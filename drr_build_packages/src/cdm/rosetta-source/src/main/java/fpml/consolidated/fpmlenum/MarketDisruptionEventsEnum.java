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
 * Provision The specification of how market disruption events will be represented.
 *
 */
@RosettaEnum("MarketDisruptionEventsEnum")
public enum MarketDisruptionEventsEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Market Disruption Events are applicable.
	 *
	 */
	@RosettaEnumValue(value = "Applicable") 
	APPLICABLE("Applicable", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Market Disruption Events are not applicable.
	 *
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Market Disruption Event(s) are determined by reference to the relevant Master Agreement.
	 *
	 */
	@RosettaEnumValue(value = "AsSpecifiedInMasterAgreement") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AsSpecifiedInMasterAgreement", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Market Disruption Event(s) are determined by reference to the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "AsSpecifiedInConfirmation") 
	AS_SPECIFIED_IN_CONFIRMATION("AsSpecifiedInConfirmation", null)
;
	private static Map<String, MarketDisruptionEventsEnum> values;
	static {
        Map<String, MarketDisruptionEventsEnum> map = new ConcurrentHashMap<>();
		for (MarketDisruptionEventsEnum instance : MarketDisruptionEventsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MarketDisruptionEventsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MarketDisruptionEventsEnum fromDisplayName(String name) {
		MarketDisruptionEventsEnum value = values.get(name);
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
