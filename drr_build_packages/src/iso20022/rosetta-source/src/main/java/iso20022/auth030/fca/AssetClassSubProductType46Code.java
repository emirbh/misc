package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Container Ship Freight.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType46Code")
public enum AssetClassSubProductType46Code {

	/**
	 * Commodity of type container ships.
	 */
	@RosettaEnumValue(value = "CSHP") 
	CSHP("CSHP", null)
;
	private static Map<String, AssetClassSubProductType46Code> values;
	static {
        Map<String, AssetClassSubProductType46Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType46Code instance : AssetClassSubProductType46Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType46Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType46Code fromDisplayName(String name) {
		AssetClassSubProductType46Code value = values.get(name);
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
