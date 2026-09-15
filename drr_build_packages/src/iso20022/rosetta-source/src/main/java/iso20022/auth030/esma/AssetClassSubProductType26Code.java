package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Inter Energy.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType26Code")
public enum AssetClassSubProductType26Code {

	/**
	 * Commodity of type inter energy.
	 */
	@RosettaEnumValue(value = "INRG") 
	INRG("INRG", null)
;
	private static Map<String, AssetClassSubProductType26Code> values;
	static {
        Map<String, AssetClassSubProductType26Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType26Code instance : AssetClassSubProductType26Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType26Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType26Code fromDisplayName(String name) {
		AssetClassSubProductType26Code value = values.get(name);
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
