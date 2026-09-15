package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0027_01")
@ImplementedBy(CSATransactionReportCSA_VR_0027_01.Default.class)
public interface CSATransactionReportCSA_VR_0027_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0027_01";
	String DEFINITION = "if nonReportable -> postUpiData -> Header -> InstrumentType = Option or nonReportable -> instrumentType = Option then ((if leg1 -> notionalCurrency exists then [callCurrency, putCurrency] any = leg1 -> notionalCurrency else True) and (if leg2 -> notionalCurrency exists then [callCurrency, putCurrency] any = leg2 -> notionalCurrency else True))";
	
	class Default implements CSATransactionReportCSA_VR_0027_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cSANonReportable -> cSANonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency())).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cSATransactionReport -> _cSATransactionReport.getCallCurrency()), MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cSATransactionReport -> _cSATransactionReport.getPutCurrency())), MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency()), CardinalityOperator.Any);
					} else {
						ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency())).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cSATransactionReport -> _cSATransactionReport.getCallCurrency()), MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cSATransactionReport -> _cSATransactionReport.getPutCurrency())), MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency()), CardinalityOperator.Any);
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
	class NoOp implements CSATransactionReportCSA_VR_0027_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
