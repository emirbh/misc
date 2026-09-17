package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specification of which party calculating the value of collateral to be delivered or returned.
 * @version 6.23.0
 */
@RosettaEnum("ValuationAgentPartyEnum")
public enum ValuationAgentPartyEnum {

	/**
	 * Party 1 will calculate the value of collateral to be delivered or returned.
	 */
	@RosettaEnumValue(value = "Party1", displayName = "Party 1") 
	PARTY_1("Party1", "Party 1"),
	
	/**
	 * Party 2 will calculate the value of collateral to be delivered or returned.
	 */
	@RosettaEnumValue(value = "Party2", displayName = "Party 2") 
	PARTY_2("Party2", "Party 2"),
	
	/**
	 * The party making the demand will calculate the value of collateral to be delivered or returned.
	 */
	@RosettaEnumValue(value = "PartyMakingDemand", displayName = "Party Making the Demand") 
	PARTY_MAKING_DEMAND("PartyMakingDemand", "Party Making the Demand")
;
	private static Map<String, ValuationAgentPartyEnum> values;
	static {
        Map<String, ValuationAgentPartyEnum> map = new ConcurrentHashMap<>();
		for (ValuationAgentPartyEnum instance : ValuationAgentPartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationAgentPartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationAgentPartyEnum fromDisplayName(String name) {
		ValuationAgentPartyEnum value = values.get(name);
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
