package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.SpecifiedValueEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxBenchmarkObligationDefaultValidator implements Validator<FxBenchmarkObligationDefault> {

	private List<ComparisonResult> getComparisonResults(FxBenchmarkObligationDefault o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("benchmarkObligationDefaultIsApplicable", (Boolean) o.getBenchmarkObligationDefaultIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("localSubstituteProvisionType", (FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedValue", (SpecifiedValueEnum) o.getSpecifiedValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBenchmarkObligationDefault o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBenchmarkObligationDefault", ValidationResult.ValidationType.CARDINALITY, "FxBenchmarkObligationDefault", path, "", res.getError());
				}
				return success("FxBenchmarkObligationDefault", ValidationResult.ValidationType.CARDINALITY, "FxBenchmarkObligationDefault", path, "");
			})
			.collect(toList());
	}

}
