import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

public class CLS {
    public static void main(String[] args) {

        // Task 14. Счета. Клиент может имет несколько счетов в банке.
        // Учитывать возможность блокировки/разблокировки счета. Реализовать поиск и сортировку счетов.
        // Вычисление общей суммы по счетам. Вычисление общей суммы по всем счетам, имеющим
        // положительный и отрицательный балансы отдельно

        Bank bank = new Bank("Bank of America");

        Client client1 = new Client("Steven", "Roberts");
        Client client2 = new Client("William", "Warner");
        Client client3 = new Client("June", "Cameron");
        Client client4 = new Client("Emma","Douglas");
        Client client5 = new Client("David", "Brooks");

        bank.createAccount(client1, new BigInteger("33984372379394701971"), new BigDecimal("151710.50"));
        bank.createAccount(client1, new BigInteger("72316950524673122952"), new BigDecimal("-1000.10"));
        bank.createAccount(client2, new BigInteger("21525338026313518411"), new BigDecimal("25510.70"));
        bank.createAccount(client3, new BigInteger("39388602932236116777"), new BigDecimal("-11125.30"));
        bank.createAccount(client3, new BigInteger("17877237181655638119"), new BigDecimal("71500.10"));
        bank.createAccount(client4, new BigInteger("50341753333008673451"), new BigDecimal("55000.10"));
        bank.createAccount(client5, new BigInteger("14052209952550719601"), new BigDecimal("-19710.75"));
        bank.createAccount(client5, new BigInteger("71909737825189527755"), new BigDecimal("15150.10"));

        bank.sortingAccount();                                              // Сортировка счетов
        bank.searchAccount(new BigInteger("17877237181655638119"));     // Поиск счета
        bank.blockingAccount(new BigInteger("17877237181655638119"));   // Блокировка счета
        System.out.println();
        bank.searchAccount(new BigInteger("17877237181655638119"));     // Поиск счета который был заблокирован
        bank.unblockingAccount(new BigInteger("17877237181655638119")); // Разблокировка счета
        bank.searchAccount(new BigInteger("17877237181655638119"));     // Поиск счета который был разблокирован
        System.out.println();
        bank.sumAllAccount();                                               // Сумма всех счетов
        bank.sumAccountPositiveBalance();                                   // Сумма положительных счетов
        bank.sumAccountNegativeBalance();                                   // Сумма отрицательных счетов
    }
}

class Client {
    private String firstName;
    private String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client: " +
                "\nFirst Name: " + firstName +
                "\nLast Name:  " + lastName;
    }
}

class Bank {
    private final String nameBank;
    Client client;
    private final ArrayList<Account> accountArrayList = new ArrayList<>();

    public Bank(String nameBank) {
        this.nameBank = nameBank;
    }

    public void createAccount(Client client, BigInteger numberAccount, BigDecimal sumOfAccount) {
        accountArrayList.add(new Account(client.getFirstName(), client.getLastName(),
                new BigInteger(String.valueOf(numberAccount)), new BigDecimal(String.valueOf(sumOfAccount))));
    }

    public void searchAccount(BigInteger numberAccount) {
        for (Account account : accountArrayList) {
            if (account.getNumberAccount().compareTo(numberAccount) == 0) {
                System.out.println(account);
            }
        }
    }

    public void sortingAccount() {
        accountArrayList.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getNumberAccount().compareTo(o2.getNumberAccount());
            }
        });
    }

    public void sumAllAccount() {
        BigDecimal bigDecimal = new BigDecimal("0");
        for (Account account : accountArrayList) {
            bigDecimal = bigDecimal.add(account.getSumOfAccount());
        }
        System.out.println("Sum from all accounts: " + bigDecimal);
    }

    public void sumAccountPositiveBalance() {
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimalTemp = new BigDecimal("0");
        for (Account account : accountArrayList) {
            if (account.getSumOfAccount().compareTo(bigDecimalTemp) > 0) {
                bigDecimal = bigDecimal.add(account.getSumOfAccount());
            }
        }
        System.out.println("Sum from all accounts Positive: " + bigDecimal);
    }

    public void sumAccountNegativeBalance() {
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimalTemp = new BigDecimal("0");
        for (Account account : accountArrayList) {
            if (account.getSumOfAccount().compareTo(bigDecimalTemp) < 0) {
                bigDecimal = bigDecimal.add(account.getSumOfAccount());
            }
        }
        System.out.println("Sum from all accounts Negative: " + bigDecimal);
    }

    public void blockingAccount(BigInteger bigInteger) {
        for (Account account : accountArrayList) {
            if (account.getNumberAccount().compareTo(bigInteger) == 0) {
                account.setBlock_Unlock(false);
            }
        }
    }

    public void unblockingAccount(BigInteger bigInteger) {
        for (Account account : accountArrayList) {
            if (account.getNumberAccount().compareTo(bigInteger) == 0) {
                account.setBlock_Unlock(true);
            }
        }
    }

    @Override
    public String toString() {
        return "Bank: " + nameBank;
    }
}

class Account {
    private boolean block_Unlock;
    private String firstNameAccountClient;
    private String lastNameAccountClient;
    private final BigInteger numberAccount;
    private BigDecimal sumOfAccount;

    public Account(String firstNameAccountClient, String lastNameAccountClient,
                   BigInteger numberAccount, BigDecimal sumOfAccount) {
        this.firstNameAccountClient = firstNameAccountClient;
        this.lastNameAccountClient = lastNameAccountClient;
        this.numberAccount = numberAccount;
        this.sumOfAccount = sumOfAccount;
        this.block_Unlock = true;
    }

    public String getFirstNameAccountClient() {
        if (block_Unlock) {
            return firstNameAccountClient;
        }
        return "Информация не доступна, счет заблокирован!";
    }

    public void setFirstNameAccountClient(String firstNameAccountClient) {
        if (block_Unlock) {
            this.firstNameAccountClient = firstNameAccountClient;
        }
        System.out.println("Информация не доступна, счет заблокирован!");
    }

    public String getLastNameAccountClient() {
        if (block_Unlock) {
            return lastNameAccountClient;
        }
        return "Информация не доступна, счет заблокирован!";
    }

    public void setLastNameAccountClient(String lastNameAccountClient) {
        if (block_Unlock) {
            this.lastNameAccountClient = lastNameAccountClient;
        }
        System.out.println("Информация не доступна, счет заблокирован!");
    }

    public BigInteger getNumberAccount() {
        return numberAccount;
    }

    public BigDecimal getSumOfAccount() {
        return sumOfAccount;
    }

    public void setSumOfAccount(BigDecimal sumOfAccount) {
        if (block_Unlock) {
            this.sumOfAccount = sumOfAccount;
        }
        System.out.println("Информация не доступна, счет заблокирован!");
    }

    public boolean isBlock_Unlock() {
        return block_Unlock;
    }

    public void setBlock_Unlock(boolean block_Unlock) {
        this.block_Unlock = block_Unlock;
    }

    @Override
    public String toString() {
        if (block_Unlock) {
            return "\nNumber account:\t" + numberAccount +
                    "\nFirst Name:\t\t" + firstNameAccountClient +
                    "\nLast Name:\t\t" + lastNameAccountClient +
                    "\nSum:\t\t\t" + "$"+ sumOfAccount;
        }
        return "Number account:\t" + numberAccount + "\n\t\tСчет заблокирован!" + "\n\t  Информация не доспупна";
    }
}