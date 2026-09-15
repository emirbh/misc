package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Containerboard.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType35Code")
public enum AssetClassSubProductType35Code {

	/**
	 * Commodity of type containerboard.
	 */
	@RosettaEnumValue(value = "CBRD") 
	CBRD("CBRD", null)
;
	private static Map<String, AssetClassSubProductType35Code> values;
	static {
        Map<String, AssetClassSubProductType35Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType35Code instance : AssetClassSubProductType35Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType35Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType35Code fromDisplayName(String name) {
		AssetClassSubProductType35Code value = values.get(name);
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
