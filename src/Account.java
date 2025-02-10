import java.util.Scanner;

public class Account implements AccInterface
{
    private double Balance;
    private String UserName;
    private long UserID = 0;
    private String Password;

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
        return UserName;
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
                    System.out.println("Username set: " + getUserName());
                    break;
                }
            }
            catch (InvalidUsernameE m)
            {
                System.out.println(m.getMessage());
            }
        }
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
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
                else
                {
                    Password = password;
                    System.out.println("Password set: " + getPassword());
                    break;
                }
            }
            catch (InvalidPasswordE m)
            {
                System.out.println(m.getMessage());
            }
        }
    }
}
