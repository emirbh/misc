package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies the type of Id used for DecisionMakerIdType
 * @version ${project.version}
 */
@RosettaEnum("InvestmnentDecisionIdTypeEnum")
public enum InvestmnentDecisionIdTypeEnum {

	/**
	 * Algorithms
	 */
	@RosettaEnumValue(value = "A") 
	A("A", null),
	
	/**
	 * National ID
	 */
	@RosettaEnumValue(value = "N") 
	N("N", null),
	
	/**
	 * Data to be populated by the confidential data table
	 */
	@RosettaEnumValue(value = "T") 
	T("T", null)
;
	private static Map<String, InvestmnentDecisionIdTypeEnum> values;
	static {
        Map<String, InvestmnentDecisionIdTypeEnum> map = new ConcurrentHashMap<>();
		for (InvestmnentDecisionIdTypeEnum instance : InvestmnentDecisionIdTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InvestmnentDecisionIdTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InvestmnentDecisionIdTypeEnum fromDisplayName(String name) {
		InvestmnentDecisionIdTypeEnum value = values.get(name);
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
