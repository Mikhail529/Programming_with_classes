import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLS {
    public static void main(String[] args) {

        // Task 11. Создать объект класса Текст, используя классы Предложение, Слово.
        // Методы: дополнить текст, вывести на консоль текст, заголовок текста

        String title = "From Blood and Ash";

        String book = "I looked up from my cards and across the crimson-painted surface " +
                "to the three men sitting at the table. I’d chosen this spot for a reason. " +
                "I’d…felt nothing from them as I drifted between the crowded tables earlier.\n" +
                "No pain, physical or emotional.\n" +
                "Normally, I didn’t prod to see if someone was in pain. Doing so without reason " +
                "felt incredibly invasive, but in crowds, it was difficult to control just how much " +
                "I allowed myself to feel. There was always someone whose pain cut so deeply, " +
                "was so raw, that their anguish became a palpable entity I didn’t even have to open " +
                "my senses to feel—that I couldn’t ignore and walk away from. " +
                "They projected their agony onto the world around them.\n" +
                "I was forbidden to do anything but ignore. " +
                "To never speak of the gift bestowed upon me by the gods and to never, " +
                "ever go beyond sensing to actually doing something about it.\n" +
                "Not that I always did what I was supposed to do.\n";

        ArrayList<String> stringArrayList = new ArrayList<>();

        Pattern pattern = Pattern.compile(".+\\.\n");
        Matcher matcher = pattern.matcher(book);

        while (matcher.find()) {
            stringArrayList.add(matcher.group());
        }

        Sentence sentence = new Sentence(stringArrayList,title);
        Text text = new Text(stringArrayList,sentence);

        text.sentence.titleText();      // Вывод название текста на консоль
        System.out.println();
        text.printText();               // Вывод текста на консоль
        text.sentence.addText();        // Метод на добавление текста
        System.out.println();
        text.printText();               // Вывод текста на консоль (уже с изменением)
        System.out.println();
    }
}

class Text {
    ArrayList<String> stringArrayList;
    Sentence sentence;

    public Text(ArrayList<String> stringArrayList, Sentence sentence) {
        this.stringArrayList = stringArrayList;
        this.sentence = sentence;
    }

    public void printText() {
        System.out.print("\t\t");
        sentence.titleText();
        for (String s : stringArrayList) {
            System.out.print(s);
        }
    }
}

class Sentence {
    ArrayList<String> stringArrayList;
    private final String title;

    public Sentence(ArrayList<String> stringArrayList, String title) {
        this.stringArrayList = stringArrayList;
        this.title = title;
    }

    public void addText() {
        System.out.println("\nEnter the text you want to add: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        stringArrayList.add(string);
    }

    public void titleText() {
        System.out.println(title);
    }
}

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}