package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Wet.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType34Code")
public enum AssetClassDetailedSubProductType34Code {

	/**
	 * Commodity attribute of type tanker.
	 */
	@RosettaEnumValue(value = "TNKR") 
	TNKR("TNKR", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType34Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType34Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType34Code instance : AssetClassDetailedSubProductType34Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType34Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType34Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType34Code value = values.get(name);
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
