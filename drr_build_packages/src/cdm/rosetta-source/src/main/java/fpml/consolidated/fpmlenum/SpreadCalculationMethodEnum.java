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
 * Provision Specifies the method by which asset swap spread is calculated, par-par or proceeds.
 *
 */
@RosettaEnum("SpreadCalculationMethodEnum")
public enum SpreadCalculationMethodEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "ParPar") 
	PAR_PAR("ParPar", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Proceeds") 
	PROCEEDS("Proceeds", null)
;
	private static Map<String, SpreadCalculationMethodEnum> values;
	static {
        Map<String, SpreadCalculationMethodEnum> map = new ConcurrentHashMap<>();
		for (SpreadCalculationMethodEnum instance : SpreadCalculationMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SpreadCalculationMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SpreadCalculationMethodEnum fromDisplayName(String name) {
		SpreadCalculationMethodEnum value = values.get(name);
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
