package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;

public class RegistrationRandomUtils {
    public Faker faker = new Faker(new Locale("en"));
    // Данные в начале класса (без final)
    private String[] genders = {"Male", "Female", "Other"};
    private String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private String[] subjects = {"Arts", "Maths", "Physics", "Chemistry", "Biology",
            "History", "English", "Computer Science", "Economics"};
    private String[] hobbies = {"Sports", "Reading", "Music"};
    private String pictureName = "Images.jfif";

    // Мапа для штатов и городов
    private static HashMap<String, String[]> statesAndCities = new HashMap<>();

    // Устанавливаем ключ-значение в мапу statesAndSities
    static {
        statesAndCities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        statesAndCities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCities.put("Haryana", new String[]{"Karnal", "Panipat"});
        statesAndCities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    // Персональные данные и методы
    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generateGender() {
        return faker.options().option(genders);
    }

    public String generatePhoneNumber() {
        return faker.numerify("##########");
    }

    public String generateDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String generateMonth() {
        return faker.options().option(months);
    }

    public String generateYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2025));
    }

    public String generateSubjects() {
        return faker.options().option(subjects);
    }

    public String generateHobbies() {
        return faker.options().option(hobbies);
    }

    public String generatePicture() {
        return pictureName;
    }

    public String generateAddress() {
        return faker.address().fullAddress();
    }

    // Локация. Генерируем связанные штат и город (БЕЗ ИНДЕКСОВ!)
    public String generateState() {
        return faker.options().option(statesAndCities.keySet().toArray(new String[0]));

    }

    public String generateCity(String state) {
        return faker.options().option(statesAndCities.get(state));

    }
}


