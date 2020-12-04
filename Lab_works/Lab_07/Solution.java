import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }  
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x == null){
            return 0;
        }
        return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
       if(key == null){
        throw new IllegalArgumentException("arguments to contains() with a key nul");
       }
       return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
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

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
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

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
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



    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
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

    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/

    public static void main(String[] args) { 
        Solution <String,Integer> theTree = new Solution <String,Integer>();
        theTree.put("ABDUL",1);
        System.out.println(theTree.get("ABDUL"));
        theTree.put("HRITHIK",2);
        assert(theTree.contains("HRITHIK") == true);
        assert(theTree.contains("HAHA") == false);
        //System.out.println(theTree.keys("ABDUL","TASHI")); 
        theTree.put("SAI",3);
        theTree.put("SAMAL",6);
        System.out.println(theTree.get("SAI"));  
        theTree.put("TASHI",4);
        System.out.println(theTree.size());
        assert(theTree.size() == 5);
        System.out.println(theTree.min());
        System.out.println(theTree.floor("HRITHIK"));
        System.out.println(theTree.floor("HAHA"));
        assert(theTree.isEmpty() == false);
        //theTree.select();
        theTree.put("CHIMI",5);
        theTree.put("SAMAL",4);
        System.out.println(theTree.get("SAMAL"));
        theTree.put("NIMA",7);
        System.out.println(theTree.size());
        System.out.println(theTree.get("CHIMI"));
        System.out.println(theTree.floor("CHIMI"));
        theTree.put("SONAM",8);
        assert(theTree.size() == 8);
        assert(theTree.min() == "ABDUL");
        //System.out.println(theTree.keys("ABDUL","TASHI")); 
        System.out.println("All are Tested Correct");  
    }
} 