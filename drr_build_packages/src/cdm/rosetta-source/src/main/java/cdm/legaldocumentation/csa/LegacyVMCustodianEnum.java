package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details of how the Custodian is determined.
 * @version 6.23.0
 */
@RosettaEnum("LegacyVMCustodianEnum")
public enum LegacyVMCustodianEnum {

	/**
	 * Not Applicable.
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 * A named entity is specified as the Custodian.
	 */
	@RosettaEnumValue(value = "NamedEntity") 
	NAMED_ENTITY("NamedEntity", null),
	
	/**
	 * The Custodian as advised by Party 1 to Party 2.
	 */
	@RosettaEnumValue(value = "AsAdvised1to2", displayName = "As advised by Party 1 to Party 2") 
	AS_ADVISED_1_TO_2("AsAdvised1to2", "As advised by Party 1 to Party 2"),
	
	/**
	 * The Custodian as advised by Party 2 to Party 1.
	 */
	@RosettaEnumValue(value = "AsAdvised2to1", displayName = "As advised by Party 2 to Party 1") 
	AS_ADVISED_2_TO_1("AsAdvised2to1", "As advised by Party 2 to Party 1"),
	
	/**
	 * Party 1 will notify Party 2 of the custodian.
	 */
	@RosettaEnumValue(value = "Party1toParty2", displayName = "Party 1 will notify Party 2") 
	PARTY_1_TO_PARTY_2("Party1toParty2", "Party 1 will notify Party 2"),
	
	/**
	 * Party 2 will notify Party 1 of the custodian.
	 */
	@RosettaEnumValue(value = "Party2toParty1", displayName = "Party 2 will notify Party 1") 
	PARTY_2_TO_PARTY_1("Party2toParty1", "Party 2 will notify Party 1")
;
	private static Map<String, LegacyVMCustodianEnum> values;
	static {
        Map<String, LegacyVMCustodianEnum> map = new ConcurrentHashMap<>();
		for (LegacyVMCustodianEnum instance : LegacyVMCustodianEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegacyVMCustodianEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegacyVMCustodianEnum fromDisplayName(String name) {
		LegacyVMCustodianEnum value = values.get(name);
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
