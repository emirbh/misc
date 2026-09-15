package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlyingInstrumentIndexTermUnitEnum")
public enum AnnaDsbUnderlyingInstrumentIndexTermUnitEnum {

	/**
	 * Rate is reported in days
	 */
	@RosettaEnumValue(value = "DAYS") 
	DAYS("DAYS", null),
	
	/**
	 * Rate is reported in months
	 */
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	/**
	 * Rate is reported in weeks
	 */
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	/**
	 * Rate is reported in years
	 */
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null)
;
	private static Map<String, AnnaDsbUnderlyingInstrumentIndexTermUnitEnum> values;
	static {
        Map<String, AnnaDsbUnderlyingInstrumentIndexTermUnitEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum instance : AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlyingInstrumentIndexTermUnitEnum fromDisplayName(String name) {
		AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value = values.get(name);
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
