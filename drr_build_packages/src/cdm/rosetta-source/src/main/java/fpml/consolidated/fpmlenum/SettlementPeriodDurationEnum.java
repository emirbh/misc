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
 * Provision Defines the Settlement Period Duration for an Electricity Transaction.
 *
 */
@RosettaEnum("SettlementPeriodDurationEnum")
public enum SettlementPeriodDurationEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Two-hourly duration applies.
	 *
	 */
	@RosettaEnumValue(value = "_2Hours", displayName = "2Hours") 
	_2_HOURS("_2Hours", "2Hours"),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Hourly duration applies.
	 *
	 */
	@RosettaEnumValue(value = "_1Hour", displayName = "1Hour") 
	_1_HOUR("_1Hour", "1Hour"),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Half-hourly duration applies.
	 *
	 */
	@RosettaEnumValue(value = "_30Minutes", displayName = "30Minutes") 
	_30_MINUTES("_30Minutes", "30Minutes"),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quarter-hourly duration applies.
	 *
	 */
	@RosettaEnumValue(value = "_15Minutes", displayName = "15Minutes") 
	_15_MINUTES("_15Minutes", "15Minutes")
;
	private static Map<String, SettlementPeriodDurationEnum> values;
	static {
        Map<String, SettlementPeriodDurationEnum> map = new ConcurrentHashMap<>();
		for (SettlementPeriodDurationEnum instance : SettlementPeriodDurationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SettlementPeriodDurationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SettlementPeriodDurationEnum fromDisplayName(String name) {
		SettlementPeriodDurationEnum value = values.get(name);
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
