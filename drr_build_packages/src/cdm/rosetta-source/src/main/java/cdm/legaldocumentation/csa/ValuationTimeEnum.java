package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of time specified for the Valuation Time.
 * @version 6.23.0
 */
@RosettaEnum("ValuationTimeEnum")
public enum ValuationTimeEnum {

	/**
	 * The valuation time should be at close of business.
	 */
	@RosettaEnumValue(value = "CloseOfBusiness") 
	CLOSE_OF_BUSINESS("CloseOfBusiness", null),
	
	/**
	 * The valuation time should be at a specific time.
	 */
	@RosettaEnumValue(value = "SpecificTime") 
	SPECIFIC_TIME("SpecificTime", null),
	
	/**
	 * The valuation time should be as selected.
	 */
	@RosettaEnumValue(value = "AsSelected") 
	AS_SELECTED("AsSelected", null)
;
	private static Map<String, ValuationTimeEnum> values;
	static {
        Map<String, ValuationTimeEnum> map = new ConcurrentHashMap<>();
		for (ValuationTimeEnum instance : ValuationTimeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationTimeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationTimeEnum fromDisplayName(String name) {
		ValuationTimeEnum value = values.get(name);
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
