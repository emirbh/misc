package cdm.base.staticdata.party.validation.datarule;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("NaturalPersonNameOrIdChoice")
@ImplementedBy(NaturalPersonNameOrIdChoice.Default.class)
public interface NaturalPersonNameOrIdChoice extends Validator<NaturalPerson> {
	
	String NAME = "NaturalPersonNameOrIdChoice";
	String DEFINITION = "(firstName exists and surname exists) or personId exists";
	
	class Default implements NaturalPersonNameOrIdChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPerson naturalPerson) {
			ComparisonResult result = executeDataRule(naturalPerson);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NaturalPerson", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NaturalPerson", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NaturalPerson naturalPerson) {
			try {
				return exists(MapperS.of(naturalPerson).<String>map("getFirstName", _naturalPerson -> _naturalPerson.getFirstName())).andNullSafe(exists(MapperS.of(naturalPerson).<String>map("getSurname", _naturalPerson -> _naturalPerson.getSurname()))).orNullSafe(exists(MapperS.of(naturalPerson).<FieldWithMetaPersonIdentifier>mapC("getPersonId", _naturalPerson -> _naturalPerson.getPersonId())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NaturalPersonNameOrIdChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPerson naturalPerson) {
			return Collections.emptyList();
		}
	}
}
