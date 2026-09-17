package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the SIMM normalized exception approaches.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2018 ISDA 2018 Credit Support Annex For Initial Margin  
 * paragraph "13 General Principles"
 *
 * Provision 
 *
 */
@RosettaEnum("SimmExceptionApplicableEnum")
public enum SimmExceptionApplicableEnum {

	/**
	 * The ISDA Standard Initial Margin Model exception is applicable as a Fallback to Mandatory Method.
	 */
	@RosettaEnumValue(value = "FallBackToMandatoryMethod") 
	FALL_BACK_TO_MANDATORY_METHOD("FallBackToMandatoryMethod", null),
	
	/**
	 * The ISDA Standard Initial Margin Model exception is applicable as a Mandatory Method.
	 */
	@RosettaEnumValue(value = "MandatoryMethod") 
	MANDATORY_METHOD("MandatoryMethod", null),
	
	/**
	 * An alternative approach is described in the document.
	 */
	@RosettaEnumValue(value = "OtherMethod") 
	OTHER_METHOD("OtherMethod", null)
;
	private static Map<String, SimmExceptionApplicableEnum> values;
	static {
        Map<String, SimmExceptionApplicableEnum> map = new ConcurrentHashMap<>();
		for (SimmExceptionApplicableEnum instance : SimmExceptionApplicableEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SimmExceptionApplicableEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SimmExceptionApplicableEnum fromDisplayName(String name) {
		SimmExceptionApplicableEnum value = values.get(name);
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
