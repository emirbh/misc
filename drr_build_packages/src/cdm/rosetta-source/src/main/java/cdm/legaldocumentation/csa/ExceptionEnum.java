package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the normalized exceptions applicable to an Initial Margin CSA.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2018 ISDA 2018 Credit Support Annex For Initial Margin  
 * paragraph "13 General Principles"
 *
 * Provision 
 *
 */
@RosettaEnum("ExceptionEnum")
public enum ExceptionEnum {

	/**
	 * The election is applicable.
	 */
	@RosettaEnumValue(value = "Applicable") 
	APPLICABLE("Applicable", null),
	
	/**
	 * The election is not applicable.
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 * An alternative approach is described in the document as follows.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, ExceptionEnum> values;
	static {
        Map<String, ExceptionEnum> map = new ConcurrentHashMap<>();
		for (ExceptionEnum instance : ExceptionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExceptionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExceptionEnum fromDisplayName(String name) {
		ExceptionEnum value = values.get(name);
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
