package d2hSubscriber.businessLogic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class D2HOperations {

	Subscriber sb = new Subscriber("Anant", null, null);
	SubscriptionPack sps = new SubscriptionPack();
	Channels ch = new Channels();
	SubscriptionServices sServices = new SubscriptionServices();
	SubscriberSubscription ssd = new SubscriberSubscription();
	SubscriptionAmountCalculator smc = new SubscriptionAmountCalculator();
	SubscriberNotification notification = new SubscriberNotification();

	public void viewCurrentBalance() {
		System.out.println("Current Balance is:" + sb.getAccountBalance());
	}

	public void rechargeAccount_subscriber(int rechargeAmount) {
		if (rechargeAmount > 0) {
			sb.rechargeAccountBalance(rechargeAmount);
			System.out.println("Account is recharged Rs:" + rechargeAmount);
			System.out.println("Current Account Balance is:" + sb.getAccountBalance());
		} else {
			System.out.println("Invalid Amount.. Please Enter corrent Amount:");
		}
	}

	public void viewAvailpacks_channels_services() {
		sps.displayPack();
		ch.displayChannelsswithRate();
		sServices.displayServiceswithRates();
	}

	public void subscribeChannelpack(String pack, int month) {
		int monthlyAmount = 0;
		HashMap<String, Integer> getpackRates = new HashMap<String, Integer>();
		getpackRates = sps.getpackRate();
		if (pack.equalsIgnoreCase("S")) {
			monthlyAmount = Integer.parseInt(getpackRates.get("Silver").toString());
			System.out.println("Monthly Price" + monthlyAmount);
		} else if (pack.equalsIgnoreCase("G")) {
			monthlyAmount = Integer.parseInt(getpackRates.get("Gold").toString());
			System.out.println("Monthly Price" + monthlyAmount);
		}
		System.out.println("Subscription Amount:" + smc.calcPackAmount(month, monthlyAmount));
		System.out.println(
				"discount Applied:" + smc.getPackSubscriptionDiscount(smc.calcPackAmount(month, monthlyAmount), month));
		System.out.println("Fianl Price after Discount:" + smc.calcPackAmountAfterDiscount(month, monthlyAmount));
		if (sb.getAccountBalance() >= (smc.calcPackAmountAfterDiscount(month, monthlyAmount))) {
			ssd.addPacksubscription(sb.getSubscriberid(), pack);
			ssd.getSubscribedPack(sb.getSubscriberid());
			sb.updateAccountBalance(smc.calcPackAmountAfterDiscount(month, monthlyAmount));
		} else {
			System.out.println("Insufficient Balance..Please recharge your Account.");
		}
		System.out.println("Account Balance: " + sb.getAccountBalance());
	}

	public void addChannels_existingSubscription(String channelListbyUser) {
		List<String> channelList = Arrays.asList(channelListbyUser.split(",")); //
		// System.out.println("Channel List By User in Array List:" + channelList);
		HashMap<String, Integer> getChannelwithMonthlyrates = new HashMap<String, Integer>();
		getChannelwithMonthlyrates = ch.getChannelwithMonthlyrates();
		for (HashMap.Entry<String, Integer> entry : getChannelwithMonthlyrates.entrySet()) {
			String storedchannel = entry.getKey();
			Integer rate = entry.getValue();
			for (String channel : channelList) {
				if (storedchannel.equalsIgnoreCase(channel.trim())) {
					if (sb.getAccountBalance() >= rate.intValue()) {
						ssd.addChannelsubscription(sb.getSubscriberid(), channelList);
						sb.updateAccountBalance(rate);
					} else {
						System.out.println("Insufficiant Balance.. Please recharge your Account");
					}
				}
			}

		}
		System.out.println("Subscribed Channels:" + ssd.getSubscribedChannels(sb.getSubscriberid()));
		System.out.println("Account Balance is:" + sb.getAccountBalance());
	}

	public void subscribeSpecialservices(String subscribeService) {
		List<String> serviceList = Arrays.asList(subscribeService.split(","));
		HashMap<String, Integer> getServiceswithMonthlyrates = new HashMap<String, Integer>();
		getServiceswithMonthlyrates = sServices.getServiceswithMonthlyrates();
		for (HashMap.Entry<String, Integer> entry : getServiceswithMonthlyrates.entrySet()) {
			String storedservice = entry.getKey();
			Integer rate = entry.getValue();
			for (String service : serviceList) {
				if (storedservice.equalsIgnoreCase(service.trim())) {
					if (sb.getAccountBalance() >= rate.intValue()) {
						ssd.addServicesubscription(sb.getSubscriberid(), serviceList);
						sb.updateAccountBalance(rate);
					} else {
						System.out.println("Insufficiant Balance.. Please recharge your Account");
					}

				}

			}
		}
		System.out.println("Subscribed Service:" + ssd.getSubscribedServices(sb.getSubscriberid()));
		System.out.println("Account Balance is:" + sb.getAccountBalance());

		if (sb.getSubscriberEmail() != null && sb.getSubscriberMob() != null) {
			System.out.println(notification.sendEmailNotification("Email Send Successfully"));
			System.out.println(notification.sendSmsNotification("Sms Send Successfully"));
		}
	}

	public void viewCurrentSubscriptionDetails() {
		System.out.println("Currently subscribed packs and channels: " + ssd.getSubscribedPack(sb.getSubscriberid())
				+ "+" + ssd.getSubscribedChannels(sb.getSubscriberid()));
		System.out.println("Currently Subscribed Services: " + ssd.getSubscribedServices(sb.getSubscriberid()));
	}

	public void updateEmailandPhone(String email, String mob) {
		System.out.println(sb.updateSubscriberemail(email));
		System.out.println(sb.updateSubscribermob(mob));
		System.out.println("Subscriber Detail After Email / Mob update: " + sb.toString());

	}

}
