package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Other C10.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType11Code")
public enum AssetClassProductType11Code {

	/**
	 * Commodity of other type C10.
	 */
	@RosettaEnumValue(value = "OTHC") 
	OTHC("OTHC", null)
;
	private static Map<String, AssetClassProductType11Code> values;
	static {
        Map<String, AssetClassProductType11Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType11Code instance : AssetClassProductType11Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType11Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType11Code fromDisplayName(String name) {
		AssetClassProductType11Code value = values.get(name);
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
