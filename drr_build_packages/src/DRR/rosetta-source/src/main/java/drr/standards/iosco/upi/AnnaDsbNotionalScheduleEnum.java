package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbNotionalScheduleEnum")
public enum AnnaDsbNotionalScheduleEnum {

	/**
	 * the notional amount increases through the life of the contract
	 */
	@RosettaEnumValue(value = "Accreting", displayName = "Accreting") 
	ACCRETING("Accreting", "Accreting"),
	
	/**
	 * the notional amount decreases through the life of the contract
	 */
	@RosettaEnumValue(value = "Amortizing", displayName = "Amortizing") 
	AMORTIZING("Amortizing", "Amortizing"),
	
	/**
	 * the notional amount is constant through the life of the contract
	 */
	@RosettaEnumValue(value = "Constant", displayName = "Constant") 
	CONSTANT("Constant", "Constant"),
	
	/**
	 * customized notional step schedule
	 */
	@RosettaEnumValue(value = "Custom", displayName = "Custom") 
	CUSTOM("Custom", "Custom")
;
	private static Map<String, AnnaDsbNotionalScheduleEnum> values;
	static {
        Map<String, AnnaDsbNotionalScheduleEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbNotionalScheduleEnum instance : AnnaDsbNotionalScheduleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbNotionalScheduleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbNotionalScheduleEnum fromDisplayName(String name) {
		AnnaDsbNotionalScheduleEnum value = values.get(name);
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
