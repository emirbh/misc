package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbOptionTypeEnum")
public enum AnnaDsbOptionTypeEnum {

	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to buy specified assets (product)
	 */
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to buy (call) or sell (put) specified assets (product); The buyer does not have to decide whether the contract will be a put or a call until an agreed future date, prior to expiration
	 */
	@RosettaEnumValue(value = "OPTL") 
	OPTL("OPTL", null),
	
	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to sell specified assets (product)
	 */
	@RosettaEnumValue(value = "PUTO") 
	PUTO("PUTO", null)
;
	private static Map<String, AnnaDsbOptionTypeEnum> values;
	static {
        Map<String, AnnaDsbOptionTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbOptionTypeEnum instance : AnnaDsbOptionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbOptionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbOptionTypeEnum fromDisplayName(String name) {
		AnnaDsbOptionTypeEnum value = values.get(name);
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
