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
 * Provision The Upper Bound Direction. It only contains the AtOrBelow and Below values.
 *
 */
@RosettaEnum("FxRegionUpperBoundDirectionEnum")
public enum FxRegionUpperBoundDirectionEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "AtOrBelow") 
	AT_OR_BELOW("AtOrBelow", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Below") 
	BELOW("Below", null)
;
	private static Map<String, FxRegionUpperBoundDirectionEnum> values;
	static {
        Map<String, FxRegionUpperBoundDirectionEnum> map = new ConcurrentHashMap<>();
		for (FxRegionUpperBoundDirectionEnum instance : FxRegionUpperBoundDirectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxRegionUpperBoundDirectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxRegionUpperBoundDirectionEnum fromDisplayName(String name) {
		FxRegionUpperBoundDirectionEnum value = values.get(name);
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
