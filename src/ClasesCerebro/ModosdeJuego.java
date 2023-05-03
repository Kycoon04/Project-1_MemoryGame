package ClasesCerebro;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public abstract class ModosdeJuego {
    
    protected NumeroYPosicion a,b,c,aux;
    protected ArrayList<ClaseCarta> Lista = new ArrayList<>();
    protected ArrayList<ClaseCarta> ListaReacomodo = new ArrayList<>();
    protected ArrayList<Integer> NumerosEncontrados = new ArrayList<>();
    protected ArrayList<Text> ParametrosText = new ArrayList<>();
    protected ObservableList<Puntaje> puntajes = FXCollections.observableArrayList();
    protected Puntaje puntaje = new Puntaje();
    protected final Image Respaldo;
    protected int turno,minutos,segundos;
    protected float ContJugador1,ContJugador2;
    protected Timeline timeline;
    protected boolean Personavscomputadora;
    protected boolean PuntoAdicional;
    protected boolean CastigoPunto;
    protected boolean TresCartas;
    protected boolean Reacomodo;
    protected boolean CartaComodin;
    protected int FinalizarJuego;
    protected int NumeroPartidas;
    protected int segundosJugador=0;
    protected int PuntoAdi=0;
    protected int Dificultad=2;
    protected int NumeroCartas;
    protected int NumeroParejas;
    protected int RutaImagen;
    protected int ContCartaComodin;
    
    public ModosdeJuego() {
        Respaldo =new Image("/img/cartaAtras.png");
        turno=1;
        minutos=0;
        segundos=0;
        Personavscomputadora = false;
        FinalizarJuego=0;
        ContJugador1=0;
        ContJugador2=0;
        NumeroPartidas=0;
    }

    public abstract void CartaSelecionada(String d);
    public abstract void ModoRevision(BorderPane Juego);
    
    public void setCartaComodin(boolean CartaComodin) {
        this.CartaComodin = CartaComodin;
    }

    public void setReacomodo(boolean Reacomodo) {
        this.Reacomodo = Reacomodo;
    }

    public void setNumeroParejas(int NumeroParejas) {
        this.NumeroParejas = NumeroParejas;
    }

    public void setTresCartas(boolean TresCartas) {
        this.TresCartas = TresCartas;
    }

    public void setDificultad(int Dificultad) {
        this.Dificultad = Dificultad;
    }

    public void setPuntoAdicional(boolean PuntoAdicional) {
        this.PuntoAdicional = PuntoAdicional;
    }

    public void setCastigoPunto(boolean CastigoPunto) {
        this.CastigoPunto = CastigoPunto;
    }
    
    public ArrayList<Text> getParametrosText() {
        return ParametrosText;
    }

    public ArrayList<ClaseCarta> getLista() {
        return Lista;
    }

    public ArrayList<Integer> getNumerosEncontrados() {
        return NumerosEncontrados;
    }

    public void setNumeroPartidas(int NumeroPartidas) {
        this.NumeroPartidas = NumeroPartidas;
    }

    public void setPersonavscomputadora(boolean Personavscomputadora) {
        this.Personavscomputadora = Personavscomputadora;
    }

    public void resetB(){
    b = new NumeroYPosicion(0,null);
    }
    public void resetC(){
    c = new NumeroYPosicion(0,null);
    }
    public void NuevoA(int Valor, ImageView Posicion){
    a = new NumeroYPosicion(Valor,Posicion);
    }
    
    public void Juego(MouseEvent event,TableView<Puntaje> Tabla,Pane VistaFinalizar){
         ImageView aux;
         if(TresCartas){
         JuegoTresCartas(event,Tabla,VistaFinalizar);
         }else{
        if(Personavscomputadora){
        MarcarTurno();
        if(!(turno%2==0)){
        aux = (ImageView) event.getSource();
        CartaSelecionada(aux.getId());
        if(b.getValor()==0){
            b.setValor(a.getValor());
            b.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else{
        ParejaPvP();
        }
        }
        if(turno%2==0){
          Runnable mx = new Runnable() {
          @Override
          public void run() {
             ParejaPvPc(Tabla,VistaFinalizar);
             Platform.runLater(() -> {
                 if(FinalizarJuego==NumeroParejas){
                     VistaFinalizar.toFront();
                     new animatefx.animation.Swing(VistaFinalizar).play();
                     Finalizar(Tabla);
                 }else {
                    if (turno % 2 == 0) {
                        setTimeout(this, 1500);
                    }
                 }
             });
         }
        };
        setTimeout(mx, 1500);
        }
        MarcarTurno();
        }
        else{
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        MarcarTurno();
        aux = (ImageView) event.getSource();
        CartaSelecionada(aux.getId());
        if(b.getValor()==0){
            b.setValor(a.getValor());
            b.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else{
        ParejaPvP();
        }
        MarcarTurno();
        }
        if(FinalizarJuego==NumeroParejas){
         VistaFinalizar.toFront();
         new animatefx.animation.Swing(VistaFinalizar).play();
         Finalizar(Tabla);
        }
        }
    }
    public void ParejaPvP() {
        int j=0;
        if(TresCartas){
         ParejaPvPTresCartas();
        }else{
        segundosJugador=0;
        if(a.getValor()!=0 && b.getValor()!=0){
        if(a.getValor()>b.getValor()){
        if(a.getValor()-NumeroParejas==b.getValor()){
            new animatefx.animation.Swing(a.getPosicion()).play();
            new animatefx.animation.Swing(b.getPosicion()).play();
            PuntosGanados();
            NumerosEncontrados.add(a.getValor());
            NumerosEncontrados.add(b.getValor());
            FinalizarJuego+=1;
            turno-=1;
           if(Reacomodo){
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
                ListaReacomodo.add(Lista.get(i));
             }
           }
           desordenarLista(ListaReacomodo);
           j=0;  
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
               ClaseCarta aux = ListaReacomodo.get(j);
               Lista.set(i, aux);
               j++;
               }
            }
        }
        }
        else{
        PuntoAdi=0;
        Runnable mx=new Runnable(){
                @Override
                public void run() {
                a.getPosicion().setImage(Respaldo);
                b.getPosicion().setImage(Respaldo);
                }
            };
            setTimeout(mx,1000);
            PuntoCastigo();
        }
        }
        else{
        if(b.getValor()-NumeroParejas==a.getValor()){
            new animatefx.animation.Swing(a.getPosicion()).play();
            new animatefx.animation.Swing(b.getPosicion()).play();
            PuntosGanados();
           NumerosEncontrados.add(a.getValor());
           NumerosEncontrados.add(b.getValor());
           FinalizarJuego+=1;
           turno-=1;
           if(CartaComodin){
        if(TresCartas){
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==(1+NumeroParejas)){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==(1+2*NumeroParejas)){
        NumerosEncontrados.add(i);
        }
        }
    }else{
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==((NumeroCartas/2)+1)){
        NumerosEncontrados.add(i);
        }
        }
    }
     }
           if(Reacomodo){
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
                ListaReacomodo.add(Lista.get(i));
             }
           }
           desordenarLista(ListaReacomodo);
           j=0;  
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
               ClaseCarta aux = ListaReacomodo.get(j);
               Lista.set(i, aux);
               j++;
               }
           }
        }
        }
        else{
            PuntoAdi=0;
            Runnable mx=new Runnable(){
                @Override
                public void run() {
                a.getPosicion().setImage(Respaldo);
                b.getPosicion().setImage(Respaldo);          
                }
            };
             setTimeout(mx,1000);
            PuntoCastigo();
        }
        }
        a.setValor(0);
        b.setValor(0);
        turno+=1;
        }
        }
        ListaReacomodo.clear();
        ContCartaComodin=1;
    }
    public void ParejaPvPc(TableView<Puntaje> Tabla,Pane VistaFinalizar){
        if(TresCartas){
         ParejaPvPcTresCartas(Tabla,VistaFinalizar);
        }else{
        Random rand = new Random();
        int i=0,j=0,aux=0;
        int num1 = rand.nextInt(NumeroCartas) + 1;
        int num2 = rand.nextInt(NumeroCartas) + 1;
        
        for(int k=0;k<Dificultad;k++){
        num1 = rand.nextInt(NumeroCartas) + 1;
        num2 = rand.nextInt(NumeroCartas) + 1;
        while (num1 == num2) {
        num2 = (int) (Math.random() * NumeroCartas) + 1;
        }
        while (NumerosEncontrados.contains(num1) || NumerosEncontrados.contains(num2)){
            if(NumerosEncontrados.contains(num1)){
             num1 = (int) (Math.random() * NumeroCartas) + 1;
            }
            else{
            num2 = (int) (Math.random() * NumeroCartas) + 1;
            }
            while (num1 == num2) {
            num2 = (int) (Math.random() * NumeroCartas) + 1;
            } 
        }
        if (num1 > num2) {
        aux = num1-NumeroParejas;
        } else {
        aux = num2 - NumeroParejas;
        }
        if(aux == num2 ||aux == num1){
        k=Dificultad;
        }
        }          
        for(int k=0; k<Lista.size();k++){
            if(Lista.get(Lista.get(k).getNumCarta()-1).getValor()==num1){ 
            a.setPosicion(Lista.get(k).getCartaAtras());
            Lista.get(k).getCartaAtras().setImage(getLista().get(Lista.get(k).getNumCarta()-1).getCartaAdelante());
            new animatefx.animation.BounceIn(Lista.get(k).getCartaAtras()).play();
            }
        }
        for(int k=0; k<Lista.size();k++){
            if(Lista.get(Lista.get(k).getNumCarta()-1).getValor()==num2){  
            b.setPosicion(Lista.get(k).getCartaAtras());
            Lista.get(k).getCartaAtras().setImage(getLista().get(Lista.get(k).getNumCarta()-1).getCartaAdelante());
            new animatefx.animation.BounceIn(Lista.get(k).getCartaAtras()).play();
            }
        }
        turno+=1;
        if(aux == num2 ||aux == num1){
            turno-=1;
            new animatefx.animation.Swing(a.getPosicion()).play();
            new animatefx.animation.Swing(b.getPosicion()).play();
            ContJugador2 = (ContJugador2+2);
            getParametrosText().get(3).setText(ContJugador2+" pts");
            getNumerosEncontrados().add(num1);
            getNumerosEncontrados().add(num2);
            FinalizarJuego+=1;
        }
        else{
            MarcarTurno();
            Runnable mx=new Runnable(){
                @Override
                public void run() {
                  for (ClaseCarta carta1 : getLista()) {
                a.getPosicion().setImage(Respaldo);
                b.getPosicion().setImage(Respaldo);
                   }
                }
            };
           setTimeout(mx,1000);    
           if(CastigoPunto){
           ContJugador2 = ((float) (ContJugador2-0.5));
           }
           getParametrosText().get(3).setText(ContJugador2+" pts");
        }
        }
    }
    public void reset() {
    for(int i=0;i<NumeroCartas;i++){
    getLista().get(i).getCartaAtras().setImage(Respaldo);
    }
    }
    
    public void CargarNumero(){
        boolean bandera =false;
        Random r=new Random();
        int randomNum;
        for(int i =0; i<NumeroCartas;i++){
        randomNum = r.nextInt(NumeroCartas+1);
        for(int j =0; j<NumeroCartas;j++){
        if(randomNum==Lista.get(j).getValor()){
            j=NumeroCartas;
            bandera =false;
            i-=1;
        }
        else{
        bandera = true;
        }
        }
        if(bandera){
        Lista.get(i).setValor(randomNum);
        }
        }
    }
    public void CargarImagen(){
        if(TresCartas){
         CargarImagenTresCartas();
        }else{
        Image vector[]=new Image[NumeroCartas];
        int i,j;
        for(i=0;i<NumeroCartas;i++){
        vector[i]=new Image("/Juego"+RutaImagen+"/cartaAtras"+i+".png");
        }
        for(i=0;i<NumeroCartas;i++){
           for(j=0;j<NumeroCartas;j++){
               if((Lista.get(j).getValor())-1==i){
               Lista.get(j).setCartaAdelante(vector[i]);
               }
           }
        }   
    }
    }
    public void Iniciar(Pane VistaFinalizar,TableView<Puntaje> Tabla, int TiempoMax, int TiempoMaxJugador) {
        resetB();
        resetC();
        ContCartaComodin=1;
        getParametrosText().get(10).setText(String.valueOf("Tiempo: "+minutos+":"+segundos));
        timeline = (new Timeline(new KeyFrame(Duration.seconds(1),e ->{
            if(segundos==59){
            minutos+=1;
            segundos=0;
            }
            if(minutos==TiempoMax){
                VistaFinalizar.toFront();
                new animatefx.animation.Swing(VistaFinalizar).play();
                Finalizar(Tabla);
                timeline.stop();
            }
            if(segundosJugador==TiempoMaxJugador){
                turno+=1;
                MarcarTurno();
                segundosJugador=0;
            }
            segundosJugador+=1;
           segundos+=1;
            getParametrosText().get(10).setText("Tiempo: "+minutos+":"+segundos);
        })));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    public void JuegoTresCartas(MouseEvent event,TableView<Puntaje> Tabla,Pane VistaFinalizar){
            if(Personavscomputadora){
        MarcarTurno();
        if(!(turno%2==0)){
        ImageView d = (ImageView) event.getSource();
        CartaSelecionada(d.getId());
        if(b.getValor()==0){
            b.setValor(a.getValor());
            b.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else if(c.getValor()==0){
            c.setValor(a.getValor());
            c.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else{
        ParejaPvP();
        }
        }
        if(turno%2==0){
          Runnable mx = new Runnable() {
          @Override
          public void run() {
             ParejaPvPc(Tabla,VistaFinalizar);
             Platform.runLater(() -> {
                 if(FinalizarJuego==NumeroParejas){
                     VistaFinalizar.toFront();
                     new animatefx.animation.Swing(VistaFinalizar).play();
                     Finalizar(Tabla);
                 }else {
                    if (turno % 2 == 0) {
                        setTimeout(this, 1500);
                    }
                 }
             });
         }
        };
        setTimeout(mx, 1500);
        }
        MarcarTurno();
        }
        else{
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        MarcarTurno();
        ImageView d = (ImageView) event.getSource();
        CartaSelecionada(d.getId());
        if(b.getValor()==0){
            b.setValor(a.getValor());
            b.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else if(c.getValor()==0){
            c.setValor(a.getValor());
            c.setPosicion(a.getPosicion());
            a.setValor(0);
        }
        else{
        ParejaPvP();
        }
        MarcarTurno();
        }
        if(FinalizarJuego==NumeroParejas){
         VistaFinalizar.toFront();
         new animatefx.animation.Swing(VistaFinalizar).play();
         Finalizar(Tabla);
        }
    }
    public void ParejaPvPTresCartas(){
    int j=0;
    int mayor, segundoMayor, menor;
    segundosJugador=0;
    if(a.getValor()!=0 && b.getValor()!=0 && c.getValor()!=0){
    
    if(a.getValor() > b.getValor() && a.getValor() > c.getValor()) {
      mayor = a.getValor();
      
        if(b.getValor() > c.getValor()) {
          segundoMayor = b.getValor();
          menor = c.getValor();
        }else{
        segundoMayor = c.getValor();
        menor = b.getValor();
        }
        
    }
    
    else if(b.getValor() > a.getValor() && b.getValor() > c.getValor()) {
        
      mayor = b.getValor();
        if(a.getValor() > c.getValor()) {
          segundoMayor = a.getValor();
          menor = c.getValor();
        }else {
        segundoMayor = c.getValor();
        menor = a.getValor();
        }
    } 
    
    else {
      mayor = c.getValor();
      
      if(a.getValor() > b.getValor()) {
        segundoMayor = a.getValor();
        menor = b.getValor();
      } else {
        segundoMayor = b.getValor();
        menor = a.getValor();
      }
    }
    
    if(mayor-NumeroParejas== segundoMayor && segundoMayor-NumeroParejas == menor){
            new animatefx.animation.Swing(a.getPosicion()).play();
            new animatefx.animation.Swing(b.getPosicion()).play();
            new animatefx.animation.Swing(c.getPosicion()).play();
            PuntosGanados();
            getNumerosEncontrados().add(a.getValor());
            getNumerosEncontrados().add(b.getValor());
            getNumerosEncontrados().add(c.getValor());
            FinalizarJuego+=1;
            turno-=1;
            segundosJugador=0;
        }
        else{
        PuntoAdi=0;
        Runnable mx=new Runnable(){
                @Override
                public void run() {
                a.getPosicion().setImage(Respaldo);
                b.getPosicion().setImage(Respaldo);
                c.getPosicion().setImage(Respaldo);
                }
            };
            setTimeout(mx,1000);
            if(CastigoPunto){
            PuntoCastigo();
            }
    }
    
         
        if(TresCartas){
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==(1+NumeroParejas)){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==(1+2*NumeroParejas)){
        NumerosEncontrados.add(i);
        }
        }
    }else{
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        NumerosEncontrados.add(i);
        }
        if(Lista.get(i).getValor()==((NumeroCartas/2)+1)){
        NumerosEncontrados.add(i);
        }
        }
    }
     
    if(Reacomodo){
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
                ListaReacomodo.add(Lista.get(i));
             }
           }
           desordenarLista(ListaReacomodo);
           j=0;  
           for (int i = 0; i < Lista.size(); i++) {
               if (!NumerosEncontrados.contains(Lista.get(i).getValor())) {
               ClaseCarta aux = ListaReacomodo.get(j);
               Lista.set(i, aux);
               j++;
               }
            }
    }
    a.setValor(0);
    b.setValor(0);
    c.setValor(0);
    turno+=1;
    }
    ContCartaComodin=1;
    }
    
    public void ParejaPvPcTresCartas(TableView<Puntaje> Tabla, Pane VistaFinalizar) {
        int mayor=0, segundoMayor=0, menor=0;
        boolean Bandera=false;
        Random rand = new Random();
        int aux=0;
        int num1 = rand.nextInt(NumeroCartas) + 1;
        int num2 = rand.nextInt(NumeroCartas) + 1;
        int num3 = rand.nextInt(NumeroCartas) + 1;
        
        for(int k=0;k<Dificultad;k++){  
        num1 = rand.nextInt(NumeroCartas) + 1;
        num2 = rand.nextInt(NumeroCartas) + 1;
        num3 = rand.nextInt(NumeroCartas) + 1;
        
        while (num1 == num2 || num1 == num3 || num2 == num3) {
        num1 = rand.nextInt(NumeroCartas) + 1;
        num2 = rand.nextInt(NumeroCartas) + 1;
        num3 = rand.nextInt(NumeroCartas) + 1;
        }
        
        while (NumerosEncontrados.contains(num1) || NumerosEncontrados.contains(num2)|| NumerosEncontrados.contains(num3)){
            if (NumerosEncontrados.contains(num1)) {
              num1 = rand.nextInt(NumeroCartas) + 1;
            }
            if (NumerosEncontrados.contains(num2)) {
              num2 = rand.nextInt(NumeroCartas) + 1;
            }
            if (NumerosEncontrados.contains(num3)) {
              num3 = rand.nextInt(NumeroCartas) + 1;
            }
            while (num1 == num2 || num1 == num3 || num2 == num3) {
             num1 = rand.nextInt(NumeroCartas) + 1;
             num2 = rand.nextInt(NumeroCartas) + 1;
             num3 = rand.nextInt(NumeroCartas) + 1;
            }
        }
        
      if(num1 > num2 && num1 > num3) {
      mayor = num1;
        if(num2 > num3) {
          segundoMayor = num2;
          menor = num3;
        }else{
        segundoMayor = num3;
        menor = num2;
        }
    }
    
    else if(num2 > num1 && num2 > num3) {
        
      mayor = num2;
        if(num1 > num3) {
          segundoMayor = num1;
          menor = num3;
        }else {
        segundoMayor = num3;
        menor = num1;
        }
    } 
    
    else {
      mayor = num3;
      
      if(num1 > num2) {
        segundoMayor = num1;
        menor = num2;
      } else {
        segundoMayor = num2;
        menor = num1;
      }
    }
    if(mayor-NumeroParejas== segundoMayor && segundoMayor-NumeroParejas == menor){
    k=Dificultad;
    Bandera=true;
    }
    }
        for (ClaseCarta carta : getLista()) {
        if (carta.getValor()==num1) {
           a.setPosicion(carta.getCartaAtras());
            carta.getCartaAtras().setImage(getLista().get(carta.getNumCarta()-1).getCartaAdelante());
            new animatefx.animation.BounceIn(carta.getCartaAtras()).play();
        }
        }
        for (ClaseCarta carta1 : getLista()) {
        if (carta1.getValor()==num2) {
            b.setPosicion(carta1.getCartaAtras());
            carta1.getCartaAtras().setImage(getLista().get(carta1.getNumCarta()-1).getCartaAdelante());
            new animatefx.animation.BounceIn(carta1.getCartaAtras()).play();
        }
        }
        for (ClaseCarta carta2 : getLista()) {
        if (carta2.getValor()==num3) {
            c.setPosicion(carta2.getCartaAtras());
            carta2.getCartaAtras().setImage(getLista().get(carta2.getNumCarta()-1).getCartaAdelante());
            new animatefx.animation.BounceIn(carta2.getCartaAtras()).play();
        }
        }
        turno+=1;
        if(Bandera){
            turno-=1;
            new animatefx.animation.Swing(a.getPosicion()).play();
            new animatefx.animation.Swing(b.getPosicion()).play();
            new animatefx.animation.Swing(c.getPosicion()).play();
            ContJugador2=(ContJugador2+2);
            ParametrosText.get(3).setText(ContJugador2+" pts");
            NumerosEncontrados.add(num1);
            NumerosEncontrados.add(num2);
            NumerosEncontrados.add(num3);
            FinalizarJuego+=1;
            Runnable mx = new Runnable() {
            @Override
            public void run() {
             ParejaPvPcTresCartas(Tabla,VistaFinalizar);
             Platform.runLater(() -> {
                 if(FinalizarJuego==6){
                    VistaFinalizar.toFront();
                    new animatefx.animation.Swing(VistaFinalizar).play();
                    Finalizar(Tabla);
                 }
             });
            }
            };
        }
        else{
            MarcarTurno();
            Runnable mx=new Runnable(){
                @Override
                public void run() {
                  for (ClaseCarta carta1 : getLista()) {
                a.getPosicion().setImage(Respaldo);
                b.getPosicion().setImage(Respaldo);
                c.getPosicion().setImage(Respaldo);
                   }
                }
            };
           setTimeout(mx,1000);    
           if(CastigoPunto){
           ContJugador2 =((float) (ContJugador2-0.5));
           }
           ParametrosText.get(3).setText(ContJugador2+" pts");
        }

    }
    public void CargarImagenTresCartas(){
        Image vector[]=new Image[NumeroCartas];
        int i,j;
        for(i=0;i<NumeroCartas;i++){
        vector[i]=new Image("/Juego"+RutaImagen+"TresCartas/cartaAtras"+i+".png");
        }
        for(i=0;i<NumeroCartas;i++){
           for(j=0;j<NumeroCartas;j++){
               if((Lista.get(j).getValor())-1==i){
               Lista.get(j).setCartaAdelante(vector[i]);
               }
           }
        }
    }
    
    public void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }
    
    public void Finalizar(TableView<Puntaje> Tabla){
        int contador=0;
        setNumeroPartidas(NumeroPartidas+1);
        if(ContJugador1==ContJugador2){
        ParametrosText.get(4).setText("Empate");
        }
        else{
        if(ContJugador1>ContJugador2){
        ParametrosText.get(4).setText(getParametrosText().get(0).getText());
        }
        else{
        ParametrosText.get(4).setText(getParametrosText().get(1).getText());
        }
        }
        ParametrosText.get(5).setText(getParametrosText().get(10).getText());
        ParametrosText.get(6).setText(ContJugador1+" pts");
        ParametrosText.get(7).setText(ContJugador2+" pts");
        ParametrosText.get(8).setText(getParametrosText().get(0).getText());
        ParametrosText.get(9).setText(getParametrosText().get(1).getText());
        
        Puntaje user1 = new Puntaje(ContJugador1,getParametrosText().get(0).getText());
        Puntaje user2 = new Puntaje(ContJugador2,getParametrosText().get(1).getText());
        ActualizarTabla(user1,user2);
        Tabla.refresh();
        Tabla.setItems(puntajes);
    }
    public void Limpiar(ArrayList<ClaseCarta> Lista,ArrayList<Integer> NumerosEncontrados,Text username1,Text username2,Text pts1,Text pts2){
    pts1.setText("0 pts");pts2.setText("0 pts");
    username1.setFill(Color.RED);
    username2.setFill(Color.WHITE);
    Lista.clear();
    NumerosEncontrados.clear();
    ContJugador1=0;ContJugador2=0;
    timeline.stop();
    turno=1;
    minutos=0;
    segundos=0;
    FinalizarJuego=0;
    segundosJugador=0;
    PuntoAdi=0;
    }
public void ActualizarTabla(Puntaje user1,Puntaje user2){
        int contador=0;
        boolean bandera=false;
        if(!(Personavscomputadora)){
        for(Puntaje aux: puntajes){
            if(aux.getJugador1()==user1.getJugador1()){
                puntajes.get(contador).setPuntaje1(aux.getPuntaje1()+ContJugador1);
                bandera=true;
            }
            contador++;
        }
        if(!bandera){
         puntajes.add(user1);
        }
        contador=0;
        bandera=false;
        for(Puntaje aux: puntajes){
            if(aux.getJugador1()==user2.getJugador1()){
                puntajes.get(contador).setPuntaje1(aux.getPuntaje1()+ContJugador2);
                bandera=true;
            }
            contador++;
        }
        if(!bandera){
        puntajes.add(user2);
        }
    }else{
        for(Puntaje aux: puntajes){
            if(aux.getJugador1()==user1.getJugador1()){
                puntajes.get(contador).setPuntaje1(aux.getPuntaje1()+ContJugador1);
                bandera=true;
            }
            contador++;
        }
        if(!bandera){
         puntajes.add(user1);
        }
    }
    }
    public void PuntoCastigo(){
    if(CastigoPunto){
        if(!(turno%2==0)){
        ContJugador1=((float) (ContJugador1-0.5));
        ParametrosText.get(2).setText(ContJugador1+" pts");
        }
        else{
        ContJugador2=((float) (ContJugador2-0.5));
        ParametrosText.get(3).setText(ContJugador2+" pts");
        }
    }
    }
    public void PuntosGanados(){
    PuntoAdi+=1;
    if(PuntoAdicional){
    if(PuntoAdi>=2){
            if(!(turno%2==0)){
            ContJugador1=(ContJugador1+3);
            ParametrosText.get(2).setText(ContJugador1+" pts");
            }
            else{
            ContJugador2=(ContJugador2+3);
            ParametrosText.get(3).setText(ContJugador2+" pts");
            }
        }else{
            if(!(turno%2==0)){
            ContJugador1=(ContJugador1+2);
            ParametrosText.get(2).setText(ContJugador1+" pts");
            }
            else{
            ContJugador2=(ContJugador2+2);
            ParametrosText.get(3).setText(ContJugador2+" pts");
            }
        }
    }else{
        if(!(turno%2==0)){
            ContJugador1=(ContJugador1+2);
            ParametrosText.get(2).setText(ContJugador1+" pts");
            }
            else{
            ContJugador2=(ContJugador2+2);
            ParametrosText.get(3).setText(ContJugador2+" pts");
        }
    }  
    }
    
    public void MarcarTurno(){
        if(!(turno%2==0)){
        ParametrosText.get(0).setFill(Color.RED);
        ParametrosText.get(1).setFill(Color.WHITE);
        }
        else{
        ParametrosText.get(0).setFill(Color.WHITE);
        ParametrosText.get(1).setFill(Color.RED);
        }
    }
    public static void desordenarLista(ArrayList<ClaseCarta> Lista) {
    int tamano = Lista.size();
    int i = 0;
    ArrayList<Integer> Auxiliar = new ArrayList<>();
    ArrayList<ClaseCarta> Lista2 = Lista;
    
    while(i!=tamano/2){
        int indice1 = (int) (Math.random() * tamano);
        int indice2 = (int) (Math.random() * tamano);
        
        while(indice1 == indice2){
        indice1 = (int) (Math.random() * tamano);
        indice2 = (int) (Math.random() * tamano);
        }
        if(!(Auxiliar.contains(indice1) || Auxiliar.contains(indice2))){
        Auxiliar.add(indice1);Auxiliar.add(indice2);
        
        swap(Lista, indice1,indice2);
        
        i++;
        }
    }
    }
    public static void swap(ArrayList<ClaseCarta> Lista, int Indice1,int Indice2){
    ClaseCarta aux = Lista.get(Indice1);
    Lista.set(Indice1, Lista.get(Indice2));
    Lista.set(Indice2, aux);
    }
    public void CartaSelecion(int posicion){
    for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getNumCarta()==posicion){
              if(!(getLista().get(i).getCartaAtras().getImage()==getLista().get(posicion-1).getCartaAdelante())){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(posicion-1).getCartaAdelante());
                aux=a;
                NuevoA(getLista().get(posicion-1).getValor(),getLista().get(i).getCartaAtras());
              }
              if(Lista.get(i).isCartaComodin() && CartaComodin && ContCartaComodin==1 && !TresCartas){
              CartaComodinPrimero(i);
              } 
              else if(Lista.get(i).isCartaComodin() && CartaComodin && ContCartaComodin==2 && !TresCartas){
              CartaComodinSegundo(posicion);
              }
              
              if(Lista.get(i).isCartaComodin() && CartaComodin && ContCartaComodin==1 && TresCartas){
              CartaComodinPrimeroTresCartas(i);
              } 
              else {
              if(Lista.get(i).isCartaComodin() && CartaComodin && ContCartaComodin==2  && TresCartas){
              CartaComodinSegundoTresCartas(posicion);
              }
              else if(Lista.get(i).isCartaComodin() && CartaComodin && ContCartaComodin==3  && TresCartas){
              aux.getPosicion().setImage(Respaldo);
              CartaComodinSegundoTresCartas(posicion);
              }
            }
              ContCartaComodin++;
            }
    }
    }
    public void CargarComodin(){
    Image CartComodin = new Image("/img/CartaComodin.png");
    if(TresCartas){
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        Lista.get(i).setCartaAdelante(CartComodin);
        Lista.get(i).setCartaComodin(true);
        NumerosEncontrados.add(Lista.get(i).getValor());
        }
        if(Lista.get(i).getValor()==(1+NumeroParejas)){
        Lista.get(i).setCartaAdelante(CartComodin);
        Lista.get(i).setCartaComodin(true);
        NumerosEncontrados.add(Lista.get(i).getValor());
        }
        if(Lista.get(i).getValor()==(1+2*NumeroParejas)){
        Lista.get(i).setCartaAdelante(CartComodin);
        Lista.get(i).setCartaComodin(true);
        NumerosEncontrados.add(Lista.get(i).getValor());
        }
        }
    }else{
        for(int i=0;i<NumeroCartas;i++){
        if(Lista.get(i).getValor()==1){
        Lista.get(i).setCartaAdelante(CartComodin);
        Lista.get(i).setCartaComodin(true);
        NumerosEncontrados.add(Lista.get(i).getValor());
        }
        if(Lista.get(i).getValor()==((NumeroCartas/2)+1)){
        Lista.get(i).setCartaAdelante(CartComodin);
        Lista.get(i).setCartaComodin(true);
        NumerosEncontrados.add(Lista.get(i).getValor());
        }
        }
    }
    }
    public void CartaComodinPrimero(int i){
            if(Lista.get(i).getValor()==((NumeroCartas/2)+1)){
                for(int k=0;k<NumeroCartas;k++){  
                    if(Lista.get(k).getValor()==1){
                       new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                       getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                       b.setPosicion(Lista.get(k).getCartaAtras());
                       b.setValor(getLista().get(k).getValor());
                    }
                } 
            }
            else{
                for(int k=0;k<NumeroCartas;k++){  
                  if(Lista.get(k).getValor()==((NumeroCartas/2)+1)){
                    new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                    getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                    b.setPosicion(Lista.get(k).getCartaAtras());
                    b.setValor(getLista().get(k).getValor());
                  }
                } 
            }
    }
    public void CartaComodinSegundo(int posicion){
        if(b.getValor()>NumeroCartas/2){
          for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getValor()==(b.getValor()-NumeroParejas)){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                a.setPosicion(Lista.get(i).getCartaAtras());
                a.setValor(getLista().get(i).getValor());
            }
         }
        }else{
          for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getValor()==(b.getValor()+NumeroParejas)){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                a.setPosicion(Lista.get(i).getCartaAtras());
                a.setValor(getLista().get(i).getValor());
            }
         }
        }
        Runnable mx=new Runnable(){
            @Override
              public void run() {
               for(int i=0; i<Lista.size();i++){
                 if(Lista.get(i).getNumCarta()==posicion){
                    Lista.get(i).getCartaAtras().setImage(Respaldo);
                 }
               }
              }
            };
           setTimeout(mx,1000);   
    }
    public void CartaComodinPrimeroTresCartas(int i){
             if(Lista.get(i).getValor()==(1+NumeroParejas)){
                for(int k=0;k<NumeroCartas;k++){
                    if(Lista.get(k).getValor()==1){
                       new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                       getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                       b.setPosicion(Lista.get(k).getCartaAtras());
                       b.setValor(getLista().get(k).getValor());
                    }
                    if(Lista.get(k).getValor()==(1+2*NumeroParejas)){
                       new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                       getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                       c.setPosicion(Lista.get(k).getCartaAtras());
                       c.setValor(getLista().get(k).getValor());
                    }
                } 
            }
             else {
               if(Lista.get(i).getValor()==(1+2*NumeroParejas)){
                for(int k=0;k<NumeroCartas;k++){  
                  if(Lista.get(k).getValor()==(1+NumeroParejas)){
                    new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                    getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                    b.setPosicion(Lista.get(k).getCartaAtras());
                    b.setValor(getLista().get(k).getValor());
                  }
                  if(Lista.get(k).getValor()==1){
                    new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                    getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                    c.setPosicion(Lista.get(k).getCartaAtras());
                    c.setValor(getLista().get(k).getValor());
                  }
                }
               }else{
                for(int k=0;k<NumeroCartas;k++){  
                  if(Lista.get(k).getValor()==(1+NumeroParejas)){
                    new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                    getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                    b.setPosicion(Lista.get(k).getCartaAtras());
                    b.setValor(getLista().get(k).getValor());
                  }
                  if(Lista.get(k).getValor()==(1+2*NumeroParejas)){
                       new animatefx.animation.BounceIn(getLista().get(k).getCartaAtras()).play();
                       getLista().get(k).getCartaAtras().setImage(getLista().get(k).getCartaAdelante());
                       c.setPosicion(Lista.get(k).getCartaAtras());
                       c.setValor(getLista().get(k).getValor());
                  }
                }
               }
            }
    }
    public void CartaComodinSegundoTresCartas(int posicion){
        if(b.getValor()<=NumeroParejas){
          for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getValor()==(b.getValor()+(1+2*NumeroParejas))-1){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                a.setPosicion(Lista.get(i).getCartaAtras());
                a.setValor(getLista().get(i).getValor());
            }
            if(Lista.get(i).getValor()==(b.getValor()+(1+NumeroParejas))-1){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                c.setPosicion(Lista.get(i).getCartaAtras());
                c.setValor(getLista().get(i).getValor());
            }
           }   
        }else{
            if(b.getValor()>(2*NumeroParejas)){
            for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getValor()==(b.getValor()-(2*NumeroParejas))){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                a.setPosicion(Lista.get(i).getCartaAtras());
                a.setValor(getLista().get(i).getValor());
            }
            if(Lista.get(i).getValor()==(b.getValor()-NumeroParejas)){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                c.setPosicion(Lista.get(i).getCartaAtras());
                c.setValor(getLista().get(i).getValor());
            }
            }  
            }
            else{
            for(int i=0; i<Lista.size();i++){
            if(Lista.get(i).getValor()==(b.getValor()+NumeroParejas)){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                a.setPosicion(Lista.get(i).getCartaAtras());
                a.setValor(Lista.get(i).getValor());
            }
            if(Lista.get(i).getValor()==(b.getValor()-NumeroParejas)){
                new animatefx.animation.BounceIn(getLista().get(i).getCartaAtras()).play();
                getLista().get(i).getCartaAtras().setImage(getLista().get(i).getCartaAdelante());
                c.setPosicion(Lista.get(i).getCartaAtras());
                c.setValor(getLista().get(i).getValor());
            }
            }
            }
        }
        Runnable mx=new Runnable(){
            @Override
              public void run() {
               for(int i=0; i<Lista.size();i++){
                 if(Lista.get(i).getNumCarta()==posicion){
                    Lista.get(i).getCartaAtras().setImage(Respaldo);
                 }
               }
              }
            };
           setTimeout(mx,1000); 
    }
}