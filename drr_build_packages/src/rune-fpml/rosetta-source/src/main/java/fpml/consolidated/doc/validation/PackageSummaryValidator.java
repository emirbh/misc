package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.OrderIdentifier;
import fpml.consolidated.doc.PackageSummary;
import fpml.consolidated.shared.IssuerTradeId;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PackageSummaryValidator implements Validator<PackageSummary> {

	private List<ComparisonResult> getComparisonResults(PackageSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("packageIdentifier", (IssuerTradeId) o.getPackageIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("orderIdentifier", (OrderIdentifier) o.getOrderIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("size", (BigDecimal) o.getSize() != null ? 1 : 0, 0, 1), 
				checkCardinality("sequenceNumber", (BigDecimal) o.getSequenceNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PackageSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PackageSummary", ValidationResult.ValidationType.CARDINALITY, "PackageSummary", path, "", res.getError());
				}
				return success("PackageSummary", ValidationResult.ValidationType.CARDINALITY, "PackageSummary", path, "");
			})
			.collect(toList());
	}

}
