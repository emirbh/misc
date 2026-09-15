package fpml.consolidated.fpmlenum;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Upon the occurrence of an Abandonment of Scheme, as defined in clause (h)(iv) of the Emissions Annex, one of the following elections, the specific terms of which are set forth in clause (b)(iii) of the Emissions Annex, will govern the parties’ rights and obligations with respect to this Emissions Transaction. If none of the above options is selected, Option A(1) will apply.
 *
 */
@RosettaEnum("EnvironmentalAbandonmentOfSchemeEnum")
public enum EnvironmentalAbandonmentOfSchemeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Abandonment of Scheme constitutes an Additional Termination Event.
	 *
	 */
	@RosettaEnumValue(value = "OptionA_1", displayName = "OptionA(1)") 
	OPTION_A_1("OptionA_1", "OptionA(1)"),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Abandonment of Scheme entails no further obligations.
	 *
	 */
	@RosettaEnumValue(value = "OptionA_2", displayName = "OptionA(2)") 
	OPTION_A_2("OptionA_2", "OptionA(2)"),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The applicability of Abandonment of Scheme to Emissions Transactions is set forth in the applicable Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "OptionB") 
	OPTION_B("OptionB", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The applicability of Abandonment of Scheme does not apply.
	 *
	 */
	@RosettaEnumValue(value = "OptionC") 
	OPTION_C("OptionC", null)
;
	private static Map<String, EnvironmentalAbandonmentOfSchemeEnum> values;
	static {
        Map<String, EnvironmentalAbandonmentOfSchemeEnum> map = new ConcurrentHashMap<>();
		for (EnvironmentalAbandonmentOfSchemeEnum instance : EnvironmentalAbandonmentOfSchemeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnvironmentalAbandonmentOfSchemeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnvironmentalAbandonmentOfSchemeEnum fromDisplayName(String name) {
		EnvironmentalAbandonmentOfSchemeEnum value = values.get(name);
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
