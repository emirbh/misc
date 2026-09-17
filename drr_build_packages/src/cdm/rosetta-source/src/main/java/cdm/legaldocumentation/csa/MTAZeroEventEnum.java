package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values for defining the relevant trigger(s) for the Minimum Transfer Amount (MTA) to fall to zero.
 * @version 6.23.0
 */
@RosettaEnum("MTAZeroEventEnum")
public enum MTAZeroEventEnum {

	/**
	 * An Event of Default.
	 */
	@RosettaEnumValue(value = "EventOfDefault") 
	EVENT_OF_DEFAULT("EventOfDefault", null),
	
	/**
	 * A Termination Event.
	 */
	@RosettaEnumValue(value = "TerminationEvent") 
	TERMINATION_EVENT("TerminationEvent", null),
	
	/**
	 * A Termination Event in respect of which all Transactions are Affected Transactions.
	 */
	@RosettaEnumValue(value = "TerminationEventAllAffectedTransactions", displayName = "A Termination Event in respect of which all Transactions are Affected Transactions") 
	TERMINATION_EVENT_ALL_AFFECTED_TRANSACTIONS("TerminationEventAllAffectedTransactions", "A Termination Event in respect of which all Transactions are Affected Transactions"),
	
	/**
	 * A Potential Event of Default.
	 */
	@RosettaEnumValue(value = "PotentialEventOfDefault") 
	POTENTIAL_EVENT_OF_DEFAULT("PotentialEventOfDefault", null),
	
	/**
	 * An Additional Termination Event (ATE).
	 */
	@RosettaEnumValue(value = "AdditionalTerminationEvent") 
	ADDITIONAL_TERMINATION_EVENT("AdditionalTerminationEvent", null),
	
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, MTAZeroEventEnum> values;
	static {
        Map<String, MTAZeroEventEnum> map = new ConcurrentHashMap<>();
		for (MTAZeroEventEnum instance : MTAZeroEventEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MTAZeroEventEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MTAZeroEventEnum fromDisplayName(String name) {
		MTAZeroEventEnum value = values.get(name);
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
