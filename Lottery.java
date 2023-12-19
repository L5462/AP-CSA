import java.util.Arrays;
import java.util.Scanner;

public class Lottery{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);

    // color
    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";

    // list
    int[] lottery = new int[6];
    int[] whiteBall = new int[5];
    int[] redBall = new int[1]; // what if this is a variable
    int[] guess = new int[6];

    // whiteBall
    for(int w=0; w<whiteBall.length; w++){
      whiteBall[w] = numRandom(1,69);
    } // end for loop

    
  } // end of main method

  public static int numRandom(int min, int max) {
    return (int)(Math.random() * (max - min + 1) + min);
  } // end of numRandom method
  

  public static boolean isValid(int[] arr, int num) {
    if(num < 1 || num > 69) {
      return false;
    }
    
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == num) {
        return false;
      }
    } // end for loop
    
    return true;
  } // end of isValid method
  

  public static String getPrize(int wr, int rr){
    String result = "";
    
    // when there's no redball
    if (rr == 0) {
      if (wr == 5){
        result += "You win $1 Million!";
      }
      else if (wr == 4){
        result += "You win $100!";
      }
      else if (wr == 3){
        result += "You win $7!";
      }
    
    // when the user didn't get anything
      else{
        result += "You didn't win anything :(";
      }
    } // end if statement
      
    // when there's redball
    if (rr == 1){
      if (wr == 5){
        result += "You win the Grand Prize!";
      }
      else if (wr == 4){
        result += "You win $50,000!";
      }
      else if (wr == 3){
        result += "You win $100!";
      }
      else if (wr == 2){
        result += "You win $7!";
      }
      else if (wr == 1){
        result += "You win $4!";
      }
      else if (wr == 0){
        result += "You win $4!";
      }
    } // end else if statement

    retrun result;
  } // end of getPrize method
  
} // end of class
