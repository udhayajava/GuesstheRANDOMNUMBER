package com.java;

import java.util.*;
import java.io.*;
public class RandomNum {
    public static String filename;
    public static int number,guess;
    public static Scanner input;
    public static Random random;
    private static RandomNum randomNum;

    private RandomNum()
     {
         input = new Scanner(System.in);// takes input using scanner
         random = new Random( );
         System.out.println("guess the number between 0 to 10");
         number=random.nextInt(11);  //to check correct answer


         //-------------- loop until the guess is correct---------------------//
         while(guess != number)
         {
             guess = input.nextInt();
             if(guess<number){
                 System.out.println("Too Low and Try Again");
             }
             else {
                 if (guess > number) {
                 System.out.println("Too high and Try Again");
                     }
             }
         }
             System.out.println("Congratulation Correct Guess  =========>" +guess);
     }
     //---------------follows singleton----------------//
     public static RandomNum getRandomNum()
     {
         if(randomNum==null)
         {
             randomNum=new RandomNum();
         }
         return randomNum;
     }
     //-----------------method to create a file and write the output----------------------//
     public File file;
     public void userMessage()
     {
         Scanner scan = new Scanner(System.in);
         System.out.println("Name Your File");
         filename = scan.nextLine();          //takes the file name
         String directory = System.getProperty("user.dir");
         String path;
         path = directory + File.separator + filename;
         System.out.println("Filepath is " + path);
         file = new File( path);
         boolean result;
         try {
             result = file.createNewFile();//*creates a new file....
             if (result)                   //test if successfully created a new file and test the file is created
             {
                 System.out.println("file created" + file.getCanonicalPath());
             }
         } catch (IOException file_creation) {
             file_creation.printStackTrace();
         }
         //--------------write the output into the create file--------------//
         try {
             FileWriter myWriter = new FileWriter(filename);
             myWriter.write("Congratulation guess the number=========>  "+guess);
             myWriter.close();
             System.out.println("Successfully wrote to the file.");
         } catch (IOException exception) {
             System.out.println("An error occurred.");
             exception.printStackTrace();
         }
     }
     public static void main(String[] args) {
         RandomNum randomNum1=RandomNum.getRandomNum();
         randomNum1.userMessage();
    }
}
