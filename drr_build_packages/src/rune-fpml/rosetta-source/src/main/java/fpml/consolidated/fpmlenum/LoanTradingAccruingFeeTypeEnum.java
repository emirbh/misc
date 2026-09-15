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
 * Provision A list of accruing fee types associated with a facility.
 *
 */
@RosettaEnum("LoanTradingAccruingFeeTypeEnum")
public enum LoanTradingAccruingFeeTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Calculated as a percentage of the unutilized portion of the facility.
	 *
	 */
	@RosettaEnumValue(value = "Commitment") 
	COMMITMENT("Commitment", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Calculated as a percentage of the global commitment amount of a facility.
	 *
	 */
	@RosettaEnumValue(value = "Facility") 
	FACILITY("Facility", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An on-going (accrual) fee paid to the Issuing Bank for a Letter of Credit. This is separate from the basic Letter of Credit Fee paid to the lender group.
	 *
	 */
	@RosettaEnumValue(value = "LetterOfCreditIssuance") 
	LETTER_OF_CREDIT_ISSUANCE("LetterOfCreditIssuance", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Typically for term loans, a commitment fee that applies to the amount of a commitment that has not yet been drawn down.
	 *
	 */
	@RosettaEnumValue(value = "Ticking") 
	TICKING("Ticking", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Calculated as a percentage of the utilized portion of the facility. This fee type is subject to banding rules – different portions of the utilization amount may be subject to different percentages.
	 *
	 */
	@RosettaEnumValue(value = "Utilization") 
	UTILIZATION("Utilization", null)
;
	private static Map<String, LoanTradingAccruingFeeTypeEnum> values;
	static {
        Map<String, LoanTradingAccruingFeeTypeEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingAccruingFeeTypeEnum instance : LoanTradingAccruingFeeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingAccruingFeeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingAccruingFeeTypeEnum fromDisplayName(String name) {
		LoanTradingAccruingFeeTypeEnum value = values.get(name);
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
