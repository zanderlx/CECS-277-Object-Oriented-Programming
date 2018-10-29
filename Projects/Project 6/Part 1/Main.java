// Lexzander Saplan - 014177252
// CECS 277 - Project 6 (Part 1) - Payroll System Modification
public class Main
{
    public static void main(String[] args)
    {
        // create subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
        HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06 );
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
        PieceWorker pieceWorker = new PieceWorker("Lexzander", "Saplan", "555-55-5555", 50, 12.50);

        System.out.println( "Employees processed individually:\n" );
        System.out.printf( "%s\n%s: $%,.2f\n\n",salariedEmployee, "earned", salariedEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n", hourlyEmployee, "earned", hourlyEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n", commissionEmployee, "earned", commissionEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings() );
        System.out.printf( "%s\n%s: $%,.2f\n\n", pieceWorker, "earned", pieceWorker.earnings() );

        // create four-element Employee array
        Employee[] employees = new Employee[5];
        // initialize array with Employees objects that you declared above
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        System.out.println( "\nEmployees processed polymorphically:\n" );
        // generically process each element in array employees
        for ( Employee currentEmployee : employees )
        {
            // invokes toString to output the current employee
            System.out.println(currentEmployee.toString());
            // if the element is a BasePlusCommissionEmployee
            // downcast Employee reference to BasePlusCommissionEmployee reference calculate
            // and output the new base salary with 10%% increase is
            if (currentEmployee instanceof BasePlusCommissionEmployee)
            {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) currentEmployee;
                double oldSalary = bpce.getSalariedCommissionReward();
                bpce.setSalariedCommissionReward(1.10 * oldSalary);
                System.out.println("New base salary with a 10% increase: $" + bpce.getSalariedCommissionReward());
            }
            //else, just print the currentEmployee earnings
            System.out.printf("currentEmployee earnings: $%,.2f%n\n", currentEmployee.earnings());
        } //end for

        System.out.println("");
        // get type name of each object in employees array
        for ( int j = 0; j < employees.length; j++ )
            System.out.printf( "Employee %d is a %s\n", j, employees[j].getClass().getName());
    }
}
