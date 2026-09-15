package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("JurisdictionEnum")
public enum JurisdictionEnum {

	/**
	 * Mixed
	 */
	@RosettaEnumValue(value = "MIXX") 
	MIXX("MIXX", null),
	
	/**
	 * Commodity Futures Trading Commission
	 */
	@RosettaEnumValue(value = "CFTC") 
	CFTC("CFTC", null),
	
	/**
	 * U.S. Securities and Exchange Commission
	 */
	@RosettaEnumValue(value = "SECH") 
	SECH("SECH", null)
;
	private static Map<String, JurisdictionEnum> values;
	static {
        Map<String, JurisdictionEnum> map = new ConcurrentHashMap<>();
		for (JurisdictionEnum instance : JurisdictionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	JurisdictionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static JurisdictionEnum fromDisplayName(String name) {
		JurisdictionEnum value = values.get(name);
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
