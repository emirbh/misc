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
 * Provision Describes how and when title to the commodity transfers.
 *
 */
@RosettaEnum("MetalTitleEnum")
public enum MetalTitleEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Transfers with Risk of Loss.
	 *
	 */
	@RosettaEnumValue(value = "TransfersWithRiskOfLoss") 
	TRANSFERS_WITH_RISK_OF_LOSS("TransfersWithRiskOfLoss", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Does Not Transfer with Risk of Loss.
	 *
	 */
	@RosettaEnumValue(value = "DoesNotTransferWithRiskOfLoss") 
	DOES_NOT_TRANSFER_WITH_RISK_OF_LOSS("DoesNotTransferWithRiskOfLoss", null)
;
	private static Map<String, MetalTitleEnum> values;
	static {
        Map<String, MetalTitleEnum> map = new ConcurrentHashMap<>();
		for (MetalTitleEnum instance : MetalTitleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MetalTitleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MetalTitleEnum fromDisplayName(String name) {
		MetalTitleEnum value = values.get(name);
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
