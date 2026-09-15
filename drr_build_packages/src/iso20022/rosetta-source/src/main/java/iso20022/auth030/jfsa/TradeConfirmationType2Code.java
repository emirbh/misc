package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("TradeConfirmationType2Code")
public enum TradeConfirmationType2Code {

	@RosettaEnumValue(value = "NCNF") 
	NCNF("NCNF", null)
;
	private static Map<String, TradeConfirmationType2Code> values;
	static {
        Map<String, TradeConfirmationType2Code> map = new ConcurrentHashMap<>();
		for (TradeConfirmationType2Code instance : TradeConfirmationType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradeConfirmationType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradeConfirmationType2Code fromDisplayName(String name) {
		TradeConfirmationType2Code value = values.get(name);
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
