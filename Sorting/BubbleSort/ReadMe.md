# Bubble Sort — C++ | Java | Python

This repository contains Bubble Sort implementations in **C++**, **Java**, and **Python**.  
All versions follow the same algorithmic logic and include both:

- **Standard Bubble Sort**
- **Optimized Bubble Sort using a “flag”**

The focus of this repository is to provide clear, beginner-friendly explanations and implementations of one of the simplest comparison-based sorting algorithms.

---

## 📌 What Is Bubble Sort?

Bubble Sort is a simple sorting algorithm that repeatedly compares **adjacent elements** and swaps them if they are in the wrong order. Over multiple passes (called *rounds*), the **largest elements gradually move to the right**, reaching their correct positions.

This repeating process resembles bubbles rising to the top—hence the name *Bubble Sort*.

---

## 🧠 How Bubble Sort Works

Bubble Sort sorts the array in multiple rounds:

### 1. Round-based movement
- In **Round 1**, the largest element is placed at the last position.
- In **Round 2**, the second-largest is placed correctly.
- Continue until all elements are sorted.

### 2. Adjacent comparison
In each round, compare:

current element ↔ previous element

If the previous element is larger, the two are swapped.

### 3. Shrinking the comparison range
After each round, one element reaches its final sorted position.  
So, the inner loop compares fewer elements each time.

---

## ⚡ Optimized Bubble Sort (Flag Method)

The improved version adds a **flag**:

- If **no swap occurs in a round**, the array is already sorted.
- The algorithm stops early instead of completing unnecessary rounds.

This optimization improves the **best-case time complexity from O(n²) to O(n)**.

---

## ⏱️ Time Complexity Analysis

| Scenario | Standard Bubble Sort | Bubble Sort With Flag |
|---------|------------------------|-------------------------|
| **Best Case** | O(n²) | **O(n)** |
| **Average Case** | O(n²) | O(n²) |
| **Worst Case** | O(n²) | O(n²) |

---

## 💾 Space Complexity

- **O(1)** extra space (in-place)
- **Stable**
- **No extra arrays needed**

---

## 🎯 When to Use Bubble Sort

- Learning sorting algorithms  
- Very small datasets  
- When input is almost sorted (flag version is efficient)  
- When stability matters  

---

## ⛔ When NOT to Use Bubble Sort

- Large datasets  
- Performance-critical applications  
- When better algorithms (Merge Sort, Quick Sort, TimSort) are available  

---

## 📂 Repository Structure

```
/cpp
/java
/python
README.md
```

---

## 📘 Summary

Bubble Sort is easy to understand, stable, and in-place, making it perfect for beginners, educational purposes, and demonstrating algorithm basics. This repo shows Bubble Sort in **C++**, **Java**, and **Python** for cross-language clarity.
