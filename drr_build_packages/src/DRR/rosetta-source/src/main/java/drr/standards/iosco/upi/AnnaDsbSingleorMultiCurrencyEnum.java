package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbSingleorMultiCurrencyEnum")
public enum AnnaDsbSingleorMultiCurrencyEnum {

	/**
	 * Cross Currency (multi curency)
	 */
	@RosettaEnumValue(value = "Cross_Currency", displayName = "Cross Currency") 
	CROSS_CURRENCY("Cross_Currency", "Cross Currency"),
	
	/**
	 * Single Currency
	 */
	@RosettaEnumValue(value = "Single_Currency", displayName = "Single Currency") 
	SINGLE_CURRENCY("Single_Currency", "Single Currency")
;
	private static Map<String, AnnaDsbSingleorMultiCurrencyEnum> values;
	static {
        Map<String, AnnaDsbSingleorMultiCurrencyEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbSingleorMultiCurrencyEnum instance : AnnaDsbSingleorMultiCurrencyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbSingleorMultiCurrencyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbSingleorMultiCurrencyEnum fromDisplayName(String name) {
		AnnaDsbSingleorMultiCurrencyEnum value = values.get(name);
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
