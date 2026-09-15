package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the nature of the reporting counterparty business activities.
 * @version ${project.version}
 */
@RosettaEnum("FinancialPartySectorType3Code")
public enum FinancialPartySectorType3Code {

	/**
	 * Alternative investment fund managed by an alternative investment fund manager (AIFM).
	 */
	@RosettaEnumValue(value = "AIFD") 
	AIFD("AIFD", null),
	
	/**
	 * Central securities depository.
	 */
	@RosettaEnumValue(value = "CSDS") 
	CSDS("CSDS", null),
	
	/**
	 * Central counterparty.
	 */
	@RosettaEnumValue(value = "CCPS") 
	CCPS("CCPS", null),
	
	/**
	 * Credit institution that takes deposits or other repayable funds from the public and grants credits for its own account.
	 */
	@RosettaEnumValue(value = "CDTI") 
	CDTI("CDTI", null),
	
	/**
	 * Insurance undertaking.
	 */
	@RosettaEnumValue(value = "INUN") 
	INUN("INUN", null),
	
	/**
	 * Institution for occupational retirement provision established for the purpose of providing retirement benefits in the context of an occupational activity.
	 */
	@RosettaEnumValue(value = "ORPI") 
	ORPI("ORPI", null),
	
	/**
	 * Investment firm.
	 */
	@RosettaEnumValue(value = "INVF") 
	INVF("INVF", null),
	
	/**
	 * Reinsurance undertaking performing the activity of accepting risks ceded by an insurance undertaking or by another reinsurance undertaking.
	 */
	@RosettaEnumValue(value = "REIN") 
	REIN("REIN", null),
	
	/**
	 * Undertaking for collective investment in transferable securities (UCITS) and its management company.
	 */
	@RosettaEnumValue(value = "UCIT") 
	UCIT("UCIT", null),
	
	/**
	 * Assurance undertaking.
	 */
	@RosettaEnumValue(value = "ASSU") 
	ASSU("ASSU", null),
	
	/**
	 * Other type of financial institution.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, FinancialPartySectorType3Code> values;
	static {
        Map<String, FinancialPartySectorType3Code> map = new ConcurrentHashMap<>();
		for (FinancialPartySectorType3Code instance : FinancialPartySectorType3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FinancialPartySectorType3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FinancialPartySectorType3Code fromDisplayName(String name) {
		FinancialPartySectorType3Code value = values.get(name);
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
