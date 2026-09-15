package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Seafood.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType23Code")
public enum AssetClassSubProductType23Code {

	/**
	 * Commodity of type seafood.
	 */
	@RosettaEnumValue(value = "SEAF") 
	SEAF("SEAF", null)
;
	private static Map<String, AssetClassSubProductType23Code> values;
	static {
        Map<String, AssetClassSubProductType23Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType23Code instance : AssetClassSubProductType23Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType23Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType23Code fromDisplayName(String name) {
		AssetClassSubProductType23Code value = values.get(name);
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
