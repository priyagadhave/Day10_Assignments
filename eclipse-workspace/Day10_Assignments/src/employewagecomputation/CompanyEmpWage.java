package employewagecomputation;


//Ability to manage Employee Wage of multiple companies
//Note: 1) Refactor to have one EmpWageBuilder to manage for Wage for multiple Company
//2) Create CompanyEmpWage class and let EmpWageBuilder has array of many Company EmpWage Object
	class CompanyEmpWage{
	    // instance constants
	    final String COMPANY_NAME;
	    final int WAGE_PER_HR;
	    final int MAX_WORKING_DAYS;
	    final int MAX_WORKING_HRS;
	    // instance variable
	    int totalEmpWage;

	    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
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

	 class EmpWageUC10 {
	    // class constants
	    public static final int PART_TIME = 1;
	    public static final int FULL_TIME = 2;
	    // instance variables
	    int noOfCompanies, index;
	    CompanyEmpWage[] companies;

	    public EmpWageUC10(int noOfCompanies)
	    {
	        this.noOfCompanies = noOfCompanies;
	        companies = new CompanyEmpWage[noOfCompanies];
	        index = 0;
	    }

	    void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
	    {
	        companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
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

	    void calculateTotalWage()
	    {
	        for (CompanyEmpWage company : companies)
	        {
	            int totalWage = calculateTotalWage(company);
	            company.setTotalEmployeeWage(totalWage);
	            System.out.println(company);
	        }
	    }

	    int calculateTotalWage(CompanyEmpWage companyEmpWage)
	    {
	        System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");
	        System.out.println("-----------------------------------------------------");
	        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

	        int workingHrs, totalWage = 0;
	        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
	                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
	        {
	            int empType = generateEmployeeType();
	            workingHrs = getWorkingHrs(empType);
	            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
	            totalWage += wage;
	            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
	        }
	        return totalWage;
	    }
	    public static void main(String args[])
	    {
	    	EmpWageUC10 employeeWageComputation = new EmpWageUC10(3);
	        employeeWageComputation.addCompany("Flipkart", 4, 30, 100);
	        employeeWageComputation.addCompany("Amazon", 5, 40, 170);
	        employeeWageComputation.addCompany("D-Mart", 9, 10, 70);
	        employeeWageComputation.calculateTotalWage();
	    }
	}