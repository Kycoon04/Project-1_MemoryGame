package ClasesCerebro;

import Vista.ModoRevision1Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ModoJuego1 extends ModosdeJuego  {
    public ModoJuego1() {
        NumeroCartas=6;
        NumeroParejas=3;
        RutaImagen=1;
    }
    @Override
    public void CartaSelecionada(String d){
    switch(d){
         case "Carta1":
             CartaSelecion(1);
         break;
         case "Carta2":
             CartaSelecion(2);
         break;
         case "Carta3":
             CartaSelecion(3);
         break;
         case "Carta4":
             CartaSelecion(4);
         break;
         case "Carta5":
             CartaSelecion(5);
         break;
         case "Carta6":
             CartaSelecion(6);
         break;
         default:break;
        }
    }
    
    @Override
    public void ModoRevision(BorderPane paneOriginal) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ModoRevision1.fxml"));
            Parent root = loader.load();
            ModoRevision1Controller modoRevision1Controller = loader.getController();
            modoRevision1Controller.Cargar(Lista);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
