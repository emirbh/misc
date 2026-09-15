package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
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
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_StrikePrice")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_StrikePrice.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_StrikePrice extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_StrikePrice";
	String DEFINITION = "if postPricedSwapIndicator = False and (nonReportable -> instrumentType = Option or nonReportable -> postUpiData -> Header -> InstrumentType = Option) then strikePrice exists else strikePrice is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_StrikePrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (areEqual(MapperS.of(sECTransactionReport).<Boolean>map("getPostPricedSwapIndicator", _sECTransactionReport -> _sECTransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<PriceFormat>map("getStrikePrice", _sECTransactionReport -> _sECTransactionReport.getStrikePrice()));
				}
				return notExists(MapperS.of(sECTransactionReport).<PriceFormat>map("getStrikePrice", _sECTransactionReport -> _sECTransactionReport.getStrikePrice()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_StrikePrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
