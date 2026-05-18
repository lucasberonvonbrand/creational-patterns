package com.creationalpatterns.factory;

import com.creationalpatterns.model.Coupon;
import com.creationalpatterns.model.CouponBuilder;

// Fábrica Concreta para VIPs usando el CouponBuilder
public class VipKitFactory implements WelcomeKitFactory {

    @Override
    public Coupon createWelcomeCoupon() {
        CouponBuilder builder = new CouponBuilder();
        return builder.buildBasicData("VIP-WELCOME", 0.35)
                .withExclusiveCategory("Premium Lounges")
                .withExpirationDate("2026-08-30")
                .getResult();
    }

    @Override
    public String createWelcomeMessage() {
        return "¡Bienvenido al nivel elite! Disfrutá de beneficios exclusivos con prioridad 24/7.";
    }
}