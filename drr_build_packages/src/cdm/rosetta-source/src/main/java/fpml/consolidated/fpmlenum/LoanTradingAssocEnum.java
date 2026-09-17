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
 * Provision A list that defines the loan trading association responsible for defining the standardized legal framework that governs the trade.
 *
 */
@RosettaEnum("LoanTradingAssocEnum")
public enum LoanTradingAssocEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Loan Market Association (UK).
	 *
	 */
	@RosettaEnumValue(value = "LMA") 
	LMA("LMA", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Loan Syndications and Trading Association (US).
	 *
	 */
	@RosettaEnumValue(value = "LSTA") 
	LSTA("LSTA", null)
;
	private static Map<String, LoanTradingAssocEnum> values;
	static {
        Map<String, LoanTradingAssocEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingAssocEnum instance : LoanTradingAssocEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingAssocEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingAssocEnum fromDisplayName(String name) {
		LoanTradingAssocEnum value = values.get(name);
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
