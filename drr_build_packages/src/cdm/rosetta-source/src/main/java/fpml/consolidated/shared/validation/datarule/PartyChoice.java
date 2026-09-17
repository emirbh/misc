package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessUnit;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.IndustryClassification;
import fpml.consolidated.shared.OrganizationType;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyGroupType;
import fpml.consolidated.shared.PartyId;
import fpml.consolidated.shared.PartyName;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.Region;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartyChoice")
@ImplementedBy(PartyChoice.Default.class)
public interface PartyChoice extends Validator<Party> {
	
	String NAME = "PartyChoice";
	String DEFINITION = "if partyId exists then groupType is absent and partyReference is absent else if groupType exists or partyReference exists then groupType exists and partyReference exists and partyId is absent and partyName is absent and classification is absent and creditRating is absent and country is absent and region is absent and jurisdiction is absent and organizationType is absent and contactInfo is absent and businessUnit is absent and person is absent else False";
	
	class Default implements PartyChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Party party) {
			ComparisonResult result = executeDataRule(party);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Party", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Party", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Party party) {
			try {
				if (exists(MapperS.of(party).<PartyId>mapC("getPartyId", _party -> _party.getPartyId())).getOrDefault(false)) {
					return notExists(MapperS.of(party).<PartyGroupType>map("getGroupType", _party -> _party.getGroupType())).andNullSafe(notExists(MapperS.of(party).<PartyReference>mapC("getPartyReference", _party -> _party.getPartyReference())));
				}
				if (exists(MapperS.of(party).<PartyGroupType>map("getGroupType", _party -> _party.getGroupType())).orNullSafe(exists(MapperS.of(party).<PartyReference>mapC("getPartyReference", _party -> _party.getPartyReference()))).getOrDefault(false)) {
					return exists(MapperS.of(party).<PartyGroupType>map("getGroupType", _party -> _party.getGroupType())).andNullSafe(exists(MapperS.of(party).<PartyReference>mapC("getPartyReference", _party -> _party.getPartyReference()))).andNullSafe(notExists(MapperS.of(party).<PartyId>mapC("getPartyId", _party -> _party.getPartyId()))).andNullSafe(notExists(MapperS.of(party).<PartyName>map("getPartyName", _party -> _party.getPartyName()))).andNullSafe(notExists(MapperS.of(party).<IndustryClassification>mapC("getClassification", _party -> _party.getClassification()))).andNullSafe(notExists(MapperS.of(party).<CreditRating>mapC("getCreditRating", _party -> _party.getCreditRating()))).andNullSafe(notExists(MapperS.of(party).<CountryCode>map("getCountry", _party -> _party.getCountry()))).andNullSafe(notExists(MapperS.of(party).<Region>mapC("getRegion", _party -> _party.getRegion()))).andNullSafe(notExists(MapperS.of(party).<GoverningLaw>mapC("getJurisdiction", _party -> _party.getJurisdiction()))).andNullSafe(notExists(MapperS.of(party).<OrganizationType>mapC("getOrganizationType", _party -> _party.getOrganizationType()))).andNullSafe(notExists(MapperS.of(party).<ContactInformation>map("getContactInfo", _party -> _party.getContactInfo()))).andNullSafe(notExists(MapperS.of(party).<BusinessUnit>mapC("getBusinessUnit", _party -> _party.getBusinessUnit()))).andNullSafe(notExists(MapperS.of(party).<Person>mapC("getPerson", _party -> _party.getPerson())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Party party) {
			return Collections.emptyList();
		}
	}
}
