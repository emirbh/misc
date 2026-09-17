package cdm.product.asset.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.StubValue;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.StubPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("InterestRatePayoutFpML_ird_23")
@ImplementedBy(InterestRatePayoutFpML_ird_23.Default.class)
public interface InterestRatePayoutFpML_ird_23 extends Validator<InterestRatePayout> {
	
	String NAME = "InterestRatePayoutFpML_ird_23";
	String DEFINITION = "if stubPeriod -> initialStub exists then calculationPeriodDates -> firstRegularPeriodStartDate exists";
	
	class Default implements InterestRatePayoutFpML_ird_23 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			ComparisonResult result = executeDataRule(interestRatePayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
			try {
				if (exists(MapperS.of(interestRatePayout).<StubPeriod>map("getStubPeriod", _interestRatePayout -> _interestRatePayout.getStubPeriod()).<StubValue>map("getInitialStub", stubPeriod -> stubPeriod.getInitialStub())).getOrDefault(false)) {
					return exists(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<Date>map("getFirstRegularPeriodStartDate", calculationPeriodDates -> calculationPeriodDates.getFirstRegularPeriodStartDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRatePayoutFpML_ird_23 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			return Collections.emptyList();
		}
	}
}
