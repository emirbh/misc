package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbDebtSeniorityEnum")
public enum AnnaDsbDebtSeniorityEnum {

	/**
	 * Junior Debt
	 */
	@RosettaEnumValue(value = "JUND") 
	JUND("JUND", null),
	
	/**
	 * Mezzanine
	 */
	@RosettaEnumValue(value = "MZZD") 
	MZZD("MZZD", null),
	
	/**
	 * Subordinated Debt
	 */
	@RosettaEnumValue(value = "SBOD") 
	SBOD("SBOD", null),
	
	/**
	 * Senior Debt
	 */
	@RosettaEnumValue(value = "SNDB") 
	SNDB("SNDB", null)
;
	private static Map<String, AnnaDsbDebtSeniorityEnum> values;
	static {
        Map<String, AnnaDsbDebtSeniorityEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbDebtSeniorityEnum instance : AnnaDsbDebtSeniorityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbDebtSeniorityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbDebtSeniorityEnum fromDisplayName(String name) {
		AnnaDsbDebtSeniorityEnum value = values.get(name);
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
