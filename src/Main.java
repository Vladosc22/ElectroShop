import modules.Magazin;
import modules.Menu;
import modules.Produs;

public class Main {
    public static void main(String[] args) {

        // Creăm magazinul
        Magazin magazin = new Magazin();

        // Definim categoriile ca String
        String electronice = "Electronice";
        String imbracaminte = "Îmbrăcăminte";

        // Creăm produsele
        Produs p1 = new Produs("Laptop", electronice, 20000, 5);
        Produs p2 = new Produs("Mouse", electronice, 350, 20);
        Produs p3 = new Produs("Tricou", imbracaminte, 500, 50);

        // Adăugăm produsele în magazin
        magazin.adaugaProdus(p1);
        magazin.adaugaProdus(p2);
        magazin.adaugaProdus(p3);

        // Adăugăm produsele direct în promoții
        magazin.getPromotiiManager().adaugaProdusLaPromotii(p1);
        magazin.getPromotiiManager().adaugaProdusLaPromotii(p2);
        magazin.getPromotiiManager().adaugaProdusLaPromotii(p3);

        // Setăm promoții fixe
        magazin.getPromotiiManager().setPromotieFixa(0, "Black Friday - 50% reducere");
        magazin.getPromotiiManager().setPromotieFixa(1, "Crăciun - Cadou la fiecare achiziție");
        magazin.getPromotiiManager().setPromotieFixa(2, "Aniversare magazin - Transport gratuit");

        // Adăugăm promoții dinamice
        magazin.getPromotiiManager().adaugaPromotie("Discount 10% pentru studenți");
        magazin.getPromotiiManager().adaugaPromotie("Campanie Social Media - Cadou surpriză");

        // Pornim meniul interactiv
        Menu menu = new Menu(magazin);
        menu.start();
    }
}
