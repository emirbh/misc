package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type of report activity for a specific reporting period.
 * @version ${project.version}
 */
@RosettaEnum("ReportPeriodActivity1Code")
public enum ReportPeriodActivity1Code {

	/**
	 * No transaction has been identified during the period.
	 */
	@RosettaEnumValue(value = "NOTX") 
	NOTX("NOTX", null)
;
	private static Map<String, ReportPeriodActivity1Code> values;
	static {
        Map<String, ReportPeriodActivity1Code> map = new ConcurrentHashMap<>();
		for (ReportPeriodActivity1Code instance : ReportPeriodActivity1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReportPeriodActivity1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReportPeriodActivity1Code fromDisplayName(String name) {
		ReportPeriodActivity1Code value = values.get(name);
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
