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
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportBuyerIdentifier")
@ImplementedBy(CFTCPart45TransactionReportBuyerIdentifier.Default.class)
public interface CFTCPart45TransactionReportBuyerIdentifier extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportBuyerIdentifier";
	String DEFINITION = "cftc.ValidatePartyIdentifierFormat( buyerIdentifier, nonReportable -> buyerIdentifierFormat )";
	
	class Default implements CFTCPart45TransactionReportBuyerIdentifier {
	
		@Inject protected ValidatePartyIdentifierFormat validatePartyIdentifierFormat;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(validatePartyIdentifierFormat.evaluate(MapperS.of(cFTCPart45TransactionReport).<String>map("getBuyerIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getBuyerIdentifier()).get(), MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<PartyIdentifierFormatEnum>map("getBuyerIdentifierFormat", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getBuyerIdentifierFormat()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportBuyerIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
