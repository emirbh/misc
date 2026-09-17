package fpml.consolidated.bond.option.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.bond.option.MakeWholeAmount;
import fpml.consolidated.fpmlenum.QuotationSideEnum;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MakeWholeAmountValidator implements Validator<MakeWholeAmount> {

	private List<ComparisonResult> getComparisonResults(MakeWholeAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("side", (QuotationSideEnum) o.getSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("earlyCallDate", (IdentifiedDate) o.getEarlyCallDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MakeWholeAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MakeWholeAmount", ValidationResult.ValidationType.CARDINALITY, "MakeWholeAmount", path, "", res.getError());
				}
				return success("MakeWholeAmount", ValidationResult.ValidationType.CARDINALITY, "MakeWholeAmount", path, "");
			})
			.collect(toList());
	}

}
