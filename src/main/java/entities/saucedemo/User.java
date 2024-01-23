package entities.saucedemo;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password = "secret_sauce";
}
