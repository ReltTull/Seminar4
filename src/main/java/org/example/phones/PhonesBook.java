package org.example.phones;

import java.util.ArrayList;
import java.util.List;

// to do: добавить простое логгирование во внешний файл, записывая туда историю операций со списком

public class PhonesBook {
    List<Employee> employees;

    public PhonesBook(List<Employee> employees) {
        this.employees = employees;
    }

    public void showEmployeesNames() {
        for (Employee e: employees) {
            System.out.println(e.getName());
        }
    }

    /**
     * ищет сотрудника по стажу (может быть список)
     * @param exp искомый стаж
     * @return
     */
    public List<Employee> getEmployeesByExp(int exp) {
        List<Employee> result = new ArrayList<>();
        for (Employee e: employees) {
            if (e.getWorkExperience() == exp) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * выводит номер телефона сотрудника по имени (может быть список)
     * @param name имя, чей (чьи) номера выводятся
     */
    public void getPhonesByName(String name) {
        for (Employee e: employees) {
            if (e.getName() == name) {
                System.out.println(e.getPhoneNumber());
            }
        }
    }

    /**
     * ищет сотрудника по табельному номеру, при отстутствии соответствий возвращает null
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id) {
        for (Employee e: employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    /**
     * добавление нового сотрудника в справочник сотрудников
     * @param rookie
     */
    public void addNewEmployee(Employee rookie) {
        employees.add(rookie);
    }
}
