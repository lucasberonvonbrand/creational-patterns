package com.creationalpatterns.factory;

public class EmailNotifier implements Notifier {

    @Override
    public void sendNotification(String message) {
        System.out.println("📧 [EMAIL] Enviando alerta: " + message);
    }
}