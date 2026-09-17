package cdm.legaldocumentation.transaction.additionalterms;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify whether such terms i.e. Force Majeure or Act Of State shall be treated either as defined per the documents applicable to the FX transaction.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(c).(ii)"
 *
 * Provision 
 *
 */
@RosettaEnum("FxForceMajeureOrActOfSStateEnum")
public enum FxForceMajeureOrActOfSStateEnum {

	@RosettaEnumValue(value = "ToBeTreatedAsDisruptionEvent") 
	TO_BE_TREATED_AS_DISRUPTION_EVENT("ToBeTreatedAsDisruptionEvent", null),
	
	@RosettaEnumValue(value = "ToBeTreatedAsForceMajeureOrActOfSState") 
	TO_BE_TREATED_AS_FORCE_MAJEURE_OR_ACT_OF_S_STATE("ToBeTreatedAsForceMajeureOrActOfSState", null)
;
	private static Map<String, FxForceMajeureOrActOfSStateEnum> values;
	static {
        Map<String, FxForceMajeureOrActOfSStateEnum> map = new ConcurrentHashMap<>();
		for (FxForceMajeureOrActOfSStateEnum instance : FxForceMajeureOrActOfSStateEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxForceMajeureOrActOfSStateEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxForceMajeureOrActOfSStateEnum fromDisplayName(String name) {
		FxForceMajeureOrActOfSStateEnum value = values.get(name);
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
