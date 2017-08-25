package main.kz.platonus.task4.dao;

import main.kz.platonus.task4.entity.Message;
import main.kz.platonus.task4.reader.MessageReader;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public class MessageDAOImpl implements MessageDAO {

    private static final String INPUT_FILE = "D:"+ File.separator+"new-messages.txt";
    private static Map<Integer,Message> messages = new MessageReader().getAllMessages(INPUT_FILE);

    public Message addMessage(Message message) {
        int id = generateFreeId();
        message.setId(id);
        messages.put(id,message);
        return message;
    }

    public Message updateMessage(Message message) {
        messages.put(message.getId(),message);
        return message;
    }

    public void deleteMessage(int id) {
        messages.remove(id);
    }

    public Collection<Message> getAllMessages() {
        return  messages.values();
    }

    private synchronized int generateFreeId(){
        for (int i = 1; i<2000000000;i++){
            if (!messages.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }
}
