package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Carbon Related.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType29Code")
public enum AssetClassSubProductType29Code {

	/**
	 * Commodity of type carbon related.
	 */
	@RosettaEnumValue(value = "CRBR") 
	CRBR("CRBR", null)
;
	private static Map<String, AssetClassSubProductType29Code> values;
	static {
        Map<String, AssetClassSubProductType29Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType29Code instance : AssetClassSubProductType29Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType29Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType29Code fromDisplayName(String name) {
		AssetClassSubProductType29Code value = values.get(name);
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
