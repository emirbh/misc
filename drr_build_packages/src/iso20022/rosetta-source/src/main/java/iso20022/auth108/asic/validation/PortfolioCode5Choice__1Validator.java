package iso20022.auth108.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.asic.NotApplicable1Code;
import iso20022.auth108.asic.PortfolioCode5Choice__1;
import iso20022.auth108.asic.PortfolioIdentification3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioCode5Choice__1Validator implements Validator<PortfolioCode5Choice__1> {

	private List<ComparisonResult> getComparisonResults(PortfolioCode5Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("prtfl", (PortfolioIdentification3__1) o.getPrtfl() != null ? 1 : 0, 0, 1), 
				checkCardinality("noPrtfl", (NotApplicable1Code) o.getNoPrtfl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode5Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioCode5Choice__1", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode5Choice__1", path, "", res.getError());
				}
				return success("PortfolioCode5Choice__1", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode5Choice__1", path, "");
			})
			.collect(toList());
	}

}
