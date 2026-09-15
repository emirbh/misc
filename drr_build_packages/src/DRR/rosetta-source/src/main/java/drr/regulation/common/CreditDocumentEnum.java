package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies arrangements being made to provide credit.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/credit-document"
 *
 * Provision 
 *
 */
@RosettaEnum("CreditDocumentEnum")
public enum CreditDocumentEnum {

	/**
	 */
	@RosettaEnumValue(value = "CreditSupportAgreement") 
	CREDIT_SUPPORT_AGREEMENT("CreditSupportAgreement", null),
	
	/**
	 */
	@RosettaEnumValue(value = "Guaranty") 
	GUARANTY("Guaranty", null),
	
	/**
	 */
	@RosettaEnumValue(value = "OtherFinancing") 
	OTHER_FINANCING("OtherFinancing", null),
	
	/**
	 */
	@RosettaEnumValue(value = "PledgeOfCollateral") 
	PLEDGE_OF_COLLATERAL("PledgeOfCollateral", null),
	
	/**
	 */
	@RosettaEnumValue(value = "RelianceOnAvailableFinancing") 
	RELIANCE_ON_AVAILABLE_FINANCING("RelianceOnAvailableFinancing", null)
;
	private static Map<String, CreditDocumentEnum> values;
	static {
        Map<String, CreditDocumentEnum> map = new ConcurrentHashMap<>();
		for (CreditDocumentEnum instance : CreditDocumentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CreditDocumentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CreditDocumentEnum fromDisplayName(String name) {
		CreditDocumentEnum value = values.get(name);
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
