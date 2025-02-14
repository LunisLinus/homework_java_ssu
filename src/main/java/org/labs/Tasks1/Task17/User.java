package org.labs.Tasks1.Task17;

public class User {
    @NotNull
    private final String name;

    @MaxLength(10)
    private final String username;

    @Min(18)
    @Range(min = 18, max = 65)
    private final int age;

    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
