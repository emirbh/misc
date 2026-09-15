package drr.base.trade.price;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("DefaultingType")
public enum DefaultingType {

	@RosettaEnumValue(value = "DefaultPercentagetoDecimal") 
	DEFAULT_PERCENTAGETO_DECIMAL("DefaultPercentagetoDecimal", null),
	
	@RosettaEnumValue(value = "DefaultBasistoPercentage") 
	DEFAULT_BASISTO_PERCENTAGE("DefaultBasistoPercentage", null)
;
	private static Map<String, DefaultingType> values;
	static {
        Map<String, DefaultingType> map = new ConcurrentHashMap<>();
		for (DefaultingType instance : DefaultingType.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DefaultingType(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DefaultingType fromDisplayName(String name) {
		DefaultingType value = values.get(name);
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
