package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.StubValue;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.StubPeriod;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
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
@RosettaDataRule("EconomicTermsLastRegularPaymentDate")
@ImplementedBy(EconomicTermsLastRegularPaymentDate.Default.class)
public interface EconomicTermsLastRegularPaymentDate extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsLastRegularPaymentDate";
	String DEFINITION = "if payout -> InterestRatePayout -> paymentDates -> lastRegularPaymentDate exists and payout -> InterestRatePayout -> stubPeriod -> finalStub exists then payout -> InterestRatePayout count = 2";
	
	class Default implements EconomicTermsLastRegularPaymentDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				if (exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", paymentDates -> paymentDates.getLastRegularPaymentDate())).andNullSafe(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<StubPeriod>map("getStubPeriod", interestRatePayout -> interestRatePayout.getStubPeriod()).<StubValue>map("getFinalStub", stubPeriod -> stubPeriod.getFinalStub()))).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).resultCount()), MapperS.of(2), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsLastRegularPaymentDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
