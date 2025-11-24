package modules;

public class Produs {

    private static int generatorCod = 1000; // cod unic auto-increment
    private int cod;                        // ID produs
    private String denumire;
    private String categorie;
    private double pret;
    private int stoc;

    // Constructor gol
    public Produs() {
        this.cod = generatorCod++;
    }

    // Constructor complet
    public Produs(String denumire, String categorie, double pret, int stoc) {
        this.cod = generatorCod++;
        this.denumire = denumire;
        this.categorie = categorie;
        this.pret = pret;
        this.stoc = stoc;
    }

    // Getteri & Setteri
    public int getCod() {
        return cod;
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

    // Metodă pentru afișare
    public void afiseazaDetaliiProdus() {
        System.out.println("Cod: " + cod +
                " | Denumire: " + denumire +
                " | Categorie: " + categorie +
                " | Pret: " + pret +
                " | Stoc: " + stoc);
    }

    // Pentru salvare în fișier
    public String toFileString() {
        return cod + ";" + denumire + ";" + categorie + ";" + pret + ";" + stoc;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                ", categorie='" + categorie + '\'' +
                ", pret=" + pret +
                ", stoc=" + stoc +
                '}';
    }
}
