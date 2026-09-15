package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the entity classification of a party under the U.S. Securities and Exchange Commission (SEC).
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/sec-entity-classification"
 *
 * Provision 
 *
 */
@RosettaEnum("SECEntityClassificationEnum")
public enum SECEntityClassificationEnum {

	/**
	 * Indicates the organization with respect to the reporting Regime is a Clearing Agency, for example under SEC. CA under SEC has the same meaning as CentralCounterparty under ESMA.
	 */
	@RosettaEnumValue(value = "CA") 
	CA("CA", null),
	
	/**
	 * Indicates the organization with respect to the reporting Regime is a Major Security-based Swap Participant, for example under SEC SBSR.
	 */
	@RosettaEnumValue(value = "MSBSP") 
	MSBSP("MSBSP", null),
	
	/**
	 * Indicates the organization with respect to the reporting Regime is neither a Security-based Swap Dealer nor a Major Security-based Swap Participant, for example under SEC SBSR.
	 */
	@RosettaEnumValue(value = "non_SBSD_MSBSP", displayName = "non-SBSD/MSBSP") 
	NON_SBSD_MSBSP("non_SBSD_MSBSP", "non-SBSD/MSBSP"),
	
	/**
	 * Indicates an organization with respect to the reporting Regime is a participant.
	 */
	@RosettaEnumValue(value = "Participant") 
	PARTICIPANT("Participant", null),
	
	/**
	 * Indicates the organization with respect to the reporting Regime is Security-based Swap Dealer, for example under SEC SBSR.
	 */
	@RosettaEnumValue(value = "SBSD") 
	SBSD("SBSD", null)
;
	private static Map<String, SECEntityClassificationEnum> values;
	static {
        Map<String, SECEntityClassificationEnum> map = new ConcurrentHashMap<>();
		for (SECEntityClassificationEnum instance : SECEntityClassificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SECEntityClassificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SECEntityClassificationEnum fromDisplayName(String name) {
		SECEntityClassificationEnum value = values.get(name);
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
