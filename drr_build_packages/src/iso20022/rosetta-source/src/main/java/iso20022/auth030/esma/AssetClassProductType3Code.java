package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Environmental.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType3Code")
public enum AssetClassProductType3Code {

	/**
	 * Commodity of type environmental.
	 */
	@RosettaEnumValue(value = "ENVR") 
	ENVR("ENVR", null)
;
	private static Map<String, AssetClassProductType3Code> values;
	static {
        Map<String, AssetClassProductType3Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType3Code instance : AssetClassProductType3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType3Code fromDisplayName(String name) {
		AssetClassProductType3Code value = values.get(name);
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
