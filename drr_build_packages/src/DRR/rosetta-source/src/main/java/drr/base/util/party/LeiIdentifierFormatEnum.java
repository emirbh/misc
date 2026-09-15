package drr.base.util.party;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("LeiIdentifierFormatEnum")
public enum LeiIdentifierFormatEnum {

	@RosettaEnumValue(value = "Lei") 
	LEI("Lei", null),
	
	@RosettaEnumValue(value = "LeiAndPerson") 
	LEI_AND_PERSON("LeiAndPerson", null)
;
	private static Map<String, LeiIdentifierFormatEnum> values;
	static {
        Map<String, LeiIdentifierFormatEnum> map = new ConcurrentHashMap<>();
		for (LeiIdentifierFormatEnum instance : LeiIdentifierFormatEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LeiIdentifierFormatEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LeiIdentifierFormatEnum fromDisplayName(String name) {
		LeiIdentifierFormatEnum value = values.get(name);
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
