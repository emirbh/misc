package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration representing the type of venue where a trade could be executed.
 * @version 7.7.0
 */
@RosettaEnum("MicTypeEnum")
public enum MicTypeEnum {

	/**
	 * indicates whether the MIC is an operating MIC
	 */
	@RosettaEnumValue(value = "OPRT") 
	OPRT("OPRT", null),
	
	/**
	 * indicates whether the MIC is a Market Segment MIC
	 */
	@RosettaEnumValue(value = "SGMT") 
	SGMT("SGMT", null)
;
	private static Map<String, MicTypeEnum> values;
	static {
        Map<String, MicTypeEnum> map = new ConcurrentHashMap<>();
		for (MicTypeEnum instance : MicTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MicTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MicTypeEnum fromDisplayName(String name) {
		MicTypeEnum value = values.get(name);
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
