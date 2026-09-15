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
 * Provision Defines applicable periods for interpolation.
 *
 */
@RosettaEnum("InterpolationPeriodEnum")
public enum InterpolationPeriodEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Interpolation is applicable to the initial period only.
	 *
	 */
	@RosettaEnumValue(value = "Initial") 
	INITIAL("Initial", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Interpolation is applicable to the initial and final periods only.
	 *
	 */
	@RosettaEnumValue(value = "InitialAndFinal") 
	INITIAL_AND_FINAL("InitialAndFinal", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Interpolation is applicable to the final period only.
	 *
	 */
	@RosettaEnumValue(value = "Final") 
	FINAL("Final", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Interpolation is applicable to any non-standard period.
	 *
	 */
	@RosettaEnumValue(value = "AnyPeriod") 
	ANY_PERIOD("AnyPeriod", null)
;
	private static Map<String, InterpolationPeriodEnum> values;
	static {
        Map<String, InterpolationPeriodEnum> map = new ConcurrentHashMap<>();
		for (InterpolationPeriodEnum instance : InterpolationPeriodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterpolationPeriodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterpolationPeriodEnum fromDisplayName(String name) {
		InterpolationPeriodEnum value = values.get(name);
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
