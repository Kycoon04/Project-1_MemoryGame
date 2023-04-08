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

public class ModoRevision3Controller implements Initializable {

    @FXML
    private ImageView Carta2Juego3;
    @FXML
    private ImageView Carta3Juego3;
    @FXML
    private ImageView Carta4Juego3;
    @FXML
    private ImageView Carta5Juego3;
    @FXML
    private ImageView Carta8Juego3;
    @FXML
    private ImageView Carta9Juego3;
    @FXML
    private ImageView Carta10Juego3;
    @FXML
    private ImageView Carta11Juego3;
    @FXML
    private ImageView Carta6Juego3;
    @FXML
    private ImageView Carta12Juego3;
    @FXML
    private ImageView Carta1Juego3;
    @FXML
    private ImageView Carta7Juego3;
    @FXML
    private ImageView Carta13Juego3;
    @FXML
    private ImageView Carta14Juego3;
    @FXML
    private ImageView Carta15Juego3;
    @FXML
    private ImageView Carta16Juego3;
    @FXML
    private ImageView Carta18Juego3;
    @FXML
    private ImageView Carta17Juego3;
    @FXML
    private BorderPane ModoRevision3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void Cargar(ArrayList<ClaseCarta> Lista){
       Carta1Juego3.setImage(Lista.get(0).getCartaAdelante());
       Carta2Juego3.setImage(Lista.get(1).getCartaAdelante());
       Carta3Juego3.setImage(Lista.get(2).getCartaAdelante());
       Carta4Juego3.setImage(Lista.get(3).getCartaAdelante());
       Carta5Juego3.setImage(Lista.get(4).getCartaAdelante());
       Carta6Juego3.setImage(Lista.get(5).getCartaAdelante());
       Carta7Juego3.setImage(Lista.get(6).getCartaAdelante());
       Carta8Juego3.setImage(Lista.get(7).getCartaAdelante());
       Carta9Juego3.setImage(Lista.get(8).getCartaAdelante());
       Carta10Juego3.setImage(Lista.get(9).getCartaAdelante());
       Carta11Juego3.setImage(Lista.get(10).getCartaAdelante());
       Carta12Juego3.setImage(Lista.get(11).getCartaAdelante());
       Carta13Juego3.setImage(Lista.get(12).getCartaAdelante());
       Carta14Juego3.setImage(Lista.get(13).getCartaAdelante());
       Carta15Juego3.setImage(Lista.get(14).getCartaAdelante());
       Carta16Juego3.setImage(Lista.get(15).getCartaAdelante());
       Carta17Juego3.setImage(Lista.get(16).getCartaAdelante());
       Carta18Juego3.setImage(Lista.get(17).getCartaAdelante());
    }

    @FXML
    private void click(MouseEvent event) {
    }
 
}