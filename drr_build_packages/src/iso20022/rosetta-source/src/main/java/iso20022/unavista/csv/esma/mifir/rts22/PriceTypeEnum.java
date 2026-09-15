package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies the unit type used for price
 * @version ${project.version}
 */
@RosettaEnum("PriceTypeEnum")
public enum PriceTypeEnum {

	/**
	 * Percentage
	 */
	@RosettaEnumValue(value = "Pctg") 
	PCTG("Pctg", null),
	
	/**
	 * Yield
	 */
	@RosettaEnumValue(value = "Yld") 
	YLD("Yld", null),
	
	/**
	 * Price pending
	 */
	@RosettaEnumValue(value = "PNDG") 
	PNDG("PNDG", null),
	
	/**
	 * Price not available
	 */
	@RosettaEnumValue(value = "NOAP") 
	NOAP("NOAP", null),
	
	/**
	 * Monetary value
	 */
	@RosettaEnumValue(value = "MntryValAmt") 
	MNTRY_VAL_AMT("MntryValAmt", null),
	
	/**
	 * Basis Points
	 */
	@RosettaEnumValue(value = "BsisPts") 
	BSIS_PTS("BsisPts", null)
;
	private static Map<String, PriceTypeEnum> values;
	static {
        Map<String, PriceTypeEnum> map = new ConcurrentHashMap<>();
		for (PriceTypeEnum instance : PriceTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PriceTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PriceTypeEnum fromDisplayName(String name) {
		PriceTypeEnum value = values.get(name);
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
