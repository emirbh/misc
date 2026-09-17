package fpml.consolidated.fpmlenum;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The duration of Security Lending transaction can be only Term or Open. There are many business and market rules that are derived from the duration of the transaction.
 *
 */
@RosettaEnum("SecurityLendingDurationEnum")
public enum SecurityLendingDurationEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the contract is an open arrangement, which remains in effect unless or until terminated at the option of one or both parties. Repo business rule: When the repo is 'Open', the forward leg MUST NOT be specified. SBL business rule: When a security lending arrangement is 'Open', the termination block ('termination/settlementDate') MUST NOT be specified.
	 *
	 */
	@RosettaEnumValue(value = "Open") 
	OPEN("Open", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that a contract is a regular term contract, with a start date and an end date. Repo business rule: When the repo is 'Term', both spot and forward legs MUST be specified. SBL business rule: When a security lending arrangement is 'Term', both the initiation block ('initiation/settlementDate') and the termination block ('termination/settlementDate') MUST be specified.
	 *
	 */
	@RosettaEnumValue(value = "Term") 
	TERM("Term", null)
;
	private static Map<String, SecurityLendingDurationEnum> values;
	static {
        Map<String, SecurityLendingDurationEnum> map = new ConcurrentHashMap<>();
		for (SecurityLendingDurationEnum instance : SecurityLendingDurationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SecurityLendingDurationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SecurityLendingDurationEnum fromDisplayName(String name) {
		SecurityLendingDurationEnum value = values.get(name);
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
