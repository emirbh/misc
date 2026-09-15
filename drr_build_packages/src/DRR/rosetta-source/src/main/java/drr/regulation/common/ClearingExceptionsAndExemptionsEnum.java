package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ClearingExceptionsAndExemptionsEnum")
public enum ClearingExceptionsAndExemptionsEnum {

	/**
	 * End-User
	 */
	@RosettaEnumValue(value = "ENDU") 
	ENDU("ENDU", null),
	
	/**
	 * Agent-Affiliate
	 */
	@RosettaEnumValue(value = "AFFL") 
	AFFL("AFFL", null),
	
	/**
	 * SmallBank
	 */
	@RosettaEnumValue(value = "SMBK") 
	SMBK("SMBK", null),
	
	/**
	 * Cooperative
	 */
	@RosettaEnumValue(value = "COOP") 
	COOP("COOP", null),
	
	/**
	 * No-action letter
	 */
	@RosettaEnumValue(value = "NOAL") 
	NOAL("NOAL", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, ClearingExceptionsAndExemptionsEnum> values;
	static {
        Map<String, ClearingExceptionsAndExemptionsEnum> map = new ConcurrentHashMap<>();
		for (ClearingExceptionsAndExemptionsEnum instance : ClearingExceptionsAndExemptionsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingExceptionsAndExemptionsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingExceptionsAndExemptionsEnum fromDisplayName(String name) {
		ClearingExceptionsAndExemptionsEnum value = values.get(name);
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
