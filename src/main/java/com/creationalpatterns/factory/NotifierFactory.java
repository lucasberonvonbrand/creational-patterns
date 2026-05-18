package com.creationalpatterns.factory;

// Clase Creadora del Factory Method
public class NotifierFactory {

    public static Notifier createNotifier(String type) {

        if (type.equalsIgnoreCase("EMAIL")) return new EmailNotifier();
        if (type.equalsIgnoreCase("SMS")) return new SmsNotifier();
        throw new IllegalArgumentException("Unknown notification type");
    }
}
