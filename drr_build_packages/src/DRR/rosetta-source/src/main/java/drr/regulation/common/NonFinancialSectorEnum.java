package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Taxonomy for Non-Financial Counterparties. The categories below correspond to the main sections of NACE classification as defined in Regulation (EC) No 1893/2006 of the European Parliament and of the Council(10).
 * @version 7.7.0
 */
@RosettaEnum("NonFinancialSectorEnum")
public enum NonFinancialSectorEnum {

	/**
	 * Agriculture, forestry and fishing
	 */
	@RosettaEnumValue(value = "A") 
	A("A", null),
	
	/**
	 * Mining and quarrying
	 */
	@RosettaEnumValue(value = "B") 
	B("B", null),
	
	/**
	 * Manufacturing
	 */
	@RosettaEnumValue(value = "C") 
	C("C", null),
	
	/**
	 * Electricity, gas, steam and air conditioning supply
	 */
	@RosettaEnumValue(value = "D") 
	D("D", null),
	
	/**
	 * Water supply, sewerage, waste management and remediation activities. Note that &#39;E&#39; clashes with the DSL keyword for mathematics E notation, so the name is prefixed with character &#39;^&#39; to indicate that it is a name rather than keyword.
	 */
	@RosettaEnumValue(value = "E") 
	E("E", null),
	
	/**
	 * Construction
	 */
	@RosettaEnumValue(value = "F") 
	F("F", null),
	
	/**
	 * Wholesale and retail trade, repair of motor vehicles and motorcycles
	 */
	@RosettaEnumValue(value = "G") 
	G("G", null),
	
	/**
	 * Transportation and storage
	 */
	@RosettaEnumValue(value = "H") 
	H("H", null),
	
	/**
	 * Accommodation and food service activities
	 */
	@RosettaEnumValue(value = "I") 
	I("I", null),
	
	/**
	 * Information and communication
	 */
	@RosettaEnumValue(value = "J") 
	J("J", null),
	
	/**
	 * Financial and insurance activities
	 */
	@RosettaEnumValue(value = "K") 
	K("K", null),
	
	/**
	 * Real estate activities
	 */
	@RosettaEnumValue(value = "L") 
	L("L", null),
	
	/**
	 * Professional, scientific and technical activities
	 */
	@RosettaEnumValue(value = "M") 
	M("M", null),
	
	/**
	 * Administrative and support service activities
	 */
	@RosettaEnumValue(value = "N") 
	N("N", null),
	
	/**
	 * Public administration and defence; compulsory social security
	 */
	@RosettaEnumValue(value = "O") 
	O("O", null),
	
	/**
	 * Education
	 */
	@RosettaEnumValue(value = "P") 
	P("P", null),
	
	/**
	 * Human health and social work activities
	 */
	@RosettaEnumValue(value = "Q") 
	Q("Q", null),
	
	/**
	 * Arts, entertainment and recreation
	 */
	@RosettaEnumValue(value = "R") 
	R("R", null),
	
	/**
	 * Other service activities
	 */
	@RosettaEnumValue(value = "S") 
	S("S", null),
	
	/**
	 * Activities of households as employers; undifferentiated goods  and services  producing activities of households for own use
	 */
	@RosettaEnumValue(value = "T") 
	T("T", null),
	
	/**
	 * Activities of extraterritorial organizations and bodies
	 */
	@RosettaEnumValue(value = "U") 
	U("U", null)
;
	private static Map<String, NonFinancialSectorEnum> values;
	static {
        Map<String, NonFinancialSectorEnum> map = new ConcurrentHashMap<>();
		for (NonFinancialSectorEnum instance : NonFinancialSectorEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NonFinancialSectorEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NonFinancialSectorEnum fromDisplayName(String name) {
		NonFinancialSectorEnum value = values.get(name);
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
