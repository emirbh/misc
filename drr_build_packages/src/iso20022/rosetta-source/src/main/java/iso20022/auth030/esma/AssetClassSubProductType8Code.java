package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Oil.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType8Code")
public enum AssetClassSubProductType8Code {

	/**
	 * Commodity of type oil.
	 */
	@RosettaEnumValue(value = "OILP") 
	OILP("OILP", null)
;
	private static Map<String, AssetClassSubProductType8Code> values;
	static {
        Map<String, AssetClassSubProductType8Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType8Code instance : AssetClassSubProductType8Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType8Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType8Code fromDisplayName(String name) {
		AssetClassSubProductType8Code value = values.get(name);
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
