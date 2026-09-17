package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies whether the meaning of credit support amount follows the pre-print definition or deviates from the standard (either based on a rating or some other methodology).
 * @version 6.23.0
 */
@RosettaEnum("CreditSupportAmountEnum")
public enum CreditSupportAmountEnum {

	/**
	 * The standard definition of the credit support amount applies.
	 */
	@RosettaEnumValue(value = "Standard", displayName = "Standard") 
	STANDARD("Standard", "Standard"),
	
	@RosettaEnumValue(value = "IAFloorGIA", displayName = "Non-Standard - IA Floor (Less GiverIA)") 
	IA_FLOOR_GIA("IAFloorGIA", "Non-Standard - IA Floor (Less GiverIA)"),
	
	@RosettaEnumValue(value = "IAFloorGIATIA", displayName = "Non-Standard - IA Floor (Less GiverIA and TakerIA)") 
	IA_FLOOR_GIATIA("IAFloorGIATIA", "Non-Standard - IA Floor (Less GiverIA and TakerIA)"),
	
	@RosettaEnumValue(value = "NonStandardRatings", displayName = "Non-Standard - Ratings") 
	NON_STANDARD_RATINGS("NonStandardRatings", "Non-Standard - Ratings"),
	
	@RosettaEnumValue(value = "NonStandardOther", displayName = "Non-Standard - Other") 
	NON_STANDARD_OTHER("NonStandardOther", "Non-Standard - Other")
;
	private static Map<String, CreditSupportAmountEnum> values;
	static {
        Map<String, CreditSupportAmountEnum> map = new ConcurrentHashMap<>();
		for (CreditSupportAmountEnum instance : CreditSupportAmountEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CreditSupportAmountEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CreditSupportAmountEnum fromDisplayName(String name) {
		CreditSupportAmountEnum value = values.get(name);
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
