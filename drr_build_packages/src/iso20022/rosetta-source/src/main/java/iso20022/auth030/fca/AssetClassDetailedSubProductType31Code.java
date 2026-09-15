package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Natural Gas.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType31Code")
public enum AssetClassDetailedSubProductType31Code {

	/**
	 * Commodity attribute of type GASPOOL.
	 */
	@RosettaEnumValue(value = "GASP") 
	GASP("GASP", null),
	
	/**
	 * Commodity attribute of type liquid natural gas.
	 */
	@RosettaEnumValue(value = "LNGG") 
	LNGG("LNGG", null),
	
	/**
	 * Commodity attribute of type NCG (NetConnect Germany).
	 */
	@RosettaEnumValue(value = "NCGG") 
	NCGG("NCGG", null),
	
	/**
	 * Commodity attribute of type TTF (Dutch Title Transfer Facility).
	 */
	@RosettaEnumValue(value = "TTFG") 
	TTFG("TTFG", null),
	
	/**
	 * Commodity attribute of type NBP (National Balancing Point).
	 */
	@RosettaEnumValue(value = "NBPG") 
	NBPG("NBPG", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType31Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType31Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType31Code instance : AssetClassDetailedSubProductType31Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType31Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType31Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType31Code value = values.get(name);
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
