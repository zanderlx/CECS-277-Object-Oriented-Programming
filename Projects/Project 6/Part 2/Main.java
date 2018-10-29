// Lexzander Saplan - 014177252
// CECS 277 - Project 6 (Part 2)
public class Main {
    public static void main(String[] args) {
        // create four-element Payable array
        Payable[] payableObjects = new Payable[6];

        // populate array with objects that implement Payable
        payableObjects[ 0 ] = new Invoice("01234", "seat", 2, 375.00);
        payableObjects[ 1 ] = new Invoice( "56789", "tire", 4, 79.95 );
        payableObjects[ 2 ] = new HourlyEmployee( "John", "Smith", "111-11-1111", 12.50, 20);
        payableObjects[ 3 ] = new SalariedEmployee( "Lisa", "Barnes", "222-22-2222", 1200.00 );
        payableObjects[ 4 ] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
        payableObjects[ 5 ] = new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );

        System.out.println("Invoices and Employees processed polymorphically:\n" );
        // generically process each element in array payableObjects
        for ( Payable currentPayable : payableObjects )
        {
            // invokes toString to output the current employee
            //System.out.println(currentPayable.toString());
            // if the element is a BasePlusCommissionEmployee
            // downcast Employee reference to BasePlusCommissionEmployee reference calculate
            // and output the new base salary with 10%% increase is
            if (currentPayable instanceof BasePlusCommissionEmployee)
            {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) currentPayable;
                double oldSalary = bpce.getSalariedCommissionReward();
                bpce.setSalariedCommissionReward(1.10 * oldSalary);
                System.out.println(currentPayable.toString());
                System.out.println("New base salary with a 10% increase: $" + bpce.getSalariedCommissionReward());
                System.out.printf("Payment Due $%,.2f\n", currentPayable.getPaymentAmount());
            }
            // output currentPayable and its appropriate payment amount
            else {
                System.out.printf("%s \n%s: $%,.2f\n\n",
                        currentPayable.toString(), "Payment Due", currentPayable.getPaymentAmount());
            }
        }//endfor

        System.out.println("");
        // get type name of each object in employees array
        for ( int j = 0; j < payableObjects.length; j++ )
            System.out.printf( "Employee %d is a %s\n", j, payableObjects[j].getClass().getName());
    }
}
