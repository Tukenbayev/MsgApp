angular.module("MessageApp",['ui.bootstrap'])
    .constant("baseUrl", "http://localhost:8080/rest/messages/")
    .controller("MsgCtrl",function ($scope,$http,baseUrl) {

        var $dialog  = $('#Modal');
        $scope.currentPage = 1;
        $scope.itemsPerPage = 10;
        $scope.maxSize = 10;
        
        $scope.refresh = function () {
            $http.get(baseUrl).success(function (data) {
               $scope.messages = data;
               $scope.totalItems = $scope.messages.length;
            });
        };

        $scope.refresh();

        $scope.delete = function (message) {
            $http.delete(baseUrl+message.id).success(function () {
                $scope.messages.splice($scope.messages.indexOf(message),1);
            });
        };

        $scope.saveMessage = function (message) {
            if (angular.isDefined(message.id)){
                $scope.update(message);
            }else{
                $scope.create(message);

            }
        };

        $scope.create = function(message){
            $http.post(baseUrl,message).success(function (data) {
                $dialog.modal("hide");
                $scope.refresh();
            });
        };

        $scope.update = function(message){
            $http.put(baseUrl,message).success(function (modifiedMsg) {
                for (var i = 0; i < $scope.messages.length; i++){
                   if ($scope.messages[i].id == modifiedMsg.id){
                       $scope.messages[i] = modifiedMsg;
                       break;
                   }
                }
                $dialog.modal("hide");
            });
        };


        $scope.editOrCreate = function (message) {
            $dialog.modal();
            $scope.currentMsg = message ? angular.copy(message) : {};
        };

        $scope.cancel = function () {
          $dialog.modal("hide");
          $scope.currentMsg = {};
        };



    });
