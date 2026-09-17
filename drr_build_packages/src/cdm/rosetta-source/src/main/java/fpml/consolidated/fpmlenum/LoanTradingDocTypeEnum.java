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
 * Provision A list describing the type of documentation used to settle a secondary market syndicated loan trade.
 *
 */
@RosettaEnum("LoanTradingDocTypeEnum")
public enum LoanTradingDocTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Distressed loan trade documentation.
	 *
	 */
	@RosettaEnumValue(value = "Distressed") 
	DISTRESSED("Distressed", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Par loan trade documentation.
	 *
	 */
	@RosettaEnumValue(value = "Par") 
	PAR("Par", null)
;
	private static Map<String, LoanTradingDocTypeEnum> values;
	static {
        Map<String, LoanTradingDocTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingDocTypeEnum instance : LoanTradingDocTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingDocTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingDocTypeEnum fromDisplayName(String name) {
		LoanTradingDocTypeEnum value = values.get(name);
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
