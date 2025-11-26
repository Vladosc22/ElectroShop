package modules;

import promotii.PromotiiManager;
import java.util.Scanner;

public class Menu {
    private Magazin magazin;
    private Scanner scanner = new Scanner(System.in);

    public Menu(Magazin magazin) {
        this.magazin = magazin;
    }

    public void start() {
        int alegere;
        do {
            afiseazaMenuOp();
            alegere = citesteInt("Alege o optiune: ");
            switch (alegere) {
                case 1: adaugaProdus(); break;
                case 2: afiseazaProduse(); break;
                case 3: adaugaClient(); break;
                case 4: creeazaComanda(); break;
                case 5: meniuPromotii(); break;  // <<< NOU
                case 0: System.out.println("Iesire..."); break;
                default: System.out.println("Optiune invalida!");
            }
        } while (alegere != 0);
    }

    private void afiseazaMenuOp() {
        System.out.println("\n-------Meniu-------");
        System.out.println("1. Adauga produs");
        System.out.println("2. Afiseaza produse");
        System.out.println("3. Adauga client");
        System.out.println("4. Creeaza comanda");
        System.out.println("5. Produse promotionale");   // <<< NOU
        System.out.println("0. Iesire");
    }

    // ==============================
    //      PRODUSE PROMOTIONALE
    // ==============================
    private void meniuPromotii() {
        PromotiiManager pm = magazin.getPromotiiManager();

        System.out.println("\n=== MENIU PROMOTII ===");
        System.out.println("1. Adauga produs in promotie");
        System.out.println("2. Afiseaza produse promotionale");
        System.out.println("0. Inapoi");

        int opt = citesteInt("Alege optiunea:");

        switch (opt) {
            case 1: adaugaProdusInPromotie(); break;
            case 2: pm.afiseazaProdusePromotii(); break;
            case 0: return;
            default: System.out.println("Optiune invalida!");
        }
    }

    private void adaugaProdusInPromotie() {
        magazin.afiseazaToateProdusele();
        int index = citesteInt("Alege indexul produsului: ");

        if (index < 1 || index > magazin.getProduse().size()) {
            System.out.println("Index invalid!");
            return;
        }

        Produs p = magazin.getProduse().get(index - 1);

        double reducere = citesteDouble("Introdu reducerea (%): ");
        double pretFinal = p.getPret() - (p.getPret() * reducere / 100);

        System.out.println("\nProdus adaugat la promotii:");
        System.out.println("Denumire: " + p.getDenumire());
        System.out.println("Categorie: " + p.getCategorie());
        System.out.println("Pret original: " + p.getPret());
        System.out.println("Reducere: " + reducere + "%");
        System.out.println("Pret final: " + pretFinal);
        System.out.println("Stoc: " + p.getStoc());

        magazin.getPromotiiManager().adaugaProdusLaPromotii(p);
    }

    // ==============================
    //     METODE EXISTENTE
    // ==============================
    private void adaugaProdus() {
        System.out.print("Numele produsului: ");
        String nume = scanner.nextLine();
        System.out.print("Categoria: ");
        String categorie = scanner.nextLine();
        double pret = citesteDouble("Pretul: ");
        int stoc = citesteInt("Stocul: ");

        magazin.adaugaProdus(new Produs(nume, categorie, pret, stoc));
        System.out.println("Produs adaugat cu succes!");
    }

    private void afiseazaProduse() {
        magazin.afiseazaToateProdusele();
    }

    private void adaugaClient() {
        System.out.print("Nume client: ");
        String nume = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Adresa: ");
        String adresa = scanner.nextLine();

        magazin.getClienti().add(new Client(nume, email, adresa));
        System.out.println("Client adaugat cu succes!");
    }

    private void creeazaComanda() {
        if (magazin.getClienti().isEmpty()) {
            System.out.println("Nu exista clienti. Adauga clienti mai intai!");
            return;
        }
        afiseazaClienti();
        int clientIndex = citesteInt("Alege clientul (index): ");
        if (clientIndex < 0 || clientIndex >= magazin.getClienti().size()) {
            System.out.println("Clientul nu exista!");
            return;
        }

        Client client = magazin.getClienti().get(clientIndex);
        Comanda comanda = new Comanda(client);

        while (true) {
            afiseazaProduse();
            int prodIndex = citesteInt("Alege produsul (index) sau -1 pentru a termina: ");
            if (prodIndex == -1) break;
            if (prodIndex < 0 || prodIndex >= magazin.getProduse().size()) {
                System.out.println("Produsul nu exista!");
                continue;
            }

            Produs produs = magazin.getProduse().get(prodIndex);
            int cantitate = citesteInt("Cantitate: ");
            if (cantitate > produs.getStoc()) {
                System.out.println("Stoc insuficient!");
                continue;
            }

            produs.setStoc(produs.getStoc() - cantitate);
            comanda.adaugaProdus(produs, cantitate);
            System.out.println("Produs adaugat in comanda.");
        }

        System.out.println("\nComanda finala:");
        System.out.println(comanda);
    }

    private void afiseazaClienti() {
        System.out.println("===== Clienti =====");
        for (int i = 0; i < magazin.getClienti().size(); i++) {
            System.out.println(i + ": " + magazin.getClienti().get(i).getNume());
        }
    }

    private int citesteInt(String mesaj) {
        while (true) {
            System.out.print(mesaj + " ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduceti un numar valid!");
            }
        }
    }

    private double citesteDouble(String mesaj) {
        while (true) {
            System.out.print(mesaj + " ");
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduceti un numar real valid!");
            }
        }
    }
}
