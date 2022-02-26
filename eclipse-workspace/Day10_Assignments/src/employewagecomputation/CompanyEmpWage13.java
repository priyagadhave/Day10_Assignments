package employewagecomputation;

//Store the Daily Wage along with the Total Wage

import java.util.ArrayList;
import java.util.HashMap;

interface IEmpWageUC13 {
	    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

	    public void calculateTotalWage();
	    }
	class CompanyEmpWage13 {
	    // instance constants
	    final String COMPANY_NAME;
	    final int WAGE_PER_HR;
	    final int MAX_WORKING_DAYS;
	    final int MAX_WORKING_HRS;
	    // instance variable
	    int totalEmpWage;

	    CompanyEmpWage13(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
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
	    public String toString()
	    {
	        System.out.println("Details of " + COMPANY_NAME + " employee");
	        System.out.println("-----------------------------------------------------");
	        System.err.println("Wage per hour:" + WAGE_PER_HR);
	        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
	        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
	        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
	    }
	}

	class EmpWageUC13 implements IEmpWageUC13 {
	    // class constants
	    public static final int PART_TIME = 1;
	    public static final int FULL_TIME = 2;
	    // instance variables
	    ArrayList<CompanyEmpWage13> companies;
	    HashMap<String, Integer> totalEmpWages;

	    public EmpWageUC13()
	    {
	        companies = new ArrayList<>();
	        totalEmpWages = new HashMap<>();
	    }

	    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
	    {
	        CompanyEmpWage13 company = new CompanyEmpWage13(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
	        companies.add(company);
	        totalEmpWages.put(companyName,0);
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
	        for (CompanyEmpWage13 company : companies)
	        {
	            int totalWage = calculateTotalWage(company);
	            company.setTotalEmployeeWage(totalWage);
	            System.out.println(company);
	        }
	    }

	    int calculateTotalWage(CompanyEmpWage13 CompanyEmpWage13)
	    {
	        System.out.println("Computation of total wage of " + CompanyEmpWage13.COMPANY_NAME + " employee");
	        System.out.println("-----------------------------------------------------");
	        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

	        int workingHrs, totalWage = 0;
	        for (int day = 1, totalWorkingHrs = 0; day <= CompanyEmpWage13.MAX_WORKING_DAYS
	                && totalWorkingHrs <= CompanyEmpWage13.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
	        {
	            int empType = generateEmployeeType();
	            workingHrs = getWorkingHrs(empType);
	            int wage = workingHrs * CompanyEmpWage13.WAGE_PER_HR;
	            totalWage += wage;
	            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
	        }
	        totalEmpWages.put(CompanyEmpWage13.COMPANY_NAME, totalWage);
	        return totalWage;
	    }

	    void printTotalEmpWages()
	    {
	        System.out.println("The Companies and their total Employee Wages are:");
	        for (String companyName : totalEmpWages.keySet())
	        {
	            System.out.println(companyName + ": " + totalEmpWages.get(companyName));
	        }

	    }

	    public static void main(String args[])
	    {
	    	EmpWageUC13 employeeWageComputation = new EmpWageUC13();
	        employeeWageComputation.addCompany("Flipkart", 4, 30, 100);
	        employeeWageComputation.addCompany("Amazon", 5, 40, 170);
	        employeeWageComputation.addCompany("D-Mart", 19, 10, 150);
	        employeeWageComputation.calculateTotalWage();
	        employeeWageComputation.printTotalEmpWages();
	    }
	}
