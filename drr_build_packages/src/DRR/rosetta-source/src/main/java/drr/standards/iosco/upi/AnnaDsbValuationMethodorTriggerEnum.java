package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbValuationMethodorTriggerEnum")
public enum AnnaDsbValuationMethodorTriggerEnum {

	/**
	 * an option where either the strike price or the settlement price is the average level of an underlying instrument over a predetermined period; the averaging can be either a geometric or arithmetic average
	 */
	@RosettaEnumValue(value = "Asian", displayName = "Asian") 
	ASIAN("Asian", "Asian"),
	
	/**
	 * an option whose final exercise depends upon the path taken by the price of an underlying instrument; for a knockout barrier option, the option is cancelled if the underlying price crosses a predetermined barrier level; for a knock-in barrier option, the option becomes available-for-exercise if the underlying price crosses a predetermined barrier level
	 */
	@RosettaEnumValue(value = "Barrier", displayName = "Barrier") 
	BARRIER("Barrier", "Barrier"),
	
	/**
	 * an option that has a pre-determined payout if the option is in-the-money and the payoff condition is satisfied; also referred to as a &#39;binary option&#39; or an &#39;all-or-nothing option&#39;
	 */
	@RosettaEnumValue(value = "Digital_Binary", displayName = "Digital (Binary)") 
	DIGITAL_BINARY("Digital_Binary", "Digital (Binary)"),
	
	/**
	 * a digital option embedded with a barrier option; there are different variations of this type of option; as an example, a down-and-out digital call option will pay a fixed payoff, or the underlying, at any time before maturity that the underlying price is equal to or greater than the barrier level; it will pay zero if the underlying price is less than the barrier level
	 */
	@RosettaEnumValue(value = "Digital_Barrier", displayName = "Digital Barrier") 
	DIGITAL_BARRIER("Digital_Barrier", "Digital Barrier"),
	
	/**
	 * an option that minimizes the uncertainties related to the timing of market entry; there are two types of lookback options: fixed and floating; the fixed option strike is determined at purchase, and the floating option strike is determined at maturity
	 */
	@RosettaEnumValue(value = "Lookback", displayName = "Lookback") 
	LOOKBACK("Lookback", "Lookback"),
	
	/**
	 * Miscellaneous
	 */
	@RosettaEnumValue(value = "Other", displayName = "Other") 
	OTHER("Other", "Other"),
	
	/**
	 * an option on a contract whose payoff is directly related to the price pattern the underlying asset follows during the life of the contract
	 */
	@RosettaEnumValue(value = "Other_Path_Dependent", displayName = "Other Path Dependent") 
	OTHER_PATH_DEPENDENT("Other_Path_Dependent", "Other Path Dependent"),
	
	/**
	 * an option for which all terms are standardized
	 */
	@RosettaEnumValue(value = "Vanilla", displayName = "Vanilla") 
	VANILLA("Vanilla", "Vanilla")
;
	private static Map<String, AnnaDsbValuationMethodorTriggerEnum> values;
	static {
        Map<String, AnnaDsbValuationMethodorTriggerEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbValuationMethodorTriggerEnum instance : AnnaDsbValuationMethodorTriggerEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbValuationMethodorTriggerEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbValuationMethodorTriggerEnum fromDisplayName(String name) {
		AnnaDsbValuationMethodorTriggerEnum value = values.get(name);
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
