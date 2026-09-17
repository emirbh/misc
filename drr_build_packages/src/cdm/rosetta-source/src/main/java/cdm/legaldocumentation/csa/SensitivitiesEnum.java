package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the methodology according to which sensitivities to (i) equity indices, funds and ETFs, and (ii) commodity indices are computed.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(gg)(2)"
 *
 * Provision 
 *
 */
@RosettaEnum("SensitivitiesEnum")
public enum SensitivitiesEnum {

	/**
	 * The parties agree that in respect of the relevant sensitivities, the delta is allocated back to individual constituents.
	 */
	@RosettaEnumValue(value = "Alternative") 
	ALTERNATIVE("Alternative", null),
	
	/**
	 * The relevant sensitivities are addressed by the standard preferred approach where the entire delta is put into the applicable asset class/category.
	 */
	@RosettaEnumValue(value = "Standard") 
	STANDARD("Standard", null)
;
	private static Map<String, SensitivitiesEnum> values;
	static {
        Map<String, SensitivitiesEnum> map = new ConcurrentHashMap<>();
		for (SensitivitiesEnum instance : SensitivitiesEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SensitivitiesEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SensitivitiesEnum fromDisplayName(String name) {
		SensitivitiesEnum value = values.get(name);
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
