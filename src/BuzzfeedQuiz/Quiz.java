
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Quiz {
        static Scanner sc = new Scanner(System.in);
        public static String name = "";
        public static HashMap<String, Category> playerData = new HashMap<>();
        public static HashMap<String, Integer> categoryData = new HashMap<>();
        public static HashMap<Question, Map<Answer, Integer>> questionData = new HashMap<>();
        
        public static void main() {
                gameIntro();
        }
        
        public static void quiz(String[] args)  {
                // Create Categories
                Category skyward = new Category("Skyward Sword",
                                "The Legend of Zelda: Skyward Sword was released in 2011! You love linear stories with a clear start and end. You love having a clear goal, and probably hate the wild-era games. You love the game's cool motion control swordfighting, but you’ve probably hit your hand on the wall at least once from the janky motion controls. You REALLY, REALLY, REALLY care about the Zelda timeline.\n" + //
                                                                                "");
                Category breath = new Category("Breath of the Wild", "The Legend of Zelda: Breath of the Wild released in 2017! "
                                + "You were probably introduced to Zelda recently, and think all Zelda games are like BotW. You probably hate Skyward Sword for its linear gameplay, and just want to do whatever you want with no clear goals. You are an outdoorsy kind of person, who loves to explore as much as you can. You don’t care about the Zelda timeline.\n" + //
                                                                                "");
                Category ocarina = new Category("Ocarina of Time",
                                "The Legend of Zelda: Ocarina of Time was released in 1998! You love the classics, and think the “Zelda Formula” is a holy grail, and must be worshipped and followed at all costs. You think every Zelda game should have a musical instrument. Your favorite moment of Twilight Princess was probably talking to the Hero’s Shade and finding out it was the Link from OoT. You probably think Oot didn’t make the timeline confusing at all, but in the end, you don’t really care about the timeline.\n" + //
                                                                                "");
                Category wind = new Category("Wind Waker", "Ahoy matey! The Legend of Zelda: The Wind Waker was released in 2002! You love the cartoony artstyle of this game to death, and probably hate that Twilight Princess robbed you of a Wind Waker 2. The vast ocean calls to you, and you want more than anything to sail the seven seas. You enjoy taking a moment to breathe, and take in the wonder of the ocean. You don’t really care about the Zelda timeline.\n" + //
                                                "");

                // Create Questions
                Question q1 = new Question("How would you like to travel?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("By horse", ocarina);
                q1.possibleAnswers[1] = new Answer("By plane",
                                skyward);
                q1.possibleAnswers[2] = new Answer("By walking", breath);
                q1.possibleAnswers[3] = new Answer("By boat", wind);

                Question q2 = new Question("What's your favorite hobby?");
                q2.possibleAnswers[0] = new Answer("Playing an instrument", ocarina);
                q2.possibleAnswers[1] = new Answer("Fencing", skyward);
                q2.possibleAnswers[2] = new Answer("Hiking", breath);
                q2.possibleAnswers[3] = new Answer("Sailing",
                                wind);

                // ... more questions here

                Question q3 = new Question("What's your favorite movie?");
                q3.possibleAnswers[0] = new Answer("Pirates of the Carribbean", wind);
                q3.possibleAnswers[1] = new Answer("Lord of the Rings", breath);
                q3.possibleAnswers[2] = new Answer("The Godfather", ocarina);
                q3.possibleAnswers[3] = new Answer("Dune", skyward);

                Question q4 = new Question("How do you feel about the Zelda timeline?\n" + //
                                                "");
                q4.possibleAnswers[0] = new Answer("The what?", breath);
                q4.possibleAnswers[1] = new Answer("I LOVE IT YIPPEE YAYYYYYYY", skyward);
                q4.possibleAnswers[2] = new Answer("It’s interesting but pretty simple.", ocarina);
                q4.possibleAnswers[3] = new Answer("It’s interesting but too complicated for me :(((((", wind);

                Question q5 = new Question("When were you introduced to Zelda?");

                q5.possibleAnswers[0] = new Answer("2002", wind);
                q5.possibleAnswers[1] = new Answer("2017", breath);
                q5.possibleAnswers[2] = new Answer("1998", ocarina);
                q5.possibleAnswers[3] = new Answer("2011", skyward);

                Question q6 = new Question("What do you think the main theme of the Zelda series is?");

                q6.possibleAnswers[0] = new Answer("A grand overarching tale of destiny and reincarnation", skyward);
                q6.possibleAnswers[1] = new Answer("An adventure game with dungeons done in a SPECIFIC order", ocarina);
                q6.possibleAnswers[2] = new Answer("A fun game that always offers something different in terms of artistic expression", wind);
                q6.possibleAnswers[3] = new Answer("A tale of freedom and exploration that anyone can experience differently", breath);

                Question q7 = new Question("How do you like to move through life?");

                q7.possibleAnswers[0] = new Answer("I like having a distinct goal, making plans for that goal, and following those plans exactly.", skyward);
                q7.possibleAnswers[1] = new Answer("I like to go with the flow, wherever life takes me.", breath);
                q7.possibleAnswers[2] = new Answer("I like to have a consistent routine.", ocarina);
                q7.possibleAnswers[3] = new Answer("I like to take life calmly. There’s no rush. Life is a vast ocean that has to be enjoyed.", wind);

                Question q8 = new Question("Who's your favorite Intermiade Computer Science Student?");

                q8.possibleAnswers[0] = new Answer("Oliver Joffee", breath);
                q8.possibleAnswers[1] = new Answer("Conor Felszcack or Felzack or however you spell his last name", ocarina);
                q8.possibleAnswers[2] = new Answer("Toby Korn", wind);
                q8.possibleAnswers[3] = new Answer("Denver Boone", skyward);

                // Question tiebreak = new Question("What's YOUR favorite Zelda game?");

                // tiebreak.possibleAnswers[0] = new Answer("Skyward Sword", skyward);
                // tiebreak.possibleAnswers[1] = new Answer("Breath of the Wild", breath);
                // tiebreak.possibleAnswers[2] = new Answer("Ocarina of Time", ocarina);
                // tiebreak.possibleAnswers[3] = new Answer("Wind Waker", wind);

                // For each question, ask, read input, store answer.
                //gameIntro();
                
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8};
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { skyward, breath, ocarina, wind };
                // these need to be in the same order or the points will be incorrect!
                ArrayList<Integer> index = getMostPopularCatIndex(cList);
                ArrayList<Answer> tiebreakAnswers = new ArrayList<Answer>(0); 
                //System.out.println("THE COUNT IS" + Integer.toString(index.size()));
                if (index.size() > 1) {
                        
                        
                        Answer ans1 = new Answer("Breath of the Wild", breath);
                        Answer ans2 = new Answer("Wind Waker", wind);
                        Answer ans3 = new Answer("Ocarina of Time", ocarina);
                        Answer ans4 = new Answer("Skyward Sword", skyward);
                        
                        Answer[] possibleTiebreakAnswers = {ans4, ans1, ans3, ans2};

                        //ArrayList<Answer> tiebreakAnswers = new ArrayList<Answer>(0)
                        for (int i = 0; i < index.size(); i ++) {
                                tiebreakAnswers.add(possibleTiebreakAnswers[index.get(i)]);
                                //Question q9 = new Question("What is your favorite Zelda Game?");

                                //System.out.println("The length is " + Integer.toString(tiebreakAnswers.size()));
                                //q9.tie(sc, tiebreakAnswers);
                        }
                        Question q9 = new Question("What is your favorite Zelda Game?");
                        q9.tie(sc, tiebreakAnswers).points ++;
                }

                ArrayList<Integer> fin = getMostPopularCatIndex(cList);
                
                System.out.println("If you were a Zelda game, you would be " + cList[fin.get(0)].label + ". ");
                System.out.println("Youre name is" + name);
                savePlayerData(name, cList[fin.get(0)]);
                saveCategoryData(cList[fin.get(0)].label);
                sc.nextLine();
                System.out.println(cList[fin.get(0)].description);
                gameIntro();

        }

        public static void saveCategoryData(String cat) {
                if (!categoryData.containsKey(cat)) {
                        categoryData.put(cat, 1);
                } else {
                        int old = categoryData.get(cat);
                        categoryData.put(cat, old + 1);
                }
        }

        public static void printCategoryData() {
                Set<String> keys = categoryData.keySet();
                System.out.println("Game, how many times gotten");
                for (String key : keys) {
                        System.out.println(key + ", " + categoryData.get(key));
                }
        }

        public static void savePlayerData(String player, Category category) {
                System.out.println("Saving " + player);
                playerData.put(player, category);
        }

        public static void printPlayerData() {
                Set<String> keys = playerData.keySet();
                System.out.println("Name, Most recent game");
                for (String key : keys) {
                        System.out.println(key + ", " + playerData.get(key).label);
                }
        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which Zelda Game Are You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter a name:");
                name = sc.nextLine();
                System.out.println("Your name is " + name);

                if (play != 1) {
                        System.out.println("Game done.");
                        //gameIntro();
                        printPlayerData();
                        printCategoryData();
                } else {
                        quiz(null);
                }
        }

        

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        public static ArrayList<Integer> getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                ArrayList<Integer> maxIndex = new ArrayList<>();
                
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex.clear();
                                maxIndex.add(i);
                        } else if (counts[i].points == maxCount) {
                                
                                
                                maxIndex.add(i);
                                
                        }
                }
                return maxIndex;
        }
}
