package iso20022.auth030.mas;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ValuationType1Code")
public enum ValuationType1Code {

	@RosettaEnumValue(value = "CCPV") 
	CCPV("CCPV", null),
	
	@RosettaEnumValue(value = "MTMA") 
	MTMA("MTMA", null),
	
	@RosettaEnumValue(value = "MTMO") 
	MTMO("MTMO", null)
;
	private static Map<String, ValuationType1Code> values;
	static {
        Map<String, ValuationType1Code> map = new ConcurrentHashMap<>();
		for (ValuationType1Code instance : ValuationType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationType1Code fromDisplayName(String name) {
		ValuationType1Code value = values.get(name);
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
