import java.util.ArrayList;

public class CLS {
    public static void main(String[] args) {

        // Task 9. Создать класс Book, спецификация которого приведена ниже.
        // Определить конструкторы, set- и get- методы и метод toString().
        // Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
        // Задать критерии выбора данных и вывести эти данные на консоль

        // Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплёта.
        // Найти и вывести:
        // a) список книг заданного автора;
        // b) список книг, выпущенных заданым издательством;
        // c) список книг, выпущеных после заданного года
        
        ArrayList<Book> arrayList = new ArrayList<>();

        arrayList.add(new Book(27807,"Кладбище домашних животных","Стивен Кинг",
                "АСТ",2016,480,7.5,"Твердый переплет"));
        arrayList.add(new Book(77082,"11/22/63","Стивен Кинг",
                "АСТ",2019,800,8.7,"Твердый переплет"));
        arrayList.add(new Book(11662, "Зелёная миля", "Стивен Кинг",
                "АСТ", 2014, 384,6.7, "Твердый переплет"));
        arrayList.add(new Book(83973,"The One","Джон Маррс",
                "Эксмо",2020,416,7.6,"Мягкая обложка"));
        arrayList.add(new Book(75117,"Цветы для Элджернона","Даниел Киз",
                "Эксмо", 2012,382,6.6,"Мягкая обложка"));
        arrayList.add(new Book(26054,"451 градус по Фаренгейту","Рэй Брэдбери",
                "Pocket Book",2017,256,3.9,"Мягкая обложка"));
        arrayList.add(new Book(50228,"Дюна","Фрэнк Герберт",
                "АСТ",2021,704,11.7,"Твердый переплет"));
        arrayList.add(new Book(29120, "Мор, ученик смерти", "Терри Пратчетт",
                "Эксмо", 2018, 384, 7.4, "Твердый переплет"));
        arrayList.add(new Book(97095,"Мрачный Жнец","Терри Пратчетт",
                "Эксмо", 2006,416,7.5,"Твердый переплет"));
        arrayList.add(new Book(31133,"Безмолвный пациент", "Алекс Михаэлидес",
                "Эксмо", 2019,352,6.8, "Твердый переплет"));
        arrayList.add(new Book(82419,"Все хреново. Книга о надежде","Марк Мэнсон",
                "Альпина Паблишер",2021,320,9.5,"Мягкая обложка"));
        arrayList.add(new Book(50012,"Мужские правила","Марк Мэнсон",
                "Альпина Паблишер",2020,300,9.7,"Мягкая обложка"));
        arrayList.add(new Book(93230,"Тонкое искусство пофигизма","Марк Мэнсон",
                "Альпина Паблишер",2022,192,9.3,"Мягкая обложка"));

        DataBook dataBook = new DataBook(arrayList);
        System.out.println("Книги заданного автора: \n");
        dataBook.listOfAuthorBooks("Терри Пратчетт");
        System.out.println("\n\nКниги заданого издательства: \n");
        dataBook.listOfBooksByPublisher("АСТ");
        System.out.println("\n\nКнига выпущенные после заданного года: \n");
        dataBook.listOfBooksOfTheYear(2021);
    }
}

class DataBook {
    private final ArrayList<Book> arrayList;

    public DataBook(ArrayList<Book> arrayList) {
        this.arrayList = arrayList;
    }

    public void listOfAuthorBooks(String authors) {
        for (Book book : arrayList) {
            if (book.getAuthors().compareTo(authors) == 0) {
                System.out.println(book.toString());
            }
        }
    }

    public void listOfBooksByPublisher(String publishingHouse) {
        for (Book book : arrayList) {
            if (book.getPublishingHouse().compareTo(publishingHouse) == 0) {
                System.out.println(book.toString());
            }
        }
    }

    public void listOfBooksOfTheYear(int yearOfPublishing) {
        for (Book book : arrayList) {
            if (book.getYearOfPublishing() >= yearOfPublishing) {
                System.out.println(book.toString());
            }
        }
    }
}

class Book {
    private int ID;
    private String name;
    private String authors;
    private String publishingHouse;
    private int yearOfPublishing;
    private int numberOfPages;
    private double cost;
    private String bindingType;

    public Book(int ID, String name, String authors, String publishingHouse,
                int yearOfPublishing, int numberOfPages, double cost, String bindingType) {
        this.ID = ID;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.cost = cost;
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book" +
                "\nID: \t\t\t\t" + ID +
                "\nНазвание: \t\t\t" + name +
                "\nАвтор: \t\t\t\t" + authors +
                "\nИздательство: \t\t" + publishingHouse +
                "\nГод издательства: \t" + yearOfPublishing +
                "\nКоличество страниц: "  + numberOfPages +
                "\nЦена: \t\t\t\t$" + cost +
                "\nТип переплёта: \t\t" + bindingType + "\n";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }
}