package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines whether the date of a Valuation is defined by a certain day of the week or a particular date in the month.
 * @version 6.23.0
 */
@RosettaEnum("ValuationDateDateEnum")
public enum ValuationDateDateEnum {

	/**
	 * Specific Valuation date frequency.
	 */
	@RosettaEnumValue(value = "Each") 
	EACH("Each", null),
	
	/**
	 * Specific Valuation date frequency.
	 */
	@RosettaEnumValue(value = "Last") 
	LAST("Last", null),
	
	/**
	 * Specific Valuation date frequency.
	 */
	@RosettaEnumValue(value = "Secondlast", displayName = "2nd Last") 
	SECONDLAST("Secondlast", "2nd Last"),
	
	/**
	 * Specific Valuation date frequency.
	 */
	@RosettaEnumValue(value = "Thirdlast", displayName = "3rd Last") 
	THIRDLAST("Thirdlast", "3rd Last"),
	
	/**
	 * Specific Valuation date frequency.
	 */
	@RosettaEnumValue(value = "Fourthlast", displayName = "4th Last") 
	FOURTHLAST("Fourthlast", "4th Last"),
	
	/**
	 * A specific day of the calendar, defined.
	 */
	@RosettaEnumValue(value = "CalendarDay") 
	CALENDAR_DAY("CalendarDay", null),
	
	/**
	 * As Selected.
	 */
	@RosettaEnumValue(value = "AsSelected", displayName = "As Selected") 
	AS_SELECTED("AsSelected", "As Selected")
;
	private static Map<String, ValuationDateDateEnum> values;
	static {
        Map<String, ValuationDateDateEnum> map = new ConcurrentHashMap<>();
		for (ValuationDateDateEnum instance : ValuationDateDateEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationDateDateEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationDateDateEnum fromDisplayName(String name) {
		ValuationDateDateEnum value = values.get(name);
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
