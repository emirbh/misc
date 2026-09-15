package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the frequency of an interest payment with a time unit.
 * @version ${project.version}
 */
@RosettaEnum("Frequency19Code__1")
public enum Frequency19Code__1 {

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
	 * Event takes place on request or as necessary.
	 */
	@RosettaEnumValue(value = "ADHO") 
	ADHO("ADHO", null),
	
	/**
	 * Event occurs on expiry of a financial contract.
	 */
	@RosettaEnumValue(value = "EXPI") 
	EXPI("EXPI", null),
	
	/**
	 * Event takes place every hours.
	 */
	@RosettaEnumValue(value = "HOUL") 
	HOUL("HOUL", null),
	
	/**
	 * Event takes place on demand.
	 */
	@RosettaEnumValue(value = "ODMD") 
	ODMD("ODMD", null)
;
	private static Map<String, Frequency19Code__1> values;
	static {
        Map<String, Frequency19Code__1> map = new ConcurrentHashMap<>();
		for (Frequency19Code__1 instance : Frequency19Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Frequency19Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Frequency19Code__1 fromDisplayName(String name) {
		Frequency19Code__1 value = values.get(name);
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
