package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the list of codes applicable to embedded option types.
 * @version ${project.version}
 */
@RosettaEnum("EmbeddedType1Code")
public enum EmbeddedType1Code {

	/**
	 * Option can be cancelled.
	 */
	@RosettaEnumValue(value = "CANC") 
	CANC("CANC", null),
	
	/**
	 * Option can be extended.
	 */
	@RosettaEnumValue(value = "EXTD") 
	EXTD("EXTD", null),
	
	/**
	 * Option can be early terminated.
	 */
	@RosettaEnumValue(value = "OPET") 
	OPET("OPET", null),
	
	/**
	 * Option type is other.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Option must be early terminated.
	 */
	@RosettaEnumValue(value = "MDET") 
	MDET("MDET", null)
;
	private static Map<String, EmbeddedType1Code> values;
	static {
        Map<String, EmbeddedType1Code> map = new ConcurrentHashMap<>();
		for (EmbeddedType1Code instance : EmbeddedType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EmbeddedType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EmbeddedType1Code fromDisplayName(String name) {
		EmbeddedType1Code value = values.get(name);
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
