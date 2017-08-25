package main.kz.platonus.task4.reader;

import main.kz.platonus.task4.entity.Message;

import java.io.*;
import java.util.*;

public class MessageReader {

    public Map<Integer,Message> getAllMessages(String fileName) {

        Map<Integer,Message> messages = new TreeMap<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
                "UTF-8"))) {


            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.equals("")) {
                    int id;
                    String ru, kz ,en;
                    id = Integer.parseInt(line.split("\\|")[0]);
                    ru = line.split("\\|")[1];
                    kz = line.split("\\|")[2];
                    en = line.split("\\|")[3];
                    messages.put(id,new Message(id, ru, kz, en.substring(0,en.length()-1)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages;
    }

}
