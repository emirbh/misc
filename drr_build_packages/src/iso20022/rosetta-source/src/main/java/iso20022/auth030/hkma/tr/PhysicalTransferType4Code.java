package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the asset delivery type when the financial instrument is settled.
 * @version ${project.version}
 */
@RosettaEnum("PhysicalTransferType4Code")
public enum PhysicalTransferType4Code {

	/**
	 * Physical transfer.
	 */
	@RosettaEnumValue(value = "PHYS") 
	PHYS("PHYS", null),
	
	/**
	 * Determined by a third party or optional for counterparty.
	 */
	@RosettaEnumValue(value = "OPTL") 
	OPTL("OPTL", null),
	
	/**
	 * Cash transfer.
	 */
	@RosettaEnumValue(value = "CASH") 
	CASH("CASH", null)
;
	private static Map<String, PhysicalTransferType4Code> values;
	static {
        Map<String, PhysicalTransferType4Code> map = new ConcurrentHashMap<>();
		for (PhysicalTransferType4Code instance : PhysicalTransferType4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PhysicalTransferType4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PhysicalTransferType4Code fromDisplayName(String name) {
		PhysicalTransferType4Code value = values.get(name);
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
