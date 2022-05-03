package poe_lac_canbanapp;

import javax.swing.JOptionPane;

import java.util.Scanner;



//(----------------------------------------------------------------------------)



public class Worker
{
    private final int MAX_USERS = 5;
    Login users[] = new Login[MAX_USERS];                                       // ! EMPTY ! --storage
    private int numUsers = 0;  
    private int  currentLoggedUser = 0;                                         // count for how many users registered and stored in the array

   public void registerUser()                                                   //ask multiple question , so we will be getting input from ! console ! , thus we need the Scanner.
   {
       Scanner input = new Scanner(System.in);
       Login tempUser = new Login();                                               
       String userInput = "_";
       boolean valid = false;
       
        do
        {
            System.out.println("Enter new Username [<6 + _]:" );                //checking username
            if (checkEmptyNull(userInput))
            {
                userInput = input.next();

            if ((checkEmptyNull(userInput))) 
            {
                if (tempUser.checkUserName(userInput))
                {
                       valid = true;
                }
                
            }
                if(! valid)
                {
                    printError("Username is not correctly formated,"+           //POE error message
                    "\n please ensure that your username contains," + 
                    "\n a underscore and is no more than 5 characters" +
                    "\n in length.");
                }
            }
            
        }  while(!valid);
        tempUser.setUsername(userInput);
        
        
        
//(----------------------------------------------------------------------------) //checking password
        


        valid = false;
        do
        {
            System.out.println("Enter new Password [>8 + UPPPER + 0-9 + SPECIAL]:" ); //checking username
            userInput = input.next();
            if (checkEmptyNull(userInput))
            
            {
                  if ((checkEmptyNull(userInput))) 
                    {
                        if (tempUser.checkPasswordComplexity(userInput))
                        {
                               valid = true;
                        }

                    }
            if(! valid)
                {
                   printError("Password is not correctly formated,"+            //POE error message
                   "\n please ensure that your username contains," + 
                   "\n a underscore and is no more than 8 characters" +
                   "\n in length.");
                }
            }
            
        }  while(!valid);   
        
        tempUser.setPassword(userInput);                                     //set password , set name , set surname
        System.out.print("Enter FirstName :");
        tempUser.setName(input.next());
        System.out.print("Enter Surname :");
        tempUser.setSurname(input.next());
        
        users[numUsers] = tempUser; // assign temp to actual array
        numUsers++; //must must must uncrement
        
        
        
   }
    
   
   //(-------------------------------------------------------------------------)
   
   
   public void printError(String errorMsg)                                      //void = no return values //Error Message
   {
       JOptionPane.showMessageDialog(null,
               errorMsg, "ERROR", JOptionPane.ERROR_MESSAGE);
       
   }
   
   
   //(-------------------------------------------------------------------------)
    
   
   public boolean checkEmptyNull(String toCheck)
    {
        boolean valid = false;
            
        if ((toCheck != null) && (!toCheck.isEmpty()))                          //check to make sure strings are never empty nor null
                {
                    valid = true;
                }
        return valid;
        
    }
            
    //(-------------------------------------------------------------------------)
   
   
                                                                                //print menu with options for users
                                                                                //needs to return int which is valid (return int)
    public int printLoginMenu()
    {
        int selection = 0;                                                      //variable has been intialised at = 0
        boolean valid = false;
        String userInput = "";
        
        do
        {                                                                       //if user press "cancel" it returns a null
            userInput = JOptionPane.showInputDialog(
                    null,                       
                    "\tUserSelectMenu "
                    + "\n--------------"
                    + "\n\t1. Register User"
                    + "\n\t2. Login A User"
                    + "\n\t3. Quit Menu",
                    "CAN BAN APP",
                    JOptionPane.INFORMATION_MESSAGE);                           //no Parent window so we say null
            
            if (checkEmptyNull(userInput))                                      //parsing (evaluate and convert string into integer)(userInput --> selection)
            {
                selection = Integer.parseInt(userInput);
                
                if ((selection > 0) && (selection < 4 ))                        //range check between 1 and 3
                {
                    valid = true;
                }
            }
            
             if (!valid)
                {
                    printError("Input can only be 1 to 3");
                }
            
        } 
        while(!valid);                                                          //if valid then return selection 
        return selection;                                                       //returning int
    }
    
    public void loginUser()                                                            
    {
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        String username, password;
        
        System.out.println("-----------------------");
        System.out.print ("Please enter username : ");
        username = input.next();
        System.out.print ("Please enter Password : ");
        password = input.next();
        
        for (int count = 0; count < numUsers; count++)
        {
            if (users[count].getUsername().equals(username))
            {
                if (users[count].getPassword().equals(password))
                {
                    valid = true;
                     currentLoggedUser = count;                                 //record logged in users
                    break;
                }
            }
        }
       if(valid)
       {
          JOptionPane.showMessageDialog(null,
           "Welcome" + users[currentLoggedUser].getName()+ 
            ", " + users[currentLoggedUser].getSurname() +
            " it is great to see you again." , 
           "Login Succesfull", 
           JOptionPane.INFORMATION_MESSAGE);
          //part 2 here
       }
       else
       {
           printError("incorrect login details, Please try again");
       }
       
    }
    
    
    
    
//(----------------------------------------------------------------------------)
 
    public void mainThread()
    {
        int selection = 0;
        boolean quit = false;                                                   //presume that they doesnt want to quit
        
        do
        {
          selection = printLoginMenu();  
           switch (selection) 
           {
               case 1 : 
                        //register a user
                   registerUser();
                   break;
               case 2 :
                        //login user
                   loginUser();
                   break;
               default :
                        //quit
                   quit = true;
           }
           System.out.println("\n Num of Reg-Users:" + numUsers);
       
        }while (!quit);
        System.exit(0);
        
    }
   
}














































