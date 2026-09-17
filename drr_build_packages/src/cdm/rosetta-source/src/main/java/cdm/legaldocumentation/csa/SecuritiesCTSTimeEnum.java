package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details the day on which securities collateral is required to be transferred relative to the Notification Time.
 * @version 6.23.0
 */
@RosettaEnum("SecuritiesCTSTimeEnum")
public enum SecuritiesCTSTimeEnum {

	/**
	 * The securities collateral should be transferred on the same day.
	 */
	@RosettaEnumValue(value = "Same") 
	SAME("Same", null),
	
	/**
	 * The securities collateral should be transferred on the next day.
	 */
	@RosettaEnumValue(value = "Next") 
	NEXT("Next", null),
	
	/**
	 * The securities collateral should be transferred on the first local business day.
	 */
	@RosettaEnumValue(value = "FirstDay", displayName = "First Local Business Day") 
	FIRST_DAY("FirstDay", "First Local Business Day"),
	
	/**
	 * The securities collateral should be transferred on the second local business day.
	 */
	@RosettaEnumValue(value = "SecondDay", displayName = "Second Local Business Day") 
	SECOND_DAY("SecondDay", "Second Local Business Day"),
	
	/**
	 * The securities collateral should be transferred on the third local business day.
	 */
	@RosettaEnumValue(value = "ThirdDay", displayName = "Third Local Business Day") 
	THIRD_DAY("ThirdDay", "Third Local Business Day"),
	
	/**
	 * Exception value.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, SecuritiesCTSTimeEnum> values;
	static {
        Map<String, SecuritiesCTSTimeEnum> map = new ConcurrentHashMap<>();
		for (SecuritiesCTSTimeEnum instance : SecuritiesCTSTimeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SecuritiesCTSTimeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SecuritiesCTSTimeEnum fromDisplayName(String name) {
		SecuritiesCTSTimeEnum value = values.get(name);
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
