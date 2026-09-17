package fpml.consolidated.valuation.fpmlreporting.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.valuation.fpmlreporting.QueryPortfolio;
import fpml.consolidated.valuation.fpmlreporting.ReportContents;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportContentsValidator implements Validator<ReportContents> {

	private List<ComparisonResult> getComparisonResults(ReportContents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("queryPortfolio", (QueryPortfolio) o.getQueryPortfolio() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportContents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportContents", ValidationResult.ValidationType.CARDINALITY, "ReportContents", path, "", res.getError());
				}
				return success("ReportContents", ValidationResult.ValidationType.CARDINALITY, "ReportContents", path, "");
			})
			.collect(toList());
	}

}
