package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies if a trade party is a taker or a maker.
 * @version ${project.version}
 */
@RosettaEnum("OptionParty3Code")
public enum OptionParty3Code {

	/**
	 * Indicates the receiver of the trade.
	 */
	@RosettaEnumValue(value = "MAKE") 
	MAKE("MAKE", null),
	
	/**
	 * Indicates the initiator of the trade.
	 */
	@RosettaEnumValue(value = "TAKE") 
	TAKE("TAKE", null)
;
	private static Map<String, OptionParty3Code> values;
	static {
        Map<String, OptionParty3Code> map = new ConcurrentHashMap<>();
		for (OptionParty3Code instance : OptionParty3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionParty3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionParty3Code fromDisplayName(String name) {
		OptionParty3Code value = values.get(name);
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
