package ru.icmit.lab2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.icmit.lab2.domain.Shop;
import ru.icmit.lab2.domain.Person;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LoadDB {

    public static Shop load() throws IOException {
        Shop shop = null;
        String shopStr = "";
        File file = new File("shop.json");

        if (file.exists()) {
            shopStr = new String(Files.readAllBytes(file.toPath()));
        }

        shop = new Gson().fromJson(shopStr, Shop.class);

        return shop;
    }

    /**
     * Пример чтения из файла массива JSON объектов
     */
    public static List<Person> loadPersonList() throws IOException, JsonSyntaxException {
        String pStr = "";
        File file = new File("persons.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File persons.json not found!");
        }

        Gson gson = new Gson();

        Person[] plst = gson.fromJson(pStr, Person[].class);

        return Arrays.asList(plst);
    }
}