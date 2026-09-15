package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassProductType2Code;
import iso20022.auth030.fca.AssetClassSubProductType24Code;
import iso20022.auth030.fca.EnergyCommodityCoal2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityCoal2__1Validator implements Validator<EnergyCommodityCoal2__1> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityCoal2__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType2Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType24Code) o.getSubPdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityCoal2__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityCoal2__1", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityCoal2__1", path, "", res.getError());
				}
				return success("EnergyCommodityCoal2__1", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityCoal2__1", path, "");
			})
			.collect(toList());
	}

}
