<!-- doc.py -->
Объявление своего класса-исключения
``` java
public class MyException extends Exception {
    // Могут быть поля-значения
    final double d;
    final String name;
    final int i;

    // Конструктор
    public MyException(String name, int i, double d) {
        super();
        this.name = name;
        this.i = i;
        this.d = d;
    }
}
```

[src/main/java/MyException.java](src/main/java/MyException.java)

....
...
throw ex;
ex.printStackTrace();
....
...
[src/test/java/Exceptions.java](src/test/java/Exceptions.java)

