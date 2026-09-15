package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indicator of a type of a post trade risk reduction operation for the purpose of reporting.
 * @version ${project.version}
 */
@RosettaEnum("RiskReductionService1Code__1")
public enum RiskReductionService1Code__1 {

	/**
	 * Portfolio Compression without a third-party service provider.
	 */
	@RosettaEnumValue(value = "PWOS") 
	PWOS("PWOS", null),
	
	/**
	 * Other portfolio compression.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Portfolio rebalancing or margin management.
	 */
	@RosettaEnumValue(value = "PRBM") 
	PRBM("PRBM", null),
	
	/**
	 * Portfolio Compression with a third-party service provider or CCP.
	 */
	@RosettaEnumValue(value = "PWAS") 
	PWAS("PWAS", null)
;
	private static Map<String, RiskReductionService1Code__1> values;
	static {
        Map<String, RiskReductionService1Code__1> map = new ConcurrentHashMap<>();
		for (RiskReductionService1Code__1 instance : RiskReductionService1Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RiskReductionService1Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RiskReductionService1Code__1 fromDisplayName(String name) {
		RiskReductionService1Code__1 value = values.get(name);
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
