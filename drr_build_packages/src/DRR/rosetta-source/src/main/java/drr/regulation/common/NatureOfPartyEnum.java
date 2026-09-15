package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * EMIR Nature of the counterparty taxonomy
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/esma-entity-classification"
 *
 * Provision 
 *
 */
@RosettaEnum("NatureOfPartyEnum")
public enum NatureOfPartyEnum {

	/**
	 * Indicates the organization with respect to the reporting Regime is a Central Counterparty, for example under ESMA EMIR.
	 */
	@RosettaEnumValue(value = "CentralCounterparty") 
	CENTRAL_COUNTERPARTY("CentralCounterparty", null),
	
	/**
	 * Parties that are exempted from reporting Financial, NonFinancial status as per Article 1(5) of EMIR, such as Multilateral Development Banks.
	 */
	@RosettaEnumValue(value = "Exempt") 
	EXEMPT("Exempt", null),
	
	/**
	 * Indicates the organization referenced by the partyTradeInformation with respect to the reporting Regime is a Financial Entity, for example in ESMA reporting.
	 */
	@RosettaEnumValue(value = "Financial") 
	FINANCIAL("Financial", null),
	
	/**
	 * Indicates the organization referenced by the partyTradeInformation with respect to the reporting Regime is a NonFinancial Entity, for example in ESMA reporting.
	 */
	@RosettaEnumValue(value = "NonFinancial") 
	NON_FINANCIAL("NonFinancial", null)
;
	private static Map<String, NatureOfPartyEnum> values;
	static {
        Map<String, NatureOfPartyEnum> map = new ConcurrentHashMap<>();
		for (NatureOfPartyEnum instance : NatureOfPartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NatureOfPartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NatureOfPartyEnum fromDisplayName(String name) {
		NatureOfPartyEnum value = values.get(name);
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
