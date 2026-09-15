package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ReferenceEntityFormatEnum")
public enum ReferenceEntityFormatEnum {

	/**
	 * Legal Entity Identifier
	 */
	@RosettaEnumValue(value = "LEI") 
	LEI("LEI", null),
	
	@RosettaEnumValue(value = "Country") 
	COUNTRY("Country", null),
	
	@RosettaEnumValue(value = "CountrySubdivision") 
	COUNTRY_SUBDIVISION("CountrySubdivision", null)
;
	private static Map<String, ReferenceEntityFormatEnum> values;
	static {
        Map<String, ReferenceEntityFormatEnum> map = new ConcurrentHashMap<>();
		for (ReferenceEntityFormatEnum instance : ReferenceEntityFormatEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReferenceEntityFormatEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReferenceEntityFormatEnum fromDisplayName(String name) {
		ReferenceEntityFormatEnum value = values.get(name);
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
