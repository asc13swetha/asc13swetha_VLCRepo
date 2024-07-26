package com.ecz.ui;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the UserName");
        String userName=sc.nextLine();
        System.out.println("Enter the password");
        String pwd=sc.nextLine();
        if(userName.equals("xyz")&&pwd.equals("xyz123")){
            System.out.println("Login success");
            System.out.println("Welcome to VirtualLearningApplication");
            Menu menu=new Menu();
            menu.displayMenu();
            System.out.println("Enter choice from above display");
            int choice=menu.getChoice();
            while(choice>=1&&choice<=4){
                switch(choice){
                    case 1:
                        menu.addCourse(menu.course());
                        break;
                    case 2:
                        menu.displayCourse();
                        break;
                    case 3:
                        menu.searchCourse();
                        break;
                    case 4:
                        menu.deleteCourse();
                        break;
                    default:
                        break;
                }
                menu.displayMenu();
                System.out.println("Enter choice from above display");
                choice=menu.getChoice();
            }
        }
        else{
            System.out.println("login unsuccessful");
        }
    }
}
