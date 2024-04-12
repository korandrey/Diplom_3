package site.nomoreparties.stellarburgers.utils;

import com.github.javafaker.Faker;
import lombok.Data;
import site.nomoreparties.stellarburgers.api.User;

@Data
public class DataGeneration {

    private String email;
    private String password;
    private String name;

    public DataGeneration() {
        Faker faker = new Faker();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password(6, 9);
        this.name = faker.name().firstName();
    }

    public static User generatingDataToCreateValidUser() {
        Faker faker = new Faker();
        final String email = faker.internet().emailAddress();
        final String password = faker.internet().password(6, 9);
        final String name = faker.name().firstName();
        return new User(email, password, name);
    }
}
