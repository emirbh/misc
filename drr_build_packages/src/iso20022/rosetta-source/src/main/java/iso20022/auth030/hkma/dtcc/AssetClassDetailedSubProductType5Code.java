package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Electricity.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType5Code")
public enum AssetClassDetailedSubProductType5Code {

	/**
	 * Commodity attribute of type base load.
	 */
	@RosettaEnumValue(value = "BSLD") 
	BSLD("BSLD", null),
	
	/**
	 * Commodity attribute of type financial transmission rights.
	 */
	@RosettaEnumValue(value = "FITR") 
	FITR("FITR", null),
	
	/**
	 * Commodity attribute of type peak load.
	 */
	@RosettaEnumValue(value = "PKLD") 
	PKLD("PKLD", null),
	
	/**
	 * Commodity attribute of type off-peak.
	 */
	@RosettaEnumValue(value = "OFFP") 
	OFFP("OFFP", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType5Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType5Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType5Code instance : AssetClassDetailedSubProductType5Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType5Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType5Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType5Code value = values.get(name);
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
