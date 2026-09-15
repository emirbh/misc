package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.DataResponse;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DataResponseTypeFormatValidator implements Validator<DataResponse> {

	private List<ComparisonResult> getComparisonResults(DataResponse o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DataResponse o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DataResponse", ValidationResult.ValidationType.TYPE_FORMAT, "DataResponse", path, "", res.getError());
				}
				return success("DataResponse", ValidationResult.ValidationType.TYPE_FORMAT, "DataResponse", path, "");
			})
			.collect(toList());
	}

}
