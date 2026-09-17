package cdm.base.staticdata.asset.commodity;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies the grade of physical commodity product to be delivered.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/commodity-oil-product-grade"
 *
 * Provision 
 *
 */
@RosettaEnum("ProductGradeEnum")
public enum ProductGradeEnum {

	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_0_1_Percent", displayName = "0.1-Percent") 
	_0_1_PERCENT("_0_1_Percent", "0.1-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_0_5_Percent", displayName = "0.5-Percent") 
	_0_5_PERCENT("_0_5_Percent", "0.5-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_1_0_Percent", displayName = "1.0-Percent") 
	_1_0_PERCENT("_1_0_Percent", "1.0-Percent"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_10_PPM", displayName = "10-PPM") 
	_10_PPM("_10_PPM", "10-PPM"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_10_PPM_95_R", displayName = "10-PPM-95-R") 
	_10_PPM_95_R("_10_PPM_95_R", "10-PPM-95-R"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_10_PPM_Premium_Unleaded", displayName = "10-PPM-Premium-Unleaded") 
	_10_PPM_PREMIUM_UNLEADED("_10_PPM_Premium_Unleaded", "10-PPM-Premium-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_10_PPM_Regular_Unleaded", displayName = "10-PPM-Regular-Unleaded") 
	_10_PPM_REGULAR_UNLEADED("_10_PPM_Regular_Unleaded", "10-PPM-Regular-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_180_CST", displayName = "180-CST") 
	_180_CST("_180_CST", "180-CST"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_3_5_Percent", displayName = "3.5-Percent") 
	_3_5_PERCENT("_3_5_Percent", "3.5-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_380_CST", displayName = "380-CST") 
	_380_CST("_380_CST", "380-CST"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "_50_PPM", displayName = "50-PPM") 
	_50_PPM("_50_PPM", "50-PPM"),
	
	/**
	 * Applies to Oil Product Type Jet Fuel.
	 */
	@RosettaEnumValue(value = "_54", displayName = "54") 
	_54("_54", "54"),
	
	/**
	 * Applies to Oil Product Type Jet Fuel.
	 */
	@RosettaEnumValue(value = "_55", displayName = "55") 
	_55("_55", "55"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_87_M", displayName = "87-M") 
	_87_M("_87_M", "87-M"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_87_Unleaded", displayName = "87-Unleaded") 
	_87_UNLEADED("_87_Unleaded", "87-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_87_Unleaded_ULS_30", displayName = "87-Unleaded-ULS-30") 
	_87_UNLEADED_ULS_30("_87_Unleaded_ULS_30", "87-Unleaded-ULS-30"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_92_Unleaded", displayName = "92-Unleaded") 
	_92_UNLEADED("_92_Unleaded", "92-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_93_Unleaded", displayName = "93-Unleaded") 
	_93_UNLEADED("_93_Unleaded", "93-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_95_Unleaded", displayName = "95-Unleaded") 
	_95_UNLEADED("_95_Unleaded", "95-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_97_Unleaded", displayName = "97-Unleaded") 
	_97_UNLEADED("_97_Unleaded", "97-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "_98_Unleaded", displayName = "98-Unleaded") 
	_98_UNLEADED("_98_Unleaded", "98-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Arabian_Light", displayName = "Arabian-Light") 
	ARABIAN_LIGHT("Arabian_Light", "Arabian-Light"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Brass_Blend", displayName = "Brass-Blend") 
	BRASS_BLEND("Brass_Blend", "Brass-Blend"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Brent") 
	BRENT("Brent", null),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "CARBOB") 
	CARBOB("CARBOB", null),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "CBOB") 
	CBOB("CBOB", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Cold_Lake", displayName = "Cold-Lake") 
	COLD_LAKE("Cold_Lake", "Cold-Lake"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Dubai") 
	DUBAI("Dubai", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Edmonton_High_Sulphur_Sour", displayName = "Edmonton-High-Sulphur-Sour") 
	EDMONTON_HIGH_SULPHUR_SOUR("Edmonton_High_Sulphur_Sour", "Edmonton-High-Sulphur-Sour"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "EUROBOB") 
	EUROBOB("EUROBOB", null),
	
	/**
	 * Applies to Oil Product Type Diesel Fuel.
	 */
	@RosettaEnumValue(value = "German_10PPM", displayName = "German-10PPM") 
	GERMAN_10_PPM("German_10PPM", "German-10PPM"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Gulf_Coast_Sweet", displayName = "Gulf-Coast-Sweet") 
	GULF_COAST_SWEET("Gulf_Coast_Sweet", "Gulf-Coast-Sweet"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Hardisty_Light", displayName = "Hardisty-Light") 
	HARDISTY_LIGHT("Hardisty_Light", "Hardisty-Light"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Iranian_Light_1", displayName = "Iranian-Light") 
	IRANIAN_LIGHT_1("Iranian_Light_1", "Iranian-Light"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Iranian_Light", displayName = "Iranian-Light") 
	IRANIAN_LIGHT("Iranian_Light", "Iranian-Light"),
	
	/**
	 * Applies to Oil Product Type Jet Fuel.
	 */
	@RosettaEnumValue(value = "Jet") 
	JET("Jet", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Kirkuk_Light", displayName = "Kirkuk-Light") 
	KIRKUK_LIGHT("Kirkuk_Light", "Kirkuk-Light"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Kuwait") 
	KUWAIT("Kuwait", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Light_Louisiana_Sweet", displayName = "Light-Louisiana-Sweet") 
	LIGHT_LOUISIANA_SWEET("Light_Louisiana_Sweet", "Light-Louisiana-Sweet"),
	
	/**
	 * Applies to Oil Product Type Diesel Fuel.
	 */
	@RosettaEnumValue(value = "Low_Sulphur", displayName = "Low-Sulphur") 
	LOW_SULPHUR("Low_Sulphur", "Low-Sulphur"),
	
	/**
	 * Applies to Oil Product Type Jet Fuel.
	 */
	@RosettaEnumValue(value = "Low_Sulphur_Jet", displayName = "Low-Sulphur-Jet") 
	LOW_SULPHUR_JET("Low_Sulphur_Jet", "Low-Sulphur-Jet"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Mars") 
	MARS("Mars", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Mixed_Sour_Blend", displayName = "Mixed-Sour-Blend") 
	MIXED_SOUR_BLEND("Mixed_Sour_Blend", "Mixed-Sour-Blend"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Mixed_Sweet_Blend", displayName = "Mixed-Sweet-Blend") 
	MIXED_SWEET_BLEND("Mixed_Sweet_Blend", "Mixed-Sweet-Blend"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Murban") 
	MURBAN("Murban", null),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "Natural_Gasoline", displayName = "Natural-Gasoline") 
	NATURAL_GASOLINE("Natural_Gasoline", "Natural-Gasoline"),
	
	/**
	 * Applies to Oil Product Type Diesel Fuel.
	 */
	@RosettaEnumValue(value = "No__2", displayName = "No.-2") 
	NO_2("No__2", "No.-2"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_0_3_Percent", displayName = "No.-6-0.3-Percent") 
	NO_6_0_3_PERCENT("No__6_0_3_Percent", "No.-6-0.3-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_0_3_Percent_HP", displayName = "No.-6-0.3-Percent-HP") 
	NO_6_0_3_PERCENT_HP("No__6_0_3_Percent_HP", "No.-6-0.3-Percent-HP"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_0_3_Percent_LP", displayName = "No.-6-0.3-Percent-LP") 
	NO_6_0_3_PERCENT_LP("No__6_0_3_Percent_LP", "No.-6-0.3-Percent-LP"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_0_7_Percent", displayName = "No.-6-0.7-Percent") 
	NO_6_0_7_PERCENT("No__6_0_7_Percent", "No.-6-0.7-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_1_0_Percent", displayName = "No.-6-1.0-Percent") 
	NO_6_1_0_PERCENT("No__6_1_0_Percent", "No.-6-1.0-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_2_2_Percent", displayName = "No.-6-2.2-Percent") 
	NO_6_2_2_PERCENT("No__6_2_2_Percent", "No.-6-2.2-Percent"),
	
	/**
	 * Applies to Oil Product Type Fuel Oil.
	 */
	@RosettaEnumValue(value = "No__6_3_Percent", displayName = "No.-6-3-Percent") 
	NO_6_3_PERCENT("No__6_3_Percent", "No.-6-3-Percent"),
	
	/**
	 * Applies to Oil Product Type Butane.
	 */
	@RosettaEnumValue(value = "Normal_Butane", displayName = "Normal-Butane") 
	NORMAL_BUTANE("Normal_Butane", "Normal-Butane"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "North_Dakota_Light", displayName = "North-Dakota-Light") 
	NORTH_DAKOTA_LIGHT("North_Dakota_Light", "North-Dakota-Light"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Oman") 
	OMAN("Oman", null),
	
	/**
	 * Applies to Oil Product Type Propylene.
	 */
	@RosettaEnumValue(value = "Polymer_Grade", displayName = "Polymer-Grade") 
	POLYMER_GRADE("Polymer_Grade", "Polymer-Grade"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "RBOB") 
	RBOB("RBOB", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Saharan") 
	SAHARAN("Saharan", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Sour") 
	SOUR("Sour", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Southern_Green_Canyon", displayName = "Southern-Green-Canyon") 
	SOUTHERN_GREEN_CANYON("Southern_Green_Canyon", "Southern-Green-Canyon"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Tapis") 
	TAPIS("Tapis", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Thunder_Horse", displayName = "Thunder-Horse") 
	THUNDER_HORSE("Thunder_Horse", "Thunder-Horse"),
	
	/**
	 * Applies to Oil Product Type Diesel Fuel.
	 */
	@RosettaEnumValue(value = "Ultra_Low_Sulphur", displayName = "Ultra-Low-Sulphur") 
	ULTRA_LOW_SULPHUR("Ultra_Low_Sulphur", "Ultra-Low-Sulphur"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Urals") 
	URALS("Urals", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Urals_Sour", displayName = "Urals-Sour") 
	URALS_SOUR("Urals_Sour", "Urals-Sour"),
	
	/**
	 * Applies to Oil Product Type Gasoline.
	 */
	@RosettaEnumValue(value = "US_Regular_Unleaded", displayName = "US-Regular-Unleaded") 
	US_REGULAR_UNLEADED("US_Regular_Unleaded", "US-Regular-Unleaded"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Western_Canadian_Select", displayName = "Western-Canadian-Select") 
	WESTERN_CANADIAN_SELECT("Western_Canadian_Select", "Western-Canadian-Select"),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "WTI") 
	WTI("WTI", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "WTS") 
	WTS("WTS", null),
	
	/**
	 * Applies to Oil Product Type Oil.
	 */
	@RosettaEnumValue(value = "Zuetina") 
	ZUETINA("Zuetina", null)
;
	private static Map<String, ProductGradeEnum> values;
	static {
        Map<String, ProductGradeEnum> map = new ConcurrentHashMap<>();
		for (ProductGradeEnum instance : ProductGradeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ProductGradeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ProductGradeEnum fromDisplayName(String name) {
		ProductGradeEnum value = values.get(name);
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
