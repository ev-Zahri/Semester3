import java.util.Random;

public class Algoritma {
    Random random = new Random();
    public int[][] player1;
    public int[][] player2;
    public int[][] player3;
    public int[][] player4;

    int[][] colabsArray = new int[28][2];
    int[][] baseQueue = new int[28][2];

    public Algoritma(int[][] player1, int[][] player2, int[][] player3, int[][] player4) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        populateColabsArray();
    }

    private void populateColabsArray() {
        int index = 0;

        for (int[] entry : player1) {
            colabsArray[index][0] = entry[0];
            colabsArray[index][1] = entry[1];
            index++;
        }

        for (int[] entry : player2) {
            colabsArray[index][0] = entry[0];
            colabsArray[index][1] = entry[1];
            index++;
        }

        for (int[] entry : player3) {
            colabsArray[index][0] = entry[0];
            colabsArray[index][1] = entry[1];
            index++;
        }

        for (int[] entry : player4) {
            colabsArray[index][0] = entry[0];
            colabsArray[index][1] = entry[1];
            index++;
        }
    }

    // algoritma masih salah 
    public void playing() {
        boolean onGoing = true;
        int startingPlayer = findValueZero();
        int currentPosition = startingPlayer;
        int indexBaseQuery = 1;
        int skippedPlayers = 0;
    
        while (onGoing) {
            int[] cardPick = loopPlaying(baseQueue, getPlayerArray(currentPosition));
    
            if (cardPick != null && indexBaseQuery <= 27) {
                baseQueue[indexBaseQuery][0] = cardPick[0];
                baseQueue[indexBaseQuery][1] = cardPick[1];
                int temp = baseQueue[0][0];
                baseQueue[0][0] = baseQueue[0][1];
                baseQueue[0][1] = temp;
                currentPosition = (currentPosition % 4) + 1;
                if (currentPosition == 0) {
                    currentPosition = 4;
                }
                indexBaseQuery++;
                skippedPlayers = 0;
            } else {
                skippedPlayers++;
            }
    
            if (skippedPlayers == 3) {
                System.out.println("Winner is player " + currentPosition);
                break;
            }
        }
        // Print the state of the cards at the end of the game
        System.out.print("Final state of the cards:");
        for (int i = 0; i < baseQueue.length; i++) {
            System.out.print("[" + baseQueue[i][0] + ", " + baseQueue[i][1] + "]");
        }
    }    

    public int[] loopPlaying(int[][] query, int[][] player) {
        int[][] tempValues = new int[player.length][2];
        int tempIndex = 0;

        for (int i = 0; i < player.length; i++) {
            if (player[i][0] == query[0][0] || player[i][1] == query[0][1]) {
                tempValues[tempIndex] = player[i];
                tempIndex++;
            }
        }

        if (tempIndex == 0) {
            return null; // No valid cards found
        }

        int randomPick = random.nextInt(tempIndex);
        return tempValues[randomPick];
    }

    private int[][] getPlayerArray(int playerNumber) {
        switch (playerNumber) {
            case 1:
                return player1;
            case 2:
                return player2;
            case 3:
                return player3;
            case 4:
                return player4;
            default:
                return null;
        }
    }

    public int findValueZero() {
        for (int i = 0; i < colabsArray.length; i++) {
            if (colabsArray[i][0] == 0 && colabsArray[i][1] == 0) {
                baseQueue[0][0] = 0;
                baseQueue[0][1] = 0;

                if (i < 7) {
                    return 1;
                } else if (i < 14) {
                    return 2;
                } else if (i < 21) {
                    return 3;
                } else if (i < 28) {
                    return 4;
                }
            }
        }
        return 0;
    }
}
