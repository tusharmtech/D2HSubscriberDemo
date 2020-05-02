package d2hSubscriber.businessLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubscriptionServices {
	ArrayList<String> serviceList = new ArrayList<String>();
	HashMap<String, Integer> subsServicesMonthlyRate = new HashMap<String, Integer>();
	private static int learnEnglishRate = 200, learnCookingRate = 100;

	public SubscriptionServices() {
		serviceList.add("LearnEnglish");
		serviceList.add("LearnCooking");
		subsServicesMonthlyRate.put("LearnEnglish", learnEnglishRate);
		subsServicesMonthlyRate.put("LearnCooking", learnCookingRate);

	}

	// Add Service in List by Name
	public void addService(String serviceName) {
		serviceList.add(serviceName);
	}

	// Remove Channels in List by Name
	public void removeService(String serviceName) {
		serviceList.remove(serviceName);
	}

	public List<String> getServices() {
		return serviceList;
	}

	public HashMap<String, Integer> getServiceswithMonthlyrates() {
		return subsServicesMonthlyRate;
	}

	public void displayServices() {
		System.out.println("Available Services:" + getServices().toString());
	}

	public void displayServiceswithRates() {
		System.out.println("Services are: ");
		subsServicesMonthlyRate.forEach((k, v) -> {
			System.out.println(k + " " + v + " Rs.");
		});
	}
}
