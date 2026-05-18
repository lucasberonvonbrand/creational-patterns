package com.creationalpatterns.model;

// El "Producto"
public class Coupon {
    private String code;
    private double discountPercentage;
    private String expirationDate;
    private String exclusiveCategory;

    // Los setters o el constructor reciben los datos del Builder independiente [cite: 132]
    public Coupon() {}

    public void setCode(String code) { this.code = code; }
    public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public void setExclusiveCategory(String exclusiveCategory) { this.exclusiveCategory = exclusiveCategory; }

    @Override
    public String toString() {
        // Validamos valores por defecto en caso de que vengan nulos
        String expiration = (expirationDate != null) ? expirationDate : "Sin límite";
        String category = (exclusiveCategory != null) ? exclusiveCategory : "General";

        return String.format("🎟️ [CUPÓN: %s] | 💰 Descuento: %.0f%% | 📅 Vence: %s | 🏷️ Cat: %s",
                code, (discountPercentage * 100), expiration, category);
    }
}