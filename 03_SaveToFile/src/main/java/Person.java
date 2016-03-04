import java.io.Serializable;

/**
 *
 */
public class Person {
    private String name;
    private int age;
    private final int finalField;

    public Person() {
        finalField = 15;
    }

    /**
     * Getter
     *
     * @return получаем имя
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param s новое имя
     */
    public void setName(String s) {
        name = s;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFinalField() {
        return finalField;
    }
}