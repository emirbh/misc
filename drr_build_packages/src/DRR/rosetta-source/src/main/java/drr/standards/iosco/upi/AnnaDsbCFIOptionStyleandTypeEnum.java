package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbCFIOptionStyleandTypeEnum")
public enum AnnaDsbCFIOptionStyleandTypeEnum {

	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "American_Call", displayName = "American-Call") 
	AMERICAN_CALL("American_Call", "American-Call"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "American_Chooser", displayName = "American-Chooser") 
	AMERICAN_CHOOSER("American_Chooser", "American-Chooser"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "American_Put", displayName = "American-Put") 
	AMERICAN_PUT("American_Put", "American-Put"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Bermudan_Call", displayName = "Bermudan-Call") 
	BERMUDAN_CALL("Bermudan_Call", "Bermudan-Call"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Bermudan_Chooser", displayName = "Bermudan-Chooser") 
	BERMUDAN_CHOOSER("Bermudan_Chooser", "Bermudan-Chooser"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "Bermudan_Put", displayName = "Bermudan-Put") 
	BERMUDAN_PUT("Bermudan_Put", "Bermudan-Put"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "European_Call", displayName = "European-Call") 
	EUROPEAN_CALL("European_Call", "European-Call"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "European_Chooser", displayName = "European-Chooser") 
	EUROPEAN_CHOOSER("European_Chooser", "European-Chooser"),
	
	/**
	 * As defined by CFI Code: ISO 10962
	 */
	@RosettaEnumValue(value = "European_Put", displayName = "European-Put") 
	EUROPEAN_PUT("European_Put", "European-Put")
;
	private static Map<String, AnnaDsbCFIOptionStyleandTypeEnum> values;
	static {
        Map<String, AnnaDsbCFIOptionStyleandTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbCFIOptionStyleandTypeEnum instance : AnnaDsbCFIOptionStyleandTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbCFIOptionStyleandTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbCFIOptionStyleandTypeEnum fromDisplayName(String name) {
		AnnaDsbCFIOptionStyleandTypeEnum value = values.get(name);
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
