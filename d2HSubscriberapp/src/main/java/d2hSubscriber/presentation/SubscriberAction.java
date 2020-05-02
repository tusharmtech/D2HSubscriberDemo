package d2hSubscriber.presentation;

import java.util.Scanner;

import d2hSubscriber.businessLogic.D2HOperations;

public class SubscriberAction {

	D2HOperations d2hOps = new D2HOperations();
	Scanner in = new Scanner(System.in);

	public void showMenu() {
		System.out.println("1. View current balance in the account");
		System.out.println("2. Recharge Account");
		System.out.println("3. View available packs, channels and services");
		System.out.println("4. Subscribe to base packs");
		System.out.println("5. Add channels to an existing subscription");
		System.out.println("6. Subscribe to special services");
		System.out.println("7. View current subscription details");
		System.out.println("8. Update email and phone number for notifications");
		System.out.println("9. Exit");
		System.out.println("Select the Option from 1 to 9:");
	}

	public void menuOptionselect() {
		int iSwitch;
		iSwitch = in.nextInt();
		switch (iSwitch) {
		case 1:
			// Opertaion1 : - > View Current Balance
			getCurrentBalance();
			break;
		case 2:
			rechargeAccount();
			break;
		case 3:
			viewAvailablePacks_Services_Channels();
			break;

		case 4:
			subscribeChannelPacks();
			break;

		case 5:
			// add channels to existing subscription
			addChannels_ExistingSubscription();
			break;

		case 6:
			// operation 6 - > Subscribe to special services
			subscribe_Specialservices();
			break;
		case 7:
			// Operation 7 - > current Subscription
			viewCurrentSubscription_details();
			break;
		case 8:
			// Operation 8 - > Update email and phone number for notifications
			System.out.println("Update email and phone number for notifications ->");
			System.out.println("Enter the email:");
			String email = in.next();
			System.out.println("Enter phone:");
			String mob = in.next();
			d2hOps.updateEmailandPhone(email, mob);
			break;
		case 9:
			// Operation9- > Exit from Menu
			exitMenu();
			break;
		default:
			// Default Selection
			defaultSelect_Menu();
			break;
		}
	}

	// Opertaion1 : - > View Current Balance
	public void getCurrentBalance() {
		d2hOps.viewCurrentBalance();
	}

	// Operation2 - > Recharge Account
	public void rechargeAccount() {
		System.out.println(" Recharges Account - >");
		System.out.println("Enter the recharge Amount:");
		int rechargeAmount = 0;
		rechargeAmount = in.nextInt();
		d2hOps.rechargeAccount_subscriber(rechargeAmount);
	}

	// Operation3. View Available Packs , Services and Channels ->
	public void viewAvailablePacks_Services_Channels() {
		System.out.println("View Available Packs , Services and Channels ->");
		d2hOps.viewAvailpacks_channels_services();
	}

	// Operation4. Subscribe to Channel Packs
	public void subscribeChannelPacks() {
		System.out.println("Subscribe to Channel Packs ->");
		System.out.println("Enter the Pack you wish to subscribe: (Silver:S, Gold:G):");
		String pack = in.next();
		System.out.println("Enter Subscription Period(in months):");
		int month = in.nextInt();
		d2hOps.subscribeChannelpack(pack, month);
	}

	// Operation5. Add channels to existing subscription
	public void addChannels_ExistingSubscription() {
		System.out.println("Add channels to existing subscription ->");
		System.out.println("Enter channel names to add (separated by commas): Discovery, NatGeo");
		String channelListbyUser = in.next();
		d2hOps.addChannels_existingSubscription(channelListbyUser);
	}

	// Operation6. SubsCribe to Special Services
	public void subscribe_Specialservices() {
		System.out.println("SubsCribe to Special Services ->");
		System.out.println("Enter the Service Name (LearnEnglish / LearnCooking):");
		String subscribeService = in.next();
		d2hOps.subscribeSpecialservices(subscribeService);
	}

	// Operation7. View Current Subscription Details
	public void viewCurrentSubscription_details() {
		System.out.println("View Current Subscription Details - > ");
		d2hOps.viewCurrentSubscriptionDetails();
	}

	// Operation8. Update email and phone number for notifications
	public void update_email_phone() {
		update_email_phone();
	}

	// Operation9. Exit Menu
	public void exitMenu() {
		in.close();
		System.exit(0);
	}

	// default operation
	public void defaultSelect_Menu() {
		System.out.println("Not in the list");
	}
}
