package CardGame;
public class SpeedComputer {
    Speed game;
    int count = 0;

    public SpeedComputer(Speed newGame) {
        game = newGame;
    }
    public void draw() {
        count++;
        if (count % 60 == 0) {
            for (int i = 0; i < game.playerTwoHand.getSize(); i++) {
                if (game.playCard(game.playerTwoHand.getCard(i), game.playerTwoHand, game.discard1)) {
           
                    
                    return;
                }
                if (game.playCard(game.playerTwoHand.getCard(i), game.playerTwoHand, game.discard2)) {
                
                    return;
                }
            }
            if (game.playerTwoHand.getSize() < 5 && game.playerTwoDeck.size() > 0) {
                game.drawCard(game.playerTwoHand, game.playerTwoDeck);
         
                return;
            }
            game.checkForPlays();

        }
        
    }

}
