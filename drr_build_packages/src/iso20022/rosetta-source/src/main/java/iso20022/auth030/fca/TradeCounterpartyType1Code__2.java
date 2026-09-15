package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type of the trade counterparty.
 * @version ${project.version}
 */
@RosettaEnum("TradeCounterpartyType1Code__2")
public enum TradeCounterpartyType1Code__2 {

	/**
	 * Specifies that party to the transaction is an Executing Agent.
	 */
	@RosettaEnumValue(value = "EXEA") 
	EXEA("EXEA", null)
;
	private static Map<String, TradeCounterpartyType1Code__2> values;
	static {
        Map<String, TradeCounterpartyType1Code__2> map = new ConcurrentHashMap<>();
		for (TradeCounterpartyType1Code__2 instance : TradeCounterpartyType1Code__2.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradeCounterpartyType1Code__2(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradeCounterpartyType1Code__2 fromDisplayName(String name) {
		TradeCounterpartyType1Code__2 value = values.get(name);
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
