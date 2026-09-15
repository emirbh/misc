package iso20022.auth108.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.tr.NotApplicable1Code;
import iso20022.auth108.hkma.tr.PortfolioCode5Choice;
import iso20022.auth108.hkma.tr.PortfolioIdentification3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioCode5ChoiceValidator implements Validator<PortfolioCode5Choice> {

	private List<ComparisonResult> getComparisonResults(PortfolioCode5Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("prtfl", (PortfolioIdentification3) o.getPrtfl() != null ? 1 : 0, 0, 1), 
				checkCardinality("noPrtfl", (NotApplicable1Code) o.getNoPrtfl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode5Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioCode5Choice", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode5Choice", path, "", res.getError());
				}
				return success("PortfolioCode5Choice", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode5Choice", path, "");
			})
			.collect(toList());
	}

}
