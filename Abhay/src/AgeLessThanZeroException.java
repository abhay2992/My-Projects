public class AgeLessThanZeroException extends Exception
{
    int age;
    AgeLessThanZeroException(int a)
    {
        this.age=a;
    }
    
    public String toString()
    {
        return ("Age can't be Negative.");
    }
    
    
}
