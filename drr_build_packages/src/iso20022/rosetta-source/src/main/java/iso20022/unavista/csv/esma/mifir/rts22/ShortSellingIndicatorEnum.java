package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A short sale concluded by an investment firm on its own behalf or on behalf of a client, as described in Article 11.
 * @version ${project.version}
 */
@RosettaEnum("ShortSellingIndicatorEnum")
public enum ShortSellingIndicatorEnum {

	/**
	 * Short sale with no exemption
	 */
	@RosettaEnumValue(value = "SESH") 
	SESH("SESH", null),
	
	/**
	 * short sale with exemption
	 */
	@RosettaEnumValue(value = "SSEX") 
	SSEX("SSEX", null),
	
	/**
	 * No short sale
	 */
	@RosettaEnumValue(value = "SELL") 
	SELL("SELL", null),
	
	/**
	 * Information not abailable
	 */
	@RosettaEnumValue(value = "UNDI") 
	UNDI("UNDI", null)
;
	private static Map<String, ShortSellingIndicatorEnum> values;
	static {
        Map<String, ShortSellingIndicatorEnum> map = new ConcurrentHashMap<>();
		for (ShortSellingIndicatorEnum instance : ShortSellingIndicatorEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ShortSellingIndicatorEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ShortSellingIndicatorEnum fromDisplayName(String name) {
		ShortSellingIndicatorEnum value = values.get(name);
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
