package drr.regulation.mas.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0015_05")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0015_05.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0015_05 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0015_05";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CommonAssetClass -> COMM then if underlyingIdOtherSource exists then (underlyingIdOther exists and underlyingIdOther = underlyingIdOtherSource to-string)";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0015_05 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All)).getOrDefault(false)) {
					if (exists(MapperS.of(mASTransactionReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", _mASTransactionReport -> _mASTransactionReport.getUnderlyingIdOtherSource())).getOrDefault(false)) {
						return exists(MapperS.of(mASTransactionReport).<String>map("getUnderlyingIdOther", _mASTransactionReport -> _mASTransactionReport.getUnderlyingIdOther())).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<String>map("getUnderlyingIdOther", _mASTransactionReport -> _mASTransactionReport.getUnderlyingIdOther()), MapperS.of(mASTransactionReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", _mASTransactionReport -> _mASTransactionReport.getUnderlyingIdOtherSource()).map("to-string", AssetIdTypeEnum::toDisplayString), CardinalityOperator.All));
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
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0015_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
