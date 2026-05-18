# 🎟️ Campaign & Coupon Management System - Backend

Este proyecto es un simulador backend puro en Java nativo diseñado para demostrar la aplicación práctica y desacoplada de los **5 patrones de diseño creacionales** de la Gang of Four (GoF). El sistema orquesta la creación y gestión dinámica de campañas publicitarias y cupones de beneficios sin dependencias externas.

## 💡 Patrones Aplicados

* **Singleton (`config`)**: Centraliza un `ConfigurationManager` único para resguardar las reglas de negocio globales en memoria.
* **Builder (`model`)**: Separa la construcción compleja de los cupones (`CouponBuilder`) en una clase independiente para lograr interfaces fluidas paso a paso.
* **Prototype (`model`)**: Implementa clonación profunda (`Campaign`) para duplicar campañas base estacionales de forma ágil e inmutable en memoria.
* **Factory Method (`factory`)**: Abstrae la instanciación de los canales de alerta (`NotifierFactory`), aislando el core del negocio del medio final de envío (Email/SMS).
* **Abstract Factory (`factory`)**: Genera familias de objetos compatibles (mensajes de bienvenida + cupones) según el perfil de suscripción del usuario (VIP/Regular).

---

## 🏛️ Diagrama de Clases (UML)

```mermaid
%%{init: { 'flowchart': { 'curve': 'linear' } } }%%
classDiagram
    %% --- PATRÓN SINGLETON ---
    class ConfigurationManager {
        -static ConfigurationManager instance
        -double maxDiscountLimit
        -String baseCurrency
        -ConfigurationManager()
        +static ConfigurationManager getInstance()
        +getMaxDiscountLimit() double
        +getBaseCurrency() String
    }

    %% --- PATRÓN BUILDER (CLASES INDEPENDIENTES) ---
    class Coupon {
        -String code
        -double discountPercentage
        -String expirationDate
        -String exclusiveCategory
        +Coupon()
        +setCode(String code) void
        +setDiscountPercentage(double pct) void
        +setExpirationDate(String date) void
        +setExclusiveCategory(String cat) void
        +toString() String
    }

    class CouponBuilder {
        -Coupon coupon
        +CouponBuilder()
        +reset() void
        +buildBasicData(String code, double pct) CouponBuilder
        +withExpirationDate(String date) CouponBuilder
        +withExclusiveCategory(String cat) CouponBuilder
        +getResult() Coupon
    }
    CouponBuilder --> Coupon : "Asocia / Construye"

    %% --- PATRÓN PROTOTYPE ---
    class ClonableCampaign {
        <<interface>>
        +clone() ClonableCampaign
    }

    class Campaign {
        -String name
        -List~Coupon~ coupons
        +Campaign(String name)
        +addCoupon(Coupon coupon) void
        +setName(String name) void
        +getName() String
        +clone() Campaign
        +toString() String
    }
    ClonableCampaign <|.. Campaign
    Campaign --> "*" Coupon : "Contiene"

    %% --- PATRÓN FACTORY METHOD ---
    class Notifier {
        <<interface>>
        +sendNotification(String message) void
    }
    class EmailNotifier { +sendNotification(String m) void }
    class SmsNotifier { +sendNotification(String m) void }
    Notifier <|.. EmailNotifier
    Notifier <|.. SmsNotifier

    class NotifierFactory {
        +static createNotifier(String type) Notifier
    }
    NotifierFactory ..> Notifier : "Crea"

    %% --- PATRÓN ABSTRACT FACTORY ---
    class WelcomeKitFactory {
        <<interface>>
        +createWelcomeCoupon() Coupon
        +createWelcomeMessage() String
    }

    class VipKitFactory {
        +createWelcomeCoupon() Coupon
        +createWelcomeMessage() String
    }

    class RegularKitFactory {
        +createWelcomeCoupon() Coupon
        +createWelcomeMessage() String
    }
    WelcomeKitFactory <|.. VipKitFactory
    WelcomeKitFactory <|.. RegularKitFactory
    VipKitFactory ..> CouponBuilder : "Instancia y usa"
    RegularKitFactory ..> CouponBuilder : "Instancia y usa"

    %% --- CLIENTE / SIMULADOR ---
    class Main {
        +main(String[] args) static
    }
    Main ..> ConfigurationManager : "Consulta"
    Main ..> CouponBuilder : "Usa"
    Main ..> Campaign : "Clona"
    Main ..> NotifierFactory : "Usa"
    Main ..> WelcomeKitFactory : "Usa"

```

## 🛠️ Tecnologías y Ejecución

* **Stack**: Java 17+ (POO pura sin frameworks externos).
* **Clonación**: `git clone https://github.com/lucasberonvonbrand/creational-patterns.git`
* **Ejecución**: Abrir en tu IDE y correr el método `main` en `src/main/java/com/creationalpatterns/Main.java`.

## 👨‍💻 Autor

- **Lucas Ruben Beron Von Brand**
