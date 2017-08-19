package shapy.appz;

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
            {"New York", "Shanghai", "Dubai"},
            {"1945","1956", "1955"},
            {"Neptune", "Earth", "Jupiter"},
            {"Orange","Blue","Green"},
            {"Seoul","Beijing","Pjöngjang"},
            {"Hydrogen","Oxygen","Helium"},
            {"Negative", "No charge", "Positive"},
            {"1","0.800","1.4"},
            {"Right","Left","Both the same"},
            {"1988","1996","1989"},
            {"Shirts","Shoes","Coats"},
            {"2001","2000","2004"},
            {"Tom Hanks", "Leonardo DiCaprio","Robert De Niro"},
            {"1961","1950","1970"},
            {"2001","2003","2004"},
            {"A youtuber", "An actor", "A song writer"},
            {"A tech-company","A song","A calculator"},
            {"Kibatarō","Alexander Fleming", "Dr. Brayn"},
            {"1915-1919","1913-1915","1914-1918"},
            {"developed the telescope","discovered four satellites of Jupiter", "All two are right"},
            {"H2SO4","SHCL","S"},
            {"1939","1940","1950"},
            {"Fred Trump","Barron Trump","Victor Trump"},
            {"America", "Great Britain", "Australia"},
            {"Yes", "No, they produce shoes", "Samsung doesn't even exist!"},
            {"Human immunodeficiency virus", "Human immune viper", "Human immune virus"},
            {"Pressure","Temperature","Energy"},
            {"The unit of force","A brand new computer","None of them"},
            {"Slave","Fire","Car"},
            {"5","65","35"},
            {"Pacific Ocean","Atlantic","Indian"},
            {"8","12","10"},
            {"Once every 2 years","Once every 4 years", "Once every 6years"},
            {"Sahara","The Antarctic desert","Arctic desert"},
            {"North Pole","South Pole","Italy"},
            {"Wladimir Wladimirowitsch Putin","Wladimir Putin","Vladimir Vlamiro Putin"},
            {"Austria","Germany","Italy"},
            {"1988","2001","1998"},
            {"Kabul","Tirana","Luanda"},
            {"Lisbon","Praia","Santiago"},
            {"Phoneutria","Cross spider","Tegenaria ferruginea"},
            {"15.26","17.12","16"},
            {"Larry Page","Jeff Bezos","Liu Chuanzhi"},
            {"The founder of Microsoft","The founder of Apple","The founder of Samsung"},
            {"Light energy diode","Light emitting diode","Light enrapture diode"},
            {"the Goblet of Fire","the Philosopher's Stone","the Order of the Phoenix"},
            {"Wolfgang Amadeus", "Wolfgang Johann", "Hermann Amadeus"},
            {"A sport", "a store", "an instrument"},
            {"7x7 squares", "8x8 squares", "9x9 squares"},
            {"Mont Blanc", "Ortler", "Matterhorn"},
            {"Sahara", "Atacama desert", "Patagonian desert"},
            {"Magneto", "The Joker", "Bane"},
            {"Nollywood", "Hollywood", "Bollywood"},
            {"Sotschi", "Vancouver", "Turin"},
            {"Mexico City", "Istanbul", "Alexandria"},
            {"Los Angeles", "New York", "Washington D. C."},
            {"28", "32", "24"},
            {"1 to 3 Million", "1 to 10 Million", "1 to 300.000"},
            {"Lusaka", "Lima", "Kuala Lumpur"},
            {"Tehran", "Tiraspol", "Tripoli"},
            {"A type of a digital currency", "The in-game currency", "The currency of Iran"},
            {"Bass per minute", "Beats per minute", "Beats per moment"},
            {"206", "300", "150"},
            {"300 meter", "200 meter", "350 meter"},
            {"Judo", "Lacrosse", "Rugby and football"},
            {"Twenty-one","Magic-card","Lucky-card"},
            {"Turkey","Egypt","Australia"},
            {"Hawaii","Himalayas","Honshu"},
            {"Paris","Antibes","Bordeaux"},
            {"2.55 meter", "2.72 meter","2.68 meter"},
            {"January 1941", "November 1942","December 1941"},
            {"A gun used by the USA army", "An atomic bomb","A war plane"},
            {"Nile","Amazon","Mississippi"},
            {"6.992 km","6.853 km","6.300 km"},
            {"920 m","816.5","828 m"},
            {"A New Hope","The Phantom Menace","The Empire Strikes Back"},
            {"January 2013","June 2012","September 2011"},
            {"Tráthnóna maith","Maidin mhaith","Conas a oibríonn"},
            {"2007","1991","1998"},
            {"2005","2004","2013"},
            {"4","3","2"},
            {"Free to peer","Free to pear","Free to play"},
            {"Podgorica","Pristina","Lusaka"},
            {"Planet","Satellite","Star"},
            {"Acetyl salt acid", "Acetyl salicylic acid","Acetyl ammonia acid"},
            {"70%","60%","45-50%"},
            {"One -> February", "Febrauary once four years","All"},
            {"12","8","16"}


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
            "Which actor won the most Oskars?",
            "Which is the strongest company on earth?",
            "When was the Coca-Cola Company foundet?",
            "In witch city is the highest building located?",
            "Which year did Albert Einstein die?",
            "Which is the largest planet in our solar system",
            "What color is Cerulean?",
            "What is the capital of South Korea?",
            "Which is the first element in the periodic system?",
            "What type of charge does a Neutron have?",
            "How many kilograms does an average human brain weigh?",
            "Which side of the human brain has more neurons?",
            "What year did the Berlin wall fall?",
            "Brogues are ____",
            "When was Wikipedia launched?",
            "Who was the protagonist of Inception?",
            "When was Barack Obama born?",
            "When was Facebook founded?",
            "Who is PewDiePie?",
            "What is Oneplus",
            "Who discovered Penicillin?",
            "World War I was from ___ till ___?",
            "Galileo was an Italian astronomer who:",
            "Which of theese is the chemical formula of sulfuric acid?",
            "When did Germany attack France during World War 2?",
            "What's the name of Donald Trumps son?",
            "Where is the Great Barrier Reef?",
            "Does the company Samsung produce watches?",
            "Whats the full term of HIV?",
            "Joule is the unit of:",
            "What is Newton?",
            "The latin name ignis means:",
            "How many muscles does it need to move your hand?",
            "What is the largest ocean in the world?",
            "How many planets are in our solar system?",
            "What is the frequency of Olympics?",
            "Which of these is the biggest desert of the world?",
            "Where do penguins live?",
            "What is the full name of the russian president Putin?",
            "Where was the dictator Hitler born?",
            "When was Google founded?",
            "What is the capital of Albania?",
            "What is the capital of Chile?",
            "One of the most dangerous spiders is the:",
            "What is approximately the squareroot of 233",
            "Who is the  founder of Amazon?",
            "Who is Bill Gates?",
            "What is the full term of LED?",
            "The first Harry Potter movie was Harry Potter and:",
            "The name of Mozart was?",
            "What is NOT named Decathlon?",
            "How big is a chess field?",
            "Which is the highest mountain of the alps?",
            "Which desert is located in south america?",
            "Who is NOT an enemy of Batman?",
            "Which film studio produces most movies a year?",
            "Where were the winter olympics 2014 located?",
            "Which is the only city located on two continents at the same time?",
            "Hollywood is a part of?",
            "How many teeth do adult humans have?",
            "What is the probability to get hit by a lightning?",
            "What is the capital of Malaysia?",
            "What is the capital of Iran?",
            "What are Bitcoins?",
            "What does BPM stand for?",
            "How many bones does an average adult have?",
            "How high is the Eiffel tower?",
            "The national sport of Canada is:",
            "Blackjack is also known as:",
            "Where is the Lake Hillier situated?",
            "Where is the Mauna Kea situated?",
            "Where is the Louvre Museum situated?",
            "How high was/is the tallest man of the world?",
            "When was the attack on Pearl Harbor?",
            "Which object has had the codename Little Boy?",
            "Which is the longest river on earth?",
            "How many km is the longest river on earth long?",
            "How high is the Burj Khalifa without the tip?",
            "What was the first Star Wars movie?",
            "When was the initial release of the app: Snapchat?",
            "What is good morning in Irish?",
            "When was the release date of the movie: the Silence of the Lambs?",
            "The festival Tommorrowland was the first time held in?",
            "What is the value of 'x':  4 - 3 + x = 5 - 2",
            "What is the full term of f2p?",
            "What is the capital of Kosovo?",
            "The moon is a:",
            "The common name of 'Aspirin' is?",
            "How many liters water does an ADULT have in its body?",
            "How many months have 28 days?",
            "How may rips does a human have?"



    };



    private final String mCorrectAnswers[] = {
            "1993", "-272,15", "The active substance of marijuana",
            "8", "12","Uranus","NaCl","John F. Kennedy",
            "Denmark","12","14","not","Wolgograd","six","South Korea","Ra","Alabama","Monopoly","Japan","Division by 0 is not defined","periodic system",
            "11", "Titanic", "1776", "8848m", "China", "5", "1236 km/h", "Usain Bolt", "194", "Mercury", "Katherine Hepburn", "Apple", "1892", "Dubai",
            "1955","Jupiter","Blue","Seoul","Hydrogen","No charge","1.4","Left","1989","Shoes","2001","Leonardo DiCaprio","1961","2004","A youtuber",
            "A tech-company","Alexander Fleming","1914-1918",
            "All two are right","H2SO4","1940","Barron Trump","Australia","Yes","Human immunodeficiency virus","Energy","The unit of force","Fire",
            "35","Pacific Ocean","8","Once every 4 years","The Antarctic desert", "South Pole","Wladimir Wladimirowitsch Putin",
            "Austria","1998","Tirana","Santiago","Phoneutria","15.26","Jeff Bezos","The founder of Microsoft","Light emitting diode","the Philosopher's Stone",
            "Wolfgang Amadeus", "an instrument", "8x8 squares", "Mont Blanc", "Atacama desert", "Magneto", "Bollywood", "Sotschi",
            "Istanbul", "Los Angeles","32", "1 to 3 Million", "Kuala Lumpur", "Tehran", "A type of a digital currency", "Beats per minute",
            "206", "300 meter", "Lacrosse","Twenty-one","Australia","Hawaii","Paris","2.72","December 1941","An atomic bomb",
            "Amazon","6.992 km","828 m","A New Hope","September 2011","Maidin mhaith","1991","2005","2","Free to play","Pristina",
            "Satellite","Acetyl salicylic acid","45-50%","All","12"
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