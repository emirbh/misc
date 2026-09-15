package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the duration of the delivery period.
 * @version 7.7.0
 */
@RosettaEnum("DurationType1Code")
public enum DurationType1Code {

	/**
	 * Duration is a year.
	 */
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null),
	
	/**
	 * Event takes place every week.
	 */
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	/**
	 * Event takes place every six months or two times a year.
	 */
	@RosettaEnumValue(value = "SEAS") 
	SEAS("SEAS", null),
	
	/**
	 * Event takes place every three months or four times a year.
	 */
	@RosettaEnumValue(value = "QURT") 
	QURT("QURT", null),
	
	/**
	 * Event takes place every month or once a month.
	 */
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	/**
	 * Duration is a minute.
	 */
	@RosettaEnumValue(value = "MNUT") 
	MNUT("MNUT", null),
	
	/**
	 * Duration is an hour.
	 */
	@RosettaEnumValue(value = "HOUR") 
	HOUR("HOUR", null),
	
	/**
	 * Duration is a day.
	 */
	@RosettaEnumValue(value = "DASD") 
	DASD("DASD", null),
	
	/**
	 * Duration is expressed in another unit.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, DurationType1Code> values;
	static {
        Map<String, DurationType1Code> map = new ConcurrentHashMap<>();
		for (DurationType1Code instance : DurationType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DurationType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DurationType1Code fromDisplayName(String name) {
		DurationType1Code value = values.get(name);
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
