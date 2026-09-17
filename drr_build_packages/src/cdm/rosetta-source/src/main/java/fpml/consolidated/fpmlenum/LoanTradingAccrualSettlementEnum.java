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
 * Provision A list that defines how the interest accrued during the settlement period is calculated and paid.
 *
 */
@RosettaEnum("LoanTradingAccrualSettlementEnum")
public enum LoanTradingAccrualSettlementEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trades flat.
	 *
	 */
	@RosettaEnumValue(value = "Flat") 
	FLAT("Flat", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settled with Accrued Interest: Interest accrued during the settlement period is paid at settlement.
	 *
	 */
	@RosettaEnumValue(value = "SettledWithAccrued") 
	SETTLED_WITH_ACCRUED("SettledWithAccrued", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settled without Accrued Interest: Interest accrued during for the settlement period is not paid at settlement.
	 *
	 */
	@RosettaEnumValue(value = "SettledWithoutAccrued") 
	SETTLED_WITHOUT_ACCRUED("SettledWithoutAccrued", null)
;
	private static Map<String, LoanTradingAccrualSettlementEnum> values;
	static {
        Map<String, LoanTradingAccrualSettlementEnum> map = new ConcurrentHashMap<>();
		for (LoanTradingAccrualSettlementEnum instance : LoanTradingAccrualSettlementEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LoanTradingAccrualSettlementEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LoanTradingAccrualSettlementEnum fromDisplayName(String name) {
		LoanTradingAccrualSettlementEnum value = values.get(name);
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
