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
 * Provision This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
 *
 */
@RosettaEnum("MarginTypeEnum")
public enum MarginTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
	 *
	 */
	@RosettaEnumValue(value = "Cash") 
	CASH("Cash", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the “instrument” case, the haircut would be applied to the securities.
	 *
	 */
	@RosettaEnumValue(value = "Instrument") 
	INSTRUMENT("Instrument", null)
;
	private static Map<String, MarginTypeEnum> values;
	static {
        Map<String, MarginTypeEnum> map = new ConcurrentHashMap<>();
		for (MarginTypeEnum instance : MarginTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MarginTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MarginTypeEnum fromDisplayName(String name) {
		MarginTypeEnum value = values.get(name);
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
