package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Precious Metal.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType16Code")
public enum AssetClassSubProductType16Code {

	/**
	 * Commodity of type precious metals.
	 */
	@RosettaEnumValue(value = "PRME") 
	PRME("PRME", null)
;
	private static Map<String, AssetClassSubProductType16Code> values;
	static {
        Map<String, AssetClassSubProductType16Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType16Code instance : AssetClassSubProductType16Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType16Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType16Code fromDisplayName(String name) {
		AssetClassSubProductType16Code value = values.get(name);
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
