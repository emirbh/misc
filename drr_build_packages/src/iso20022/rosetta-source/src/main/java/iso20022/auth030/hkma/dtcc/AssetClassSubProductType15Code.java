package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Non Precious Metal.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType15Code")
public enum AssetClassSubProductType15Code {

	/**
	 * Commodity of type non precious metals.
	 */
	@RosettaEnumValue(value = "NPRM") 
	NPRM("NPRM", null)
;
	private static Map<String, AssetClassSubProductType15Code> values;
	static {
        Map<String, AssetClassSubProductType15Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType15Code instance : AssetClassSubProductType15Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType15Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType15Code fromDisplayName(String name) {
		AssetClassSubProductType15Code value = values.get(name);
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
