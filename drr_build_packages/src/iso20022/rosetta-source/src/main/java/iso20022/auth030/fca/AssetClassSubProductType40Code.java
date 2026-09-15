package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Diammonium Phosphate.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType40Code")
public enum AssetClassSubProductType40Code {

	/**
	 * Commodity of type diammonium phosphate.
	 */
	@RosettaEnumValue(value = "DAPH") 
	DAPH("DAPH", null)
;
	private static Map<String, AssetClassSubProductType40Code> values;
	static {
        Map<String, AssetClassSubProductType40Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType40Code instance : AssetClassSubProductType40Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType40Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType40Code fromDisplayName(String name) {
		AssetClassSubProductType40Code value = values.get(name);
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
