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
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportReceiverIdentifierCondition")
@ImplementedBy(CFTCPart45TransactionReportReceiverIdentifierCondition.Default.class)
public interface CFTCPart45TransactionReportReceiverIdentifierCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportReceiverIdentifierCondition";
	String DEFINITION = "if buyerIdentifier is absent and sellerIdentifier is absent then ((if leg1 -> receiverIdentifier exists then [counterparty1, counterparty2] any = leg1 -> receiverIdentifier else True) and (if leg2 -> receiverIdentifier exists then [counterparty1, counterparty2] any = leg2 -> receiverIdentifier else True)) else leg1 -> receiverIdentifier is absent and leg2 -> receiverIdentifier is absent";
	
	class Default implements CFTCPart45TransactionReportReceiverIdentifierCondition {
	
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
				if (notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getBuyerIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getBuyerIdentifier())).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getSellerIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getSellerIdentifier()))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier())).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperC.<String>of(MapperS.of(cFTCPart45TransactionReport).<String>map("getCounterparty1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCounterparty1()), MapperS.of(cFTCPart45TransactionReport).<String>map("getCounterparty2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCounterparty2())), MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier()), CardinalityOperator.Any);
					} else {
						ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier())).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperC.<String>of(MapperS.of(cFTCPart45TransactionReport).<String>map("getCounterparty1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCounterparty1()), MapperS.of(cFTCPart45TransactionReport).<String>map("getCounterparty2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCounterparty2())), MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier()), CardinalityOperator.Any);
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier())).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<String>map("getReceiverIdentifier", cFTCPart45Leg -> cFTCPart45Leg.getReceiverIdentifier())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportReceiverIdentifierCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
