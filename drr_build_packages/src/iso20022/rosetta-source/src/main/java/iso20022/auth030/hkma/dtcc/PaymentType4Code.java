package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the type, or nature, of the payment.
 * @version ${project.version}
 */
@RosettaEnum("PaymentType4Code")
public enum PaymentType4Code {

	/**
	 * Transaction is an initial payment made by one of the counterparties  either to bring a transaction to fair value or for any other reason that may be the cause of an off-market transaction.
	 */
	@RosettaEnumValue(value = "UFRO") 
	UFRO("UFRO", null),
	
	/**
	 * Transaction is the final settlement payment made when a transaction is unwound prior to its end date or a payment that may result due to the full termination of derivative transaction(s).
	 */
	@RosettaEnumValue(value = "UWIN") 
	UWIN("UWIN", null),
	
	/**
	 * Transaction is an exchange of notional values for cross-currency swaps.
	 */
	@RosettaEnumValue(value = "PEXH") 
	PEXH("PEXH", null)
;
	private static Map<String, PaymentType4Code> values;
	static {
        Map<String, PaymentType4Code> map = new ConcurrentHashMap<>();
		for (PaymentType4Code instance : PaymentType4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PaymentType4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PaymentType4Code fromDisplayName(String name) {
		PaymentType4Code value = values.get(name);
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
