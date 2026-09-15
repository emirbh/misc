package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.cd.ProtectionTermsReference;
import fpml.consolidated.cd.ReferencePair;
import fpml.consolidated.cd.ReferencePoolItem;
import fpml.consolidated.cd.SettlementTermsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferencePoolItemValidator implements Validator<ReferencePoolItem> {

	private List<ComparisonResult> getComparisonResults(ReferencePoolItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("constituentWeight", (ConstituentWeight) o.getConstituentWeight() != null ? 1 : 0, 0, 1), 
				checkCardinality("referencePair", (ReferencePair) o.getReferencePair() != null ? 1 : 0, 0, 1), 
				checkCardinality("protectionTermsReference", (ProtectionTermsReference) o.getProtectionTermsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTermsReference", (SettlementTermsReference) o.getSettlementTermsReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePoolItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePoolItem", ValidationResult.ValidationType.CARDINALITY, "ReferencePoolItem", path, "", res.getError());
				}
				return success("ReferencePoolItem", ValidationResult.ValidationType.CARDINALITY, "ReferencePoolItem", path, "");
			})
			.collect(toList());
	}

}
