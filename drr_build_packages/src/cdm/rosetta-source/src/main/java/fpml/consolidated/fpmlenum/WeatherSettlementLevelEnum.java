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
@RosettaEnum("WeatherSettlementLevelEnum")
public enum WeatherSettlementLevelEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cumulative number of Weather Index Units for each day in the Calculation Period.
	 *
	 */
	@RosettaEnumValue(value = "Cumulative") 
	CUMULATIVE("Cumulative", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cumulative number of Weather Index Units for each day in the Calculation Period divided by the number of days in the Calculation Period.
	 *
	 */
	@RosettaEnumValue(value = "Average") 
	AVERAGE("Average", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum number of Weather Index Units for any day in the Calculation Period.
	 *
	 */
	@RosettaEnumValue(value = "Mximum") 
	MXIMUM("Mximum", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum number of Weather Index Units for any day in the Calculation Period.
	 *
	 */
	@RosettaEnumValue(value = "Minimum") 
	MINIMUM("Minimum", null)
;
	private static Map<String, WeatherSettlementLevelEnum> values;
	static {
        Map<String, WeatherSettlementLevelEnum> map = new ConcurrentHashMap<>();
		for (WeatherSettlementLevelEnum instance : WeatherSettlementLevelEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WeatherSettlementLevelEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WeatherSettlementLevelEnum fromDisplayName(String name) {
		WeatherSettlementLevelEnum value = values.get(name);
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
