import java.util.Scanner;
public class Encryption {
    static Scanner console = new Scanner(System.in); 
    public static void main(String[] args){
    

        //Default variables

        String PIN = "";



        // Setting the PIN by the user

        System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
        PIN = console.next();
        char first_num = PIN.charAt(0);

        // Check for wrong type input
        boolean Status = true;
        for (int i = 0; i < PIN.length(); i++)
            if (PIN.charAt(i) < '0' || PIN.charAt(i) > '9')
                Status = false;
            else
                Status = true;
        
                    
            

        while (first_num == '0' || PIN.length() != 4 || Status == false)
        {
           System.out.println("Enter a PIN of only 4 digits (First digit can't be 0): ");
           PIN = console.next(); 
           first_num = PIN.charAt(0);
        }








        // Show Display Menu and ask for the number





        System.out.println()
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
