package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Olive Oil.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType3Code")
public enum AssetClassSubProductType3Code {

	/**
	 * Commodity of type olive oil.
	 */
	@RosettaEnumValue(value = "OOLI") 
	OOLI("OOLI", null)
;
	private static Map<String, AssetClassSubProductType3Code> values;
	static {
        Map<String, AssetClassSubProductType3Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType3Code instance : AssetClassSubProductType3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType3Code fromDisplayName(String name) {
		AssetClassSubProductType3Code value = values.get(name);
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
