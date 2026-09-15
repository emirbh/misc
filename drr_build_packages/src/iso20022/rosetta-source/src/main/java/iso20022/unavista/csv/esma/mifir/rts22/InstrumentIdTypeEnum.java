package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of instrument ID reported in field 41. Required to generate ISO20022
 * @version ${project.version}
 */
@RosettaEnum("InstrumentIdTypeEnum")
public enum InstrumentIdTypeEnum {

	/**
	 * Specifies the attributes of the financial instrument (ISIN).
	 */
	@RosettaEnumValue(value = "Fininstr_id", displayName = "Fininstr.id") 
	FININSTR_ID("Fininstr_id", "Fininstr.id"),
	
	/**
	 * Identifies the security instrument by its name and typical characteristics.
	 */
	@RosettaEnumValue(value = "Fininstr_Othr", displayName = "Fininstr.Othr") 
	FININSTR_OTHR("Fininstr_Othr", "Fininstr.Othr")
;
	private static Map<String, InstrumentIdTypeEnum> values;
	static {
        Map<String, InstrumentIdTypeEnum> map = new ConcurrentHashMap<>();
		for (InstrumentIdTypeEnum instance : InstrumentIdTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InstrumentIdTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InstrumentIdTypeEnum fromDisplayName(String name) {
		InstrumentIdTypeEnum value = values.get(name);
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
