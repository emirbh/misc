package drr.regulation.common.dtcc.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ProductGradeReportTypeFormatValidator implements Validator<ProductGradeReport> {

	private List<ComparisonResult> getComparisonResults(ProductGradeReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("productGrade", o.getProductGrade(), 1, of(50), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductGradeReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductGradeReport", ValidationResult.ValidationType.TYPE_FORMAT, "ProductGradeReport", path, "", res.getError());
				}
				return success("ProductGradeReport", ValidationResult.ValidationType.TYPE_FORMAT, "ProductGradeReport", path, "");
			})
			.collect(toList());
	}

}
