package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeDTCC_CSA_VR_0065_01")
@ImplementedBy(CSATransactionReportTradeDTCC_CSA_VR_0065_01.Default.class)
public interface CSATransactionReportTradeDTCC_CSA_VR_0065_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeDTCC_CSA_VR_0065_01";
	String DEFINITION = "if strikePriceSchedule -> effectiveDate count >= 1 then strikePriceSchedule -> effectiveDate count = strikePriceSchedule -> price count";
	
	class Default implements CSATransactionReportTradeDTCC_CSA_VR_0065_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (greaterThanEquals(MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getStrikePriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getStrikePriceSchedule()).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getStrikePriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getStrikePriceSchedule()).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getStrikePriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getStrikePriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).resultCount()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeDTCC_CSA_VR_0065_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
