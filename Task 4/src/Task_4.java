import java.util.*;

public class CLS {
    public static void main(String[] args) {

        // Task 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
        // Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива
        // по номерам поездов. Добавьте возможность сортировки массива по пункту назначения, причем поезда
        // с одинаковыми пунктами назначения должны быть упорядочены по времени отправления
        
        ArrayList<Train> trains = new ArrayList<>();

        trains.add(new Train(79618, "21:30", "New York"));
        trains.add(new Train(19657, "19:15", "Charlotte"));
        trains.add(new Train(75256, "01:30", "Washington"));
        trains.add(new Train(29359, "19:45", "Baltimore"));
        trains.add(new Train(17117, "17:00", "New York"));

        System.out.println("\nСортировка по номера поезда: \n");
        sortingTrainNumbers(trains);
        printMethod(trains);
        System.out.println("\nСортировка по пунктам назначения: \n");
        sortingByDestination(trains);
        printMethod(trains);
    }

    public static void sortingTrainNumbers(ArrayList<Train> trains) {
        trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.trainNumber.compareTo(o2.trainNumber);
            }
        });
    }

    public static void sortingByDestination(ArrayList<Train> trains) {
        trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                int result = o1.destination.compareTo(o2.destination);
                if (result == 0) {
                    return o1.departureTime.compareTo(o2.departureTime);
                }
                return result;
            }
        });
    }

    public static void printMethod(ArrayList<Train> trains) {
        for (Train train : trains) {
            train.printMethod(train);
        }
    }
}

class Train {
    Integer trainNumber;
    String departureTime;
    String destination;

    public Train(int trainNumber, String departureTime, String destination) {
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.destination = destination;
    }

    public void printMethod(Train train) {
        System.out.println(train.toString());
    }

    public String toString() {
        return trainNumber + "\t" + destination + "\t" + departureTime;
    }
}