package drr.base.trade;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration of the values specifying the method for confirmation of a transaction.
 * @version 7.7.0
 */
@RosettaEnum("ConfirmationMethodEnum")
public enum ConfirmationMethodEnum {

	/**
	 * Confirmation via a shared confirmation facility or platform, or a private/bilateral electronic system.
	 */
	@RosettaEnumValue(value = "Electronic") 
	ELECTRONIC("Electronic", null),
	
	/**
	 * Confirmation via a human-readable written document (possibly transmitted electronically).
	 */
	@RosettaEnumValue(value = "NonElectronic") 
	NON_ELECTRONIC("NonElectronic", null),
	
	/**
	 * This trade has not been confirmed and is not expected to be confirmed in any form. For example, this could include situations where the trade is an inter-affiliate trade and no confirmation is required, or cases were confirmation is negative only. For trades that have not yet been confirmed but are expected to be confirmed, one of the other values should be used.
	 */
	@RosettaEnumValue(value = "NotConfirmed") 
	NOT_CONFIRMED("NotConfirmed", null)
;
	private static Map<String, ConfirmationMethodEnum> values;
	static {
        Map<String, ConfirmationMethodEnum> map = new ConcurrentHashMap<>();
		for (ConfirmationMethodEnum instance : ConfirmationMethodEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ConfirmationMethodEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ConfirmationMethodEnum fromDisplayName(String name) {
		ConfirmationMethodEnum value = values.get(name);
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
