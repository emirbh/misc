package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Wet Freight.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType32Code")
public enum AssetClassSubProductType32Code {

	/**
	 * Commodity of type wet freight.
	 */
	@RosettaEnumValue(value = "WETF") 
	WETF("WETF", null)
;
	private static Map<String, AssetClassSubProductType32Code> values;
	static {
        Map<String, AssetClassSubProductType32Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType32Code instance : AssetClassSubProductType32Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType32Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType32Code fromDisplayName(String name) {
		AssetClassSubProductType32Code value = values.get(name);
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
