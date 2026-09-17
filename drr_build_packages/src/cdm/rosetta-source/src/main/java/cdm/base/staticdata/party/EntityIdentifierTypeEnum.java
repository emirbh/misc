package cdm.base.staticdata.party;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumeration values associated with legal entity identifier sources.
 * @version 6.23.0
 */
@RosettaEnum("EntityIdentifierTypeEnum")
public enum EntityIdentifierTypeEnum {

	/**
	 * The Bank Identifier Code.
	 */
	@RosettaEnumValue(value = "BIC") 
	BIC("BIC", null),
	
	/**
	 * The ISO 17442:2012 Legal Entity Identifier.
	 */
	@RosettaEnumValue(value = "LEI") 
	LEI("LEI", null),
	
	/**
	 * The ISO 10383 Market Identifier Code (MIC).
	 */
	@RosettaEnumValue(value = "MIC") 
	MIC("MIC", null),
	
	/**
	 * The Reference Entity Database identifier.
	 */
	@RosettaEnumValue(value = "REDID") 
	REDID("REDID", null),
	
	/**
	 * The ISO 3166 Country Code.
	 */
	@RosettaEnumValue(value = "CountryCode") 
	COUNTRY_CODE("CountryCode", null),
	
	/**
	 * Used when the identifier type is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, EntityIdentifierTypeEnum> values;
	static {
        Map<String, EntityIdentifierTypeEnum> map = new ConcurrentHashMap<>();
		for (EntityIdentifierTypeEnum instance : EntityIdentifierTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EntityIdentifierTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EntityIdentifierTypeEnum fromDisplayName(String name) {
		EntityIdentifierTypeEnum value = values.get(name);
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
