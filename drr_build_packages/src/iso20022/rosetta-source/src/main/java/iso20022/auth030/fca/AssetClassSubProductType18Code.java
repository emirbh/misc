package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Plastic.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType18Code")
public enum AssetClassSubProductType18Code {

	/**
	 * Commodity of type plastic.
	 */
	@RosettaEnumValue(value = "PLST") 
	PLST("PLST", null)
;
	private static Map<String, AssetClassSubProductType18Code> values;
	static {
        Map<String, AssetClassSubProductType18Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType18Code instance : AssetClassSubProductType18Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType18Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType18Code fromDisplayName(String name) {
		AssetClassSubProductType18Code value = values.get(name);
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
