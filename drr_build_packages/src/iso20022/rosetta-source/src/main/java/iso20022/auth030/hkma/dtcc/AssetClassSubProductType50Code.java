package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the sub-product of type as either recovered paper or other.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassSubProductType50Code")
public enum AssetClassSubProductType50Code {

	/**
	 * Commodity of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Commodity of type recovered paper.
	 */
	@RosettaEnumValue(value = "RCVP") 
	RCVP("RCVP", null)
;
	private static Map<String, AssetClassSubProductType50Code> values;
	static {
        Map<String, AssetClassSubProductType50Code> map = new ConcurrentHashMap<>();
		for (AssetClassSubProductType50Code instance : AssetClassSubProductType50Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassSubProductType50Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassSubProductType50Code fromDisplayName(String name) {
		AssetClassSubProductType50Code value = values.get(name);
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
