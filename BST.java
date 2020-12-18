import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             

    private class Node {
        private Key key;          
        private Value val;         
        private Node left, right;  
        private int size;          

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public BST() {
    }
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }  
        return false;
    }
    public int size() {
      return size(root);
    }
    private int size(Node x) {
        if(x == null){
            return 0;
        }
        return x.size;
    }
    public boolean contains(Key key) {
       if(key == null){
        throw new IllegalArgumentException("arguments to contains() with a key nul");
       }
       return get(key) != null;
    }
    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x, Key key) {
       if(key == null){
        throw new IllegalArgumentException("call gets() is a null key");
       }
       if(x == null){
        return null;
       }
       else{
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.left,key);
        }
        else if(cmp > 0){
            return get(x.right,key);
        }
        else{
            return x.val;
        }
       }
    }
    public void put(Key key, Value val) {
        if(key == null){
            throw new IllegalArgumentException("call put() with a null key");
        }
        root = put(root,key,val);       
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null){
            return new Node(key,val,1);
        }
        else{
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x.left = put(x.left,key,val);
            }
            else if(cmp > 0){
                x.right = put(x.right,key,val);
            }
            else{
                x.val = val;
            }
            x.size = 1 + size(x.left) + size(x.right);
        }
        return x;
    }
    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("call min() is with empty symbol table");
        }
        return min(root).key;
    }

    private Node min(Node x) { 
         if(x.left == null){
            return x;
         }
         else{
            return min(x.left);
         }
    } 
    public Key floor(Key key) {
        if(key == null){
            throw new IllegalArgumentException("arguments to floor() is null");
        }
        if(isEmpty()){
            throw new NoSuchElementException("arguments to floor() is empty in symbol table");
        }
        Node x = floor(root,key);
        if(x == null){
            throw new IllegalArgumentException("arguments to floor() is too small");
        }
        else{
            return x.key;
        }
    } 

    private Node floor(Node x, Key key) {
       if(x == null){
        return x;
       }
       else{
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return floor(x.left,key);
        }
        else{
            Node floor1 = floor(x.right,key);
            if(floor1 != null){
                return floor1;
            }
            else{
                return x;
            }
        }
       }
    } 
 public static void main(String[] args){
 	BST<String ,Integer> theTree = new BST <String,Integer>();
 	theTree.put("Ada",1);
 	theTree.put("Ballerina", 7);
 	System.out.println(theTree.get("Ada"));
 	theTree.put("HTML",5);
 	theTree.put("Java",7);
 	System.out.println(theTree.get("Java"));
 	System.out.println(theTree.size());
 	System.out.println(theTree.min());
 	System.out.println(theTree.min());
 	System.out.println(theTree.floor("Ballerina"));
 }
} 