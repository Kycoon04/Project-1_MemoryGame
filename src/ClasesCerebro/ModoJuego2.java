package ClasesCerebro;

import Vista.ModoRevision2Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ModoJuego2 extends ModosdeJuego  {
    public ModoJuego2() {
        NumeroCartas=12;
        NumeroParejas=6;
        RutaImagen=2;
    }

    @Override
    public void CartaSelecionada(String d) {
            switch(d){
         case "Carta1Juego2":
             if(!(getLista().get(0).getCartaAtras().getImage()==getLista().get(0).getCartaAdelante())){
                 
         new animatefx.animation.BounceIn(getLista().get(0).getCartaAtras()).play();
         getLista().get(0).getCartaAtras().setImage(getLista().get(0).getCartaAdelante());
         NuevoA(getLista().get(0).getValor(),getLista().get(0).getCartaAtras());
         }
         break;
         case "Carta2Juego2":
             if(!(getLista().get(1).getCartaAtras().getImage()==getLista().get(1).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(1).getCartaAtras()).play();
         getLista().get(1).getCartaAtras().setImage(getLista().get(1).getCartaAdelante());
         NuevoA(getLista().get(1).getValor(),getLista().get(1).getCartaAtras());
             }
         break;
         case "Carta3Juego2":
             if(!(getLista().get(2).getCartaAtras().getImage()==getLista().get(2).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(2).getCartaAtras()).play();
         getLista().get(2).getCartaAtras().setImage(getLista().get(2).getCartaAdelante());
         NuevoA(getLista().get(2).getValor(),getLista().get(2).getCartaAtras());
             }
         break;
         case "Carta4Juego2":
             if(!(getLista().get(3).getCartaAtras().getImage()==getLista().get(3).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(3).getCartaAtras()).play();
         getLista().get(3).getCartaAtras().setImage(getLista().get(3).getCartaAdelante());
         NuevoA(getLista().get(3).getValor(),getLista().get(3).getCartaAtras());
             }
         break;
         case "Carta5Juego2":
             if(!(getLista().get(4).getCartaAtras().getImage()==getLista().get(4).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(4).getCartaAtras()).play();
         getLista().get(4).getCartaAtras().setImage(getLista().get(4).getCartaAdelante());
         NuevoA(getLista().get(4).getValor(),getLista().get(4).getCartaAtras());
             }
         break;
         case "Carta6Juego2":
             if(!(getLista().get(5).getCartaAtras().getImage()==getLista().get(5).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(5).getCartaAtras()).play();
         getLista().get(5).getCartaAtras().setImage(getLista().get(5).getCartaAdelante());
         NuevoA(getLista().get(5).getValor(),getLista().get(5).getCartaAtras());
             }
         break;
         case "Carta7Juego2":
             if(!(getLista().get(6).getCartaAtras().getImage()==getLista().get(6).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(6).getCartaAtras()).play();
         getLista().get(6).getCartaAtras().setImage(getLista().get(6).getCartaAdelante());
         NuevoA(getLista().get(6).getValor(),getLista().get(6).getCartaAtras());
             }
         break;
         case "Carta8Juego2":
             if(!(getLista().get(7).getCartaAtras().getImage()==getLista().get(7).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(7).getCartaAtras()).play();
         getLista().get(7).getCartaAtras().setImage(getLista().get(7).getCartaAdelante());
         NuevoA(getLista().get(7).getValor(),getLista().get(7).getCartaAtras());
             }
         break;
         case "Carta9Juego2":
             if(!(getLista().get(8).getCartaAtras().getImage()==getLista().get(8).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(8).getCartaAtras()).play();
         getLista().get(8).getCartaAtras().setImage(getLista().get(8).getCartaAdelante());
         NuevoA(getLista().get(8).getValor(),getLista().get(8).getCartaAtras());
             }
         break;
         case "Carta10Juego2":
             if(!(getLista().get(9).getCartaAtras().getImage()==getLista().get(9).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(9).getCartaAtras()).play();
         getLista().get(9).getCartaAtras().setImage(getLista().get(9).getCartaAdelante());
         NuevoA(getLista().get(9).getValor(),getLista().get(9).getCartaAtras());
             }
         break;
         case "Carta11Juego2":
             if(!(getLista().get(10).getCartaAtras().getImage()==getLista().get(10).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(10).getCartaAtras()).play();
         getLista().get(10).getCartaAtras().setImage(getLista().get(10).getCartaAdelante());
         NuevoA(getLista().get(10).getValor(),getLista().get(10).getCartaAtras());
             }
         break;
         case "Carta12Juego2":
             if(!(getLista().get(11).getCartaAtras().getImage()==getLista().get(11).getCartaAdelante())){
         new animatefx.animation.BounceIn(getLista().get(11).getCartaAtras()).play();
         getLista().get(11).getCartaAtras().setImage(getLista().get(11).getCartaAdelante());
         NuevoA(getLista().get(11).getValor(),getLista().get(11).getCartaAtras());
             }
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
