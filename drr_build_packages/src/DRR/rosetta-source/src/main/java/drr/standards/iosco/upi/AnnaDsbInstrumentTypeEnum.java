package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbInstrumentTypeEnum")
public enum AnnaDsbInstrumentTypeEnum {

	@RosettaEnumValue(value = "Forward", displayName = "Forward") 
	FORWARD("Forward", "Forward"),
	
	@RosettaEnumValue(value = "Option", displayName = "Option") 
	OPTION("Option", "Option"),
	
	@RosettaEnumValue(value = "Other", displayName = "Other") 
	OTHER("Other", "Other"),
	
	@RosettaEnumValue(value = "Swap", displayName = "Swap") 
	SWAP("Swap", "Swap")
;
	private static Map<String, AnnaDsbInstrumentTypeEnum> values;
	static {
        Map<String, AnnaDsbInstrumentTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbInstrumentTypeEnum instance : AnnaDsbInstrumentTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbInstrumentTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbInstrumentTypeEnum fromDisplayName(String name) {
		AnnaDsbInstrumentTypeEnum value = values.get(name);
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
