public class User implements Comparable<User>{

    private final int age;
    private final String name;

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(this.age, user.getAge());
    }

    public static User build(int age, String name) {
        return new User(age, name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
