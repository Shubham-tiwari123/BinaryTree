
package binarytreeoperation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryTreeOperation {

    private final Scanner sc = new Scanner(System.in);
    
    public void start(){
        int choice=0;
        BinaryTree bt = new BinaryTree();
        
        do{
            System.out.print("\n1)Add node\n2)Display\n3)Delete node\n4)Exit\n");
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
                           int value = sc.nextInt();
                           bt.createBT(value);
                       }
                       break;
                case 2:
                        Node node=bt.getRoot();
                        bt.inorder(node);
                        break;
                case 3:
                        System.out.print("\nEnter the data to delete:-");
                        int value=sc.nextInt();
                        bt.deleteNode(value);
            }
        }while(choice!=4);
    }
   
    public static void main(String[] args) {
        BinaryTreeOperation obj = new BinaryTreeOperation();
        obj.start();
    }
    
}
