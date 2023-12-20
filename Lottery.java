import java.util.Scanner;
import java.util.Arrays;

public class Lottery {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    // color
    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";

    // list
    int[] winningNumbers = new int[5];
    int[] winningPower = new int[1];
    int[] userNumbers = new int[5];
    int[] userPower = new int[1];


    // winningNumbers
    for (int wn = 0; wn < winningNumbers.length; wn++){
      int random = numRandom(1,69);

      // if number repeats
      while(wn != 0 && !isValid(winningNumbers, random)){
          random = numRandom(1,69);
      }
      
      winningNumbers[wn] = random;
      
    } // end for loop

    // winningPower
    winningPower[0] = numRandom(1,26);

    // userNumbers
    for (int un = 0; un < userNumbers.length; un++){
      System.out.print("Enter your NUMBER: ");
      int inputNumber = s.nextInt();

      while (!isValid(userNumbers, inputNumber)){
        System.out.print("Invalid NUMBER. Enter another NUMBER: ");
        inputNumber = s.nextInt();
      }

      userNumbers[un] = inputNumber;
    } // end of for loop

    // userPower
    System.out.print("Enter your POWER: ");
    int inputPower = s.nextInt();
    userPower[0] = inputPower;

    while (userPower[0] > 26){
      System.out.print("Invalid POWER. Enter another POWER: ");
      inputPower = s.nextInt();
      userPower[0] = inputPower;
    } // end while loop

    System.out.println();
    System.out.println("Your NUMBERS Input: " + Arrays.toString(userNumbers));
    System.out.println("Your POWER Input: " + Arrays.toString(userPower));
    System.out.println("Winning NUMBERS: " + Arrays.toString(winningNumbers));
    System.out.println(RED + "Winning POWER: " + Arrays.toString(winningPower) +RESET);

    
    int matchNum = countMatches(winningNumbers, userNumbers);
    int matchPow = countMatches(winningPower, userPower);
    
    System.out.println();
    System.out.println("Match NUMBERS: " +matchNum);
    System.out.println("Match POWER: " +matchPow);

    System.out.println();
    System.out.println("Result: " +getPrize(matchNum, matchPow));
    
  }
  

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
    }
    
      return true;
  } // end of isValid method
  

  public static int countMatches (int[] arr1, int[] arr2){
    int count = 0;

    // nested enhanced for loop
    for (int i : arr1){
      for (int j : arr2){
        if (i==j){
          count++;
        } // end of if statement
      } // end of for loop j
    } // end of for loop i

    return count;
  } // end of countMatches method
  

  public static String getPrize(int winNum, int winPow){

    String result = "";

    // when there's no redball
    if (winPow == 0) {
      if (winNum == 5){
        result += "You win $1 Million!";
      }
      else if (winNum == 4){
        result += "You win $100!";
      }
      else if (winNum == 3){
        result += "You win $7!";
      }

    // when the user didn't get anything
      else{
        result += "You didn't win anything :(";
      }
    } // end if statement

    // when there's redball
    if (winPow == 1){
      if (winNum == 5){
        result += "You win the Grand Prize!";
      }
      else if (winNum == 4){
        result += "You win $50,000!";
      }
      else if (winNum == 3){
        result += "You win $100!";
      }
      else if (winNum == 2){
        result += "You win $7!";
      }
      else if (winNum == 1){
        result += "You win $4!";
      }
      else if (winNum == 0){
        result += "You win $4!";
      }
    } // end else if statement

    return result;
  } // end of getPrize method
  
  
} // end of lottery class
