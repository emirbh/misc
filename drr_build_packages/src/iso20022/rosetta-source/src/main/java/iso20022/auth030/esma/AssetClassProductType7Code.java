package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Metal.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType7Code")
public enum AssetClassProductType7Code {

	/**
	 * Commodity of type metal.
	 */
	@RosettaEnumValue(value = "METL") 
	METL("METL", null)
;
	private static Map<String, AssetClassProductType7Code> values;
	static {
        Map<String, AssetClassProductType7Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType7Code instance : AssetClassProductType7Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType7Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType7Code fromDisplayName(String name) {
		AssetClassProductType7Code value = values.get(name);
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
