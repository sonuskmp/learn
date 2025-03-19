# Enum in Java

## Introduction
In Java, an `enum` (short for enumeration) is a special data type that defines a collection of constants. Enums are used to represent fixed sets of values, such as days of the week, directions, or categories.

## Features of Enum:
- Enums are implicitly `final` and `static`.
- Each constant in an enum is an instance of the enum type.
- Enums can have fields, constructors, and methods.
- They provide better type safety compared to constant variables.

---

## Understanding the Code

### 1. `Category.java`
This file defines an `enum` named `Category`, which represents different animal categories.

```java
package com.basic.enums;

public enum Category {
    CAT("cat"),
    DOG("dog"),
    LION("lion"),
    ELEPHANT("elephant"),
    MONKEY("monkey"),
    DONKEY("donkey");

    private String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
```

### Explanation:
- The `Category` enum defines six constants: `CAT`, `DOG`, `LION`, `ELEPHANT`, `MONKEY`, and `DONKEY`.
- Each constant has an associated string value (e.g., `DOG("dog")`).
- A constructor is defined and initialized the `name` field.
- The `toString()` method attempts to return `this.name`.

#### Fix for the Constructor Issue:
Modify the constructor to initialize the `name` field:
```java
Category(String name) {
    this.name = name;
}
```

---

### 2. `EnumApp.java`
This file contains the `main` method that demonstrates how to use the `Category` enum.

```java
package com.basic.enums;

public class EnumApp {
    public static void main(String[] args) {
        String animalName = Category.DOG.name();
        System.out.println(animalName);
    }
}
```

### Explanation:
- The `main` method retrieves the name of the `DOG` constant using `Category.DOG.name()`.
- The `name()` method is a built-in method of `enum` that returns the exact name of the constant (e.g., `DOG`).
- The output will be:
  ```
  DOG
  ```

#### Alternative Approach Using `toString()`:
If the constructor issue is fixed, you can use `toString()` instead:
```java
String animalName = Category.DOG.toString();
System.out.println(animalName);
```
This will print:
```
dog
```
---

## Benefits of Using Enum
- Enums provide type safety.
- They improve code readability and maintainability.
- Enums can have methods and constructors for additional functionality.
- They help in defining a fixed set of constants clearly and efficiently.

## Conclusion
This project demonstrates the use of enums in Java. The `Category` enum represents different animal categories, and `EnumApp` demonstrates how to access enum constants.

