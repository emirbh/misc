package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbOtherUnderlierIDSourceEnum")
public enum AnnaDsbOtherUnderlierIDSourceEnum {

	/**
	 * CCY
	 */
	@RosettaEnumValue(value = "CCY") 
	CCY("CCY", null),
	
	/**
	 * Commodity Reference Price
	 */
	@RosettaEnumValue(value = "COMM") 
	COMM("COMM", null)
;
	private static Map<String, AnnaDsbOtherUnderlierIDSourceEnum> values;
	static {
        Map<String, AnnaDsbOtherUnderlierIDSourceEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbOtherUnderlierIDSourceEnum instance : AnnaDsbOtherUnderlierIDSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbOtherUnderlierIDSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbOtherUnderlierIDSourceEnum fromDisplayName(String name) {
		AnnaDsbOtherUnderlierIDSourceEnum value = values.get(name);
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
