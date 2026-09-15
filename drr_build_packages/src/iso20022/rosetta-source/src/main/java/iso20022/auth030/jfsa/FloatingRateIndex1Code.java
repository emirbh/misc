package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FloatingRateIndex1Code")
public enum FloatingRateIndex1Code {

	@RosettaEnumValue(value = "BBSW") 
	BBSW("BBSW", null),
	
	@RosettaEnumValue(value = "BCOL") 
	BCOL("BCOL", null),
	
	@RosettaEnumValue(value = "BJUO") 
	BJUO("BJUO", null),
	
	@RosettaEnumValue(value = "BUBO") 
	BUBO("BUBO", null),
	
	@RosettaEnumValue(value = "CDOR") 
	CDOR("CDOR", null),
	
	@RosettaEnumValue(value = "CIBO") 
	CIBO("CIBO", null),
	
	@RosettaEnumValue(value = "CORA") 
	CORA("CORA", null),
	
	@RosettaEnumValue(value = "CZNA") 
	CZNA("CZNA", null),
	
	@RosettaEnumValue(value = "EFFR") 
	EFFR("EFFR", null),
	
	@RosettaEnumValue(value = "EONA") 
	EONA("EONA", null),
	
	@RosettaEnumValue(value = "EONS") 
	EONS("EONS", null),
	
	@RosettaEnumValue(value = "ESTR") 
	ESTR("ESTR", null),
	
	@RosettaEnumValue(value = "ETIO") 
	ETIO("ETIO", null),
	
	@RosettaEnumValue(value = "EUCH") 
	EUCH("EUCH", null),
	
	@RosettaEnumValue(value = "EURI") 
	EURI("EURI", null),
	
	@RosettaEnumValue(value = "EUUS") 
	EUUS("EUUS", null),
	
	@RosettaEnumValue(value = "FUSW") 
	FUSW("FUSW", null),
	
	@RosettaEnumValue(value = "GCFR") 
	GCFR("GCFR", null),
	
	@RosettaEnumValue(value = "HKIO") 
	HKIO("HKIO", null),
	
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	@RosettaEnumValue(value = "JIBA") 
	JIBA("JIBA", null),
	
	@RosettaEnumValue(value = "LIBI") 
	LIBI("LIBI", null),
	
	@RosettaEnumValue(value = "LIBO") 
	LIBO("LIBO", null),
	
	@RosettaEnumValue(value = "MAAA") 
	MAAA("MAAA", null),
	
	@RosettaEnumValue(value = "MOSP") 
	MOSP("MOSP", null),
	
	@RosettaEnumValue(value = "NIBO") 
	NIBO("NIBO", null),
	
	@RosettaEnumValue(value = "OBFR") 
	OBFR("OBFR", null),
	
	@RosettaEnumValue(value = "PFAN") 
	PFAN("PFAN", null),
	
	@RosettaEnumValue(value = "PRBO") 
	PRBO("PRBO", null),
	
	@RosettaEnumValue(value = "RCTR") 
	RCTR("RCTR", null),
	
	@RosettaEnumValue(value = "SIBO") 
	SIBO("SIBO", null),
	
	@RosettaEnumValue(value = "SOFR") 
	SOFR("SOFR", null),
	
	@RosettaEnumValue(value = "SONA") 
	SONA("SONA", null),
	
	@RosettaEnumValue(value = "SORA") 
	SORA("SORA", null),
	
	@RosettaEnumValue(value = "SSOR") 
	SSOR("SSOR", null),
	
	@RosettaEnumValue(value = "STBO") 
	STBO("STBO", null),
	
	@RosettaEnumValue(value = "SWAP") 
	SWAP("SWAP", null),
	
	@RosettaEnumValue(value = "TIBO") 
	TIBO("TIBO", null),
	
	@RosettaEnumValue(value = "TLBO") 
	TLBO("TLBO", null),
	
	@RosettaEnumValue(value = "TONA") 
	TONA("TONA", null),
	
	@RosettaEnumValue(value = "TORF") 
	TORF("TORF", null),
	
	@RosettaEnumValue(value = "TREA") 
	TREA("TREA", null),
	
	@RosettaEnumValue(value = "WIBO") 
	WIBO("WIBO", null)
;
	private static Map<String, FloatingRateIndex1Code> values;
	static {
        Map<String, FloatingRateIndex1Code> map = new ConcurrentHashMap<>();
		for (FloatingRateIndex1Code instance : FloatingRateIndex1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FloatingRateIndex1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FloatingRateIndex1Code fromDisplayName(String name) {
		FloatingRateIndex1Code value = values.get(name);
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
