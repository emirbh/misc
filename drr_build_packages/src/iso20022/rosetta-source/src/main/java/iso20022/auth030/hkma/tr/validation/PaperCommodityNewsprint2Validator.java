package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassProductType8Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType36Code;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PaperCommodityNewsprint2Validator implements Validator<PaperCommodityNewsprint2> {

	private List<ComparisonResult> getComparisonResults(PaperCommodityNewsprint2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType8Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType36Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaperCommodityNewsprint2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaperCommodityNewsprint2", ValidationResult.ValidationType.CARDINALITY, "PaperCommodityNewsprint2", path, "", res.getError());
				}
				return success("PaperCommodityNewsprint2", ValidationResult.ValidationType.CARDINALITY, "PaperCommodityNewsprint2", path, "");
			})
			.collect(toList());
	}

}
