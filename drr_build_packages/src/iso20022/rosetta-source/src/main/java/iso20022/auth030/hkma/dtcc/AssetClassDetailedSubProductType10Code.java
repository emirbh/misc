package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Non-Precious.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType10Code")
public enum AssetClassDetailedSubProductType10Code {

	/**
	 * Commodity attribute of type aluminium.
	 */
	@RosettaEnumValue(value = "ALUM") 
	ALUM("ALUM", null),
	
	/**
	 * Commodity attribute of type aluminium alloy.
	 */
	@RosettaEnumValue(value = "ALUA") 
	ALUA("ALUA", null),
	
	/**
	 * Commodity attribute of type cobalt.
	 */
	@RosettaEnumValue(value = "CBLT") 
	CBLT("CBLT", null),
	
	/**
	 * Commodity attribute of type copper.
	 */
	@RosettaEnumValue(value = "COPR") 
	COPR("COPR", null),
	
	/**
	 * Commodity attribute of type iron ore.
	 */
	@RosettaEnumValue(value = "IRON") 
	IRON("IRON", null),
	
	/**
	 * Commodity attribute of type molybdenum.
	 */
	@RosettaEnumValue(value = "MOLY") 
	MOLY("MOLY", null),
	
	/**
	 * Commodity attribute of type NASAAC (North American Special Aluminum Alloy Contract).
	 */
	@RosettaEnumValue(value = "NASC") 
	NASC("NASC", null),
	
	/**
	 * Commodity attribute of type nickel.
	 */
	@RosettaEnumValue(value = "NICK") 
	NICK("NICK", null),
	
	/**
	 * Commodity attribute of type steel.
	 */
	@RosettaEnumValue(value = "STEL") 
	STEL("STEL", null),
	
	/**
	 * Commodity attribute of type tin.
	 */
	@RosettaEnumValue(value = "TINN") 
	TINN("TINN", null),
	
	/**
	 * Commodity attribute of type zinc.
	 */
	@RosettaEnumValue(value = "ZINC") 
	ZINC("ZINC", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Commodity attribute of type lead.
	 */
	@RosettaEnumValue(value = "LEAD") 
	LEAD("LEAD", null)
;
	private static Map<String, AssetClassDetailedSubProductType10Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType10Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType10Code instance : AssetClassDetailedSubProductType10Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType10Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType10Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType10Code value = values.get(name);
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
