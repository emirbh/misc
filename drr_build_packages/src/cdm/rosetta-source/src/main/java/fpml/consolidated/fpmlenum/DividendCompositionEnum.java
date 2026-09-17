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
@RosettaEnum("DividendCompositionEnum")
public enum DividendCompositionEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "EquityAmountReceiverElection") 
	EQUITY_AMOUNT_RECEIVER_ELECTION("EquityAmountReceiverElection", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "CalculationAgentElection") 
	CALCULATION_AGENT_ELECTION("CalculationAgentElection", null)
;
	private static Map<String, DividendCompositionEnum> values;
	static {
        Map<String, DividendCompositionEnum> map = new ConcurrentHashMap<>();
		for (DividendCompositionEnum instance : DividendCompositionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendCompositionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendCompositionEnum fromDisplayName(String name) {
		DividendCompositionEnum value = values.get(name);
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
