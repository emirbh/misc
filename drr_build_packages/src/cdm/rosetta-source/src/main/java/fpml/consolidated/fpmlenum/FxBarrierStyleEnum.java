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
 * Provision Defines the barrier observation style i.e. continuous (American) or discrete (European).
 *
 */
@RosettaEnum("FxBarrierStyleEnum")
public enum FxBarrierStyleEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The barrier is observed continuously through the observation period.
	 *
	 */
	@RosettaEnumValue(value = "American") 
	AMERICAN("American", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The barrier is observed on a discrete expiry date, or (in the case of a multi-phase product) series of expiry dates.
	 *
	 */
	@RosettaEnumValue(value = "European") 
	EUROPEAN("European", null)
;
	private static Map<String, FxBarrierStyleEnum> values;
	static {
        Map<String, FxBarrierStyleEnum> map = new ConcurrentHashMap<>();
		for (FxBarrierStyleEnum instance : FxBarrierStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxBarrierStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxBarrierStyleEnum fromDisplayName(String name) {
		FxBarrierStyleEnum value = values.get(name);
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
