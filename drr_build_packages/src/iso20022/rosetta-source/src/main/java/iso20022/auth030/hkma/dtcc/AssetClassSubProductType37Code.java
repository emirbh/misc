package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Pulp.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType37Code")
public enum AssetClassSubProductType37Code {

	/**
	 * Commodity of type pulp.
	 */
	@RosettaEnumValue(value = "PULP") 
	PULP("PULP", null)
;
	private static Map<String, AssetClassSubProductType37Code> values;
	static {
        Map<String, AssetClassSubProductType37Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType37Code instance : AssetClassSubProductType37Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType37Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType37Code fromDisplayName(String name) {
		AssetClassSubProductType37Code value = values.get(name);
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
