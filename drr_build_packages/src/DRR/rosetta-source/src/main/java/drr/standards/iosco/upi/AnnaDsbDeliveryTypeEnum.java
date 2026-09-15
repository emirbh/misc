package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbDeliveryTypeEnum")
public enum AnnaDsbDeliveryTypeEnum {

	/**
	 * an independently administered synthetic auction process on a set of defined deliverable obligations that sets a reference final price that can be used to facilitate cash settlement of all covered transactions following a credit event
	 */
	@RosettaEnumValue(value = "Auction", displayName = "Auction") 
	AUCTION("Auction", "Auction"),
	
	/**
	 * the discharge of an obligation by payment or receipt of a net cash amount instead of payment or delivery by both parties
	 */
	@RosettaEnumValue(value = "CASH") 
	CASH("CASH", null),
	
	/**
	 * the method of delivery of the underlying instrument when the option is exercised shall be determined at the time of exercise
	 */
	@RosettaEnumValue(value = "Elect_at_Exercise", displayName = "Elect at Exercise") 
	ELECT_AT_EXERCISE("Elect_at_Exercise", "Elect at Exercise"),
	
	/**
	 * determined at the time of settlement
	 */
	@RosettaEnumValue(value = "Elect_at_Settlement", displayName = "Elect at Settlement") 
	ELECT_AT_SETTLEMENT("Elect_at_Settlement", "Elect at Settlement"),
	
	/**
	 * as defined by CFI code: ISO 10962 (2015)
	 */
	@RosettaEnumValue(value = "Non_Deliverable", displayName = "Non-Deliverable") 
	NON_DELIVERABLE("Non_Deliverable", "Non-Deliverable"),
	
	/**
	 * the method of delivery of the underlying instrument when the option is exercised shall be determined at the time of exercise
	 */
	@RosettaEnumValue(value = "OPTL") 
	OPTL("OPTL", null),
	
	/**
	 * the meeting of a settlement obligation under a derivative contract through the receipt or delivery of the actual underlying instrument(s) instead of through cash settlement
	 */
	@RosettaEnumValue(value = "PHYS") 
	PHYS("PHYS", null),
	
	/**
	 * the meeting of a settlement obligation under a derivative contract through the receipt or delivery of the actual underlying instrument(s) instead of through cash settlement
	 */
	@RosettaEnumValue(value = "Physical", displayName = "Physical") 
	PHYSICAL("Physical", "Physical")
;
	private static Map<String, AnnaDsbDeliveryTypeEnum> values;
	static {
        Map<String, AnnaDsbDeliveryTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbDeliveryTypeEnum instance : AnnaDsbDeliveryTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbDeliveryTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbDeliveryTypeEnum fromDisplayName(String name) {
		AnnaDsbDeliveryTypeEnum value = values.get(name);
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
