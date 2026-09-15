package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Floating rate index ISO Code List corresponding to the version published by EMIR Refit as part of its requirements.
 * @version 7.7.0
 */
@RosettaEnum("ISOFloatingRateIndexEnum")
public enum ISOFloatingRateIndexEnum {

	/**
	 * BBSW
	 */
	@RosettaEnumValue(value = "BBSW") 
	BBSW("BBSW", null),
	
	/**
	 * BUBOR
	 */
	@RosettaEnumValue(value = "BUBO") 
	BUBO("BUBO", null),
	
	/**
	 * CDOR
	 */
	@RosettaEnumValue(value = "CDOR") 
	CDOR("CDOR", null),
	
	/**
	 * CIBOR
	 */
	@RosettaEnumValue(value = "CIBO") 
	CIBO("CIBO", null),
	
	/**
	 * CORA
	 */
	@RosettaEnumValue(value = "CORA") 
	CORA("CORA", null),
	
	/**
	 * Effective Federal Funds Rate OBFR = Overnight Bank Funding Rate
	 */
	@RosettaEnumValue(value = "EFFR") 
	EFFR("EFFR", null),
	
	/**
	 * EONIA
	 */
	@RosettaEnumValue(value = "EONA") 
	EONA("EONA", null),
	
	/**
	 * EONIA SWAP
	 */
	@RosettaEnumValue(value = "EONS") 
	EONS("EONS", null),
	
	/**
	 * STR
	 */
	@RosettaEnumValue(value = "ESTR") 
	ESTR("ESTR", null),
	
	/**
	 * EURIBOR
	 */
	@RosettaEnumValue(value = "EURI") 
	EURI("EURI", null),
	
	/**
	 * HKIO
	 */
	@RosettaEnumValue(value = "HKIO") 
	HKIO("HKIO", null),
	
	/**
	 * ISDAFIX
	 */
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	/**
	 * JIBAR
	 */
	@RosettaEnumValue(value = "JIBA") 
	JIBA("JIBA", null),
	
	/**
	 * LIBOR
	 */
	@RosettaEnumValue(value = "LIBO") 
	LIBO("LIBO", null),
	
	/**
	 * Muni AAA
	 */
	@RosettaEnumValue(value = "MAAA") 
	MAAA("MAAA", null),
	
	/**
	 * MOSPRIM
	 */
	@RosettaEnumValue(value = "MOSP") 
	MOSP("MOSP", null),
	
	/**
	 * NIBOR
	 */
	@RosettaEnumValue(value = "NIBO") 
	NIBO("NIBO", null),
	
	/**
	 * PRIBOR
	 */
	@RosettaEnumValue(value = "PRBO") 
	PRBO("PRBO", null),
	
	/**
	 * SOFR
	 */
	@RosettaEnumValue(value = "SOFR") 
	SOFR("SOFR", null),
	
	/**
	 * SONIA
	 */
	@RosettaEnumValue(value = "SONA") 
	SONA("SONA", null),
	
	/**
	 * STIBOR
	 */
	@RosettaEnumValue(value = "STBO") 
	STBO("STBO", null),
	
	/**
	 * SWAP
	 */
	@RosettaEnumValue(value = "SWAP") 
	SWAP("SWAP", null),
	
	/**
	 * TIBOR
	 */
	@RosettaEnumValue(value = "TIBO") 
	TIBO("TIBO", null),
	
	/**
	 * TELBOR
	 */
	@RosettaEnumValue(value = "TLBO") 
	TLBO("TLBO", null),
	
	/**
	 * Treasury
	 */
	@RosettaEnumValue(value = "TREA") 
	TREA("TREA", null),
	
	/**
	 * WIBOR
	 */
	@RosettaEnumValue(value = "WIBO") 
	WIBO("WIBO", null)
;
	private static Map<String, ISOFloatingRateIndexEnum> values;
	static {
        Map<String, ISOFloatingRateIndexEnum> map = new ConcurrentHashMap<>();
		for (ISOFloatingRateIndexEnum instance : ISOFloatingRateIndexEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ISOFloatingRateIndexEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ISOFloatingRateIndexEnum fromDisplayName(String name) {
		ISOFloatingRateIndexEnum value = values.get(name);
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
