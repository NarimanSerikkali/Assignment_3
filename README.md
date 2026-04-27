# Assignment 3: HashTable and BST

This repository contains the implementation of custom data structures for Assignment 3. 
A strict requirement for this project was to **avoid recursion completely**.

## Features

* **Part 1: MyHashTable**
  * Custom Hash Table implemented using chaining.
  * `MyTestingClass` features a custom polynomial `hashCode()` implementation that ensures uniform distribution of 10,000 random elements across buckets.
* **Part 2: Binary Search Tree (BST)**
  * Fully iterative implementation of `put()`, `get()`, and `delete()` methods.
  * Custom In-Order `iterator()` built using a `Stack`, allowing simultaneous access to both keys and values during iteration.

## Files Structure
* `Main.java` - Entry point containing test cases for both data structures.
* `MyHashTable.java` - Hash table logic.
* `BST.java` - Iterative Binary Search Tree logic.
* `MyTestingClass.java` - Custom key class for testing hash distribution.
* `Student.java` - Value class for hash table testing.

## Author
Nariman Serikkali (SE-2536)
