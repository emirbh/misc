package drr.regulation.common.dtcc.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProductGradeReportValidator implements Validator<ProductGradeReport> {

	private List<ComparisonResult> getComparisonResults(ProductGradeReport o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductGradeReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductGradeReport", ValidationResult.ValidationType.CARDINALITY, "ProductGradeReport", path, "", res.getError());
				}
				return success("ProductGradeReport", ValidationResult.ValidationType.CARDINALITY, "ProductGradeReport", path, "");
			})
			.collect(toList());
	}

}
