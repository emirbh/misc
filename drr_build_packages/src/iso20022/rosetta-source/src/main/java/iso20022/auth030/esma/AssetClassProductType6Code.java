package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Industrial Product.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType6Code")
public enum AssetClassProductType6Code {

	/**
	 * Commodity of type industrial product.
	 */
	@RosettaEnumValue(value = "INDP") 
	INDP("INDP", null)
;
	private static Map<String, AssetClassProductType6Code> values;
	static {
        Map<String, AssetClassProductType6Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType6Code instance : AssetClassProductType6Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType6Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType6Code fromDisplayName(String name) {
		AssetClassProductType6Code value = values.get(name);
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
