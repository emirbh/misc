package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
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
@RosettaDataRule("MinimumTransferAmountAmendmentAmendmentNotApplicable")
@ImplementedBy(MinimumTransferAmountAmendmentAmendmentNotApplicable.Default.class)
public interface MinimumTransferAmountAmendmentAmendmentNotApplicable extends Validator<MinimumTransferAmountAmendment> {
	
	String NAME = "MinimumTransferAmountAmendmentAmendmentNotApplicable";
	String DEFINITION = "if isApplicable = False then effectiveDate is absent and partyElections is absent";
	
	class Default implements MinimumTransferAmountAmendmentAmendmentNotApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
			ComparisonResult result = executeDataRule(minimumTransferAmountAmendment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MinimumTransferAmountAmendment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MinimumTransferAmountAmendment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
			try {
				if (areEqual(MapperS.of(minimumTransferAmountAmendment).<Boolean>map("getIsApplicable", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(minimumTransferAmountAmendment).<AmendmentEffectiveDate>map("getEffectiveDate", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getEffectiveDate())).andNullSafe(notExists(MapperS.of(minimumTransferAmountAmendment).<ElectiveAmountElection>mapC("getPartyElections", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getPartyElections())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MinimumTransferAmountAmendmentAmendmentNotApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
			return Collections.emptyList();
		}
	}
}
