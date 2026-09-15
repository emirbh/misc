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
 * Provision The specification of whether resets occur relative to the first or last day of a calculation period.
 *
 */
@RosettaEnum("ResetRelativeToEnum")
public enum ResetRelativeToEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "CalculationPeriodStartDate") 
	CALCULATION_PERIOD_START_DATE("CalculationPeriodStartDate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "CalculationPeriodEndDate") 
	CALCULATION_PERIOD_END_DATE("CalculationPeriodEndDate", null)
;
	private static Map<String, ResetRelativeToEnum> values;
	static {
        Map<String, ResetRelativeToEnum> map = new ConcurrentHashMap<>();
		for (ResetRelativeToEnum instance : ResetRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ResetRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ResetRelativeToEnum fromDisplayName(String name) {
		ResetRelativeToEnum value = values.get(name);
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
