package utils;

import com.github.javafaker.Faker;

public class GenerateDateHelper {
    private static final Faker fake = new Faker();
    private static final String REGEXP_PRODUCT_CODE = "[0-9]{6}";

    /**
     * Метод для получения случайного LastName
     */
    public static String getRandomLastName() {
        return fake.name().lastName();
    }

    /**
     * Метод для получения случайного FirstName
     */
    public static String getRandomFirstName() {
        return fake.name().firstName();
    }

    /**
     * Метод для получения случайного ProductCode
     */
    public static String getRandomProductCode(){
        return fake.regexify(REGEXP_PRODUCT_CODE);
    }
}
