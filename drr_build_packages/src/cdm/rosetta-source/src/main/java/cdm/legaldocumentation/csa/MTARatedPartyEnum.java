package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values applicable where a Rated Party is defined within the Minimum Transfer Amount (MTA) clause.
 * @version 6.23.0
 */
@RosettaEnum("MTARatedPartyEnum")
public enum MTARatedPartyEnum {

	/**
	 * Party.
	 */
	@RosettaEnumValue(value = "Party") 
	PARTY("Party", null),
	
	/**
	 * Credit Support Provider.
	 */
	@RosettaEnumValue(value = "CreditSupportProvider") 
	CREDIT_SUPPORT_PROVIDER("CreditSupportProvider", null),
	
	/**
	 * An Named Entity.
	 */
	@RosettaEnumValue(value = "NamedEntity") 
	NAMED_ENTITY("NamedEntity", null),
	
	/**
	 * The Party or Credit Support Provider.
	 */
	@RosettaEnumValue(value = "PartyOrCreditSupportProvider") 
	PARTY_OR_CREDIT_SUPPORT_PROVIDER("PartyOrCreditSupportProvider", null),
	
	/**
	 * An Named Affiliate of the Party.
	 */
	@RosettaEnumValue(value = "NamedAffiliate") 
	NAMED_AFFILIATE("NamedAffiliate", null),
	
	/**
	 * All Affiliates to the Party.
	 */
	@RosettaEnumValue(value = "AllAffiliates", displayName = "All Affiliates to the Party") 
	ALL_AFFILIATES("AllAffiliates", "All Affiliates to the Party")
;
	private static Map<String, MTARatedPartyEnum> values;
	static {
        Map<String, MTARatedPartyEnum> map = new ConcurrentHashMap<>();
		for (MTARatedPartyEnum instance : MTARatedPartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MTARatedPartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MTARatedPartyEnum fromDisplayName(String name) {
		MTARatedPartyEnum value = values.get(name);
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
