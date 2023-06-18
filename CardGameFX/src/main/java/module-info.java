module com.game.cardgamefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.cardgamefx to javafx.fxml;
    exports com.game.cardgamefx;
}