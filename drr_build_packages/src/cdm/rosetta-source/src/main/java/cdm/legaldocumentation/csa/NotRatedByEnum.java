package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values applicable to define the what conditions apply to trigger a Not Rated condition.
 * @version 6.23.0
 */
@RosettaEnum("NotRatedByEnum")
public enum NotRatedByEnum {

	/**
	 * No rating is available for the Party for any of the stated Rating Agencies.
	 */
	@RosettaEnumValue(value = "All") 
	ALL("All", null),
	
	/**
	 * No rating is available for the Party for any one of the stated Rating Agencies.
	 */
	@RosettaEnumValue(value = "One") 
	ONE("One", null),
	
	/**
	 * No rating is available for the Party for any two of the stated Rating Agencies.
	 */
	@RosettaEnumValue(value = "Two") 
	TWO("Two", null)
;
	private static Map<String, NotRatedByEnum> values;
	static {
        Map<String, NotRatedByEnum> map = new ConcurrentHashMap<>();
		for (NotRatedByEnum instance : NotRatedByEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotRatedByEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotRatedByEnum fromDisplayName(String name) {
		NotRatedByEnum value = values.get(name);
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
