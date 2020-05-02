package d2hSubscriber.businessLogic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SubscriberSubscription {

	SubscriptionPack pack;
	SubscriptionServices services;
	Channels channels;

	LinkedHashMap<String, String> suscribedPacks = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<String>> suscribedServices = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, List<String>> suscribedChannels = new LinkedHashMap<String, List<String>>();

	public void addPacksubscription(String id, String packName) {
		if (packName.equalsIgnoreCase("G")) {
			suscribedPacks.put(id, "Gold");
			System.out.println("Subscription Pack " + "Gold" + " " + "is subscribed , Monthly Price Rs 100");
		} else if (packName.equalsIgnoreCase("S")) {
			suscribedPacks.put(id, "Silver");
			System.out.println("Subscription Pack " + "Silver" + " " + "is subscribed ,  Monthly Price Rs 50");
		}
	}

	public void addServicesubscription(String id, List<String> serviceNames) {
		suscribedServices.put(id, serviceNames);
	}

	public void addChannelsubscription(String id, List<String> channels) {
		suscribedChannels.put(id, channels);
	}

	public String getSubscribedPack(String id) {
		if (suscribedPacks.containsKey(id))
			return suscribedPacks.get(id);
		return "No Subscribed Pack found";
	}

	public List<String> getSubscribedServices(String id) {
		if (suscribedServices.containsKey(id))
			return suscribedServices.get(id);
		return new ArrayList<String>(0);
	}

	public List<String> getSubscribedChannels(String id) {
		if (suscribedChannels.containsKey(id))
			return suscribedChannels.get(id);
		return new ArrayList<String>(0);
	}

	public void getAllSubscriptionDetail(String id) {
		getSubscribedPack(id);
		getSubscribedServices(id);
		getSubscribedChannels(id);

	}

}
