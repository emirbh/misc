package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Natural Gas.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType7Code")
public enum AssetClassSubProductType7Code {

	/**
	 * Commodity of type natural gas.
	 */
	@RosettaEnumValue(value = "NGAS") 
	NGAS("NGAS", null)
;
	private static Map<String, AssetClassSubProductType7Code> values;
	static {
        Map<String, AssetClassSubProductType7Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType7Code instance : AssetClassSubProductType7Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType7Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType7Code fromDisplayName(String name) {
		AssetClassSubProductType7Code value = values.get(name);
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
