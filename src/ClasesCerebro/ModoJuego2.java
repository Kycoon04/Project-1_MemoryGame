package ClasesCerebro;

import Vista.ModoRevision2Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ModoJuego2 extends ModosdeJuego  {/*José Manuel Valverde Valverde*/
    public ModoJuego2() {
        NumeroCartas=12;
        NumeroParejas=6;
        RutaImagen=2;
    }

    @Override
    public void CartaSelecionada(String d) {
            switch(d){
         case "Carta1Juego2":
             CartaSelecion(1);
         break;
         case "Carta2Juego2":
             CartaSelecion(2);
         break;
         case "Carta3Juego2":
             CartaSelecion(3);
         break;
         case "Carta4Juego2":
             CartaSelecion(4);
         break;
         case "Carta5Juego2":
             CartaSelecion(5);
         break;
         case "Carta6Juego2":
             CartaSelecion(6);
         break;
         case "Carta7Juego2":
             CartaSelecion(7);
         break;
         case "Carta8Juego2":
             CartaSelecion(8);
         break;
         case "Carta9Juego2":
             CartaSelecion(9);
         break;
         case "Carta10Juego2":
             CartaSelecion(10);
         break;
         case "Carta11Juego2":
             CartaSelecion(11);
         break;
         case "Carta12Juego2":
             CartaSelecion(12);
         break;
         default:break;
        }
    }

    @Override
    public void ModoRevision(BorderPane paneOriginal) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ModoRevision2.fxml"));
            Parent root = loader.load();
            ModoRevision2Controller modoRevision2Controller = loader.getController();
            modoRevision2Controller.Cargar(Lista);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
