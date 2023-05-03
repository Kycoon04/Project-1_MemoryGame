package ClasesCerebro;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ClaseCarta {
    private Image CartaAdelante;
    private int Valor;
    private ImageView CartaAtras;
    private int NumCarta;
    private boolean cartaComodin;

    public ClaseCarta(ImageView CartaAtras, int NumCarta) {/*José Manuel Valverde Valverde*/
        this.CartaAtras = CartaAtras;
        this.NumCarta = NumCarta;
        cartaComodin=false;
    }
    public int getNumCarta() {
        return NumCarta;
    }

    public boolean isCartaComodin() {
        return cartaComodin;
    }

    public void setCartaComodin(boolean cartaComodin) {
        this.cartaComodin = cartaComodin;
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

