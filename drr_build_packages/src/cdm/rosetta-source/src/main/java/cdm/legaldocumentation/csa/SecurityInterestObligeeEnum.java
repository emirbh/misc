package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values applicable for Security Interest for Obligations Obligee.
 * @version 6.23.0
 */
@RosettaEnum("SecurityInterestObligeeEnum")
public enum SecurityInterestObligeeEnum {

	/**
	 * Party A.
	 */
	@RosettaEnumValue(value = "PartyA") 
	PARTY_A("PartyA", null),
	
	/**
	 * Party A or any Affiliate of Party A.
	 */
	@RosettaEnumValue(value = "PartyAOrAffiliate", displayName = "Party A or any Affiliate of Party A") 
	PARTY_A_OR_AFFILIATE("PartyAOrAffiliate", "Party A or any Affiliate of Party A"),
	
	/**
	 * Party B.
	 */
	@RosettaEnumValue(value = "PartyB") 
	PARTY_B("PartyB", null),
	
	/**
	 * Party B or any Affiliate of Party B.
	 */
	@RosettaEnumValue(value = "PartyBOrAffiliate", displayName = "Party B or any Affiliate of Party B") 
	PARTY_B_OR_AFFILIATE("PartyBOrAffiliate", "Party B or any Affiliate of Party B"),
	
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, SecurityInterestObligeeEnum> values;
	static {
        Map<String, SecurityInterestObligeeEnum> map = new ConcurrentHashMap<>();
		for (SecurityInterestObligeeEnum instance : SecurityInterestObligeeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SecurityInterestObligeeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SecurityInterestObligeeEnum fromDisplayName(String name) {
		SecurityInterestObligeeEnum value = values.get(name);
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
