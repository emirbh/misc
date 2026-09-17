package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the procedure under which the market value of posted collateral will be recalculated.
 * @version 6.23.0
 */
@RosettaEnum("RecalculationOfValueElectionEnum")
public enum RecalculationOfValueElectionEnum {

	/**
	 * The parties agree to consult.
	 */
	@RosettaEnumValue(value = "ConsulationProcedure") 
	CONSULATION_PROCEDURE("ConsulationProcedure", null),
	
	/**
	 * The procedures specified in an Other Regulatory CSA.
	 */
	@RosettaEnumValue(value = "OtherRegulatoryCSAProcedure") 
	OTHER_REGULATORY_CSA_PROCEDURE("OtherRegulatoryCSAProcedure", null),
	
	/**
	 * Description to be added.
	 */
	@RosettaEnumValue(value = "NotApplicable") 
	NOT_APPLICABLE("NotApplicable", null),
	
	/**
	 * Bespoke Recalculation of value terms are specified in the agreement.
	 */
	@RosettaEnumValue(value = "Specified") 
	SPECIFIED("Specified", null)
;
	private static Map<String, RecalculationOfValueElectionEnum> values;
	static {
        Map<String, RecalculationOfValueElectionEnum> map = new ConcurrentHashMap<>();
		for (RecalculationOfValueElectionEnum instance : RecalculationOfValueElectionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RecalculationOfValueElectionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RecalculationOfValueElectionEnum fromDisplayName(String name) {
		RecalculationOfValueElectionEnum value = values.get(name);
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
