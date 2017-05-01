package br.com.log4b.with.spring;

import br.com.log4b.domain.NotificationRequest;
import br.com.log4b.domain.NotificationType;
import br.com.log4b.strategy.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StrategyPatternWithSpringService {

    private final Map<String, NotificationStrategy> notificationStrategies;

    @Autowired
    public StrategyPatternWithSpringService(Map<String, NotificationStrategy> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    public void sendNotification(NotificationRequest notificationRequest, NotificationType notificationType)  {
        notificationRequest.setNotificationStrategy(notificationStrategies.get(notificationType.name()));
        notificationRequest.sendNotification();
    }

    public void showAllStrategies() {
        notificationStrategies.forEach( (k,v) -> System.out.println(k));
    }
}
