package d2hSubscriber.businessLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Channels {

	ArrayList<String> channelList = new ArrayList<String>();
	HashMap<String, Integer> subsChannelMonthlyRate = new HashMap<String, Integer>();

	private static int zeeRate = 10, SonyRate = 15, starPlusRate = 20, discoveryRate = 10, natGeoRate = 20;

	public Channels() {
		channelList.add("Zee");
		channelList.add("Sony");
		channelList.add("StarPlus");
		channelList.add("Discovery");
		channelList.add("NatGeo");
		subsChannelMonthlyRate.put("Zee", zeeRate);
		subsChannelMonthlyRate.put("Sony", SonyRate);
		subsChannelMonthlyRate.put("StarPlus", starPlusRate);
		subsChannelMonthlyRate.put("Discovery", discoveryRate);
		subsChannelMonthlyRate.put("NatGeo", natGeoRate);
	}

	public List<String> getGoldPackchannels() {
		return channelList.subList(0, 5);
	}

	public List<String> getSilverPackchannels() {
		return channelList.subList(0, 3);
	}

	public List<String> getChannels() {
		return channelList;
	}

	// Add Channels in List by Name
	public void addChannel(String channelName) {
		channelList.add(channelName);
	}

	// Remove Channels in List by Name
	public void removeChannel(String channelName) {
		channelList.remove(channelName);
	}

	public HashMap<String, Integer> getChannelwithMonthlyrates() {
		return subsChannelMonthlyRate;
	}

	public void displayChannels() {
		System.out.println("Available Services:" + getChannels().toString());
	}

	public void displayChannelsswithRate() {
		System.out.println("Channels are: ");
		subsChannelMonthlyRate.forEach((k, v) -> {
			System.out.println(k + " " + v + " Rs.");
		});
	}

}
