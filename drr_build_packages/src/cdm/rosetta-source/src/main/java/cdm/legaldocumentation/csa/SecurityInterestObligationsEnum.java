package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values applicable for Security Interest for Obligations.
 * @version 6.23.0
 */
@RosettaEnum("SecurityInterestObligationsEnum")
public enum SecurityInterestObligationsEnum {

	/**
	 * Security Interest for Obligations is not applicable to the Party.
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 * All Obligations of Party A.
	 */
	@RosettaEnumValue(value = "AllObligationsOfPartyA", displayName = "All Obligations of Party A") 
	ALL_OBLIGATIONS_OF_PARTY_A("AllObligationsOfPartyA", "All Obligations of Party A"),
	
	/**
	 * All Obligations of Party B.
	 */
	@RosettaEnumValue(value = "AllObligationsOfPartyB", displayName = "All Obligations of Party B") 
	ALL_OBLIGATIONS_OF_PARTY_B("AllObligationsOfPartyB", "All Obligations of Party B"),
	
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, SecurityInterestObligationsEnum> values;
	static {
        Map<String, SecurityInterestObligationsEnum> map = new ConcurrentHashMap<>();
		for (SecurityInterestObligationsEnum instance : SecurityInterestObligationsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SecurityInterestObligationsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SecurityInterestObligationsEnum fromDisplayName(String name) {
		SecurityInterestObligationsEnum value = values.get(name);
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
