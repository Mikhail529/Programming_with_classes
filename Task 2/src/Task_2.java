public class CLS {
    public static void main(String[] args) {

        // Task 2. Создайте класс Test2 двумя перемеными.
        // Добавьте конструктор с входными параметрами.
        // Добавьте конструктор, инициализирующий члены класса по умолчанию.
        // Добавьте set- и get- методы для полей экземпляра класса
        
        Test2 test1 = new Test2();
        System.out.println("Конструктор по умолчанию");
        System.out.println("VariableOne: " + test1.getVariableOne() + "\t VariableTwo: " + test1.getVariableTwo());

        System.out.println();

        Test2 test2 = new Test2(25, 50);
        System.out.println("Конструктор с входными параметрами");
        System.out.println("VariableOne: " + test2.getVariableOne() + "\t VariableTwo: " + test2.getVariableTwo());

        System.out.println();

        System.out.println("Getter and Setter method");
        test1.setVariableOne(75);
        System.out.println("method get: " + test1.getVariableOne());
        test1.setVariableTwo(95);
        System.out.println("method get: " + test1.getVariableTwo());
    }
}

class Test2 {
    private int variableOne;
    private int variableTwo;

    public Test2() {
        variableOne = 0;
        variableTwo = 0;
    }
    public Test2(int variableOne, int variableTwo) {
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
    }

    public int getVariableOne() {
        return variableOne;
    }

    public void setVariableOne(int variableOne) {
        this.variableOne = variableOne;
    }

    public int getVariableTwo() {
        return variableTwo;
    }

    public void setVariableTwo(int variableTwo) {
        this.variableTwo = variableTwo;
    }
}