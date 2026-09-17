package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("PledgeeRepresentativeRiderRepresentativeParty")
@ImplementedBy(PledgeeRepresentativeRiderRepresentativeParty.Default.class)
public interface PledgeeRepresentativeRiderRepresentativeParty extends Validator<PledgeeRepresentativeRider> {
	
	String NAME = "PledgeeRepresentativeRiderRepresentativeParty";
	String DEFINITION = "if isApplicable = True then party exists and representativeTerms exists and representativeEvent exists and representativeEndDate exists";
	
	class Default implements PledgeeRepresentativeRiderRepresentativeParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			ComparisonResult result = executeDataRule(pledgeeRepresentativeRider);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			try {
				if (areEqual(MapperS.of(pledgeeRepresentativeRider).<Boolean>map("getIsApplicable", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(pledgeeRepresentativeRider).<CounterpartyRoleEnum>map("getParty", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getParty())).andNullSafe(exists(MapperS.of(pledgeeRepresentativeRider).<String>map("getRepresentativeTerms", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeTerms()))).andNullSafe(exists(MapperS.of(pledgeeRepresentativeRider).<ExceptionEnum>map("getRepresentativeEvent", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEvent()))).andNullSafe(exists(MapperS.of(pledgeeRepresentativeRider).<CustomisableOffset>map("getRepresentativeEndDate", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEndDate())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PledgeeRepresentativeRiderRepresentativeParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
			return Collections.emptyList();
		}
	}
}
