/**
 * Author : Zachary Zawodny
 * Class : ITN262
 * Date : 3/7/2023
 * Assignment : Stack Card Game
 */
package com.game.cardgamefx;

import static com.game.cardgamefx.CardGame.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class CardGameApplication extends Application {

    private Text gameText = new Text("Press Start Game To Begin");
    private Text winnerText = new Text();
    private Button startGameButton = new Button("Start Game");

    private TilePane gameMenu = new TilePane(startGameButton);
    private VBox vbox = new VBox(gameText, winnerText);

    private BorderPane border = new BorderPane();
    private Scene scene = new Scene(border, 600, 300);

    @Override
    public void start(Stage stage) throws IOException {
        configureUI();
        stage.setScene(scene);
        stage.setTitle("Card Game");
        stage.show();
    }

    private void configureUI() {
        gameText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 17));
        winnerText.setTextAlignment(TextAlignment.CENTER);
        winnerText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        gameMenu.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        border.setCenter(vbox);
        border.setBottom(gameMenu);

        startGameButton.setOnAction(e -> startGame());
    }

    private void startGame() {
        resetGame();
        createDeck();
        shuffleDeck();
        createPlayerDecks();
        simulateGame();
        gameText.setText("Player 1's Cards: "+ player1WinDeck.length() + "\n"
                + "Player 2's Cards: "+ player2WinDeck.length());

        if (player1WinDeck.length() > player2WinDeck.length()){
            winnerText.setText("Player 1 Wins!");
        }
        else if (player2WinDeck.length() > player1WinDeck.length()){
            winnerText.setText("Player 2 Wins!");
        }
        else {
            winnerText.setText("Draw!");
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
