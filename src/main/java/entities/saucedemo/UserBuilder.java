package entities.saucedemo;

public class UserBuilder {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private final UserBuilder userBuilder;
        public Builder withUsername(String username){
            userBuilder.username = username;
            return this;
        }
        public Builder withPassword(String password){
            userBuilder.password = password;
            return this;
        }

        public Builder() {
            this.userBuilder = new UserBuilder();
        }
        public UserBuilder build(){
            return userBuilder;
        }
    }

    @Override
    public String toString() {
        return "UserBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
