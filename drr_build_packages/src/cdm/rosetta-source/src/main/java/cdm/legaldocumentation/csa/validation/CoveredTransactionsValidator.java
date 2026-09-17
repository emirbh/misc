package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.legaldocumentation.csa.AdditionalObligations;
import cdm.legaldocumentation.csa.CoveredTransactions;
import cdm.legaldocumentation.csa.ExposureScope;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoveredTransactionsValidator implements Validator<CoveredTransactions> {

	private List<ComparisonResult> getComparisonResults(CoveredTransactions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("inclusionDate", (Date) o.getInclusionDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("coveredTransactions", (List<? extends ProductTaxonomy>) o.getCoveredTransactions() == null ? 0 : o.getCoveredTransactions().size(), 1, 0), 
				checkCardinality("bespokeCoveredTransactions", (List<String>) o.getBespokeCoveredTransactions() == null ? 0 : o.getBespokeCoveredTransactions().size(), 1, 0), 
				checkCardinality("additionalObligations", (List<? extends AdditionalObligations>) o.getAdditionalObligations() == null ? 0 : o.getAdditionalObligations().size(), 0, 2), 
				checkCardinality("exposure", (String) o.getExposure() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyExposure", (List<? extends ExposureScope>) o.getLegacyExposure() == null ? 0 : o.getLegacyExposure().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoveredTransactions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoveredTransactions", ValidationResult.ValidationType.CARDINALITY, "CoveredTransactions", path, "", res.getError());
				}
				return success("CoveredTransactions", ValidationResult.ValidationType.CARDINALITY, "CoveredTransactions", path, "");
			})
			.collect(toList());
	}

}
