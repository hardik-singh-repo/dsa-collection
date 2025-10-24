# Data Structures in Java

## 1. Linear Data Structures

### a) Arrays
- Fixed size
- Time Complexities:
  - Access: O(1)
  - Search: O(n)
  - Insert/Delete: O(n)

### b) ArrayList
- Dynamic size
- Time Complexities:
  - Access: O(1)
  - Add/Remove at end: O(1) amortized
  - Add/Remove at middle: O(n)

### c) LinkedList
- Dynamic size
- Time Complexities:
  - Access: O(n)
  - Add/Remove at start/end: O(1)
  - Add/Remove at middle: O(n)

## 2. Stack and Queue

### a) Stack (LIFO)
- Time Complexities:
  - Push: O(1)
  - Pop: O(1)
  - Peek: O(1)

### b) Queue (FIFO)
- Time Complexities:
  - Enqueue: O(1)
  - Dequeue: O(1)
  - Peek: O(1)

## 3. Tree Structures

### a) Binary Tree
- Time Complexities:
  - Access/Search/Insert/Delete: O(n)

### b) Binary Search Tree (BST)
- Time Complexities:
  - Access/Search/Insert/Delete: O(log n) average case
  - Access/Search/Insert/Delete: O(n) worst case

### c) AVL Tree
- Self-balancing
- Time Complexities:
  - Access/Search/Insert/Delete: O(log n)

### d) Red-Black Tree
- Self-balancing
- Time Complexities:
  - Access/Search/Insert/Delete: O(log n)

## 4. Hash-Based Structures

### a) HashMap
- Time Complexities:
  - Access/Insert/Delete: O(1) average case
  - Access/Insert/Delete: O(n) worst case

### b) HashSet
- Time Complexities:
  - Add/Remove/Contains: O(1) average case
  - Add/Remove/Contains: O(n) worst case

## 5. Heap

### a) PriorityQueue (Binary Heap)
- Time Complexities:
  - Insert: O(log n)
  - Delete min/max: O(log n)
  - Get min/max: O(1)

## 6. Graph

### a) Adjacency Matrix
- Space Complexity: O(V²)
- Time Complexities:
  - Add Edge: O(1)
  - Remove Edge: O(1)
  - Check Edge: O(1)

### b) Adjacency List
- Space Complexity: O(V + E)
- Time Complexities:
  - Add Edge: O(1)
  - Remove Edge: O(E)
  - Check Edge: O(V)

## Common Use Cases

1. **ArrayList**: 
   - Dynamic arrays
   - Frequent access operations
   
2. **LinkedList**: 
   - Frequent insertions/deletions
   
3. **HashMap**: 
   - Key-value pairs
   - Caching implementations
   
4. **TreeMap**: 
   - Sorted key-value pairs
   
5. **Stack**: 
   - Expression evaluation
   - Undo mechanisms
   
6. **Queue**: 
   - Task scheduling
   - Breadth-First Search (BFS)
   
7. **PriorityQueue**: 
   - Task scheduling with priority
   
8. **Graph**: 
   - Network routing
   - Social networks modeling

---
*Note: Time complexities are given in Big O notation. V represents number of vertices and E represents number of edges in graph-related complexities.*