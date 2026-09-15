package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("CommonAssetClass")
public enum CommonAssetClass {

	/**
	 * Rates
	 */
	@RosettaEnumValue(value = "INTR") 
	INTR("INTR", null),
	
	/**
	 * Credit
	 */
	@RosettaEnumValue(value = "CRDT") 
	CRDT("CRDT", null),
	
	/**
	 * Equity
	 */
	@RosettaEnumValue(value = "EQUI") 
	EQUI("EQUI", null),
	
	/**
	 * Commodity
	 */
	@RosettaEnumValue(value = "COMM") 
	COMM("COMM", null),
	
	/**
	 * Foreign exchange
	 */
	@RosettaEnumValue(value = "CURR") 
	CURR("CURR", null)
;
	private static Map<String, CommonAssetClass> values;
	static {
        Map<String, CommonAssetClass> map = new ConcurrentHashMap<>();
		for (CommonAssetClass instance : CommonAssetClass.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommonAssetClass(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommonAssetClass fromDisplayName(String name) {
		CommonAssetClass value = values.get(name);
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
