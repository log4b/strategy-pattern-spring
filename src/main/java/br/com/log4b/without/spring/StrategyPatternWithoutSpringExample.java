package br.com.log4b.without.spring;

import br.com.log4b.domain.NotificationRequest;
import br.com.log4b.domain.NotificationType;
import br.com.log4b.strategy.EmailStrategy;
import br.com.log4b.strategy.SmsStrategy;
import br.com.log4b.strategy.TelegramStrategy;
import br.com.log4b.strategy.WhatsappStrategy;

public class StrategyPatternWithoutSpringExample {

    public void sendNotification(NotificationRequest request, NotificationType notificationType) throws IllegalArgumentException {
        switch(notificationType)    {
            case SMS:
                request.setNotificationStrategy(new SmsStrategy());
                break;

            case Whatsapp:
                request.setNotificationStrategy(new WhatsappStrategy());
                break;

            case Email:
                request.setNotificationStrategy(new EmailStrategy());
                break;

            case Telegram:
                request.setNotificationStrategy(new TelegramStrategy());
                break;

            default:
                System.err.println("No strategy found, aborting the request");
                throw new IllegalArgumentException("Invalid notification type");
        }

        request.sendNotification();
    }
}
