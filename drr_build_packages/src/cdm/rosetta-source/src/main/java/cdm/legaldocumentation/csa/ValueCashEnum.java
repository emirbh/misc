package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details of how cash collateral is valued when resolving disputes.
 * @version 6.23.0
 */
@RosettaEnum("ValueCashEnum")
public enum ValueCashEnum {

	/**
	 * Cash - Amount thereof.
	 */
	@RosettaEnumValue(value = "CashAmount", displayName = "Cash - Amount Thereof") 
	CASH_AMOUNT("CashAmount", "Cash - Amount Thereof"),
	
	/**
	 * Cash - amount thereof multiplied by Valuation Percentage.
	 */
	@RosettaEnumValue(value = "CashPercentage", displayName = "Cash - Amount Thereof multiplied by Valuation Percentage") 
	CASH_PERCENTAGE("CashPercentage", "Cash - Amount Thereof multiplied by Valuation Percentage"),
	
	/**
	 * Cash - Amount Thereof multiplied by (Valuation Percentage - FX Haircut).
	 */
	@RosettaEnumValue(value = "CashPercentageLessHaircut", displayName = "Cash - Amount Thereof multiplied by (Valuation Percentage - FX Haircut)") 
	CASH_PERCENTAGE_LESS_HAIRCUT("CashPercentageLessHaircut", "Cash - Amount Thereof multiplied by (Valuation Percentage - FX Haircut)"),
	
	/**
	 * Exception value.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, ValueCashEnum> values;
	static {
        Map<String, ValueCashEnum> map = new ConcurrentHashMap<>();
		for (ValueCashEnum instance : ValueCashEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValueCashEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValueCashEnum fromDisplayName(String name) {
		ValueCashEnum value = values.get(name);
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
