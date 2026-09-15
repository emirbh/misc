package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Reference to the master agreement type under which the counterparties concluded a derivative.
 * @version ${project.version}
 */
@RosettaEnum("MasterAgreementType2Code")
public enum MasterAgreementType2Code {

	/**
	 * Bilateral agreement.
	 */
	@RosettaEnumValue(value = "BIAG") 
	BIAG("BIAG", null),
	
	/**
	 * FIA-ISDA Cleared Derivatives Execution Agreement.
	 */
	@RosettaEnumValue(value = "CDEA") 
	CDEA("CDEA", null),
	
	/**
	 * Swiss Master Agreement.
	 */
	@RosettaEnumValue(value = "CHMA") 
	CHMA("CHMA", null),
	
	/**
	 * Contrato Marco de Operaciones Financieras.
	 */
	@RosettaEnumValue(value = "CMOP") 
	CMOP("CMOP", null),
	
	/**
	 * Deutscher Rahmenvertrag für Finanztermingeschäfte (DRV).
	 */
	@RosettaEnumValue(value = "DERV") 
	DERV("DERV", null),
	
	/**
	 * EFET Master Agreement.
	 */
	@RosettaEnumValue(value = "EFMA") 
	EFMA("EFMA", null),
	
	/**
	 * European Master Agreement.
	 */
	@RosettaEnumValue(value = "EUMA") 
	EUMA("EUMA", null),
	
	/**
	 * FBF Master Agreement relating to transactions on forward financial instruments.
	 */
	@RosettaEnumValue(value = "FMAT") 
	FMAT("FMAT", null),
	
	/**
	 * FOA Professional Client Agreement.
	 */
	@RosettaEnumValue(value = "FPCA") 
	FPCA("FPCA", null),
	
	/**
	 * GMRA.
	 */
	@RosettaEnumValue(value = "GMRA") 
	GMRA("GMRA", null),
	
	/**
	 * GMSLA.
	 */
	@RosettaEnumValue(value = "GMSL") 
	GMSL("GMSL", null),
	
	/**
	 * Islamic Derivative Master Agreement.
	 */
	@RosettaEnumValue(value = "IDMA") 
	IDMA("IDMA", null),
	
	/**
	 * ISDA.
	 */
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	/**
	 * If the master agreement type is not included in the above list.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, MasterAgreementType2Code> values;
	static {
        Map<String, MasterAgreementType2Code> map = new ConcurrentHashMap<>();
		for (MasterAgreementType2Code instance : MasterAgreementType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MasterAgreementType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MasterAgreementType2Code fromDisplayName(String name) {
		MasterAgreementType2Code value = values.get(name);
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
