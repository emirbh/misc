package cdm.product.template.validation.datarule;

import cdm.product.template.MandatoryEarlyTerminationAdjustedDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("MandatoryEarlyTerminationAdjustedDatesFpML_ird_44")
@ImplementedBy(MandatoryEarlyTerminationAdjustedDatesFpML_ird_44.Default.class)
public interface MandatoryEarlyTerminationAdjustedDatesFpML_ird_44 extends Validator<MandatoryEarlyTerminationAdjustedDates> {
	
	String NAME = "MandatoryEarlyTerminationAdjustedDatesFpML_ird_44";
	String DEFINITION = "adjustedEarlyTerminationDate <= adjustedCashSettlementValuationDate and adjustedCashSettlementValuationDate <= adjustedCashSettlementPaymentDate";
	
	class Default implements MandatoryEarlyTerminationAdjustedDatesFpML_ird_44 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
			ComparisonResult result = executeDataRule(mandatoryEarlyTerminationAdjustedDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTerminationAdjustedDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTerminationAdjustedDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
			try {
				return lessThanEquals(MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedEarlyTerminationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedEarlyTerminationDate()), MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementValuationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementValuationDate()), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementValuationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementValuationDate()), MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementPaymentDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementPaymentDate()), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MandatoryEarlyTerminationAdjustedDatesFpML_ird_44 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
			return Collections.emptyList();
		}
	}
}
