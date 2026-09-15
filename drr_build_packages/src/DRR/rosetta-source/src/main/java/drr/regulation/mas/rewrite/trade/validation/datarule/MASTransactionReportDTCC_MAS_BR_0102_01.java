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
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0102_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0102_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0102_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0102_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonContractType -> OPTN, CommonContractType -> SWPT] any = contractType then (if (nonReportable -> postUpiData -> Derived -> ValuationMethodorTrigger <> Barrier or nonReportable -> postUpiData -> Derived -> ValuationMethodorTrigger <> Digital_Barrier) and nonReportable -> postUpiData -> Header -> InstrumentType = Option and strikePriceNotation = Monetary and nonReportable -> postUpiData -> Header -> InstrumentType = Option then strikePriceCurrency exists else if strikePriceSchedule -> price -> monetary exists then strikePriceCurrency exists) and (if [\"XAG\", \"XAU\", \"XBA\", \"XBB\", \"XBC\", \"XBD\", \"XDR\", \"XEU\", \"XFU\", \"XPD\", \"XPT\", \"XTS\"] any = strikePriceCurrency then False else True)";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0102_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (notEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbValuationMethodorTriggerEnum>map("getValuationMethodorTrigger", annaDsbDerived -> annaDsbDerived.getValuationMethodorTrigger()), MapperS.of(AnnaDsbValuationMethodorTriggerEnum.BARRIER), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbValuationMethodorTriggerEnum>map("getValuationMethodorTrigger", annaDsbDerived -> annaDsbDerived.getValuationMethodorTrigger()), MapperS.of(AnnaDsbValuationMethodorTriggerEnum.DIGITAL_BARRIER), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _mASTransactionReport -> _mASTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(mASTransactionReport).<String>map("getStrikePriceCurrency", _mASTransactionReport -> _mASTransactionReport.getStrikePriceCurrency()));
					} else if (exists(MapperS.of(mASTransactionReport).<PricePeriod>mapC("getStrikePriceSchedule", _mASTransactionReport -> _mASTransactionReport.getStrikePriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(mASTransactionReport).<String>map("getStrikePriceCurrency", _mASTransactionReport -> _mASTransactionReport.getStrikePriceCurrency()));
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (areEqual(MapperC.<String>of(MapperS.of("XAG"), MapperS.of("XAU"), MapperS.of("XBA"), MapperS.of("XBB"), MapperS.of("XBC"), MapperS.of("XBD"), MapperS.of("XDR"), MapperS.of("XEU"), MapperS.of("XFU"), MapperS.of("XPD"), MapperS.of("XPT"), MapperS.of("XTS")), MapperS.of(mASTransactionReport).<String>map("getStrikePriceCurrency", _mASTransactionReport -> _mASTransactionReport.getStrikePriceCurrency()), CardinalityOperator.Any).getOrDefault(false)) {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(false));
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0102_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
