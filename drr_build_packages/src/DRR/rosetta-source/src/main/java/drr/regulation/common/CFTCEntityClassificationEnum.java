package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the entity classification of a party under the CFTC.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/organization-type"
 *
 * Provision 
 *
 */
@RosettaEnum("CFTCEntityClassificationEnum")
public enum CFTCEntityClassificationEnum {

	/**
	 * A significant participant in the swaps market, for example as defined by the Dodd-Frank Act.
	 */
	@RosettaEnumValue(value = "MSP") 
	MSP("MSP", null),
	
	/**
	 * A human being.
	 */
	@RosettaEnumValue(value = "NaturalPerson") 
	NATURAL_PERSON("NaturalPerson", null),
	
	/**
	 * A firm that is neither a swap dealer nor a major swaps participant under the Dodd-Frank Act.
	 */
	@RosettaEnumValue(value = "non_SD_MSP", displayName = "non-SD/MSP") 
	NON_SD_MSP("non_SD_MSP", "non-SD/MSP"),
	
	/**
	 * Registered swap dealer.
	 */
	@RosettaEnumValue(value = "SD") 
	SD("SD", null)
;
	private static Map<String, CFTCEntityClassificationEnum> values;
	static {
        Map<String, CFTCEntityClassificationEnum> map = new ConcurrentHashMap<>();
		for (CFTCEntityClassificationEnum instance : CFTCEntityClassificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CFTCEntityClassificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CFTCEntityClassificationEnum fromDisplayName(String name) {
		CFTCEntityClassificationEnum value = values.get(name);
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
