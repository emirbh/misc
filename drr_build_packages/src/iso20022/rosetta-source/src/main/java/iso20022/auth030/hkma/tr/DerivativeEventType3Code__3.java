package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Explanation or reason for the action being taken on the transaction reporting.
 * @version ${project.version}
 */
@RosettaEnum("DerivativeEventType3Code__3")
public enum DerivativeEventType3Code__3 {

	/**
	 * Allocation event, where an existing derivative is allocated to different counterparties and reported as new derivatives.
	 */
	@RosettaEnumValue(value = "ALOC") 
	ALOC("ALOC", null),
	
	/**
	 * Process in which a CCP interposes itself between the counterparties to the contract becoming the buyer to the counterparty that was a seller and the seller to the counterparty that was a buyer.
	 */
	@RosettaEnumValue(value = "CLRG") 
	CLRG("CLRG", null),
	
	/**
	 * Simultaneous clearing and allocation event in a derivatives clearing organisation.
	 */
	@RosettaEnumValue(value = "CLAL") 
	CLAL("CLAL", null),
	
	/**
	 * Compression or post-trade risk reduction exercise.
	 */
	@RosettaEnumValue(value = "COMP") 
	COMP("COMP", null),
	
	/**
	 * Result of a corporate action.
	 */
	@RosettaEnumValue(value = "CORP") 
	CORP("CORP", null),
	
	/**
	 * Applies only to credit derivatives. A credit event that results in a termination or modification of a derivative, at a trade or position level.
	 */
	@RosettaEnumValue(value = "CREV") 
	CREV("CREV", null),
	
	/**
	 * Termination of an existing derivative transaction prior to scheduled termination or maturity date.
	 */
	@RosettaEnumValue(value = "ETRM") 
	ETRM("ETRM", null),
	
	/**
	 * The exercise of an option or a swaption by one counterparty of the transaction, fully or partially.
	 */
	@RosettaEnumValue(value = "EXER") 
	EXER("EXER", null),
	
	/**
	 * Inclusion of an ETD or CFD into a position, where an existing derivative is terminated and either a new position is created or the notional of an existing position is modified.
	 */
	@RosettaEnumValue(value = "INCP") 
	INCP("INCP", null),
	
	/**
	 * The replacement of a party to a derivative contract with another party giving rise to a new derivative contract.
	 */
	@RosettaEnumValue(value = "NOVA") 
	NOVA("NOVA", null)
;
	private static Map<String, DerivativeEventType3Code__3> values;
	static {
        Map<String, DerivativeEventType3Code__3> map = new ConcurrentHashMap<>();
		for (DerivativeEventType3Code__3 instance : DerivativeEventType3Code__3.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DerivativeEventType3Code__3(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DerivativeEventType3Code__3 fromDisplayName(String name) {
		DerivativeEventType3Code__3 value = values.get(name);
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
