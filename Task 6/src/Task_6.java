public class CLS {
    public static void main(String[] args) {

        // Task 6. Составьте описание класса для представления времени. Предусмотрите возможность установки времени
        // и изменения его отдельных частей (час, минута, секунда) с проверкой допустимости вводимых значений.
        // В случае недопустимых эначений полей поле устанавливается значение 0. Создать методы изменения времени
        // на заданое количество часов, минут и секунд
        
        Time time = new Time();
        System.out.println("Время по умолчанию: ");
        time.showTime();
        time.setHour(14);
        time.setMinute(50);
        time.setSecond(10);
        System.out.println("Время установлено пользователем: ");
        time.showTime();
        time.chargeHour(7);
        time.chargeMinute(30);
        time.chargeSecond(45);
        System.out.println("Время изменено на заданое количество: ");
        time.showTime();
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour) {
        if (hour >= 24 || hour < 0) {
            hour = 0;
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute >= 60 || minute < 0) {
            minute = 0;
        }
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second >= 60 || second < 0) {
            second = 0;
        }
        this.second = second;
    }

    public void chargeHour(int hour) {
        if (hour > 0) {
            hour = this.hour + hour;
            if (hour < 24) {
                this.hour = hour;
            }
        }
    }

    public void chargeMinute(int minute) {
        if (minute > 0) {
            minute = this.minute + minute;
            if (minute < 60) {
                this.minute = minute;
            }
            else if (minute < 1440) {
                chargeHour(minute/60);
                setMinute(minute%60);
            }
        }
    }

    public void chargeSecond(int second) {
        if (second > 0) {
            second = this.second + second;
            if (second < 60) {
                this.second = second;
            }
            else if (second < 3600) {
                chargeMinute(second/60);
                setSecond(second%60);
            }
            else if (second < 86400) {
                chargeHour(second/3600);
                chargeMinute((second%3600)/60);
                setSecond(second%60);
            }
        }
    }

    public void showTime() {
        System.out.println("Time now: " + string(hour) + ":" + string(minute) + ":" + string(second));
    }

    private String string(int temp) {
        String string = String.valueOf(temp);
        if (temp <= 9) {
            string = "0" + string;
        }
        return string;
    }
}