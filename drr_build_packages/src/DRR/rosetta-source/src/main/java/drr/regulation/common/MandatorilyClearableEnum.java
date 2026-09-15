package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("MandatorilyClearableEnum")
public enum MandatorilyClearableEnum {

	/**
	 * The contract belongs to a class of OTC derivatives that has been declared subject to the clearing obligation and both counterparties to the contract are subject to the clearing obligation
	 */
	@RosettaEnumValue(value = "ProductAndCptyMandatory") 
	PRODUCT_AND_CPTY_MANDATORY("ProductAndCptyMandatory", null),
	
	/**
	 * The contract belongs to a class of OTC derivatives that has been declared subject to the clearing obligation but one or both counterparties to the contract are not subject to the clearing obligation or value
	 */
	@RosettaEnumValue(value = "ProductMandatoryButNotCpty") 
	PRODUCT_MANDATORY_BUT_NOT_CPTY("ProductMandatoryButNotCpty", null),
	
	/**
	 * The contract does not belong to a class of OTC derivatives that has been declared subject to the clearing obligation
	 */
	@RosettaEnumValue(value = "ProductNotMandatory") 
	PRODUCT_NOT_MANDATORY("ProductNotMandatory", null)
;
	private static Map<String, MandatorilyClearableEnum> values;
	static {
        Map<String, MandatorilyClearableEnum> map = new ConcurrentHashMap<>();
		for (MandatorilyClearableEnum instance : MandatorilyClearableEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MandatorilyClearableEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MandatorilyClearableEnum fromDisplayName(String name) {
		MandatorilyClearableEnum value = values.get(name);
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
