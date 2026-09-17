package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details of the consent requirements (if any) for Substitution.
 * @version 6.23.0
 */
@RosettaEnum("LegacyConsentEnum")
public enum LegacyConsentEnum {

	/**
	 * Consent is required for Substitution.
	 */
	@RosettaEnumValue(value = "ConsentRequired") 
	CONSENT_REQUIRED("ConsentRequired", null),
	
	/**
	 * No consent is required for Substitution.
	 */
	@RosettaEnumValue(value = "NoConsent") 
	NO_CONSENT("NoConsent", null),
	
	/**
	 * Consent is required, with no unreasonable delay, for Substitution.
	 */
	@RosettaEnumValue(value = "ConsentRequiredNoDelay") 
	CONSENT_REQUIRED_NO_DELAY("ConsentRequiredNoDelay", null),
	
	/**
	 * Times adjusted.
	 */
	@RosettaEnumValue(value = "TimesAdjusted") 
	TIMES_ADJUSTED("TimesAdjusted", null),
	
	/**
	 * Notice conditions apply for Substitution.
	 */
	@RosettaEnumValue(value = "NoticeConditions") 
	NOTICE_CONDITIONS("NoticeConditions", null),
	
	/**
	 * Costs apportioned for Substitution.
	 */
	@RosettaEnumValue(value = "CostsApportioned") 
	COSTS_APPORTIONED("CostsApportioned", null)
;
	private static Map<String, LegacyConsentEnum> values;
	static {
        Map<String, LegacyConsentEnum> map = new ConcurrentHashMap<>();
		for (LegacyConsentEnum instance : LegacyConsentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegacyConsentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegacyConsentEnum fromDisplayName(String name) {
		LegacyConsentEnum value = values.get(name);
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
