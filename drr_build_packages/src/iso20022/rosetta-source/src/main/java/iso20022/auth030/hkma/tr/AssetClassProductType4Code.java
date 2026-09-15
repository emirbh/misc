package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Freight.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType4Code")
public enum AssetClassProductType4Code {

	/**
	 * Commodity of type freight.
	 */
	@RosettaEnumValue(value = "FRGT") 
	FRGT("FRGT", null)
;
	private static Map<String, AssetClassProductType4Code> values;
	static {
        Map<String, AssetClassProductType4Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType4Code instance : AssetClassProductType4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType4Code fromDisplayName(String name) {
		AssetClassProductType4Code value = values.get(name);
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
