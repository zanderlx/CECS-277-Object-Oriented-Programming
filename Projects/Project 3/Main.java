public class Main {

    public static void main(String[] args){
        // Vehicle - Car - Truck
        Vehicle vehicleTruck = new Truck(2, "Red");
        Car carTruck = new Truck(2, "Orange");
        Truck truck = new Truck(2, "Yellow");

        // Vehicle - Car - Van
        Vehicle vehicleVan = new Van(4, "Green");
        Car carVan = new Van(4, "Blue");
        Van van = new Van(4, "Violet");

        // Vehicle - Boat - Sailboat
        Vehicle vehicleSailBoat = new Sailboat(3, "Purple");
        Boat boatSailBoat = new Sailboat(3, "Indigo");
        Sailboat sailboat = new Sailboat(3, "Magenta");

        // Vehicle - Boat - Yacht
        Vehicle vehicleYacht = new Yacht(20, "Cyan");
        Boat boatYacht = new Yacht(20, "Pink");
        Yacht yacht = new Yacht(20, "Turquoise");

        // Vehicle - Aircraft - Helicopter
        Vehicle vehicleHelicopter = new Helicopter(6, "Brown");
        Aircraft aircraftHelicopter = new Helicopter(6, "Black");
        Helicopter helicopter = new Helicopter(6, "Gray");

        // Vehicle - Aircraft - Blimp
        Vehicle vehicleBlimp = new Blimp(30, "Gold");
        Aircraft aircraftBlimp = new Blimp(30, "Silver");
        Blimp blimp = new Blimp(30, "White");

        // Testing each object created with toString()
        System.out.println("vehicleTruck");
        /* vehicleTruck.setNumOfPassengers(2);
           carTruck.setNumOfPassengers(2);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        truck.setNumOfPassengers(2); // This works because the method exists in the truck object
        vehicleTruck.accelerate(3);
        carTruck.accelerate(5);
        carTruck.changeGear(3);
        truck.accelerate(10);
        truck.changeGear(5);
        System.out.println(vehicleTruck.toString());
        System.out.println("\ncarTruck");
        System.out.println(carTruck.toString());
        System.out.println("\nTruck");
        System.out.println(truck.toString() + "\n");

        /* vehicleVan.setNumOfPassengers(3);
           carVan.setNumOfPassengers(3);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        System.out.println("vehicleVan");
        van.setNumOfPassengers(3); // This works because the method exists in the van object
        carVan.accelerate(5);
        System.out.println(vehicleVan.toString());
        System.out.println("\ncarVan");
        System.out.println(carVan.toString());
        System.out.println("\nVan");
        System.out.println(van.toString() + "\n");

        /* vehicleSailBoat.setNumOfPassengers(4);
           boatSailBoat.setNumOfPassengers(4);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        System.out.println("vehicleSailBoat");
        sailboat.setNumOfPassengers(4); // This works because the method exists in the sailboat object
        System.out.println(vehicleSailBoat.toString());
        System.out.println("\nboatSailBoat");
        System.out.println(boatSailBoat.toString());
        System.out.println("\nSailboat");
        System.out.println(sailboat.toString() + "\n");

        /* vehicleYacht.setNumOfPassengers(5);
           boatYacht.setNumOfPassengers(5);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        System.out.println("vehicleYacht");
        yacht.setNumOfPassengers(5); // This works because the method exists in the yacht object
        System.out.println(vehicleYacht.toString());
        System.out.println("\nboatYacht");
        System.out.println(boatYacht.toString());
        System.out.println("\nYacht");
        System.out.println(yacht.toString() + "\n");

        /* vehicleHelicopter.setNumOfPassengers(6);
           aircraftHelicopter.setNumOfPassengers(6);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        System.out.println("vehicleHelicopter");
        helicopter.setNumOfPassengers(6); // This works because the method exists in the helicopter object
        System.out.println(vehicleHelicopter.toString());
        System.out.println("\naircraftHelicopter");
        System.out.println(aircraftHelicopter.toString());
        System.out.println("\nHelicopter");
        System.out.println(helicopter.toString() + "\n");

        /* vehicleBlimp.setNumOfPassengers(7);
           aircraftBlimp.setNumOfPassengers(7);
           These method WILL create an error because they are
           not declared in their respective class / interface
        */
        System.out.println("vehicleBlimp");
        blimp.setNumOfPassengers(7); // This works because the method exists in the blimp object
        System.out.println(vehicleBlimp.toString());
        System.out.println("\naircraftBlimp");
        System.out.println(aircraftBlimp.toString());
        System.out.println("\nBlimp");
        System.out.println(blimp.toString() + "\n");
    }
}
