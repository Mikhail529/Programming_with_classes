import java.util.Scanner;

public class CLS {
    public static void main(String[] args) {

        // Task 1. Создайте класс Test1 двумя переменными.
        // Добавьте метод вывода на экран и методы изенения этих переменных.
        // Добавьте метод который находит сумму значений этих переменных,
        // метод который находит наибольшее значение из этих двух переменных
        
        Test1 test1 = new Test1();
        test1.showOnScreen();
        test1.chargeVariableOne();
        test1.chargeVariableTwo();
        test1.sumVariable();
        test1.greatVariable();
    }
}

class Test1 {
    private int variableOne = 25;
    private int variableTwo = 50;

    void showOnScreen() {
        System.out.println("Variable One is: " + variableOne);
        System.out.println("Variable Two is: " + variableTwo);
    }
    void chargeVariableOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new value of the variable \"variableOne\": ");
        variableOne = scanner.nextInt();
    }
    void chargeVariableTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new value of the variable \"variableTwo\": ");
        variableTwo = scanner.nextInt();
    }
    void sumVariable() {
        System.out.println("Sum of variables: " + (variableOne+variableTwo));
    }
    void greatVariable() {
        if (variableOne>variableTwo)
            System.out.println("Highest value: " + variableOne);
        else if (variableOne<variableTwo)
            System.out.println("Highest value: " + variableTwo);
        else System.out.println("Variables are equal");
    }
}