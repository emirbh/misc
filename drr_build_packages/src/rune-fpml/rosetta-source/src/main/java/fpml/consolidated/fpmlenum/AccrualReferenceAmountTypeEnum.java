package fpml.consolidated.fpmlenum;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaEnum("AccrualReferenceAmountTypeEnum")
public enum AccrualReferenceAmountTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Commitment") 
	COMMITMENT("Commitment", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Funded") 
	FUNDED("Funded", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Unfunded") 
	UNFUNDED("Unfunded", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Unutilized") 
	UNUTILIZED("Unutilized", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	@RosettaEnumValue(value = "Utilized") 
	UTILIZED("Utilized", null)
;
	private static Map<String, AccrualReferenceAmountTypeEnum> values;
	static {
        Map<String, AccrualReferenceAmountTypeEnum> map = new ConcurrentHashMap<>();
		for (AccrualReferenceAmountTypeEnum instance : AccrualReferenceAmountTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AccrualReferenceAmountTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AccrualReferenceAmountTypeEnum fromDisplayName(String name) {
		AccrualReferenceAmountTypeEnum value = values.get(name);
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
