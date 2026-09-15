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
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0016_04")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0016_04.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0016_04 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0016_04";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and nonReportable -> postUpiData -> Header -> AssetClass = Rates and nonReportable -> postUpiData -> Header -> InstrumentType = Forward and nonReportable -> postUpiData -> Header -> UseCase = FRA_Index then leg1 -> fixedRate exists";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0016_04 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.RATES), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbUseCaseEnum>map("getUseCase", annaDsbHeader -> annaDsbHeader.getUseCase()), MapperS.of(AnnaDsbUseCaseEnum.FRA_INDEX), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0016_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
