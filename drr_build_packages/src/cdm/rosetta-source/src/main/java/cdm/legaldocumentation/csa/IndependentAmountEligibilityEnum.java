package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the instances where the independent amount eligible collateral is not defined as a set of eligible collateral assets.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/independent-amount-eligibility"
 *
 * Provision 
 *
 */
@RosettaEnum("IndependentAmountEligibilityEnum")
public enum IndependentAmountEligibilityEnum {

	/**
	 * None.
	 */
	@RosettaEnumValue(value = "None") 
	NONE("None", null),
	
	/**
	 * None, unless otherwise specified in a Confirmation.
	 */
	@RosettaEnumValue(value = "NoneUnlessSpecifiedInConfirmation") 
	NONE_UNLESS_SPECIFIED_IN_CONFIRMATION("NoneUnlessSpecifiedInConfirmation", null)
;
	private static Map<String, IndependentAmountEligibilityEnum> values;
	static {
        Map<String, IndependentAmountEligibilityEnum> map = new ConcurrentHashMap<>();
		for (IndependentAmountEligibilityEnum instance : IndependentAmountEligibilityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	IndependentAmountEligibilityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static IndependentAmountEligibilityEnum fromDisplayName(String name) {
		IndependentAmountEligibilityEnum value = values.get(name);
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
