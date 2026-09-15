package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbStatusEnum")
public enum AnnaDsbStatusEnum {

	/**
	 * The identifier is deleted and no longer active
	 */
	@RosettaEnumValue(value = "Deleted", displayName = "Deleted") 
	DELETED("Deleted", "Deleted"),
	
	/**
	 * The record does not meet the requirements of the product template
	 */
	@RosettaEnumValue(value = "Deprecated", displayName = "Deprecated") 
	DEPRECATED("Deprecated", "Deprecated"),
	
	/**
	 * New record added to the database
	 */
	@RosettaEnumValue(value = "New", displayName = "New") 
	NEW("New", "New"),
	
	/**
	 * One/several of the fields in the record is/are updated
	 */
	@RosettaEnumValue(value = "Updated", displayName = "Updated") 
	UPDATED("Updated", "Updated")
;
	private static Map<String, AnnaDsbStatusEnum> values;
	static {
        Map<String, AnnaDsbStatusEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbStatusEnum instance : AnnaDsbStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbStatusEnum fromDisplayName(String name) {
		AnnaDsbStatusEnum value = values.get(name);
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
