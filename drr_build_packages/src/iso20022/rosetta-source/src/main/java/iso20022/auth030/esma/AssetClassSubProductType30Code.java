package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Weather.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType30Code")
public enum AssetClassSubProductType30Code {

	/**
	 * Commodity of type weather.
	 */
	@RosettaEnumValue(value = "WTHR") 
	WTHR("WTHR", null)
;
	private static Map<String, AssetClassSubProductType30Code> values;
	static {
        Map<String, AssetClassSubProductType30Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType30Code instance : AssetClassSubProductType30Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType30Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType30Code fromDisplayName(String name) {
		AssetClassSubProductType30Code value = values.get(name);
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
