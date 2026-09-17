package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the interest adjustment periodicity election through standard language.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)"
 *
 * Provision 
 *
 */
@RosettaEnum("InterestAdjustmentPeriodicityEnum")
public enum InterestAdjustmentPeriodicityEnum {

	/**
	 * The interest adjustment takes place on the last local business day of each calendar month.
	 */
	@RosettaEnumValue(value = "LastLocalBusinessDayOfMonth") 
	LAST_LOCAL_BUSINESS_DAY_OF_MONTH("LastLocalBusinessDayOfMonth", null),
	
	/**
	 * The interest adjustment takes place each day.
	 */
	@RosettaEnumValue(value = "EachDay") 
	EACH_DAY("EachDay", null)
;
	private static Map<String, InterestAdjustmentPeriodicityEnum> values;
	static {
        Map<String, InterestAdjustmentPeriodicityEnum> map = new ConcurrentHashMap<>();
		for (InterestAdjustmentPeriodicityEnum instance : InterestAdjustmentPeriodicityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterestAdjustmentPeriodicityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterestAdjustmentPeriodicityEnum fromDisplayName(String name) {
		InterestAdjustmentPeriodicityEnum value = values.get(name);
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
