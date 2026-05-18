package com.creationalpatterns.factory;

import com.creationalpatterns.model.Coupon;
import com.creationalpatterns.model.CouponBuilder;

// Fábrica Concreta para clientes Regulares
public class RegularKitFactory implements WelcomeKitFactory {

    @Override
    public Coupon createWelcomeCoupon() {
        CouponBuilder builder = new CouponBuilder();
        return builder.buildBasicData("REG-WELCOME", 0.15)
                .withExclusiveCategory("General Store")
                .getResult();
    }

    @Override
    public String createWelcomeMessage() {
        return "¡Bienvenido a nuestra tienda! Disfrutá de tu primer descuento en compras estándar.";
    }
}