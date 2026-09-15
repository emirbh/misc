package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration of the role of a party in a report.  Used to clarify which participant&#39;s information is being reported.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/reporting-role"
 *
 * Provision 
 *
 */
@RosettaEnum("ReportingRoleEnum")
public enum ReportingRoleEnum {

	/**
	 * The reporting counterparty has concluded the contract as agent for the account of and on behalf of a client.
	 */
	@RosettaEnumValue(value = "Agent") 
	AGENT("Agent", null),
	
	/**
	 * The reporting counterparty is providing the relevant details for their side of the transaction.
	 */
	@RosettaEnumValue(value = "Counterparty") 
	COUNTERPARTY("Counterparty", null),
	
	/**
	 * Party has fully delegated responsibility of their reporting obligation in this jurisdiction to the submitter of this transaction.
	 */
	@RosettaEnumValue(value = "FullyDelegated") 
	FULLY_DELEGATED("FullyDelegated", null),
	
	/**
	 * Party has taken sole responsibility of the reporting obligation in the applicable jurisdiction.
	 */
	@RosettaEnumValue(value = "Independent") 
	INDEPENDENT("Independent", null),
	
	/**
	 * Party has partially delegated responsibility of their reporting obligation (typically the common data only) in this jurisdiction to the submitter of this transaction.
	 */
	@RosettaEnumValue(value = "PartiallyDelegated") 
	PARTIALLY_DELEGATED("PartiallyDelegated", null),
	
	/**
	 * The reporting counterparty has concluded the contract as principal on own account (on own behalf or on behalf of a client).
	 */
	@RosettaEnumValue(value = "Principal") 
	PRINCIPAL("Principal", null),
	
	/**
	 * Party responsible for reporting this transaction.
	 */
	@RosettaEnumValue(value = "ReportingParty") 
	REPORTING_PARTY("ReportingParty", null),
	
	/**
	 * Party not responsible for reporting this transaction.
	 */
	@RosettaEnumValue(value = "VoluntaryParty") 
	VOLUNTARY_PARTY("VoluntaryParty", null)
;
	private static Map<String, ReportingRoleEnum> values;
	static {
        Map<String, ReportingRoleEnum> map = new ConcurrentHashMap<>();
		for (ReportingRoleEnum instance : ReportingRoleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReportingRoleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReportingRoleEnum fromDisplayName(String name) {
		ReportingRoleEnum value = values.get(name);
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
