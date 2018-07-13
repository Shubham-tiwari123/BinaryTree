
package binarytreeoperation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
}

class BinaryTree{
    Scanner sc = new Scanner(System.in);
    Node root,newnode,temp,temp1,arrayRoot;
    int[] A = new int[10];
    
    public BinaryTree() {
        root=null;
        arrayRoot=null;
    }
    
    public void createBT(int value){
        int num;
        char side;
        int flag1=0,flag2=0;
            
        newnode = new Node();
        newnode.data = value;
        newnode.left=null;
        newnode.right=null;
            
        if(root==null){
            root = newnode;
        }
        else{
            temp = root;
            System.out.print("\nWhere to enter(L/R):-");
            side=sc.next().charAt(0);
            if(side=='L'){
                if(temp.left==null){
                    temp.left = newnode;
                    temp=null;
                }
                else{
                    temp=temp.left;
                }
                while(temp!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=sc.next().charAt(0);
                    if(side=='L'){
                        temp1 = temp;
                        temp=temp.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        temp1=temp;
                        temp=temp.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    temp1.left=newnode;
                else if(flag2==1)
                    temp1.right=newnode;
            }
            else{
                if(root.right==null){
                    root.right = newnode;
                    temp = null;
                }
                else{
                    temp=temp.right;
                }
                while(temp!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=sc.next().charAt(0);
                    if(side=='L'){
                        temp1 = temp;
                        temp=temp.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        temp1=temp;
                        temp=temp.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    temp1.left=newnode;
                else if(flag2==1)
                    temp1.right=newnode;
            }

        }
    }
    
    public void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    
    public void preOrder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    
    public void levelOrderTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("\n");
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            System.out.print(temp.data+" ");
        }
    }
    public void deleteNode(int value){
        Node key_node=null;
        temp=null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            
            if(temp.data == value){
                key_node = temp;
            }
            if(temp.left != null)
                queue.add(temp.left);
            
            if(temp.right != null)
                queue.add(temp.right);
        }
        System.out.print(key_node.data);
        
        queue.add(root);
        while(!queue.isEmpty()){
            temp=queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        System.out.println(temp.data);
        
        key_node.data = temp.data;
        temp.data=-1;
        
        queue.add(root);
        while(!queue.isEmpty()){
            temp=queue.poll();
            if(temp.left!=null){
                if(temp.left.data==-1){
                    temp.left=null;
                    return;
                }
                queue.add(temp.left);
            }
            if(temp.right!=null){
                if(temp.right.data==-1){
                    temp.right=null;
                    return;
                }
                queue.add(temp.right);
            }
        }
    }
    
    Node getRoot(){
        return root;
    }
    
    public void initializeArray(){
        for(int i=0;i<10;i++){
            A[i]=-1;
        }
    }
    public void arrayRepresentation(int key,int root){
        
        char choice;
        if(A[0]==-1){
            A[0]=key;
        }
        else{
            System.out.print("\nEnter(L/R):-");
            choice = sc.next().charAt(0);
            if(choice=='L'){
                int possition = (root*2)+1;
                A[possition]=key;
            }
            if(choice=='R'){
                int possition = (root*2)+2;
                A[possition]=key;
            }
        }
    }
    
    public void displayArray(){
        for (int i = 0; i < 10; i++) {
            if (A[i] != -1)
                System.out.print(A[i]);
        }
    }
}

