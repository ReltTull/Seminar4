package org.example;

import java.util.*;
import java.util.stream.Stream;

public class NamesCollection {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Mayeve", "Vensan", "Rachel", "Alan", "Rahil", "Vensan", "Anastatia", "Alexander",
                "Marco", "Lui", "Rachel", "Alan", "Aaron", "Ithen");
        // сортировка по алфавиту
//        Collections.sort(names);
//        for (String s:womanNames) {
//            System.out.print(s + " ");
//        }
        // сортировка по длине
//        sortByLength(names);
//        for (String s : names) {
//            System.out.print(s + " ");
//        }


//        Set<String> unicNames = Set.copyOf(names);
//        for (String s : unicNames) {
//            System.out.println(s + " ");
//        }

        deleteAContainsNames(names);
//        for (String s : names) {
//            System.out.print(s + " ");
//        }
    }


    /**
     * сортировка выбором, используется длина строки
     *
     * @param list
     */
    public static void sortByLength(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int shorterElemIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).length() < list.get(shorterElemIndex).length()) {
                    shorterElemIndex = j;
                }
            }
            String temp = list.get(shorterElemIndex);
            list.set(shorterElemIndex, list.get(i));
            list.set(i, temp);
        }
    }

    /**
     * метод определения наименьшего элемента (алфавитный порядок) в Set. Т.к. Java не допускает сортировку Set,
     * кастуем Set в List, сортируем List и вытаскиваем 0 индекс.
     *
     * @param elements
     * @return
     */
    public static String getMinimalAlphabetElement(Set<String> elements) {
        List<String> list = (List<String>) elements;
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * метод определения наибольшего элемента (по длине) в Set. Т.к. Java не допускает сортировку Set,
     * кастуем Set в List, сортируем List с помощью sortByLength и вытаскиваем последний индекс.
     *
     * @param elements
     * @return
     */
    public static String getMaximumLengthName(Set<String> elements) {
        List<String> list = (List<String>) elements;
        sortByLength(list);
        return list.get(list.size() - 1);
    }

    /**
     * метод удаления всех имён, содержащих "а". Итерируемся в лист имен, каждое переводим в массив символов и сравниваем
     * с "а" или "А". При совпадении присваивает нынешнему имени null.
     *
     * @param names
     */
    public static void deleteAContainsNames(List<String> names) {

        for (int i = 0; i < names.size(); i++) {
            char[] nameInChars = names.get(i).toCharArray();
            for (int j = 0; j < nameInChars.length; j++) {
                if (nameInChars[j] == 'a' || nameInChars[j] == 'A') {
                    names.set(i, " ");
                }
            }
        }
        for (String s : names) {
                System.out.print(s + " ");
        }
    }
}
