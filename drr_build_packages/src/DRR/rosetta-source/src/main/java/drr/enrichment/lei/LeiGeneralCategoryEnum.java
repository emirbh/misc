package drr.enrichment.lei;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("LeiGeneralCategoryEnum")
public enum LeiGeneralCategoryEnum {

	@RosettaEnumValue(value = "BRANCH") 
	BRANCH("BRANCH", null),
	
	@RosettaEnumValue(value = "FUND") 
	FUND("FUND", null),
	
	@RosettaEnumValue(value = "SOLE_PROPRIETOR") 
	SOLE_PROPRIETOR("SOLE_PROPRIETOR", null),
	
	@RosettaEnumValue(value = "GENERAL") 
	GENERAL("GENERAL", null),
	
	@RosettaEnumValue(value = "RESIDENT_GOVERNMENT_ENTITY") 
	RESIDENT_GOVERNMENT_ENTITY("RESIDENT_GOVERNMENT_ENTITY", null),
	
	@RosettaEnumValue(value = "INTERNATIONAL_ORGANIZATION") 
	INTERNATIONAL_ORGANIZATION("INTERNATIONAL_ORGANIZATION", null)
;
	private static Map<String, LeiGeneralCategoryEnum> values;
	static {
        Map<String, LeiGeneralCategoryEnum> map = new ConcurrentHashMap<>();
		for (LeiGeneralCategoryEnum instance : LeiGeneralCategoryEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LeiGeneralCategoryEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LeiGeneralCategoryEnum fromDisplayName(String name) {
		LeiGeneralCategoryEnum value = values.get(name);
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
