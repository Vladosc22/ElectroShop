package model;

public class PromotionalProduct extends Product {

    private double discountPercent;
    private double finalPrice;

    public PromotionalProduct(int id, String name, String category, double price, int stock, double discountPercent) {
        super(id, name, category, price, stock);
        this.discountPercent = discountPercent;
        this.finalPrice = price - (price * discountPercent / 100);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Produs Promotional | Cod: " + getId() +
                " | Denumire: " + getName() +
                " | Categorie: " + getCategory() +
                " | Pret original: " + getPrice() +
                " | Reducere: " + discountPercent + "%" +
                " | Pret final: " + finalPrice +
                " | Stoc: " + getStock();
    }
}
