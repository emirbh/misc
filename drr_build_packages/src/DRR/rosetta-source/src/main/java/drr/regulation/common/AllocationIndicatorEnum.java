package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AllocationIndicatorEnum")
public enum AllocationIndicatorEnum {

	/**
	 * An indication that the transaction is the result of an allocation
	 */
	@RosettaEnumValue(value = "POST") 
	POST("POST", null),
	
	/**
	 * An indication that the transaction is to be allocated
	 */
	@RosettaEnumValue(value = "PREA") 
	PREA("PREA", null),
	
	/**
	 * An indication that the transaction is not a post-allocated transaction and/or is not to be allocated
	 */
	@RosettaEnumValue(value = "UNAL") 
	UNAL("UNAL", null)
;
	private static Map<String, AllocationIndicatorEnum> values;
	static {
        Map<String, AllocationIndicatorEnum> map = new ConcurrentHashMap<>();
		for (AllocationIndicatorEnum instance : AllocationIndicatorEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AllocationIndicatorEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AllocationIndicatorEnum fromDisplayName(String name) {
		AllocationIndicatorEnum value = values.get(name);
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
