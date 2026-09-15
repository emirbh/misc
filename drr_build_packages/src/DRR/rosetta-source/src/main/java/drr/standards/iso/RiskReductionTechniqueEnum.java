package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("RiskReductionTechniqueEnum")
public enum RiskReductionTechniqueEnum {

	@RosettaEnumValue(value = "PWAS") 
	PWAS("PWAS", null),
	
	@RosettaEnumValue(value = "PWOS") 
	PWOS("PWOS", null),
	
	@RosettaEnumValue(value = "PRBM") 
	PRBM("PRBM", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, RiskReductionTechniqueEnum> values;
	static {
        Map<String, RiskReductionTechniqueEnum> map = new ConcurrentHashMap<>();
		for (RiskReductionTechniqueEnum instance : RiskReductionTechniqueEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RiskReductionTechniqueEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RiskReductionTechniqueEnum fromDisplayName(String name) {
		RiskReductionTechniqueEnum value = values.get(name);
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
