package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Core;
import iso20022.dtcc.rds.harmonized.DataResponse;
import iso20022.dtcc.rds.harmonized.GenericAttribute;
import iso20022.dtcc.rds.harmonized.Header;
import iso20022.dtcc.rds.harmonized.SubmissionWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DataResponseValidator implements Validator<DataResponse> {

	private List<ComparisonResult> getComparisonResults(DataResponse o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("header", (Header) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("submissionValidationStatus", (List<? extends GenericAttribute>) o.getSubmissionValidationStatus() == null ? 0 : o.getSubmissionValidationStatus().size(), 1, 0), 
				checkCardinality("core", (Core) o.getCore() != null ? 1 : 0, 1, 1), 
				checkCardinality("originalSubmission", (SubmissionWrapper) o.getOriginalSubmission() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DataResponse o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DataResponse", ValidationResult.ValidationType.CARDINALITY, "DataResponse", path, "", res.getError());
				}
				return success("DataResponse", ValidationResult.ValidationType.CARDINALITY, "DataResponse", path, "");
			})
			.collect(toList());
	}

}
