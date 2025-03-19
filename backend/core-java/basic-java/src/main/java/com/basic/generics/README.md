# Java Generics 

## Overview
Java Generics allow for type safety and reusability of code by enabling parameterized types. This project demonstrates the use of generics through a `Box<T>` class and a generic method to print arrays.

## Classes and Implementation

### 1. `Box<T>` Class
The `Box<T>` class is a simple generic class that can hold objects of any type `T`.

#### Implementation:
```java
package com.basic.generics;
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<String> boxStr = new Box<>();
        boxStr.set("Test String");
        System.out.println(boxStr.get());

        Box<Integer> boxInt = new Box<>();
        boxInt.set(1);
        System.out.println(boxInt.get().toString());
    }
}
```

#### Explanation:
- The class is parameterized with a type `T`.
- The `set(T t)` method assigns a value to the `t` variable.
- The `get()` method returns the stored value.
- The `main` method demonstrates creating instances of `Box<String>` and `Box<Integer>`.

### 2. `GenMethod` Class
The `GenMethod` class contains a generic method to print an array of any type.

#### Implementation:
```java
package com.basic.generics;

public class GenMethod {
    public <T> void printArray(T[] t){
        for(T item: t){
            System.out.println(item);
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        GenMethod gm = new GenMethod();
        gm.printArray(intArray);
        gm.printArray(doubleArray);
        gm.printArray(charArray);
    }
}
```

#### Explanation:
- The `<T>` in `printArray(T[] t)` signifies a generic method.
- The method prints each element of the given array.
- The `main` method demonstrates usage with different types: `Integer`, `Double`, and `Character`.

## Benefits of Java Generics
1. **Type Safety**: Prevents `ClassCastException` by enforcing type at compile-time.
2. **Code Reusability**: Allows a single implementation to work with multiple data types.
3. **Eliminates Type Casting**: No need to explicitly cast objects.

## How to Run the Program
1. Compile the Java files:
   ```sh
   javac com/basic/generics/*.java
   ```
2. Run the programs:
   ```sh
   java com.basic.generics.Box
   java com.basic.generics.GenMethod
   ```

## Conclusion
This project demonstrates the power of Java Generics through a simple generic class (`Box<T>`) and a generic method (`printArray(T[])`). Generics enhance code flexibility while maintaining type safety.

