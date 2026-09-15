package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Energy.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType2Code")
public enum AssetClassProductType2Code {

	/**
	 * Commodity of type energy.
	 */
	@RosettaEnumValue(value = "NRGY") 
	NRGY("NRGY", null)
;
	private static Map<String, AssetClassProductType2Code> values;
	static {
        Map<String, AssetClassProductType2Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType2Code instance : AssetClassProductType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType2Code fromDisplayName(String name) {
		AssetClassProductType2Code value = values.get(name);
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
