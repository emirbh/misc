package iso20022.auth030.mas;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("Frequency19Code")
public enum Frequency19Code {

	@RosettaEnumValue(value = "DAIL") 
	DAIL("DAIL", null),
	
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null),
	
	@RosettaEnumValue(value = "ADHO") 
	ADHO("ADHO", null),
	
	@RosettaEnumValue(value = "EXPI") 
	EXPI("EXPI", null),
	
	@RosettaEnumValue(value = "MIAN") 
	MIAN("MIAN", null),
	
	@RosettaEnumValue(value = "QURT") 
	QURT("QURT", null),
	
	@RosettaEnumValue(value = "HOUL") 
	HOUL("HOUL", null),
	
	@RosettaEnumValue(value = "ODMD") 
	ODMD("ODMD", null)
;
	private static Map<String, Frequency19Code> values;
	static {
        Map<String, Frequency19Code> map = new ConcurrentHashMap<>();
		for (Frequency19Code instance : Frequency19Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Frequency19Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Frequency19Code fromDisplayName(String name) {
		Frequency19Code value = values.get(name);
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
