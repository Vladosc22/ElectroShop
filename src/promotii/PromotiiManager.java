package promotii;

import modules.Produs;
import java.util.ArrayList;

public class PromotiiManager {

    private String[] promotiiFixe = new String[3];
    private ArrayList<String> promotiiDinamice = new ArrayList<>();
    private ArrayList<Produs> produsePromotii = new ArrayList<>(); // lista de produse aflate în promoții

    // ============================
    //      PROMOȚII FIXE
    // ============================
    public void setPromotieFixa(int index, String promotie) {
        if (index >= 0 && index < promotiiFixe.length) {
            promotiiFixe[index] = promotie;
        }
    }

    public void afiseazaPromotiiFixe() {
        System.out.println("=== Promoții fixe ===");
        for (int i = 0; i < promotiiFixe.length; i++) {
            System.out.println("[" + i + "] " + promotiiFixe[i]);
        }
    }

    // ============================
    //      PROMOȚII DINAMICE
    // ============================
    public void adaugaPromotie(String promotie) {
        promotiiDinamice.add(promotie);
    }

    public void afiseazaPromotiiDinamice() {
        System.out.println("=== Promoții dinamice ===");
        for (String p : promotiiDinamice) {
            System.out.println("- " + p);
        }
    }

    // ============================
    //      PRODUSE ÎN PROMOȚII
    // ============================
    public void adaugaProdusLaPromotii(Produs produs) {
        produsePromotii.add(produs);
        System.out.println("Produsul " + produs.getDenumire() + " a fost adăugat la promoții.");
    }

    public void stergeProdusDinPromotii(Produs produs) {
        if (produsePromotii.remove(produs)) {
            System.out.println("Produsul " + produs.getDenumire() + " a fost scos din promoții.");
        } else {
            System.out.println("Produsul nu se află în lista promoțiilor.");
        }
    }

    public boolean esteProdusInPromotii(Produs produs) {
        return produsePromotii.contains(produs);
    }

    public void afiseazaProdusePromotii() {
        System.out.println("=== Produse aflate în promoții ===");
        if (produsePromotii.isEmpty()) {
            System.out.println("Nu există produse în promoții.");
            return;
        }
        for (Produs p : produsePromotii) {
            System.out.println("- " + p.getDenumire() + " | Pret: " + p.getPret());
        }
    }

    public ArrayList<Produs> getListaProdusePromotii() {
        return produsePromotii;
    }

    public void stergeToatePromotiile() {
        promotiiDinamice.clear();
        produsePromotii.clear();
        for (int i = 0; i < promotiiFixe.length; i++) promotiiFixe[i] = null;

        System.out.println("Toate promoțiile au fost șterse.");
    }
}
