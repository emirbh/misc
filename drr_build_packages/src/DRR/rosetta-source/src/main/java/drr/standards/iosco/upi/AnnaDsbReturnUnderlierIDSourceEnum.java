package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbReturnUnderlierIDSourceEnum")
public enum AnnaDsbReturnUnderlierIDSourceEnum {

	@RosettaEnumValue(value = "CUSIP") 
	CUSIP("CUSIP", null),
	
	@RosettaEnumValue(value = "FIGI") 
	FIGI("FIGI", null),
	
	@RosettaEnumValue(value = "RIC") 
	RIC("RIC", null),
	
	@RosettaEnumValue(value = "SEDOL") 
	SEDOL("SEDOL", null)
;
	private static Map<String, AnnaDsbReturnUnderlierIDSourceEnum> values;
	static {
        Map<String, AnnaDsbReturnUnderlierIDSourceEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbReturnUnderlierIDSourceEnum instance : AnnaDsbReturnUnderlierIDSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbReturnUnderlierIDSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbReturnUnderlierIDSourceEnum fromDisplayName(String name) {
		AnnaDsbReturnUnderlierIDSourceEnum value = values.get(name);
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
