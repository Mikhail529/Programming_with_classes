import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

public class CLS {
    public static void main(String[] args) {

        // Task 8. Создать класс Customer, спецификация которого приведена ниже.
        // Определить конструкторы, set- и get- методы и метод toString().
        // Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
        // Задать критерии выбора данных и вывести эти данные на консоль

        // Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банкковского счёта.
        // Найти и вывести:
        // a) список покупателей в алфавитном порядке;
        // b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

        ArrayList<Customer> arrayList = new ArrayList<>();
        arrayList.add(new Customer(71161,"Скворцова","Таисия",
                "Васильевна", "Минск",
                new BigInteger("2948912498418563"), new BigInteger("30012714595862511651")));
        arrayList.add(new Customer(71034, "Яковлева", "Алиса",
                "Сергеевна", "Москва",
                new BigInteger("1711585958978341"), new BigInteger("34038155909128820694")));
        arrayList.add(new Customer(38823,"Наумова","Екатерина",
                "Марковна","Лондон",
                new BigInteger("7005427296676937"),new BigInteger("39756681769060059991")));
        arrayList.add(new Customer(79374,"Иванов","Ярослав",
                "Даниилович", "Санкт-Петербург",
                new BigInteger("3512574872810924"), new BigInteger("22142640197450158451")));
        arrayList.add(new Customer(15189,"Иванов","Андрей",
                "Артёмович","Владивосток",
                new BigInteger("5490035089267341"), new BigInteger("99465902425829867486")));
        arrayList.add(new Customer(22716,"Максимов","Борис",
                "Андреевич","Париж",
                new BigInteger("9158414334289933"), new BigInteger("74820618043907925359")));
        arrayList.add(new Customer(55440,"Королева","Елизавета",
                "Михайловна","Рим",
                new BigInteger("3942982468317826"), new BigInteger("84763893098179620661")));
        arrayList.add(new Customer(91575, "Новиков","Илья",
                "Даниилович", "Мадрид",
                new BigInteger("2843293916220098"), new BigInteger("90212653969737747460")));

        DataCustomer dataCustomer = new DataCustomer(arrayList);

        dataCustomer.sortingListAlphabet(arrayList);

        // Для использования функции "sortingCreditCard" вывода списка покупателей
        // у которых номер кредитной карточки находится в заданном интервале. Для корректной работы функции,
        // вводите заданный интервал в формате 0000 0000 0000 0000 (16-ти значного числа)

//        dataCustomer.sortingCreditCard(arrayList, new BigInteger("2000000000000000"),
//                new BigInteger("6000000000000000"));
    }
}

class DataCustomer {
    ArrayList<Customer> arrayList;

    public DataCustomer(ArrayList<Customer> arrayList) {
        this.arrayList = arrayList;
    }

    public void sortingListAlphabet(ArrayList<Customer> arrayList) {
        arrayList.sort(Comparator.comparing(Customer::getSurname));
        for (Customer customer : arrayList) {
            System.out.println(customer.toString());
        }
    }

    public void sortingCreditCard(ArrayList<Customer> arrayList, BigInteger first, BigInteger second) {
        arrayList.sort(Comparator.comparing(Customer::getCreditCardNumber));
//        BigInteger bigInt1 = new BigInteger(String.valueOf(first));
//        BigInteger bigInt2 = new BigInteger(String.valueOf(second));
        for (Customer customer : arrayList) {
            if (customer.getCreditCardNumber().compareTo(first) > 0 && customer.getCreditCardNumber().compareTo(second) < 0)
                System.out.println(customer.toString());
        }
    }
}

class Customer {
    private int ID;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private BigInteger creditCardNumber;
    private BigInteger bankAccountNumber;

    public Customer(int ID, String surname, String name, String patronymic, String address,
                    BigInteger creditCardNumber, BigInteger bankAccountNumber) {
        this.ID = ID;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer" +
                "\nID: \t\t" + ID +
                "\nФамилия: \t" + surname +
                "\nИмя: \t\t" + name +
                "\nОтчество: \t" + patronymic +
                "\nАдрес: \t\t" + address +
                "\n_________________________" +
                "\nНомер кредитной карточки: \t" + creditCardNumber +
                "\nНомер банковского счета: \t" + bankAccountNumber + "\n\n";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(BigInteger creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public BigInteger getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(BigInteger bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}