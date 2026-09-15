package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Explanation or reason for the action being taken on the contract, where applicable.
 * @version 7.7.0
 */
@RosettaEnum("EventTypeEnum")
public enum EventTypeEnum {

	/**
	 * Trade: Conclusion of a derivative or renegotiation of its terms that does not result in change of a counterparty.
	 */
	@RosettaEnumValue(value = "TRAD") 
	TRAD("TRAD", null),
	
	/**
	 * Step-in: An event, where part or entirety of the derivative is transferred to a counterparty 2 (and reported as a new derivative) and the existing derivative is either terminated or its notional is modified.
	 */
	@RosettaEnumValue(value = "NOVA") 
	NOVA("NOVA", null),
	
	/**
	 * PTRR: Post-trade risk reduction exercise.
	 */
	@RosettaEnumValue(value = "COMP") 
	COMP("COMP", null),
	
	/**
	 * Early termination: Termination of a derivative, at a trade or position level.
	 */
	@RosettaEnumValue(value = "ETRM") 
	ETRM("ETRM", null),
	
	/**
	 * Clearing: Central clearing is a process where a derivatives clearing organization interposes itself between counterparties to contracts, becoming the buyer to every seller and the seller to every buyer. It has the effect of terminating an existing transaction between the buyer and the seller and thereby ensuring the performance of open contracts.
	 */
	@RosettaEnumValue(value = "CLRG") 
	CLRG("CLRG", null),
	
	/**
	 * Exercise: The exercise of an option or a swaption by one counterparty of the transaction, fully or partially.
	 */
	@RosettaEnumValue(value = "EXER") 
	EXER("EXER", null),
	
	/**
	 * Allocation: Allocation event, where an existing derivative is allocated to different counterparties and reported as new derivatives with reduced notional amounts.
	 */
	@RosettaEnumValue(value = "ALOC") 
	ALOC("ALOC", null),
	
	/**
	 * Clearing and Allocation: A simultaneous clearing and allocation event in a derivatives clearing organization.
	 */
	@RosettaEnumValue(value = "CLAL") 
	CLAL("CLAL", null),
	
	/**
	 * Credit event: An event or trigger that results in the termination or modification of the state of a previously submitted credit derivative transaction.
	 */
	@RosettaEnumValue(value = "CREV") 
	CREV("CREV", null),
	
	/**
	 * Corporate event: A corporate action on equity underlying that impacts the derivatives on that equity.
	 */
	@RosettaEnumValue(value = "CORP") 
	CORP("CORP", null),
	
	/**
	 * Inclusion in position: Inclusion of CCP-cleared derivative or CFD into a position, where an existing derivative is terminated and either a new position is created or the notional of an existing position is modified.
	 */
	@RosettaEnumValue(value = "INCP") 
	INCP("INCP", null),
	
	/**
	 * Update: Update of an outstanding derivative performed during the transition period in order to ensure its conformity with the amended reporting requirements.
	 */
	@RosettaEnumValue(value = "UPDT") 
	UPDT("UPDT", null),
	
	/**
	 * Transfer: The process by which a swap is transferred to another SDR that has the effect of the closing of the swap transaction at one SDR or opening of the same swap transaction using the same UTI/USI in a different SDR (new).
	 */
	@RosettaEnumValue(value = "PTNG") 
	PTNG("PTNG", null)
;
	private static Map<String, EventTypeEnum> values;
	static {
        Map<String, EventTypeEnum> map = new ConcurrentHashMap<>();
		for (EventTypeEnum instance : EventTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EventTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EventTypeEnum fromDisplayName(String name) {
		EventTypeEnum value = values.get(name);
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
