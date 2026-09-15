package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbOptionExerciseStyleEnum")
public enum AnnaDsbOptionExerciseStyleEnum {

	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to buy (call) or sell (put) specified assets (product) at a fixed price at any time during the term of the put option, up to and including the expiration date of the contract
	 */
	@RosettaEnumValue(value = "AMER") 
	AMER("AMER", null),
	
	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to buy (call) or sell (put) specified assets (product) at a fixed price on a number of specific dates within the exercise period of the contract
	 */
	@RosettaEnumValue(value = "BERM") 
	BERM("BERM", null),
	
	/**
	 * An option on a contract which allows its holder (buyer) to exercise the right to buy (call) or sell (put) specified assets (product) at a fixed price, only on the contract&#39;s expiration date
	 */
	@RosettaEnumValue(value = "EURO") 
	EURO("EURO", null)
;
	private static Map<String, AnnaDsbOptionExerciseStyleEnum> values;
	static {
        Map<String, AnnaDsbOptionExerciseStyleEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbOptionExerciseStyleEnum instance : AnnaDsbOptionExerciseStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbOptionExerciseStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbOptionExerciseStyleEnum fromDisplayName(String name) {
		AnnaDsbOptionExerciseStyleEnum value = values.get(name);
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
