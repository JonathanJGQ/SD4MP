package br.ufc.dc.sd4mp.mynotes;

public class Note {

    private int id;

    private String title;

    private String content;

    private String data;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String toString() {
        return "(" + id + ") " + title + ": " + content + " - " + data;
    }
}