package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Urea.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType43Code")
public enum AssetClassSubProductType43Code {

	/**
	 * Commodity of type urea.
	 */
	@RosettaEnumValue(value = "UREA") 
	UREA("UREA", null)
;
	private static Map<String, AssetClassSubProductType43Code> values;
	static {
        Map<String, AssetClassSubProductType43Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType43Code instance : AssetClassSubProductType43Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType43Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType43Code fromDisplayName(String name) {
		AssetClassSubProductType43Code value = values.get(name);
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
