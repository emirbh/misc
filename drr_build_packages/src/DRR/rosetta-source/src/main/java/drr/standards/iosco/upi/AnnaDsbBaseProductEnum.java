package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbBaseProductEnum")
public enum AnnaDsbBaseProductEnum {

	@RosettaEnumValue(value = "AGRI") 
	AGRI("AGRI", null),
	
	@RosettaEnumValue(value = "ENVR") 
	ENVR("ENVR", null),
	
	@RosettaEnumValue(value = "FRGT") 
	FRGT("FRGT", null),
	
	@RosettaEnumValue(value = "FRTL") 
	FRTL("FRTL", null),
	
	@RosettaEnumValue(value = "INDP") 
	INDP("INDP", null),
	
	@RosettaEnumValue(value = "INFL") 
	INFL("INFL", null),
	
	@RosettaEnumValue(value = "MCEX") 
	MCEX("MCEX", null),
	
	@RosettaEnumValue(value = "METL") 
	METL("METL", null),
	
	@RosettaEnumValue(value = "NRGY") 
	NRGY("NRGY", null),
	
	@RosettaEnumValue(value = "OEST") 
	OEST("OEST", null),
	
	@RosettaEnumValue(value = "OTHC") 
	OTHC("OTHC", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	@RosettaEnumValue(value = "PAPR") 
	PAPR("PAPR", null),
	
	@RosettaEnumValue(value = "POLY") 
	POLY("POLY", null)
;
	private static Map<String, AnnaDsbBaseProductEnum> values;
	static {
        Map<String, AnnaDsbBaseProductEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbBaseProductEnum instance : AnnaDsbBaseProductEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbBaseProductEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbBaseProductEnum fromDisplayName(String name) {
		AnnaDsbBaseProductEnum value = values.get(name);
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
