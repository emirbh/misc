package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(b)(B)"
 *
 * Provision 
 *
 */
@RosettaEnum("AdditionalTypeEnum")
public enum AdditionalTypeEnum {

	/**
	 * No Additional Type of transaction is applicable to the regulatory regulatory regime.
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 * Single stock equity option or index option transaction as referred to in the transitional provisions (if any) of the EMIR RTS.
	 */
	@RosettaEnumValue(value = "EquityOptionOrIndexOption") 
	EQUITY_OPTION_OR_INDEX_OPTION("EquityOptionOrIndexOption", null),
	
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, AdditionalTypeEnum> values;
	static {
        Map<String, AdditionalTypeEnum> map = new ConcurrentHashMap<>();
		for (AdditionalTypeEnum instance : AdditionalTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AdditionalTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AdditionalTypeEnum fromDisplayName(String name) {
		AdditionalTypeEnum value = values.get(name);
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
