package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Softs.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType2Code")
public enum AssetClassSubProductType2Code {

	/**
	 * Commodity of type softs.
	 */
	@RosettaEnumValue(value = "SOFT") 
	SOFT("SOFT", null)
;
	private static Map<String, AssetClassSubProductType2Code> values;
	static {
        Map<String, AssetClassSubProductType2Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType2Code instance : AssetClassSubProductType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType2Code fromDisplayName(String name) {
		AssetClassSubProductType2Code value = values.get(name);
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
