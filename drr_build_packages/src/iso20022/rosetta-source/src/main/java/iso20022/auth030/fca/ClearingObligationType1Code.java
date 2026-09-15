package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies whether the reported contract belongs to a class of OTC derivatives that has been declared subject to the clearing obligation and both counterparties to the contract are subject to the clearing obligation under Regulation (EU) No 648/2012, as of the time of execution of the contract.
 * @version ${project.version}
 */
@RosettaEnum("ClearingObligationType1Code")
public enum ClearingObligationType1Code {

	/**
	 * Reported contract does not belong to a class of OTC derivatives that has been declared subject to the clearing obligation.
	 */
	@RosettaEnumValue(value = "FLSE") 
	FLSE("FLSE", null),
	
	/**
	 * Unknown whether reported contract belongs to a class of OTC derivatives that has been declared subject to the clearing obligation.
	 */
	@RosettaEnumValue(value = "UKWN") 
	UKWN("UKWN", null),
	
	/**
	 * Reported contract belongs to a class of OTC derivatives that has been declared subject to the clearing obligation.
	 */
	@RosettaEnumValue(value = "TRUE") 
	TRUE("TRUE", null)
;
	private static Map<String, ClearingObligationType1Code> values;
	static {
        Map<String, ClearingObligationType1Code> map = new ConcurrentHashMap<>();
		for (ClearingObligationType1Code instance : ClearingObligationType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingObligationType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingObligationType1Code fromDisplayName(String name) {
		ClearingObligationType1Code value = values.get(name);
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
