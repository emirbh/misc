package iso20022.auth108.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type of the trade counterparty.
 * @version ${project.version}
 */
@RosettaEnum("TradeCounterpartyType1Code__1")
public enum TradeCounterpartyType1Code__1 {

	/**
	 * Specifies that party to the transaction is an Other Counterparty.
	 */
	@RosettaEnumValue(value = "OTHC") 
	OTHC("OTHC", null),
	
	/**
	 * Specifies that party to the transaction is a Reporting Counterparty.
	 */
	@RosettaEnumValue(value = "REPC") 
	REPC("REPC", null)
;
	private static Map<String, TradeCounterpartyType1Code__1> values;
	static {
        Map<String, TradeCounterpartyType1Code__1> map = new ConcurrentHashMap<>();
		for (TradeCounterpartyType1Code__1 instance : TradeCounterpartyType1Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradeCounterpartyType1Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradeCounterpartyType1Code__1 fromDisplayName(String name) {
		TradeCounterpartyType1Code__1 value = values.get(name);
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
