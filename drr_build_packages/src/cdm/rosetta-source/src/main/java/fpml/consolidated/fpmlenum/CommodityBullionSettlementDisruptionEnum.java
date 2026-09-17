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
@RosettaEnum("CommodityBullionSettlementDisruptionEnum")
public enum CommodityBullionSettlementDisruptionEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Negotiation") 
	NEGOTIATION("Negotiation", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Cancellation_and_Payment", displayName = "Cancellation and Payment") 
	CANCELLATION_AND_PAYMENT("Cancellation_and_Payment", "Cancellation and Payment")
;
	private static Map<String, CommodityBullionSettlementDisruptionEnum> values;
	static {
        Map<String, CommodityBullionSettlementDisruptionEnum> map = new ConcurrentHashMap<>();
		for (CommodityBullionSettlementDisruptionEnum instance : CommodityBullionSettlementDisruptionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityBullionSettlementDisruptionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityBullionSettlementDisruptionEnum fromDisplayName(String name) {
		CommodityBullionSettlementDisruptionEnum value = values.get(name);
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
