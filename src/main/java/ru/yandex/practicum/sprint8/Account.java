package ru.yandex.practicum.sprint8;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /**
     * Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
     * Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
     */
    public boolean checkNameToEmboss() {
        return name.matches("^\\S+\\s\\S+$") && name.length() <= 19;
    }
}
