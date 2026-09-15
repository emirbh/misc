package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication as to whether the option may be exercised only at a fixed date (European, and Asian style), a series of pre-specified dates (Bermudan) or at any time during the life of the contract (American style). This field is only applicable for options, warrants and entitlement certificates.
 * @version ${project.version}
 */
@RosettaEnum("OptionStyleEnum")
public enum OptionStyleEnum {

	/**
	 * European
	 */
	@RosettaEnumValue(value = "EURO") 
	EURO("EURO", null),
	
	/**
	 * American
	 */
	@RosettaEnumValue(value = "AMER") 
	AMER("AMER", null),
	
	/**
	 * Asian
	 */
	@RosettaEnumValue(value = "ASIA") 
	ASIA("ASIA", null),
	
	/**
	 * Bermudan
	 */
	@RosettaEnumValue(value = "BERM") 
	BERM("BERM", null),
	
	/**
	 * Any other type
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, OptionStyleEnum> values;
	static {
        Map<String, OptionStyleEnum> map = new ConcurrentHashMap<>();
		for (OptionStyleEnum instance : OptionStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionStyleEnum fromDisplayName(String name) {
		OptionStyleEnum value = values.get(name);
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
