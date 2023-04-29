package Controlador;

import ClasesCerebro.ClaseCarta;
import ClasesCerebro.ModosdeJuego;
import ClasesCerebro.ModoJuego1;
import ClasesCerebro.ModoJuego2;
import ClasesCerebro.ModoJuego3;
import ClasesCerebro.Puntaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
public class VistaJuegoController implements Initializable {
    int contador=0;
    long tiempoMaximoEntreClics = 1000;
    ModosdeJuego Facil = new ModoJuego1();
    ModosdeJuego Medio = new ModoJuego2();
    ModosdeJuego Dificil = new ModoJuego3();
    
    
    /*ATRIBUTOS JAVAFX-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private BorderPane VistaPrincipal;
    @FXML
    private BorderPane VistaInformacion;
    @FXML
    private BorderPane VistaPonerNombre;
    @FXML
    private BorderPane VistaJuego1;
    @FXML
    private BorderPane VistaModosdeJuego;
    @FXML
    private BorderPane VistaDificultad;
    @FXML
    private TextField campo1; /*CAMPO PARA INSERTAR NOMBRE*/    
    @FXML
    private TextField campo2; /*CAMPO PARA INSERTAR NOMBRE*/  
    @FXML
    private TextField campo3; /*CAMPO PARA INSERTAR NOMBRE*/  
    @FXML
    private TextField campo4; /*CAMPO PARA INSERTAR NOMBRE*/  
    @FXML
    private Text tiempo;
    @FXML
    private Text pts1;
    @FXML
    private Text pts2;
    @FXML
    private ImageView Carta1;
    @FXML
    private ImageView Carta2;
    @FXML
    private ImageView Carta3;
    @FXML
    private ImageView Carta4;
    @FXML
    private ImageView Carta6;
    @FXML
    private ImageView Carta5;
    @FXML
    private Text username1;
    @FXML
    private Text username2;
    @FXML
    private ChoiceBox<String> CantidadCartas = new ChoiceBox<String>();
    @FXML
    private ChoiceBox<Integer> TiempoMaxTotal = new ChoiceBox<Integer>();
    @FXML
    private ChoiceBox<Integer> TiempoMaxJugador= new ChoiceBox<Integer>();
    @FXML
    private CheckBox botonCartasAutomaticas;
    @FXML
    private CheckBox checkPvsPc;
    @FXML
    private CheckBox checkPvsP;
    @FXML
    private Pane VistaFinalizar;
    @FXML
    private Text TiempoTotal;
    @FXML
    private Text Ganador;
    @FXML
    private Text PuntosJugador1;
    @FXML
    private Text PuntosJugador2;
    @FXML
    private Text Nombre1;
    @FXML
    private Text Nombre2;
    @FXML
    private BorderPane tablaPuntajes;
    @FXML
    private TableColumn TablaJugador1;
    @FXML
    private TableColumn TablaJugador2;
    @FXML
    private TableView<Puntaje> Tabla;
    @FXML
    private BorderPane VistaJuego2;
    @FXML
    private ImageView Carta1Juego2;
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
    private ImageView Carta6Juego2;
    @FXML
    private ImageView Carta7Juego2;
    @FXML
    private ImageView Carta11Juego2;
    @FXML
    private ImageView Carta12Juego2;
    @FXML
    private BorderPane VistaJuego3;
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
    private CheckBox BotonDificultadFacil;
    @FXML
    private CheckBox BotonDificultadMedia;
    @FXML
    private CheckBox BotonDificultadDificil;
    @FXML
    private ImageView Carta18Juego3;
    @FXML
    private ImageView Carta17Juego3;
    @FXML
    private BorderPane VistaExplicacion;
    @FXML
    private CheckBox PuntoAdicional;
    @FXML
    private CheckBox CastigoPunto;
    @FXML
    private CheckBox TresCartas;
    @FXML
    private CheckBox CartaComodin;
    /*FIN ATRIBUTOS JAVAFX---------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    CantidadCartas.getItems().add("6");
    CantidadCartas.getItems().add("12");
    CantidadCartas.getItems().add("18");
    CantidadCartas.setValue("6");
    TiempoMaxTotal.getItems().add(2);
    TiempoMaxTotal.getItems().add(5);
    TiempoMaxTotal.getItems().add(8);
    TiempoMaxTotal.setValue(2);
    TiempoMaxJugador.getItems().add(20);
    TiempoMaxJugador.getItems().add(25);
    TiempoMaxJugador.getItems().add(30);
    TiempoMaxJugador.setValue(20);
    VistaPrincipal.toFront();
    this.TablaJugador1.setCellValueFactory(new PropertyValueFactory("Jugador1"));
    this.TablaJugador2.setCellValueFactory(new PropertyValueFactory("puntaje1"));
    VistaPonerNombre.setPickOnBounds(true);
        
    }
    /*BOTONES PANTALLA INICIAL-----------------------------------------------------------------------------------------------------------------------------------------------------*/    
    @FXML
    private void MostrarInformacion(ActionEvent event) {
         VistaInformacion.toFront();
    }
    @FXML
    private void VistaPonerNombre(ActionEvent event) {
        VistaPonerNombre.toFront();
    }
    private void VolverInformacion(MouseEvent event) {
        VistaPrincipal.toFront();
    }
    @FXML
    private void IniciarJuego(ActionEvent event) {
        AnalizarConfiguracion();
        switch(CantidadCartas.getValue()){
            case "6": cargarParametros(Facil);IniciarFacil();break;
            case "12": cargarParametros(Medio);IniciarMedio();break;
            case "18": cargarParametros(Dificil);IniciarDificil();break;
            default:break;
        }
    }
    @FXML
    private void VistaModoJuego(ActionEvent event) {
        VistaModosdeJuego.toFront();
    }
    @FXML
    private void VistaDificultad(ActionEvent event) {
        VistaDificultad.toFront();
    }
    @FXML
    private void TablaDePuntajes(ActionEvent event) {
        tablaPuntajes.toFront();
    }
    @FXML
    private void modoRevision(ActionEvent event) {
        switch(CantidadCartas.getValue()){
            case "6": Facil.ModoRevision(VistaJuego1);break;
            case "12": Medio.ModoRevision(VistaJuego2);break;
            case "18": Dificil.ModoRevision(VistaJuego3);break;
            default:break;
        }
    }
    @FXML
    private void Explicacion(ActionEvent event) {
        VistaExplicacion.toFront();
    }
    /*FIN BOTONES PANTALLA INICIAL-------------------------------------------------------------------------------------------------------------------------------------------------*/ 
    
    /*BOTONES SALIR----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void SalirJuego(ActionEvent event) {
    VistaPrincipal.toFront();
        switch(CantidadCartas.getValue()){
            case "6": FinalizoJuego(Facil);break;
            case "12": FinalizoJuego(Medio);break;
            case "18": FinalizoJuego(Dificil);break;
            default:break;
        }
    }
    /*FIN BOTONES SALIR----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void Facil(ActionEvent event) {
        if(BotonDificultadFacil.isSelected()){
        BotonDificultadMedia.setDisable(true);
        BotonDificultadDificil.setDisable(true);
        }else{
        BotonDificultadMedia.setDisable(false);
        BotonDificultadDificil.setDisable(false);
        }
    }
    @FXML
    private void Media(ActionEvent event) {
        if(BotonDificultadMedia.isSelected()){
        BotonDificultadFacil.setDisable(true);
        BotonDificultadDificil.setDisable(true);
        }else{
        BotonDificultadFacil.setDisable(false);
        BotonDificultadDificil.setDisable(false);
        }
    }
    @FXML
    private void Dificil(ActionEvent event) {
        if(BotonDificultadDificil.isSelected()){
        BotonDificultadFacil.setDisable(true);
        BotonDificultadMedia.setDisable(true);
        }else{
        BotonDificultadFacil.setDisable(false);
        BotonDificultadMedia.setDisable(false);
        }
    }
    /*FIN BOTONES ACEPTAR--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void click(MouseEvent event) {
    if(TresCartas.isSelected()){
    ReguladorClicks(event,3);
    }else{
    ReguladorClicks(event,2);
    }
}
    public void IniciarFacil(){
        ClaseCarta[] cartas = new ClaseCarta[] {
        new ClaseCarta(Carta1,1),
        new ClaseCarta(Carta2,2),
        new ClaseCarta(Carta3,3),
        new ClaseCarta(Carta4,4),
        new ClaseCarta(Carta5,5),
        new ClaseCarta(Carta6,6),
    };
    for (ClaseCarta carta : cartas) {
        Facil.getLista().add(carta);
    }
    VistaJuego1.toFront();
    Facil.CargarNumero();
    Facil.CargarImagen();
    if(CartaComodin.isSelected()){
         Facil.CargarComodin();
    }
    Facil.Iniciar(VistaFinalizar, Tabla,TiempoMaxTotal.getValue(),TiempoMaxJugador.getValue());
    }
    public void IniciarMedio(){
        ClaseCarta[] cartas = new ClaseCarta[] {
        new ClaseCarta(Carta1Juego2,1),
        new ClaseCarta(Carta2Juego2,2),
        new ClaseCarta(Carta3Juego2,3),
        new ClaseCarta(Carta4Juego2,4),
        new ClaseCarta(Carta5Juego2,5),
        new ClaseCarta(Carta6Juego2,6),
        new ClaseCarta(Carta7Juego2,7),
        new ClaseCarta(Carta8Juego2,8),
        new ClaseCarta(Carta9Juego2,9),
        new ClaseCarta(Carta10Juego2,10),
        new ClaseCarta(Carta11Juego2,11),
        new ClaseCarta(Carta12Juego2,12),
    };
    for (ClaseCarta carta : cartas) {
        Medio.getLista().add(carta);
    }
    VistaJuego1.toFront();
    VistaJuego2.toFront();
    Medio.CargarNumero();
    Medio.CargarImagen();
    if(CartaComodin.isSelected()){
         Medio.CargarComodin();
    }
    Medio.Iniciar(VistaFinalizar, Tabla,TiempoMaxTotal.getValue(),TiempoMaxJugador.getValue());
    }
        public void IniciarDificil(){
        ClaseCarta[] cartas = new ClaseCarta[] {
        new ClaseCarta(Carta1Juego3,1),
        new ClaseCarta(Carta2Juego3,2),
        new ClaseCarta(Carta3Juego3,3),
        new ClaseCarta(Carta4Juego3,4),
        new ClaseCarta(Carta5Juego3,5),
        new ClaseCarta(Carta6Juego3,6),
        new ClaseCarta(Carta7Juego3,7),
        new ClaseCarta(Carta8Juego3,8),
        new ClaseCarta(Carta9Juego3,9),
        new ClaseCarta(Carta10Juego3,10),
        new ClaseCarta(Carta11Juego3,11),
        new ClaseCarta(Carta12Juego3,12),
        new ClaseCarta(Carta13Juego3,13),
        new ClaseCarta(Carta14Juego3,14),
        new ClaseCarta(Carta15Juego3,15),
        new ClaseCarta(Carta16Juego3,16),
        new ClaseCarta(Carta17Juego3,17),
        new ClaseCarta(Carta18Juego3,18),
    };
    for (ClaseCarta carta : cartas) {
        Dificil.getLista().add(carta);
    }
    VistaJuego1.toFront();
    VistaJuego3.toFront();
    Dificil.CargarNumero();
    Dificil.CargarImagen();
    if(CartaComodin.isSelected()){
        Dificil.CargarComodin();
    }
    Dificil.Iniciar(VistaFinalizar, Tabla,TiempoMaxTotal.getValue(),TiempoMaxJugador.getValue());
    }
    public void cargarParametros(ModosdeJuego obj){
        
     obj.getParametrosText().add(username1);
     obj.getParametrosText().add(username2);
     obj.getParametrosText().add(pts1);
     obj.getParametrosText().add(pts2);
     obj.getParametrosText().add(Ganador);
     obj.getParametrosText().add(TiempoTotal);
     obj.getParametrosText().add(PuntosJugador1);
     obj.getParametrosText().add(PuntosJugador2);
     obj.getParametrosText().add(Nombre1);
     obj.getParametrosText().add(Nombre2);
     obj.getParametrosText().add(tiempo);
    }
    public void FinalizoJuego(ModosdeJuego obj){
    obj.reset();
    obj.Limpiar(obj.getLista(),obj.getNumerosEncontrados(),username1,username2,pts1,pts2);
    }
    
    public void ReguladorClicks(MouseEvent event, int NumCartas){
        tiempoMaximoEntreClics = CartaComodin.isSelected() ? 50 : 1000;
        if (contador < NumCartas) { /*Si alguien con mala voluntad para buscar errores podria darle click a 3 cartas a la vez, sabiendo que esta programado para que compare 2 cartas*/
        contador++;     /*Esto lo que hace es que al segundo click seguido se bloquee y no permita dar mas*/
        if (contador == NumCartas) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(tiempoMaximoEntreClics), ae -> {
                contador = 0;
            }));
            timeline.play();
        }
        switch (CantidadCartas.getValue()) {
            case "6":
                Facil.Juego(event, Tabla, VistaFinalizar);
                break;
            case "12":
                Medio.Juego(event, Tabla, VistaFinalizar);
                break;
            case "18":
                Dificil.Juego(event, Tabla, VistaFinalizar);
                break;
            default:
                break;
        }
    }
    }
    public void AnalizarConfiguracion(){
        Facil.setPersonavscomputadora(checkPvsPc.isSelected());
        Medio.setPersonavscomputadora(checkPvsPc.isSelected());
        Dificil.setPersonavscomputadora(checkPvsPc.isSelected());
        if(checkPvsP.isSelected()){
            if(campo1.getText().isEmpty()){
               username1.setText("Jugador 1");
               username2.setText("Jugador 2");
            }else{
            username1.setText(campo1.getText());
            username2.setText(campo2.getText());
            }
        }
        else{
            if(campo3.getText().isEmpty()){
               username1.setText("Jugador 1");
               username2.setText("Jugador 2");
            }else{
            username1.setText(campo3.getText());
            username2.setText(campo4.getText());
            }
        }
         if(TresCartas.isSelected()){
         Facil.setTresCartas(true); Facil.setNumeroParejas(2);
         Medio.setTresCartas(true); Medio.setNumeroParejas(4);
         Dificil.setTresCartas(true); Dificil.setNumeroParejas(6);
         }else{
         Facil.setTresCartas(false); Facil.setNumeroParejas(3);
         Medio.setTresCartas(false); Medio.setNumeroParejas(6);
         Dificil.setTresCartas(false); Dificil.setNumeroParejas(9);
         }
         Facil.setPuntoAdicional(PuntoAdicional.isSelected());
         Medio.setPuntoAdicional(PuntoAdicional.isSelected());
         Dificil.setPuntoAdicional(PuntoAdicional.isSelected());
         Facil.setCastigoPunto(CastigoPunto.isSelected());
         Medio.setCastigoPunto(CastigoPunto.isSelected());
         Dificil.setCastigoPunto(CastigoPunto.isSelected());
         Facil.setCartaComodin(CartaComodin.isSelected());
         Medio.setCartaComodin(CartaComodin.isSelected());
         Dificil.setCartaComodin(CartaComodin.isSelected());
         
        if(BotonDificultadFacil.isSelected()){
        Facil.setDificultad(5);
        Medio.setDificultad(5);
        Dificil.setDificultad(5);
        }
        if(BotonDificultadMedia.isSelected()){
        Facil.setDificultad(12);
        Medio.setDificultad(12);
        Dificil.setDificultad(12);
        }
        if(BotonDificultadDificil.isSelected()){
        Facil.setDificultad(50);
        Medio.setDificultad(50);
        Dificil.setDificultad(50);
        }
        Facil.setReacomodo(botonCartasAutomaticas.isSelected());
        Medio.setReacomodo(botonCartasAutomaticas.isSelected());
        Dificil.setReacomodo(botonCartasAutomaticas.isSelected());
        
    }

    @FXML
    private void CheckPersonavsPersona(ActionEvent event) {
        if(checkPvsP.isSelected()){
        checkPvsPc.setDisable(true);
        campo3.setDisable(true);
        campo4.setDisable(true);
        }
        else{
        checkPvsPc.setDisable(false);
        campo3.setDisable(false);
        campo4.setDisable(false);
        }
    }
    @FXML
    private void CheckPersonavsPc(ActionEvent event) {
        if(checkPvsPc.isSelected()){
        checkPvsP.setDisable(true);
        campo1.setDisable(true);
        campo2.setDisable(true);
        }
        else{
        checkPvsP.setDisable(false);
        campo1.setDisable(false);
        campo2.setDisable(false);
        }
    }
    @FXML
    private void Sonidobtn(MouseEvent event) {
    }
}