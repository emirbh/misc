package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.price.functions.Price_Validation_02;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
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
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0094_02")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0094_02.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0094_02 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0094_02";
	String DEFINITION = "if ((assetClass = CommonAssetClass -> INTR and [CommonContractType -> FORW, CommonContractType -> OTHR] any = contractType) or ([CommonAssetClass -> EQUI, CommonAssetClass -> COMM] any = assetClass and CommonContractType -> OTHR = contractType)) then common.price.Price_Validation_02( actionType, leg1, leg2, strikePrice, optionPremiumAmount, price, priceSchedule )";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0094_02 {
	
		@Inject protected Price_Validation_02 price_Validation_02;
		
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
				if (areEqual(MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.OTHR)), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.Any)).orNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(CommonContractType.OTHR), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.All))).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(price_Validation_02.evaluate(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()).get(), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).get(), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).get(), MapperS.of(mASTransactionReport).<PriceFormat>map("getStrikePrice", _mASTransactionReport -> _mASTransactionReport.getStrikePrice()).get(), MapperS.of(mASTransactionReport).<BigDecimal>map("getOptionPremiumAmount", _mASTransactionReport -> _mASTransactionReport.getOptionPremiumAmount()).get(), MapperS.of(mASTransactionReport).<PriceFormat>map("getPrice", _mASTransactionReport -> _mASTransactionReport.getPrice()).get(), MapperS.of(mASTransactionReport).<PricePeriod>mapC("getPriceSchedule", _mASTransactionReport -> _mASTransactionReport.getPriceSchedule()).getMulti())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0094_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
