import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CardCombat {

    //This is the slowprint method. Every Time I need to slowprint something, I call this while passing in a string. It slows it down and then prints it.
    //This specific slowprint method delays for 1000 ms or 1 seconds.
    public static void slowPrint1(String output) {

        //The for loop basically goes through the string and tries to print it.
        for (int c = 0; c<output.length(); c++) {
            char d = output.charAt(c);
            System.out.print(d);
        }
        //This part is what delays the print statement.
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        catch (Exception e) {

        }
    }

    //This is the same slowprint method from above, just that there is 2000 ms or 2 seconds wait time instead. There are places in the code where this is where 1 seconds is too short.
    public static void slowPrint2(String output) {

        //The for loop basically goes through the string and tries to print it.
        for (int c = 0; c<output.length(); c++) {
            char d = output.charAt(c);
            System.out.print(d);
        }
        //This part is what delays the print statement.
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        }
        catch (Exception e) {

        }
    }

    //This prints the Instructions when called upon. I am using slowprint here too so that they don't print all at the same time.
    public static void Instructions () {
        slowPrint2 ("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        slowPrint1("\nHere are the instructions: ");
        slowPrint2("\nThe game is divided into tasks 1 and task 2. In order for you to move on to task 2, you have to complete task 1.");
        slowPrint2("\nTask 1 will be repeated 3 times. You have to win 2 out of the 3 rounds to move onto task 2.");
        slowPrint2("\nTask 2 will be repeated for 5 rounds and then you will be informed whether you have won or lost the game.");
        slowPrint2("\nWinning and losing will be calculated by points.");
        slowPrint2("\nHow points work for task 1 and task 2 will be explained later.");
        slowPrint1("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        slowPrint1("\nFinally let's talk about the point system.");
        slowPrint2("\nWhen a user wins a round, the user's card is taken and the value of the computer card is subtracted from it. The leftover points are then added to the total points the user has.");
        slowPrint2("\nThe user starts with a total of 20 points. If they manage to get over 30 points, they win. And if they get less than 10 points, they lose.");
        slowPrint1("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        slowPrint2("\nThese are your general instructions for now and Good Luck!");
    }

    //This is the code provided by you, to clear the screen. I call to it every time I want to clear the screen.
    public static void clearScreen(){

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 

        catch (Exception E) { 
            System.out.println(E);
        }

    }

    /*This creates a deck of cards. Things to note: This array only contains numbers from 1 to 13. It does not contain the TYPES Of the cards.
     *That is going to be a separatearray. The array is made in integer formatting where the Ace, Joker, Queen, and the King are replaced with numbers.
     *This makes it much easier for calculations later on in the code.
     */
    public static int [] Deck () {

        //This creates an array with 13 empty places where our card number values will be stored.
        int [] Deck = new int [13];
        //This variable stores the values that will be assigned to the array. So basically it will be the placeholder of the values before they are assigned to the array.
        int count = 0;
        //This for loop assign the values
        for (int c = 0; c<Deck.length; c++) {
            //This is where the value is increased because we don't want to assign 0's to every index.
            count++;
            Deck[c] = count; 
        }

        //Now we return the Deck array to the main program.
        return Deck;
    }

    //Like mentioned before, this is the array of types. It stores the types of cards there are. It will be used in task 2.
    public static String[] Types() {
        //First we create a string with 4 empty indexes.
        String [] types = new String [4];
        //Then we assign the values we want.
        types[0] = "Hearts";
        types[1] = "Clubs";
        types[2] = "Diamonds";
        types[3] = "Spades";

        //Finally we return the array back to the main program.
        return (types);
    }

    //This is where the number deck is sent back to be shuffled.
    public static int[] ShuffledDeck (int[] deck) {

        //First you create a random variable to generate a random number
        Random rand = new Random();

        //This is a for loop where the random number is generated, and swaps the values of the array.
        for (int c = 0; c < deck.length; c++) {
            //Generates a random number.
            int randomIndexToSwap = rand.nextInt(deck.length);
            //Uses the temp variable to store the value that is inside that random index.
            int temp = deck[randomIndexToSwap];
            //Assigns a different value to that random index.
            deck[randomIndexToSwap] = deck[c];
            //Finally, the value in the temp variable is assigned to the index that was assigned before.
            deck[c] = temp;
        }

        //Returns the shuffled array.
        return deck;
    }

    //This explains the instructions the user needs for task 1. Different slowprint's were used here as well
    public static void Task1_instructions () {
        slowPrint2("\nWelcome Back! Since Task 1 is about to begin, the rules will be explained.");
        slowPrint2("\nTask 1 consists of a total of 3 rounds.");
        slowPrint2("\nThe user has to win 2 of the 3 rounds for the user to move onto Task 2.");
        slowPrint2("\nA random card is picked for the user and for the computer.");
        slowPrint2("\nIgnoring the types (hearts, diamonds and so on) of the cards, only the numbers will matter in task 1");
        slowPrint2("\nThe user will have a chance to choose a random card again if they are not satisfied with their first card");
        slowPrint2("\nBut be careful! the computer will also have a chance to rechoose their card.");
        slowPrint1("\n");
        slowPrint2("\nHere is the list of the index of the cards:");
        slowPrint1("\nAce = 1");
        slowPrint1("\n2 = 2");
        slowPrint1("\n3 = 3");
        slowPrint1("\n4 = 4");
        slowPrint1("\n5 = 5");
        slowPrint1("\n6 = 6");
        slowPrint1("\n7 = 7");
        slowPrint1("\n8 = 8");
        slowPrint1("\n9 = 9");
        slowPrint1("\n10 = 10");
        slowPrint1("\nJoker = 11");
        slowPrint1("\nQueen = 12");
        slowPrint1("\nKing = 13");
        slowPrint1("\n");
        slowPrint1("\nIn the order that they have appeared is how they are ranked. King has greater value than Ace for example.");
        slowPrint1("\nThat's enough of the rules, now let the game begin!");
        slowPrint1("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    /*Finally this is where our task 1 begins. We create a method that receives the shuffled deck from the main program. We are going to be 
     *returning some information to the main program that will be needed to move on to the task 2, which is why we are using 'int[] task 1' rather
     *than void.
     */
    public static int[] Task1 (int []ShuffledDeck) {

        //This calls the task 1 instructions method that displays all the instructions specifically for task 1.
        Task1_instructions();
        //This clears the screen after the instructions are displayed.
        clearScreen();

        //Creates a new Scanner
        Scanner in = new Scanner (System.in);

        //Creates a random generator
        Random rand = new Random();

        //These 2 variables are used to hold the random generated card values.
        int computer, user;
        //This keeps track of how many rounds have passed so that the game can be repeated 3 times.
        int rounds = 0;
        //This keeps track of how many times the user has won the game to determine whether they are eligible to move onto task 2 or not.
        int count = 0;
        //This keeps track of the user's points.
        int points = 20;
        //This creates an array that we need to return at the end of this method. We are going to be returning the points and the count variable.
        int [] information = new int [2];

        //The while loop for the game begins here.
        while (rounds < 3) {

            rounds++;

            //This if else structure tells the user which round is starting.
            if (rounds == 1) {
                slowPrint1("\nLet round 1 begin!");
                slowPrint1("\n-------------------------------------------------------------------------------------------------------------------------------------");
            }
            else if (rounds == 2) {
                slowPrint1("\nLet round 2 begin!");
                slowPrint1("\n-------------------------------------------------------------------------------------------------------------------------------------");
            }
            else {
                slowPrint1("\nLast the final round begin!");
                slowPrint1("\n-------------------------------------------------------------------------------------------------------------------------------------");
            }

            //Generates a random index value for the computer.
            int randomindexforcomputer = rand.nextInt(13);
            //Assigns the random index value of the shuffled deck to the variable, computer.
            computer = ShuffledDeck[randomindexforcomputer];

            //Generates a random index value for the user.
            int randomindexforuser = rand.nextInt(13);
            //Assigns the random index value of the shuffled deck to the variable, user.
            user = ShuffledDeck[randomindexforuser];

            //Asks the user whether they want to re-pick a card or not.
            slowPrint1("\nYour the number on your current card is " + user);
            slowPrint1("\nIf you are not satisfied with your current card, would you like to pick again? Types 'yes' or 'no'.");
            //Variable where the user's choice is stored
            String choice = in.nextLine();

            //This while loop error checks to see if the user is entering the values we want them to enter or not. If not, then we keep asking them for the correct value until they put one in.
            while ( (!choice.equals("no")) && (!choice.equals("yes")) ) {
                slowPrint1("\nPlease enter in a valid value");
                choice = in.nextLine();
            }

            //If the user chooses no and wants to keep their card, we keep going.
            if (choice.equals("no")) {
                slowPrint1("\n\nAlright then, good luck!");
            }

            //If the user chooses yes and wants to repick their card, we do it for them.
            else {

                //Generates a random number and assigns that index value from shuffled deck to computer.
                randomindexforcomputer = rand.nextInt(13);
                computer = ShuffledDeck[randomindexforcomputer];

                //Generates a random number and assigns that index value from the shuffled deck to the user.
                randomindexforuser = rand.nextInt(13);
                user = ShuffledDeck[randomindexforuser];

                slowPrint1("\nNew values have been chosen, Good Luck!");
            }

            //This is where it is determined whether the user has won or lost the game.
            //If the value of the user is greater than the computer, they have won.
            if (user > computer) {
                //This keeps track that they have won
                count++;
                //Prints a congratulations message
                slowPrint2("\nYou have won the game! The computer had " + computer + " while you had " + user);
                slowPrint2("");

                //Keeps track of points
                points = points + (user-computer);

                //Displays current points.
                slowPrint2("\nYou have " + points + " points right now.");

            }

            //If it is a tie
            else if (user == computer) {
                //Prints a congratulations message
                slowPrint2("\nIt was a tie! The computer had " + computer + " while you had " + user);
                slowPrint2("");

                //Displays current points.
                slowPrint2("\nYou have " + points + " points right now.");
            }

            //If it is neither a win or a draw, then it is a loss.
            else {

                //Prints a message informing the user they have lost.
                slowPrint2("\nYou have lost the game. The computer had " + computer + " while you had " + user);
                slowPrint2("");

                //Keeps track of points
                points = points - (computer-user);

                //Displays current points.
                slowPrint2("\nYou have " + points + " points right now.");

            }

            //Clears the screen
            clearScreen();

            //Assigns the values to the array after round 3.
            if (rounds == 3) {
                information [0] = count;
                information [1] = points;
            }

        }

        //Returns the information we need later on.
        return (information);

    }

    //These are the instructions for task 2
    public static void Task2_instructions() {
        slowPrint2("This is where the Task 2 is going to start!");
        slowPrint2("Here are the instructions:");
        slowPrint2("There will be 5 cards dealt out to the user and the computer.");
        slowPrint2("There will be a random card drawn out of the pile and used as the starting point.");
        slowPrint2("The user and the computer have to put down a card from their pile that is the same type.");
        slowPrint2("Or to put down a card of the same number but different types.");
        slowPrint2("However, you when putting a card of a differnt type, it cannot be higher or lower to the card on top of the pile");
        slowPrint2("Whoever manages to get rid of most of their cards from their respective piles, wins the game");
        slowPrint2("Alright then, Lets begin!");
    }

    //This is where task 2 begins.
    public static void Task2 () {

        Task2_instructions();

    }

    //This is the main program.
    public static void main(String[] args) {

        //Creates a new Scanner
        Scanner in = new Scanner (System.in);

        //Prints a welcome message and asks the user whether they want to see the instructions or not.
        slowPrint1("Hello and welcome to CardCombat!");
        slowPrint1("\nIt is a card game played between the player and the computer.");
        slowPrint1("\nLet's get started! But first, it is highly recommended that you look at the rules.");
        slowPrint1("\nDo you wish to look at the rules or not? Type 'yes' or 'no'.");
        System.out.println("");
        //Takes the user's reply and stores it in 'user'.
        String user = in.nextLine();

        //Error checks so that the user only puts in 'yes' or 'no'. Keep asking for a value otherwise.
        while ( (!user.equals("yes")) && (!user.equals("no"))) {
            slowPrint1("\nInvalid value! Please type either yes or no.");
            System.out.println("");
            user = in.nextLine();
        }

        //If they want to see the instructions then we call it here.
        if (user.equals("yes")) {
            Instructions();
        }
        //If they don't, then we skip and move on.
        else {
            slowPrint1("\nAlright then let's move on!");
        }

        //Clear the screen before moving onto task 1
        clearScreen();

        //Stores the deck array received from the method Deck()
        int [] deck = Deck();
        //Stores the types array received from the method Types()
        String [] types = Types();

        //This calls upon the shuffled method and passes in the deck array. Then it stores it into an array named ShuffledDeck
        int [] ShuffledDeck = ShuffledDeck(deck);

        //This is needed so that we can keep track of what the user wants. 
        String user2 = "no";

        //This do while loop calls upon task 1. Then after receiving the information provided on how many rounds the user has won or lost, it moves from there before proceeding to task 2.
        do {

            //Call to task 1 and perform the task.
            int [] information = Task1 (ShuffledDeck);

            //Check if the user has won more 2 times or more
            if (information[0] >= 2) {
                //Ask if they want to proceed onto task 2
                slowPrint1("\nYou have finished task 1. You have won! Would you like to proceed onto task 2? Type 'yes' or 'no'.\n");
                user = in.nextLine();

                //Error checking here
                while ( (!user.equals("yes")) && (!user.equals("no"))) {
                    slowPrint1("\nInvalid value! Please type either yes or no.");
                    System.out.println("");
                    user = in.nextLine();
                }

                //If they want to move on, then we call task 2.
                if (user.equals ("yes")) {
                    Task2 ();
                }

                //If they don't want to move on, then we exit the while loop and end the program.
            }

            //This checks if the user loses or not.
            else if (information[0] < 2) {

                //Ask them if they want to restart the game or not.
                slowPrint1("\nTask 1 is finished. You have lost! Would you like to restart the game? Type 'yes' or 'no'.\n");
                user2 = in.nextLine();

                //Error checking
                while ( (!user2.equals("yes")) && (!user2.equals("no"))) {
                    slowPrint1("\nInvalid value! Please type either yes or no.");
                    System.out.println("");
                    user2 = in.nextLine();
                }

            }

            //If they want to restart the game then we go back to the top and follow the while loop. If they don't then it exits the while loop and moves from there.
        } while (user2.equals("yes"));

    }
}

