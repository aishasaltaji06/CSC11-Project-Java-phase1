import java.util.Scanner;
public class Encryption {
   static Scanner console = new Scanner(System.in); 
   public static void main(String[] args){


     //Default variables

      String PIN = "0000";
      boolean Status = true;
      boolean Authenticated = true;
      boolean KeyIsValid=false;
      String OriginalKey_Attempt = null;
      String CodeKey_Attempt = null;
      String OriginalKey = null;
      String CodeKey = null;
      String CurrentSentence = null;
      String pinAttempt = null;
      boolean isActive = true;
      char ch;
      char first_num;                 



      while (true)
      {
         System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
         PIN = console.next(); 
         first_num = PIN.charAt(0);
         //check first character and length
         if(first_num!='0' & PIN.length()==4){
         //check all are numbers
            for (int i = 0; i < PIN.length(); i++){
               if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9'){
                  Status = false;
                  break;
               }
               else
                  Status = true;
            }
            if(Status)
               break;
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
               //input key and check its validation
               System.out.println("Enter the original key: ");
               OriginalKey_Attempt = console.next();
               System.out.println("Enter the code key: ");
               CodeKey_Attempt = console.next();
               if (OriginalKey_Attempt.length() != CodeKey_Attempt.length()) {
                  System.out.println("The keys are not the same length");
                  KeyIsValid=false;
                  break;

               }
               for(int j=0; j<CodeKey_Attempt.length(); j++){
                  ch=CodeKey_Attempt.charAt(j);
                  if(OriginalKey_Attempt.indexOf(ch) == -1){
                     System.out.println("Validation failed: Character " + ch + " from code key is not in the original key");
                     KeyIsValid=false;
                     break;
                  }
                  else{ 
                  KeyIsValid=true;
                  continue;}
               }

               if(KeyIsValid==true)
               {
                  OriginalKey = OriginalKey_Attempt;
                  CodeKey = CodeKey_Attempt;
                  System.out.println("The keys have been set");
               //check if required to keep or only demonstrate the special case
                  CurrentSentence=null;
               }
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
               if(OriginalKey!=null||CodeKey!=null){
                  System.out.printf("Your original key is: %s %nYour code key is: %s%n",OriginalKey,CodeKey);
                  break;}
               else {System.out.println("The key has not been set, returning to main menu");
                  break;}


            case 3: // Enter a sentence
               System.out.println("Please enter your sentence");
               console.nextLine();
               CurrentSentence=console.nextLine();
               break;


            case 4: // Display Current Sentence, need PIN
               if(CurrentSentence!=null){
               System.out.printf("your current sentence is: %s.%n ",CurrentSentence);
                break;}
                else {
                System.out.println("you have not entered a sentence yet,returning to main menu.");
                break;}


            case 5: // Encryption
               if (OriginalKey == null || CodeKey == null) {
                  System.out.println("The keys have not been set, Please set the keys first.");
                  break;
               }

               if (CurrentSentence == null) {
                  System.out.println("The sentence has not been entered, Please enter a sentence first.");
                  break;
               }
               String encryptedSentence = "";
               for (int i = 0; i < CurrentSentence.length(); i++) {
                  char currentChar = CurrentSentence.charAt(i);
                  int index = OriginalKey.indexOf(currentChar);
                  if (index != -1) {
                     encryptedSentence += CodeKey.charAt(index);
                  } else {
                     encryptedSentence += currentChar;
                  }
               }
               System.out.println("Encrypted Sentence: " + encryptedSentence);
               break;
               



            case 6: // Decryption
               if (OriginalKey == null || CodeKey == null) {
                  System.out.println("The keys have not been set, Please set the keys first (option 1).");
                  break;
               }
               if (CurrentSentence == null) {
                  System.out.println("The sentence has not been entered, Please enter a sentence first (option 3).");
                  break;
               }
               String decryptedSentence = "";
               for (int i = 0; i < CurrentSentence.length(); i++) {
                  char currentChar = CurrentSentence.charAt(i);
                  int index = CodeKey.indexOf(currentChar);
                  if (index != -1) {
                     decryptedSentence += OriginalKey.charAt(index);
                     }
                  else {
                     decryptedSentence += currentChar;
                  }
               }
               System.out.println("Decrypted Sentence: " + decryptedSentence);
               break;
               
                  
                  



            case 7: // Exit System
               System.out.println("Exiting the system....Goodbye!");
               isActive = false;
               console.close();
               System.exit(0);
               break;


            default:
               System.out.println("Your number is a mismatch; please choose a number from 1 to 7");
               optionNum = console.nextInt();
               break;






         }
      }
   }
}
