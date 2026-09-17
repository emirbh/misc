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
 * Provision Indicator as to the type of transaction in accordance with Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014.
 *
 */
@RosettaEnum("NotionalChangeEnum")
public enum NotionalChangeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Transaction results in a Increase of Notional value
	 *
	 */
	@RosettaEnumValue(value = "Increase") 
	INCREASE("Increase", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Transaction results in a Decrease of Notional value
	 *
	 */
	@RosettaEnumValue(value = "Decrease") 
	DECREASE("Decrease", null)
;
	private static Map<String, NotionalChangeEnum> values;
	static {
        Map<String, NotionalChangeEnum> map = new ConcurrentHashMap<>();
		for (NotionalChangeEnum instance : NotionalChangeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotionalChangeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotionalChangeEnum fromDisplayName(String name) {
		NotionalChangeEnum value = values.get(name);
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
