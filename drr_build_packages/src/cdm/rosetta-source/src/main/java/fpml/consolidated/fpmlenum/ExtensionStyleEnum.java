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
 * Provision Specifies a Repo or Security Lending arangement: Everdeen or Extendible.
 *
 */
@RosettaEnum("ExtensionStyleEnum")
public enum ExtensionStyleEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Evergreen is a Repo or Security Lending arangement to close the Evergreen. This takes place by negotiation.
	 *
	 */
	@RosettaEnumValue(value = "Evergreen") 
	EVERGREEN("Evergreen", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Extendable ia a Repo or Security Lending arangement to extend the Extendable. This takes place by negotiation.
	 *
	 */
	@RosettaEnumValue(value = "Extendable") 
	EXTENDABLE("Extendable", null)
;
	private static Map<String, ExtensionStyleEnum> values;
	static {
        Map<String, ExtensionStyleEnum> map = new ConcurrentHashMap<>();
		for (ExtensionStyleEnum instance : ExtensionStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExtensionStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExtensionStyleEnum fromDisplayName(String name) {
		ExtensionStyleEnum value = values.get(name);
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
