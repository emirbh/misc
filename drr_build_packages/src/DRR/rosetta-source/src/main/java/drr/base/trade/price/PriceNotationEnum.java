package drr.base.trade.price;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("PriceNotationEnum")
public enum PriceNotationEnum {

	@RosettaEnumValue(value = "Monetary") 
	MONETARY("Monetary", null),
	
	@RosettaEnumValue(value = "Percentage") 
	PERCENTAGE("Percentage", null),
	
	@RosettaEnumValue(value = "Decimal") 
	DECIMAL("Decimal", null),
	
	@RosettaEnumValue(value = "Basis") 
	BASIS("Basis", null)
;
	private static Map<String, PriceNotationEnum> values;
	static {
        Map<String, PriceNotationEnum> map = new ConcurrentHashMap<>();
		for (PriceNotationEnum instance : PriceNotationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PriceNotationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PriceNotationEnum fromDisplayName(String name) {
		PriceNotationEnum value = values.get(name);
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
