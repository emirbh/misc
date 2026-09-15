package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodity7Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityC10Other1;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityFreight4Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndex1;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityInflation1;
import iso20022.auth030.hkma.tr.AssetClassCommodityMetal2Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.hkma.tr.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.hkma.tr.AssetClassCommodityOther1;
import iso20022.auth030.hkma.tr.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityPolypropylene4Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodity7ChoiceValidator implements Validator<AssetClassCommodity7Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodity7Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("agrcltrl", (AssetClassCommodityAgricultural6Choice) o.getAgrcltrl() != null ? 1 : 0, 0, 1), 
				checkCardinality("nrgy", (AssetClassCommodityEnergy3Choice) o.getNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("envttl", (AssetClassCommodityEnvironmental3Choice) o.getEnvttl() != null ? 1 : 0, 0, 1), 
				checkCardinality("frtlzr", (AssetClassCommodityFertilizer4Choice) o.getFrtlzr() != null ? 1 : 0, 0, 1), 
				checkCardinality("frght", (AssetClassCommodityFreight4Choice) o.getFrght() != null ? 1 : 0, 0, 1), 
				checkCardinality("indx", (AssetClassCommodityIndex1) o.getIndx() != null ? 1 : 0, 0, 1), 
				checkCardinality("indstrlPdct", (AssetClassCommodityIndustrialProduct2Choice) o.getIndstrlPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("infltn", (AssetClassCommodityInflation1) o.getInfltn() != null ? 1 : 0, 0, 1), 
				checkCardinality("metl", (AssetClassCommodityMetal2Choice) o.getMetl() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiCmmdtyExtc", (AssetClassCommodityMultiCommodityExotic1) o.getMultiCmmdtyExtc() != null ? 1 : 0, 0, 1), 
				checkCardinality("offclEcnmcSttstcs", (AssetClassCommodityOfficialEconomicStatistics1) o.getOffclEcnmcSttstcs() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (AssetClassCommodityOther1) o.getOthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrC10", (AssetClassCommodityC10Other1) o.getOthrC10() != null ? 1 : 0, 0, 1), 
				checkCardinality("ppr", (AssetClassCommodityPaper5Choice) o.getPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("plprpln", (AssetClassCommodityPolypropylene4Choice) o.getPlprpln() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity7Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodity7Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity7Choice", path, "", res.getError());
				}
				return success("AssetClassCommodity7Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity7Choice", path, "");
			})
			.collect(toList());
	}

}
