package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the seniority type of a specific debt instrument.
 * @version ${project.version}
 */
@RosettaEnum("DebtInstrumentSeniorityType2Code")
public enum DebtInstrumentSeniorityType2Code {

	/**
	 * Debt owed to an unsecured creditor that can only be paid, in the event of a liquidation, after the claims of secured creditors have been met.
	 */
	@RosettaEnumValue(value = "SBOD") 
	SBOD("SBOD", null),
	
	/**
	 * Debt that takes priority over other unsecured or otherwise more junior debt owed by the issuer.
	 */
	@RosettaEnumValue(value = "SNDB") 
	SNDB("SNDB", null),
	
	/**
	 * Other type of debts.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, DebtInstrumentSeniorityType2Code> values;
	static {
        Map<String, DebtInstrumentSeniorityType2Code> map = new ConcurrentHashMap<>();
		for (DebtInstrumentSeniorityType2Code instance : DebtInstrumentSeniorityType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DebtInstrumentSeniorityType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DebtInstrumentSeniorityType2Code fromDisplayName(String name) {
		DebtInstrumentSeniorityType2Code value = values.get(name);
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
