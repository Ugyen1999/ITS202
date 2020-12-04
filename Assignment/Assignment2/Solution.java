import java.util.*;

public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;            

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  

        public Node(Key key, Value val) {
            this.key = key; 
            this.val = val;
        }
    }
    public boolean isEmpty() {
        if(size == 0){ 
            return true;
        }
        return false;
    }
    public int size() {
      return size; 
    }
    public boolean contains(Key key) {
        Node curNode = root; 
       if(key == null){
            throw new IllegalArgumentException("There is not key conatin in the root");
       }
       else{
            while(curNode.key != key){
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){ 
                    curNode = curNode.left;
                }
                else{ 
                    curNode = curNode.right;
                }
            }
            return true; 
       }
    }
    public Value get(Key key) {
        if(key == null){
            throw new IllegalArgumentException("argument to get value() is null");
        }
        Node curNode = root; 
        while(curNode.key != key){
            int cmp = key.compareTo(curNode.key);
            if(cmp < 0){ 
                curNode = curNode.left; 
            }
            else if(cmp > 0){
                curNode = curNode.right;
            }
        }
        if(curNode.key == key){ 
            System.out.println(curNode.val); 
        }
        return curNode.val;
    }
    public void put(Key key, Value val) {
        Node newNode = new Node(key,val); 
        if(root == null){
            root = newNode;
        }
        else{
            Node curNode = root;
            Node parent; 
            while(true){
                parent = curNode;
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){
                    curNode = curNode.left;
                    if(curNode == null){
                        parent.left = newNode;
                        size = size + 1;
                        return;
                    }
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
                else if(cmp > 0){
                    curNode = curNode.right;
                    if(curNode == null){
                        parent.right = newNode;
                        size = size + 1;
                        return;
                    }
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
            }
        }
        size = size + 1;
    }
    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node curNode = root;
            while(curNode.left != null){
                curNode = curNode.left;
            }
            return curNode.key;
       }
    } 
    public Key floor(Key key) {
        if(isEmpty()){
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node curNode = root;
        Node parent = null;
        while(curNode != null){
            parent = curNode;
            int cmp = key.compareTo(parent.key);
            if(key == null){
                throw new IllegalArgumentException("argument to get value() is null");
            }
            if(cmp == 0){
                return parent.key;
            }
            if(cmp < 0){
                curNode = parent.left;
            }
            else if(cmp > 0){
                curNode = parent.right;
                int vmp = key.compareTo(curNode.key);
                if(vmp < 0){
                    return parent.key;
                }
                else{
                    curNode = parent.right;
                }
            }
        }
        return parent.key;
    } 
    public static void main(String[] args) { 
        Solution <String,Integer> bst = new Solution <String,Integer>();
        bst.put("ABDUL",1);
        bst.get("ABDUL");
        bst.put("HRITHIK",2);
        bst.put("SAI",3);
        bst.put("SAMAL",6);
        bst.get("SAI");  
        bst.put("TASHI",4);
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.floor("HRITHIK"));
        System.out.println(bst.floor("HAHA"));
        bst.put("CHIMI",5);
        bst.put("SAMAL",4);
        bst.get("SAMAL");
        bst.put("NIMA",7);
        System.out.println(bst.size());
        bst.get("CHIMI");
        System.out.println(bst.floor("CHIMI"));
        bst.put("SONAM",8);
        System.out.println("ABDUL CHIMI HRITHIK NIMA SAI SAMAL SONAM TASHI");
    }
}