package fpml.consolidated.dividend.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendSwapOptionTransactionSupplementValidator implements Validator<DividendSwapOptionTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(DividendSwapOptionTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityPremium", (EquityPremium) o.getEquityPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExercise", (EquityExerciseValuationSettlement) o.getEquityExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangeLookAlike", (Boolean) o.getExchangeLookAlike() != null ? 1 : 0, 0, 1), 
				checkCardinality("methodOfAdjustment", (MethodOfAdjustmentEnum) o.getMethodOfAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (SwaptionPhysicalSettlement) o.getClearingInstructions() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendSwapTransactionSupplement", (DividendSwapTransactionSupplement) o.getDividendSwapTransactionSupplement() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapOptionTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "", res.getError());
				}
				return success("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
