package d2hSubscriber.businessLogic;

public interface Notification {

	String sendEmailNotification(String str);
	String sendSmsNotification(String str);
}
