package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Sulphur.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType42Code")
public enum AssetClassSubProductType42Code {

	/**
	 * Commodity of type sulphur.
	 */
	@RosettaEnumValue(value = "SLPH") 
	SLPH("SLPH", null)
;
	private static Map<String, AssetClassSubProductType42Code> values;
	static {
        Map<String, AssetClassSubProductType42Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType42Code instance : AssetClassSubProductType42Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType42Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType42Code fromDisplayName(String name) {
		AssetClassSubProductType42Code value = values.get(name);
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
