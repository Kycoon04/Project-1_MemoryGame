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
             if(!(getLista().get(0).getCartaAtras().getImage()==getLista().get(0).getCartaAdelante())){
              new animatefx.animation.BounceIn(getLista().get(0).getCartaAtras()).play();
         getLista().get(0).getCartaAtras().setImage(getLista().get(0).getCartaAdelante());
         NuevoA(getLista().get(0).getValor(),getLista().get(0).getCartaAtras());
         }
         break;
         case "Carta2":
             if(!(getLista().get(1).getCartaAtras().getImage()==getLista().get(1).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(1).getCartaAtras()).play();
         getLista().get(1).getCartaAtras().setImage(getLista().get(1).getCartaAdelante());
         NuevoA(getLista().get(1).getValor(),getLista().get(1).getCartaAtras());
             }
         break;
         case "Carta3":
             if(!(getLista().get(2).getCartaAtras().getImage()==getLista().get(2).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(2).getCartaAtras()).play();
         getLista().get(2).getCartaAtras().setImage(getLista().get(2).getCartaAdelante());
         NuevoA(getLista().get(2).getValor(),getLista().get(2).getCartaAtras());
             }
         break;
         case "Carta4":
             if(!(getLista().get(3).getCartaAtras().getImage()==getLista().get(3).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(3).getCartaAtras()).play();
         getLista().get(3).getCartaAtras().setImage(getLista().get(3).getCartaAdelante());
         NuevoA(getLista().get(3).getValor(),getLista().get(3).getCartaAtras());
             }
         break;
         case "Carta5":
             if(!(getLista().get(4).getCartaAtras().getImage()==getLista().get(4).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(4).getCartaAtras()).play();
         getLista().get(4).getCartaAtras().setImage(getLista().get(4).getCartaAdelante());
         NuevoA(getLista().get(4).getValor(),getLista().get(4).getCartaAtras());
             }
         break;
         case "Carta6":
             if(!(getLista().get(5).getCartaAtras().getImage()==getLista().get(5).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(5).getCartaAtras()).play();
         getLista().get(5).getCartaAtras().setImage(getLista().get(5).getCartaAdelante());
         NuevoA(getLista().get(5).getValor(),getLista().get(5).getCartaAtras());
             }
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
