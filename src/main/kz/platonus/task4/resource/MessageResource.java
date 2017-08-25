package main.kz.platonus.task4.resource;

import main.kz.platonus.task4.dao.MessageDAOImpl;
import main.kz.platonus.task4.entity.Message;
import main.kz.platonus.task4.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService(new MessageDAOImpl());

    @GET
    public Collection<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @POST
    public Message addNewMessage(Message message){
        return messageService.addMessage(message);
    }

    @DELETE
    @Path("/{id}")
    public void deleteMessage(@PathParam("id") int id){
        messageService.deleteMessage(id);
    }

    @PUT
    public Message updateMessage(Message message){
        return messageService.updateMessage(message);
    }

}
