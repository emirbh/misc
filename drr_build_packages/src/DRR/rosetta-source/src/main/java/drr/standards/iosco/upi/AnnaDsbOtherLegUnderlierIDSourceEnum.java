package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbOtherLegUnderlierIDSourceEnum")
public enum AnnaDsbOtherLegUnderlierIDSourceEnum {

	/**
	 * FPML
	 */
	@RosettaEnumValue(value = "FPML") 
	FPML("FPML", null)
;
	private static Map<String, AnnaDsbOtherLegUnderlierIDSourceEnum> values;
	static {
        Map<String, AnnaDsbOtherLegUnderlierIDSourceEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbOtherLegUnderlierIDSourceEnum instance : AnnaDsbOtherLegUnderlierIDSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbOtherLegUnderlierIDSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbOtherLegUnderlierIDSourceEnum fromDisplayName(String name) {
		AnnaDsbOtherLegUnderlierIDSourceEnum value = values.get(name);
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
