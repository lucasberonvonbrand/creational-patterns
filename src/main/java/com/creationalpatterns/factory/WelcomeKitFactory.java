package com.creationalpatterns.factory;

import com.creationalpatterns.model.Coupon;

// Interfaz de la Fábrica Abstracta para familias de objetos
public interface WelcomeKitFactory {

    Coupon createWelcomeCoupon();
    String createWelcomeMessage();
}
