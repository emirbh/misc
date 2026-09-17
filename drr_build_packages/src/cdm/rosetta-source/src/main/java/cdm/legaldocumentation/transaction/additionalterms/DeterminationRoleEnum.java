package cdm.legaldocumentation.transaction.additionalterms;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the enumerated values to specify the determination roles to the transaction. Such roles mostly address any determination that would be required when some Extraordinary Events would happen, for instance qualifying the effectiveness of such event, or when a calculation is required, etc. else any other kind of determination as need be.
 * @version 6.23.0
 */
@RosettaEnum("DeterminationRoleEnum")
public enum DeterminationRoleEnum {

	/**
	 * Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition. As an indication, the role of Calculation Agent is key in regards of other roles, for mainly two reasons : first is that it is a fallback role i.e. whenever another role is not defined, then such role would be assumed by the Calculation Agent ; second is that related determination are not limited to Extraordinary Event per se i.e. any determinationr required in regards of Payout calculations for instance would fall on Calculation Agent, unless otherwise specified in Calculation Agent attached to Economic Terms.
	 */
	@RosettaEnumValue(value = "CalculationAgent") 
	CALCULATION_AGENT("CalculationAgent", null),
	
	/**
	 * Specifies the party responsible for performing related HedgingParty duties as defined in the applicable product definition, notably in regards of particular Extraordinary Events or Price Determination Methods which involve hedging considerations.
	 */
	@RosettaEnumValue(value = "HedgingParty") 
	HEDGING_PARTY("HedgingParty", null),
	
	/**
	 * Specifies the party responsible for performing related HedgingParty duties as defined in the applicable product definition, notably in regards of particular Disruption Events or Early Termination Terms which may involve the calculation of a liquidation or compensation value amount.
	 */
	@RosettaEnumValue(value = "DeterminingParty") 
	DETERMINING_PARTY("DeterminingParty", null)
;
	private static Map<String, DeterminationRoleEnum> values;
	static {
        Map<String, DeterminationRoleEnum> map = new ConcurrentHashMap<>();
		for (DeterminationRoleEnum instance : DeterminationRoleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DeterminationRoleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DeterminationRoleEnum fromDisplayName(String name) {
		DeterminationRoleEnum value = values.get(name);
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
