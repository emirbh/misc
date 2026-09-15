package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the transaction or position level.
 * @version ${project.version}
 */
@RosettaEnum("ModificationLevel1Code__1")
public enum ModificationLevel1Code__1 {

	/**
	 * Modification applies to a transaction.
	 */
	@RosettaEnumValue(value = "TCTN") 
	TCTN("TCTN", null)
;
	private static Map<String, ModificationLevel1Code__1> values;
	static {
        Map<String, ModificationLevel1Code__1> map = new ConcurrentHashMap<>();
		for (ModificationLevel1Code__1 instance : ModificationLevel1Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ModificationLevel1Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ModificationLevel1Code__1 fromDisplayName(String name) {
		ModificationLevel1Code__1 value = values.get(name);
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
