package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to define the number of Rating Agencies that must be considered to meet the rating condition.
 * @version 6.23.0
 */
@RosettaEnum("NumberOfRatingAgenciesEnum")
public enum NumberOfRatingAgenciesEnum {

	/**
	 * Ratings for all defined Rating Agencies will be considered.
	 */
	@RosettaEnumValue(value = "All") 
	ALL("All", null),
	
	/**
	 * Ratings for Any 1 stated Rating Agency will be applicable.
	 */
	@RosettaEnumValue(value = "AnyOne") 
	ANY_ONE("AnyOne", null),
	
	/**
	 * Ratings for Any 2 stated Rating Agencies will be applicable.
	 */
	@RosettaEnumValue(value = "AnyTwo") 
	ANY_TWO("AnyTwo", null),
	
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, NumberOfRatingAgenciesEnum> values;
	static {
        Map<String, NumberOfRatingAgenciesEnum> map = new ConcurrentHashMap<>();
		for (NumberOfRatingAgenciesEnum instance : NumberOfRatingAgenciesEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NumberOfRatingAgenciesEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NumberOfRatingAgenciesEnum fromDisplayName(String name) {
		NumberOfRatingAgenciesEnum value = values.get(name);
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
