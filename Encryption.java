import java.util.Scanner;
public class Encryption {
    static Scanner console = new Scanner(System.in); 
    public static void main(String[] args){

        while(true){
        //Default variables

        String PIN = "0000";
        boolean Status = true;
        boolean Authenticated = true;
        boolean KeyIsValid = true;
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

        Status = true;
        for (int i = 0; i < PIN.length(); i++){

            if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9') {
                Status = false;
                break;
            }
        } 



        while (first_num == '0' || PIN.length() != 4 || Status == false)
        {
           System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
           PIN = console.next(); 
           first_num = PIN.charAt(0);

           Status = true;
           for (int i = 0; i < PIN.length(); i++){

               if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9') {
                   Status = false;
                   break;
               }
           }
        }








        // Show Display Menu and ask for the number


        System.out.println("Please choosen number from the following options: \n 1. Set/Change the key \n 2. Display Key \n 3. Enter a sentence \n 4. Display Current Sentence \n 5. Encryption \n 6. Decryption \n 7. Exit System");
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
                do {
                    System.out.println("Enter the original key: ");
                    OriginalKey_Attempt = console.next();
                    System.out.println("Enter the code key: ");
                    CodeKey_Attempt = console.next();
                    KeyIsValid = true;
                    if (OriginalKey_Attempt.length() != CodeKey_Attempt.length()) {
                        System.out.println("The keys are not the same length");
                        KeyIsValid = false;
                        break;

                    }
                    if(KeyIsValid){
                        for(int j=0; j<CodeKey_Attempt.length(); j++) {
                            char ch=CodeKey_Attempt.charAt(j);
                            if(OriginalKey_Attempt.indexOf(ch) == -1){
                                System.out.println("Validation failed: Character " + ch + " from code key is not in the original key");
                                KeyIsValid = false;
                                break;
                            }
                        }
                    }
                    if(KeyIsValid){
                        OriginalKey = OriginalKey_Attempt;
                        CodeKey = CodeKey_Attempt;
                        System.out.println("The keys have been set");
                        CurrentSentence=null;
                    } else {
                        System.out.println("The keys validation failed, enter 'R' if you want to retry or any other key to return to the main menu");
                        String retry = console.next();
                        if(!retry.equals("R")){
                            break;
                        }
                    }
                } while(!KeyIsValid);
                break;


            case 2: // Display Key : needs a PIN    
                break;


            case 3: // Enter a sentence
                break;


            case 4: // Display Current Sentence
                break;


            case 5: // Encryption
                break;



            case 6: // Decryption
                break;



            case 7: // Exit System
                System.out.println("Exiting the system....Goodbye!");
                isActive = false;
                break;


            default:
                System.out.println("Your number is a mismatch; please choose a number from 1 to 7");
                optionNum = console.nextInt();

        }
        if (!isActive) break;
        }
    }
}