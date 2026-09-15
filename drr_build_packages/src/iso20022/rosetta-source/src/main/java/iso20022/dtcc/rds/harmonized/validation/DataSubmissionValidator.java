package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Core;
import iso20022.dtcc.rds.harmonized.DataSubmission;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import iso20022.dtcc.rds.harmonized.Header;
import iso20022.dtcc.rds.harmonized.Schedules;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DataSubmissionValidator implements Validator<DataSubmission> {

	private List<ComparisonResult> getComparisonResults(DataSubmission o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("header", (Header) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("core", (Core) o.getCore() != null ? 1 : 0, 1, 1), 
				checkCardinality("harmonizedData", (HarmonizedData) o.getHarmonizedData() != null ? 1 : 0, 1, 1), 
				checkCardinality("harmonizedRepeatableData", (HarmonizedRepeatableData) o.getHarmonizedRepeatableData() != null ? 1 : 0, 0, 1), 
				checkCardinality("schedules", (Schedules) o.getSchedules() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DataSubmission o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DataSubmission", ValidationResult.ValidationType.CARDINALITY, "DataSubmission", path, "", res.getError());
				}
				return success("DataSubmission", ValidationResult.ValidationType.CARDINALITY, "DataSubmission", path, "");
			})
			.collect(toList());
	}

}
