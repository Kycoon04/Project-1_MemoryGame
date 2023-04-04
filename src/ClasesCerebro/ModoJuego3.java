package ClasesCerebro;

import Vista.ModoRevision3Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ModoJuego3 extends ModosdeJuego  {
    public ModoJuego3() {
        NumeroCartas=18;
        NumeroParejas=9;
        RutaImagen=3;
    }

    @Override
    public void CartaSelecionada(String d) {
            switch(d){
         case "Carta1Juego3":
             CartaSelecion(1);
         break;
         case "Carta2Juego3":
             CartaSelecion(2);
         break;
         case "Carta3Juego3":
             CartaSelecion(3);
         break;
         case "Carta4Juego3":
             CartaSelecion(4);
         break;
         case "Carta5Juego3":
             CartaSelecion(5);
         break;
         case "Carta6Juego3":
             CartaSelecion(6);
         break;
         case "Carta7Juego3":
             CartaSelecion(7);
         break;
         case "Carta8Juego3":
             CartaSelecion(8);
         break;
         case "Carta9Juego3":
             CartaSelecion(9);
         break;
         case "Carta10Juego3":
             CartaSelecion(10);
         break;
         case "Carta11Juego3":
             CartaSelecion(11);
         break;
         case "Carta12Juego3":
             CartaSelecion(12);
         break;
         case "Carta13Juego3":
            CartaSelecion(13);
         break;
         case "Carta14Juego3":
             CartaSelecion(14);
         break;
         case "Carta15Juego3":
             CartaSelecion(15);
         break;
         case "Carta16Juego3":
             CartaSelecion(16);
         break;
         case "Carta17Juego3":
             CartaSelecion(17);
         break;
         case "Carta18Juego3":
             CartaSelecion(18);
         break;
         default:break;
        }
    }

    @Override
    public void ModoRevision(BorderPane Juego) {
                Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ModoRevision3.fxml"));
            Parent root = loader.load();
            ModoRevision3Controller modoRevision3Controller = loader.getController();
            modoRevision3Controller.Cargar(Lista);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
