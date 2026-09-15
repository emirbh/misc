package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.SupplementaryData1;
import iso20022.auth030.hkma.tr.SupplementaryDataEnvelope1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SupplementaryData1Validator implements Validator<SupplementaryData1> {

	private List<ComparisonResult> getComparisonResults(SupplementaryData1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("plcAndNm", (String) o.getPlcAndNm() != null ? 1 : 0, 0, 1), 
				checkCardinality("envlp", (SupplementaryDataEnvelope1) o.getEnvlp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupplementaryData1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupplementaryData1", ValidationResult.ValidationType.CARDINALITY, "SupplementaryData1", path, "", res.getError());
				}
				return success("SupplementaryData1", ValidationResult.ValidationType.CARDINALITY, "SupplementaryData1", path, "");
			})
			.collect(toList());
	}

}
