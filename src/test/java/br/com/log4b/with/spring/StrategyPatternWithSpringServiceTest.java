package br.com.log4b.with.spring;

import br.com.log4b.domain.NotificationRequest;
import br.com.log4b.domain.NotificationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyPatternWithSpringServiceTest {

    @Autowired
    private StrategyPatternWithSpringService strategyPatternWithSpringService;

    @Test
    public void showAllAvailableStrategies() {
        strategyPatternWithSpringService.showAllStrategies();
    }

    @Test
    public void shouldSendSmsNotification() {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi sms!");
        strategyPatternWithSpringService.sendNotification(notificationRequest, NotificationType.SMS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailHipChatNotification() {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Sorry Hipchat!");
        strategyPatternWithSpringService.sendNotification(notificationRequest, NotificationType.Hipchat);
    }

    @Test
    public void shouldSendTelegramNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Telegram!");
        strategyPatternWithSpringService.sendNotification(notificationRequest, NotificationType.Telegram);
    }

    @Test
    public void shouldSendWhatsappNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Whatsapp!");
        strategyPatternWithSpringService.sendNotification(notificationRequest, NotificationType.Whatsapp);
    }

    @Test
    public void shouldSendEmailNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi email!");
        strategyPatternWithSpringService.sendNotification(notificationRequest, NotificationType.Email);
    }
}