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
 * Provision Defines which type of bullion is applicable for a Bullion Transaction.
 *
 */
@RosettaEnum("BullionTypeEnum")
public enum BullionTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Gold. Quality as per the Good Delivery Rules issued by the London Bullion Market Association.
	 *
	 */
	@RosettaEnumValue(value = "Gold") 
	GOLD("Gold", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Palladium. Quality as per the Good Delivery Rules issued by the London Platinum and Palladium Market.
	 *
	 */
	@RosettaEnumValue(value = "Palladium") 
	PALLADIUM("Palladium", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Palladium. Quality as per the Good Delivery Rules issued by the London Platinum and Palladium Market.
	 *
	 */
	@RosettaEnumValue(value = "Platinum") 
	PLATINUM("Platinum", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Silver. Quality as per the Good Delivery Rules issued by the London Bullion Market Association.
	 *
	 */
	@RosettaEnumValue(value = "Silver") 
	SILVER("Silver", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quality as per the Good Delivery Rules for Rhodium.
	 *
	 */
	@RosettaEnumValue(value = "Rhodium") 
	RHODIUM("Rhodium", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "RhodiumSponge") 
	RHODIUM_SPONGE("RhodiumSponge", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quality as per the Good Delivery Rules for Iridium.
	 *
	 */
	@RosettaEnumValue(value = "Iridium") 
	IRIDIUM("Iridium", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quality as per the Good Delivery Rules for Ruthenium.
	 *
	 */
	@RosettaEnumValue(value = "Ruthenium") 
	RUTHENIUM("Ruthenium", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quality as per the Good Delivery Rules for Osmium.
	 *
	 */
	@RosettaEnumValue(value = "Osmium") 
	OSMIUM("Osmium", null)
;
	private static Map<String, BullionTypeEnum> values;
	static {
        Map<String, BullionTypeEnum> map = new ConcurrentHashMap<>();
		for (BullionTypeEnum instance : BullionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BullionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BullionTypeEnum fromDisplayName(String name) {
		BullionTypeEnum value = values.get(name);
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
