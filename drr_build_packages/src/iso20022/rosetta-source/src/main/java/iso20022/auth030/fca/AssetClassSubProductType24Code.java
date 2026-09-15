package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type Coal.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType24Code")
public enum AssetClassSubProductType24Code {

	/**
	 * Commodity of type coal.
	 */
	@RosettaEnumValue(value = "COAL") 
	COAL("COAL", null)
;
	private static Map<String, AssetClassSubProductType24Code> values;
	static {
        Map<String, AssetClassSubProductType24Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType24Code instance : AssetClassSubProductType24Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType24Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType24Code fromDisplayName(String name) {
		AssetClassSubProductType24Code value = values.get(name);
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
