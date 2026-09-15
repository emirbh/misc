package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies whether it is a call option (right to purchase a specific underlying asset) or a put option (right to sell a specific underlying asset) or any other type of option.
 * @version ${project.version}
 */
@RosettaEnum("OptionType2Code")
public enum OptionType2Code {

	/**
	 * Right to buy a quantity of an asset for an agreed price at exercise date.
	 */
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	/**
	 * Right to sell a quantity of an asset for an agreed price at exercise date.
	 */
	@RosettaEnumValue(value = "PUTO") 
	PUTO("PUTO", null),
	
	/**
	 * Right where the holder of the option decides whether the option is put or call.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, OptionType2Code> values;
	static {
        Map<String, OptionType2Code> map = new ConcurrentHashMap<>();
		for (OptionType2Code instance : OptionType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionType2Code fromDisplayName(String name) {
		OptionType2Code value = values.get(name);
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
