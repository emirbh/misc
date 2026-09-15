package iso20022.auth030.mas;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("InterestComputationMethod4Code")
public enum InterestComputationMethod4Code {

	@RosettaEnumValue(value = "A004") 
	A004("A004", null),
	
	@RosettaEnumValue(value = "A019") 
	A019("A019", null),
	
	@RosettaEnumValue(value = "A017") 
	A017("A017", null),
	
	@RosettaEnumValue(value = "A005") 
	A005("A005", null),
	
	@RosettaEnumValue(value = "A009") 
	A009("A009", null),
	
	@RosettaEnumValue(value = "A014") 
	A014("A014", null),
	
	@RosettaEnumValue(value = "A010") 
	A010("A010", null),
	
	@RosettaEnumValue(value = "A006") 
	A006("A006", null),
	
	@RosettaEnumValue(value = "A008") 
	A008("A008", null),
	
	@RosettaEnumValue(value = "A015") 
	A015("A015", null),
	
	@RosettaEnumValue(value = "A018") 
	A018("A018", null),
	
	@RosettaEnumValue(value = "A011") 
	A011("A011", null),
	
	@RosettaEnumValue(value = "A001") 
	A001("A001", null),
	
	@RosettaEnumValue(value = "A002") 
	A002("A002", null),
	
	@RosettaEnumValue(value = "A003") 
	A003("A003", null),
	
	@RosettaEnumValue(value = "A012") 
	A012("A012", null),
	
	@RosettaEnumValue(value = "A013") 
	A013("A013", null),
	
	@RosettaEnumValue(value = "A007") 
	A007("A007", null),
	
	@RosettaEnumValue(value = "A016") 
	A016("A016", null),
	
	@RosettaEnumValue(value = "NARR") 
	NARR("NARR", null),
	
	@RosettaEnumValue(value = "A020") 
	A020("A020", null)
;
	private static Map<String, InterestComputationMethod4Code> values;
	static {
        Map<String, InterestComputationMethod4Code> map = new ConcurrentHashMap<>();
		for (InterestComputationMethod4Code instance : InterestComputationMethod4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InterestComputationMethod4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InterestComputationMethod4Code fromDisplayName(String name) {
		InterestComputationMethod4Code value = values.get(name);
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
