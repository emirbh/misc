package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("TradeConfirmationType1Code")
public enum TradeConfirmationType1Code {

	@RosettaEnumValue(value = "ECNF") 
	ECNF("ECNF", null),
	
	@RosettaEnumValue(value = "YCNF") 
	YCNF("YCNF", null)
;
	private static Map<String, TradeConfirmationType1Code> values;
	static {
        Map<String, TradeConfirmationType1Code> map = new ConcurrentHashMap<>();
		for (TradeConfirmationType1Code instance : TradeConfirmationType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradeConfirmationType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradeConfirmationType1Code fromDisplayName(String name) {
		TradeConfirmationType1Code value = values.get(name);
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
