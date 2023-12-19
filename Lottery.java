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
    }
  
} // end of class
