package main;

import main.kz.platonus.task4.dao.MessageDAOImpl;
import main.kz.platonus.task4.entity.Message;
import main.kz.platonus.task4.service.MessageService;

public class Main {
    public static void main(String[] args) {
        MessageService service = new MessageService(new MessageDAOImpl());
        for (Message msg : service.getAllMessages())
            System.out.println(msg);

        System.out.println();

        service.deleteMessage(1);
        for (Message msg : service.getAllMessages())
            System.out.println(msg);

        service.addMessage(new Message("sojdf","sjlkdfj","jsidfu"));
        service.addMessage(new Message("sojdf","sjlkdfj","jsidfu"));
        service.addMessage(new Message("sojdf","sjlkdfj","jsidfu"));
        service.addMessage(new Message("sojdf","sjlkdfj","jsidfu"));
        service.addMessage(new Message("sojdf","sjlkdfj","jsidfu"));

        System.out.println();

        for (Message msg : service.getAllMessages())
            System.out.println(msg);

    }
}
