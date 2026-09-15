package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Dairy.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType20Code")
public enum AssetClassSubProductType20Code {

	/**
	 * Commodity of type dairy.
	 */
	@RosettaEnumValue(value = "DIRY") 
	DIRY("DIRY", null)
;
	private static Map<String, AssetClassSubProductType20Code> values;
	static {
        Map<String, AssetClassSubProductType20Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType20Code instance : AssetClassSubProductType20Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType20Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType20Code fromDisplayName(String name) {
		AssetClassSubProductType20Code value = values.get(name);
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
