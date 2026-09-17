package fpml.consolidated.fpmlenum;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaEnum("InventoryAccountingMethodEnum")
public enum InventoryAccountingMethodEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "FIFO") 
	FIFO("FIFO", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LIFO") 
	LIFO("LIFO", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "WeightedAverage") 
	WEIGHTED_AVERAGE("WeightedAverage", null)
;
	private static Map<String, InventoryAccountingMethodEnum> values;
	static {
        Map<String, InventoryAccountingMethodEnum> map = new ConcurrentHashMap<>();
		for (InventoryAccountingMethodEnum instance : InventoryAccountingMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InventoryAccountingMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InventoryAccountingMethodEnum fromDisplayName(String name) {
		InventoryAccountingMethodEnum value = values.get(name);
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
