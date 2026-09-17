package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The relevant rating type.
 * @version 6.23.0
 */
@RosettaEnum("RatingTypeEnum")
public enum RatingTypeEnum {

	/**
	 * Long Term Ratings are applicable for the stated Rating Agency.
	 */
	@RosettaEnumValue(value = "LongTerm") 
	LONG_TERM("LongTerm", null),
	
	/**
	 * Short Term Ratings are applicable for the stated Rating Agency.
	 */
	@RosettaEnumValue(value = "ShortTerm") 
	SHORT_TERM("ShortTerm", null)
;
	private static Map<String, RatingTypeEnum> values;
	static {
        Map<String, RatingTypeEnum> map = new ConcurrentHashMap<>();
		for (RatingTypeEnum instance : RatingTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RatingTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RatingTypeEnum fromDisplayName(String name) {
		RatingTypeEnum value = values.get(name);
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
