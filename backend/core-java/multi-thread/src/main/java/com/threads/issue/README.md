# Multithreading Issue Example

## Overview
This project demonstrates common **multithreading issues** in Java, specifically **race conditions** and **data corruption** due to unsynchronized access to a shared resource.

## Problem Statement
In a multithreaded environment, multiple threads may read and write to a shared data structure (like `HashMap`) without proper synchronization. This can lead to:
- **ConcurrentModificationException** when iterating over the map while modifying it.
- **Inconsistent or corrupted data** due to race conditions.

## Project Structure
```
.
├── App.java          # Main class to start threads
├── Resource.java     # Shared resource (HashMap without synchronization)
├── WriterThread1.java      # Writer thread 1
├── WriterThread2.java      # Writer thread 2
├── ReaderThread.java      # ReaderThread
```

## Code Explanation
### `Resource.java` (Shared Resource)
This class maintains a `HashMap` and provides methods for writing and reading data. However, it lacks thread synchronization, causing race conditions.

```java
public class Resource {
   private Map<String, String> map = new HashMap<>();

   public void write(String key, String val) {
      map.put(key, val);
   }

   public void read() {
      System.out.println("Reading Map...");
      for (String key : map.keySet()) {
         System.out.println(key + "|" + map.get(key));
      }
   }
}
```

### `WriterThread1.java` and `WriterThread2.java` (Writing Threads)
These classes write data to the shared resource, simulating concurrent writes.


```java
public class WriterThread1 extends Thread {
   private Resource resource;

   public WriterThread1(Resource resource){
      this.resource = resource;
   }

   @Override
   public void run() {
      for (int i=0; i<=100; i++) {
         this.resource.write("1_"+i, "A"+i);
         try {
            Thread.sleep(5);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
   }
}
```

### `ReaderThread.java`
This class read from shared resource

```java
public class ReaderThread extends Thread {
   private Resource resource;

   public ReaderThread(Resource resource){
      this.resource = resource;
   }

   @Override
   public void run() {
      for (int i = 0; i < 100; i++) {
         resource.read();
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
```

### `App.java` (Main Class)
Starts all three threads.

```java
public class App {
   public static void main(String[] args) {
      Resource resource = new Resource();

      Thread writer1 = new WriterThread1(resource);
      Thread writer2 = new WriterThread2(resource);
      Thread reader = new ReaderThread(resource);

      writer1.start();
      writer2.start();
      reader.start();
   }
}
```

## Result
```
"C:\Program Files\Java\jdk-22\bin\java.exe" --enable-preview "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.6\lib\idea_rt.jar=57698:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.6\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\workspace\learning\backend\core-java\multi-thread\target\classes com.threads.issue.App
Reading Map...
Reading Map...
Reading Map...
1_0|A0
Exception in thread "Thread-2" java.util.ConcurrentModificationException
	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
	at com.threads.issue.Resource.read(Resource.java:15)
	at com.threads.issue.ReaderThread.run(ReaderThread.java:13)

Process finished with exit code 0
```

## Conclusion
This project highlights the importance of thread synchronization when dealing with shared resources. By using `synchronized`, `ConcurrentHashMap`, or `ReentrantReadWriteLock`, we can resolve these multithreading issues effectively.

## Author
- **Sonu S**
- Contact: sonuskmp@gmail.com

