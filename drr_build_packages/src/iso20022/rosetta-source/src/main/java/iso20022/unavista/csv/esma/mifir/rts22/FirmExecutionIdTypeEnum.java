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
@RosettaEnum("FirmExecutionIdTypeEnum")
public enum FirmExecutionIdTypeEnum {

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
	T("T", null),
	
	/**
	 * client
	 */
	@RosettaEnumValue(value = "C") 
	C("C", null)
;
	private static Map<String, FirmExecutionIdTypeEnum> values;
	static {
        Map<String, FirmExecutionIdTypeEnum> map = new ConcurrentHashMap<>();
		for (FirmExecutionIdTypeEnum instance : FirmExecutionIdTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FirmExecutionIdTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FirmExecutionIdTypeEnum fromDisplayName(String name) {
		FirmExecutionIdTypeEnum value = values.get(name);
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
