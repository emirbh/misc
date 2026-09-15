package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the financial entity classification of a party under the CFTC.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/cftc-entity-classification"
 *
 * Provision 
 *
 */
@RosettaEnum("CFTCFinancialEntityClassificationEnum")
public enum CFTCFinancialEntityClassificationEnum {

	/**
	 * A commodity pool as defined in CFTC CEA  2(h)(7)(C).
	 */
	@RosettaEnumValue(value = "CommodityPool") 
	COMMODITY_POOL("CommodityPool", null),
	
	/**
	 * An employee benefit plan as defined in paragraphs (3) and (32) of section 1002 of title 29 of the Commodity Exchange Act (CEA).
	 */
	@RosettaEnumValue(value = "EmployeeBenefitPlan") 
	EMPLOYEE_BENEFIT_PLAN("EmployeeBenefitPlan", null),
	
	/**
	 * A person predominantly engaged in activities that are in the business of banking, or in activities that are financial in nature, as defined in section 1843(k) of title 12 of the Commodity Exchange Act (CEA).
	 */
	@RosettaEnumValue(value = "FinancialSectorPerson") 
	FINANCIAL_SECTOR_PERSON("FinancialSectorPerson", null),
	
	/**
	 * A major security based swap participant as defined in CFTC CEA  2(h)(7)(C).
	 */
	@RosettaEnumValue(value = "MSBSP") 
	MSBSP("MSBSP", null),
	
	/**
	 * A major swap participant as defined in CFTC CEA  2(h)(7)(C).
	 */
	@RosettaEnumValue(value = "MSP") 
	MSP("MSP", null),
	
	/**
	 * None of the other codes apply.
	 */
	@RosettaEnumValue(value = "None") 
	NONE("None", null),
	
	/**
	 * A private fund as defined in section 80b-2(a) of title 15 of the Commodity Exchange Act (CEA).
	 */
	@RosettaEnumValue(value = "PrivateFund") 
	PRIVATE_FUND("PrivateFund", null),
	
	/**
	 * A security-based swap dealer as defined in CFTC CEA  2(h)(7)(C).
	 */
	@RosettaEnumValue(value = "SBSD") 
	SBSD("SBSD", null),
	
	/**
	 * A swap dealer as defined in CFTC CEA  2(h)(7)(C).
	 */
	@RosettaEnumValue(value = "SD") 
	SD("SD", null)
;
	private static Map<String, CFTCFinancialEntityClassificationEnum> values;
	static {
        Map<String, CFTCFinancialEntityClassificationEnum> map = new ConcurrentHashMap<>();
		for (CFTCFinancialEntityClassificationEnum instance : CFTCFinancialEntityClassificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CFTCFinancialEntityClassificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CFTCFinancialEntityClassificationEnum fromDisplayName(String name) {
		CFTCFinancialEntityClassificationEnum value = values.get(name);
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
