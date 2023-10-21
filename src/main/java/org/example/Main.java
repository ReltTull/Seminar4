package org.example;


import org.example.phones.Employee;
import org.example.phones.PhonesBook;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
//        List<Employee> employees = Arrays.asList(new Employee("8 911 211 34 12", "Alex", 20),
//                new Employee("8 911 211 34 25", "Dallas", 15));
//
//        PhonesBook phonesBook = new PhonesBook(employees);
//        phonesBook.showEmployeesNames();

        FIleLoader fIleLoader = new FIleLoader("https://sun9-6.userapi.com/impg/P9oij_d5p1_jxE3bdGH843hGMOn_Bbs48JJnUw/oXtIP-hgchU.jpg?size=866x1125&quality=95&sign=6259a8b07d07a4f30f891857ef21d1d6&type=album",
                "D:/GeekBrains/", "test");
        fIleLoader.downloadFile(3);

    }
}