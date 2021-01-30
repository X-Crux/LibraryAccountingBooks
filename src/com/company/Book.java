package com.company;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String authorName;
    private String bookName;
    private List<String> list = new ArrayList<>();

    public void setAuthorName(String authorNameV){
        authorName = authorNameV;
    }

    public void setBookName(String bookNameV){
        bookName = bookNameV;
    }

    public void setList(String title){
        list.add(title);
    }

    public String getAuthorName(){
        return authorName;
    }

    public String getBookName(){
        return bookName;
    }

    public List<String> getList(){
        return list;
    }
}
