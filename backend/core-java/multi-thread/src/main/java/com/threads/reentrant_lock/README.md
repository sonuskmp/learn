### **README for `ReentrantLockExample`**

#### **Introduction**
This project demonstrates the usage of **ReentrantLock** in Java. A **ReentrantLock** allows a thread to acquire the same lock multiple times without causing a deadlock. The example includes two methods (`method1` and `method2`), where a thread re-acquires the lock when calling `method2()` from `method1()`.

---

#### **Project Structure**
```
/ReentrantLockExample
│── src
│   ├── App.java                // Main class to run the example
│   ├── ReentrantLockExample.java // Demonstrates ReentrantLock usage
│── README.md    
```

---

#### **How It Works**
1. `method1()` acquires the lock.
2. `method1()` calls `method2()`, which **reacquires the same lock**.
3. Both methods execute successfully without deadlock.
4. The lock is released in the reverse order of acquisition.

---

#### **Code Explanation**

##### **`App.java` (Main Class)**
```java
public class App {
    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.method1();
    }
}
```
- Initializes an instance of `ReentrantLockExample` and calls `method1()`.

##### **`ReentrantLockExample.java` (Lock Demonstration Class)**
```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void method1() {
        lock.lock();
        try {
            System.out.println("Method 1 executing...");
            method2();  // Reacquires the lock
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();  // Allowed since it's the same thread
        try {
            System.out.println("Method 2 executing...");
        } finally {
            lock.unlock();
        }
    }
}
```

---

#### **Expected Output**
```
Method 1 executing...
Method 2 executing...
```
- The thread successfully re-enters the lock when calling `method2()`.

---

#### **Advantages of `ReentrantLock` Over `synchronized`**
| Feature | `synchronized` | `ReentrantLock` |
|---------|--------------|----------------|
| Supports reentrancy | ✅ Yes | ✅ Yes |
| Explicit lock handling | ❌ No | ✅ Yes |
| TryLock support | ❌ No | ✅ Yes (`lock.tryLock()`) |
| Interruptible locking | ❌ No | ✅ Yes (`lock.lockInterruptibly()`) |
| Fair lock option | ❌ No | ✅ Yes (`new ReentrantLock(true)`) |

---

#### **When to Use `ReentrantLock`?**
- When explicit lock management is needed.
- When `tryLock()` or fairness policies (`new ReentrantLock(true)`) are required.
- When a thread should be able to interrupt while waiting for a lock.

---

#### **How to Run the Code**
1. **Compile and Run (Using Terminal)**
   ```sh
   javac App.java ReentrantLockExample.java
   java App
   ```
---

#### **Conclusion**
This project showcases **ReentrantLock**, demonstrating how a thread can safely acquire the same lock multiple times without deadlock. This is useful in complex synchronization scenarios requiring advanced lock handling.

---

Would you like me to add any enhancements, such as multi-threading examples or logging? 🚀