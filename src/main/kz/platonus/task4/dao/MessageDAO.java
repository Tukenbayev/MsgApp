package main.kz.platonus.task4.dao;


import main.kz.platonus.task4.entity.Message;

import java.util.Collection;

public interface MessageDAO {

    Message addMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(int id);
    Collection<Message> getAllMessages();
}
