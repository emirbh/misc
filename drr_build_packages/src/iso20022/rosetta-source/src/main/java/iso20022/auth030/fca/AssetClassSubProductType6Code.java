package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Electricity.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType6Code")
public enum AssetClassSubProductType6Code {

	/**
	 * Commodity of type electricity.
	 */
	@RosettaEnumValue(value = "ELEC") 
	ELEC("ELEC", null)
;
	private static Map<String, AssetClassSubProductType6Code> values;
	static {
        Map<String, AssetClassSubProductType6Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType6Code instance : AssetClassSubProductType6Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType6Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType6Code fromDisplayName(String name) {
		AssetClassSubProductType6Code value = values.get(name);
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
