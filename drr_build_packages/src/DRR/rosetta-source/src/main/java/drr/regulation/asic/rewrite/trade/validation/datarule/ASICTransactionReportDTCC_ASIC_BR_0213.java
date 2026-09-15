package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.quantity.functions.NotionalQuantityScheduleValue_Validation;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_0213")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_0213.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_0213 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_0213";
	String DEFINITION = "if assetClass = COMM and leg2 -> totalNotionalQuantity exists and leg2 -> notionalQuantity is absent then leg2 -> notionalQuantitySchedule -> value exists and common.quantity.NotionalQuantityScheduleValue_Validation( actionType, assetClass, leg2 -> notionalQuantitySchedule )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_0213 {
	
		@Inject protected NotionalQuantityScheduleValue_Validation notionalQuantityScheduleValue_Validation;
		
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
				if (areEqual(MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()))).andNullSafe(notExists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()))).getOrDefault(false)) {
					return exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleValue_Validation.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()).get(), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule()).getMulti()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_0213 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
