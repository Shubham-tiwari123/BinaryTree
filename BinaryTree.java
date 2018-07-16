
package binarytreeoperation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
}

class AvlNode{
    int data;
    int number;
    AvlNode left;
    AvlNode right;
}

class BinaryTree{
    Scanner sc = new Scanner(System.in);
    Node root,newnode,temp,temp1;
    int[] A = new int[10];
    AvlNode avlRoot,avlNewNode,tempVar,tempVar1;
    
    public BinaryTree() {
        root=null;
        avlRoot=null;
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
    
    public void treeDuplicateValue(int value){
        boolean flag=false;
        char side;
        int flag1=0,flag2=0;
        if(avlRoot==null){
            avlNewNode = new AvlNode();
            avlNewNode.data=value;
            avlNewNode.number=1;
            avlNewNode.left=null;
            avlNewNode.right=null;
            
            avlRoot=avlNewNode;
        }
        else{
            flag=checkData(value);
            if(flag)
                return;
            else{
                tempVar = avlRoot;
                avlNewNode=new AvlNode();
                avlNewNode.data=value;
                avlNewNode.number=1;
                avlNewNode.left=null;
                avlNewNode.right=null;
                
                System.out.print("\nWhere to enter(L/R):-");
                side=sc.next().charAt(0);
                if(side=='L'){
                    if(tempVar.left==null){
                        tempVar.left = avlNewNode;
                        tempVar=null;
                    }
                    else{
                        tempVar=tempVar.left;
                    }
                    while(tempVar!=null){
                        System.out.print("\nWhere to enter(L/R):-");
                        side=sc.next().charAt(0);
                        if(side=='L'){
                            tempVar1 = tempVar;
                            tempVar=tempVar.left;
                            flag1=1;
                            flag2=0;
                        }
                        else{
                            tempVar1=tempVar;
                            tempVar=tempVar.right;
                            flag1=0;
                            flag2=1;
                        }
                    }
                    if(flag1==1)
                        tempVar1.left=avlNewNode;
                    else if(flag2==1)
                        tempVar1.right=avlNewNode;
                }
                else{
                    if(avlRoot.right==null){
                        avlRoot.right = avlNewNode;
                        tempVar = null;
                    }
                    else{
                        tempVar=tempVar.right;
                    }
                    while(tempVar!=null){
                        System.out.print("\nWhere to enter(L/R):-");
                        side=sc.next().charAt(0);
                        if(side=='L'){
                            tempVar1 = tempVar;
                            tempVar=tempVar.left;
                            flag1=1;
                            flag2=0;
                        }
                        else{
                            tempVar1=tempVar;
                            tempVar=tempVar.right;
                            flag1=0;
                            flag2=1;
                        }
                    }
                    if(flag1==1)
                        tempVar1.left=avlNewNode;
                    else if(flag2==1)
                        tempVar1.right=avlNewNode;
                }

            }
        }
    }
    
    public boolean checkData(int value){
        tempVar = avlRoot;
        Queue<AvlNode>queue= new LinkedList<>();
        queue.add(avlRoot);
        while(!queue.isEmpty()){
            tempVar=queue.poll();
            if(tempVar.data==value){
                int i=tempVar.number;
                tempVar.number=i+1;
                return Boolean.TRUE;
            }
            if(tempVar.left!=null)
                queue.add(tempVar.left);
            if(tempVar.right!=null)
                queue.add(tempVar.right);
        }
        return Boolean.FALSE;
    }
    
    public void avlInoder(AvlNode node){
        if(node==null)
            return;
        avlInoder(node.left);
        System.out.print(node.data+" "+node.number+"\n");
        avlInoder(node.right);
    }
    
    AvlNode getAvlRoot(){
        return avlRoot;
    }
    
    public void continuousTree(Node nodeData){
        if(nodeData==null)
            return;
        Node temp2=null;
        int flag=0;
        Queue<Node>queue=new LinkedList<>();
        Queue<Node>queue1=new LinkedList<>();
        queue.add(nodeData);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left!=null)
                queue1.add(temp.left);
            if(temp.right!=null)
                queue1.add(temp.right);
            
            temp1=queue1.poll();
            if(temp1!=null){
                if(temp1.data-temp.data==1||temp1.data-temp.data==-1){
                    temp2=queue1.poll();
                    if(temp2!=null){
                        if(temp2.data-temp.data==1||temp2.data-temp.data==-1){
                            queue.add(temp1);
                            queue.add(temp2);
                            flag=1;
                        }
                        else{
                            System.out.println("\nNot a continues tree");
                            flag=0;
                            break;
                        }
                    }
                }
                else{
                    flag=0;
                    System.out.println("\nNot a continues tree");
                    break;
                }
            }
        }
        if(flag==1)
            System.out.print("\nContinuous Tree");
    }
}

