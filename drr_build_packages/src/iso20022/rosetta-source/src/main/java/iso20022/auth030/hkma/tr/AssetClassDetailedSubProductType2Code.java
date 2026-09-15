package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Softs.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType2Code")
public enum AssetClassDetailedSubProductType2Code {

	/**
	 * Commodity attribute of type robusta coffee.
	 */
	@RosettaEnumValue(value = "ROBU") 
	ROBU("ROBU", null),
	
	/**
	 * Commodity attribute of type cocoa.
	 */
	@RosettaEnumValue(value = "CCOA") 
	CCOA("CCOA", null),
	
	/**
	 * Commodity attribute of type raw sugar.
	 */
	@RosettaEnumValue(value = "BRWN") 
	BRWN("BRWN", null),
	
	/**
	 * Commodity attribute of type white sugar.
	 */
	@RosettaEnumValue(value = "WHSG") 
	WHSG("WHSG", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType2Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType2Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType2Code instance : AssetClassDetailedSubProductType2Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType2Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType2Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType2Code value = values.get(name);
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
