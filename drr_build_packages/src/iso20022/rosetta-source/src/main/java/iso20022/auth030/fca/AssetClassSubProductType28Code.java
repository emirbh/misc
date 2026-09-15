package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Renewable Energy.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType28Code")
public enum AssetClassSubProductType28Code {

	/**
	 * Commodity of type renewable energy.
	 */
	@RosettaEnumValue(value = "RNNG") 
	RNNG("RNNG", null)
;
	private static Map<String, AssetClassSubProductType28Code> values;
	static {
        Map<String, AssetClassSubProductType28Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType28Code instance : AssetClassSubProductType28Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType28Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType28Code fromDisplayName(String name) {
		AssetClassSubProductType28Code value = values.get(name);
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
