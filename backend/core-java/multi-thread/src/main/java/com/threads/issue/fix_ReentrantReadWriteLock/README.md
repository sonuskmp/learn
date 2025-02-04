# Multithreading Issue Example

## Overview
This project demonstrates common **multithreading issues** in Java, specifically **race conditions** and **data corruption** due to unsynchronized access to a shared resource.
It can be fixed by ReentrantReadWriteLock

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
This class maintains a `HashMap` and provides methods for writing and reading data. Applied lock using  ReentrantReadWriteLock here.

```java
public class Resource {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Map<String, String> map = new HashMap<>();

    public void write(String key, String val) {
        lock.writeLock().lock();
        try {
            map.put(key, val);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println("Reading Map...");
            for (String key : map.keySet()) {
                System.out.println(key + "|" + map.get(key));
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}
```


## Result
```
Runs Succussfully..
```

## Conclusion
This project highlights the importance of thread locking when dealing with shared resources.

## Author
- **Sonu S**
- Contact: sonuskmp@gmail.com

