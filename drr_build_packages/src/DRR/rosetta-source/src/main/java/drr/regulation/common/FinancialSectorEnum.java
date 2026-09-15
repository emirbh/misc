package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Taxonomy for Financial Counterparties
 * @version 7.7.0
 */
@RosettaEnum("FinancialSectorEnum")
public enum FinancialSectorEnum {

	/**
	 * Investment firm authorized in accordance with Directive 2014/65/EU of the European Parliament and of the Council
	 */
	@RosettaEnumValue(value = "INVF") 
	INVF("INVF", null),
	
	/**
	 * Credit institution authorised in accordance with Directive 2013/36/EU
	 */
	@RosettaEnumValue(value = "CDTI") 
	CDTI("CDTI", null),
	
	/**
	 * an insurance undertaking or reinsurance undertaking authorised in accordance with Directive 2009/138/EC of the European Parliament and of the Council
	 */
	@RosettaEnumValue(value = "INUN") 
	INUN("INUN", null),
	
	/**
	 * a UCITS and, where relevant, its management company, authorised in accordance with Directive 2009/65/EC, unless that UCITS is set up exclusively for the purpose of serving one or more employee share purchase plans
	 */
	@RosettaEnumValue(value = "UCIT") 
	UCIT("UCIT", null),
	
	/**
	 * an institution for occupational retirement provision (IORP), as defined in point (1) of Article 6 of Directive (EU) 2016/2341 of the European Parliament and of the Council
	 */
	@RosettaEnumValue(value = "ORPI") 
	ORPI("ORPI", null),
	
	/**
	 * an alternative investment fund (AIF), as defined in point (a) of Article 4(1) of Directive 2011/61/EU, which is either established in the Union or managed by an alternative investment fund manager (AIFM) authorised or registered in accordance with that Directive, unless that AIF is set up exclusively for the purpose of serving one or more employee share purchase plans, or unless that AIF is a securitisation special purpose entity as referred to in point (g) of Article 2(3) of Directive 2011/61/EU, and, where relevant, its AIFM established in the Union
	 */
	@RosettaEnumValue(value = "AIFD") 
	AIFD("AIFD", null),
	
	/**
	 * a central securities depository authorised in accordance with Regulation (EU) No 909/2014 of the European Parliament and of the Council
	 */
	@RosettaEnumValue(value = "CSDS") 
	CSDS("CSDS", null),
	
	/**
	 * Assurance Undertaking
	 */
	@RosettaEnumValue(value = "ASSU") 
	ASSU("ASSU", null),
	
	/**
	 * Reinsurance Undertaking
	 */
	@RosettaEnumValue(value = "REIN") 
	REIN("REIN", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Central Counterparty
	 */
	@RosettaEnumValue(value = "CCPS") 
	CCPS("CCPS", null)
;
	private static Map<String, FinancialSectorEnum> values;
	static {
        Map<String, FinancialSectorEnum> map = new ConcurrentHashMap<>();
		for (FinancialSectorEnum instance : FinancialSectorEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FinancialSectorEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FinancialSectorEnum fromDisplayName(String name) {
		FinancialSectorEnum value = values.get(name);
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
