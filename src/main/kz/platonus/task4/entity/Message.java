package main.kz.platonus.task4.entity;

public class Message implements Comparable<Message> {

    private int id;
    private String message_ru;
    private String message_kz;
    private String message_en;

    public Message(int id, String message_ru, String message_kz, String message_en) {
        this.id = id;
        this.message_ru = message_ru;
        this.message_kz = message_kz;
        this.message_en = message_en;
    }

    public Message(int id) {
        this.id = id;
    }
    public Message(){}

    public Message(String message_ru, String message_kz, String message_en) {
        this.message_ru = message_ru;
        this.message_kz = message_kz;
        this.message_en = message_en;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage_ru() {
        return message_ru;
    }

    public void setMessage_ru(String message_ru) {
        this.message_ru = message_ru;
    }

    public String getMessage_kz() {
        return message_kz;
    }

    public void setMessage_kz(String message_kz) {
        this.message_kz = message_kz;
    }

    public String getMessage_en() {
        return message_en;
    }

    public void setMessage_en(String message_en) {
        this.message_en = message_en;
    }



    @Override
    public String toString() {
        return new StringBuilder(String.valueOf(id)).append('|').append(message_ru).append('|').append(message_kz)
                .append('|').append(message_en).toString();
    }

    public int compareTo(Message o) {
        return id - o.getId();
    }

    public boolean hasContent(){
        return message_en != null;
    }
}
