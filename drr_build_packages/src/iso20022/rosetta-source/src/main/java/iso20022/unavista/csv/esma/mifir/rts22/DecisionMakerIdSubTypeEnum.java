package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies the Subtype of Id used for DecisionMakerIdSubType
 * @version ${project.version}
 */
@RosettaEnum("DecisionMakerIdSubTypeEnum")
public enum DecisionMakerIdSubTypeEnum {

	/**
	 * Passport number
	 */
	@RosettaEnumValue(value = "CCPT") 
	CCPT("CCPT", null),
	
	/**
	 * Other ids as national ID
	 */
	@RosettaEnumValue(value = "NIDN") 
	NIDN("NIDN", null),
	
	/**
	 * Concatenated number
	 */
	@RosettaEnumValue(value = "CONCAT") 
	CONCAT("CONCAT", null)
;
	private static Map<String, DecisionMakerIdSubTypeEnum> values;
	static {
        Map<String, DecisionMakerIdSubTypeEnum> map = new ConcurrentHashMap<>();
		for (DecisionMakerIdSubTypeEnum instance : DecisionMakerIdSubTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DecisionMakerIdSubTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DecisionMakerIdSubTypeEnum fromDisplayName(String name) {
		DecisionMakerIdSubTypeEnum value = values.get(name);
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
