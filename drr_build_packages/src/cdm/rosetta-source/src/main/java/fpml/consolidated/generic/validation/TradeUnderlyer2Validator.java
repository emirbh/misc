package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.com.CoalProduct;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.generic.GenericProductExchangeRate;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeUnderlyer2Validator implements Validator<TradeUnderlyer2> {

	private List<ComparisonResult> getComparisonResults(TradeUnderlyer2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRate", (FloatingRate) o.getFloatingRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (Schedule) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRate", (GenericProductExchangeRate) o.getExchangeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformation", (IndexReferenceInformation) o.getIndexReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("gas", (GasProduct) o.getGas() != null ? 1 : 0, 0, 1), 
				checkCardinality("oil", (OilProduct) o.getOil() != null ? 1 : 0, 0, 1), 
				checkCardinality("coal", (CoalProduct) o.getCoal() != null ? 1 : 0, 0, 1), 
				checkCardinality("electricity", (ElectricityProduct) o.getElectricity() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeUnderlyer2", ValidationResult.ValidationType.CARDINALITY, "TradeUnderlyer2", path, "", res.getError());
				}
				return success("TradeUnderlyer2", ValidationResult.ValidationType.CARDINALITY, "TradeUnderlyer2", path, "");
			})
			.collect(toList());
	}

}
