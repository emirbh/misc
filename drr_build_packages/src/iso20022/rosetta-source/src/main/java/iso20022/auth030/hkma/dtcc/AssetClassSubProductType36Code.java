package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Newsprint.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType36Code")
public enum AssetClassSubProductType36Code {

	/**
	 * Commodity of type newsprint.
	 */
	@RosettaEnumValue(value = "NSPT") 
	NSPT("NSPT", null)
;
	private static Map<String, AssetClassSubProductType36Code> values;
	static {
        Map<String, AssetClassSubProductType36Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType36Code instance : AssetClassSubProductType36Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType36Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType36Code fromDisplayName(String name) {
		AssetClassSubProductType36Code value = values.get(name);
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
