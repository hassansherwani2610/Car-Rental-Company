package com.projects;
import java.util.Scanner;
import java.util.ArrayList;

interface CompanyFeatures{
    public void destination();
    public void cars(int SelectedDestination , String selectedCurrentLocationName , String selectedDestinationName);
    public void availableDatesOfSelectedCar(int selectedCar , String selectedCarName , String selectedCurrentLocationName  , String selectedDestinationName);
    public void availableTime();
    public void companyDetails();
}

class CompanyFeaturesImplementation implements CompanyFeatures{
    String selectedCurrentLocationName;
    String selectedDestinationName;
    String selectedCarName;
    int selectedCarPrice;
    String selectedDateIs;
    String selectedDate;
    public void availableTime(){
        String[] timingSlot = {"8am" , "9am" , "11am" , "1pm" , "4pm" , "8pm" , "11pm" , "12pm"};

        System.out.println("\nAvailable Timing Slots Are: ");
        for (int i = 0 ; i < timingSlot.length ; i++){
            System.out.println((i+1) + ". " + timingSlot[i]);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Select The Desired Time By Enter The Respective Number Of Your Desired Time: ");
        int selectedTime = scan.nextInt();

        selectedDate = timingSlot[selectedTime - 1];
    }

    public void availableDatesOfSelectedCar(int selectedCar , String selectedCarName  , String selectedCurrentLocationName  , String selectedDestinationName){
        String[] availableDates = {"11-October-2024", "22-October-2024", "30-October-2024", "07-November-2024", "11-November-2024", "23-November-2024", "25-November-2024", "26-November-2024", "29-November-2024", "02-December-2024", "16-December-2024", "23-December-2024", "25-December-2024", "31-December-2024"};

        if (selectedCar == 1 || selectedCar == 3 || selectedCar == 5 || selectedCar == 7 || selectedCar == 9){
            System.out.println("\nThe Available Dates Of " + selectedCarName + " From " + selectedCurrentLocationName + " To " + selectedDestinationName + " Are: ");
            for (int i = 0 ; i < availableDates.length ; i++){
                System.out.println((i+1) + ". " + availableDates[i]);
            }
        }

        if (selectedCar == 2 || selectedCar == 4 || selectedCar == 6 || selectedCar == 8 || selectedCar == 10){
            System.out.println("\nThe Available Dates Of " + selectedCarName + " From " + selectedCurrentLocationName + " To " + selectedDestinationName + " Are: ");
            for (int i = 0 ; i < availableDates.length ; i++){
                System.out.println((i+1) + ". " + availableDates[i]);
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Select The Desired Date By Enter The Respective Number Of Your Desired Time: ");
        int selectedDateOption = scan.nextInt();

        selectedDateIs = availableDates[selectedDateOption - 1];

        availableTime();
    }
    public void cars(int selectedDestination , String selectedCurrentLocationName , String selectedDestinationName){
        String[] availableCars = {"SUZUKI ALTO" , "SUZUKI Mehran" , "SUZUKI CULTUS Old" , "SUZUKI CULTUS new" , "TOYOTA Yaris" , "TOYOTA GLI" , "TOYOTA XLI" , "KIA Sportage" , "APV" , "Bolan"};
        int[] pricesOfCars = {5500 , 3500 , 6000 , 7000 , 10000 , 10500 , 12000 , 15000 , 14000 , 4200};
        System.out.println("\nAvailable Cars Are: ");
        for (int i = 0 ; i < availableCars.length ; i++){
            System.out.println((i+1) + ". " + availableCars[i] + " - " + pricesOfCars[i]);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Select The Desired Car By Enter The Respective Number Of Your Desired Car: ");
        int selectedCar = scan.nextInt();

        selectedCarName = availableCars[selectedCar - 1];
        selectedCarPrice = pricesOfCars[selectedCar - 1];


        availableDatesOfSelectedCar(selectedCar , selectedCarName , selectedCurrentLocationName  , selectedDestinationName);
    }
    public void destination(){
        Scanner scan = new Scanner(System.in);

        String[] availableCurrentLocation = {"Murree", "Quetta" , "Hyderabad" , "Karachi" , "Islamabad" , "Kashmir" , "Balochistan" , "Multan" , "Lahore" , "Peshawar"};
        System.out.println("\nAvailable Current Locations Are: ");
        for (int i = 0 ; i < availableCurrentLocation.length ; i++){
            System.out.println((i+1) + ". " + availableCurrentLocation[i]);
        }

        System.out.print("Please Enter Your Current City By Enter The Respective Number Of Your Current Location: ");
        int currentCity = scan.nextInt();

        selectedCurrentLocationName = availableCurrentLocation[currentCity - 1];

        String[] availableDestinations = {"Murree", "Quetta" , "Hyderabad" , "Karachi" , "Islamabad" , "Kashmir" , "Balochistan" , "Multan" , "Lahore" , "Peshawar"};
        System.out.println("\nAvailable Destinations Are: ");
        for (int i = 0 ; i < availableDestinations.length ; i++){
            System.out.println((i+1) + ". " + availableDestinations[i]);
        }

        System.out.print("Select The Desired Destination By Enter The Respective Number Of Your Desired Destination: ");
        int selectedDestination = scan.nextInt();

        selectedDestinationName = availableDestinations[selectedDestination - 1];

        cars(selectedDestination , selectedCurrentLocationName , selectedDestinationName);
    }

    public void companyDetails(){
        String[] driversName = {"Usama" , "Akram" , "Usman" , "Riad" , "Yusuf" , "Hussain"};
        int driverNameRandom = (int)(Math.random() * driversName.length);

        System.out.println("Pickup City: " + selectedCurrentLocationName);
        System.out.println("Destination City: " + selectedDestinationName);
        System.out.println("Car Name: " + selectedCarName);
        System.out.println("Driver's Name: " + driversName[driverNameRandom]);
        System.out.println("Total Amount Of Fare: " + selectedCarPrice);
        System.out.println("Date Of Pickup: " + selectedDateIs);
        System.out.println("Time Of Pickup: " + selectedDate);
        System.out.println("Service Provider: Sherwani & CO.");

        System.out.println("\t\t\t\t\t\tThanks For Choosing Us, Have A Safe Journey!");
    }
}

public class CarRentalCompany {
    public static void main(String[] args) {
        CompanyFeaturesImplementation company = new CompanyFeaturesImplementation();
        company.destination();

        Scanner scan = new Scanner(System.in);
        System.out.print("\nIf You Want To Change Anything Enter (1)-One And If Not Then Enter (0)-Zero: ");
        int change = scan.nextInt();

        String name;
        String fatherName;
        long contactNumber;
        long cnicNumber;
        int howMany;


        if (change == 1){
            company.destination();
        }

        ArrayList<String> passengersName = new ArrayList<String>();

        System.out.println("Please Give Us Some Details Of Yours: ");

        System.out.print("Enter Your First Name Only: ");
        name = scan.next();

        System.out.print("Enter Your Father's First Name Only: ");
        fatherName = scan.next();

        System.out.print("Enter Your Contact Number: ");
        contactNumber = scan.nextLong();

        System.out.print("Enter Your CNIC Number: ");
        cnicNumber = scan.nextLong();

        System.out.print("Are You Sure You Want To Confirm The Booking (For Yes Enter 1 For No Enter 0): ");
        int confirmed = scan.nextInt();

        if (confirmed == 1){
            System.out.println("\n\t\t\t\t\t\t\t\t\tE-Invoice");

            System.out.println("Booking By: " + name);
            System.out.println("Booker's Father's Name: " + fatherName);
            System.out.println("Booker's Contact Number: +92" + contactNumber);
            System.out.println("Booker's CNIC Number: " + cnicNumber);

            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            company.companyDetails();
        }
        else if (confirmed == 0){
            System.out.println("Thanks, Come Again Later, Bye!");

        }
    }
}
