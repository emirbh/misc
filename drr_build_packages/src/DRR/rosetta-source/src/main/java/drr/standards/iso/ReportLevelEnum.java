package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies whether the report is done at the trade or position level.
 * @version 7.7.0
 */
@RosettaEnum("ReportLevelEnum")
public enum ReportLevelEnum {

	/**
	 * Report is at position level.
	 */
	@RosettaEnumValue(value = "PSTN") 
	PSTN("PSTN", null),
	
	/**
	 * Report is at trade level.
	 */
	@RosettaEnumValue(value = "TCTN") 
	TCTN("TCTN", null)
;
	private static Map<String, ReportLevelEnum> values;
	static {
        Map<String, ReportLevelEnum> map = new ConcurrentHashMap<>();
		for (ReportLevelEnum instance : ReportLevelEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReportLevelEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReportLevelEnum fromDisplayName(String name) {
		ReportLevelEnum value = values.get(name);
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
