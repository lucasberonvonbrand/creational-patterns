package com.creationalpatterns.factory;

public class SmsNotifier implements Notifier {

    @Override
    public void sendNotification(String message) {
        System.out.println("💬 [SMS] Enviando alerta: " + message);
    }
}
