package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication as to whether the transaction is settled physically or in cash.
 * @version ${project.version}
 */
@RosettaEnum("DeliveryTypeEnum")
public enum DeliveryTypeEnum {

	/**
	 * physicaly settled
	 */
	@RosettaEnumValue(value = "PHYS") 
	PHYS("PHYS", null),
	
	/**
	 * cash settled
	 */
	@RosettaEnumValue(value = "CASH") 
	CASH("CASH", null),
	
	/**
	 * optional for party or when determined by third party
	 */
	@RosettaEnumValue(value = "OPTL") 
	OPTL("OPTL", null)
;
	private static Map<String, DeliveryTypeEnum> values;
	static {
        Map<String, DeliveryTypeEnum> map = new ConcurrentHashMap<>();
		for (DeliveryTypeEnum instance : DeliveryTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DeliveryTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DeliveryTypeEnum fromDisplayName(String name) {
		DeliveryTypeEnum value = values.get(name);
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
