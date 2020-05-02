package d2hSubscriber.businessLogic;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

public class Subscriber {

	private static AtomicLong idCounter = new AtomicLong();
	
	public Subscriber(String subscriberName, String SubscriberEmail, String mob) {
		this.Subscriberid = createID();
		this.SubscriberName = subscriberName;
		this.SubscriberEmail = SubscriberEmail;
		this.SubscriberMob = mob;
	}

	public static String createID() {
		String idPrefix = "S1";
		return idPrefix + String.valueOf(idCounter.getAndIncrement());
	}

	public String getSubscriberid() {
		return Subscriberid;
	}

	public String getSubscriberName() {
		return SubscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.SubscriberName = subscriberName;
	}

	public String getSubscriberEmail() {
		return SubscriberEmail;
	}

	public void setSubscriberEmail(String subscriberEmail) {
		SubscriberEmail = subscriberEmail;
	}

	public String getSubscriberMob() {
		return SubscriberMob;
	}

	public String updateSubscriberemail(String email) {
		setSubscriberEmail(email);
		return "Email updated Successfully";
	}

	public String updateSubscribermob(String mob) {
		setSubscriberMob(mob);
		return "Mobile No. Updated Successfully";
	}

	public void setSubscriberMob(String subscriberMob) {
		SubscriberMob = subscriberMob;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void updateAccountBalance(int subscribedAmount) {
		accountBalance = accountBalance - subscribedAmount;
	}

	public void rechargeAccountBalance(int rechargeAmount) {
		accountBalance = accountBalance + rechargeAmount;
	}

	public String getSubscriberDetails() {
		return toString();
	}

	@Override
	public String toString() {
		return "User [id=" + this.Subscriberid + ", Name=" + this.SubscriberName + ", mobile=" + this.SubscriberMob
				+ ", Email=" + this.SubscriberEmail + "]";
	}

	String SubscriberName;
	String SubscriberEmail;
	String Subscriberid;
	String SubscriberMob;
	int accountBalance = 100;

}
