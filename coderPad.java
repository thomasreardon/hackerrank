import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
   
//     int[] values = {1,63415,86,34,90,64,1,8,0};
//     Stack<Integer> stack = new Stack<Integer>();
   
//     for(int i = 0; i<values.length; i++) {
     
//      stack.push(values[i]);
//     }
   
//     emptyStack(stack);
    
//     for(int i = 0; i<values.length; i++) {
     
//      System.out.println(stack.pop());
//     }
   
    // System.out.println(printExcel(10000));
   
    // reverseString("i.love.to.code");
  
    // String[] strings = {"aaa","bbb","ccc","bbb", "aaa","aaa"};
    // findSecondMostRepeatedString(strings.length, strings);
//     int[] array = {10,2,4,5,6,2,0,10,9,3};
//     int[] arrayTwo = {100,44,66,33,44,99,98,43,33,34};
//     mergeSort(10, array);
//     mergeSort(10, arrayTwo);
//     mergeTwoArraysInAscendingOrder(array, arrayTwo);
   
    // int[] A = {1, 2, 5, 4, 0};
    // int[] B = {2, 4, 5, 0, 1};
    // compareTwoArrays(A,B);
   
    // ArrayList<Object> list = new ArrayList<Object>(); //{1,2,"R",1,3,"L"};
   
//     DoublyLinkedList binaryTree = new DoublyLinkedList();
//     convertToDll(2, list, binaryTree);
 
     
    //  findNthUglyNumber(20);
    // String string = "geeksforgeeks";
    // findFirstUniqueCharacter(string);
    //isPowerOfTen(100000);
 
    //isAnagram("mostly", "lostmy");
    //isPalindrome("hannah");
    // int[] elements = {1,2,3,4,5,6};
    // reverseLinkedList(6, elements);
   
 
    // int[] primeNumbers = new int[1000];
    // primeFactorization(29, primeNumbers);
   // findPrimeNumbersUpToN(10, primeNumbers);
    // char digits[] = {'1', '2', '3', '4', '5'};
    // System.out.println(countDecoding(digits, 3));
   
//     int[] newArray = {10,32432,5,8,2,3,4,6,2,6,8,23,243,43,64,54,645,7};
//     mergeSortPractice(newArray);
   
//     int i = 0;
//     while(i<newArray.length){
//       System.out.println(newArray[i]);
//       i++;
//     }
   
//     System.out.println(1 + numberOfDecodings(3, "123"));
//     char[] digits = {'1','1','1','1','1','1'};
//     System.out.println(countDecoding(digits, digits.length));
       System.out.println(eggProblem(4, 50));
   
  }
 
//   Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below.
// An egg that survives a fall can be used again.
// A broken egg must be discarded.
// The effect of a fall is the same for all eggs.
// If the egg doesn't break at a certain floor, it will not break at any floor below.
// If the eggs breaks at a certain floor, it will break at any floor above.
// For more description on this problem see wiki page
// Input:
// The first line of input is  T denoting the number of testcases.Then each of the T lines contains two positive integer N and K where 'N' is the number of eggs and 'K' is number of floor in building.
// Output:
// For each test case, print a single line containing one integer the minimum number of attempt you need in order find the critical floor.
 
 
 
  public static int eggProblem(int eggs, int floors) {
   
    int attempts = 0;
    int increment = (int)Math.sqrt(floors);
   
    attempts = eggProblem2(eggs, floors, increment);
    return attempts;
  }
 
  public static int eggProblem2(int eggs, int floors, int increment) {
    int attempts = 0;
    int floorsLeft = floors;
   
    if(eggs < 2 && floorsLeft > 0) {
       attempts++;
       floorsLeft = floorsLeft - increment;
       attempts += eggProblem2(eggs, floorsLeft, increment);
    }
   
    else if (floorsLeft > 0 && eggs > 2) {
     eggs--;
      attempts++;
      int currentFloors = floorsLeft/2;
      floorsLeft = floorsLeft-currentFloors;
      attempts+= eggProblem2(eggs,floorsLeft,increment);
    }
   
    else if (floorsLeft > 0) {
      eggs--;
      attempts++;
      floorsLeft = floorsLeft-increment;
      attempts += eggProblem2(eggs, floorsLeft, increment);
   
    }
  
    return attempts;
  }
 
  //this one counts combinations on values needing to be adjacent
   public static int countDecoding(char[] digits, int n) 
   
  {
    // base cases
    if (n == 0 || n == 1)
    return 1;
 
    // Initialize count
    int count = 0; 
 
    // If the last digit is not 0, then 
    // last digit must add to
    // the number of words
    if (digits[n - 1] > '0')
    count = countDecoding(digits, n - 1);
 
    // If the last two digits form a number
    // smaller than or equal to 26,
    // then consider last two digits and recur
    if (digits[n - 2] == '1' || 
       (digits[n - 2] == '2' && digits[n - 1] < '7'))
    count += countDecoding(digits, n - 2);
 
    return count;
}
 
  //this function counts #of combinations possible
    public static int numberOfDecodings(int size, String string) {
      char[] array = string.toCharArray();
      int totalDecodings = 0;
      String total = "";
      int intTotal = 0;
      if(array[size-1] > '0' && (size-1) != 0) {
        totalDecodings = numberOfDecodings(size-1, string);
      }
       
      if(size > 1) {
          total += array[size-2];
          total += array[size-1];
          intTotal = Integer.valueOf(total);
      if(intTotal < 27) {
        totalDecodings++;
      }
        int x = size - 3;
        while(intTotal < 26 && x>-1) {
          total += array[x--];
          intTotal = Integer.valueOf(total);
          if(intTotal < 26) {
            totalDecodings++;
          }
        }
       
        totalDecodings += numberOfDecodings(size-1, string);
     
       
    }
     
      return totalDecodings;
    }
  
  public static void findNthUniqueWithLists(String string, int nth) {
    
    char[] stringArray = string.toCharArray();
    List<Object> uniqueList = new ArrayList<Object>();
    List<Object> duplicatesList = new ArrayList<Object>();
    
    int a = 0;
    while(a < stringArray.length){
     
      if(!uniqueList.contains(stringArray[a])){
        uniqueList.add(stringArray[a]);
        
      }
      else
        duplicatesList.add(stringArray[a]);
      a++;
    }
    
      for(int i = 0; i < duplicatesList.size(); i++){
     uniqueList.remove(duplicatesList.get(i)); 
    }
    System.out.println(uniqueList.get(nth));
  }
   
  public static void findPrimeNumbersUpToN(int num, int[] primeNumbers) {
 
    primeNumbers[0] = 2;
    primeNumbers[1] = 3;
    //a prime number is onyl divisile by itself and 1, 1 is not a prime numer
    int i = 2;
    int j = 2;
    while(i < num) {
     
      if(j % 3 != 0  && j % 2 != 0)
      {
        primeNumbers[i] = j;
        i++;
      }
        j++;
    }
   
   
  }
 
 
  public static void primeFactorization(int num, int[] primeNumbers) {
  
    //the cieling prime number is the square root of the number passed in
    findPrimeNumbersUpToN(num, primeNumbers);
    int[] primeFactors = new int[num-1];
   
    int i = num-1;
    int j = 0;
    while(i > -1) {
    
     if(num % primeNumbers[i] == 0) {
       primeFactors[j] = primeNumbers[i];
       System.out.println(primeFactors[j]);
        j++;
     }
        i--;
    }
   
    j = 0;
    while(num > 1) {
       num = num / primeFactors[j];
      System.out.println(j+1 + ":" + primeFactors[j]);
      if(num % primeFactors[j] != 0)
        j++;
    }
  }
 
//   Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// You have to flatten the linked list to a single linked list which is sorted.
//        5 -> 10 -> 19 -> 28
//        |    |     |     |
//        V    V     V     V
//        7    20    22    35
//        |          |     |
//        V          V     V
//        8          50    40
//        |                |
//        V                V
//        30               45
// and after flattening it, the sorted linked list looks like:
//  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
// The  node structure has 3 fields as mentioned. A next pointer, a bottom pointer and a data part.
// There are multiple test cases. For each test case, this function will be called individually.
// Input (To be used for Expected Output):
// The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
// First line of each test case contains an integer N denoting the number of head nodes connected to each other.
// Second line of each test case contains N space separated numbers (M1, M2...Mn) denoting number of elements in linked lists starting with each head. Third line of each test case contains all the elements of the linked list starting with 1st head node and covering all the elements through its down pointer, then 2nd head node and covering all its elements through down pointer and so on till the last head node of the linked list.
// Output:
// Return a pointer to the flattened linked list.
// Constraints:
// 1 <= T <= 50
// 0 <= N <= 50
// 1 <= Mi <= 20
// 1 <= Element of linked list <= 1000
// Example:
// Input
// 1                  
// 4
// 4 2 3 4                 
// 5 7 8 30 10 20 19 22 50 28 35 40 45
// Output:
// 5 7 8 10 19 20 22 28 30 35 40 45 50
  // Java implementation to construct a BST
// // from its level order traversal
// class GFG
// {
 
// // node of a BST
// static class Node
// {
//     int data;
//     Node left, right;
// };
 
 
// // function to get a new node
// static Node getNode(int data)
// {
//     // Allocate memory
//     Node newNode = new Node();
     
//     // put in the data 
//     newNode.data = data;
//     newNode.left = newNode.right = null; 
//     return newNode;
// }
 
 
// // function to construct a BST from
// // its level order traversal
// static Node LevelOrder(Node root , int data) 
// {
//     if(root == null)
//     { 
//         root = getNode(data);
//         return root;
//     }
//     if(data <= root.data)
//     root.left = LevelOrder(root.left, data);
//     else
//     root.right = LevelOrder(root.right, data);
//     return root;     
// }
 
// static Node constructBst(int arr[], int n)
// {
//     if(n == 0)return null;
//     Node root = null;
 
//     for(int i = 0; i < n; i++)
//     root = LevelOrder(root , arr[i]);
     
//     return root;
// }
 
// // function to print the inorder traversal
// static void inorderTraversal(Node root)
// {
//     if (root == null)
//         return;
     
//     inorderTraversal(root.left);
//     System.out.print( root.data + " ");
//     inorderTraversal(root.right); 
// }
 
 
// // Driver code
// public static void main(String args[])
// {
//     int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
//     int n = arr.length;
     
//     Node root = constructBst(arr, n);
     
//     System.out.print( "Inorder Traversal: ");
//     inorderTraversal(root);
// }
// }
// Java program for different tree traversals
 
/* Class containing left and right child of current
   node and key value*/
// class Node
// {
//     int key;
//     Node left, right;
 
//     public Node(int item)
//     {
//         key = item;
//         left = right = null;
//     }
// }
 
// class BinaryTree
// {
//     // Root of Binary Tree
//     Node root;
 
//     BinaryTree()
//     {
//         root = null;
//     }
 
//     /* Given a binary tree, print its nodes according to the
//       "bottom-up" postorder traversal. */
//     void printPostorder(Node node)
//     {
//         if (node == null)
//             return;
 
//         // first recur on left subtree
//         printPostorder(node.left);
 
//         // then recur on right subtree
//         printPostorder(node.right);
 
//         // now deal with the node
//         System.out.print(node.key + " ");
//     }
 
//     /* Given a binary tree, print its nodes in inorder*/
//     void printInorder(Node node)
//     {
//         if (node == null)
//             return;
 
//         /* first recur on left child */
//         printInorder(node.left);
 
//         /* then print the data of node */
//         System.out.print(node.key + " ");
 
//         /* now recur on right child */
//         printInorder(node.right);
//     }
 
//     /* Given a binary tree, print its nodes in preorder*/
//     void printPreorder(Node node)
//     {
//         if (node == null)
//             return;
 
//         /* first print data of node */
//         System.out.print(node.key + " ");
 
//         /* then recur on left sutree */
//         printPreorder(node.left);
 
//         /* now recur on right subtree */
//         printPreorder(node.right);
//     }
 
//     // Wrappers over above recursive functions
//     void printPostorder()  {     printPostorder(root);  }
//     void printInorder()    {     printInorder(root);   }
//     void printPreorder()   {     printPreorder(root);  }
 
//     // Driver method
//     public static void main(String[] args)
//     {
//         BinaryTree tree = new BinaryTree();
//         tree.root = new Node(1);
//         tree.root.left = new Node(2);
//         tree.root.right = new Node(3);
//         tree.root.left.left = new Node(4);
//         tree.root.left.right = new Node(5);
 
//         System.out.println("Preorder traversal of binary tree is ");
//         tree.printPreorder();
 
//         System.out.println("\nInorder traversal of binary tree is ");
//         tree.printInorder();
 
//         System.out.println("\nPostorder traversal of binary tree is ");
//         tree.printPostorder();
//     }
// }
//   // Java program to demonstrate insert operation in binary search tree
// class BinarySearchTree {
 
//     /* Class containing left and right child of current node and key value*/
//     class Node {
//         int key;
//         Node left, right;
 
//         public Node(int item) {
//             key = item;
//             left = right = null;
//         }
//     }
 
//     // Root of BST
//     Node root;
 
//     // Constructor
//     BinarySearchTree() { 
//         root = null; 
//     }
 
//     // This method mainly calls insertRec()
//     void insert(int key) {
//        root = insertRec(root, key);
//     }
     
//     /* A recursive function to insert a new key in BST */
//     Node insertRec(Node root, int key) {
 
//         /* If the tree is empty, return a new node */
//         if (root == null) {
//             root = new Node(key);
//             return root;
//         }
 
//         /* Otherwise, recur down the tree */
//         if (key < root.key)
//             root.left = insertRec(root.left, key);
//         else if (key > root.key)
//             root.right = insertRec(root.right, key);
 
//         /* return the (unchanged) node pointer */
//         return root;
//     }
 
//     // This method mainly calls InorderRec()
//     void inorder()  {
//        inorderRec(root);
//     }
 
//     // A utility function to do inorder traversal of BST
//     void inorderRec(Node root) {
//         if (root != null) {
//             inorderRec(root.left);
//             System.out.println(root.key);
//             inorderRec(root.right);
//         }
//     }
 
//     // Driver Program to test above functions
//     public static void main(String[] args) {
//         BinarySearchTree tree = new BinarySearchTree();
 
//         /* Let us create following BST
//               50
//            /     \
//           30      70
//          /  \    /  \
//        20   40  60   80 */
//         tree.insert(50);
//         tree.insert(30);
//         tree.insert(20);
//         tree.insert(40);
//         tree.insert(70);
//         tree.insert(60);
//         tree.insert(80);
 
//         // print inorder traversal of the BST
//         tree.inorder();
//     }
// }
//
     
//     }
 
 
//   public class LinkedListTest {
//   /**
//    * @param args
//    */
//   public static void main(String[] args) {
   
//     Node listNode = createLinkedList(9);
//     System.out.println("Print List Before Reverse");
//     printList(listNode);
//     listNode = reverseUsingRecursion(listNode);
//     System.out.println("Print List After Reverse using Recusion");
//     printList(listNode);
   
//     System.out.println("Print List Before Reverse");
//     printList(listNode);
//     listNode = reverseUsingIteration(listNode);
//     System.out.println("Print List After Reverse using Iteration");
//     printList(listNode);
//   }
 
//   private static Node createLinkedList(int n) {
//       Node head = new Node("1");
//       Node current = head;
  
//       for (int i = 2; i <= n; i++) {
//           Node newNode = new Node(String.valueOf(i));
//           current.setNext(newNode);
//           current = newNode;
//       }
  
//       return head;
//   }
 
//   private static Node reverseUsingIteration(Node head)  {
//         if(head.getNext() == null) {
//           return head;
//         }
//         Node currentNode = head;
//         Node nextNode = null;
//         Node previousNode = null;
           
//         while(currentNode != null) {
//           nextNode = currentNode.getNext();
//           currentNode.setNext(previousNode);
//           previousNode = currentNode;
//             currentNode = nextNode;
//         }
//         return previousNode;
//   }
 
//   private static Node reverseUsingRecursion(Node head)  {
//         if(head.getNext() == null) {
//           return head;
//         }
//         Node newHead = reverseUsingRecursion(head.getNext());
//         head.getNext().setNext(head);
//         head.setNext(null);
//         return newHead;
//   }
 
//   public static void printList(Node head) {
//     while (head != null) {
//       System.out.print(head.getData());
//       head = head.getNext();
//       }
//     System.out.println();
//   }
// }
 // more reverse linkedlist
   
// private static Node reverseUsingRecursion(Node head)  {
//         if(head.getNext() == null) {
//           return head;
//         }
//         Node newHead = reverseUsingRecursion(head.getNext());
//         head.getNext().setNext(head);
//         head.setNext(null);
//         return newHead;
//   }
   
// private static Node reverseUsingIteration(Node head)  {
//         if(head.getNext() == null) {
//           return head;
//         }
//         Node currentNode = head;
//         Node nextNode = null;
//         Node previousNode = null;
           
//         while(currentNode != null) {
//           nextNode = currentNode.getNext();
//           currentNode.setNext(previousNode);
//           previousNode = currentNode;
//             currentNode = nextNode;
//         }
//         return previousNode;
//   }
  //reverseALinkedList class LinkedList {
 
//     static Node head;
 
//     static class Node {
 
//         int data;
//         Node next;
 
//         Node(int d) {
//             data = d;
//             next = null;
//         }
//     }
 
//     /* Function to reverse the linked list */
//     Node reverse(Node node) {
//         Node prev = null;
//         Node current = node;
//         Node next = null;
//         while (current != null) {
//             next = current.next;
//             current.next = prev;
//             prev = current;
//             current = next;
//         }
//         node = prev;
//         return node;
//     }
 
//     // prints content of double linked list
//     void printList(Node node) {
//         while (node != null) {
//             System.out.print(node.data + " ");
//             node = node.next;
//         }
//     }
 
//     public static void main(String[] args) {
//         LinkedList list = new LinkedList();
//         list.head = new Node(85);
//         list.head.next = new Node(15);
//         list.head.next.next = new Node(4);
//         list.head.next.next.next = new Node(20);
         
//         System.out.println("Given Linked list");
//         list.printList(head);
//         head = list.reverse(head);
//         System.out.println("");
//         System.out.println("Reversed linked list ");
//         list.printList(head);
//     }
// }
 
 
 
//     public static void reverseLinkedList(int length, int[] elements) {
     
//       DoublyLinkedList head;
//       Node prev;
//       Node temp;
//       while(temp.next != null) [
//         temp = temp.next;
//         }
       
//         //now that i have the tail lets reverse
//         head.head = temp;//head.value = temp;
//         head.next = temp.prev;
//         prev = temp;
//         temp = temp.prev;
//         temp.next = temp.prev;
//         temp.prev = prev;
//         while(temp.prev != null) {
//           //setting tail to head and beginning the reverse
//           temp.next = temp.prev; 
//           temp.prev = prev;
//           temp = temp.next;
         
//         }
//         head.tail = temp;
//     }
 
    public static  void isPalindrome(String string) {
     
      StringBuilder temp = new StringBuilder(string.toString());
      temp.reverse();
     
      if(string.equals(temp.toString())) {
       System.out.println(string + "is a palindrome, backwards it is:" + temp);
      }
      else {
       System.out.println(string + "is not a palindrome, backwards it is: " + temp);
      }
     
    }
             
    public static void isAnagram(String stringOne, String stringTwo) {
     
      char[] charArray = stringOne.toCharArray();
      char[] charArrayTwo = stringTwo.toCharArray();
      Arrays.sort(charArray);
      Arrays.sort(charArrayTwo);
      if(Arrays.equals(charArray, charArrayTwo)) {
        System.out.println(stringOne + "is an anagram of " + stringTwo + "because they contain the letters ");
        for(int i = 0; i<charArray.length; i++){
          System.out.print(charArray[i]);
        }
       
      }
     
      else {
       System.out.println(stringOne + " is not an anagram of " + stringTwo + " because they both contain the    letters " + charArray.toString() + " and " + charArrayTwo.toString());
      }
     
    }
 
    public static void isPowerOfTen(int num) {
     
      int temp = num;
      int powers = 0;
      while(num >= 10) {
        num = num / 10;
        powers++;
      //  System.out.println(num);
      }
     
      if(num == 1) {
        System.out.println(temp + "is a factor of ten to the power of: " + powers);
      }
     
    }
 
    public static void findFirstUniqueCharacter(String string) {
     
      char[] stringArray = string.toCharArray();
      char[] uniqueArray = new char[stringArray.length];
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      for(int i = 0; i<stringArray.length; i++) {
          if(!map.containsKey(stringArray[i])) {
          map.put(stringArray[i], i);
          uniqueArray[i] = stringArray[i];
          }
     
        else {
         uniqueArray[map.get(stringArray[i])] = '\u0000';
        }
      }
      int i = 0;
      int j = 0;
      while(j < 1) {
        if(uniqueArray[i] != '\u0000') {
          j++;
        }
        i++;
      }
      System.out.println(uniqueArray[i]);
   
    }
 
   //prime = numbr that has no divisors except 1 and itself
  //ugly number only divisors are 2,3,or 5
    public static void findNthUglyNumber(int num) {
        System.out.println("1:1");
        int i = 2;
        int iteration = 0;
        int currentNumber = 1;
       
        while(i <= num) {
           if(currentNumber % 2 == 0 || currentNumber % 3 == 0 || currentNumber % 5 == 0) {
             System.out.println(i + ":" + currentNumber);
             i++;
           }
         
          currentNumber = ++iteration;
        
        }
       
    }
 
//    public class DoublyLinkedList {
   
//     Node head;
//     Node tail;
//     int size;
  
//     public DoublyLinkedList(){
//     size = 0;
     
//     }
 
//     public class Node {
     
//       int value;
//       Node left;
//       Node right;
     
//       public Node(int value, Node left, Node right) {
//             this.value = value;
//             this.left = left;
//             this.right = right;
//         }
//     }
//   private void inorder(Node root, Node prev, Node head){
//         if(root == null) return;
 
//         if(root.left != null) inorder(root.left);
//         process(root, prev,head);
//         if(root.right != null) inorder(root.right);
//     }
 
//   private void process(TreeNode root, TreeNode prev, TreeNode head){
//     if(prev == null){
//         head = root;
//     }
//     else{
//         prev.setRight(root);
//     }
//     root.setLeft(prev);
//     prev = root;
// }
   
//   }
//     public static void convertToDll(int edges, ArrayList<Object> list, DoublyLinkedList binaryTree){
   
//       Node temp = new Node();
//       for(int i = 0;i<list.size(); i = i+3) {
//         if(i ==0) {
//          head.value = list[i];
//          temp = head;
//         }
//         else {
//         //implement in order traversal to find the node  while(temp.
//         }
//           if(i+2 == "L") {
//             temp.left = new Node(list[i+1]);
//             }
       
//         else {
//             temp.right = new Node(list[i+1]);
//               }
     
       
//         binaryTree.size++;
//       }
//   }
 
//   Implement a Queue using 2 stacks s1 and s2 .
// Input Format:
// The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
// First line of each test case contains an integer Q denoting the number of queries .
// A Query Q is of 2 Types
// (i) 1 x (a query of this type means  pushing 'x' into the queue)
// (ii) 2   (a query of this type means to pop element from queue and print the poped element)
// The second line of each test case contains Q queries seperated by space.
// Output Format:
// The output for each test case will  be space separated integers having -1 if the queue is empty else the element poped out from the queue .
// You are required to complete the two methods push which take one argument an integer 'x' to be pushed into the quee and pop which returns a integer poped out from other queue.
// Your Task:
// Since this is a function problem, you don't need to take inputs. Just complete the provided functions. The printing is done automatically by the driver code.
 class StackQueue
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
  
    /* The method insert to push element
       into the queue */
    void insert(int B)
    {
     stack1.push(B);
    }
 
   
    /* The method remove which return the
      element popped out of the queue*/
    int remove()
    {
            if(stack2.isEmpty()) {
                 if(!stack1.isEmpty()){
                     for(int i = 0; i<stack1.size(); i++){
                         stack2.push(stack1.pop());
                     }
                     return stack2.pop();
                    
                 }
                else {
                    return -1;
                }
            }
                return stack2.pop();
               
    }
  }

  public static void compareTwoArrays(int[] array, int[] arrayTwo) {
  
    Arrays.sort(array);
    Arrays.sort(arrayTwo);
    //arrays must have exact same ordering of elements so we must sort first
    System.out.println(Arrays.equals(array, arrayTwo));
  }
 
  public static void mergeSort(int size, int[] array) {
   
    if(size < 2) {
      return;
    }
   
    int mid = size/2;
    int[] l = new int[mid];
    int[] r = new int[size-mid];
   
    for(int i =0; i<mid; i++) {
      l[i] = array[i];
    }
   
    for(int i = mid; i<size; i++) {
      r[i-mid] = array[i];
    }
   
    mergeSort(mid, l);
    mergeSort(size - mid, r);
    merge(array, l, r);   
   
  }
 
    
  //int leftSize is left sub array size, rightSize is right sub array size
  public static void merge(int [] array, int[] l, int[] r) {
   
    int i = 0, j = 0, k = 0;
    while (i < l.length && j < r.length) {
        if (l[i] >= r[j]) {
          array[k++] = l[i++];
        }
        else {
          array[k++] = r[j++];
        }
    }
    while (i < l.length) {
        array[k++] = l[i++];
    }
   
    while (j < r.length) {
        array[k++] = r[j++];
    }
   
  }
 
  //hacker rank is to merge two sorted arrays in ascending order into one array in ascending order
  public static void mergeTwoArraysInAscendingOrder(int[] array, int[] arrayTwo) {
   
    int[] combinedArray = new int[array.length + arrayTwo.length];
    merge(combinedArray, array, arrayTwo);
   
    int i = 0;
    while (i < combinedArray.length) {
     System.out.println(combinedArray[i]);
      i++;
    }
   
  }
 
 
//   Given two sorted arrays P[] and Q[] in non-decreasing order with size X and Y. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
// Note: Expected time complexity is O((X+Y) log(X+Y)). DO NOT use extra space.
// Input:
// First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.
// Output:
// For each test case, print (X + Y) space separated integer representing the merged array.
// Constraints:
// 1 <= T <= 100
// 1 <= X, Y <= 5*104
// 0 <= Pi, Qi <= 109
// Example:
// Input:
// 1
// 4 5
// 1 3 5 7
// 0 2 6 8 9
 
  public static void findSecondMostRepeatedString(int numberOfStrings, String[] strings) {
   
      HashMap<String, Integer> map = new HashMap<String, Integer>();
     
      Object[] greatest = {"", 0};
      Object[] secondGreatest = {"", 0};
  
      for(int i = 0; i<numberOfStrings; i++){
       
        if(!map.containsKey(strings[i])){
            map.put(strings[i], 1);
        }
        else {
            map.put(strings[i], map.get(strings[i])+1);
           
            if(map.get(strings[i]) > (Integer)greatest[1]) {
             
                secondGreatest[0] = greatest[0];
                secondGreatest[1] = greatest[1];
                greatest[0] = strings[i];
                greatest[1] = map.get(strings[i]);
            }
        }
        System.out.println(map.values());
      
      }
   
     System.out.println(secondGreatest[0]);
  }
  //hasmap
 // use get or default to check if value exists = map.put(map.getOrDefault("word"))
 
//   Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
// Note: No two strings are the second most repeated, there will be always a single string.
// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting number of strings in a sequence and the second line contains N space separated strings.
// Output:
// For each test case, in a new line print the second most repeated string.
// Constraints:
// 1<=T<=100
// 3<=N<=103
// 1<=|String length|<=100
// Example:
// Input:
// 2
// 6
// aaa bbb ccc bbb aaa  aaa
// 6
// geeks for geeks for geeks aaa
 
  //implement push pop for queuee
//     void push(int a)
//   {
//       arr[rear] = a;
//       rear++;
  
//   }
//     /* The method pop which return the
//        element poped out of the queue*/
//   int pop()
//   {
//      if(front == rear){
//          return -1;
//      }
//      else {
//      int temp = arr[front];
//      front++;
//      return temp;
//      }
//   }
 
  //reverse words in a given string without reversing the individual words
  public static void reverseString(String string) {
  
    String reversedString = "";
    String[] splittedString = string.split("\\.");
    for(int i = splittedString.length-1; i>-1;i--){
     
      reversedString += splittedString[i];
      if(i>0){
       reversedString += ".";
      }
    }
   
    System.out.println(reversedString);
  }
 
  //sort stack recursively
  public static void emptyStack(Stack<Integer> stack){
  
    if(!stack.isEmpty()){
    
      int temp = stack.pop();
      emptyStack(stack);
      sortStack(temp, stack);
    }
   
  }
 
  public static void sortStack(int temp, Stack<Integer> stack) {
   
   if(stack.isEmpty() || stack.peek() <= temp){
     stack.push(temp);
   }
 
    if(stack.peek() > temp) {
     
      int newTemp = stack.pop();
      stack.push(temp);
      emptyStack(stack);
      sortStack(newTemp, stack); 
    }
   
  }
 
  //given an integer print out a if its 1, z if its 26, 27 if aa
  //cz if 100, 1000 is all
    public static String printExcel(int value){
   
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] alphabetArray = alphabet.toCharArray();
    String columnTitle = "";
    String title = "";
  
   
    while(value>26) {
     
      int modulus = value % 26;
      value = value / 26;
      title += alphabetArray[modulus-1];
   }
   
      columnTitle = "" + alphabetArray[value-1];
   
     
    char[] reversedTitle = title.toCharArray();
    for(int i = reversedTitle.length-1; i>-1; i--){
        columnTitle += reversedTitle[i];
    }
   
    //columnTitle += title;
    System.out.println(columnTitle);
    return columnTitle;
   
    }
  }