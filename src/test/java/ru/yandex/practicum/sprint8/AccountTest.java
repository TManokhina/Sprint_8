package ru.yandex.practicum.sprint8;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    Faker faker = new Faker();

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает true, если передать в него валидную строку")
    public void checkMaskNameToEmboss() {
        Account account = new Account(faker.name().firstName() + " " + faker.name().lastName());
        Assert.assertTrue("Строка не соответствует маске", account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает false, если передать в него строку без пробелов")
    public void checkNameToEmbossWithoutBlank() {
        Account account = new Account(faker.name().firstName());
        Assert.assertFalse("Метод checkNameToEmboss посчитал строку без пробела валидной", account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает false, если передать в него строку с двумя пробелами")
    public void checkNameToEmbossWithTwoBlank() {
        Account account = new Account(faker.name().firstName() + "  " + faker.name().lastName());
        Assert.assertFalse("Метод checkNameToEmboss посчитал строку с двумя пробелами валидной",
                account.checkNameToEmboss());
    }


    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает false, если передать в него строку с пробелом в " +
            "начале строки")
    public void checkNameToEmbossWithBlankBeforeString() {
        Account account = new Account(" " + faker.name().firstName() + faker.name().lastName());
        Assert.assertFalse("Метод checkNameToEmboss посчитал строку с пробелом в начале строки валидной",
                account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает false, если передать в него строку с пробелом в " +
            "конце строки")
    public void checkNameToEmbossWithBlankAfterString() {
        Account account = new Account(" " + faker.name().firstName() + faker.name().lastName());
        Assert.assertFalse("Метод checkNameToEmboss посчитал строку с пробелом в начале строки валидной",
                account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает true, если передать в него 19-символьную строку " +
            "(19-верхняя граница для строки которую может принять checkNameToEmboss)")
    public void checkNameToEmbossMaxValidLength() {
        Account account = new Account(faker.bothify("???????") + " " + faker.bothify("?????????"));
        Assert.assertTrue("Метод checkNameToEmboss посчитал строку с пробелом в начале строки валидной",
                account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает true, если передать в него 3-символьную строку " +
            "(3-нижняя граница для строки которую может принять checkNameToEmboss)")
    public void checkNameToEmbossMinValidLength() {
        Account account = new Account(faker.bothify("?") + " " + faker.bothify("?"));
        Assert.assertTrue("Метод checkNameToEmboss посчитал строку с пробелом в начале строки валидной",
                account.checkNameToEmboss());
    }

    @Test
    @Description("Проверка что метод checkNameToEmboss возвращает false, если передать в него 20-символьную строку " +
            "(19-верхняя граница для строки которую может принять checkNameToEmboss)")
    public void checkNameToEmbossWithExceedingLength() {
        Account account = new Account(faker.bothify("????????????") + " " + faker.bothify("???????"));
        Assert.assertFalse("Метод checkNameToEmboss посчитал строку с пробелом в начале строки валидной",
                account.checkNameToEmboss());
    }


}