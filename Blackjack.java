import java.util.Scanner;

public class Blackjack {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        P1Random rng = new P1Random();
        /*
        After setting up this class, I introduced most of the variables I would need to use for this
        project. I set up the numberOfGames variable as a sum of other variables that represent the
        number of ties, player wins and dealer wins.
         */
        int playerHand = 0;
        int option;
        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;
        int numberOfGames = playerWins + dealerWins + ties;
        int currentGameNumber = 1 + numberOfGames;
        /*
        I then proceeded to add the invariable "Start game" statement and randomly generated the player's
        first card, all of which occur before the program enters the while loop.
         */
        System.out.println("START GAME #" + currentGameNumber);
        System.out.println("");
        int cardDraw = rng.nextInt(13) + 1;
        /*
        I needed to write some if/else if statements to make sure that the player hand's value is correct
        and so that the program assigns a value of 10 to numbers 11 - 13 from the number generator. The if/else if
        statements also dictate what statements are printed. This if/else if loop is often repeated later in the
        program.
         */
        if (cardDraw >= 1 && cardDraw <= 10) {
            playerHand = playerHand + cardDraw;
            if (cardDraw == 1) {
                System.out.println("Your card is a ACE!");
            } else {
                System.out.println("Your card is a " + cardDraw + "!");
            }
        } else if (cardDraw == 11) {
            playerHand = playerHand + cardDraw - 1;
            System.out.println("Your card is a JACK!");
        } else if (cardDraw == 12) {
            playerHand = playerHand + cardDraw - 2;
            System.out.println("Your card is a QUEEN!");
        } else if (cardDraw == 13) {
            playerHand = playerHand + cardDraw - 3;
            System.out.println("Your card is a KING!");
        }
        /*
        I printed the options while also introducing the scanner that allows users to choose from options 1 - 4.
         */
        System.out.println("Your hand is: " + playerHand);
        System.out.println("");
        System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
        System.out.println("");
        System.out.print("Choose an option: ");
        option = scnr.nextInt();
        System.out.println("");

        /*
        I then wrote the while loop, which I wrote to last for whenever the number of games is greater than or
        equal to 0, which is all the time. I wrote this because the only time the program should exit the while loop
        is when the user enters 4 into the option scanner.
         */
        while (numberOfGames >= 0) {
            /*
            The first part of the first if branch is almost identical to the last if/else if section.
             */
            if (option == 1) {
                cardDraw = rng.nextInt(13) + 1;
                if (cardDraw >= 1 && cardDraw <= 10) {
                    playerHand = playerHand + cardDraw;
                    if (cardDraw == 1) {
                        System.out.println("Your card is a ACE!");
                    } else {
                        System.out.println("Your card is a " + cardDraw + "!");
                    }
                } else if (cardDraw == 11) {
                    playerHand = playerHand + cardDraw - 1;
                    System.out.println("Your card is a JACK!");
                } else if (cardDraw == 12) {
                    playerHand = playerHand + cardDraw - 2;
                    System.out.println("Your card is a QUEEN!");
                } else if (cardDraw == 13) {
                    playerHand = playerHand + cardDraw - 3;
                    System.out.println("Your card is a KING!");
                }
                /*
                The program should now print the value of the player's hand, summing up all the cards he/she has
                accrued till this point.
                 */
                System.out.println("Your hand is: " + playerHand);
                System.out.println("");

                /*
                The following if/else if statements dictate what the program does for each outcome of the
                values of the playerHand.
                 */
                if (playerHand == 21) {
                    System.out.println("BLACKJACK! You win!");
                    System.out.println("");
                    /*
                    At the end of each game, I need to add to either the player's wins, the dealer's wins or
                    the number of ties. I then update the number of games by calling upon the equation that equates the
                    number of games to the sum of player wins, dealer wins, and ties. This helps for when a player
                    wants to see their game stats in option 3.
                     */
                    playerWins = playerWins + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    /*
                    The main difference between the following if/else if statements and the previous ones is I reset
                    the value of playerHand to 0 before initiating the if/else if commands. This lets the program
                    "reset" the games.
                     */
                    cardDraw = rng.nextInt(13) + 1;
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                    /*
                    I now print the menu of options again.
                     */
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("");
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                } else if (playerHand > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println("");
                    /*
                    Again the number of games completed is completed by adding to the dealer wins and calling the
                    equation for number of games.
                     */
                    dealerWins = dealerWins + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    /*
                    I again call upon the familiar if/else if statements to help reset the game.
                     */
                    cardDraw = rng.nextInt(13) + 1;
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                    /*
                    As done many times before, I print the statements that should be present at the start of each
                    new game.
                     */
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("");
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                    /*
                    The following else statement covers the possibility that a conclusion to the game has not been
                    reached. At this point, the options menu will be brought back up and the player will go to the
                    start of the while loop.
                     */
                } else {
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                }
            } else if (option == 2) {
                /*
                I use the same class to call a random number between 16 and 26 for the dealer's hand. I then print it
                and use if/else if statements to dictate the result of the game based on this. Unlike option one,
                a result to the game is decided regardless of what the dealer's hand is.
                 */
                int dealerHand = rng.nextInt(11) + 16;
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println("");
                if (dealerHand > 21) {
                    /*
                    In this case, the dealer wins and the number of player wins and total games played are appended.
                     */
                    System.out.println("You win!");
                    System.out.println("");
                    playerWins = playerWins + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    cardDraw = rng.nextInt(13) + 1;
                    /*
                    Again, I use the following code to reset and reassign the value of the player's hand.
                     */
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                    /*
                    The following code re states the player's options.
                     */
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("");
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                }
                else if (dealerHand == playerHand) {
                    /*
                    This case leads to a tie. In this case, the number of ties is added to.
                     */
                    System.out.println("It's a tie! No one wins!");
                    System.out.println("");
                    ties = ties + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    cardDraw = rng.nextInt(13) + 1;
                    /*
                    The player's hand is reset and reassigned.
                     */
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                    /*
                    The following code re-states the users options after the round is over.
                     */
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("");
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                }

                /*
                The next two else if statements cover the possibility that either the dealer's hand equals 21 or neither the dealer or the player exceeds
                21.
                 */
                else if (dealerHand == 21 || (dealerHand < 21 && playerHand < 21 && dealerHand > playerHand)) {
                    System.out.println("Dealer wins!");
                    System.out.println("");
                    dealerWins = dealerWins + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    cardDraw = rng.nextInt(13) + 1;
                    /*
                    The player's hand is reset.
                     */
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                    /*
                    The set of options are redisplayed for the player.
                     */
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("");
                    System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println("");
                }
                else if ((dealerHand < 21 && playerHand < 21 && dealerHand < playerHand)) {
                    System.out.println("You win!");
                    System.out.println("");
                    playerWins = playerWins + 1;
                    numberOfGames = playerWins + dealerWins + ties;
                    currentGameNumber = 1 + numberOfGames;
                    System.out.println("START GAME #" + currentGameNumber);
                    System.out.println("");
                    cardDraw = rng.nextInt(13) + 1;
                    /*
                    After the number of games played is appended, the player's hand is reset.
                     */
                    playerHand = 0;
                    if (cardDraw >= 1 && cardDraw <= 10) {
                        playerHand = playerHand + cardDraw;
                        if (cardDraw == 1) {
                            System.out.println("Your card is a ACE!");
                        } else {
                            System.out.println("Your card is a " + cardDraw + "!");
                        }
                    } else if (cardDraw == 11) {
                        playerHand = playerHand + cardDraw - 1;
                        System.out.println("Your card is a JACK!");
                    } else if (cardDraw == 12) {
                        playerHand = playerHand + cardDraw - 2;
                        System.out.println("Your card is a QUEEN!");
                    } else if (cardDraw == 13) {
                        playerHand = playerHand + cardDraw - 3;
                        System.out.println("Your card is a KING!");
                    }
                }
                /*
                Now we move onto the output if the user enters option 3.
                 */
            }
            else if (option == 3) {
                /*
                Most of this else if statement is basic print statements that print the value of variables that have
                been added to through the course of the program.
                 */
                System.out.println("Number of Player wins: " + playerWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + ties);
                System.out.println("Total # of games played is: " + numberOfGames);
                /*
                I introduce the double versions of playerWins and numberOfGames so that I can calculate the player's
                win percentage in decimal form. I introduce a double variable for this calculation.
                 */
                double playerWinsDecimal = playerWins;
                double numberOfGamesDecimal = numberOfGames;
                double playerWinPct = playerWinsDecimal / numberOfGamesDecimal * 100;
                System.out.println("Percentage of Player wins: " + playerWinPct + "%");
                System.out.println("");
                /*
                The options are restated.
                 */
                System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                option = scnr.nextInt();
                System.out.println("");
            }
            /*
            The following option allows the user to exit from the while loop and terminate the program.
             */
            else if (option == 4) {
                break;
            }
            /*
            The following else statement is written to produce an error statement if an integer other than 1 - 4 is
            entered in the options scanner. It also re states the users options.
             */
            else {
                System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                System.out.println("");
                System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                option = scnr.nextInt();
                System.out.println("");
            }
            }
        }
    }

