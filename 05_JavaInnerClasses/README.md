<!-- doc.py -->
Внутренние (вложенные) классы Java
==================================

Внутри классов Java можно объявять вложенные (внутренние классы).

Они бывают 3-х видов:
* Статический внутренний класс (с ключевым словом static)
* Внутренние классы - объявляются внутри основного класса (без слова static)
* Анонимные (безымянные) классы - объявляются внутри методов основного класса
[src/main/java/OuterClass.java](src/main/java/OuterClass.java)

``` java
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod() {
                Assert.assertEquals(1, i);
                // i++; // Невозможно сделать
                System.out.println("InnerClassTest.myMethod");
            }
        };

        myInterface.myMethod();
```

[src/test/java/InnerClassTest.java](src/test/java/InnerClassTest.java)

