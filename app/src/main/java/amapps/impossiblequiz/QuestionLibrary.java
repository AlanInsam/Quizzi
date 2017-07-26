package amapps.impossiblequiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionLibrary {
//Arrays begin: the choices, question and the answer
    private final String[] [] mChoices ={
            {"1993", "1986", "1967"},
            {"-260", "-272,15", "279,15"},
            {"a plant","The active substance of marijuana" , "a spider"},
            {"6", "10","8"},
            {"12","15","10"},
            {"Uranus","Neptune","Saturn"},
            {"HCl","NaCl","CO"},
            {"John F. Kennedy", "Richard Nixon","James A. Garfield"},
            {"Canada","Denmark", "Greenland is an own state!"},
            {"12","20","14"},
            {"10","12","14"},
            {"not","never","now"},
            {"Leningrad","Wolgograd","Dimitrijgrad"},
            {"six","five","three"},
            {"Germany","France","South Korea"},
            {"Ra","Ba","Rd"},
            {"Alabama","Alaska","California"},
            {"Snakes and Ladders","Ludo","Monopoly"},
            {"China","Vietnam","Japan"},
            {"1","0","Division by 0 is not defined"},
            {"Element table", "periodic system", "periodic table"},
            {"11", "13", "9"},
            {"Forrest Gump", "West Side Story", "Titanic"},
            {"1776", "1789", "1876"},
            {"8952m", "8747m", "8848m"},
            {"India", "China", "USA"},
            {"5", "3", "4"},
            {"1236 km/h", "1165km/h", "1280km/h"},
            {"Yohan Blake", "Tyson Gay", "Usain Bolt"},
            {"211", "199", "194"},
            {"Mars", "Mercury", "Venus"},
            {"Katherine Hepburn", "Jack Nicholson", "Robert De Niro"},
            {"Microsoft", "Amazon", "Apple"},
            {"1892", "1912", "1899"},
            {"New York", "Shanghai", "Dubai"}

    };
    private final String mQuestions[] = {
            "When was the European Union founded?",
            "How many Grad Celsius is one Kelvin?",
            "What is THC?",
            "How many legs has a spider?",
            "How many stars has the European flag?",
            "Which is the seventh planet from the sun?",
            "What is the chemical formula of salt?",
            "Who said: Ich bin ein berliner?",
            "To which country belongs Greenland?",
            "What is the result of: 2 + 2 *5?",
            "How many mountains are higher than 8000 meter/26.246 ft?",
            "A famous quote is: to be, or____ to be!",
            "What is the name of Stalingrad nowadays?",
            "How many Apollo missions landed men on the moon?",
            "In which country will the 2018 Winter Olympics be held?",
            "What is the chemical symbol for 'Radium'?",
            "If you list all 50 States of America in alphabetical order, which comes first?",
            "In which board game would you find a top hat, a boot, a flatiron, and a car?",
            "Which country's flag consists of a red circle on a white background?",
            "What is 5/0 ?",
            "What is the name of the table in which the chemical elements are listed?",
            "How many players does a soccer team have?",
            "Which film has won the most Oscars?",
            "When was the declaration of independence signed?",
            "How high is the mount everest?",
            "Which country has the highest population?",
            "4+2/2",
            "How fast is the speed of sound?",
            "Who is currently the fastest man on earth?",
            "How many nations exist on earth?",
            "What is the nearest planet to the sun?",
            "Witch actor won the most Oskars?",
            "Witch is the strongest company on earth?",
            "When was the Coca-Cola Company foundet?",
            "In witch city is the highest building located?"


    };



    private final String mCorrectAnswers[] = {
            "1993", "-272,15", "The active substance of marijuana",
            "8", "12","Uranus","NaCl","John F. Kennedy",
            "Denmark","12","14","not","Wolgograd","six","South Korea","Ra","Alabama","Monopoly","Japan","Division by 0 is not defined","periodic system",
            "11", "Titanic", "1776", "8848m", "China", "5", "1236 km/h", "Usain Bolt", "194", "Mercury", "Katherine Hepburn", "Apple", "1892", "Dubai"

    };
//Array list will be created important for the randomizer
    private final List<Integer> indexes = new ArrayList<>();

    public QuestionLibrary() {
        for (int i = 0; i < mQuestions.length; ++i)
            indexes.add(i);
    }

    private int index(int i) {
        return indexes.get(i);
    }

    public String getQuestion(int a) {
        return mQuestions[index(a)];
    }

    public String getChoice1(int a) {
        return mChoices[index(a)][0];
    }

    public String getChoice2(int a) {
        return mChoices[index(a)][1];
    }

    public String getChoice3(int a) {
        return mChoices[index(a)][2];
    }

    public String getCorrectAnswer(int a) {
        return mCorrectAnswers[index(a)];
    }

    public int getLength() {
        return mQuestions.length;
    }

   //shuffles
    public void shuffle() {
        Collections.shuffle(indexes);
    }



}