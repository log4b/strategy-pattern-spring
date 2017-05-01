package br.com.log4b.domain;

import br.com.log4b.strategy.NotificationStrategy;

public class NotificationRequest {

    public String to;
    public String from;
    public String message;

    private NotificationStrategy notificationStrategy;

    public NotificationRequest(String to, String from, String message, NotificationStrategy notificationStrategy) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.notificationStrategy = notificationStrategy;
    }

    public NotificationRequest(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
    }

    public void sendNotification()  {
        notificationStrategy.notificate(this);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        if(null == notificationStrategy)    {
            throw new IllegalArgumentException("An strategy must be chosen");
        }
        this.notificationStrategy = notificationStrategy;
    }
}
