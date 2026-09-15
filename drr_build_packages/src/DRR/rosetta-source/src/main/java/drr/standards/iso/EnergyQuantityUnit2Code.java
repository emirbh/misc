package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies an energy quantity unit.
 * @version 7.7.0
 */
@RosettaEnum("EnergyQuantityUnit2Code")
public enum EnergyQuantityUnit2Code {

	/**
	 * British Thermal Unit Per Day
	 */
	@RosettaEnumValue(value = "BTUD") 
	BTUD("BTUD", null),
	
	/**
	 * Cm per day.
	 */
	@RosettaEnumValue(value = "CMPD") 
	CMPD("CMPD", null),
	
	/**
	 * GigaJoule Per Day.
	 */
	@RosettaEnumValue(value = "GJDD") 
	GJDD("GJDD", null),
	
	/**
	 * Giga Watt.
	 */
	@RosettaEnumValue(value = "GWAT") 
	GWAT("GWAT", null),
	
	/**
	 * Giga Watt hour per day.
	 */
	@RosettaEnumValue(value = "GWHD") 
	GWHD("GWHD", null),
	
	/**
	 * Giga Watt hour per hour.
	 */
	@RosettaEnumValue(value = "GWHH") 
	GWHH("GWHH", null),
	
	/**
	 * Hundred MegaJoule Per Day.
	 */
	@RosettaEnumValue(value = "HMJD") 
	HMJD("HMJD", null),
	
	/**
	 * KTherm per day.
	 */
	@RosettaEnumValue(value = "KTMD") 
	KTMD("KTMD", null),
	
	/**
	 * Kilo Watt.
	 */
	@RosettaEnumValue(value = "KWAT") 
	KWAT("KWAT", null),
	
	/**
	 * Kilo Watt hour per day.
	 */
	@RosettaEnumValue(value = "KWHD") 
	KWHD("KWHD", null),
	
	/**
	 * Kilo Watt hour per hour.
	 */
	@RosettaEnumValue(value = "KWHH") 
	KWHH("KWHH", null),
	
	/**
	 * Mcm per day.
	 */
	@RosettaEnumValue(value = "MCMD") 
	MCMD("MCMD", null),
	
	/**
	 * MegaJoule Per Day.
	 */
	@RosettaEnumValue(value = "MJDD") 
	MJDD("MJDD", null),
	
	/**
	 * Million British Thermal Unit Per Day.
	 */
	@RosettaEnumValue(value = "MBTD") 
	MBTD("MBTD", null),
	
	/**
	 * Million MegaJoule Per Day.
	 */
	@RosettaEnumValue(value = "MMJD") 
	MMJD("MMJD", null),
	
	/**
	 * MTherm per day.
	 */
	@RosettaEnumValue(value = "MTMD") 
	MTMD("MTMD", null),
	
	/**
	 * Mega Watt.
	 */
	@RosettaEnumValue(value = "MWAT") 
	MWAT("MWAT", null),
	
	/**
	 * Mega Watt hour per day.
	 */
	@RosettaEnumValue(value = "MWHD") 
	MWHD("MWHD", null),
	
	/**
	 * Mega Watt hour per hour.
	 */
	@RosettaEnumValue(value = "MWHH") 
	MWHH("MWHH", null),
	
	/**
	 * Therm per day.
	 */
	@RosettaEnumValue(value = "THMD") 
	THMD("THMD", null)
;
	private static Map<String, EnergyQuantityUnit2Code> values;
	static {
        Map<String, EnergyQuantityUnit2Code> map = new ConcurrentHashMap<>();
		for (EnergyQuantityUnit2Code instance : EnergyQuantityUnit2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnergyQuantityUnit2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnergyQuantityUnit2Code fromDisplayName(String name) {
		EnergyQuantityUnit2Code value = values.get(name);
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
