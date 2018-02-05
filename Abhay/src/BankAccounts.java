import java.io.*;
public class BankAccounts 
{
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(isr);
    int accountnumber; 
    String accountname;
    float balance;
    BankAccounts()throws IOException
    {   
        System.out.print("Enter your Account Number: ");
        accountnumber= Integer.parseInt(br.readLine());
        System.out.print("Enter your Account Name: ");
        accountname=br.readLine();
        balance=0; //Why not error.. as balance is float.. i must write 0.0f then why not error..
    }
    
    BankAccounts(int acc_no, String acc_name, float bal)throws IOException
    {   
        accountnumber=acc_no;
        accountname=acc_name;
        balance=bal;
    }  
    void getBalance()
    {
        System.out.println("Account Number: "+accountnumber+"\tAccount Name: "+accountname+"\tBalance: "+balance);
    }
    void withdraw() throws IOException
    {
        System.out.print("Enter the amount to be withdrawn: ");
        float amt=Float.parseFloat(br.readLine());
        float c= balance-amt;
        if(c<=1500)
            System.out.println("Minimum Balance Condition.. Amount cannot be Withdrawn..!!!");
        else
        {
            balance=c;
            System.out.println("Amount Withdrawn: "+amt+"\tAmount left: "+balance);
        }
    }
    void deposit() throws IOException
    {
        System.out.print("Enter the amount to be deposited: ");
        float amt=Float.parseFloat(br.readLine());
        balance=balance+amt;
        System.out.println("Amount Deposited: "+amt+"\tTotal Balance: "+balance);       
    }
            
    public static void main(String[] args)throws IOException 
    {
        InputStreamReader xy=new InputStreamReader(System.in); //I have to write these two statements again.. is there any other way..
        BufferedReader ab=new BufferedReader(xy);
        BankAccounts obj=new BankAccounts(125,"qwerty",2000);
        boolean a=true;
        while(a)
        {
            System.out.print("Your Options are:\n1. Check Balance.\n2. Deposit Amount.\n3. Withdraw Amount.\n4. Exit.\nEnter your choice: ");
            int x=Integer.parseInt(ab.readLine());
            switch(x)
            {
                case 1:
                    obj.getBalance();
                    break;
                case 2:
                    obj.deposit();
                    break;
                case 3:
                    obj.withdraw();
                    break;
                case 4:
                    a=false;
                    break;
                default:
                    System.out.println("Invalid Input..!!!");
            }
        }
    }
}
