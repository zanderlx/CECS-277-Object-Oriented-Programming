public class BaseCommissionEmployee extends CommissionEmployee{

    private double baseSalary;

    public BaseCommissionEmployee() {
        super();
        this.baseSalary = 0;

    }

    public BaseCommissionEmployee(String firstName, String lastName, int SSN, double commissionRate, int gross, double baseSalary) {
        super(firstName, lastName, SSN, commissionRate, gross);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "BaseCommissionEmployee{" +
                super.toString() +
                "}";
    }
}
