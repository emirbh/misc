package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Potash.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType41Code")
public enum AssetClassSubProductType41Code {

	/**
	 * Commodity of type potash.
	 */
	@RosettaEnumValue(value = "PTSH") 
	PTSH("PTSH", null)
;
	private static Map<String, AssetClassSubProductType41Code> values;
	static {
        Map<String, AssetClassSubProductType41Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType41Code instance : AssetClassSubProductType41Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType41Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType41Code fromDisplayName(String name) {
		AssetClassSubProductType41Code value = values.get(name);
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
