package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Emission.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType10Code")
public enum AssetClassSubProductType10Code {

	/**
	 * Commodity of type emission.
	 */
	@RosettaEnumValue(value = "EMIS") 
	EMIS("EMIS", null)
;
	private static Map<String, AssetClassSubProductType10Code> values;
	static {
        Map<String, AssetClassSubProductType10Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType10Code instance : AssetClassSubProductType10Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType10Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType10Code fromDisplayName(String name) {
		AssetClassSubProductType10Code value = values.get(name);
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
