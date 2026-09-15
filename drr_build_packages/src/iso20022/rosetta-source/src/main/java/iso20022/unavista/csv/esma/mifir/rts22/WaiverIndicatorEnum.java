package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication as to whether the transaction was executed under a pre-trade waiver in accordance with Articles 4 and 9 of Regulation (EU) 600/2014
 * @version ${project.version}
 */
@RosettaEnum("WaiverIndicatorEnum")
public enum WaiverIndicatorEnum {

	/**
	 * reference price
	 */
	@RosettaEnumValue(value = "REPT") 
	REPT("REPT", null),
	
	/**
	 * negotiated liquid
	 */
	@RosettaEnumValue(value = "NLIC") 
	NLIC("NLIC", null),
	
	/**
	 * negotiated iliquid
	 */
	@RosettaEnumValue(value = "OILC") 
	OILC("OILC", null),
	
	/**
	 * negotiated conditions
	 */
	@RosettaEnumValue(value = "PRIC") 
	PRIC("PRIC", null),
	
	/**
	 * above especified size
	 */
	@RosettaEnumValue(value = "SIZE") 
	SIZE("SIZE", null),
	
	/**
	 * iliquid instrument
	 */
	@RosettaEnumValue(value = "ILQD") 
	ILQD("ILQD", null)
;
	private static Map<String, WaiverIndicatorEnum> values;
	static {
        Map<String, WaiverIndicatorEnum> map = new ConcurrentHashMap<>();
		for (WaiverIndicatorEnum instance : WaiverIndicatorEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WaiverIndicatorEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WaiverIndicatorEnum fromDisplayName(String name) {
		WaiverIndicatorEnum value = values.get(name);
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
