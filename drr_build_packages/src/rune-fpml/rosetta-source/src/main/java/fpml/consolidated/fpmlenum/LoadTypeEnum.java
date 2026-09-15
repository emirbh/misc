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
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaEnum("LoadTypeEnum")
public enum LoadTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Base
	 *
	 */
	@RosettaEnumValue(value = "Base") 
	BASE("Base", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Peak
	 *
	 */
	@RosettaEnumValue(value = "Peak") 
	PEAK("Peak", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Off-Peak
	 *
	 */
	@RosettaEnumValue(value = "OffPeak") 
	OFF_PEAK("OffPeak", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Block Hours
	 *
	 */
	@RosettaEnumValue(value = "BlockHours") 
	BLOCK_HOURS("BlockHours", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Anything that does not fall under the predefined standard categories
	 *
	 */
	@RosettaEnumValue(value = "Custom") 
	CUSTOM("Custom", null)
;
	private static Map<String, LoadTypeEnum> values;
	static {
        Map<String, LoadTypeEnum> map = new ConcurrentHashMap<>();
		for (LoadTypeEnum instance : LoadTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoadTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoadTypeEnum fromDisplayName(String name) {
		LoadTypeEnum value = values.get(name);
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
