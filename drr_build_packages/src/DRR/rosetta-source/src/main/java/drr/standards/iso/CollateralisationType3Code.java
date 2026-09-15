package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type of collateral agreement between two parties.
 * @version 7.7.0
 */
@RosettaEnum("CollateralisationType3Code")
public enum CollateralisationType3Code {

	/**
	 * The collateral agreement between the counterparties stipulates that both counterparties post initial margin and regularly post variation margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "FLCL") 
	FLCL("FLCL", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that both counterparties post initial margin and variation margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "OWCL") 
	OWCL("OWCL", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the reporting counterparty posts the initial margin and regularly posts variation margin and that the other counterparty does not post any margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "OWC1") 
	OWC1("OWC1", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the other counterparty posts the initial margin and regularly posts variation margin and that the reporting counterparty does not post any margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "OWC2") 
	OWC2("OWC2", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the reporting counterparty posts the initial margin and regularly posts variation margin and that the other counterparty regularly posts only variation margin.
	 */
	@RosettaEnumValue(value = "OWP1") 
	OWP1("OWP1", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the other counterparty posts the initial margin and regularly posts variation margin and that the reporting counterparty regularly posts only variation margin.
	 */
	@RosettaEnumValue(value = "OWP2") 
	OWP2("OWP2", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that both counterparties regularly post only variation margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "PRCL") 
	PRCL("PRCL", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the reporting counterparty regularly  posts only variation margin and that the other counterparty does not post any margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "PRC1") 
	PRC1("PRC1", null),
	
	/**
	 * The collateral agreement between the counterparties stipulates that the other counterparty regularly posts only variation margin and that the reporting counterparty does not post any margin with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "PRC2") 
	PRC2("PRC2", null),
	
	/**
	 * There is no collateral agreement between the counterparties or the collateral agreement between the counterparties stipulates that no collateral (neither initial margin nor variation margin) has to be posted with respect to the derivative transaction.
	 */
	@RosettaEnumValue(value = "UNCL") 
	UNCL("UNCL", null)
;
	private static Map<String, CollateralisationType3Code> values;
	static {
        Map<String, CollateralisationType3Code> map = new ConcurrentHashMap<>();
		for (CollateralisationType3Code instance : CollateralisationType3Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralisationType3Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralisationType3Code fromDisplayName(String name) {
		CollateralisationType3Code value = values.get(name);
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
