package service;

import modules.Produs;
import promotii.PromotiiManager;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    private ArrayList<Produs> products = new ArrayList<>();
    private PromotiiManager promotiiManager = new PromotiiManager();

    public ProductService() {
        // exemplu de produse
        products.add(new Produs("Laptop", "Electronice", 20000.0, 5));
        products.add(new Produs("Mouse", "Electronice", 350.0, 20));
        products.add(new Produs("Tricou", "Îmbrăcăminte", 500.0, 50));
        products.add(new Produs("Lapte", "Lactate", 25.0, 3));
    }

    public void listProducts() {
        for (Produs p : products) {
            p.afiseazaDetaliiProdus();
        }
    }

    public void addPromotionalProduct() {
        Scanner sc = new Scanner(System.in);

        listProducts();
        System.out.println("\nAlege codul produsului pentru promoție:");
        int id = sc.nextInt();

        Produs selected = null;

        for (Produs p : products) {
            if (p.getCod() == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("❌ Produs inexistent!");
            return;
        }

        promotiiManager.adaugaProdusLaPromotii(selected);
    }

    public void listPromotionalProducts() {
        promotiiManager.afiseazaProdusePromotii();
    }

    public PromotiiManager getPromotiiManager() {
        return promotiiManager;
    }
}
