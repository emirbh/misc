package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier";
	String DEFINITION = "if buyerIdentifier exists or (leg1 -> payerIdentifier is absent and leg1 -> receiverIdentifier is absent) then sellerIdentifier exists and (sellerIdentifier = counterparty1 or sellerIdentifier = counterparty2) else sellerIdentifier is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			ComparisonResult result = executeDataRule(sECTransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReportTrade sECTransactionReportTrade) {
			try {
				if (exists(MapperS.of(sECTransactionReportTrade).<String>map("getBuyerIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getBuyerIdentifier())).orNullSafe(notExists(MapperS.of(sECTransactionReportTrade).<SECLeg>map("getLeg1", _sECTransactionReportTrade -> _sECTransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", sECLeg -> sECLeg.getPayerIdentifier())).andNullSafe(notExists(MapperS.of(sECTransactionReportTrade).<SECLeg>map("getLeg1", _sECTransactionReportTrade -> _sECTransactionReportTrade.getLeg1()).<String>map("getReceiverIdentifier", sECLeg -> sECLeg.getReceiverIdentifier())))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<String>map("getSellerIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getSellerIdentifier())).andNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<String>map("getSellerIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getSellerIdentifier()), MapperS.of(sECTransactionReportTrade).<String>map("getCounterparty1", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCounterparty1()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<String>map("getSellerIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getSellerIdentifier()), MapperS.of(sECTransactionReportTrade).<String>map("getCounterparty2", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCounterparty2()), CardinalityOperator.All)));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<String>map("getSellerIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getSellerIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_SellerIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
