package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("FinancialInstrumentContractType2Code")
public enum FinancialInstrumentContractType2Code {

	@RosettaEnumValue(value = "CFDS") 
	CFDS("CFDS", null),
	
	@RosettaEnumValue(value = "FRAS") 
	FRAS("FRAS", null),
	
	@RosettaEnumValue(value = "FUTR") 
	FUTR("FUTR", null),
	
	@RosettaEnumValue(value = "FORW") 
	FORW("FORW", null),
	
	@RosettaEnumValue(value = "OPTN") 
	OPTN("OPTN", null),
	
	@RosettaEnumValue(value = "SPDB") 
	SPDB("SPDB", null),
	
	@RosettaEnumValue(value = "SWAP") 
	SWAP("SWAP", null),
	
	@RosettaEnumValue(value = "SWPT") 
	SWPT("SWPT", null),
	
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
