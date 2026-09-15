package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Fertilizer.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType5Code")
public enum AssetClassProductType5Code {

	/**
	 * Commodity of type fertilizer.
	 */
	@RosettaEnumValue(value = "FRTL") 
	FRTL("FRTL", null)
;
	private static Map<String, AssetClassProductType5Code> values;
	static {
        Map<String, AssetClassProductType5Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType5Code instance : AssetClassProductType5Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType5Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType5Code fromDisplayName(String name) {
		AssetClassProductType5Code value = values.get(name);
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
