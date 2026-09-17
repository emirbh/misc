package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.PaymentDates;
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
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("EconomicTermsFpML_cd_30")
@ImplementedBy(EconomicTermsFpML_cd_30.Default.class)
public interface EconomicTermsFpML_cd_30 extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsFpML_cd_30";
	String DEFINITION = "if payout -> InterestRatePayout -> paymentDates -> lastRegularPaymentDate exists and terminationDate exists then payout -> InterestRatePayout -> paymentDates -> lastRegularPaymentDate all < terminationDate -> adjustableDate -> unadjustedDate or payout -> InterestRatePayout -> paymentDates -> lastRegularPaymentDate all < terminationDate -> adjustableDate -> adjustedDate";
	
	class Default implements EconomicTermsFpML_cd_30 {
	
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
				if (exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", paymentDates -> paymentDates.getLastRegularPaymentDate())).andNullSafe(exists(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()))).getOrDefault(false)) {
					return lessThan(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", paymentDates -> paymentDates.getLastRegularPaymentDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()), CardinalityOperator.All).orNullSafe(lessThan(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", paymentDates -> paymentDates.getLastRegularPaymentDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", adjustableDate -> adjustableDate.getAdjustedDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsFpML_cd_30 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
