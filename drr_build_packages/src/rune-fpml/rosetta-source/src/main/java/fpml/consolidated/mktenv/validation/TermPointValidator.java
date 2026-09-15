package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.TermPoint;
import fpml.consolidated.riskdef.TimeDimension;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TermPointValidator implements Validator<TermPoint> {

	private List<ComparisonResult> getComparisonResults(TermPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("term", (TimeDimension) o.getTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("bid", (BigDecimal) o.getBid() != null ? 1 : 0, 0, 1), 
				checkCardinality("mid", (BigDecimal) o.getMid() != null ? 1 : 0, 0, 1), 
				checkCardinality("ask", (BigDecimal) o.getAsk() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadValue", (BigDecimal) o.getSpreadValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (AssetReference) o.getDefinition() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermPoint", ValidationResult.ValidationType.CARDINALITY, "TermPoint", path, "", res.getError());
				}
				return success("TermPoint", ValidationResult.ValidationType.CARDINALITY, "TermPoint", path, "");
			})
			.collect(toList());
	}

}
