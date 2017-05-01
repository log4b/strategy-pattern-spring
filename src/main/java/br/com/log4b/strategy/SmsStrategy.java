package br.com.log4b.strategy;

import br.com.log4b.domain.NotificationRequest;
import org.springframework.stereotype.Component;

@Component("SMS")
public class SmsStrategy implements NotificationStrategy {

    @Override
    public void notificate(NotificationRequest request) {
        StringBuilder log = new StringBuilder();
        log.append("Sending sms to: ");
        log.append(request.getTo());
        log.append(" from: ");
        log.append(request.getFrom());

        System.out.println(log.toString());
    }
}
