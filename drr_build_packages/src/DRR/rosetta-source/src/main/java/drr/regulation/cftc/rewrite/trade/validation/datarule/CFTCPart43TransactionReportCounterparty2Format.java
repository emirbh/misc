package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.cftc.rewrite.functions.ValidatePartyIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportCounterparty2Format")
@ImplementedBy(CFTCPart43TransactionReportCounterparty2Format.Default.class)
public interface CFTCPart43TransactionReportCounterparty2Format extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportCounterparty2Format";
	String DEFINITION = "cftc.ValidatePartyIdentifierFormat( counterparty2, nonReportable -> counterparty2Format )";
	
	class Default implements CFTCPart43TransactionReportCounterparty2Format {
	
		@Inject protected ValidatePartyIdentifierFormat validatePartyIdentifierFormat;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(validatePartyIdentifierFormat.evaluate(MapperS.of(cFTCPart43TransactionReport).<String>map("getCounterparty2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getCounterparty2()).get(), MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<PartyIdentifierFormatEnum>map("getCounterparty2Format", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getCounterparty2Format()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportCounterparty2Format {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
