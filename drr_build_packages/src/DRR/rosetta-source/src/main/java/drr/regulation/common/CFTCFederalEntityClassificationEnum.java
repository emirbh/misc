package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the federal entity indicator of a party unde the CFTC
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/cftc-organization-type"
 *
 * Provision 
 *
 */
@RosettaEnum("CFTCFederalEntityClassificationEnum")
public enum CFTCFederalEntityClassificationEnum {

	/**
	 * An agency as defined in 5 U.S.C. 551(1), a federal instrumentality, or a federal authority.
	 */
	@RosettaEnumValue(value = "Agency") 
	AGENCY("Agency", null),
	
	/**
	 * An entity chartered pursuant to federal law after formation (example: an organization listed in title 36 of the U.S. Code).
	 */
	@RosettaEnumValue(value = "CharteredPursuantToFederalLaw") 
	CHARTERED_PURSUANT_TO_FEDERAL_LAW("CharteredPursuantToFederalLaw", null),
	
	/**
	 * An entity that was established by, or at the direction of, one or more of the entities listed in clause (1), or has an ultimate parent listed in its LEI reference data that is an entity listed in clause (1) or in the first part of this clause (2).
	 */
	@RosettaEnumValue(value = "EstablishedByFederalEntity") 
	ESTABLISHED_BY_FEDERAL_ENTITY("EstablishedByFederalEntity", null),
	
	/**
	 * A federally funded research and development center on the master list referenced in 48 CFR 35.017-6.
	 */
	@RosettaEnumValue(value = "FederallyFundedResearchAndDevelopmentCenter") 
	FEDERALLY_FUNDED_RESEARCH_AND_DEVELOPMENT_CENTER("FederallyFundedResearchAndDevelopmentCenter", null),
	
	/**
	 * A government corporation (examples: as such term is defined in 5 U.S.C. 103(1) or in 31 U.S.C. 9101).
	 */
	@RosettaEnumValue(value = "GovernmentCorporation") 
	GOVERNMENT_CORPORATION("GovernmentCorporation", null),
	
	/**
	 * A government-sponsored enterprise (example: as such term is defined in 2 U.S.C. 622(8)).
	 */
	@RosettaEnumValue(value = "GovernmentSponsoredEnterprise") 
	GOVERNMENT_SPONSORED_ENTERPRISE("GovernmentSponsoredEnterprise", null),
	
	/**
	 * An executive department listed in 5 U.S.C. 101.
	 */
	@RosettaEnumValue(value = "USCListedExecutiveDepartment") 
	USC_LISTED_EXECUTIVE_DEPARTMENT("USCListedExecutiveDepartment", null)
;
	private static Map<String, CFTCFederalEntityClassificationEnum> values;
	static {
        Map<String, CFTCFederalEntityClassificationEnum> map = new ConcurrentHashMap<>();
		for (CFTCFederalEntityClassificationEnum instance : CFTCFederalEntityClassificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CFTCFederalEntityClassificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CFTCFederalEntityClassificationEnum fromDisplayName(String name) {
		CFTCFederalEntityClassificationEnum value = values.get(name);
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
