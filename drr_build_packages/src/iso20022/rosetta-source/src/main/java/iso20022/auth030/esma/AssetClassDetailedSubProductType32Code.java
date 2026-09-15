package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Further sub product code list for commodity derivative Oil.
 * @version ${project.version}
 */
@RosettaEnum("AssetClassDetailedSubProductType32Code")
public enum AssetClassDetailedSubProductType32Code {

	/**
	 * Commodity attribute of type bakken.
	 */
	@RosettaEnumValue(value = "BAKK") 
	BAKK("BAKK", null),
	
	/**
	 * Commodity attribute of type biodiesel.
	 */
	@RosettaEnumValue(value = "BDSL") 
	BDSL("BDSL", null),
	
	/**
	 * Commodity attribute of type Brent.
	 */
	@RosettaEnumValue(value = "BRNT") 
	BRNT("BRNT", null),
	
	/**
	 * Commodity attribute of type Brent NX (New Expiry).
	 */
	@RosettaEnumValue(value = "BRNX") 
	BRNX("BRNX", null),
	
	/**
	 * Commodity attribute of type canadian.
	 */
	@RosettaEnumValue(value = "CNDA") 
	CNDA("CNDA", null),
	
	/**
	 * Commodity attribute of type condensate.
	 */
	@RosettaEnumValue(value = "COND") 
	COND("COND", null),
	
	/**
	 * Commodity attribute of type diesel.
	 */
	@RosettaEnumValue(value = "DSEL") 
	DSEL("DSEL", null),
	
	/**
	 * Commodity attribute of type Dubai.
	 */
	@RosettaEnumValue(value = "DUBA") 
	DUBA("DUBA", null),
	
	/**
	 * Commodity attribute of type ESPO (Eastern Siberia Pacific Ocean).
	 */
	@RosettaEnumValue(value = "ESPO") 
	ESPO("ESPO", null),
	
	/**
	 * Commodity attribute of type ethanol.
	 */
	@RosettaEnumValue(value = "ETHA") 
	ETHA("ETHA", null),
	
	/**
	 * Commodity attribute of type fuel.
	 */
	@RosettaEnumValue(value = "FUEL") 
	FUEL("FUEL", null),
	
	/**
	 * Commodity attribute of type fuel oil.
	 */
	@RosettaEnumValue(value = "FOIL") 
	FOIL("FOIL", null),
	
	/**
	 * Commodity attribute of type gasoil.
	 */
	@RosettaEnumValue(value = "GOIL") 
	GOIL("GOIL", null),
	
	/**
	 * Commodity attribute of type gasoline.
	 */
	@RosettaEnumValue(value = "GSLN") 
	GSLN("GSLN", null),
	
	/**
	 * Commodity attribute of type heating oil.
	 */
	@RosettaEnumValue(value = "HEAT") 
	HEAT("HEAT", null),
	
	/**
	 * Commodity attribute of type jet fuel.
	 */
	@RosettaEnumValue(value = "JTFL") 
	JTFL("JTFL", null),
	
	/**
	 * Commodity attribute of type kerosene.
	 */
	@RosettaEnumValue(value = "KERO") 
	KERO("KERO", null),
	
	/**
	 * Commodity attribute of type light Louisiana sweet (LLS).
	 */
	@RosettaEnumValue(value = "LLSO") 
	LLSO("LLSO", null),
	
	/**
	 * Commodity attribute of type mars.
	 */
	@RosettaEnumValue(value = "MARS") 
	MARS("MARS", null),
	
	/**
	 * Commodity attribute of type naptha.
	 */
	@RosettaEnumValue(value = "NAPH") 
	NAPH("NAPH", null),
	
	/**
	 * Commodity attribute of type NGL (Natural Gas Liquids).
	 */
	@RosettaEnumValue(value = "NGLO") 
	NGLO("NGLO", null),
	
	/**
	 * Commodity attribute of type tapis.
	 */
	@RosettaEnumValue(value = "TAPI") 
	TAPI("TAPI", null),
	
	/**
	 * Commodity attribute of type WTI (West Texas Intermediate).
	 */
	@RosettaEnumValue(value = "WTIO") 
	WTIO("WTIO", null),
	
	/**
	 * Commodity attribute of type urals.
	 */
	@RosettaEnumValue(value = "URAL") 
	URAL("URAL", null),
	
	/**
	 * Commodity attribute of other type.
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, AssetClassDetailedSubProductType32Code> values;
	static {
        Map<String, AssetClassDetailedSubProductType32Code> map = new ConcurrentHashMap<>();
		for (AssetClassDetailedSubProductType32Code instance : AssetClassDetailedSubProductType32Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetClassDetailedSubProductType32Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetClassDetailedSubProductType32Code fromDisplayName(String name) {
		AssetClassDetailedSubProductType32Code value = values.get(name);
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
