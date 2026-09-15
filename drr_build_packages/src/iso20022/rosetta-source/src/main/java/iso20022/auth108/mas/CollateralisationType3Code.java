package iso20022.auth108.mas;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CollateralisationType3Code")
public enum CollateralisationType3Code {

	@RosettaEnumValue(value = "FLCL") 
	FLCL("FLCL", null),
	
	@RosettaEnumValue(value = "OWCL") 
	OWCL("OWCL", null),
	
	@RosettaEnumValue(value = "OWC1") 
	OWC1("OWC1", null),
	
	@RosettaEnumValue(value = "OWC2") 
	OWC2("OWC2", null),
	
	@RosettaEnumValue(value = "OWP1") 
	OWP1("OWP1", null),
	
	@RosettaEnumValue(value = "OWP2") 
	OWP2("OWP2", null),
	
	@RosettaEnumValue(value = "PRCL") 
	PRCL("PRCL", null),
	
	@RosettaEnumValue(value = "PRC1") 
	PRC1("PRC1", null),
	
	@RosettaEnumValue(value = "PRC2") 
	PRC2("PRC2", null),
	
	@RosettaEnumValue(value = "UNCL") 
	UNCL("UNCL", null)
;
	private static Map<String, CollateralisationType3Code> values;
	static {
        Map<String, CollateralisationType3Code> map = new ConcurrentHashMap<>();
		for (CollateralisationType3Code instance : CollateralisationType3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralisationType3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralisationType3Code fromDisplayName(String name) {
		CollateralisationType3Code value = values.get(name);
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
