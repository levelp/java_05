<!-- doc.py -->
Java8: реализация по-умолчанию (default для интерфейсов)
[src/main/java/defaultimpl/Shape.java](src/main/java/defaultimpl/Shape.java)

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

[src/main/java/lambda/LambdaDemo.java](src/main/java/lambda/LambdaDemo.java)

Ищем куда поставить новый элемент
Мы идём налево если новый элемент меньше текущего
Иначе (новый элемент => текущему) идём направо
[src/main/java/lambda_tree/SearchTree.java](src/main/java/lambda_tree/SearchTree.java)

2
/   \
1    5
[src/test/java/lambda_tree/SearchTreeTest.java](src/test/java/lambda_tree/SearchTreeTest.java)

