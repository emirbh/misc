package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the contract type of a derivative.
 * @version ${project.version}
 */
@RosettaEnum("FinancialInstrumentContractType2Code")
public enum FinancialInstrumentContractType2Code {

	/**
	 * Contract of type contracts for difference.
	 */
	@RosettaEnumValue(value = "CFDS") 
	CFDS("CFDS", null),
	
	/**
	 * Contract of type forward rate agreement.
	 */
	@RosettaEnumValue(value = "FRAS") 
	FRAS("FRAS", null),
	
	/**
	 * Contract of type future.
	 */
	@RosettaEnumValue(value = "FUTR") 
	FUTR("FUTR", null),
	
	/**
	 * Contract of type forward.
	 */
	@RosettaEnumValue(value = "FORW") 
	FORW("FORW", null),
	
	/**
	 * Contract of type option.
	 */
	@RosettaEnumValue(value = "OPTN") 
	OPTN("OPTN", null),
	
	/**
	 * Contract of type spread betting.
	 */
	@RosettaEnumValue(value = "SPDB") 
	SPDB("SPDB", null),
	
	/**
	 * Contract of type swap.
	 */
	@RosettaEnumValue(value = "SWAP") 
	SWAP("SWAP", null),
	
	/**
	 * Contract of type swaption.
	 */
	@RosettaEnumValue(value = "SWPT") 
	SWPT("SWPT", null),
	
	/**
	 * Contract of other financial instrument contract type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, FinancialInstrumentContractType2Code> values;
	static {
        Map<String, FinancialInstrumentContractType2Code> map = new ConcurrentHashMap<>();
		for (FinancialInstrumentContractType2Code instance : FinancialInstrumentContractType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FinancialInstrumentContractType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FinancialInstrumentContractType2Code fromDisplayName(String name) {
		FinancialInstrumentContractType2Code value = values.get(name);
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
