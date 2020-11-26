package ru.icmit.lab3;


import ru.icmit.lab3.model.Shop;
import ru.icmit.lab3.model.ShopAccount;
import ru.icmit.lab3.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Пример, демонстрирующий преобразование XML документа в объект
 */
public class MainLoad {

    public static void main(String[] args) {

        Shop shop = XMLService.loadShopFromXML();

        System.out.println(shop);
    }
}