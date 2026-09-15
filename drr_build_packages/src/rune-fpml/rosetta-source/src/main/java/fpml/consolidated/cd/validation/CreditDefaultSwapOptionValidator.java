package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.CreditOptionStrike;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapOptionValidator implements Validator<CreditDefaultSwapOption> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("premium", (Premium) o.getPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("feature", (OptionFeature) o.getFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalReference", (NotionalAmountReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (Money) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("entitlementCurrency", (Currency) o.getEntitlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptions", (BigDecimal) o.getNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (SwaptionPhysicalSettlement) o.getClearingInstructions() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (CreditOptionStrike) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditDefaultSwap", (CreditDefaultSwap) o.getCreditDefaultSwap() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapOption", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "", res.getError());
				}
				return success("CreditDefaultSwapOption", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "");
			})
			.collect(toList());
	}

}
