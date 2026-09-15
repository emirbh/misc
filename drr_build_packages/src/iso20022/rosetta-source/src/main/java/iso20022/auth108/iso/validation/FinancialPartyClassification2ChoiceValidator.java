package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.FinancialPartyClassification2Choice;
import iso20022.auth108.iso.FinancialPartySectorType3Code;
import iso20022.auth108.iso.GenericIdentification175;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinancialPartyClassification2ChoiceValidator implements Validator<FinancialPartyClassification2Choice> {

	private List<ComparisonResult> getComparisonResults(FinancialPartyClassification2Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cd", (FinancialPartySectorType3Code) o.getCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("prtry", (GenericIdentification175) o.getPrtry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinancialPartyClassification2Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinancialPartyClassification2Choice", ValidationResult.ValidationType.CARDINALITY, "FinancialPartyClassification2Choice", path, "", res.getError());
				}
				return success("FinancialPartyClassification2Choice", ValidationResult.ValidationType.CARDINALITY, "FinancialPartyClassification2Choice", path, "");
			})
			.collect(toList());
	}

}
