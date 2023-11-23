public class Execute {
    public static void main(String[] args) {
        int[][] player1 = Operation.getRandomElements(7);
        int[][] player2 = Operation.getRandomElements(7);
        int[][] player3 = Operation.getRandomElements(7);
        int[][] player4 = Operation.getRandomElements(7);

        Operation.printArray(player1);
        Operation.printArray(player2);
        Operation.printArray(player3);
        Operation.printArray(player4);

        Algoritma algoritma = new Algoritma(player1, player2, player3, player4);
        // System.out.println();
        algoritma.playing();
    }
}
