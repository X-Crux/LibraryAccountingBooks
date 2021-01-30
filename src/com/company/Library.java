package com.company;

import java.util.*;

public class Library {
    private Map<String, Integer> visitors = new HashMap<>();
    private Map<String, List> allVisitors = new HashMap<>();

    // метод для вывода на экран читателей, у которых наибольшее кол-во книг
    public void findMaxReader(){
        int maxValue = Collections.max(visitors.values());
        System.out.println("\nМаксимальное количество книг у следующих читателей:");

        for (Map.Entry<String, Integer> entry : visitors.entrySet()){
            if (maxValue == entry.getValue()){
                System.out.println("- Фамилия " + entry.getKey() + ", книг " + entry.getValue() + "шт.");
            }
        }
    }

    // метод для сравнения строк не зависимо от регистра букв
    public boolean findReaderByTitleBook(String text, String title){
        if (title.toLowerCase().contains(text.toLowerCase())){
            return true;
        } else {
            return false;
        }
    }

    public void setVisitors(String lastname, int bookValues, List list){
        visitors.put(lastname, bookValues);
        allVisitors.put(lastname, list);
    }

    // метод для вывода всех читателей и списка книг
    public void getAllVisitors(){
        System.out.println("Держатели книг");
        for (Map.Entry<String, List> entry : allVisitors.entrySet()){
            System.out.println("- Читатель: " + entry.getKey() + "; книги: " + entry.getValue());
        }
    }

    public Map<String, List> getAllForSearch(){
        return allVisitors;
    }
}
