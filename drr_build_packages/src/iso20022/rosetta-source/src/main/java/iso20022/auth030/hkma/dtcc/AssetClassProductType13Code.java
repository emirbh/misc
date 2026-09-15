package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Multi Commodity Exotic.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType13Code")
public enum AssetClassProductType13Code {

	/**
	 * Commodity of type multi commodity exotic.
	 */
	@RosettaEnumValue(value = "MCEX") 
	MCEX("MCEX", null)
;
	private static Map<String, AssetClassProductType13Code> values;
	static {
        Map<String, AssetClassProductType13Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType13Code instance : AssetClassProductType13Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType13Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType13Code fromDisplayName(String name) {
		AssetClassProductType13Code value = values.get(name);
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
