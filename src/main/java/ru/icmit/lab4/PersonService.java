package ru.icmit.lab4;


import ru.icmit.lab4.domain.Person;

import java.util.List;

/**
 *  Класс сервисных методов для работы с данными
 */
public class PersonService {

    /**
     * Поиск по имени
     */
    public static Person findPersonByName(List<Person> persons, String searchName) {
        Person result = null;

        for (Person person : persons) {
            if (person.getFirstName().equals(searchName)) {
                result = person;
            }
        }

        return result;
    }

}