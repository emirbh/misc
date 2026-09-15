package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Commodity derivative base product code list for Paper.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassProductType8Code")
public enum AssetClassProductType8Code {

	/**
	 * Commodity of type paper.
	 */
	@RosettaEnumValue(value = "PAPR") 
	PAPR("PAPR", null)
;
	private static Map<String, AssetClassProductType8Code> values;
	static {
        Map<String, AssetClassProductType8Code> map = new ConcurrentHashMap<>();
		for (AssetClassProductType8Code instance : AssetClassProductType8Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassProductType8Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassProductType8Code fromDisplayName(String name) {
		AssetClassProductType8Code value = values.get(name);
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
