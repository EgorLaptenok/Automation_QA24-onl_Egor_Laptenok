package entities.saucedemo;

import lombok.Builder;
import lombok.Data;


@Data
@Builder(setterPrefix = "with")
public class UserBuilder {
    private String username;
    private String password;
}
