package drr.enrichment.lei;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("LeiCategoryEnum")
public enum LeiCategoryEnum {

	@RosettaEnumValue(value = "Branch") 
	BRANCH("Branch", null),
	
	@RosettaEnumValue(value = "Fund") 
	FUND("Fund", null),
	
	@RosettaEnumValue(value = "SoleProprietor") 
	SOLE_PROPRIETOR("SoleProprietor", null),
	
	@RosettaEnumValue(value = "General") 
	GENERAL("General", null),
	
	@RosettaEnumValue(value = "ResidentGovernmentEntity") 
	RESIDENT_GOVERNMENT_ENTITY("ResidentGovernmentEntity", null),
	
	@RosettaEnumValue(value = "InternationalOrganization") 
	INTERNATIONAL_ORGANIZATION("InternationalOrganization", null)
;
	private static Map<String, LeiCategoryEnum> values;
	static {
        Map<String, LeiCategoryEnum> map = new ConcurrentHashMap<>();
		for (LeiCategoryEnum instance : LeiCategoryEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LeiCategoryEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LeiCategoryEnum fromDisplayName(String name) {
		LeiCategoryEnum value = values.get(name);
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
