package drr.regulation.csa.rewrite.trade.validation.datarule;

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
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0006_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0006_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0006_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0006_01";
	String DEFINITION = "if buyerIdentifier is absent and sellerIdentifier is absent then ((if leg1 -> payerIdentifier exists then [counterparty1, counterparty2] any = leg1 -> payerIdentifier else True) and (if leg2 -> payerIdentifier exists then [counterparty1, counterparty2] any = leg2 -> payerIdentifier else True)) else leg1 -> payerIdentifier is absent and leg2 -> payerIdentifier is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0006_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (notExists(MapperS.of(cSATransactionReportTrade).<String>map("getBuyerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBuyerIdentifier())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<String>map("getSellerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getSellerIdentifier()))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier())).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperC.<String>of(MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty1()), MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty2())), MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier()), CardinalityOperator.Any);
					} else {
						ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier())).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperC.<String>of(MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty1()), MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty2())), MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier()), CardinalityOperator.Any);
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0006_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
