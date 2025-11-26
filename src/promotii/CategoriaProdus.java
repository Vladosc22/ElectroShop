package promotii; // sau package modules; dacă vrei să fie în modules

public class CategoriaProdus {
    private String nume;
    private String descriere;

    // Constructor
    public CategoriaProdus(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
    }

    // Getteri și setteri
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    // Suprascriere toString pentru afișare ușoară
    @Override
    public String toString() {
        return nume + " — " + descriere;
    }
}