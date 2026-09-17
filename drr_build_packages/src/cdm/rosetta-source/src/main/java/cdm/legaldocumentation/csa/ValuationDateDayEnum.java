package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the conditions for the day for a Valuation Date.
 * @version 6.23.0
 */
@RosettaEnum("ValuationDateDayEnum")
public enum ValuationDateDayEnum {

	/**
	 * Monday
	 */
	@RosettaEnumValue(value = "MON") 
	MON("MON", null),
	
	/**
	 * Tuesday
	 */
	@RosettaEnumValue(value = "TUE") 
	TUE("TUE", null),
	
	/**
	 * Wednesday
	 */
	@RosettaEnumValue(value = "WED") 
	WED("WED", null),
	
	/**
	 * Thursday
	 */
	@RosettaEnumValue(value = "THU") 
	THU("THU", null),
	
	/**
	 * Friday
	 */
	@RosettaEnumValue(value = "FRI") 
	FRI("FRI", null),
	
	/**
	 * Saturday
	 */
	@RosettaEnumValue(value = "SAT") 
	SAT("SAT", null),
	
	/**
	 * Sunday
	 */
	@RosettaEnumValue(value = "SUN") 
	SUN("SUN", null),
	
	/**
	 * The Date must be a day on which commercial banks are open for general business in the local market.
	 */
	@RosettaEnumValue(value = "LocalBusinessDay") 
	LOCAL_BUSINESS_DAY("LocalBusinessDay", null),
	
	/**
	 * The Date can be a given day on the regular calendar.
	 */
	@RosettaEnumValue(value = "CalendarDay") 
	CALENDAR_DAY("CalendarDay", null),
	
	/**
	 * The Date must be a New York Banking Day, that is a day, other than a Saturday or Sunday, on which banks are open for general commercial business in New York, USA.
	 */
	@RosettaEnumValue(value = "NewYorkBankingDay", displayName = "New York Banking Day") 
	NEW_YORK_BANKING_DAY("NewYorkBankingDay", "New York Banking Day")
;
	private static Map<String, ValuationDateDayEnum> values;
	static {
        Map<String, ValuationDateDayEnum> map = new ConcurrentHashMap<>();
		for (ValuationDateDayEnum instance : ValuationDateDayEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationDateDayEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationDateDayEnum fromDisplayName(String name) {
		ValuationDateDayEnum value = values.get(name);
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
