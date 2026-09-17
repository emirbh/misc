package cdm.product.common.settlement.validation;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.RelativeDateOffset;
import cdm.observable.asset.MultipleValuationDates;
import cdm.observable.asset.SingleValuationDate;
import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.ValuationDate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationDateValidator implements Validator<ValuationDate> {

	private List<ComparisonResult> getComparisonResults(ValuationDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singleValuationDate", (SingleValuationDate) o.getSingleValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleValuationDates", (MultipleValuationDates) o.getMultipleValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (RelativeDateOffset) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFixingDate", (FxFixingDate) o.getFxFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFixingSchedule", (AdjustableDates) o.getFxFixingSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDate", ValidationResult.ValidationType.CARDINALITY, "ValuationDate", path, "", res.getError());
				}
				return success("ValuationDate", ValidationResult.ValidationType.CARDINALITY, "ValuationDate", path, "");
			})
			.collect(toList());
	}

}
