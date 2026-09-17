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
 * Provision Average calculation method e.g. Arithmetic, Harmonic)
 *
 */
@RosettaEnum("FxAveragingMethodEnum")
public enum FxAveragingMethodEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Arithmetic method of average calculation.
	 *
	 */
	@RosettaEnumValue(value = "Arithmetic") 
	ARITHMETIC("Arithmetic", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Harmonic method of average calculation.
	 *
	 */
	@RosettaEnumValue(value = "Harmonic") 
	HARMONIC("Harmonic", null)
;
	private static Map<String, FxAveragingMethodEnum> values;
	static {
        Map<String, FxAveragingMethodEnum> map = new ConcurrentHashMap<>();
		for (FxAveragingMethodEnum instance : FxAveragingMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxAveragingMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxAveragingMethodEnum fromDisplayName(String name) {
		FxAveragingMethodEnum value = values.get(name);
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
