package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication as to whether the transaction report is new or a cancellation.
 * @version ${project.version}
 */
@RosettaEnum("ReportStatusEnum")
public enum ReportStatusEnum {

	/**
	 * New transaction report.
	 */
	@RosettaEnumValue(value = "NEWT") 
	NEWT("NEWT", null),
	
	/**
	 * Cancellation of a transaction report.
	 */
	@RosettaEnumValue(value = "CANC") 
	CANC("CANC", null)
;
	private static Map<String, ReportStatusEnum> values;
	static {
        Map<String, ReportStatusEnum> map = new ConcurrentHashMap<>();
		for (ReportStatusEnum instance : ReportStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReportStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReportStatusEnum fromDisplayName(String name) {
		ReportStatusEnum value = values.get(name);
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
