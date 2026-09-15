package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the categories or characteristics that apply to an organization which allow it to apply for an end-user exception determination.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/organization-characteristic"
 *
 * Provision 
 *
 */
@RosettaEnum("OrganizationCharacteristicEnum")
public enum OrganizationCharacteristicEnum {

	/**
	 */
	@RosettaEnumValue(value = "CaptiveFinanceUnit") 
	CAPTIVE_FINANCE_UNIT("CaptiveFinanceUnit", null),
	
	/**
	 */
	@RosettaEnumValue(value = "FinancialEntity") 
	FINANCIAL_ENTITY("FinancialEntity", null)
;
	private static Map<String, OrganizationCharacteristicEnum> values;
	static {
        Map<String, OrganizationCharacteristicEnum> map = new ConcurrentHashMap<>();
		for (OrganizationCharacteristicEnum instance : OrganizationCharacteristicEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OrganizationCharacteristicEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OrganizationCharacteristicEnum fromDisplayName(String name) {
		OrganizationCharacteristicEnum value = values.get(name);
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
