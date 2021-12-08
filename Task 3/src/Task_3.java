public class CLS {
    public static void main(String[] args) {

        // Task 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
        // успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
        // Добавьте возможность вывода фамилии и номеров групп студентов, имеющих оценки, равные только 9 и 10

        dataMethod();
    }

    public static void dataMethod() {
        Student[] studArray = new Student[10];
        Student student1 = new Student("D.W", "Owens",18710, new int[]{7,5,8,9,8});
        Student student2 = new Student("J.U", "Gilmore", 20991, new int[]{9,8,7,8,9});
        Student student3 = new Student("E.O", "French", 92858, new int[]{10,9,10,9,10});
        Student student4 = new Student("K.Q", "Haynes", 34407, new int[]{7,8,7,8,9});
        Student student5 = new Student("H.T", "Spencer", 50207, new int[]{5,5,7,7,9});
        Student student6 = new Student("R.P", "Fox", 73058, new int[]{5,7,9,8,7});
        Student student7 = new Student("P.W", "Matthews", 95046, new int[]{7,6,8,9,5});
        Student student8 = new Student("M.B", "Cannon", 89784, new int[]{9,9,9,9,9});
        Student student9 = new Student("L.M", "Porter",27703, new int[]{5,9,7,8,2});
        Student student10 = new Student("F.T", "Adams", 49213, new int[]{9,9,10,9,10});

        studArray[0] = student1;
        studArray[1] = student2;
        studArray[2] = student3;
        studArray[3] = student4;
        studArray[4] = student5;
        studArray[5] = student6;
        studArray[6] = student7;
        studArray[7] = student8;
        studArray[8] = student9;
        studArray[9] = student10;

        method(studArray);
    }

    public static void method(Student[] studArray) {
        System.out.println("Students with grades of only 9 and 10: \n");

        for (Student student : studArray) {
            int temp = 0;
            for (int j = 0; j < student.progress.length; j++) {
                int progress = student.progress[j];
                if (progress >= 9) {
                    temp++;}
            }
            if (temp == student.progress.length) {
                System.out.println("GroupNumber: " + student.groupNumber + "\tSurname: " + student.surname);
            }
        }
    }
}

class Student {
    String initials;
    String surname;

    int groupNumber;
    int[] progress;
    
    public Student(String initials, String surname, int groupNumber, int[] progress) {
        this.initials = initials;
        this.surname = surname;
        this.groupNumber = groupNumber;
        this.progress = progress;
    }
}