package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Livestock.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType22Code")
public enum AssetClassSubProductType22Code {

	/**
	 * Commodity of type livestock.
	 */
	@RosettaEnumValue(value = "LSTK") 
	LSTK("LSTK", null)
;
	private static Map<String, AssetClassSubProductType22Code> values;
	static {
        Map<String, AssetClassSubProductType22Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType22Code instance : AssetClassSubProductType22Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType22Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType22Code fromDisplayName(String name) {
		AssetClassSubProductType22Code value = values.get(name);
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
