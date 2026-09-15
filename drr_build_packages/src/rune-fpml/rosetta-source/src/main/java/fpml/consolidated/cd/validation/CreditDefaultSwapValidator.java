package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapValidator implements Validator<CreditDefaultSwap> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("generalTerms", (GeneralTerms) o.getGeneralTerms() != null ? 1 : 0, 1, 1), 
				checkCardinality("feeLeg", (FeeLeg) o.getFeeLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("protectionTerms", (List<? extends ProtectionTerms>) o.getProtectionTerms() == null ? 0 : o.getProtectionTerms().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwap", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultSwap", path, "", res.getError());
				}
				return success("CreditDefaultSwap", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultSwap", path, "");
			})
			.collect(toList());
	}

}
