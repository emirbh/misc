package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Olive Oil.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType29Code")
public enum AssetClassDetailedSubProductType29Code {

	/**
	 * Commodity attribute of type lampante.
	 */
	@RosettaEnumValue(value = "LAMP") 
	LAMP("LAMP", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType29Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType29Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType29Code instance : AssetClassDetailedSubProductType29Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType29Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType29Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType29Code value = values.get(name);
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
