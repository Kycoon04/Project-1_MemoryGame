package Vista;

import ClasesCerebro.ClaseCarta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ModoRevision2Controller implements Initializable {

    @FXML
    private ImageView Carta2Juego2;
    @FXML
    private ImageView Carta3Juego2;
    @FXML
    private ImageView Carta4Juego2;
    @FXML
    private ImageView Carta5Juego2;
    @FXML
    private ImageView Carta8Juego2;
    @FXML
    private ImageView Carta9Juego2;
    @FXML
    private ImageView Carta10Juego2;
    @FXML
    private ImageView Carta11Juego2;
    @FXML
    private ImageView Carta6Juego2;
    @FXML
    private ImageView Carta12Juego2;
    @FXML
    private ImageView Carta1Juego2;
    @FXML
    private ImageView Carta7Juego2;
    @FXML
    private BorderPane ModoRevision2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void Cargar(ArrayList<ClaseCarta> Lista){
       Carta1Juego2.setImage(Lista.get(0).getCartaAdelante());
       Carta2Juego2.setImage(Lista.get(1).getCartaAdelante());
       Carta3Juego2.setImage(Lista.get(2).getCartaAdelante());
       Carta4Juego2.setImage(Lista.get(3).getCartaAdelante());
       Carta5Juego2.setImage(Lista.get(4).getCartaAdelante());
       Carta6Juego2.setImage(Lista.get(5).getCartaAdelante());
       Carta7Juego2.setImage(Lista.get(6).getCartaAdelante());
       Carta8Juego2.setImage(Lista.get(7).getCartaAdelante());
       Carta9Juego2.setImage(Lista.get(8).getCartaAdelante());
       Carta10Juego2.setImage(Lista.get(9).getCartaAdelante());
       Carta11Juego2.setImage(Lista.get(10).getCartaAdelante());
       Carta12Juego2.setImage(Lista.get(11).getCartaAdelante());
    }

    @FXML
    private void click(MouseEvent event) {
    }
}