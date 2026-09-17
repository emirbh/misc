package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.YieldCurveMethod;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class YieldCurveMethodValidator implements Validator<YieldCurveMethod> {

	private List<ComparisonResult> getComparisonResults(YieldCurveMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementRateSource", (SettlementRateSource) o.getSettlementRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationRateType", (QuotationRateTypeEnum) o.getQuotationRateType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, YieldCurveMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("YieldCurveMethod", ValidationResult.ValidationType.CARDINALITY, "YieldCurveMethod", path, "", res.getError());
				}
				return success("YieldCurveMethod", ValidationResult.ValidationType.CARDINALITY, "YieldCurveMethod", path, "");
			})
			.collect(toList());
	}

}
