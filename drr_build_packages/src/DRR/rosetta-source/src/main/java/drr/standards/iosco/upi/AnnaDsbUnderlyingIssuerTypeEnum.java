package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlyingIssuerTypeEnum")
public enum AnnaDsbUnderlyingIssuerTypeEnum {

	@RosettaEnumValue(value = "Corporate", displayName = "Corporate") 
	CORPORATE("Corporate", "Corporate"),
	
	@RosettaEnumValue(value = "Local", displayName = "Local") 
	LOCAL("Local", "Local"),
	
	@RosettaEnumValue(value = "Sovereign", displayName = "Sovereign") 
	SOVEREIGN("Sovereign", "Sovereign")
;
	private static Map<String, AnnaDsbUnderlyingIssuerTypeEnum> values;
	static {
        Map<String, AnnaDsbUnderlyingIssuerTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlyingIssuerTypeEnum instance : AnnaDsbUnderlyingIssuerTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlyingIssuerTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlyingIssuerTypeEnum fromDisplayName(String name) {
		AnnaDsbUnderlyingIssuerTypeEnum value = values.get(name);
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
