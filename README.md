# 🎟️ Campaign & Coupon Management System - Backend

[cite_start]Este proyecto es un simulador backend puro en Java nativo diseñado para demostrar la aplicación práctica y desacoplada de los **5 patrones de diseño creacionales** de la Gang of Four (GoF)[cite: 38]. [cite_start]El sistema orquesta la creación y gestión dinámica de campañas publicitarias y cupones de beneficios sin dependencias externas[cite: 22, 23].

## 💡 Patrones Aplicados

* [cite_start]**Singleton (`config`)**: Centraliza un `ConfigurationManager` único para resguardar las reglas de negocio globales en memoria[cite: 50, 51].
* [cite_start]**Builder (`model`)**: Separa la construcción compleja de los cupones (`CouponBuilder`) en una clase independiente para lograr interfaces fluidas paso a paso[cite: 126, 132].
* [cite_start]**Prototype (`model`)**: Implementa clonación profunda (`Campaign`) para duplicar campañas base estacionales de forma ágil e inmutable en memoria[cite: 166, 174].
* [cite_start]**Factory Method (`factory`)**: Abstrae la instanciación de los canales de alerta (`NotifierFactory`), aislando el core del negocio del medio final de envío (Email/SMS)[cite: 72, 73].
* [cite_start]**Abstract Factory (`factory`)**: Genera familias de objetos compatibles (mensajes de bienvenida + cupones) según el perfil de suscripción del usuario (VIP/Regular)[cite: 99, 100].

---

## 🏛️ Diagrama de Clases (UML)

```mermaid
%%{init: { 'flowchart': { 'curve': 'linear' } } }%%
classDiagram
    class ConfigurationManager {
        -static ConfigurationManager instance
        +static getInstance() ConfigurationManager
    }
    class Coupon {
        -String code
    }
    class CouponBuilder {
        -Coupon coupon
        +getResult() Coupon
    }
    class ClonableCampaign {
        <<interface>>
        +clone()
    }
    class Campaign {
        -String name
        -List coupons
    }
    class Notifier {
        <<interface>>
        +sendNotification()
    }
    class EmailNotifier {
    }
    class SmsNotifier {
    }
    class NotifierFactory {
        +static createNotifier()
    }
    class WelcomeKitFactory {
        <<interface>>
        +createWelcomeCoupon()
    }
    class VipKitFactory {
    }
    class RegularKitFactory {
    }

    CouponBuilder --> Coupon : "Builds"
    ClonableCampaign <|.. Campaign
    Campaign --> "*" Coupon : "Contains"
    Notifier <|.. EmailNotifier
    Notifier <|.. SmsNotifier
    NotifierFactory ..> Notifier : "Creates"
    WelcomeKitFactory <|.. VipKitFactory
    WelcomeKitFactory <|.. RegularKitFactory
    VipKitFactory ..> CouponBuilder : "Uses"
    RegularKitFactory ..> CouponBuilder : "Uses"

```

## 🛠️ Tecnologías y Ejecución

* **Stack**: Java 17+ (POO pura sin frameworks externos).
* **Clonación**: `git clone https://github.com/lucasberonvonbrand/creational-patterns.git`
* **Ejecución**: Abrir en tu IDE y correr el método `main` en `src/main/java/com/creationalpatterns/Main.java`.

## 👨‍💻 Autor

- **Lucas Ruben Beron Von Brand**
