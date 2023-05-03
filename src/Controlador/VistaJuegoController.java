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
public class VistaJuegoController implements Initializable {/*José Manuel Valverde Valverde*/
    int contador=0;
    long tiempoMaximoEntreClics = 1000;
    ModosdeJuego modoJuego;
    
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
    private TextField campo1;   
    @FXML
    private TextField campo2; 
    @FXML
    private TextField campo3; 
    @FXML
    private TextField campo4; 
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
    private ChoiceBox<Integer> CantidadCartas = new ChoiceBox<Integer>();
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
    CantidadCartas.getItems().add(6);
    CantidadCartas.getItems().add(12);
    CantidadCartas.getItems().add(18);
    CantidadCartas.setValue(6);
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
    switch(CantidadCartas.getValue()){
        case 6:
            modoJuego = new ModoJuego1();
            AnalizarConfiguracion();            
            cargarParametros(modoJuego);
            IniciarJuego(1);
            break;
        case 12:
            modoJuego = new ModoJuego2();
            AnalizarConfiguracion();
            cargarParametros(modoJuego);
            IniciarJuego(2);
            break;
        case 18:
            modoJuego = new ModoJuego3();
            AnalizarConfiguracion();
            cargarParametros(modoJuego);
            IniciarJuego(3);
            break;
        default:
            break;
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
            case 6: modoJuego.ModoRevision(VistaJuego1);break;
            case 12: modoJuego.ModoRevision(VistaJuego2);break;
            case 18: modoJuego.ModoRevision(VistaJuego3);break;
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
            case 6: FinalizoJuego(modoJuego);break;
            case 12: FinalizoJuego(modoJuego);break;
            case 18: FinalizoJuego(modoJuego);break;
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
    
    
    /*METODOS FUERA DE FXML--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public void IniciarJuego(int dificultad) {
    ImageView[] objetosCarta = null;
    switch(dificultad) {
        case 1: // Fácil
            objetosCarta = new ImageView[] {Carta1, Carta2, Carta3, Carta4, Carta5, Carta6};
            VistaJuego1.toFront();
            break;
        case 2: // Medio
            objetosCarta = new ImageView[] {Carta1Juego2, Carta2Juego2, Carta3Juego2, Carta4Juego2, Carta5Juego2, Carta6Juego2, Carta7Juego2, Carta8Juego2, 
            Carta9Juego2, Carta10Juego2, Carta11Juego2, Carta12Juego2};
            VistaJuego1.toFront();
            VistaJuego2.toFront();
            break;
        case 3: // Difícil
            objetosCarta = new ImageView[] {Carta1Juego3, Carta2Juego3, Carta3Juego3, Carta4Juego3, Carta5Juego3, Carta6Juego3, Carta7Juego3, Carta8Juego3, 
            Carta9Juego3, Carta10Juego3, Carta11Juego3, Carta12Juego3, Carta13Juego3, Carta14Juego3, Carta15Juego3, Carta16Juego3, Carta17Juego3, Carta18Juego3};
            VistaJuego1.toFront();
            VistaJuego3.toFront();
            break;
    }
    ClaseCarta[] cartas = new ClaseCarta[CantidadCartas.getValue()];
    for (int i = 0; i < CantidadCartas.getValue(); i++) {
        modoJuego.getLista().add(new ClaseCarta(objetosCarta[i], i+1));
    }
    modoJuego.CargarNumero();
    modoJuego.CargarImagen();
    if(CartaComodin.isSelected()) {
        modoJuego.CargarComodin();
    }
    modoJuego.Iniciar(VistaFinalizar, Tabla,TiempoMaxTotal.getValue(),TiempoMaxJugador.getValue());
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
        tiempoMaximoEntreClics = TresCartas.isSelected() ? 50 : 1000;
        if (contador < NumCartas) { /*Si alguien con mala voluntad para buscar errores podria darle click a 3 cartas a la vez, sabiendo que esta programado para que compare 2 cartas*/
        contador++;     /*Esto lo que hace es que al segundo click seguido se bloquee y no permita dar mas*/
        if (contador == NumCartas) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(tiempoMaximoEntreClics), ae -> {
                contador = 0;
            }));
            timeline.play();
        }
        switch (CantidadCartas.getValue()) {
            case 6:
                 modoJuego.Juego(event, Tabla, VistaFinalizar);
                break;
            case 12:
                 modoJuego.Juego(event, Tabla, VistaFinalizar);
                break;
            case 18:
                 modoJuego.Juego(event, Tabla, VistaFinalizar);
                break;
            default:
                break;
        }
    }
    }
    
    public void AnalizarConfiguracion(){ /* Aqui lo que hace es guardar todo lo de modos de juego y dificultad */
        if(!CartaComodin.isSelected()){
        modoJuego.setPersonavscomputadora(checkPvsPc.isSelected());
        }
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
         modoJuego.setTresCartas(true); modoJuego.setNumeroParejas(CantidadCartas.getValue()/3);
         }else{
         modoJuego.setTresCartas(false); modoJuego.setNumeroParejas(CantidadCartas.getValue()/2);
         }
         modoJuego.setPuntoAdicional(PuntoAdicional.isSelected());
         modoJuego.setCastigoPunto(CastigoPunto.isSelected());
         modoJuego.setCartaComodin(CartaComodin.isSelected());
         modoJuego.setReacomodo(botonCartasAutomaticas.isSelected() && checkPvsP.isSelected());
        if(BotonDificultadFacil.isSelected()){
        modoJuego.setDificultad(50);
        }
        if(BotonDificultadMedia.isSelected()){
        modoJuego.setDificultad(150);
        }
        if(BotonDificultadDificil.isSelected()){
        modoJuego.setDificultad(250);
        }
    }
}