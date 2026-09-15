package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of identification code
 * @version 7.7.0
 */
@RosettaEnum("HKTRPartyScheme")
public enum HKTRPartyScheme {

	/**
	 * Business Registration Number
	 */
	@RosettaEnumValue(value = "BRNO") 
	BRNO("BRNO", null),
	
	/**
	 * Certificate of Incorporation Number, for locally incorporated companies or Certificate of Registration Number, for companies incorporated overseas
	 */
	@RosettaEnumValue(value = "CICR") 
	CICR("CICR", null),
	
	/**
	 * Transactional Entity ID
	 */
	@RosettaEnumValue(value = "TRID") 
	TRID("TRID", null),
	
	/**
	 * Unique Business Identifier
	 */
	@RosettaEnumValue(value = "UBIN") 
	UBIN("UBIN", null),
	
	/**
	 * User Defined Code
	 */
	@RosettaEnumValue(value = "USDC") 
	USDC("USDC", null)
;
	private static Map<String, HKTRPartyScheme> values;
	static {
        Map<String, HKTRPartyScheme> map = new ConcurrentHashMap<>();
		for (HKTRPartyScheme instance : HKTRPartyScheme.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	HKTRPartyScheme(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static HKTRPartyScheme fromDisplayName(String name) {
		HKTRPartyScheme value = values.get(name);
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
