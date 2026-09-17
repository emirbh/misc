package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FxFixingDate;
import fpml.consolidated.ird.NonDeliverableSettlement;
import fpml.consolidated.ird.PriceSourceDisruption;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonDeliverableSettlementValidator implements Validator<NonDeliverableSettlement> {

	private List<ComparisonResult> getComparisonResults(NonDeliverableSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFixingDate", (FxFixingDate) o.getFxFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFixingSchedule", (AdjustableDates) o.getFxFixingSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementRateOption", (SettlementRateOption) o.getSettlementRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceSourceDisruption", (PriceSourceDisruption) o.getPriceSourceDisruption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonDeliverableSettlement", ValidationResult.ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "", res.getError());
				}
				return success("NonDeliverableSettlement", ValidationResult.ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "");
			})
			.collect(toList());
	}

}
