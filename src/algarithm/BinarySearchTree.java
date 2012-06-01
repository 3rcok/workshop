package algarithm;

import java.util.ArrayList;
import java.util.Stack;
//to do:
// use generic programming
public class BinarySearchTree {
    private Node root = null;


    /**
     * @param args
     */
    public static void main(String[] args) {
        
//        test1();
        test2();
//        test3();
//        test4();
//        test5();
//        test6();


    }
    public void print(){
        print(root);
        System.out.println(" traverseTreeInOrderIterative");
        traverseTreeInOrder(root);
    }
    
    public static void test1(){
      BinarySearchTree tree = new BinarySearchTree();
      tree.addNode("g");
      tree.addNode("c");
      tree.addNode("i");
      System.out.println("test1 expected cgi, depth is " + tree.getDepth());
      tree.print();        
    }

    public static void test2(){

      BinarySearchTree tree = new BinarySearchTree();
      tree.addNode("g");
      tree.addNode("c");
      tree.addNode("i");
      tree.addNode("a");
      System.out.println("test2 expected acgi, depth is 2 " + tree.getDepth());
      tree.print();        
    }

    public static void test3(){
      BinarySearchTree tree = new BinarySearchTree();
      tree.addNode("g");
      tree.addNode("c");
      tree.addNode("i");
      tree.addNode("e");
      tree.addNode("a");
      System.out.println("test3 expected acegi, depth is 2 " + tree.getDepth());
      tree.print();        
    }

    public static void test4(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode("g");
        tree.addNode("c");
        tree.addNode("i");
        tree.addNode("e");
        tree.addNode("d");
        System.out.println("test4 expected cdegi, depth is 3 " + tree.getDepth());
        tree.print();        
      }

    public static void test5(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode("g");
        tree.addNode("c");
        tree.addNode("i");
        tree.addNode("e");
        tree.addNode("d");
        tree.addNode("f");
        System.out.println("test5 expected cdefgi, depth is 3 " + tree.getDepth());
        tree.print();        
      }
    public static void test6(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode("g");
        tree.addNode("c");
        tree.addNode("p");
        tree.addNode("e");
        tree.addNode("d");
        tree.addNode("h");
        tree.addNode("i");

        /*
         *    g
         *    /   \
         *   c     p
         *    \    /
         *     e   h
         *     /    \
         *     d     i
         *       
         *    
         */
        
        System.out.println("test6 expected cdeghip, depth is 3 " + tree.getDepth());
        tree.print();    
        for(int i=0; i<4;i++){
            System.out.println("level " +i+" width is " + tree.getWidth(i));
        }
        //add two more on right subtree, to test if it is still correct
        tree.addNode("o");
        tree.addNode("u");

        /*
         *    n
         *    /\
         *   c     p
         *    \   / \
         *     e  o  u
         *     / \
         *     d g
         *        \i
         *    
         */
        System.out.println("test6 expected cdeghiopu, depth is 4 " + tree.getDepth());
        tree.print();    
        for(int i=0; i<5;i++){
            System.out.println("level " +i+" width is " + tree.getWidth(i));
        }
        
        System.out.println("min " + tree.findMin().getData());        
        System.out.println("max " + tree.findMax().getData());     
      }
    //can be used to print the whole tree or any subtree    
    public void print(Node n){
        if(n.getLeft() != null){
            print(n.getLeft());}
        System.out.println(n.getData());
        if(n.getRight() != null){
            print(n.getRight()); 
        }
    }
    public void traverseTreeInOrder(Node node) {
        //incoming node is root
        Stack<Node> nodes = new Stack();
        while(!nodes.isEmpty()||null!=node) {
            if(null!=node) {
                nodes.push(node);
                node=node.left;
            } else {
                node=nodes.pop();
                System.out.println("Node data: "+node.data);
                node=node.right;
            }
        }                     
    }
    //get list of children on each level
    public ArrayList<Node> getChildren(int level){
        ArrayList<Node> list = new ArrayList<Node>();
        ArrayList<Node> parentList = new ArrayList<Node>();
 
        if(level==1 && root != null){
            parentList.add(root);
        } else {
            parentList = getChildren(level-1);
        }
        for(Node n:parentList){
            
            Node left = n.getLeft();
            Node right = n.getRight();
            if(left != null){
                list.add(left);
            }
            if(right != null){
                list.add(right);
            }
        }
        return list;  
      }

    //get width for each level. If there is only one root, and no subtree, the width is 1.
      public int getWidth(int level){
          if(level == 0 && root != null){
              return 1;
          }
          return getChildren(level).size();
      }
      //get the maximum width of a tree
      public int getMaxWidth(){
          int depth = getDepth();
          
          int max = 0;
          for(int i=0; i<= depth;i++){
              int w = getWidth(i);
              if(w > max){
                  max =w;
              }
          }
          return max;
      }
      //find the depth of the tree
      public int getDepth(){
          return getDepth(root, 0);
      }
      //find the depth of the subtree which has node as root
      //depth is the level of the node, which is needed to be one of the parameters, 
      //because you want to remember the previous value in the recursive call
      public int getDepth(Node node, int depth){

          if(node.getLeft()== null && node.getRight()==null){
              return depth;
          }
          Node tmp = node;


          if(tmp.getLeft() != null && tmp.getRight() != null){
              depth++;
              int left  = getDepth(tmp.getLeft(), depth);
              int right = getDepth(tmp.getRight(), depth);
              if(left<right){
                  depth=right;
              }else{
                  depth=left;
              }
              return depth;
          }

          if(tmp.getLeft() != null ){
              tmp = tmp.getLeft();
              return getDepth(tmp, ++depth);
          }
          if(tmp.getRight() != null){
              tmp = tmp.getRight();
              return getDepth(tmp, ++depth);
          }

          return depth;
      }
      //get the min in the tree
      public Node findMin(){
          Node min = root;
          Node node = root;
          if(root.getLeft() == null){
              return min;
          }
          while(node.getLeft()!=null){
              node = node.getLeft();
          }
          min = node;
          return min;
          
      }
      //get the max in the tree
      public Node findMax(){
          Node max = root;
          Node node = root;
          if(root.getRight() == null){
              return max;
          }
          while(node.getRight()!=null){
              node = node.getRight();
          }
          max = node;
          return max;
          
      }  
      //find a node.
      //return a Node in case the Node in the tree has more information than the _node which is passed in. 
      //return null if it can't find the node in the tree
      public Node findNode(Node _node){
          Node node = root;
          while(node != null){
              int flag = _node.compareTo(node);
              if(flag == 0){
                  return node;
              }
              else if(flag < 0){
                  node = node.getLeft();
              }
              else if(flag > 0){
                  node = node.getRight();
              }
          }
          return node;
      }
      
      //addNode should be method of tree class.
      //root can be a variable and use recursive call

      public void addNode(Comparable comparable){
          if(comparable == null){
              return;
          }
          if(root == null){
              root = new Node(comparable);
          }
          else{
              root.addNode(new Node(comparable));
          }
          
      }


class Node {
    private Node left = null;
    private Node right = null;
    private Comparable data = null;
    public Node(Comparable comparable){
        data = comparable;
        
    }
    public Node getLeft(){
        return left;
        
    }
    public Node getRight(){
        return right;
        
    }
    public void setLeft(Node node){
        left = node;
        
    }
    public void setRight(Node node){
        right = node;
        
    } 
    public Comparable getData(){
        return data;
    }
    public int compareTo(Node arg0) {
        if(!(arg0 instanceof Node)){
            
        }
        return data.compareTo(((Node)arg0).getData());
    }
    
    public void addNode(Node node){
        if(data.compareTo(node.data) < 0){
            if(getLeft() != null){
                getLeft().addNode( node);
            }else{
                setLeft(node);
            }
        }else{
            if(getRight() != null){
                getRight().addNode(node);
            }else{
                setRight(node);
            }
        }     }
               
    }    

//Example:
//http://en.literateprograms.org/Binary_search_tree_%28Java%29#chunk%20def:usage

    
}
