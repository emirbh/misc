package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Type of action taken on the contract.
 * @version 7.7.0
 */
@RosettaEnum("ActionTypeEnum")
public enum ActionTypeEnum {

	/**
	 * New: A report of a derivative, at a trade or position level, for the first time.
	 */
	@RosettaEnumValue(value = "NEWT") 
	NEWT("NEWT", null),
	
	/**
	 * Modify: A modification to the terms or details of a previously reported derivative, at a trade or position level, but not a correction of a report.
	 */
	@RosettaEnumValue(value = "MODI") 
	MODI("MODI", null),
	
	/**
	 * Valuation: An update of a valuation of a derivative, at a trade or position level.
	 */
	@RosettaEnumValue(value = "VALU") 
	VALU("VALU", null),
	
	/**
	 * Correct: A report correcting the erroneous data fields of a previously submitted report.
	 */
	@RosettaEnumValue(value = "CORR") 
	CORR("CORR", null),
	
	/**
	 * Terminate: A termination of an existing derivative, at a trade or position level.
	 */
	@RosettaEnumValue(value = "TERM") 
	TERM("TERM", null),
	
	/**
	 * Error: A cancellation of a wrongly submitted entire report in case the derivative, at a trade or position level, never came into existence.
	 */
	@RosettaEnumValue(value = "EROR") 
	EROR("EROR", null),
	
	/**
	 * Revive: Re-opening of a derivative, at a trade or position level, that was cancelled with action type Error or terminated by mistake.
	 */
	@RosettaEnumValue(value = "REVI") 
	REVI("REVI", null),
	
	/**
	 * Position component: A report of a new derivative that is included in a separate position report on the same day.
	 */
	@RosettaEnumValue(value = "POSC") 
	POSC("POSC", null),
	
	/**
	 * For the transfer of a Reportable Transaction from one Derivative Trade Repository to another Derivative Trade Repository.
	 */
	@RosettaEnumValue(value = "PRTO") 
	PRTO("PRTO", null),
	
	/**
	 * Collateral: An update to collateral margin data.
	 */
	@RosettaEnumValue(value = "MARU") 
	MARU("MARU", null)
;
	private static Map<String, ActionTypeEnum> values;
	static {
        Map<String, ActionTypeEnum> map = new ConcurrentHashMap<>();
		for (ActionTypeEnum instance : ActionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ActionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ActionTypeEnum fromDisplayName(String name) {
		ActionTypeEnum value = values.get(name);
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
