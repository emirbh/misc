package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbReturnorPayoutTriggerEnum")
public enum AnnaDsbReturnorPayoutTriggerEnum {

	/**
	 * a cash settled total return swap or forward where the parties agree to exchange on the maturity of the contract the difference between the opening price and closing price of the underlying
	 */
	@RosettaEnumValue(value = "Contract_for_Difference_CFD_", displayName = "Contract for Difference (CFD)") 
	CONTRACT_FOR_DIFFERENCE_CFD("Contract_for_Difference_CFD_", "Contract for Difference (CFD)"),
	
	/**
	 * Credit Default
	 */
	@RosettaEnumValue(value = "Credit_Default", displayName = "Credit Default") 
	CREDIT_DEFAULT("Credit_Default", "Credit Default"),
	
	/**
	 * a fixed-term contract between two parties where one party will make an interest rate payment for each interval and the other party will pay the total dividends received as pay-out by a selected underlying asset
	 */
	@RosettaEnumValue(value = "Dividend", displayName = "Dividend") 
	DIVIDEND("Dividend", "Dividend"),
	
	/**
	 * Forward price of underlying instrument
	 */
	@RosettaEnumValue(value = "Forward_price_of_underlying_instrument", displayName = "Forward price of underlying instrument") 
	FORWARD_PRICE_OF_UNDERLYING_INSTRUMENT("Forward_price_of_underlying_instrument", "Forward price of underlying instrument"),
	
	/**
	 * Miscellaneous
	 */
	@RosettaEnumValue(value = "Other", displayName = "Other") 
	OTHER("Other", "Other"),
	
	/**
	 * price return equity swap, similar to a total return swap, except that dividends are not passed through to the buyer
	 */
	@RosettaEnumValue(value = "Price", displayName = "Price") 
	PRICE("Price", "Price"),
	
	/**
	 * the payout is determined by the movement in the reference price of the underlying instrument to its price at expiry (or the price when the holder wishes to close out) multiplied by an agreed amount per point movement
	 */
	@RosettaEnumValue(value = "Spreadbets", displayName = "Spreadbets") 
	SPREADBETS("Spreadbets", "Spreadbets"),
	
	/**
	 * the total economic return of an underlying asset is transferred from one party (total return buyer) to another (total return seller); total return seller takes on the risk of negative changes in market value of the reference asset, and pays any positive cash flow to the buyer such as coupon, capital gains or dividends of the reference asset
	 */
	@RosettaEnumValue(value = "Total_Return", displayName = "Total Return") 
	TOTAL_RETURN("Total_Return", "Total Return"),
	
	/**
	 * a forward swap that uses the variance (being the volatility squared) of an underlying&#39;s price movement over a period as the basis for the payoff calculation
	 */
	@RosettaEnumValue(value = "Variance", displayName = "Variance") 
	VARIANCE("Variance", "Variance"),
	
	/**
	 * the variability of movements in a security or underlying instrument&#39;s price; it is a measure of the amount by which an asset&#39;s price is expected to fluctuate over a given period of time; it is normally measured by the annual standard deviation of daily price changes
	 */
	@RosettaEnumValue(value = "Volatility", displayName = "Volatility") 
	VOLATILITY("Volatility", "Volatility")
;
	private static Map<String, AnnaDsbReturnorPayoutTriggerEnum> values;
	static {
        Map<String, AnnaDsbReturnorPayoutTriggerEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbReturnorPayoutTriggerEnum instance : AnnaDsbReturnorPayoutTriggerEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbReturnorPayoutTriggerEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbReturnorPayoutTriggerEnum fromDisplayName(String name) {
		AnnaDsbReturnorPayoutTriggerEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
