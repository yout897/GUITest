package test;

import java.util.Scanner;

/**
 *  Name: Alex DiCarlo
 *  Date: September 7, 2016
 *  Purpose: To create a simple console based program that will eventually become
 *  a GUI based program. 
 *  Version: v0.1
 */
public class one{

    public static Scanner scan = new Scanner(System.in);
    public static String input;
    
    public static void check(){
        System.out.println("Welcome!\nIf you don't any commands please type \"help\"!");
        do{
            input = scan.nextLine();
            
            if(input.equalsIgnoreCase("Hi")){
                System.out.println("Hello there!");
            }
            else if(input.equalsIgnoreCase("help")){
                System.out.println("Commands:\tOutput:\n------------------------\nescape:\tCloses the program"
                        + "\ntableflip:\tWhat do you think it does!\nrand:\tCreates a random number between 1 and 100!"
                        + "\n");
            }
            else if(input.equalsIgnoreCase("tableflip")){
                System.out.println("(ヘ･_･)ヘ┳━┳");
                System.out.println("(┛◉Д◉)┛彡┻━┻");        
            }
            else if(input.equalsIgnoreCase("rand")){
                int randomNum;
                randomNum = (int)(Math.ceil(Math.random()*100));
                System.out.println(""+randomNum);
            }
            else if(input.equalsIgnoreCase("escape")){
                System.exit(0);
            }   
        }while(true);
    }
}
