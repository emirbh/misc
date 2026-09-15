package drr.enrichment.lei;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("LeiRegistrationStatusEnum")
public enum LeiRegistrationStatusEnum {

	@RosettaEnumValue(value = "Issued") 
	ISSUED("Issued", null),
	
	@RosettaEnumValue(value = "Lapsed") 
	LAPSED("Lapsed", null),
	
	@RosettaEnumValue(value = "Annulled") 
	ANNULLED("Annulled", null),
	
	@RosettaEnumValue(value = "PendingTransfer") 
	PENDING_TRANSFER("PendingTransfer", null),
	
	@RosettaEnumValue(value = "PendingArchival") 
	PENDING_ARCHIVAL("PendingArchival", null),
	
	@RosettaEnumValue(value = "Duplicate") 
	DUPLICATE("Duplicate", null),
	
	@RosettaEnumValue(value = "Retired") 
	RETIRED("Retired", null),
	
	@RosettaEnumValue(value = "Merged") 
	MERGED("Merged", null)
;
	private static Map<String, LeiRegistrationStatusEnum> values;
	static {
        Map<String, LeiRegistrationStatusEnum> map = new ConcurrentHashMap<>();
		for (LeiRegistrationStatusEnum instance : LeiRegistrationStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LeiRegistrationStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LeiRegistrationStatusEnum fromDisplayName(String name) {
		LeiRegistrationStatusEnum value = values.get(name);
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
