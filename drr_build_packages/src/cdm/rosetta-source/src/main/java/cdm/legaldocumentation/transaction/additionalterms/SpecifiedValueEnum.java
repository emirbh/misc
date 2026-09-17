package cdm.legaldocumentation.transaction.additionalterms;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.4.(w)"
 *
 * Provision 
 *
 */
@RosettaEnum("SpecifiedValueEnum")
public enum SpecifiedValueEnum {

	@RosettaEnumValue(value = "OutstandingPrincipalBalance") 
	OUTSTANDING_PRINCIPAL_BALANCE("OutstandingPrincipalBalance", null),
	
	@RosettaEnumValue(value = "StatedPrincipalBalance") 
	STATED_PRINCIPAL_BALANCE("StatedPrincipalBalance", null),
	
	@RosettaEnumValue(value = "FaceValue") 
	FACE_VALUE("FaceValue", null),
	
	@RosettaEnumValue(value = "MarketValue") 
	MARKET_VALUE("MarketValue", null)
;
	private static Map<String, SpecifiedValueEnum> values;
	static {
        Map<String, SpecifiedValueEnum> map = new ConcurrentHashMap<>();
		for (SpecifiedValueEnum instance : SpecifiedValueEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SpecifiedValueEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SpecifiedValueEnum fromDisplayName(String name) {
		SpecifiedValueEnum value = values.get(name);
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
