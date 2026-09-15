package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
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
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0005_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0005_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0005_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0005_01";
	String DEFINITION = "if (leg1 -> payerIdentifier is absent and leg2 -> payerIdentifier is absent) and (leg1 -> receiverIdentifier is absent and leg2 -> receiverIdentifier is absent) then (sellerIdentifier exists and (sellerIdentifier = counterparty1 or sellerIdentifier = counterparty2)) else sellerIdentifier is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0005_01 {
	
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
				if (notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier()))).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<String>map("getReceiverIdentifier", cSALeg -> cSALeg.getReceiverIdentifier())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<String>map("getReceiverIdentifier", cSALeg -> cSALeg.getReceiverIdentifier())))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<String>map("getSellerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getSellerIdentifier())).andNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<String>map("getSellerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getSellerIdentifier()), MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty1()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<String>map("getSellerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getSellerIdentifier()), MapperS.of(cSATransactionReportTrade).<String>map("getCounterparty2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCounterparty2()), CardinalityOperator.All)));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<String>map("getSellerIdentifier", _cSATransactionReportTrade -> _cSATransactionReportTrade.getSellerIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0005_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
