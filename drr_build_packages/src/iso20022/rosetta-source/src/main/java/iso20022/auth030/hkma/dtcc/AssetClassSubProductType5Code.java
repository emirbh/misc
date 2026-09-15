package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Grain.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType5Code")
public enum AssetClassSubProductType5Code {

	/**
	 * Commodity of type grain.
	 */
	@RosettaEnumValue(value = "GRIN") 
	GRIN("GRIN", null)
;
	private static Map<String, AssetClassSubProductType5Code> values;
	static {
        Map<String, AssetClassSubProductType5Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType5Code instance : AssetClassSubProductType5Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType5Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType5Code fromDisplayName(String name) {
		AssetClassSubProductType5Code value = values.get(name);
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
