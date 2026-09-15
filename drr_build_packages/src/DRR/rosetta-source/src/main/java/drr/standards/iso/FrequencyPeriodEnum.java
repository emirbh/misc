package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the frequency of an interest payment with a time unit.
 * @version 7.7.0
 */
@RosettaEnum("FrequencyPeriodEnum")
public enum FrequencyPeriodEnum {

	/**
	 * Event takes place every hour
	 */
	@RosettaEnumValue(value = "HOUL") 
	HOUL("HOUL", null),
	
	/**
	 * Event takes place every day.
	 */
	@RosettaEnumValue(value = "DAIL") 
	DAIL("DAIL", null),
	
	/**
	 * Event takes place once a week.
	 */
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	/**
	 * Event takes place every month or once a month.
	 */
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	/**
	 * Event takes place every year or once a year.
	 */
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null),
	
	/**
	 * Event takes place every quarter or once every quarter.
	 */
	@RosettaEnumValue(value = "QURT") 
	QURT("QURT", null),
	
	/**
	 * Event occurs on expiry of a financial contract.
	 */
	@RosettaEnumValue(value = "EXPI") 
	EXPI("EXPI", null),
	
	/**
	 * Event takes place on request or as necessary.
	 */
	@RosettaEnumValue(value = "ADHO") 
	ADHO("ADHO", null),
	
	/**
	 * Event takes place on demand / on request or as necessary.
	 */
	@RosettaEnumValue(value = "ONDE") 
	ONDE("ONDE", null),
	
	/**
	 * Event takes place on demand / on request or as necessary.
	 */
	@RosettaEnumValue(value = "ODMD") 
	ODMD("ODMD", null),
	
	/**
	 *  .
	 */
	@RosettaEnumValue(value = "MIAN") 
	MIAN("MIAN", null)
;
	private static Map<String, FrequencyPeriodEnum> values;
	static {
        Map<String, FrequencyPeriodEnum> map = new ConcurrentHashMap<>();
		for (FrequencyPeriodEnum instance : FrequencyPeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FrequencyPeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FrequencyPeriodEnum fromDisplayName(String name) {
		FrequencyPeriodEnum value = values.get(name);
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
