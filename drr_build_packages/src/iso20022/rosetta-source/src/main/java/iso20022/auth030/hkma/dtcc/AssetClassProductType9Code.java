package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Polypropylene.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType9Code")
public enum AssetClassProductType9Code {

	/**
	 * Commodity of type polypropylene.
	 */
	@RosettaEnumValue(value = "POLY") 
	POLY("POLY", null)
;
	private static Map<String, AssetClassProductType9Code> values;
	static {
        Map<String, AssetClassProductType9Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType9Code instance : AssetClassProductType9Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType9Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType9Code fromDisplayName(String name) {
		AssetClassProductType9Code value = values.get(name);
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
