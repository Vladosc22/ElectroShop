package modules;

import java.util.ArrayList;
import promotii.PromotiiManager;

public class Magazin {

    private ArrayList<Produs> produse = new ArrayList<>();
    private ArrayList<Client> clienti = new ArrayList<>();
    private PromotiiManager promotiiManager; // Adăugat

    // Constructor
    public Magazin() {
        this.produse = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.promotiiManager = new PromotiiManager(); // inițializare
    }

    // Getter pentru PromotiiManager
    public PromotiiManager getPromotiiManager() {
        return promotiiManager;
    }

    // Adaugă produs
    public void adaugaProdus(Produs produs) {
        produse.add(produs);
        System.out.println("Produsul " + produs.getDenumire() + " a fost adaugat la magazin");
    }

    // Adaugă client
    public void adaugaClient(Client client) {
        clienti.add(client);
        System.out.println("Clientul " + client.getNume() + " a fost adaugat!");
    }

    // Getter produse
    public ArrayList<Produs> getProduse() {
        return produse;
    }

    // Getter clienti
    public ArrayList<Client> getClienti() {
        return clienti;
    }

    // Afișează toate produsele
    public void afiseazaToateProdusele() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse in magazin.");
            return;
        }
        System.out.println("=== Lista produse ===");
        for (int i = 0; i < produse.size(); i++) {
            System.out.print((i + 1) + ". ");
            produse.get(i).afiseazaDetaliiProdus();
        }
    }

    // Afișează stocul unui produs
    public void afiseazaProdus(Produs produs) {
        if (produs.getStoc() >= 10) {
            System.out.println("Produsul este bine aprovizionat (10+ bucati)");
        } else if (produs.getStoc() >= 6) {
            System.out.println("Produsul are stoc mediu (6–9 bucati)");
        } else if (produs.getStoc() >= 1) {
            System.out.println("Produsul are stoc redus (1–5 bucati)");
        } else if (produs.getStoc() == 0) {
            System.out.println("Produsul nu este disponibil");
        } else {
            System.out.println("Stoc invalid!");
        }
    }
}