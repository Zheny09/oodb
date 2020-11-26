package ru.icmit.lab3;


import ru.icmit.lab3.model.ClientAccount;
import ru.icmit.lab3.model.Shop;
import ru.icmit.lab3.model.Client;
import java.util.ArrayList;
import java.util.List;

/**
 * Пример, демонстрирующий сохранение (marshalling) объекта в XML документ
 */
public class MainSave {

    public static void main(String[] args) {

        // Создаем объект банк
        Shop shop = new Shop();

        // Создаем объекты - клиенты банка
        Client client1 = new Client("Иван","Иванов","89196855585","");
        Client client2 = new Client("Петр","Петров","","Fgd@mail.ru");

        // Добавляем объекту client1 расчетный счет
        ClientAccount account = new ClientAccount(1299876);
        List<ClientAccount> accounts = new ArrayList<>();
        accounts.add(account);
        client1.setAccounts(accounts);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        // Прикрепляем клиентов к банку
        shop.setClients(clients);

        // сохраняем объект в в XML документ
        XMLService.saveShopData(shop);
    }
}