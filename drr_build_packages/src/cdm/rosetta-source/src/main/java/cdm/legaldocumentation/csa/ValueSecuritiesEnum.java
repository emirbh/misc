package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details of how securities collateral is valued when resolving disputes.
 * @version 6.23.0
 */
@RosettaEnum("ValueSecuritiesEnum")
public enum ValueSecuritiesEnum {

	/**
	 * Securities collateral is valued using the bid price multiplied by the valuation percentage.
	 */
	@RosettaEnumValue(value = "BidPricePercentage", displayName = "Securities - Bid Price multiplied by Valuation Percentage") 
	BID_PRICE_PERCENTAGE("BidPricePercentage", "Securities - Bid Price multiplied by Valuation Percentage"),
	
	/**
	 * Securities collateral is valued using the bid price multiplied by the valuation percentage less the FX haircut.
	 */
	@RosettaEnumValue(value = "BidPricePercentageLessHaircut", displayName = "Securities - Bid Price multiplied by (Valuation Percentage - FX Haircut)") 
	BID_PRICE_PERCENTAGE_LESS_HAIRCUT("BidPricePercentageLessHaircut", "Securities - Bid Price multiplied by (Valuation Percentage - FX Haircut)"),
	
	/**
	 * Securities collateral is valued using the mid price multiplied by the valuation percentage.
	 */
	@RosettaEnumValue(value = "MidPricePercentage", displayName = "Securities - Mid Price multiplied by Valuation Percentage") 
	MID_PRICE_PERCENTAGE("MidPricePercentage", "Securities - Mid Price multiplied by Valuation Percentage"),
	
	/**
	 * Securities collateral is valued using the mid price multiplied by the valuation percentage less the FX haircut.
	 */
	@RosettaEnumValue(value = "MidPricePercentageLessHaircut", displayName = "Securities - Mid Price multiplied by (Valuation Percentage - FX Haircut)") 
	MID_PRICE_PERCENTAGE_LESS_HAIRCUT("MidPricePercentageLessHaircut", "Securities - Mid Price multiplied by (Valuation Percentage - FX Haircut)"),
	
	/**
	 * Exception value.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, ValueSecuritiesEnum> values;
	static {
        Map<String, ValueSecuritiesEnum> map = new ConcurrentHashMap<>();
		for (ValueSecuritiesEnum instance : ValueSecuritiesEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValueSecuritiesEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValueSecuritiesEnum fromDisplayName(String name) {
		ValueSecuritiesEnum value = values.get(name);
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
