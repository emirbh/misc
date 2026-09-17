package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Description of the relevant derivative transactions excluded from the calculation of exposure.
 * @version 6.23.0
 */
@RosettaEnum("ExposureScopeProductEnum")
public enum ExposureScopeProductEnum {

	/**
	 * FX Transactions.
	 */
	@RosettaEnumValue(value = "FXTransactions", displayName = "FX Transactions") 
	FX_TRANSACTIONS("FXTransactions", "FX Transactions"),
	
	/**
	 * FX Transactions with Settlement date.
	 */
	@RosettaEnumValue(value = "FXSettlementDate", displayName = "FX Transaction with Settlement Date") 
	FX_SETTLEMENT_DATE("FXSettlementDate", "FX Transaction with Settlement Date"),
	
	/**
	 * Currency Option Transactions.
	 */
	@RosettaEnumValue(value = "CurrencyOptionTransactions", displayName = "Currency Option Transactions") 
	CURRENCY_OPTION_TRANSACTIONS("CurrencyOptionTransactions", "Currency Option Transactions")
;
	private static Map<String, ExposureScopeProductEnum> values;
	static {
        Map<String, ExposureScopeProductEnum> map = new ConcurrentHashMap<>();
		for (ExposureScopeProductEnum instance : ExposureScopeProductEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExposureScopeProductEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExposureScopeProductEnum fromDisplayName(String name) {
		ExposureScopeProductEnum value = values.get(name);
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
