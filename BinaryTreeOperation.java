
package binarytreeoperation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryTreeOperation {

    private final Scanner sc = new Scanner(System.in);
    
    public void start(){
        int choice=0;
        int choice2=0;
        int value=0;
        int level=0;
        boolean input=false;
        BinaryTree bt = new BinaryTree();
        
        do{
            System.out.print("\n1)Add node\n2)BFS/Level order traversal\n"
                    + "3)DFS(Depth First Traversals)\n4)Delete node\n"
                    + "5)Array implementation\n6)AVL with duplicate keys\n"
                    + "7)Avl Display\n8)Continuous Tree\n9)Exit\n");
            System.out.print("Enter your choice:-");
            try{
                choice = sc.nextInt();
            }catch(InputMismatchException i){
                System.out.print("\nWrong input...enter again");
                sc.nextLine();
                start();
            }
            switch(choice){
                case 1:System.out.print("\nNumber of nodes:-");
                       int num=sc.nextInt();
                       for(int i=0;i<num;i++){
                           System.out.print("\nValue:-");
                           value = sc.nextInt();
                           bt.createBT(value);
                       }
                       break;
                case 2:
                       bt.levelOrderTraversal();
                       break;
                       
                case 3: Node node=bt.getRoot();
                        System.out.print("\n1)InOrder\t2)PostOrder\t3)PreOrder\n"
                                + "Enter your choice:-");
                        while(!input){
                            try{
                                choice2 = sc.nextInt();
                                input=true;
                            }catch(InputMismatchException i){
                                System.out.print("\nWrong input...enter again");
                                sc.nextLine();
                            }
                        }
                        switch(choice2){
                            case 1: System.out.print("\nInoder...\n");
                                    bt.inorder(node);
                                    break;
                            case 2: System.out.print("\nPostorder...\n");
                                    bt.postOrder(node);
                                    break;
                            case 3:System.out.print("\nPreorder...\n");
                                    bt.preOrder(node);
                                    break;
                        }
                        break;
                        
                case 4:
                        System.out.print("\nEnter the data to delete:-");
                        value=sc.nextInt();
                        bt.deleteNode(value);
                        break;
                case 5:bt.initializeArray();
                       System.out.print("\nArray implementation...");
                       System.out.print("\nNumber of nodes:-");
                       num=sc.nextInt();
                       for(int i=0;i<num;i++){
                           if(i==0){
                               System.out.print("Value:-");
                               value = sc.nextInt();
                           }
                           else{
                               System.out.print("Value:-");
                               value = sc.nextInt();
                               System.out.print("level:-");
                               level=sc.nextInt();
                           }
                           bt.arrayRepresentation(value,level);
                       }
                       bt.displayArray();
                       break;
                       
                case 6:
                       System.out.print("\nNumber of nodes:-");
                       num=sc.nextInt();
                       for(int i=0;i<num;i++){
                           System.out.print("\nValue:-");
                           value = sc.nextInt();
                           bt.treeDuplicateValue(value);
                       }
                       break;
                case 7:
                       System.out.print("\nAvl Tree with duplicate value:-");
                       AvlNode root = bt.getAvlRoot();
                       bt.avlInoder(root);
                       break;
                case 8:node=bt.getRoot();
                       bt.continuousTree(node);
                       break;
            }
        }while(choice!=9);
    }
   
    public static void main(String[] args) {
        BinaryTreeOperation obj = new BinaryTreeOperation();
        obj.start();
    }
    
}
