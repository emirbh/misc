package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Official Economic Statistics.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType14Code")
public enum AssetClassProductType14Code {

	/**
	 * Commodity of type official economic statistic.
	 */
	@RosettaEnumValue(value = "OEST") 
	OEST("OEST", null)
;
	private static Map<String, AssetClassProductType14Code> values;
	static {
        Map<String, AssetClassProductType14Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType14Code instance : AssetClassProductType14Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType14Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType14Code fromDisplayName(String name) {
		AssetClassProductType14Code value = values.get(name);
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
