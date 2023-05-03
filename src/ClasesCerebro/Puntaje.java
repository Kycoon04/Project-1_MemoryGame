
package ClasesCerebro;

public class Puntaje {
    private float puntaje1;
    private String Jugador1;

    public Puntaje(float puntaje1,String Jugador1) {/*José Manuel Valverde Valverde*/
        this.puntaje1 = puntaje1;
         this.Jugador1 = Jugador1;
    }

    public Puntaje() {
    }

    public float getPuntaje1() {
        return puntaje1;
    }

    public void setPuntaje1(float puntaje1) {
        this.puntaje1 = puntaje1;
    }

    public String getJugador1() {
        return Jugador1;
    }

    public void setJugador1(String Jugador1) {
        this.Jugador1 = Jugador1;
    }
    
}
