package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of the transaction identifier for projections
 * @version 7.7.0
 */
@RosettaEnum("UTIProprietarySchemeNameEnum")
public enum UTIProprietarySchemeNameEnum {

	/**
	 * Unique Swap Identifier
	 */
	@RosettaEnumValue(value = "UTI_USI", displayName = "UTI-USI") 
	UTI_USI("UTI_USI", "UTI-USI"),
	
	/**
	 * Unique Trade ID
	 */
	@RosettaEnumValue(value = "UTI_TID", displayName = "UTI-TID") 
	UTI_TID("UTI_TID", "UTI-TID")
;
	private static Map<String, UTIProprietarySchemeNameEnum> values;
	static {
        Map<String, UTIProprietarySchemeNameEnum> map = new ConcurrentHashMap<>();
		for (UTIProprietarySchemeNameEnum instance : UTIProprietarySchemeNameEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	UTIProprietarySchemeNameEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static UTIProprietarySchemeNameEnum fromDisplayName(String name) {
		UTIProprietarySchemeNameEnum value = values.get(name);
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
