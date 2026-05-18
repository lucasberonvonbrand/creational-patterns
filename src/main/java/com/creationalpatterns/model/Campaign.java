package com.creationalpatterns.model;

import java.util.ArrayList;
import java.util.List;

// Prototipo Concreto
public class Campaign implements ClonableCampaign {

    private String name;
    private List<Coupon> coupons;

    public Campaign(String name) {
        this.name = name;
        this.coupons = new ArrayList<>();
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public Campaign clone() {
        Campaign cloned = new Campaign(this.name);
        cloned.coupons = new ArrayList<>(this.coupons);
        return cloned;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 CAMPAÑA: ").append(name).append("\n");
        sb.append("   📌 Cantidad de Cupones: ").append(coupons.size()).append("\n");

        if (coupons.isEmpty()) {
            sb.append("   ⚠️ No hay cupones asignados en esta campaña.");
        } else {
            sb.append("   👇 Detalle de Cupones:\n");
            for (Coupon coupon : coupons) {
                sb.append("      ▪️ ").append(coupon).append("\n");
            }
        }
        return sb.toString();
    }
}