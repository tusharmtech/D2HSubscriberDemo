package d2hSubscriber.businessLogic;

public class SubscriptionAmountCalculator {

	int discount = 0;
	int finalpackAmount = 0, amount = 0;

	public int calcPackAmountAfterDiscount(int subscription_dur, int monthlyAmount) {

		amount = monthlyAmount * subscription_dur;
		finalpackAmount = amount - getPackSubscriptionDiscount(amount, subscription_dur);
		return finalpackAmount;
	}

	public int calcPackAmount(int subscription_dur, int monthlyAmount) {
		amount = monthlyAmount * subscription_dur;
		return amount;
	}

	public int calcServiceAmount(int subscription_dur, int monthlyAmount) {
		amount = monthlyAmount * subscription_dur;
		finalpackAmount = amount - getServiceSubscriptionDiscount(monthlyAmount, subscription_dur);
		return finalpackAmount;
	}

	public int getPackSubscriptionDiscount(int amount, int month) {

		if (month >= 3) {
			discount = (amount * 10) / 100;
		}

		return discount;
	}

	public int getServiceSubscriptionDiscount(int amount, int month) {
		return discount;
	}
}
