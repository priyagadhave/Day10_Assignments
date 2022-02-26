package employewagecomputation;


//Ability to get the Total Wage when queried by Company
//Create Method in EmpWageBuilder to get total wage by Company

import java.util.ArrayList;
import java.util.HashMap;

interface IEmployeeWageComputation {
 public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

 public void calculateTotalWage();

 public int getTotalEmpWage(String companyName);
}

class CompanyEmpWage14 {
 // instance constants
 final String COMPANY_NAME;
 final int WAGE_PER_HR;
 final int MAX_WORKING_DAYS;
 final int MAX_WORKING_HRS;
 // instance variable
 int totalEmpWage;

 //parameterized constructor to get and set the values
 CompanyEmpWage14(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
 {
     COMPANY_NAME = companyName;
     WAGE_PER_HR = wagePerHr;
     MAX_WORKING_DAYS = maxWorkingDays;
     MAX_WORKING_HRS = maxWorkingHrs;
     totalEmpWage = 0;
 }

 void setTotalEmployeeWage(int totalEmpWage) 
 {
     this.totalEmpWage = totalEmpWage;
 }

 @Override
 public String toString() {
     System.out.println("Details of " + COMPANY_NAME + " employee");
     System.out.println("-----------------------------------------------------");
     System.err.println("Wage per hour:" + WAGE_PER_HR);
     System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
     System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
     return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
 }
}

 class EmpWageUC14 implements IEmployeeWageComputation 
{
 // class constants
 public static final int PART_TIME = 1;
 public static final int FULL_TIME = 2;
 // instance variables

 //references of CompanyEmpWage14 objects are stored in arraylist
 ArrayList<CompanyEmpWage14> companies;
 //companyname is mapped with total employee wage
 HashMap<String, Integer> totalEmpWages;

 //defalut constructor
 public EmpWageUC14() 
 {
     companies = new ArrayList<>();
     totalEmpWages = new HashMap<>();
 }

 //it creats CompanyEmpWage14 objects and add to the arraylist
 public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) 
 {
     CompanyEmpWage14 company = new CompanyEmpWage14(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
     companies.add(company);
     totalEmpWages.put(companyName, 0);
 }

 int generateEmployeeType() 
 {
     return (int) (Math.random() * 100) % 3;
 }

 int getWorkingHrs(int empType) 
 {
     switch (empType) 
     {
         case FULL_TIME:
             return 8;
         case PART_TIME:
             return 4;
         default:
             return 0;
     }
 }

 public void calculateTotalWage() 
 {
     for (CompanyEmpWage14 company : companies) 
     {
         int totalWage = calculateTotalWage(company);
         company.setTotalEmployeeWage(totalWage);
         System.out.println(company);
     }
 }

 int calculateTotalWage(CompanyEmpWage14 CompanyEmpWage14) 
 {
     System.out.println("Computation of total wage of " + CompanyEmpWage14.COMPANY_NAME + " employee");
     System.out.println("-----------------------------------------------------");
     System.out.printf("%4s\t%4s\t%2s\t%4s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

     int workingHrs, totalWage = 0;
     for (int day = 1, totalWorkingHrs = 0; day <= CompanyEmpWage14.MAX_WORKING_DAYS
             && totalWorkingHrs <= CompanyEmpWage14.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) 
     {
         int empType = generateEmployeeType();
         workingHrs = getWorkingHrs(empType);
         int wage = workingHrs * CompanyEmpWage14.WAGE_PER_HR;
         totalWage += wage;
         System.out.printf("%4d\t%5d\t%10d\t%10d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
     }
     totalEmpWages.put(CompanyEmpWage14.COMPANY_NAME, totalWage);
     return totalWage;
 }

 public int getTotalEmpWage(String companyName) 
 {
     return totalEmpWages.get(companyName);
 }

 public static void main(String args[]) 
 {
 	EmpWageUC14 employeeWageComputation = new EmpWageUC14();
     employeeWageComputation.addCompany("Flipkart", 4, 30, 100);
     employeeWageComputation.addCompany("Amazon", 5, 40, 170);
     employeeWageComputation.addCompany("D-Mart", 19, 10, 150);
     employeeWageComputation.calculateTotalWage();
     String query = "Flipkart";
     int totalWage = employeeWageComputation.getTotalEmpWage(query);
     System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
 }
}