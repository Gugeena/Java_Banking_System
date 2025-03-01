import java.io.*;
import java.util.Scanner;

public class Account implements AccInterface
{
    private double Balance;
    private String UserName;
    private long UserID = 0;
    private String Password;

    public void CheckIn()
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Login or SignUp");
        String line = scn.nextLine();
        if(line.equals("Login"))
        {
            LogIn();
        }
        if(line.equals("SignUp"))
        {
            AccountCreation();
        }
    }

    public void LogIn()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Username:");
            String line = scanner.nextLine();
            System.out.println("Enter your Password:");
            String line1 = scanner.nextLine();
            if (line.equals(getUserName()) && line1.equals(getPassword()))
            {
                System.out.println("LoginSuccesfull");
            }
            else
            {
                throw new InvalidUserE("User not found, try again");
            }
        }
        catch (InvalidUserE e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void AccountCreation()
    {
       setUserName("");
       setPassword("");
    }
    public double getBalance()
    {
        return Balance;
    }

    public void setBalance(double balance)
    {
        Balance = balance;
    }

    public String getUserName()
    {
        try
        {
            FileReader filereader = new FileReader("C:\\Users\\User\\Documents\\Username.txt");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line = bufferedReader.readLine();
            if(line.isEmpty())
            {
                throw new InvalidPasswordE("Username not found");
            }
            bufferedReader.close();
            return line;
        }
        catch (IOException | InvalidPasswordE e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }

    public String getPassword()
    {
        try
        {
            FileReader filereader = new FileReader("C:\\Users\\User\\Documents\\Password.txt");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line = bufferedReader.readLine();
            if(line.isEmpty())
            {
                throw new InvalidPasswordE("Password not found");
            }
            bufferedReader.close();
            return line;
        }
        catch (IOException | InvalidPasswordE e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public void setUserName(String userName)
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.println("Enter your Username: ");
                userName = scanner.nextLine();
                if(userName.isEmpty())
                {
                    throw new InvalidUsernameE("Username cant be blank, Start Over");
                }
                else
                {
                    UserName = userName;
                    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\User\\Documents\\Username.txt");
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    bufferedOutputStream.write(userName.getBytes());
                    bufferedOutputStream.close();
                    System.out.println("Username set: " + userName);
                    break;
                    //HERE
                }
            }
            catch (InvalidUsernameE | IOException m)
            {
                System.out.println(m.getMessage());
            }
        }
    }

    public void setPassword(String password)
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.println("Enter your Password: ");
                password = scanner.nextLine();
                if(password.isEmpty())
                {
                    throw new InvalidPasswordE("Password cant be blank, Start Over");
                }
                else if(password.length() < 8)
                {
                    throw new InvalidPasswordE("Password must be or over 8 characters");
                }
                else
                {
                    Password = password;
                    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\User\\Documents\\Password.txt");
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    bufferedOutputStream.write(password.getBytes());
                    bufferedOutputStream.close();
                    System.out.println("Password set: " + getPassword());
                    break;
                }
            }
            catch (InvalidPasswordE | IOException m)
            {
                System.out.println(m.getMessage());
            }
        }
    }
}
