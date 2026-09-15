package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication of whether the transaction results from the executing firm carrying out matched principal trading under Article 4(38) of Directive 2014/65/EU or dealing on own account under Article 4(6) of Directive 2014/65/EU. Where the transaction does not result from the executing firm carrying out matched principal trading or dealing on own account, the field shall indicate that the transaction was carried out under any other capacity.
 * @version ${project.version}
 */
@RosettaEnum("TradingCapacityEnum")
public enum TradingCapacityEnum {

	/**
	 * Dealing on own account
	 */
	@RosettaEnumValue(value = "DEAL") 
	DEAL("DEAL", null),
	
	/**
	 * Matched principal
	 */
	@RosettaEnumValue(value = "MTCH") 
	MTCH("MTCH", null),
	
	/**
	 * Any other capacity
	 */
	@RosettaEnumValue(value = "AOTC") 
	AOTC("AOTC", null)
;
	private static Map<String, TradingCapacityEnum> values;
	static {
        Map<String, TradingCapacityEnum> map = new ConcurrentHashMap<>();
		for (TradingCapacityEnum instance : TradingCapacityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradingCapacityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradingCapacityEnum fromDisplayName(String name) {
		TradingCapacityEnum value = values.get(name);
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
