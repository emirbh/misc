package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The day at which the value of the collateral and obligations to transfer or return collateral are to be calculated relative to the Valuation Date.
 * @version 6.23.0
 */
@RosettaEnum("ValuationTimeDayEnum")
public enum ValuationTimeDayEnum {

	/**
	 * Should be calculated relative to the previous local business day.
	 */
	@RosettaEnumValue(value = "PreviousLocalBusinessDay", displayName = "Previous Local Business Day") 
	PREVIOUS_LOCAL_BUSINESS_DAY("PreviousLocalBusinessDay", "Previous Local Business Day"),
	
	/**
	 * Should be calculated relative to the previous local business day in the Relevant Market).
	 */
	@RosettaEnumValue(value = "PreviousLocalBusinessDayMarket", displayName = "Previous Local Business Day (Relevant Market)") 
	PREVIOUS_LOCAL_BUSINESS_DAY_MARKET("PreviousLocalBusinessDayMarket", "Previous Local Business Day (Relevant Market)"),
	
	/**
	 * Should be calculated relative to the previous local business day in the city of the Valuation Agent.
	 */
	@RosettaEnumValue(value = "PreviousLocalBusinessDayCityOfAgent", displayName = "Previous Local Business Day (City of Valuation Agent)") 
	PREVIOUS_LOCAL_BUSINESS_DAY_CITY_OF_AGENT("PreviousLocalBusinessDayCityOfAgent", "Previous Local Business Day (City of Valuation Agent)"),
	
	/**
	 * Should be calculated on the Valuation Date.
	 */
	@RosettaEnumValue(value = "ValuationDate", displayName = "Valuation Date") 
	VALUATION_DATE("ValuationDate", "Valuation Date"),
	
	/**
	 * Should be calculated relative to the previous local business day as selected.
	 */
	@RosettaEnumValue(value = "AsSelected", displayName = "As Selected") 
	AS_SELECTED("AsSelected", "As Selected")
;
	private static Map<String, ValuationTimeDayEnum> values;
	static {
        Map<String, ValuationTimeDayEnum> map = new ConcurrentHashMap<>();
		for (ValuationTimeDayEnum instance : ValuationTimeDayEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationTimeDayEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationTimeDayEnum fromDisplayName(String name) {
		ValuationTimeDayEnum value = values.get(name);
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
