package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbCFIDeliveryTypeEnum")
public enum AnnaDsbCFIDeliveryTypeEnum {

	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Auction", displayName = "Auction") 
	AUCTION("Auction", "Auction"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Cash", displayName = "Cash") 
	CASH("Cash", "Cash"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Elect_at_Exercise", displayName = "Elect at Exercise") 
	ELECT_AT_EXERCISE("Elect_at_Exercise", "Elect at Exercise"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Elect_at_Settlement", displayName = "Elect at Settlement") 
	ELECT_AT_SETTLEMENT("Elect_at_Settlement", "Elect at Settlement"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Non_Deliverable", displayName = "Non-Deliverable") 
	NON_DELIVERABLE("Non_Deliverable", "Non-Deliverable"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Physical", displayName = "Physical") 
	PHYSICAL("Physical", "Physical")
;
	private static Map<String, AnnaDsbCFIDeliveryTypeEnum> values;
	static {
        Map<String, AnnaDsbCFIDeliveryTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbCFIDeliveryTypeEnum instance : AnnaDsbCFIDeliveryTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbCFIDeliveryTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbCFIDeliveryTypeEnum fromDisplayName(String name) {
		AnnaDsbCFIDeliveryTypeEnum value = values.get(name);
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
