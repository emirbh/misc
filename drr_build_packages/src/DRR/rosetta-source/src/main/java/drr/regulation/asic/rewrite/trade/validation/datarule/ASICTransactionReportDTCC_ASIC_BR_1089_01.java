package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1089_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1089_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1089_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1089_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CRDT then if cdSIndexAttachmentPoint exists then cdSIndexDetachmentPoint > cdSIndexAttachmentPoint and (cdSIndexDetachmentPoint >= 0 and cdSIndexDetachmentPoint <= 1)";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1089_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).getOrDefault(false)) {
					if (exists(MapperS.of(aSICTransactionReport).<BigDecimal>map("getCdSIndexAttachmentPoint", _aSICTransactionReport -> _aSICTransactionReport.getCdSIndexAttachmentPoint())).getOrDefault(false)) {
						return greaterThan(MapperS.of(aSICTransactionReport).<BigDecimal>map("getCdSIndexDetachmentPoint", _aSICTransactionReport -> _aSICTransactionReport.getCdSIndexDetachmentPoint()), MapperS.of(aSICTransactionReport).<BigDecimal>map("getCdSIndexAttachmentPoint", _aSICTransactionReport -> _aSICTransactionReport.getCdSIndexAttachmentPoint()), CardinalityOperator.All).andNullSafe(greaterThanEquals(MapperS.of(aSICTransactionReport).<BigDecimal>map("getCdSIndexDetachmentPoint", _aSICTransactionReport -> _aSICTransactionReport.getCdSIndexDetachmentPoint()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(aSICTransactionReport).<BigDecimal>map("getCdSIndexDetachmentPoint", _aSICTransactionReport -> _aSICTransactionReport.getCdSIndexDetachmentPoint()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All)));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1089_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
