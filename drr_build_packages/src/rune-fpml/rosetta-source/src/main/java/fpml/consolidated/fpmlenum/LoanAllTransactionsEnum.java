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
 * Provision A list with a single 'all' value to explicitly indicate all transactions are applicable.
 *
 */
@RosettaEnum("LoanAllTransactionsEnum")
public enum LoanAllTransactionsEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trade is part of a syndication.
	 *
	 */
	@RosettaEnumValue(value = "All") 
	ALL("All", null)
;
	private static Map<String, LoanAllTransactionsEnum> values;
	static {
        Map<String, LoanAllTransactionsEnum> map = new ConcurrentHashMap<>();
		for (LoanAllTransactionsEnum instance : LoanAllTransactionsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanAllTransactionsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanAllTransactionsEnum fromDisplayName(String name) {
		LoanAllTransactionsEnum value = values.get(name);
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
