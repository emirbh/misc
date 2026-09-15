package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the approximate duration of the contract in the context of commodity trading. Exact boundaries between allowed values in EMIR Refit have not been precisely defined so far. This enumeration is expected to be removed when values exact definitions of values emerge and a functional assessment of duration - based upon start and end dates and times - can be implemented.
 * @version 7.7.0
 */
@RosettaEnum("CommodityTimeUnitEnum")
public enum CommodityTimeUnitEnum {

	/**
	 * Second
	 */
	@RosettaEnumValue(value = "Second") 
	SECOND("Second", null),
	
	/**
	 * Minute
	 */
	@RosettaEnumValue(value = "Minute") 
	MINUTE("Minute", null),
	
	/**
	 * Hour
	 */
	@RosettaEnumValue(value = "Hour") 
	HOUR("Hour", null),
	
	/**
	 * Day
	 */
	@RosettaEnumValue(value = "Day") 
	DAY("Day", null),
	
	/**
	 * Week
	 */
	@RosettaEnumValue(value = "Week") 
	WEEK("Week", null),
	
	/**
	 * Month
	 */
	@RosettaEnumValue(value = "Month") 
	MONTH("Month", null),
	
	/**
	 * Year
	 */
	@RosettaEnumValue(value = "Year") 
	YEAR("Year", null),
	
	/**
	 * Quarter
	 */
	@RosettaEnumValue(value = "Quarter") 
	QUARTER("Quarter", null),
	
	/**
	 * Season
	 */
	@RosettaEnumValue(value = "Season") 
	SEASON("Season", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, CommodityTimeUnitEnum> values;
	static {
        Map<String, CommodityTimeUnitEnum> map = new ConcurrentHashMap<>();
		for (CommodityTimeUnitEnum instance : CommodityTimeUnitEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityTimeUnitEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityTimeUnitEnum fromDisplayName(String name) {
		CommodityTimeUnitEnum value = values.get(name);
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
