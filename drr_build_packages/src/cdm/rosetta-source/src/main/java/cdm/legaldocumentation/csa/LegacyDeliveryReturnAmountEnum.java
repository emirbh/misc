package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * In respect of a Valuation Date, the amount of collateral which a party is entitled to demand to be transferred to it as a Delivery or Return Amount.
 * @version 6.23.0
 */
@RosettaEnum("LegacyDeliveryReturnAmountEnum")
public enum LegacyDeliveryReturnAmountEnum {

	/**
	 * Standard definition applies.
	 */
	@RosettaEnumValue(value = "Standard") 
	STANDARD("Standard", null),
	
	/**
	 * Election includes non-standard ratings-based langauge.
	 */
	@RosettaEnumValue(value = "NonStandardRatings") 
	NON_STANDARD_RATINGS("NonStandardRatings", null),
	
	/**
	 * Election includes non-standard bespoke language.
	 */
	@RosettaEnumValue(value = "NonStandardOther") 
	NON_STANDARD_OTHER("NonStandardOther", null)
;
	private static Map<String, LegacyDeliveryReturnAmountEnum> values;
	static {
        Map<String, LegacyDeliveryReturnAmountEnum> map = new ConcurrentHashMap<>();
		for (LegacyDeliveryReturnAmountEnum instance : LegacyDeliveryReturnAmountEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegacyDeliveryReturnAmountEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegacyDeliveryReturnAmountEnum fromDisplayName(String name) {
		LegacyDeliveryReturnAmountEnum value = values.get(name);
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
