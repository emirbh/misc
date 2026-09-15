package drr.base.util.party;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("PartyIdentifierFormat2Enum")
public enum PartyIdentifierFormat2Enum {

	@RosettaEnumValue(value = "Lei") 
	LEI("Lei", null),
	
	@RosettaEnumValue(value = "LeiAndPerson") 
	LEI_AND_PERSON("LeiAndPerson", null),
	
	@RosettaEnumValue(value = "NaturalPerson") 
	NATURAL_PERSON("NaturalPerson", null),
	
	@RosettaEnumValue(value = "SWIFTBIC") 
	SWIFTBIC("SWIFTBIC", null),
	
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, PartyIdentifierFormat2Enum> values;
	static {
        Map<String, PartyIdentifierFormat2Enum> map = new ConcurrentHashMap<>();
		for (PartyIdentifierFormat2Enum instance : PartyIdentifierFormat2Enum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PartyIdentifierFormat2Enum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PartyIdentifierFormat2Enum fromDisplayName(String name) {
		PartyIdentifierFormat2Enum value = values.get(name);
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
