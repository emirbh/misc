package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.NetAndGross;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NetAndGrossValidator implements Validator<NetAndGross> {

	private List<ComparisonResult> getComparisonResults(NetAndGross o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("net", (BigDecimal) o.getNet() != null ? 1 : 0, 0, 1), 
				checkCardinality("gross", (BigDecimal) o.getGross() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndGross o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NetAndGross", ValidationResult.ValidationType.CARDINALITY, "NetAndGross", path, "", res.getError());
				}
				return success("NetAndGross", ValidationResult.ValidationType.CARDINALITY, "NetAndGross", path, "");
			})
			.collect(toList());
	}

}
