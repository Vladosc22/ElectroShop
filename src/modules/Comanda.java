package modules;

import java.util.ArrayList;

public class Comanda {
    private ClientLocal client;
    private ArrayList<ProdusLocal> produse = new ArrayList<>();
    private double total;

    public Comanda(Client client) {
        this.client = new ClientLocal(client);
    }

    public void adaugaProdus(Produs produs, int cantitate) {
        produse.add(new ProdusLocal(produs, cantitate));
        recalculeazaTotal();
    }

    private void recalculeazaTotal() {
        total = 0;
        for (ProdusLocal p : produse) {
            total += p.getSubTotal();
        }
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda pentru clientul: ")
                .append(client.getNume())
                .append(" (").append(client.getEmail()).append(")\n");
        sb.append("Produse comandate:\n");
        for (ProdusLocal p : produse) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\nTotal: ").append(total).append(" MDL\n");
        sb.append("---------------------------");
        return sb.toString();
    }

    // === INNER CLASS CLIENT ===
    public class ClientLocal {
        private String nume;
        private String email;

        public ClientLocal(Client client) {
            this.nume = client.getNume();
            this.email = client.getEmail();
        }

        public String getNume() {
            return nume;
        }

        public String getEmail() {
            return email;
        }
    }

    // === INNER CLASS PRODUS ===
    public class ProdusLocal {
        private String denumire;
        private double pret;
        private int cantitate;

        public ProdusLocal(Produs produs, int cantitate) {
            this.denumire = produs.getDenumire();
            this.pret = produs.getPret();
            this.cantitate = cantitate;
        }

        public double getSubTotal() {
            return pret * cantitate;
        }

        @Override
        public String toString() {
            return denumire + " | Pret: " + pret + " | Cantitate: " + cantitate + " | Subtotal: " + getSubTotal() + " MDL";
        }
    }
}