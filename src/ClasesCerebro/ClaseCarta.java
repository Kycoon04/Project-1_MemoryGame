package ClasesCerebro;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ClaseCarta { /*hola mundo*/
    private Image CartaAdelante;
    private int Valor;
    private ImageView CartaAtras;
    private int NumCarta;

    public ClaseCarta(ImageView CartaAtras, int NumCarta) {
        this.CartaAtras = CartaAtras;
        this.NumCarta = NumCarta;
    }
    public int getNumCarta() {
        return NumCarta;
    }

    public void setNumCarta(int NumCarta) {
        this.NumCarta = NumCarta;
    }
    
    public Image getCartaAdelante() {
        return CartaAdelante;
    }
    public ImageView getCartaAtras() {
        return CartaAtras;
    }
    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    public int getValor() {
        return Valor;
    }
    public void setCartaAdelante(Image CartaAdelante) {
        this.CartaAdelante = CartaAdelante;
    }
    
}

