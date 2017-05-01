package br.com.log4b.without.spring;

import br.com.log4b.domain.NotificationRequest;
import br.com.log4b.domain.NotificationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StrategyPatternWithoutSpringExampleTest {

    private StrategyPatternWithoutSpringExample strategyPatternWithoutSpringExample;

    @Before
    public void setUp() {
        strategyPatternWithoutSpringExample = new StrategyPatternWithoutSpringExample();
    }

    @Test
    public void shouldSendEmailNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Email!");
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.Email);
    }

    @Test
    public void shouldSendEmailAndSmsNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Email and Sms!");
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.Email);
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.SMS);
    }

    @Test
    public void shouldSendWhatsappNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Whatsapp!");
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.Whatsapp);
    }

    @Test
    public void shouldSendTelegramNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Hi Telegram!");
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.Telegram);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSendHipChatNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest("Bruno", "Log4b", "Sorry HipChat :(");
        strategyPatternWithoutSpringExample.sendNotification(notificationRequest, NotificationType.Hipchat);
    }

}
