package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the categories or characteristics that apply to a transaction which allow application of an end-user exception determination.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/transaction-characteristic"
 *
 * Provision 
 *
 */
@RosettaEnum("TransactionCharacteristicEnum")
public enum TransactionCharacteristicEnum {

	/**
	 */
	@RosettaEnumValue(value = "BoardOfDirectorsApproval") 
	BOARD_OF_DIRECTORS_APPROVAL("BoardOfDirectorsApproval", null),
	
	/**
	 */
	@RosettaEnumValue(value = "HedgesFinancialRisk") 
	HEDGES_FINANCIAL_RISK("HedgesFinancialRisk", null)
;
	private static Map<String, TransactionCharacteristicEnum> values;
	static {
        Map<String, TransactionCharacteristicEnum> map = new ConcurrentHashMap<>();
		for (TransactionCharacteristicEnum instance : TransactionCharacteristicEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TransactionCharacteristicEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TransactionCharacteristicEnum fromDisplayName(String name) {
		TransactionCharacteristicEnum value = values.get(name);
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
