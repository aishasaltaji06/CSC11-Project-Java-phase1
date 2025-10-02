import java.util.Scanner;
public class Encryption {
   static Scanner console = new Scanner(System.in); 
   public static void main(String[] args){


     //Default variables

      String PIN = "0000";
      boolean Status = true;
      boolean Authenticated = true;
      String OriginalKey_Attempt = null;
      String CodeKey_Attempt = null;
      String OriginalKey = null;
      String CodeKey = null;
      String CurrentSentence = null;
      String pinAttempt = null;
      boolean isActive = true;




     // Setting the PIN by the user

      System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
      PIN = console.next();
      char first_num = PIN.charAt(0);

     // Check for wrong type input hhhh

      for (int i = 0; i < PIN.length(); i++){
         if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9')
            Status = false;
         else
            Status = true;
      }



      while (first_num == '0' || PIN.length() != 4 || Status == false)
      {
         System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
         PIN = console.next(); 
         for (int i = 0; i < PIN.length(); i++){
            System.out.println(PIN.charAt(i));
            if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9')
               Status = false;
            else
               Status = true;
         }

      }








     // Show Display Menu and ask for the number

      while(true){
         System.out.println("Please choose a number from the following options: \n 1. Set/Change the key \n 2. Display Key \n 3. Enter a sentence \n 4. Display Current Sentence \n 5. Encryption \n 6. Decryption \n 7. Exit System");
         int optionNum = console.nextInt();

      // Cases:

         switch(optionNum){

            case 1:            // Set/Change the key: needs a PIN
               System.out.println("PIN required, please enter your PIN: ");
               pinAttempt = console.next();
               if(pinAttempt.equals(PIN)) {
                  System.out.println("Access Granted");
                  Authenticated=true;
               } else {
                  System.out.println("Access Denied");
                  break;
               }

               System.out.println("Enter the original key: ");
               OriginalKey_Attempt = console.next();
               System.out.println("Enter the code key: ");
               CodeKey_Attempt = console.next();
               if (OriginalKey_Attempt.length() != CodeKey_Attempt.length()) {
                  System.out.println("The keys are not the same length");
                  break;

               }
               for(int j=0; j<CodeKey_Attempt.length(); j++) {
                  char ch=CodeKey_Attempt.charAt(j);
                  if(OriginalKey_Attempt.indexOf(ch) == -1){
                     System.out.println("Validation failed: Character " + ch + " from code key is not in the original key");
                     break;
                  }
               }
               OriginalKey = OriginalKey_Attempt;
               CodeKey = CodeKey_Attempt;
               System.out.println("The keys have been set");
               //check if required to keep or only demonstrate the special case
               CurrentSentence=null;
               break;


            case 2: // Display Key : needs a PIN    
            System.out.println("PIN required, please enter your PIN: ");
               pinAttempt = console.next();
               if(pinAttempt.equals(PIN)) {
                  System.out.println("Access Granted");
                  Authenticated=true;
               } else {
                  System.out.println("Access Denied");
                  break;
               }
               if(OriginalKey!=null||CodeKey!=null)
               System.out.printf("Your original key is: %s %nYour code key is: %s%n",OriginalKey,CodeKey);
               else System.out.println("The key has not been set, returning to main menu");
               break;


            case 3: // Enter a sentence


            case 4: // Display Current Sentence


            case 5: // Encryption



            case 6: // Decryption



            case 7: // Exit System
               System.out.println("Exiting the system....Goodbye!");
               isActive = false;
               break;


            default:
               System.out.println("Your number is a mismatch; please choose a number from 1 to 7");
               optionNum = console.nextInt();
               break;






         }
      }
   }
}
