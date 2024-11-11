package ru.yandex.practicum.sprint8;

public class Praktikum {

    /**
     * В этом методе заложи логику работы с классом ru.yandex.practicum.sprint8.Account.
     * Нужно создать экземпляр класса ru.yandex.practicum.sprint8.Account: в качестве аргумента передать тестируемое имя
     * и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
     */
    public static void main(String[] args) {
        Account account = new Account("Тимотэй Виннер");
        account.checkNameToEmboss();
    }
}
