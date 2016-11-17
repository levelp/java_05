<!-- doc.py -->
﻿Тонкости Java. Ввод/вывод. Параллельное выполнение
==================================================

[![Build Status](https://travis-ci.org/levelp/java_05.svg?branch=master)](https://travis-ci.org/levelp/java_05)
[![Coverage Status](https://coveralls.io/repos/github/levelp/java_05/badge.svg?branch=master)](https://coveralls.io/github/levelp/java_05?branch=master)

Операторы и структура кода. Исключения
--------------------------------------

Исключения
----------

Маленькие хитрости Java. StringBuilder
--------------------------------------
Тест производительности.

Файловая система. Ввод-вывод
----------------------------
File
Scanner

Начало реализации DAO - хранение в файлах
-----------------------------------------

Модульное тестирование JUnit 4 - разобрали


Работа с PostgreSQL
-------------------


SELECT
------

``` SQL

```

INSERT
------
``` SQL

```


UPDATE
------
``` SQL

```


DELETE
------
``` SQL

```


CREATE TABLE
------------
``` SQL

```

Литература
----------
* Пакет java.io
* Потоки выполнения. Синхронизация.

Исключения
----------

* RuntimeException
* Exception

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

[01_Exceptions/src/main/java/MyException.java](01_Exceptions/src/main/java/MyException.java)

....
....
[01_Exceptions/src/test/java/Exceptions.java](01_Exceptions/src/test/java/Exceptions.java)

Демонстрация работы методов StringBuilder: append, insert, delete
``` java
        StringBuilder s = new StringBuilder();

        s.append("boolean: ");
        s.append(true);
        System.out.println(s);
        assertEquals("boolean: true", s.toString());

        s.append("  double: ");
        s.append(1.0);
        System.out.println(s);
        assertEquals("boolean: true  double: 1.0", s.toString());

        // Вставляем подстроку в позицию 13
        s.insert(13, ",");
        System.out.println(s);
        assertEquals("boolean: true,  double: 1.0", s.toString());

        // Удаляем кусок
        s.delete(0, 9);
        System.out.println(s);
        assertEquals("true,  double: 1.0", s.toString());

        s = new StringBuilder();

        // Цепочка действий
        s.append("boolean: ")
                .append(true)
                .append(" double: ")
                .append(1.2)
                .insert(13, ",");
        System.out.println(s);
        assertEquals("boolean: true, double: 1.2", s.toString());

        s.append("  "); // Отступ
        Point point = new Point(2, 3);
        s.append(point);
        assertEquals("boolean: true, double: 1.2  Point{x=2.0, y=3.0}", s.toString());
```

[02_StringBuilder/src/test/java/StringBuilderTest.java](02_StringBuilder/src/test/java/StringBuilderTest.java)

Внутренние (вложенные) классы Java
==================================

Внутри классов Java можно объявять вложенные (внутренние классы).

Они бывают 3-х видов:
* Статический внутренний класс (с ключевым словом static)
* Внутренние классы - объявляются внутри основного класса (без слова static)
* Анонимные (безымянные) классы - объявляются внутри методов основного класса
[05_JavaInnerClasses/src/main/java/OuterClass.java](05_JavaInnerClasses/src/main/java/OuterClass.java)

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

[05_JavaInnerClasses/src/test/java/InnerClassTest.java](05_JavaInnerClasses/src/test/java/InnerClassTest.java)

Java8: реализация по-умолчанию (default для интерфейсов)
[09_Java8/src/main/java/defaultimpl/Shape.java](09_Java8/src/main/java/defaultimpl/Shape.java)

Java8: Лямбда-выражения
-----------------------
``` java
        Operation multiply = new Operation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };
        out.println("Sum: " + map(ints, multiply));

        Operation op = (x, y) -> x + y;
        out.println("Sum: " + map(ints, op));
        out.println("Mul: " + map(ints, (x, y) -> x * y));
        out.println("Max: " + map(ints, (x, y) -> (x > y) ? x : y));
        out.println("Min: " + map(ints, (x, y) -> (x < y) ? x : y));
        out.println("Max (Math::max): " + map(ints, Math::max));
        out.println("Mul2: " + map(ints, LambdaDemo::mul));
```

[09_Java8/src/main/java/lambda/LambdaDemo.java](09_Java8/src/main/java/lambda/LambdaDemo.java)

``` java
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        // Добавляем аттрибут ${message} для hello.jsp
        model.addAttribute("message", "Добро пожаловать на наш сайт!");
        model.addAttribute("a", 2);
        model.addAttribute("b", 3);
        return "hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model,
                      @RequestParam("a") int a,
                      @RequestParam("b") int b) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", a + b);
        return "add";
    }

    /**
     * http://localhost:8080/table - выведется таблица умножения
     * http://localhost:8080/table?size=5 - задаём размер
     */
    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String printMulTable(Model model, @RequestParam(value = "size", required = false) Integer size) {
        model.addAttribute("html", "This <b>is</b> <strike>HTML</strike> from controller!");
        // Размер таблицы по-умолчанию (значение по-умолчанию)
        if (size == null) {
            size = 10;
        }
        model.addAttribute("size", size);
        return "table";
    }

    /**
     * Вывод таблицы умножения
     * http://localhost:8080/table - выведется таблица умножения
     * size - размер таблицы
     */
    @RequestMapping(value = "/table/{size}", method = RequestMethod.GET)
    public String printMulTable2(Model model,
                                 @PathVariable("size") Integer size) {
        model.addAttribute("html", "size = " + size);
        model.addAttribute("size", size);
        return "table";
    }

    @RequestMapping(value = "/table/{op}/{size}", method = RequestMethod.GET)
    public String printOpTable(Model model,
                               @PathVariable("op") String op,
                               @PathVariable("size") Integer size) {
        model.addAttribute("html", "size = " + size);
        model.addAttribute("size", size);
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = i + 1;
                int y = j + 1;
                switch (op) {
                    case "sum":
                        result[i][j] = x + y;
                        break;
                    case "sub":
                        result[i][j] = x - y;
                        break;
                    case "mul":
                        result[i][j] = x * y;
                        break;
                }
            }
        }
        model.addAttribute("result", result);
        return "any_table";
    }

    /**
     * Вывод списка: Питерский метрополитен
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        List<String> list = new ArrayList<String>();
        list.add("1. Красная - Кировско-Выборгская");
        list.add("2. Синяя");
        list.add("3. Зелёная");
        list.add("4. Оранжевая");
        list.add("5. Фиолетовая");

        // "list" - имя .jsp страницы => list.jsp
        ModelAndView model = new ModelAndView("list");
        model.addObject("lists", list);

        return model;
    }
}
```

[SpringMVC/src/main/java/ru/levelp/mvc/controller/HelloController.java](SpringMVC/src/main/java/ru/levelp/mvc/controller/HelloController.java)

Домашнее задание
================

Проект: https://github.com/levelp/WebInterface

Сделать вывод всех сообщений об ошибках.
Вывод процесса решения уравнения в формате
HTML.

http://htmlbook.ru - справочник по HTML.


