package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the energy delivery profile.
 * @version 7.7.0
 */
@RosettaEnum("EnergyLoadType1Code")
public enum EnergyLoadType1Code {

	/**
	 * Base load.
	 */
	@RosettaEnumValue(value = "BSLD") 
	BSLD("BSLD", null),
	
	/**
	 * Gas day.
	 */
	@RosettaEnumValue(value = "GASD") 
	GASD("GASD", null),
	
	/**
	 * Hour and block hours.
	 */
	@RosettaEnumValue(value = "HABH") 
	HABH("HABH", null),
	
	/**
	 * Off-Peak.
	 */
	@RosettaEnumValue(value = "OFFP") 
	OFFP("OFFP", null),
	
	/**
	 * Other.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Peak load.
	 */
	@RosettaEnumValue(value = "PKLD") 
	PKLD("PKLD", null),
	
	/**
	 * Shaped.
	 */
	@RosettaEnumValue(value = "SHPD") 
	SHPD("SHPD", null)
;
	private static Map<String, EnergyLoadType1Code> values;
	static {
        Map<String, EnergyLoadType1Code> map = new ConcurrentHashMap<>();
		for (EnergyLoadType1Code instance : EnergyLoadType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnergyLoadType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnergyLoadType1Code fromDisplayName(String name) {
		EnergyLoadType1Code value = values.get(name);
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
