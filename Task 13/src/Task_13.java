import java.util.ArrayList;

public class CLS {
    public static void main(String[] args) {

        // Task 13. Создать объект класса Государство, используя классы Область, Район, Город.
        // Методы: вывести на консоль столицу, количество областей, областные центры

        Country country = new Country("Belarus", "Minsk");

        country.regions.add(new Region("Brestskaya oblast", new Town("Brest")));
        country.regions.add(new Region("Gomel'skaya oblast",new Town("Gomel")));
        country.regions.add(new Region("Grodnenskaya oblast", new Town("Grodno")));
        country.regions.add(new Region("Minskaya oblast", new Town("Minsk")));
        country.regions.add(new Region("Mogilevskaya oblast", new Town("Mogilov")));
        country.regions.add(new Region("Vitebskaya oblast",new Town("Vitebsk")));

        country.printCapital();         // Вывод столицы на консоль
        System.out.println();
        country.numberRegion();         // Вывод на консоль количество регионов
        System.out.println();
        country.regionalCenters();      // Вывод на консоль областные центры
    }
}

class Country {
    private final String name;
    private final String capital;
    ArrayList<Region> regions;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
        this.regions = new ArrayList<>();
    }

    public void printCapital() {
        System.out.println(name + ": capital is " + capital);
    }

    public void numberRegion() {
        System.out.println("Numbers Region: " + regions.size());
    }

    public void regionalCenters() {
        for (Region region : regions) {
            region.town.getNameTown();
        }
    }
}

class Region {
    Town town;
    private String nameRegion;

    public Region(String nameRegion, Town town) {
        this.nameRegion = nameRegion;
        this.town = town;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion() {
        this.nameRegion = nameRegion;
    }
}

class Town {
    private String nameTown;

    public Town(String nameTown) {
        this.nameTown = nameTown;
    }

    public void getNameTown() {
        System.out.println(nameTown);
    }

    public void setNameTown(String nameTown) {
        this.nameTown = nameTown;
    }
}