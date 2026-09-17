package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify condition(s) required by a party from the other party to hold its posted collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13 General Principles" * clause "(h)(i)" * name "Eligibility to Hold Posted Collateral (VM); Custodians (VM)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/holding-posted-collateral"
 *
 * Provision 
 *
 */
@RosettaEnum("HoldingPostedCollateralEnum")
public enum HoldingPostedCollateralEnum {

	/**
	 * The custodian is acceptable to the other party to the agreement.
	 */
	@RosettaEnumValue(value = "AcceptableCustodian") 
	ACCEPTABLE_CUSTODIAN("AcceptableCustodian", null)
;
	private static Map<String, HoldingPostedCollateralEnum> values;
	static {
        Map<String, HoldingPostedCollateralEnum> map = new ConcurrentHashMap<>();
		for (HoldingPostedCollateralEnum instance : HoldingPostedCollateralEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	HoldingPostedCollateralEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static HoldingPostedCollateralEnum fromDisplayName(String name) {
		HoldingPostedCollateralEnum value = values.get(name);
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
