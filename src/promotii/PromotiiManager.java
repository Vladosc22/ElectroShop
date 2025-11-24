package promotii;

import modules.Produs;
import java.util.ArrayList;

public class PromotiiManager {

    private String[] promotiiFixe = new String[3];
    private ArrayList<String> promotiiDinamice = new ArrayList<>();
    private ArrayList<Produs> produsePromotii = new ArrayList<>(); // lista de produse în promoții

    public void setPromotieFixa(int index, String promotie) {
        if(index >= 0 && index < promotiiFixe.length){
            promotiiFixe[index] = promotie;
        }
    }

    public void adaugaPromotie(String promotie) {
        promotiiDinamice.add(promotie);
    }

    // Noua metodă pentru produse în promoții
    public void adaugaProdusLaPromotii(Produs produs) {
        produsePromotii.add(produs);
        System.out.println("Produsul " + produs.getDenumire() + " a fost adăugat la promoții.");
    }

    public void afiseazaProdusePromotii() {
        System.out.println("=== Produse în promoții ===");
        for(Produs p : produsePromotii) {
            System.out.println("- " + p.getDenumire());
        }
    }
}