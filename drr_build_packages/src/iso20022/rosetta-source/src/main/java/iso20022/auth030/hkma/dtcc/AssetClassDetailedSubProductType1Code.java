package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Grains Oil Seeds.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType1Code")
public enum AssetClassDetailedSubProductType1Code {

	/**
	 * Commodity attribute of type feed wheat.
	 */
	@RosettaEnumValue(value = "FWHT") 
	FWHT("FWHT", null),
	
	/**
	 * Commodity attribute of type soybeans.
	 */
	@RosettaEnumValue(value = "SOYB") 
	SOYB("SOYB", null),
	
	/**
	 * Commodity attribute of type rapeseed.
	 */
	@RosettaEnumValue(value = "RPSD") 
	RPSD("RPSD", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	/**
	 * Commodity attribute of type maize.
	 */
	@RosettaEnumValue(value = "CORN") 
	CORN("CORN", null),
	
	/**
	 * Commodity attribute of type rice.
	 */
	@RosettaEnumValue(value = "RICE") 
	RICE("RICE", null)
;
	private static Map<String, AssetClassDetailedSubProductType1Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType1Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType1Code instance : AssetClassDetailedSubProductType1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType1Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType1Code value = values.get(name);
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
