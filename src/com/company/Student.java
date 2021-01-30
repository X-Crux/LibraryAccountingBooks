package com.company;

import java.util.Map;

public class Student extends LibraryVisitors {
    public void printBooks(){
        System.out.println("Список книг");
        for (Map.Entry<String, String> entry : getBookMap().entrySet()){
            System.out.println("- Автор: " + entry.getKey() + "; название: " + entry.getValue());
        }
    }
}
