import java.util.ArrayList;
import java.util.Scanner;

public class CLS {
    public static void main(String[] args) {

        // Task 15. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
        // различного типа (отдых, экскурсии, лечение, шопинг, круиз и т.д.) для оптимального выбора.
        // Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путёвок

        ArrayList<Offer> offerArrayList = new ArrayList<>();
        offerArrayList.add(new Offer("Excursion", "Belarus", "Minsk"));
        offerArrayList.add(new Offer("Excursion", "Czech", "Prague"));
        offerArrayList.add(new Offer("Excursion", "USA", "Washington"));
        offerArrayList.add(new Offer("Relaxation", "Jordan", "Amman"));
        offerArrayList.add(new Offer("Relaxation", "UAE", "Abu Dhabi"));
        offerArrayList.add(new Offer("Relaxation", "Egypt" , "Cairo"));
        offerArrayList.add(new Offer("Treatment", "Switzerland", "Berne"));
        offerArrayList.add(new Offer("Treatment", "Germany", "Berlin"));
        offerArrayList.add(new Offer("Treatment", "Israel", "Jerusalem"));
        offerArrayList.add(new Offer("Shopping", "Italy", "Venice"));
        offerArrayList.add(new Offer("Shopping", "Russia", "Moscow"));
        offerArrayList.add(new Offer("Shopping", "Poland", "Warsaw"));
        offerArrayList.add(new Offer("Cruise", "Sweden", "Stockholm"));
        offerArrayList.add(new Offer("Cruise", "Italy", "Rome"));
        offerArrayList.add(new Offer("Cruise", "Norway", "Oslo"));

        offerData(offerArrayList);                              // набор предложений
        Offer offer = new Offer();
        offer.setN_o(offer.printOffer(offerArrayList));         // выбор предложения для путевки
        Voucher voucher = new Voucher();
        voucher.addVoucher();                                   // выбор транспорта, питания и даты
        voucher.printVoucher(offer.getN_o(), offerArrayList);   // печать готовой путевки
    }

    public static void offerData(ArrayList<Offer> offerArrayList) {
        for (int i=0; i<offerArrayList.size(); i++) {
            System.out.println("Offer " + i + offerArrayList.get(i).toString() + "\n");
        }
    }
}

class Offer {
    private String typeVoucher;
    private String country;
    private String town;
    private int n_o;

    public Offer(String typeVoucher, String country, String town) {
        this.typeVoucher = typeVoucher;
        this.country = country;
        this.town = town;
    }

    public Offer() {}

    public int printOffer(ArrayList<Offer> offerArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number offer: ");
        int numberOffer = scanner.nextInt();

        while (!(numberOffer < offerArrayList.size() && numberOffer > 0)) {
            System.out.println("Error! Not chosen!");
            System.out.println("Enter number offer: ");
            numberOffer = scanner.nextInt();
        }
        return numberOffer;
    }

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getN_o() {
        return n_o;
    }

    public void setN_o(int n_o) {
        this.n_o = n_o;
    }

    @Override
    public String toString() {
        return  "\nVoucher:\t" + typeVoucher +
                "\ncountry:\t" + country +
                "\ntown:\t\t" + town;
    }
}

class Voucher {
    private Offer offer = new Offer();
    private Transport transport = new Transport();
    private Food food = new Food();
    private Days day = new Days();

    public void addVoucher() {
        Scanner scanner = new Scanner(System.in);
        transport.printTypeTransport();
        int numberTransport = scanner.nextInt();
        while (!(numberTransport >= 0 && numberTransport < 4)) {
            System.out.println("Error! Not chosen!");
            System.out.println("Enter number offer: ");
            numberTransport = scanner.nextInt();
        }
        transport.setTypeTransport(numberTransport);

        food.printTypeFood();
        System.out.println("Enter the selected number:");
        int numberFood = scanner.nextInt();
        while (!(numberFood >= 0 && numberFood < 8)) {
            System.out.println("Error! Not chosen!");
            System.out.println("Enter number offer: ");
            numberFood = scanner.nextInt();
        }
        food.setTypeFood(numberFood);

        day.setStart();
        day.setEnd();
    }

    public void printVoucher(int x, ArrayList<Offer> offerArrayList) {
        System.out.print("\n\t*** Voucher ***");
        System.out.println(offerArrayList.get(x).toString());
        System.out.println("Transport:\t" + transport.getTypeTransport());
        System.out.println("Food:\t\t" + food.getTypeFood());
        day.printDate();
    }
}

class Transport {
    private String typeTransport;

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(int numberTransport) {
        switch (numberTransport) {
            case 0: this.typeTransport = "bus";
            break;
            case 1: this.typeTransport = "airplane";
            break;
            case 2: this.typeTransport = "train";
            break;
            case 3: this.typeTransport = "minibus";
            break;
            default:
                this.typeTransport = "Not chosen!";
        }
    }

    public void printTypeTransport() {
        System.out.println("Select transport: ");
        System.out.println("0 if bus\n" +
                "1 if airplane\n" +
                "2 if train\n" +
                "3 if minibus\n");
        System.out.println("Enter the selected number:");
    }
}

class Food {
    private String typeFood;

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(int numberFood) {
        switch (numberFood) {
            case 0: this.typeFood = "All inclusive";
            break;
            case 1: this.typeFood = "Breakfast";
            break;
            case 2: this.typeFood = "Breakfast and lunch";
            break;
            case 3: this.typeFood = "Lunch";
            break;
            case 4: this.typeFood = "Lunch and dinner";
            break;
            case 5: this.typeFood = "Dinner";
            break;
            case 6: this.typeFood = "Dinner and breakfast";
            break;
            case 7: this.typeFood = "Without food";
            break;
            default:
                System.out.println("Not chosen!");
                this.typeFood = "Not chosen!";
        }
    }

    public void printTypeFood() {
        System.out.println("Select transport: ");
        System.out.println("0 if All inclusive\n" +
                "1 if Breakfast\n" +
                "2 if Breakfast and lunch\n" +
                "3 if Lunch\n" +
                "4 if Lunch and dinner\n" +
                "5 if Dinner\n" +
                "6 if Dinner and breakfast\n" +
                "7 if Without food\n");
    }
}

class Days {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start departure: ");
        int tempStart = scanner.nextInt();
        while (!(tempStart <= 31 && tempStart > 0)) {
            System.out.println("Error! Not chosen!");
            System.out.println("Enter number offer: ");
            tempStart = scanner.nextInt();
        }
        this.start = tempStart;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter arrival date: ");
        int tempEnd = scanner.nextInt();
        while (!(tempEnd <= 31 && tempEnd > 0)) {
            System.out.println("Error! Not chosen!");
            System.out.println("Enter number offer: ");
            tempEnd = scanner.nextInt();
        }
        this.end = tempEnd;
    }

    public void printDate() {
        System.out.println("Data:\t\t" +
                "from: " + getStart() +
                " to: " + getEnd());
    }
}