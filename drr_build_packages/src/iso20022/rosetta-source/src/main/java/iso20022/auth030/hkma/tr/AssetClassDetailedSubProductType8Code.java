package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Emissions.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType8Code")
public enum AssetClassDetailedSubProductType8Code {

	/**
	 * Commodity attribute of type emissions allowance CER (Certified Emission Reduction).
	 */
	@RosettaEnumValue(value = "CERE") 
	CERE("CERE", null),
	
	/**
	 * Commodity attribute of type emissions allowance ERU (European Reduction Unit).
	 */
	@RosettaEnumValue(value = "ERUE") 
	ERUE("ERUE", null),
	
	/**
	 * Commodity attribute of type emissions allowance EUA (European Union Allowance).
	 */
	@RosettaEnumValue(value = "EUAE") 
	EUAE("EUAE", null),
	
	/**
	 * Commodity attribute of type emissions allowance EUAA (European Union Aviation Allowance).
	 */
	@RosettaEnumValue(value = "EUAA") 
	EUAA("EUAA", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType8Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType8Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType8Code instance : AssetClassDetailedSubProductType8Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType8Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType8Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType8Code value = values.get(name);
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
