package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies the unit type used for quantity
 * @version ${project.version}
 */
@RosettaEnum("QuantityTypeEnum")
public enum QuantityTypeEnum {

	@RosettaEnumValue(value = "Unit") 
	UNIT("Unit", null),
	
	@RosettaEnumValue(value = "NominalValue") 
	NOMINAL_VALUE("NominalValue", null),
	
	@RosettaEnumValue(value = "MonetaryValue") 
	MONETARY_VALUE("MonetaryValue", null)
;
	private static Map<String, QuantityTypeEnum> values;
	static {
        Map<String, QuantityTypeEnum> map = new ConcurrentHashMap<>();
		for (QuantityTypeEnum instance : QuantityTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuantityTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuantityTypeEnum fromDisplayName(String name) {
		QuantityTypeEnum value = values.get(name);
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
