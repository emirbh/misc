package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.InstrumentTradePricing;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InstrumentTradePricingValidator implements Validator<InstrumentTradePricing> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradePricing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("couponStartDate", (ZonedDateTime) o.getCouponStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exDividendDate", (ZonedDateTime) o.getExDividendDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradedFlatOfAccrued", (Boolean) o.getTradedFlatOfAccrued() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradePricing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradePricing", ValidationResult.ValidationType.CARDINALITY, "InstrumentTradePricing", path, "", res.getError());
				}
				return success("InstrumentTradePricing", ValidationResult.ValidationType.CARDINALITY, "InstrumentTradePricing", path, "");
			})
			.collect(toList());
	}

}
