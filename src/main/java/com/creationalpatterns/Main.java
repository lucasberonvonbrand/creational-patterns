package com.creationalpatterns;

import com.creationalpatterns.config.ConfigurationManager;
import com.creationalpatterns.factory.*;
import com.creationalpatterns.model.Campaign;
import com.creationalpatterns.model.Coupon;
import com.creationalpatterns.model.CouponBuilder;

public class Main {
    public static void main(String[] args) {

        System.out.println(" === INICIO DE LA SIMULACIÓN DE PATRONES DE DISEÑO CREACIONALES === \n");

        // 1. SINGLETON TEST
        System.out.println("--- [PROBANDO PATRÓN SINGLETON] ---");
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("[SINGLETON] Moneda Global Configurada: " + config.getBaseCurrency());
        System.out.println("[SINGLETON] Descuento Máximo Global Permitido: " + (config.getMaxDiscountLimit() * 100) + "% \n");

        // 2. BUILDER TEST
        System.out.println("--- [PROBANDO PATRÓN BUILDER] ---");
        System.out.println("[BUILDER] Construyendo cupones personalizados paso a paso...");
        CouponBuilder couponBuilder = new CouponBuilder();

        // Ejemplo 1: Cupón para productos electrónicos
        Coupon flashCoupon = couponBuilder.buildBasicData("FLASH20", 0.20)
                .withExpirationDate("2026-06-01")
                .withExclusiveCategory("Electronica")
                .getResult();
        System.out.println("Cupón 1 Creado: " + flashCoupon);

        // Ejemplo 2: Cupón para tienda de mascotas
        Coupon petCoupon = couponBuilder.buildBasicData("LULU10", 0.10)
                .withExpirationDate("2026-07-15")
                .withExclusiveCategory("Mascotas")
                .getResult();
        System.out.println("Cupón 2 Creado: " + petCoupon + "\n");

        // 3. PROTOTYPE TEST
        System.out.println("--- [PROBANDO PATRÓN PROTOTYPE] ---");
        System.out.println("[PROTOTYPE] Diseñando una campaña básica inicial...");
        Campaign hotSaleCampaign = new Campaign("Hot Sale 2026");
        hotSaleCampaign.addCoupon(flashCoupon);
        hotSaleCampaign.addCoupon(petCoupon);
        System.out.println("Campaña Básica Inicial:\n" + hotSaleCampaign);

        // Clonación 1: Cyber Monday
        System.out.println("[PROTOTYPE] Clonando para crear la campaña Cyber Monday...");
        Campaign cyberMondayCampaign = hotSaleCampaign.clone();
        cyberMondayCampaign.setName("Cyber Monday 2026");
        System.out.println("Campaña Clonada 1 (Cyber Monday):\n" + cyberMondayCampaign);

        // Clonación 2: Cyber Week - Modificando también sus componentes
        System.out.println("[PROTOTYPE] Clonando de nuevo para crear la campaña Cyber Week con nuevos beneficios...");
        Campaign cyberWeekCampaign = hotSaleCampaign.clone();
        cyberWeekCampaign.setName("Cyber Week Extendido 2026");
        Coupon extraCoupon = couponBuilder.buildBasicData("EXTRA5", 0.05).getResult();
        cyberWeekCampaign.addCoupon(extraCoupon);
        System.out.println("Campaña Clonada 2 (Cyber Week con cupón extra):\n" + cyberWeekCampaign);

        // 4. FACTORY METHOD TEST
        System.out.println("--- [PROBANDO PATRÓN FACTORY METHOD] ---");
        System.out.println("[FACTORY METHOD] Instanciando canales de notificación desacoplados...");
        Notifier emailChannel = NotifierFactory.createNotifier("EMAIL");
        Notifier smsChannel = NotifierFactory.createNotifier("SMS");

        emailChannel.sendNotification("¡La campaña Cyber Monday ya se encuentra activa!");
        smsChannel.sendNotification("Tu cupón LULU10 vence pronto. ¡Aprovéchalo!");
        System.out.println(); // Salto de línea al finalizar las notificaciones

        // 5. ABSTRACT FACTORY TEST
        System.out.println("--- [PROBANDO PATRÓN ABSTRACT FACTORY] ---");
        System.out.println("[ABSTRACT FACTORY] Generando paquetes de bienvenida por categorías de usuario...\n");

        // Familia VIP
        WelcomeKitFactory vipFactory = new VipKitFactory();
        Coupon vipCoupon = vipFactory.createWelcomeCoupon();
        String vipMsg = vipFactory.createWelcomeMessage();
        System.out.println("-> CATEGORÍA VIP");
        System.out.println("   Mensaje recibido: '" + vipMsg + "'");
        System.out.println("   Beneficio asignado: " + vipCoupon + "\n");

        // Familia Regular
        WelcomeKitFactory regularFactory = new RegularKitFactory();
        Coupon regCoupon = regularFactory.createWelcomeCoupon();
        String regMsg = regularFactory.createWelcomeMessage();
        System.out.println("-> CATEGORÍA REGULAR");
        System.out.println("   Mensaje recibido: '" + regMsg + "'");
        System.out.println("   Beneficio asignado: " + regCoupon + "\n");

        System.out.println(" === FIN DE LA SIMULACIÓN DE PATRONES DE DISEÑO CREACIONALES ===");
    }
}