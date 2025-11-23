package modules;

public class Produs {
    String denumire;
    String categorie;
    double pret;
    int stoc;

    public Produs() {
    }

    public Produs(String denumire, String categorie, double pret, int stoc) {
        this.denumire = denumire;
        this.categorie = categorie;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public void afiseazaDetaliiProdus() {
        System.out.println("Denumirea produsului este: " + denumire + " care face parte din categoria " + categorie + " la un pret de " + pret + " si are un stoc de " + stoc + " produse");
    }
}