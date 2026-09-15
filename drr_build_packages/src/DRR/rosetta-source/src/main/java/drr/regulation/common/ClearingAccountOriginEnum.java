package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ClearingAccountOriginEnum")
public enum ClearingAccountOriginEnum {

	/**
	 * House
	 */
	@RosettaEnumValue(value = "HOUS") 
	HOUS("HOUS", null),
	
	/**
	 * Client
	 */
	@RosettaEnumValue(value = "CLIE") 
	CLIE("CLIE", null)
;
	private static Map<String, ClearingAccountOriginEnum> values;
	static {
        Map<String, ClearingAccountOriginEnum> map = new ConcurrentHashMap<>();
		for (ClearingAccountOriginEnum instance : ClearingAccountOriginEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingAccountOriginEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingAccountOriginEnum fromDisplayName(String name) {
		ClearingAccountOriginEnum value = values.get(name);
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
