package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.quantity.functions.NotionalQuantityScheduleEffectiveDate_Validation;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0037_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0037_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0037_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0037_01";
	String DEFINITION = "common.quantity.NotionalQuantityScheduleEffectiveDate_Validation( leg1 -> notionalQuantitySchedule ) and common.quantity.NotionalQuantityScheduleEffectiveDate_Validation( leg2 -> notionalQuantitySchedule )";
	
	class Default implements CSATransactionReportTradeCSA_VR_0037_01 {
	
		@Inject protected NotionalQuantityScheduleEffectiveDate_Validation notionalQuantityScheduleEffectiveDate_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleEffectiveDate_Validation.evaluate(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleEffectiveDate_Validation.evaluate(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).getMulti()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0037_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
