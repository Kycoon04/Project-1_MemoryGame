package ClasesCerebro;

import javafx.scene.image.ImageView;

public class NumeroYPosicion {
    int Valor;
    ImageView Posicion;

    public NumeroYPosicion(int Valor, ImageView Posicion) {
        this.Valor = Valor;
        this.Posicion = Posicion;
    }

    public int getValor() {
        return Valor;
    }

    public ImageView getPosicion() {
        return Posicion;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public void setPosicion(ImageView Posicion) {
        this.Posicion = Posicion;
    }

  
}
