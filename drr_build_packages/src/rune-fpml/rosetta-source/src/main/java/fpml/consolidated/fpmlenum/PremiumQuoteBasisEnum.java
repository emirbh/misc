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
 * Provision 
 *
 */
@RosettaEnum("PremiumQuoteBasisEnum")
public enum PremiumQuoteBasisEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "PercentageOfCallCurrencyAmount") 
	PERCENTAGE_OF_CALL_CURRENCY_AMOUNT("PercentageOfCallCurrencyAmount", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "PercentageOfPutCurrencyAmount") 
	PERCENTAGE_OF_PUT_CURRENCY_AMOUNT("PercentageOfPutCurrencyAmount", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "CallCurrencyPerPutCurrency") 
	CALL_CURRENCY_PER_PUT_CURRENCY("CallCurrencyPerPutCurrency", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "PutCurrencyPerCallCurrency") 
	PUT_CURRENCY_PER_CALL_CURRENCY("PutCurrencyPerCallCurrency", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Explicit") 
	EXPLICIT("Explicit", null)
;
	private static Map<String, PremiumQuoteBasisEnum> values;
	static {
        Map<String, PremiumQuoteBasisEnum> map = new ConcurrentHashMap<>();
		for (PremiumQuoteBasisEnum instance : PremiumQuoteBasisEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PremiumQuoteBasisEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PremiumQuoteBasisEnum fromDisplayName(String name) {
		PremiumQuoteBasisEnum value = values.get(name);
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
