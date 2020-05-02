package d2hSubscriber.presentation;

public class D2hProgramMain {

	public static void main(String[] args) {
		boolean flag = true;
		System.out.println("Welcome to SatTV");
		SubscriberAction SubscriberActn = new SubscriberAction();
		do {
			SubscriberActn.showMenu();
			SubscriberActn.menuOptionselect();
		} while (flag);
	}
}
