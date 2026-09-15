package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Grain.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType30Code")
public enum AssetClassDetailedSubProductType30Code {

	/**
	 * Commodity attribute of type milled wheat.
	 */
	@RosettaEnumValue(value = "MWHT") 
	MWHT("MWHT", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType30Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType30Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType30Code instance : AssetClassDetailedSubProductType30Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType30Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType30Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType30Code value = values.get(name);
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
