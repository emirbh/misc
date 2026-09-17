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
@RosettaEnum("LoanTradingLetterOfCreditFeeTypeEnum")
public enum LoanTradingLetterOfCreditFeeTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LetterOfCreditFronting") 
	LETTER_OF_CREDIT_FRONTING("LetterOfCreditFronting", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LetterOfCreditIssuance") 
	LETTER_OF_CREDIT_ISSUANCE("LetterOfCreditIssuance", null)
;
	private static Map<String, LoanTradingLetterOfCreditFeeTypeEnum> values;
	static {
        Map<String, LoanTradingLetterOfCreditFeeTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingLetterOfCreditFeeTypeEnum instance : LoanTradingLetterOfCreditFeeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingLetterOfCreditFeeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingLetterOfCreditFeeTypeEnum fromDisplayName(String name) {
		LoanTradingLetterOfCreditFeeTypeEnum value = values.get(name);
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
