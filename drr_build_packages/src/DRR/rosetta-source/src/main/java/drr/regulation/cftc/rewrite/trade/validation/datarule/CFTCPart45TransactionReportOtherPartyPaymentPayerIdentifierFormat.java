package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.math.functions.EmptyOrAllMatch;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.cftc.rewrite.functions.ValidatePartyIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat")
@ImplementedBy(CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat.Default.class)
public interface CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat";
	String DEFINITION = "EmptyOrAllMatch( otherPayment extract cftc.ValidatePartyIdentifierFormat(payer, payerFormat), True )";
	
	class Default implements CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat {
	
		@Inject protected EmptyOrAllMatch emptyOrAllMatch;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(emptyOrAllMatch.evaluate(MapperS.of(cFTCPart45TransactionReport).<OtherPayment>mapC("getOtherPayment", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOtherPayment())
					.mapItem(item -> MapperS.of(validatePartyIdentifierFormat.evaluate(item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get(), item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()).get()))).getMulti(), true)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportOtherPartyPaymentPayerIdentifierFormat {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
