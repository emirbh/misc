package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration representing the type of venue where a trade could be executed.
 * @version 7.7.0
 */
@RosettaEnum("MicMarketCategoryEnum")
public enum MicMarketCategoryEnum {

	/**
	 * Alternative Trading System
	 */
	@RosettaEnumValue(value = "ATSS") 
	ATSS("ATSS", null),
	
	/**
	 * Approved Publication Arrangement
	 */
	@RosettaEnumValue(value = "APPA") 
	APPA("APPA", null),
	
	/**
	 * Approved Reporting Mechanism
	 */
	@RosettaEnumValue(value = "ARMS") 
	ARMS("ARMS", null),
	
	/**
	 * Consolidated Tape Provider
	 */
	@RosettaEnumValue(value = "CTPS") 
	CTPS("CTPS", null),
	
	/**
	 * Crypto Asset Services Provider
	 */
	@RosettaEnumValue(value = "CASP") 
	CASP("CASP", null),
	
	/**
	 * Designated Contract Market
	 */
	@RosettaEnumValue(value = "DCMS") 
	DCMS("DCMS", null),
	
	/**
	 * Inter-Dealer Quotation System
	 */
	@RosettaEnumValue(value = "IDQS") 
	IDQS("IDQS", null),
	
	/**
	 * Multilateral Trading Facility
	 */
	@RosettaEnumValue(value = "MLTF") 
	MLTF("MLTF", null),
	
	/**
	 * Not Specified
	 */
	@RosettaEnumValue(value = "NSPD") 
	NSPD("NSPD", null),
	
	/**
	 * Organised Trading Facility
	 */
	@RosettaEnumValue(value = "OTFS") 
	OTFS("OTFS", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Recognised Market Operator
	 */
	@RosettaEnumValue(value = "RMOS") 
	RMOS("RMOS", null),
	
	/**
	 * Regulated Market
	 */
	@RosettaEnumValue(value = "RMKT") 
	RMKT("RMKT", null),
	
	/**
	 * Swap Execution Facility
	 */
	@RosettaEnumValue(value = "SEFS") 
	SEFS("SEFS", null),
	
	/**
	 * Systematic Internaliser
	 */
	@RosettaEnumValue(value = "SINT") 
	SINT("SINT", null),
	
	/**
	 * Trade Reporting Facility
	 */
	@RosettaEnumValue(value = "TRFS") 
	TRFS("TRFS", null)
;
	private static Map<String, MicMarketCategoryEnum> values;
	static {
        Map<String, MicMarketCategoryEnum> map = new ConcurrentHashMap<>();
		for (MicMarketCategoryEnum instance : MicMarketCategoryEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MicMarketCategoryEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MicMarketCategoryEnum fromDisplayName(String name) {
		MicMarketCategoryEnum value = values.get(name);
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
