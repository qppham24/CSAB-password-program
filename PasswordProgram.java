// Phuong Pham
// 8/31/2021
// 2 classes are used in this program. Password1 class is designed to check for valid password while PasswordProgram pulled the whole process together.

import java.util.*;

public class PasswordProgram {   
   public static void main(String[] args) {
      String pw1 = EnterPassword();
      ReEnterPassword(pw1);
   }
   
   //promt user for password and check if it meets the requirements
   public static String EnterPassword() {
      Scanner scan = new Scanner(System.in);
      Password1 pw1;
      do {
         System.out.println("Enter your password:");
         pw1 = new Password1(scan.nextLine());
      } while (!pw1.checkPassword1());
      System.out.println(pw1);
      return pw1.toString();
   }
   
   //promt user to re-enter password and check if it is the same as the first one
   public static void ReEnterPassword(String pw1) {
      Scanner scan = new Scanner(System.in);
      String pw2 = "";
      do {
         for (int i=0; i<3; i++) {
            System.out.println("Re-enter your password:");
            pw2 = scan.nextLine();
            if (pw1.equals(pw2)) {
               System.out.println("Success");
               i=4;
               return;
            }
         }
         // start process over again
         pw1 = EnterPassword();
      } while (!pw2.equals(pw1));
   }
}

class Password1 {
   String pw1;
   char[] arr;
   
   public Password1(String p) {
      pw1 = p;
      arr = pw1.toCharArray();
   }
   
   public String toString() {
      return pw1;
   }
   
   public boolean checkPassword1() {
      return checkLength() && hasLowerAndUpperCase() && hasNumber() && hasSpecialChar() && hasNoSpace();
   }
   
   public boolean checkLength() { //must have 8 or more characters
      return pw1.length()>=8;
   }
   
   public boolean hasLowerAndUpperCase() { //must have 1 lower and 1 upper case character
      int numOfLowerCase = 0;
      int numOfUpperCase = 0;
      for (char ch:arr) {
         if (Character.isLowerCase(ch)) {
            numOfLowerCase++;
         } else if (Character.isUpperCase(ch)) {
            numOfUpperCase++;
         }
      }
      return numOfLowerCase>0 && numOfUpperCase>0;
   }
   
   public boolean hasNumber() { //must have a number
      for (char ch:arr) {
         if (Character.isDigit(ch)) {
            return true;
         }
      }
      return false;
   }
   
   public boolean hasSpecialChar() { //must have a special character
      String specials = ".,?!;:\"(){}[]<>";
      char[] puncts = specials.toCharArray();
      for (char ch:arr) {
         Character a = ch;
         for (char punct:puncts) {
            Character b = punct;
            if (a.equals(b)) {
               return true;
            }
         }
      }
      return false;
   }
   
   public boolean hasNoSpace() { //must have no space
      for (char ch:arr) {
         if (Character.isSpaceChar(ch)) {
            return false;
         }
      }
      return true;
   }
}