package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the effective date of the Amendment to Termination Currency when specified as a specific date (e.g. the annex date).
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(t)"
 *
 * Provision 
 *
 */
@RosettaEnum("AmendmentEffectiveDateEnum")
public enum AmendmentEffectiveDateEnum {

	/**
	 * The effective date corresponds to the Annex date.
	 */
	@RosettaEnumValue(value = "AnnexDate") 
	ANNEX_DATE("AnnexDate", null),
	
	/**
	 * The effective date corresponds to the Deed date.
	 */
	@RosettaEnumValue(value = "DeedDate") 
	DEED_DATE("DeedDate", null),
	
	/**
	 * The effective date corresponds to the Agreement date.
	 */
	@RosettaEnumValue(value = "AgreementDate") 
	AGREEMENT_DATE("AgreementDate", null),
	
	/**
	 * The effective date corresponds to the Amendment Effective Date (IM).
	 */
	@RosettaEnumValue(value = "AmendmentEffectiveDate") 
	AMENDMENT_EFFECTIVE_DATE("AmendmentEffectiveDate", null)
;
	private static Map<String, AmendmentEffectiveDateEnum> values;
	static {
        Map<String, AmendmentEffectiveDateEnum> map = new ConcurrentHashMap<>();
		for (AmendmentEffectiveDateEnum instance : AmendmentEffectiveDateEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AmendmentEffectiveDateEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AmendmentEffectiveDateEnum fromDisplayName(String name) {
		AmendmentEffectiveDateEnum value = values.get(name);
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
