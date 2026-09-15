package iso20022.auth108.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type of the trade counterparty.
 * @version ${project.version}
 */
@RosettaEnum("TradeCounterpartyType1Code")
public enum TradeCounterpartyType1Code {

	/**
	 * Specifies that party to the transaction is a Beneficiary.
	 */
	@RosettaEnumValue(value = "BENE") 
	BENE("BENE", null),
	
	/**
	 * Specifies that party to the transaction is a Broker.
	 */
	@RosettaEnumValue(value = "BROK") 
	BROK("BROK", null),
	
	/**
	 * Specifies that party to the transaction is a Clearing Member.
	 */
	@RosettaEnumValue(value = "CLEM") 
	CLEM("CLEM", null),
	
	/**
	 * Specifies that party to the transaction is an Executing Agent.
	 */
	@RosettaEnumValue(value = "EXEA") 
	EXEA("EXEA", null),
	
	/**
	 * Specifies that party to the transaction is an Other Counterparty.
	 */
	@RosettaEnumValue(value = "OTHC") 
	OTHC("OTHC", null),
	
	/**
	 * Specifies that party to the transaction is a Reporting Counterparty.
	 */
	@RosettaEnumValue(value = "REPC") 
	REPC("REPC", null),
	
	/**
	 * Specifies that party to the transaction is a Submitting Agent.
	 */
	@RosettaEnumValue(value = "SBMA") 
	SBMA("SBMA", null),
	
	/**
	 * Specifies that party to the transaction is an Entity Responsible For Report.
	 */
	@RosettaEnumValue(value = "ERFR") 
	ERFR("ERFR", null)
;
	private static Map<String, TradeCounterpartyType1Code> values;
	static {
        Map<String, TradeCounterpartyType1Code> map = new ConcurrentHashMap<>();
		for (TradeCounterpartyType1Code instance : TradeCounterpartyType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradeCounterpartyType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradeCounterpartyType1Code fromDisplayName(String name) {
		TradeCounterpartyType1Code value = values.get(name);
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
