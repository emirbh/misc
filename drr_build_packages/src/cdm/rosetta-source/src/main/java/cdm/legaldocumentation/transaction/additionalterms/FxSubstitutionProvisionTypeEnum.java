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
 * section "5.2.(c)"
 *
 * Provision 
 *
 */
@RosettaEnum("FxSubstitutionProvisionTypeEnum")
public enum FxSubstitutionProvisionTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.2.(c)" * paragraph "(vi)"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LocalAssetSubstituteGross") 
	LOCAL_ASSET_SUBSTITUTE_GROSS("LocalAssetSubstituteGross", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.2.(c)" * paragraph "(vii)"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LocalAssetSubstituteNet") 
	LOCAL_ASSET_SUBSTITUTE_NET("LocalAssetSubstituteNet", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.2.(c)" * paragraph "(viii)"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "LocalCurrencySubstitute") 
	LOCAL_CURRENCY_SUBSTITUTE("LocalCurrencySubstitute", null)
;
	private static Map<String, FxSubstitutionProvisionTypeEnum> values;
	static {
        Map<String, FxSubstitutionProvisionTypeEnum> map = new ConcurrentHashMap<>();
		for (FxSubstitutionProvisionTypeEnum instance : FxSubstitutionProvisionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FxSubstitutionProvisionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FxSubstitutionProvisionTypeEnum fromDisplayName(String name) {
		FxSubstitutionProvisionTypeEnum value = values.get(name);
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
