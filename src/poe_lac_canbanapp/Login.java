package poe_lac_canbanapp;                                                          


public class Login
{                                                                               //Creating strings for each string that will be populated with words or values.
    
    private String name = "";
    private String surname = "";
    private String username = "";
    private String password = "";
    
    private final int MAX_USERNAME = 5;                                         //"final" value cant change , finals = constants.
    private final int MIN_PASSWORD = 8;
    private final String UNDERSCORE = "_";
    private final String SPECIAL = "!@#$%^&*()-+{}[]|\\;:?.,<>";
    
    
    
    //(------------------------------------------------------------------------)
    
    
    public boolean checkUserName(String toCheck)                                //POE requires use of boolean here
    {
        boolean valid = false;
        if (toCheck.length() <= MAX_USERNAME )                                  //length check for less then opr equal to username length peramiters
        {
            if (toCheck.contains(UNDERSCORE))
                {
                    valid = true;
                }
        }     
    return valid;
    }
   
    
    
    //(------------------------------------------------------------------------)
    
    
    public boolean checkUpper(String toCheck)                                   //copy paste + modify from checkDigit
    {
        boolean valid = false;
        
        for(int count = 0; count < toCheck.length(); count ++)
        {  
            if(Character.isUpperCase(toCheck.charAt(count)))
            {
                {
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }
    
    
    
    
    //(------------------------------------------------------------------------)
    
    
    
    public boolean checkDigit(String toCheck)                                   //checks for digits
    {
        boolean valid = false;
        
        for(int count = 0; count < toCheck.length(); count ++)
        {  
            if(Character.isDigit(toCheck.charAt(count)))
            {
                {
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }
    
    
    
    //(------------------------------------------------------------------------)
  
    
    
    public boolean checkSPECIAL(String toCheck)                                 //checks for SPECIALS
    {
        boolean valid = false;
        
        for(int count = 0; count < SPECIAL.length(); count++)
        {  
            String str = Character.toString(SPECIAL.charAt(count));
            if (toCheck.contains (str))
            {
                {
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }
    
    
    
    //(------------------------------------------------------------------------)
    
    
    
    public boolean checkPasswordComplexity(String toCheck)                      //runs through all modules and if all come back as valid = true ,  
    {                                                                           //a valid will be returned in passwordcomplexity to turn boolean to true.
        boolean valid = false;
        if (toCheck.length() >= MIN_PASSWORD)
        {
            if ((checkDigit (toCheck)) && (checkUpper (toCheck)))
            {
                if (checkSPECIAL (toCheck))
                {
                  valid = true;  
                }
            } 
        }
        return valid;
    }
    
  
    
    
   //(-------------------------------------------------------------------------)
     
    
                                                                                //getters and setter (mutaters and accesseros)
    public String getName()                                                     //insert code , getters and setters.
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
}
