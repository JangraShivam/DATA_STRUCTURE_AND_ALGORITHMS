# 🔍 Binary Search (C++ | Java | Python)

This folder contains clean and beginner-friendly implementations of **Binary Search** in three languages:
- **C++**
- **Java**
- **Python**

Each implementation supports:
- ✔ Searching in **ascending** sorted arrays  
- ✔ Searching in **descending** sorted arrays  
- ✔ Clear input/output format  
- ✔ Proper sorted-array validation  
- ✔ Clean variable naming and comments  

The Python version also demonstrates the use of the **inbuilt `bisect` module`.**

---

## 🧠 What is Binary Search?

Binary Search is an efficient searching algorithm that works on **sorted arrays** by repeatedly dividing the search interval in half (Divide & Conquer).

### Conditions
- The array must be sorted (ascending or descending).
- Direct indexing must be possible (arrays, not linked lists).

### How it works (Divide & Conquer)
1. Compare target with the middle element.  
2. If equal → return mid index.  
3. If target is smaller → search the left half.  
4. If target is larger → search the right half.  
5. Repeat until the search space becomes empty.

---

## 📊 Time & Space Complexity

| Operation | Complexity |
|----------|------------|
| **Search** | `O(log n)` |
| **Space** | `O(1)` |

Binary Search is extremely efficient because the search space is halved at every step.

---

## 📂 Files Included

BinarySearch.cpp → C++ implementation
BinarySearch.java → Java implementation
BinarySearch.py → Python implementation



---

## 🚀 How to Run

### C++
```bash
g++ BinarySearch.cpp -o bs
./bs

### Java
javac BinarySearch.java
java BinarySearch

### Python
python3 BinarySearch.py

📝 Input Format
Number of elements
Sorted array elements
Target element

Example:
Enter number of elements in the array: 5
Enter the elements of the array:
1
3
5
7
9
Enter the target value to search: 7

Output:
Target 7 found at index: 3
