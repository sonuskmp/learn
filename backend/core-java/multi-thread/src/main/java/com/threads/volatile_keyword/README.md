# Java `volatile` Keyword

## Overview
The `volatile` keyword in Java is used to indicate that a variable's value will be modified by multiple threads. It ensures visibility and ordering of updates to the variable across different threads.

---

## Key Features
1. **Visibility**: Changes made to a `volatile` variable by one thread are immediately visible to all other threads.
2. **Prevents Caching**: The value is always read from and written to main memory (not from CPU registers or thread caches).
3. **Atomic Reads and Writes**: Reads and writes to a `volatile` variable are atomic, but compound operations (like `count++`) are **not** atomic.

---

## Using `volatile`
```java
public class VolatileEx {
   private static volatile boolean flag = true;
   public static void main(String[] args) {
      Thread t1 = new Thread(() -> {
         while(flag){
            //System.out.println("Thread Running.....");
         }
         System.out.println("thread stopped.");
      });

      t1.start();

      flag = false; //try changing flag to stop while.. This change will refelct 

      System.out.println("Main thread updated flag to false.");
   }
}
```
### Why This Works?
- **No caching issues**: The `flag` variable is always read from main memory.
- **Change visibility**: As soon as `flag` is set to `false`, all threads see the updated value.

---

## Limitations of `volatile`
1. **No Atomicity for Compound Operations**
   ```java
   private static volatile int count = 0;
   
   public static void increment() {
       count++;  // Not atomic (read, modify, write)
   }
   ```
   **Solution**: Use `AtomicInteger` or `synchronized`
   ```java
   private static AtomicInteger count = new AtomicInteger(0);

   public static void increment() {
       count.incrementAndGet();
   }
   ```

2. **No Mutual Exclusion (`synchronized` still needed for complex operations)**
    - `volatile` **does not** prevent race conditions if multiple operations need to be synchronized.

---

## When to Use `volatile`?
- When a **single** thread writes, and **multiple** threads read.
- When **atomicity is not required** (use `synchronized` or `Atomic` classes otherwise).
- When **ordering of variable updates is important**.

---

## Conclusion
- `volatile` ensures **visibility** and **ordering** but not **atomicity**.
- Suitable for **flags**, **counters (single-writer, multiple-readers)**, and **double-checked locking**.
- For **compound actions**, use `synchronized` or `java.util.concurrent` classes.

---

## References
- [Java Volatile Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/volatile.html)
- [Java Concurrency in Practice - Brian Goetz]

Would you like a deeper dive into practical use cases like **double-checked locking with volatile**? 🚀

