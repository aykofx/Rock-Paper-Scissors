// Fxml controller class

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class Controller {
	
    // Labels to display player and computer scores
    @FXML
    private Label playerScoreLabel;

    @FXML
    private Label computerScoreLabel;
    
    // Score variables to track the number of wins
    private int playerScore = 0;
    private int computerScore = 0;
    
    // Methods for the buttons | calls the playGame method
    public void rock(ActionEvent e) {
	playGame("Rock");
    }
	
    public void paper(ActionEvent e) {
	playGame("Paper");
    }
	
    public void scissors(ActionEvent e) {
	playGame("Scissors");
    }
	
    /**
     * Compares the player's choice with the computer's choice
     * Updates the score and displays the result
     */
    private void playGame(String playerChoice) {
    	// Array containing possible choices for the game
        String[] choices = {"Rock", "Paper", "Scissors"};
        // Randomly select a choice for the computer
        String computerChoice = choices[new Random().nextInt(choices.length)];

        // Determine the game result
        String message;
        if (playerChoice.equals(computerChoice)) {
            message = "It's a tie! Both chose " + playerChoice + ".";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            playerScore++;
            message = "You win! " + playerChoice + " beats " + computerChoice + ".";
        } else {
            computerScore++;
            message = "You lose! " + computerChoice + " beats " + playerChoice + ".";
        }

        // Update score labels
        playerScoreLabel.setText(String.valueOf(playerScore));
        computerScoreLabel.setText(String.valueOf(computerScore));

        // Display the game result in a JavaFX pop-up
        showResultDialog("Game Result", message);
    }
    
    
    // Method for the pop up message
    private void showResultDialog(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
	

}
