package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class LibraryVisitors {
    private String lastname;
    private Map<String, String> bookMap = new HashMap<>();

    // метод для вывода списка книг у читателей
    public abstract void printBooks();

    public void setLastname(String lastnameV){
        lastname = lastnameV;
    }

    public void setBookMap(String authorName, String bookName){
        bookMap.put(authorName, bookName);
    }

    public String getLastname(){
        return lastname;
    }

    public Map<String, String> getBookMap() {
        return bookMap;
    }


}
