package cdm.legaldocumentation.transaction.additionalterms;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify whether such terms i.e. Illegality or Impossibility shall be treated either as defined per the documents applicable to the FX transaction.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(c).(i)"
 *
 * Provision 
 *
 */
@RosettaEnum("FxIllegalityOrImpossibilityEnum")
public enum FxIllegalityOrImpossibilityEnum {

	@RosettaEnumValue(value = "ToBeTreatedAsDisruptionEvent") 
	TO_BE_TREATED_AS_DISRUPTION_EVENT("ToBeTreatedAsDisruptionEvent", null),
	
	@RosettaEnumValue(value = "ToBeTreatedAsIllegalityOrImpossibility") 
	TO_BE_TREATED_AS_ILLEGALITY_OR_IMPOSSIBILITY("ToBeTreatedAsIllegalityOrImpossibility", null)
;
	private static Map<String, FxIllegalityOrImpossibilityEnum> values;
	static {
        Map<String, FxIllegalityOrImpossibilityEnum> map = new ConcurrentHashMap<>();
		for (FxIllegalityOrImpossibilityEnum instance : FxIllegalityOrImpossibilityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxIllegalityOrImpossibilityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxIllegalityOrImpossibilityEnum fromDisplayName(String name) {
		FxIllegalityOrImpossibilityEnum value = values.get(name);
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
