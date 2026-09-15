package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.price.functions.StrikePrice_Validation_01;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1059_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1059_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1059_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1059_01";
	String DEFINITION = "common.price.StrikePrice_Validation_01( actionType, contractType, strikePriceSchedule, strikePrice, nonReportable )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1059_01 {
	
		@Inject protected StrikePrice_Validation_01 strikePrice_Validation_01;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(strikePrice_Validation_01.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()).get(), MapperS.of(aSICTransactionReport).<PricePeriod>mapC("getStrikePriceSchedule", _aSICTransactionReport -> _aSICTransactionReport.getStrikePriceSchedule()).getMulti(), MapperS.of(aSICTransactionReport).<PriceFormat>map("getStrikePrice", _aSICTransactionReport -> _aSICTransactionReport.getStrikePrice()).get(), MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1059_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
