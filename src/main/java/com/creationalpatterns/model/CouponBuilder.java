package com.creationalpatterns.model;

// El "Constructor Concreto" separado
public class CouponBuilder {
    private Coupon coupon;

    public CouponBuilder() {
        this.reset();
    }

    public void reset() {
        this.coupon = new Coupon();
    }

    // Pasos de construcción del producto
    public CouponBuilder buildBasicData(String code, double discountPercentage) {
        this.coupon.setCode(code);
        this.coupon.setDiscountPercentage(discountPercentage);
        return this;
    }

    public CouponBuilder withExpirationDate(String date) {
        this.coupon.setExpirationDate(date);
        return this;
    }

    public CouponBuilder withExclusiveCategory(String category) {
        this.coupon.setExclusiveCategory(category);
        return this;
    }

    // Retorna el producto final listo
    public Coupon getResult() {
        Coupon result = this.coupon;
        this.reset();
        return result;
    }
}