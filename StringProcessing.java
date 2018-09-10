package StringProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author liuyang
 */
public class StringProcessing {
    private static String[] records;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        records = new String[100];
        
        try {
            Scanner reader = new Scanner(new File(args[0]));
            
            int currentIndex = 0;
            while (reader.hasNext()){
                
                  String[] line = reader.nextLine().split(",");
                  
                  String firstName = line[0];
                  String lastName = line[1];
                  String age = line[2];
                  String gender = line[3];
                  String phoneNumber = line[4];
                  String email = line[5];
                  
               if(!validateName(firstName) || !validateName(lastName)) {
                    continue;
                }
                if(!validateGender(gender)) {
                    continue;
                }
                if(!validateAge(age)) {
                    continue;
                }
                if(!validatePhoneNumber(phoneNumber)) {
                    continue;
                }
                if(!validateEmail(email)) {
                    continue;
                }
                  
                  
                  
     records [currentIndex] = String.format("%-20s%-20s%-10s%-4s%-15s%-20s", firstName, lastName, gender, age, phoneNumber, email);
              currentIndex++;
                  currentIndex ++;
              
            }
        
        } 
        catch (FileNotFoundException ex){
            System.err.println("Could not find input file");
        }
        // TODO code application logic here
    for(int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
        
        return;
        
    }
    
    public static boolean validateName(String name) {
        
        char[] nameArr = name.toCharArray();
        
        for(int i = 0; i < name.length(); i++ ) {
            if(!Character.isAlphabetic(nameArr[i]) && nameArr[i] != ' ') {
                System.out.println("ERROR: INVALID NAME, INVALID CHARACTER FOUND - " + name);
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean validateGender(String gender) {
        
        gender = gender.replaceAll(" ", ""); //gender has a space in the front of it when read.
        
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            return true;
        }
        else {
            System.out.println("ERROR: INVALID GENDER, INVALID GENDER VALUE - " + gender);
            return false;
        }
    }
    
    public static boolean validateAge(String age) {
        
        if(age.equals("")) {
            System.out.println("ERROR: INVALID AGE, AGE NOT A NUMBER - " + age);
            return false;
        }
        int ageInt = Integer.parseInt(age);
        
        if(1 <= ageInt && ageInt <= 130) {
            return true;
        }

        System.out.println("ERROR: INVALID AGE, AGE OUT OF RANGE - " + age);
        return false;
        
    }
    
    //TODO: CHECK THIS METHOD
    public static boolean validatePhoneNumber(String phoneNumber) {
        
        char[] phoneNumberArr = phoneNumber.toCharArray();
        int countDigits = 0;
        
        for(int i = 0; i < phoneNumberArr.length; i++) {
            if(Character.isDigit(phoneNumberArr[i])) {
                countDigits += 1;
            }
        }
        
        if(countDigits != 10) {
           System.out.println("ERROR: INVALID PHONE NUMBER - " + phoneNumber);
           return false;
        } 
       
        return true;
    }
    
    public static boolean validateEmail(String email) {
        
        char[] emailArr = email.toCharArray();
        boolean containsAtSymbol = false;
        
        if(!Character.isLetter(emailArr[0])) {
            System.out.println("ERROR: INVALID EMAIL,FIRST LETTER NOT LETTER - " + email);
            return false;
        }
        
        for(int i = 0; i < emailArr.length; i++) {
            
            if(emailArr[i] == '@') {
                containsAtSymbol = true;
                continue;
            }
            
            if(!Character.isLetterOrDigit(emailArr[i]) && emailArr[i] != '.') {
                System.out.println("ERROR: INVALID EMAIL - " + email);
                return false;
            }
            else if(emailArr[i] == '.') {
                continue;
            }
            
            
        }
        
        return true;
    }
}
