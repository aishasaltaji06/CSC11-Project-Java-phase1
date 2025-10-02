import java.util.Scanner;
public class Encryption {
    static Scanner console = new Scanner(System.in); 
    public static void main(String[] args){
    

        //Default variables

        int PIN = 0000;



        // Setting the PIN by the user

        System.out.println("Enter a PIN of 4 digits (First digit can't be 0): ");
        PIN = console.nextInt();
        String PIN_as_string = PIN + "";
        char first_num = PIN_as_string.charAt(0);

        while (first_num == '0' || PIN_as_string.length() != 4 )
        {
           System.out.println("Enter a PIN of 4 digits (First digit can't be 0): ");
           PIN = console.nextInt(); 
        }








        // Show Display Menu and ask for the number






        int optionNum = console.nextInt();

        // Cases:

        switch(optionNum){

            case 1: // Set/Change the key


            case 2: // Display Key


            case 3: // Enter a sentence


            case 4: // Display Current Sentence


            case 5: // Encryption



            case 6: // Decryption



            case 7: // Exit System


            default:
                System.out.println("Your number is a mismatch; please choose a number from 1 to 7");
                optionNum = console.nextInt();






        }
















    
    }
}
