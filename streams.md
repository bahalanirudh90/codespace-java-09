# Java Streams Quick Reference Guide

## 🎯 **Learning Path to Master Java Streams**

### **Phase 1: Basic Operations (Questions 1-10)**
- **filter()** - Remove elements that don't match criteria
- **map()** - Transform elements to different type/value
- **forEach()** - Perform action on each element
- **collect()** - Gather results into collections

### **Phase 2: Intermediate Operations (Questions 11-20)**
- **sorted()** - Sort elements by natural order or custom comparator
- **distinct()** - Remove duplicates
- **limit()** - Take only first N elements
- **skip()** - Skip first N elements

### **Phase 3: Advanced Operations (Questions 21-30)**
- **reduce()** - Combine elements into single result
- **min()/max()** - Find minimum/maximum element
- **anyMatch()/allMatch()/noneMatch()** - Test conditions
- **findFirst()/findAny()** - Get optional element

### **Phase 4: Complex Operations (Questions 31-38)**
- **groupingBy()** - Group elements by key
- **partitioningBy()** - Split into two groups
- **joining()** - Concatenate strings
- **summaryStatistics()** - Get statistical data

---

## 📚 **Stream Operations Cheat Sheet**

### **Intermediate Operations (Return Stream)**
```java
// Filtering
.filter(predicate)              // Keep elements matching condition
.distinct()                     // Remove duplicates
.limit(n)                      // Take first n elements
.skip(n)                       // Skip first n elements

// Transforming
.map(function)                 // Transform each element
.flatMap(function)             // Flatten nested collections
.mapToInt/Long/Double()        // Convert to primitive streams

// Sorting
.sorted()                      // Natural order
.sorted(comparator)            // Custom order
```

### **Terminal Operations (End Stream)**
```java
// Collecting
.collect(Collectors.toList())          // To List
.collect(Collectors.toSet())           // To Set
.collect(Collectors.toMap(k,v))        // To Map
.collect(Collectors.joining(","))      // Join strings
.collect(Collectors.groupingBy(key))   // Group by key

// Reducing
.reduce(identity, accumulator)         // Custom reduction
.sum()                                 // Sum (IntStream)
.average()                             // Average (IntStream)
.min(comparator)                       // Minimum element
.max(comparator)                       // Maximum element

// Matching
.anyMatch(predicate)                   // Any element matches?
.allMatch(predicate)                   // All elements match?
.noneMatch(predicate)                  // No elements match?

// Finding
.findFirst()                           // Optional first element
.findAny()                             // Optional any element
.count()                               // Count elements

// Consuming
.forEach(consumer)                     // Perform action on each
```

---

## 🔧 **Common Patterns**

### **1. Filter → Map → Collect**
```java
List<String> result = list.stream()
    .filter(item -> condition)
    .map(item -> transform)
    .collect(Collectors.toList());
```

### **2. Group and Count**
```java
Map<Key, Long> counts = list.stream()
    .collect(Collectors.groupingBy(keyExtractor, Collectors.counting()));
```

### **3. Sort and Limit**
```java
List<Item> top5 = list.stream()
    .sorted(comparator.reversed())
    .limit(5)
    .collect(Collectors.toList());
```

### **4. Complex Grouping**
```java
Map<Key1, Map<Key2, List<Item>>> nested = list.stream()
    .collect(Collectors.groupingBy(
        keyExtractor1,
        Collectors.groupingBy(keyExtractor2)
    ));
```

---

## 💡 **Tips for Success**

1. **Start Simple**: Begin with basic filter/map/collect operations
2. **Chain Operations**: Build complex pipelines step by step
3. **Use Method References**: `Object::method` instead of `obj -> obj.method()`
4. **Understand Lazy Evaluation**: Intermediate operations are lazy
5. **Debug with peek()**: Use `.peek(System.out::println)` to see intermediate results
6. **Know Your Collectors**: Master groupingBy, partitioningBy, joining
7. **Practice Daily**: Solve 2-3 questions daily to build muscle memory

---

## 🎯 **Recommended Practice Schedule**

**Week 1**: Questions 1-15 (Basic filtering, mapping, sorting)
**Week 2**: Questions 16-25 (Grouping, reduction, advanced filtering)
**Week 3**: Questions 26-35 (Complex operations, statistics)
**Week 4**: Questions 36-38 + Create your own challenges

---

## 🚀 **Next Steps After Mastery**

1. **Parallel Streams**: Use `.parallelStream()` for performance
2. **Custom Collectors**: Create your own collector implementations
3. **Stream Performance**: Understand when to use streams vs traditional loops
4. **Optional Integration**: Master Optional with streams
5. **Real Projects**: Apply streams in actual codebases
