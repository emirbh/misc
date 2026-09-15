package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Potato.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType45Code")
public enum AssetClassSubProductType45Code {

	/**
	 * Commodity of type potato.
	 */
	@RosettaEnumValue(value = "POTA") 
	POTA("POTA", null)
;
	private static Map<String, AssetClassSubProductType45Code> values;
	static {
        Map<String, AssetClassSubProductType45Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType45Code instance : AssetClassSubProductType45Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType45Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType45Code fromDisplayName(String name) {
		AssetClassSubProductType45Code value = values.get(name);
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
