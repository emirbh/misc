package iso20022.auth108.asic;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("CollateralisationType3Code__1")
public enum CollateralisationType3Code__1 {

	@RosettaEnumValue(value = "FLCL") 
	FLCL("FLCL", null),
	
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
	private static Map<String, CollateralisationType3Code__1> values;
	static {
        Map<String, CollateralisationType3Code__1> map = new ConcurrentHashMap<>();
		for (CollateralisationType3Code__1 instance : CollateralisationType3Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralisationType3Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralisationType3Code__1 fromDisplayName(String name) {
		CollateralisationType3Code__1 value = values.get(name);
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
