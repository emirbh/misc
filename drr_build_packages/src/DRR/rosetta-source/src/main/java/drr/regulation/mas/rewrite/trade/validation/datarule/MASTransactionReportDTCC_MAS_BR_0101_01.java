package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.price.functions.StrikePrice_Validation_01;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0101_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0101_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0101_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0101_01";
	String DEFINITION = "common.price.StrikePrice_Validation_01( actionType, contractType, strikePriceSchedule, strikePrice, nonReportable )";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0101_01 {
	
		@Inject protected StrikePrice_Validation_01 strikePrice_Validation_01;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(strikePrice_Validation_01.evaluate(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()).get(), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()).get(), MapperS.of(mASTransactionReport).<PricePeriod>mapC("getStrikePriceSchedule", _mASTransactionReport -> _mASTransactionReport.getStrikePriceSchedule()).getMulti(), MapperS.of(mASTransactionReport).<PriceFormat>map("getStrikePrice", _mASTransactionReport -> _mASTransactionReport.getStrikePrice()).get(), MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0101_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
