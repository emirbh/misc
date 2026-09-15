package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the external benchmark curve name code in the format of character string with a maximum length of 4 characters.
 * @version ${project.version}
 */
@RosettaEnum("FloatingRateIndex1Code")
public enum FloatingRateIndex1Code {

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
	 * CZEONIA
	 */
	@RosettaEnumValue(value = "CZNA") 
	CZNA("CZNA", null),
	
	/**
	 * Effective Federal Funds Rate
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
	 * €STR
	 */
	@RosettaEnumValue(value = "ESTR") 
	ESTR("ESTR", null),
	
	/**
	 * EuroSwiss
	 */
	@RosettaEnumValue(value = "EUCH") 
	EUCH("EUCH", null),
	
	/**
	 * EURIBOR
	 */
	@RosettaEnumValue(value = "EURI") 
	EURI("EURI", null),
	
	/**
	 * EURODOLLAR
	 */
	@RosettaEnumValue(value = "EUUS") 
	EUUS("EUUS", null),
	
	/**
	 * Future SWAP
	 */
	@RosettaEnumValue(value = "FUSW") 
	FUSW("FUSW", null),
	
	/**
	 * GCF REPO
	 */
	@RosettaEnumValue(value = "GCFR") 
	GCFR("GCFR", null),
	
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
	 * LIBID
	 */
	@RosettaEnumValue(value = "LIBI") 
	LIBI("LIBI", null),
	
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
	 * Overnight Bank Funding Rate
	 */
	@RosettaEnumValue(value = "OBFR") 
	OBFR("OBFR", null),
	
	/**
	 * Pfandbriefe
	 */
	@RosettaEnumValue(value = "PFAN") 
	PFAN("PFAN", null),
	
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
	 * TIBO
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
	private static Map<String, FloatingRateIndex1Code> values;
	static {
        Map<String, FloatingRateIndex1Code> map = new ConcurrentHashMap<>();
		for (FloatingRateIndex1Code instance : FloatingRateIndex1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FloatingRateIndex1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FloatingRateIndex1Code fromDisplayName(String name) {
		FloatingRateIndex1Code value = values.get(name);
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
