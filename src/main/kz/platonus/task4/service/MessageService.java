package main.kz.platonus.task4.service;

import main.kz.platonus.task4.dao.MessageDAO;
import main.kz.platonus.task4.entity.Message;

import java.util.Collection;

public class MessageService {

    private MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message addMessage(Message message){
        return messageDAO.addMessage(message);
    }

    public Message updateMessage(Message message){
        return messageDAO.updateMessage(message);
    }

    public void deleteMessage(int id){
        messageDAO.deleteMessage(id);
    }

    public Collection<Message> getAllMessages(){
        return messageDAO.getAllMessages();
    }

}
