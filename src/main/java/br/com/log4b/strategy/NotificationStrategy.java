package br.com.log4b.strategy;

import br.com.log4b.domain.NotificationRequest;

public interface NotificationStrategy {

    void notificate(NotificationRequest request);
}
