
import java.util.ArrayList;



public class Company
{
  private String name_of_company;
  private  ArrayList<Company_Branch> offices;
  
  Company(String name_of_company)
  {
      this.name_of_company=name_of_company;
      offices=new ArrayList<>();
  }
  
  public void addCompanyBranch(Company_Branch new_branch)
  {
      this.offices.add(new_branch);
  }
  
  public ArrayList<Company_Branch> getCompanyBranches()
  {
      return offices;
  }
    
}
