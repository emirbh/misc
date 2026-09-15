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
 * version "recordkeeping-5.13"
 *
 * Provision Environmental Product (e.g. allowance, certificate or unit).
 *
 */
@RosettaEnum("EnvironmentalProductTypeEnum")
public enum EnvironmentalProductTypeEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For EU Emissions Allowance Transactions: An EU Emissions Allowance.
	 *
	 */
	@RosettaEnumValue(value = "EUAllowance") 
	EU_ALLOWANCE("EUAllowance", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For EU Emissions Allowance Transactions: An EU Emissions Credit.
	 *
	 */
	@RosettaEnumValue(value = "EUCredit") 
	EU_CREDIT("EUCredit", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For EU Emissions Allowance Transactions: An EU Alternative Allowance.
	 *
	 */
	@RosettaEnumValue(value = "AlternativeAllowance") 
	ALTERNATIVE_ALLOWANCE("AlternativeAllowance", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: A limited authorization issued by the state permitting authority or the US Environmental Protection Agency (EPA) to emit certain amounts of nitrogen oxides (Nox).
	 *
	 */
	@RosettaEnumValue(value = "NOXEmissionsProduct") 
	NOX_EMISSIONS_PRODUCT("NOXEmissionsProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: A emissions allowance or emissions reduction credit issued under a mult-state or provincial or other cap-and-trade Scheme.
	 *
	 */
	@RosettaEnumValue(value = "RegionalEmissionsProduct") 
	REGIONAL_EMISSIONS_PRODUCT("RegionalEmissionsProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: A limited authorization issued by the RGGI scheme permitting the emission of certain amounts of carbon dioxide.
	 *
	 */
	@RosettaEnumValue(value = "RGGIEmissionsProduct") 
	RGGI_EMISSIONS_PRODUCT("RGGIEmissionsProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: A limited authorization issued by the U.S. Environmental Protection Agency (EPA) to emit a certain amount of sulfur dioxide.
	 *
	 */
	@RosettaEnumValue(value = "SO2EmissionsProduct") 
	SO_2_EMISSIONS_PRODUCT("SO2EmissionsProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: Any emissions allowance or emission reduction credit created and promulgated under a U.S. state Scheme.
	 *
	 */
	@RosettaEnumValue(value = "StateEmissionProduct") 
	STATE_EMISSION_PRODUCT("StateEmissionProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Emissions Allowance Transactions: Any emissions allowance, emission credit, emissions offset or emissions reduction credit created or issued under a voluntary Scheme.
	 *
	 */
	@RosettaEnumValue(value = "VoluntaryEmissionProduct") 
	VOLUNTARY_EMISSION_PRODUCT("VoluntaryEmissionProduct", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For US Renewable Energy Certificate Transactions: A Renewable Energy Certificate (“REC”) represents the environmental, social and other non-power qualities of generation of 1 megawatt-hour (MWh) of electricity from an eligible renewable energy resource.
	 *
	 */
	@RosettaEnumValue(value = "RenewableEnergyCertificate") 
	RENEWABLE_ENERGY_CERTIFICATE("RenewableEnergyCertificate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Australian Carbon Credit Unit.
	 *
	 */
	@RosettaEnumValue(value = "AUSCarbonCreditUnit") 
	AUS_CARBON_CREDIT_UNIT("AUSCarbonCreditUnit", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Australian Carbon Unit.
	 *
	 */
	@RosettaEnumValue(value = "AUSCarbonUnit") 
	AUS_CARBON_UNIT("AUSCarbonUnit", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Energy Savings Certificate.
	 *
	 */
	@RosettaEnumValue(value = "AUSEnergySavingCertificate") 
	AUS_ENERGY_SAVING_CERTIFICATE("AUSEnergySavingCertificate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Large-scale Generation Certificate.
	 *
	 */
	@RosettaEnumValue(value = "AUSLargeScaleGenerationCertificate") 
	AUS_LARGE_SCALE_GENERATION_CERTIFICATE("AUSLargeScaleGenerationCertificate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Small-scale Technology Certificate.
	 *
	 */
	@RosettaEnumValue(value = "AUSSmallScaleTechnologyCertificate") 
	AUS_SMALL_SCALE_TECHNOLOGY_CERTIFICATE("AUSSmallScaleTechnologyCertificate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Australia Green Energy: Victorian Energy Efficiency Certificate.
	 *
	 */
	@RosettaEnumValue(value = "AUSVictorianEnergyEfficiencyCertificate") 
	AUS_VICTORIAN_ENERGY_EFFICIENCY_CERTIFICATE("AUSVictorianEnergyEfficiencyCertificate", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Mexico CCFE CRT INTLODS Physical Certificates.
	 *
	 */
	@RosettaEnumValue(value = "MXCCFECRTINTLODS") 
	MXCCFECRTINTLODS("MXCCFECRTINTLODS", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision New Zealand Emissions Units.
	 *
	 */
	@RosettaEnumValue(value = "NZEmissionsUnits") 
	NZ_EMISSIONS_UNITS("NZEmissionsUnits", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision United Kingdom Ofgem Renewable Obligation Certificate.
	 *
	 */
	@RosettaEnumValue(value = "UKRenewableObligationCertificate") 
	UK_RENEWABLE_OBLIGATION_CERTIFICATE("UKRenewableObligationCertificate", null)
;
	private static Map<String, EnvironmentalProductTypeEnum> values;
	static {
        Map<String, EnvironmentalProductTypeEnum> map = new ConcurrentHashMap<>();
		for (EnvironmentalProductTypeEnum instance : EnvironmentalProductTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EnvironmentalProductTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EnvironmentalProductTypeEnum fromDisplayName(String name) {
		EnvironmentalProductTypeEnum value = values.get(name);
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
