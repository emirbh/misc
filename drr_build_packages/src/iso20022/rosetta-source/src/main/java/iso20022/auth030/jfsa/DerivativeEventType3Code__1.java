package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("DerivativeEventType3Code__1")
public enum DerivativeEventType3Code__1 {

	@RosettaEnumValue(value = "ALOC") 
	ALOC("ALOC", null),
	
	@RosettaEnumValue(value = "CLRG") 
	CLRG("CLRG", null),
	
	@RosettaEnumValue(value = "CLAL") 
	CLAL("CLAL", null),
	
	@RosettaEnumValue(value = "COMP") 
	COMP("COMP", null),
	
	@RosettaEnumValue(value = "CORP") 
	CORP("CORP", null),
	
	@RosettaEnumValue(value = "CREV") 
	CREV("CREV", null),
	
	@RosettaEnumValue(value = "ETRM") 
	ETRM("ETRM", null),
	
	@RosettaEnumValue(value = "EXER") 
	EXER("EXER", null),
	
	@RosettaEnumValue(value = "NOVA") 
	NOVA("NOVA", null),
	
	@RosettaEnumValue(value = "PTNG") 
	PTNG("PTNG", null),
	
	@RosettaEnumValue(value = "TRAD") 
	TRAD("TRAD", null),
	
	@RosettaEnumValue(value = "UPDT") 
	UPDT("UPDT", null)
;
	private static Map<String, DerivativeEventType3Code__1> values;
	static {
        Map<String, DerivativeEventType3Code__1> map = new ConcurrentHashMap<>();
		for (DerivativeEventType3Code__1 instance : DerivativeEventType3Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DerivativeEventType3Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DerivativeEventType3Code__1 fromDisplayName(String name) {
		DerivativeEventType3Code__1 value = values.get(name);
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
