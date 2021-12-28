import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CLS {
    public static void main(String[] args) {

        // Task 10. Создать класс Airline, спецификация которого приведена ниже.
        // Определить конструкторы, set- и get- методы и метод toString().
        // Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
        // Задать критерии выбора данных и вывести эти данные на консоль

        // Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        // Найти и вывести:
        // a) список рейсов для заданого пункта назначения;
        // b) список рейсов для заданого дня недели;
        // c) список рейсов для заданого дня недели, время вылета для которых больше заданного

        ArrayList<Airline> arrayList = new ArrayList<>();

        arrayList.add(new Airline("New York","NY-5768","Boeing 737-800",
                new Airline.Time(21,30), new String[]{"Mon", "Sun"}));
        arrayList.add(new Airline("Boston","BT-3448","Boeing 777-300",
                new Airline.Time(19,15),new String[]{"Tue", "Sun"}));
        arrayList.add(new Airline("Washington","WA-7271", "Airbus a380",
                new Airline.Time(3,50), new String[]{"Mon", "Wed"}));
        arrayList.add(new Airline("Los Angeles","LA-7991","Cessna 560XL",
                new Airline.Time(14,0),new String[]{"Wed", "Sun"}));
        arrayList.add(new Airline("Seattle","ST-3759","Airbus a320",
                new Airline.Time(0,50),new String[]{"Tue", "Sat"}));
        arrayList.add(new Airline("Minneapolis", "MN-2232", "Cessna 207",
                new Airline.Time(15,10), new String[]{"Sat", "Sun"}));
        arrayList.add(new Airline("Boston","BT-2710","Airbus a330",
                new Airline.Time(22,20),new String[]{"Wed", "Fri"}));
        arrayList.add(new Airline("Seattle","ST-7102","Cessna 172R",
                new Airline.Time(17,45),new String[]{"Mon", "Fri"}));
        arrayList.add(new Airline("New York","NY-3972","Cessna 560XL",
                new Airline.Time(7,0), new String[]{"Mon", "Fri"}));
        arrayList.add(new Airline("Minneapolis", "MN-1379", "Boeing 737-800",
                new Airline.Time(2, 10), new String[]{"Tue", "Sat"}));
        arrayList.add(new Airline("Oklahoma City", "OC-1103", "Airbus a320",
                new Airline.Time(16, 15), new String[]{"Thu", "Sat"}));
        arrayList.add(new Airline("Los Angeles", "LA-2201", "Cessna 172R",
                new Airline.Time(7, 50), new String[]{"Tue", "Fri"}));
        arrayList.add(new Airline("Seattle", "ST-5007", "Boeing 747-446",
                new Airline.Time(11, 0), new String[]{"Wed", "Sat"}));
        arrayList.add(new Airline("New York", "NY-2552", "Cessna 207",
                new Airline.Time(15, 15), new String[]{"Mon", "Fri"}));

        DataAirline dataAirline = new DataAirline(arrayList);
        System.out.println("\nСписок рейсов для заданого пункта назначения: ");
        dataAirline.listFlightForDestination("New York");

        System.out.println("\nСписок рейсов для заданого дня недели: ");
        dataAirline.listFlightForDay("Fri");
        
        System.out.println("\nСписок рейсов для заданого дня недели, время вылета для которых больше заданного\n");
        dataAirline.listFlightForDayAndTime("Mon",18,10);
    }
}

class DataAirline {
    private final ArrayList<Airline> arrayList;

    public DataAirline(ArrayList<Airline> arrayList) {
        this.arrayList = arrayList;
    }

    public void listFlightForDestination(String destination) {
        for (Airline airline : arrayList) {
            if (airline.getDestination().compareTo(destination) == 0) {
                System.out.println(airline.toString());
            }
        }
    }

    public void listFlightForDay(String day) {
        for (Airline airline : arrayList) {
            if (checkArray(airline.getDaysOfTheWeek(), day)) {
                System.out.println(airline.toString());
            }
        }
    }

    public void listFlightForDayAndTime(String day, int hour, int minute) {
        for (Airline airline : arrayList) {
            if (checkArray(airline.getDaysOfTheWeek(), day)) {
                if (airline.getTime().hour >= hour) {
                    if (airline.getTime().minute >= minute) {
                        System.out.println(airline.toString());
                    }
                }
            }
        }
    }

    private void printArray(ArrayList<Airline> arrayList) {
        for (Airline s : arrayList) {
            System.out.println(s.toString());
        }
    }

    private boolean checkArray(String[] strings, String string) {
        boolean b = false;
        for (String str : strings) {
            if (Objects.equals(str, string)) {
                b = true;
                break;
            }
        }
        return b;
    }
}

class Airline {
    private String destination;
    private String flightNumber;
    private String aircraftType;
    private Time time;
    private String[] daysOfTheWeek;

    public Airline(String destination, String flightNumber, String aircraftType, Time time, String[] daysOfTheWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.time = time;
        this.daysOfTheWeek = daysOfTheWeek;
    }

    @Override
    public String toString() {
        return "\nAirline: " +
                "\nПункт назначения: \t" + destination +
                "\nНомер рейса: \t\t" + flightNumber +
                "\nТип самолета: \t\t" + aircraftType +
                "\nВремя вылета: \t\t" + time +
                "\nДни недели: \t\t" + Arrays.toString(daysOfTheWeek);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String[] getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public void setDaysOfTheWeek(String[] daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }

    static class Time {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            if (hour >= 24 || hour < 0) {
                System.out.println("Error!");
                hour = 0;
            }
            this.hour = hour;
            if (minute >= 60 || minute < 0) {
                minute = 0;
            }
            this.minute = minute;
        }

        @Override
        public String toString() {
            return string(hour) + ":" + string(minute);
        }

        private String string(int temp) {
            String string = String.valueOf(temp);
            if (temp <= 9) {
                string = "0" + string;
            }
            return string;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            if (hour >= 24 || hour < 0) {
                hour = 0;
            }
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            if (minute >= 60 || minute < 0) {
                minute = 0;
            }
            this.minute = minute;
        }
    }
}