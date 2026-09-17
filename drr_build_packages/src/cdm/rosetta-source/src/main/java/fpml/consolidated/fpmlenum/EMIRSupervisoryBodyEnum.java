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
 * Provision The list of regulators or other supervisory bodies for EMIR reporting.
 *
 */
@RosettaEnum("EMIRSupervisoryBodyEnum")
public enum EMIRSupervisoryBodyEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "ESMA") 
	ESMA("ESMA", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "UKFCA") 
	UKFCA("UKFCA", null)
;
	private static Map<String, EMIRSupervisoryBodyEnum> values;
	static {
        Map<String, EMIRSupervisoryBodyEnum> map = new ConcurrentHashMap<>();
		for (EMIRSupervisoryBodyEnum instance : EMIRSupervisoryBodyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EMIRSupervisoryBodyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EMIRSupervisoryBodyEnum fromDisplayName(String name) {
		EMIRSupervisoryBodyEnum value = values.get(name);
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
