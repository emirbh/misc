package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassProductType2Code;
import iso20022.auth030.esma.AssetClassSubProductType24Code;
import iso20022.auth030.esma.EnergyCommodityCoal2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityCoal2Validator implements Validator<EnergyCommodityCoal2> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityCoal2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType2Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType24Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityCoal2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityCoal2", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityCoal2", path, "", res.getError());
				}
				return success("EnergyCommodityCoal2", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityCoal2", path, "");
			})
			.collect(toList());
	}

}
