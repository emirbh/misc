package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details the day on which cash collateral is required to be transferred relative to the Notification Time.
 * @version 6.23.0
 */
@RosettaEnum("CashCTSTimeEnum")
public enum CashCTSTimeEnum {

	/**
	 * The cash collateral should be transferred on the same day.
	 */
	@RosettaEnumValue(value = "Same") 
	SAME("Same", null),
	
	/**
	 * The cash collateral should be transferred on the next day.
	 */
	@RosettaEnumValue(value = "Next") 
	NEXT("Next", null),
	
	/**
	 * The cash collateral should be transferred on the first local business day.
	 */
	@RosettaEnumValue(value = "FirstLBD", displayName = "First Local Business Day") 
	FIRST_LBD("FirstLBD", "First Local Business Day"),
	
	/**
	 * The cash collateral should be transferred on the second local business day.
	 */
	@RosettaEnumValue(value = "SecondLBD", displayName = "Second Local Business Day") 
	SECOND_LBD("SecondLBD", "Second Local Business Day"),
	
	/**
	 * Exception value.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, CashCTSTimeEnum> values;
	static {
        Map<String, CashCTSTimeEnum> map = new ConcurrentHashMap<>();
		for (CashCTSTimeEnum instance : CashCTSTimeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CashCTSTimeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CashCTSTimeEnum fromDisplayName(String name) {
		CashCTSTimeEnum value = values.get(name);
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
