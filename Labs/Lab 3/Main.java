public class Main {

    public static void main(String[] args) {

        CommissionEmployee ce = new CommissionEmployee();
        CommissionEmployee ce2 = new CommissionEmployee();

        System.out.println(ce.hashCode());
        System.out.println(ce2.hashCode());


        System.out.println(ce.getClass());
    }

}
