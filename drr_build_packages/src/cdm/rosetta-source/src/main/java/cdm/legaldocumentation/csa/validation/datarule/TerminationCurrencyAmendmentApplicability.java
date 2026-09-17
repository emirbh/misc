package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.legaldocumentation.csa.TerminationCurrencyElection;
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
@RosettaDataRule("TerminationCurrencyAmendmentApplicability")
@ImplementedBy(TerminationCurrencyAmendmentApplicability.Default.class)
public interface TerminationCurrencyAmendmentApplicability extends Validator<TerminationCurrencyAmendment> {
	
	String NAME = "TerminationCurrencyAmendmentApplicability";
	String DEFINITION = "if isApplicable = False then effectiveDate is absent and partyElection is absent";
	
	class Default implements TerminationCurrencyAmendmentApplicability {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyAmendment terminationCurrencyAmendment) {
			ComparisonResult result = executeDataRule(terminationCurrencyAmendment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyAmendment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyAmendment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TerminationCurrencyAmendment terminationCurrencyAmendment) {
			try {
				if (areEqual(MapperS.of(terminationCurrencyAmendment).<Boolean>map("getIsApplicable", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(terminationCurrencyAmendment).<AmendmentEffectiveDate>map("getEffectiveDate", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getEffectiveDate())).andNullSafe(notExists(MapperS.of(terminationCurrencyAmendment).<TerminationCurrencyElection>mapC("getPartyElection", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getPartyElection())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TerminationCurrencyAmendmentApplicability {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyAmendment terminationCurrencyAmendment) {
			return Collections.emptyList();
		}
	}
}
