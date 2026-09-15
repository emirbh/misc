package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Dry.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType33Code")
public enum AssetClassDetailedSubProductType33Code {

	/**
	 * Commodity attribute of type dry bulk carrier.
	 */
	@RosettaEnumValue(value = "DBCR") 
	DBCR("DBCR", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType33Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType33Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType33Code instance : AssetClassDetailedSubProductType33Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType33Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType33Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType33Code value = values.get(name);
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
