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
 * Provision 
 *
 */
@RosettaEnum("FPVFinalPriceElectionFallbackEnum")
public enum FPVFinalPriceElectionFallbackEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "FPVClose") 
	FPV_CLOSE("FPVClose", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "FPVHedgeExecution") 
	FPV_HEDGE_EXECUTION("FPVHedgeExecution", null)
;
	private static Map<String, FPVFinalPriceElectionFallbackEnum> values;
	static {
        Map<String, FPVFinalPriceElectionFallbackEnum> map = new ConcurrentHashMap<>();
		for (FPVFinalPriceElectionFallbackEnum instance : FPVFinalPriceElectionFallbackEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FPVFinalPriceElectionFallbackEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FPVFinalPriceElectionFallbackEnum fromDisplayName(String name) {
		FPVFinalPriceElectionFallbackEnum value = values.get(name);
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
