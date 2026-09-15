package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04")
@ImplementedBy(CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04.Default.class)
public interface CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04 extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04";
	String DEFINITION = "if dtccAdditionalFields -> tradeParty1IDType = \"NPID\" then [\"XXXX\", \"XOFF\", \"BILT\"] any <> platformIdentifier and cleared = I";
	
	class Default implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1IDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1IDType()), MapperS.of("NPID"), CardinalityOperator.All).getOrDefault(false)) {
					return notEqual(MapperC.<String>of(MapperS.of("XXXX"), MapperS.of("XOFF"), MapperS.of("BILT")), MapperS.of(cFTCPart45TransactionReport).<String>map("getPlatformIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPlatformIdentifier()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
