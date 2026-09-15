package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.price.functions.PriceScheduleCount_Validation;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0099_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0099_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0099_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0099_01";
	String DEFINITION = "if [CommonAssetClass -> EQUI, CommonAssetClass -> COMM, CommonAssetClass -> INTR] any = assetClass and [CommonContractType -> CFDS, CommonContractType -> FORW, CommonContractType -> SWAP, CommonContractType -> OTHR] any = contractType and priceSchedule -> endDate exists then common.price.PriceScheduleCount_Validation(actionType, priceSchedule)";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0099_01 {
	
		@Inject protected PriceScheduleCount_Validation priceScheduleCount_Validation;
		
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
				if (areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM), MapperS.of(CommonAssetClass.INTR)), MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.OTHR)), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(mASTransactionReport).<PricePeriod>mapC("getPriceSchedule", _mASTransactionReport -> _mASTransactionReport.getPriceSchedule()).<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()))).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(priceScheduleCount_Validation.evaluate(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()).get(), MapperS.of(mASTransactionReport).<PricePeriod>mapC("getPriceSchedule", _mASTransactionReport -> _mASTransactionReport.getPriceSchedule()).getMulti())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0099_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
