/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vista;

import ClasesCerebro.ClaseCarta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author jomav
 */
public class ModoRevision1Controller implements Initializable {

    @FXML
    private BorderPane VistaJuego1;
    @FXML
    private ImageView Carta1;
    @FXML
    private ImageView Carta2;
    @FXML
    private ImageView Carta3;
    @FXML
    private ImageView Carta4;
    @FXML
    private ImageView Carta5;
    @FXML
    private ImageView Carta6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    public void Cargar(ArrayList<ClaseCarta> Lista){
       Carta1.setImage(Lista.get(0).getCartaAdelante());
       Carta2.setImage(Lista.get(1).getCartaAdelante());
       Carta3.setImage(Lista.get(2).getCartaAdelante());
       Carta4.setImage(Lista.get(3).getCartaAdelante());
       Carta5.setImage(Lista.get(4).getCartaAdelante());
       Carta6.setImage(Lista.get(5).getCartaAdelante());
    }
}