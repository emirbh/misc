package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the day of the week of the delivery.
 * @version ${project.version}
 */
@RosettaEnum("WeekDay3Code__1")
public enum WeekDay3Code__1 {

	/**
	 * Days of the week excluding bank holidays.
	 */
	@RosettaEnumValue(value = "XBHL") 
	XBHL("XBHL", null),
	
	/**
	 * Days of the week Including bank holidays.
	 */
	@RosettaEnumValue(value = "IBHL") 
	IBHL("IBHL", null),
	
	/**
	 * Friday.
	 */
	@RosettaEnumValue(value = "FRID") 
	FRID("FRID", null),
	
	/**
	 * Monday.
	 */
	@RosettaEnumValue(value = "MOND") 
	MOND("MOND", null),
	
	/**
	 * Saturday.
	 */
	@RosettaEnumValue(value = "SATD") 
	SATD("SATD", null),
	
	/**
	 * Sunday.
	 */
	@RosettaEnumValue(value = "SUND") 
	SUND("SUND", null),
	
	/**
	 * Thursday.
	 */
	@RosettaEnumValue(value = "THUD") 
	THUD("THUD", null),
	
	/**
	 * Tuesday.
	 */
	@RosettaEnumValue(value = "TUED") 
	TUED("TUED", null),
	
	/**
	 * Wednesday.
	 */
	@RosettaEnumValue(value = "WEDD") 
	WEDD("WEDD", null),
	
	/**
	 * Weekdays.
	 */
	@RosettaEnumValue(value = "WDAY") 
	WDAY("WDAY", null),
	
	/**
	 * Weekend.
	 */
	@RosettaEnumValue(value = "WEND") 
	WEND("WEND", null)
;
	private static Map<String, WeekDay3Code__1> values;
	static {
        Map<String, WeekDay3Code__1> map = new ConcurrentHashMap<>();
		for (WeekDay3Code__1 instance : WeekDay3Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WeekDay3Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WeekDay3Code__1 fromDisplayName(String name) {
		WeekDay3Code__1 value = values.get(name);
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
