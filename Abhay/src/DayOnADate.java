// This is made to be run on only cmd and notepad.. here we can input date from the user..
public class DayOnADate
{
    public static void main(String args[])
    {
	int d=Integer.parseInt(args[0]);
	int m=Integer.parseInt(args[1]);
	int y=Integer.parseInt(args[2]);
	int x=y%400;
	int y0=(x/100)*5;      //
	int y1=x%100;
	int y2;		      
	
	if(y1%4==0)
	  y2=(y1/4)-1;
	else
	  y2=y1/4;
			
	int y3=y2*2;	    //

	int y4=(y1-1)-y2;   //
	int i=0;		    //
	if(y1%4==0)
	{
	   if(m>2)
	      i=1;
	   else 
	       i=0;   
	}	
	
	int sum=0;	    //
	for(int j=1;j<m;j++)
	{
	   if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)
	      sum=sum+3;
	   else if(j==4||j==6||j==9||j==11)
	      sum=sum+2;
	}
	
	int t= (d+y0+y3+y4+i+sum)%7;
        System.out.println(t);
	
    }
}