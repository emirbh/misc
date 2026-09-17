package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FraDiscountingEnum;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FraValidator implements Validator<Fra> {

	private List<ComparisonResult> getComparisonResults(Fra o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedEffectiveDate", (RequiredIdentifierDate) o.getAdjustedEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustedTerminationDate", (ZonedDateTime) o.getAdjustedTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDateOffset", (RelativeDateOffset) o.getFixingDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodNumberOfDays", (Integer) o.getCalculationPeriodNumberOfDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("notional", (Money) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedRate", (IdentifiedRate) o.getFixedRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (List<? extends Period>) o.getIndexTenor() == null ? 0 : o.getIndexTenor().size(), 1, 2), 
				checkCardinality("fraDiscounting", (FraDiscountingEnum) o.getFraDiscounting() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Fra o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Fra", ValidationResult.ValidationType.CARDINALITY, "Fra", path, "", res.getError());
				}
				return success("Fra", ValidationResult.ValidationType.CARDINALITY, "Fra", path, "");
			})
			.collect(toList());
	}

}
