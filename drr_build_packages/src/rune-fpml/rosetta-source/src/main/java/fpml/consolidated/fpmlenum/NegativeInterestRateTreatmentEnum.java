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
 * Provision The method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 *
 */
@RosettaEnum("NegativeInterestRateTreatmentEnum")
public enum NegativeInterestRateTreatmentEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "NegativeInterestRateMethod") 
	NEGATIVE_INTEREST_RATE_METHOD("NegativeInterestRateMethod", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "ZeroInterestRateMethod") 
	ZERO_INTEREST_RATE_METHOD("ZeroInterestRateMethod", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "ZeroInterestRateMethodExcludingSpread") 
	ZERO_INTEREST_RATE_METHOD_EXCLUDING_SPREAD("ZeroInterestRateMethodExcludingSpread", null)
;
	private static Map<String, NegativeInterestRateTreatmentEnum> values;
	static {
        Map<String, NegativeInterestRateTreatmentEnum> map = new ConcurrentHashMap<>();
		for (NegativeInterestRateTreatmentEnum instance : NegativeInterestRateTreatmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NegativeInterestRateTreatmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NegativeInterestRateTreatmentEnum fromDisplayName(String name) {
		NegativeInterestRateTreatmentEnum value = values.get(name);
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
