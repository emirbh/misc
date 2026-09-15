package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlierCharacteristicEnum")
public enum AnnaDsbUnderlierCharacteristicEnum {

	/**
	 * In case the product has multiple underliers
	 */
	@RosettaEnumValue(value = "Basket", displayName = "Basket") 
	BASKET("Basket", "Basket"),
	
	/**
	 * In case the product has single underlier
	 */
	@RosettaEnumValue(value = "Single", displayName = "Single") 
	SINGLE("Single", "Single")
;
	private static Map<String, AnnaDsbUnderlierCharacteristicEnum> values;
	static {
        Map<String, AnnaDsbUnderlierCharacteristicEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlierCharacteristicEnum instance : AnnaDsbUnderlierCharacteristicEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlierCharacteristicEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlierCharacteristicEnum fromDisplayName(String name) {
		AnnaDsbUnderlierCharacteristicEnum value = values.get(name);
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
