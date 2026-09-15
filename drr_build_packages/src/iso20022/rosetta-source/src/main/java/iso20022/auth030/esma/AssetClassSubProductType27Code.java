package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Light Ends.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType27Code")
public enum AssetClassSubProductType27Code {

	/**
	 * Commodity of type light ends.
	 */
	@RosettaEnumValue(value = "LGHT") 
	LGHT("LGHT", null)
;
	private static Map<String, AssetClassSubProductType27Code> values;
	static {
        Map<String, AssetClassSubProductType27Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType27Code instance : AssetClassSubProductType27Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType27Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType27Code fromDisplayName(String name) {
		AssetClassSubProductType27Code value = values.get(name);
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
