package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify an elective amount.
 * @version 6.23.0
 */
@RosettaEnum("ElectiveAmountEnum")
public enum ElectiveAmountEnum {

	/**
	 * The elective amount is zero.
	 */
	@RosettaEnumValue(value = "Zero") 
	ZERO("Zero", null),
	
	/**
	 * The elective amount has no upper limit.
	 */
	@RosettaEnumValue(value = "Unlimited") 
	UNLIMITED("Unlimited", null)
;
	private static Map<String, ElectiveAmountEnum> values;
	static {
        Map<String, ElectiveAmountEnum> map = new ConcurrentHashMap<>();
		for (ElectiveAmountEnum instance : ElectiveAmountEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ElectiveAmountEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ElectiveAmountEnum fromDisplayName(String name) {
		ElectiveAmountEnum value = values.get(name);
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
