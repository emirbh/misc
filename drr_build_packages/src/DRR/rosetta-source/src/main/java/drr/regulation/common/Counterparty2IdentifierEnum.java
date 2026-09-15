package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("Counterparty2IdentifierEnum")
public enum Counterparty2IdentifierEnum {

	/**
	 * Natural Person Identifier
	 */
	@RosettaEnumValue(value = "NPID") 
	NPID("NPID", null),
	
	/**
	 * Legal Entity Identifier
	 */
	@RosettaEnumValue(value = "LEID") 
	LEID("LEID", null),
	
	@RosettaEnumValue(value = "PLID") 
	PLID("PLID", null)
;
	private static Map<String, Counterparty2IdentifierEnum> values;
	static {
        Map<String, Counterparty2IdentifierEnum> map = new ConcurrentHashMap<>();
		for (Counterparty2IdentifierEnum instance : Counterparty2IdentifierEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Counterparty2IdentifierEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Counterparty2IdentifierEnum fromDisplayName(String name) {
		Counterparty2IdentifierEnum value = values.get(name);
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
