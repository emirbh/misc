package drr.base.qualification.event;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ReportableActionEnum")
public enum ReportableActionEnum {

	/**
	 * An action of cancellation of a wrongly submitted entire transaction in case it never came into existence or was not subject to the reporting requirements but was reported erroneously, or a cancellation of duplicate report.
	 */
	@RosettaEnumValue(value = "Error") 
	ERROR("Error", null),
	
	/**
	 * A report correcting the erroneous data fields of a previously submitted report.
	 */
	@RosettaEnumValue(value = "Correct") 
	CORRECT("Correct", null),
	
	/**
	 * An action that reinstates a swap transaction that was reported as error on terminated by mistake.
	 */
	@RosettaEnumValue(value = "Revive") 
	REVIVE("Revive", null),
	
	/**
	 * An action that transfers swap transaction from one SDR to another SOR (change of swap data repository).
	 */
	@RosettaEnumValue(value = "TransferOut") 
	TRANSFER_OUT("TransferOut", null),
	
	/**
	 * An upgrade of an outstanding transaction performed in order to ensure its conformity with the amended reporting requirements.
	 */
	@RosettaEnumValue(value = "Update") 
	UPDATE("Update", null),
	
	/**
	 * The process by which a swap is transferred to another SDR that has the effect of the closing of the suap transaction at one 50 or opening of the same swap transaction using the same UTI/USI in a different SDR (new).
	 */
	@RosettaEnumValue(value = "TransferIn") 
	TRANSFER_IN("TransferIn", null),
	
	/**
	 * An action that modifies the state of a previously submitted transaction or changes a term of a previously submitted transaction due to a newly negotiated modification or updates previously missing information. It does not include correction of a previous transaction.
	 */
	@RosettaEnumValue(value = "Modification") 
	MODIFICATION("Modification", null)
;
	private static Map<String, ReportableActionEnum> values;
	static {
        Map<String, ReportableActionEnum> map = new ConcurrentHashMap<>();
		for (ReportableActionEnum instance : ReportableActionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ReportableActionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ReportableActionEnum fromDisplayName(String name) {
		ReportableActionEnum value = values.get(name);
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
