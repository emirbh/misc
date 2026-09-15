package drr.regulation.common.trade.party;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("NatureOfCounterpartyEnum")
public enum NatureOfCounterpartyEnum {

	/**
	 * Financial
	 */
	@RosettaEnumValue(value = "F") 
	F("F", null),
	
	/**
	 * NonFinancial
	 */
	@RosettaEnumValue(value = "N") 
	N("N", null),
	
	/**
	 * CentralCounterparty
	 */
	@RosettaEnumValue(value = "C") 
	C("C", null),
	
	/**
	 * Exempt
	 */
	@RosettaEnumValue(value = "O") 
	O("O", null)
;
	private static Map<String, NatureOfCounterpartyEnum> values;
	static {
        Map<String, NatureOfCounterpartyEnum> map = new ConcurrentHashMap<>();
		for (NatureOfCounterpartyEnum instance : NatureOfCounterpartyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NatureOfCounterpartyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NatureOfCounterpartyEnum fromDisplayName(String name) {
		NatureOfCounterpartyEnum value = values.get(name);
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
