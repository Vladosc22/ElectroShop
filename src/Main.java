import modules.Magazin;
import modules.Menu;

public class Main {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        Menu menu = new Menu(magazin);
        menu.start();

    }
}