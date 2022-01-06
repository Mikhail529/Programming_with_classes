public class CLS {
    public static void main(String[] args) {

        // Task 12. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
        // Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля

        Engine engine = new Engine();
        Car car = new Car("Porsche 911 Turbo S",engine);
        car.printCarModel();                // Марка автомобиля
        System.out.println();
        car.refuel();                       // Заправка автомобиля
        System.out.println();
        car.wheel.changeWheel(2);       // Замена колеса
        System.out.println();
        car.drive();                        // Автомобиль едет
    }
}

class Car {
    private final String model;
    private final Engine engine;
    Wheel wheel;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.wheel = new Wheel();
    }

    public void drive() {
        System.out.println("Автомобиль в движении");

        engine.EngineOn();
        wheel.driveWheel();
    }

    public void refuel() {
        System.out.println("Автомобиль заправлен");
    }

    public void printCarModel() {
        System.out.println("Марка автомобиля: " + model);
    }
}

class Engine {
    public void EngineOn() {
        System.out.println("\tMessage: Engine On!");
    }
}

class Wheel {
    private final int[] wheelCar;

    public Wheel() {
        this.wheelCar = new int[4];
        for (int i=0, temp=0; i<wheelCar.length; i++, temp++) {
            wheelCar[i] = temp;
        }
    }

    public void driveWheel() {
        for (int j : wheelCar) {
            System.out.println("\tMessage: Колесо " + (j+1) + " в движении!");
        }
    }
    public void changeWheel(int w) {
        System.out.println("Замена колеса произведена успешно");
        for (int j : wheelCar) {
            if (j == w) {
                System.out.println("\tMessage: Колесо " + (j+1) + " заменено!");
            }
        }
    }
}