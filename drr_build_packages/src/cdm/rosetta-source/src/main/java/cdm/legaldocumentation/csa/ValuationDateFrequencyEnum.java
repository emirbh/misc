package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The regularity of the event for the Valuation Date.
 * @version 6.23.0
 */
@RosettaEnum("ValuationDateFrequencyEnum")
public enum ValuationDateFrequencyEnum {

	@RosettaEnumValue(value = "Daily") 
	DAILY("Daily", null),
	
	@RosettaEnumValue(value = "Weekly") 
	WEEKLY("Weekly", null),
	
	@RosettaEnumValue(value = "Fortnightly") 
	FORTNIGHTLY("Fortnightly", null),
	
	@RosettaEnumValue(value = "Monthly") 
	MONTHLY("Monthly", null),
	
	@RosettaEnumValue(value = "AsAgreed") 
	AS_AGREED("AsAgreed", null),
	
	@RosettaEnumValue(value = "AsSelected") 
	AS_SELECTED("AsSelected", null)
;
	private static Map<String, ValuationDateFrequencyEnum> values;
	static {
        Map<String, ValuationDateFrequencyEnum> map = new ConcurrentHashMap<>();
		for (ValuationDateFrequencyEnum instance : ValuationDateFrequencyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationDateFrequencyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationDateFrequencyEnum fromDisplayName(String name) {
		ValuationDateFrequencyEnum value = values.get(name);
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
