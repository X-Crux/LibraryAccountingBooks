/**
 * Модель работы библиотеки. Учет держателей книг.
 *
 * Студенты и преподаватели берут в библиотеке книги.
 * Программа ведет учет книг у всех держателей.
 * Вывод списка книг показывает список книг только у студентов. У преподавателей - нет.
 * Общий вывод списка держателей и книг выводит полную текущую информацию о держателях книг
 * вместе со списком книг, которые числятся у них.
 * Программа позволяет искать читателя по названию книги.
 */
package com.company;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) {
        int command = 0;
        Library library = new Library();
        while (command != 5){
            System.out.print("\nГлавное меню программы.\n" +
                    "1. Рамдомное заполнение.\n" +
                    "2. Ручное заполнение.\n" +
                    "3. Показать читателей.\n" +
                    "4. Поиск читателей.\n" +
                    "5. Выход из программы.\n" +
                    "Введите номер выбранного меню (1-5): ");
            Scanner in = new Scanner(System.in);
            command = in.nextInt();
            String clearLine = in.nextLine(); // очистка new Line от лишнего символа после ввода Интового значения
            if (command == 1){ // в этой части программы происходит автоматическая генерация значений
                Random random = new Random();
                int authorNameId = 1000; // начальное число для формирования уникального имени автора книги
                int bookNameId = 2000; // начальное число для формирования уникального названия книги
                int lastnameId = 1000; // начальное число для формирования уникального фамилии студента
                int studentsValue = random.nextInt(30) + 1; // рамдомное кол-во студентов от 1 до 30
                int teachersValue = random.nextInt(10) + 1; // рамдомное кол-во учителей от 1 до 10

                // генерация студентов
                for (int i = 0; i < studentsValue; i++){
                    Student student = new Student();
                    lastnameId++;
                    String lastname = "Lastname" + lastnameId; // создание уникальной фамилии студента
                    student.setLastname(lastname);
                    int booksValue = random.nextInt(15) + 1; // рамдомное кол-во книг от 1 до 15
                    Book book = new Book();

                    // генерация книг
                    for (int j = 0; j < booksValue; j++){
                        authorNameId++;
                        bookNameId++;
                        String authorName = "AuthorName" + authorNameId; // создание уникального имени автора
                        String bookName = "NameOfBook" + bookNameId; // создание уникального название книги
                        book.setAuthorName(authorName);
                        book.setBookName(bookName);
                        student.setBookMap(book.getAuthorName(), book.getBookName());
                        book.setList(bookName);
                    }

                    library.setVisitors(student.getLastname(), student.getBookMap().size(), book.getList());
                    System.out.println("\nСтудент: " + student.getLastname());
                    student.printBooks();
                }

                // генерация учителей
                for (int i = 0; i < teachersValue; i++){
                    Teacher teacher = new Teacher();
                    lastnameId++;
                    String lastname = "Lastname" + lastnameId; // создание уникальной фамилии учителя
                    teacher.setLastname(lastname);
                    int booksValue = random.nextInt(15) + 1; // рамдомное кол-во книг от 1 до 15
                    Book book = new Book();

                    // генерация книг
                    for (int j = 0; j < booksValue; j++){
                        authorNameId++;
                        bookNameId++;
                        String authorName = "AuthorName" + authorNameId; // создание уникального имени автора
                        String bookName = "NameOfBook" + bookNameId; // создание уникального название книги
                        book.setAuthorName(authorName);
                        book.setBookName(bookName);
                        teacher.setBookMap(book.getAuthorName(), book.getBookName());
                        book.setList(bookName);
                    }

                    library.setVisitors(teacher.getLastname(), teacher.getBookMap().size(), book.getList());
                    System.out.println("\nУчитель: " + teacher.getLastname());
                    teacher.printBooks();
                }
                library.findMaxReader(); // вывод на экран читателей, у которых наибольшее кол-во книг
            } else if (command == 2){ // в этой части программы происходит ручной ввод значений
                System.out.print("\nВведите количество студентов: ");
                int studentsValue = in.nextInt();
                System.out.print("\nВведите количество учителей: ");
                int teachersValue = in.nextInt();
                clearLine = in.nextLine(); // очистка new Line от лишнего символа после ввода Интового значения

                // создание студентов
                for (int i = 0; i < studentsValue; i++){
                    Student student = new Student();
                    System.out.print("\nВведите фамилию студента №" + (i + 1) + ": ");
                    String lastname = in.nextLine();
                    student.setLastname(lastname);
                    System.out.print("\nВведите количество книг у студента по фамилии " + lastname + ": ");
                    int booksValue = in.nextInt();
                    clearLine = in.nextLine(); // очистка new Line от лишнего символа после ввода Интового значения
                    Book book = new Book();

                    // создание книг
                    for (int j = 0; j < booksValue; j++){
                        System.out.print("\nИмя автора книги №" + (j + 1) + ": ");
                        String authorName = in.nextLine();
                        System.out.print("\nНазвание книги №" + (j + 1) + ": ");
                        String bookName = in.nextLine();
                        book.setAuthorName(authorName);
                        book.setBookName(bookName);
                        student.setBookMap(book.getAuthorName(), book.getBookName());
                        book.setList(bookName);
                    }

                    library.setVisitors(student.getLastname(), student.getBookMap().size(), book.getList());
                    System.out.println("\nСтудент: " + student.getLastname());
                    student.printBooks();
                }

                // создание учителей
                for (int i = 0; i < teachersValue; i++){
                    Teacher teacher = new Teacher();
                    System.out.print("\nВведите фамилию учителя №" + (i + 1) + ": ");
                    String lastname = in.nextLine();
                    teacher.setLastname(lastname);
                    System.out.print("\nВведите количество книг у учителя по фамилии " + lastname + ": ");
                    int booksValue = in.nextInt();
                    clearLine = in.nextLine(); // очистка new Line от лишнего символа после ввода Интового значения
                    Book book = new Book();

                    // создание книг
                    for (int j = 0; j < booksValue; j++){
                        System.out.print("\nИмя автора книги №" + (j + 1) + ": ");
                        String authorName = in.nextLine();
                        System.out.print("\nНазвание книги №" + (j + 1) + ": ");
                        String bookName = in.nextLine();
                        book.setAuthorName(authorName);
                        book.setBookName(bookName);
                        teacher.setBookMap(book.getAuthorName(), book.getBookName());
                        book.setList(bookName);
                    }

                    library.setVisitors(teacher.getLastname(), teacher.getBookMap().size(), book.getList());
                    System.out.println("\nУчитель: " + teacher.getLastname());
                    teacher.printBooks();
                }
                library.findMaxReader(); // вывод на экран читателей, у которых наибольшее кол-во книг
            } else if (command == 3){ // в этом пункте происходит вывод всех читателей и их книги на экран
                library.getAllVisitors();
            } else if (command == 4){ // в этой части программы происходит поиск читателей по названию книги
                System.out.print("\nВведите название книги для поиска читателя: ");
                String text = in.nextLine();
                System.out.println("\nКнига есть у следующих читателей: ");

                // переборка каждой книги у читателя и вывод только тех фамилий, которые нам нужны
                for (Map.Entry<String, List> entry : library.getAllForSearch().entrySet()){
                    for (int i = 0; i < entry.getValue().size(); i++){
                        String title = valueOf(entry.getValue().get(i));
                        if (library.findReaderByTitleBook(text, title)){
                            System.out.println("- Читатель: " + entry.getKey());
                        }
                    }
                }
            } else if (command == 5) { // выход из цикла/программы
                break;
            } else { // вывод сообщения, если пользователь ввел не верную команду в меню
                System.out.print("Введите корректный номер меню.");
            }
        }
    }
}
