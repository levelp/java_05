<!-- doc.py -->
﻿Тонкости Java. Ввод/вывод. Параллельное выполнение
==================================================

[![Build Status](https://travis-ci.org/levelp/java_05.svg?branch=master)](https://travis-ci.org/levelp/java_05)
[![Coverage Status](https://coveralls.io/repos/github/levelp/java_05/badge.svg?branch=master)](https://coveralls.io/github/levelp/java_05?branch=master)

Начало реализации DAO - хранение в файлах
-----------------------------------------

Модульное тестирование JUnit 4 - разобрали


Базы Данных. Работа с SQL (MySQL / PostgreSQL)
==============================================


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

Файловая система. Ввод-вывод File/Scanner/FileReader
----------------------------------------------------

XMLDecoder - из текстового файла считывает XML
и заполняет поля объектов
Запись (сериализация) любого объекта в формат XML
[03_SaveToFile/src/main/java/dao/XMLFile.java](03_SaveToFile/src/main/java/dao/XMLFile.java)

Обновляем
[03_SaveToFile/src/test/java/FileStorageTest.java](03_SaveToFile/src/test/java/FileStorageTest.java)

f1.setFinalField(343);
Считываем обратно
[03_SaveToFile/src/test/java/MyClassXMLTest.java](03_SaveToFile/src/test/java/MyClassXMLTest.java)

Запись в текстовый файл
Чтение из текстового файла
Считываем элементы массива
[03_SaveToFile/src/test/java/TextFileSaveLoad.java](03_SaveToFile/src/test/java/TextFileSaveLoad.java)

TODO: завершить пример
[03_SaveToFile/src/test/java/UserSaveLoadTest.java](03_SaveToFile/src/test/java/UserSaveLoadTest.java)

Используйте: OutputStreamWriter
Через Reflection API получаем класс
Через Reflection API получаем список полей
Получаем значение поля
Закрываем файл
Имя класса
Загружаем класс по имени
Создаём экземпляр класса
Pattern hh = Pattern.compile("(\\w+):");
Пропускаем "="
[04_ProblemFileWriteRead/src/main/java/ObjectSaveLoad.java](04_ProblemFileWriteRead/src/main/java/ObjectSaveLoad.java)

Используйте: OutputStreamWriter
[04_ProblemFileWriteRead/src/main/java/TextSaveLoad.java](04_ProblemFileWriteRead/src/main/java/TextSaveLoad.java)

Внутренние (вложенные) классы Java
----------------------------------

Внутри классов Java можно объявять вложенные (внутренние классы).

Они бывают 3-х видов:
* Статический внутренний класс (с ключевым словом static)
* Внутренние классы - объявляются внутри основного класса (без слова static)
* Анонимные (безымянные) классы - объявляются внутри методов основного класса
Константа в локальном классе
static int staticVar = 100; // Ошибка компиляции
Не можем менять локальных переменных
value++;
notFinal++; // Ошибка компиляции
Эта строка синтаксически корректна
Можно создавать сколько угодно экземпляров локального класса
но только внутри данного метода
При определении анонимного класса применен полиморфизм - переменная listener
содержит экземпляр анонимного класса, реализующего существующий
интерфейс ActionListener
Начало анонимного локального класса >>>
<< Окончание
Не можем обращаться к обычным полям класса
int getOuterField() {
return OuterClass.this.outerField; // Эта строка кода - ошибка компиляции
}
LocalInnerClass inner; // Ошибка компиляции: локальные классы тут не видны
static void xx(){ // Ошибка
}
[05_JavaInnerClasses/src/main/java/OuterClass.java](05_JavaInnerClasses/src/main/java/OuterClass.java)

Помещаем новый элемент на вершину
Запоминаем значение
Переводим вершину стека на следующий элемент
Возвращаем значение
[05_JavaInnerClasses/src/main/java/Stack.java](05_JavaInnerClasses/src/main/java/Stack.java)

Анонимный класс
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

Ищем куда поставить новый элемент
Мы идём налево если новый элемент меньше текущего
Иначе (новый элемент => текущему) идём направо
[09_Java8/src/main/java/lambda_tree/SearchTree.java](09_Java8/src/main/java/lambda_tree/SearchTree.java)

2
/   \
1    5
[09_Java8/src/test/java/lambda_tree/SearchTreeTest.java](09_Java8/src/test/java/lambda_tree/SearchTreeTest.java)

Соединение с БД
Создаём SQL-оператор
Создаем таблицу
Получаем результаты
[JDBC_Demo/src/test/java/jdbcdemo/JDBCDemo.java](JDBC_Demo/src/test/java/jdbcdemo/JDBCDemo.java)

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

resume.setName("Нужное нам резюме: " + query);
[SpringMVC/src/main/java/ru/levelp/mvc/controller/ResumeController.java](SpringMVC/src/main/java/ru/levelp/mvc/controller/ResumeController.java)

Сравнение с игнорированием
[SpringMVC/src/main/java/ru/levelp/mvc/storage/FileStorage.java](SpringMVC/src/main/java/ru/levelp/mvc/storage/FileStorage.java)

Создаём запрос
Набор результатов
Пока есть результаты
class Contact {
int id;
String name;
String surname;
}
query.executeUpdate("UPDATE contact SET ... WHERE ...");
query.executeUpdate("DELETE FROM contact WHERE ...");
query.executeUpdate("INSERT INTO contact VALUES(...)")
query.execute("CREATE TABLE ...");
[SpringMVC/src/test/java/jdbc/PostgresJDBC.java](SpringMVC/src/test/java/jdbc/PostgresJDBC.java)

@Test
public void
[SpringMVC/src/test/java/ru/levelp/mvc/UserTest.java](SpringMVC/src/test/java/ru/levelp/mvc/UserTest.java)


Домашнее задание
================

Создание JSP-страниц, HTML, CSS, JavaScript
-------------------------------------------
Проект: https://github.com/levelp/WebInterface

Сделать вывод всех сообщений об ошибках.
Вывод процесса решения уравнения в формате
HTML.

http://htmlbook.ru - справочник по HTML.

