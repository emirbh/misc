package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Precious.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType11Code")
public enum AssetClassDetailedSubProductType11Code {

	/**
	 * Commodity attribute of type gold.
	 */
	@RosettaEnumValue(value = "GOLD") 
	GOLD("GOLD", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Commodity attribute of type palladium.
	 */
	@RosettaEnumValue(value = "PLDM") 
	PLDM("PLDM", null),
	
	/**
	 * Commodity attribute of type platinum.
	 */
	@RosettaEnumValue(value = "PTNM") 
	PTNM("PTNM", null),
	
	/**
	 * Commodity attribute of type silver.
	 */
	@RosettaEnumValue(value = "SLVR") 
	SLVR("SLVR", null)
;
	private static Map<String, AssetClassDetailedSubProductType11Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType11Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType11Code instance : AssetClassDetailedSubProductType11Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType11Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType11Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType11Code value = values.get(name);
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
