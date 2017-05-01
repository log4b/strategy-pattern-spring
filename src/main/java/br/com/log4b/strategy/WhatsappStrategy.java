package br.com.log4b.strategy;

import br.com.log4b.domain.NotificationRequest;
import org.springframework.stereotype.Component;

@Component("Whatsapp")
public class WhatsappStrategy implements NotificationStrategy {

    @Override
    public void notificate(NotificationRequest request) {
        StringBuilder log = new StringBuilder();
        log.append("Sending whatsapp message to: ");
        log.append(request.getTo());
        log.append(" from: ");
        log.append(request.getFrom());

        System.out.println(log.toString());
    }
}
