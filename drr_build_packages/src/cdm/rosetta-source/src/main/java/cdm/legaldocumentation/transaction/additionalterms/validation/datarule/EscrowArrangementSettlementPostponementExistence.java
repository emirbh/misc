package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.observable.asset.ValuationPostponement;
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
@RosettaDataRule("EscrowArrangementSettlementPostponementExistence")
@ImplementedBy(EscrowArrangementSettlementPostponementExistence.Default.class)
public interface EscrowArrangementSettlementPostponementExistence extends Validator<EscrowArrangement> {
	
	String NAME = "EscrowArrangementSettlementPostponementExistence";
	String DEFINITION = "if escrowArrangementIsApplicable = False then maximumDaysOfDisruption is absent and if escrowArrangementIsApplicable = True then maximumDaysOfDisruption exists";
	
	class Default implements EscrowArrangementSettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EscrowArrangement escrowArrangement) {
			ComparisonResult result = executeDataRule(escrowArrangement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EscrowArrangement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EscrowArrangement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EscrowArrangement escrowArrangement) {
			try {
				if (areEqual(MapperS.of(escrowArrangement).<Boolean>map("getEscrowArrangementIsApplicable", _escrowArrangement -> _escrowArrangement.getEscrowArrangementIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperS.of(escrowArrangement).<Boolean>map("getEscrowArrangementIsApplicable", _escrowArrangement -> _escrowArrangement.getEscrowArrangementIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(escrowArrangement).<ValuationPostponement>map("getMaximumDaysOfDisruption", _escrowArrangement -> _escrowArrangement.getMaximumDaysOfDisruption()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return notExists(MapperS.of(escrowArrangement).<ValuationPostponement>map("getMaximumDaysOfDisruption", _escrowArrangement -> _escrowArrangement.getMaximumDaysOfDisruption())).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EscrowArrangementSettlementPostponementExistence {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EscrowArrangement escrowArrangement) {
			return Collections.emptyList();
		}
	}
}
