package drr.regulation.common.trade.underlier;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("UnderlyingIdentificationTypeEnum")
public enum UnderlyingIdentificationTypeEnum {

	/**
	 * ISIN
	 */
	@RosettaEnumValue(value = "I") 
	I("I", null),
	
	/**
	 * Basket
	 */
	@RosettaEnumValue(value = "B") 
	B("B", null),
	
	/**
	 * Index
	 */
	@RosettaEnumValue(value = "X") 
	X("X", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "O") 
	O("O", null)
;
	private static Map<String, UnderlyingIdentificationTypeEnum> values;
	static {
        Map<String, UnderlyingIdentificationTypeEnum> map = new ConcurrentHashMap<>();
		for (UnderlyingIdentificationTypeEnum instance : UnderlyingIdentificationTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	UnderlyingIdentificationTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static UnderlyingIdentificationTypeEnum fromDisplayName(String name) {
		UnderlyingIdentificationTypeEnum value = values.get(name);
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
