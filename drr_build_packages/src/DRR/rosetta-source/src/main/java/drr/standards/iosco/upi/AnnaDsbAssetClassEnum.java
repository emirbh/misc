package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbAssetClassEnum")
public enum AnnaDsbAssetClassEnum {

	@RosettaEnumValue(value = "Commodities", displayName = "Commodities") 
	COMMODITIES("Commodities", "Commodities"),
	
	@RosettaEnumValue(value = "Credit", displayName = "Credit") 
	CREDIT("Credit", "Credit"),
	
	@RosettaEnumValue(value = "Equity", displayName = "Equity") 
	EQUITY("Equity", "Equity"),
	
	@RosettaEnumValue(value = "Foreign_Exchange", displayName = "Foreign_Exchange") 
	FOREIGN_EXCHANGE("Foreign_Exchange", "Foreign_Exchange"),
	
	@RosettaEnumValue(value = "Other", displayName = "Other") 
	OTHER("Other", "Other"),
	
	@RosettaEnumValue(value = "Rates", displayName = "Rates") 
	RATES("Rates", "Rates")
;
	private static Map<String, AnnaDsbAssetClassEnum> values;
	static {
        Map<String, AnnaDsbAssetClassEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbAssetClassEnum instance : AnnaDsbAssetClassEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbAssetClassEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbAssetClassEnum fromDisplayName(String name) {
		AnnaDsbAssetClassEnum value = values.get(name);
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
