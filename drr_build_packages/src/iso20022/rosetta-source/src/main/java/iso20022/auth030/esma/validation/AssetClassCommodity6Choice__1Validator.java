package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodity6Choice__1;
import iso20022.auth030.esma.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.esma.AssetClassCommodityC10Other1;
import iso20022.auth030.esma.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.esma.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.esma.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.esma.AssetClassCommodityFreight4Choice;
import iso20022.auth030.esma.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.esma.AssetClassCommodityInflation1;
import iso20022.auth030.esma.AssetClassCommodityMetal2Choice;
import iso20022.auth030.esma.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.esma.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.esma.AssetClassCommodityOther1;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import iso20022.auth030.esma.AssetClassCommodityPolypropylene4Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodity6Choice__1Validator implements Validator<AssetClassCommodity6Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodity6Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("agrcltrl", (AssetClassCommodityAgricultural6Choice) o.getAgrcltrl() != null ? 1 : 0, 0, 1), 
				checkCardinality("nrgy", (AssetClassCommodityEnergy3Choice) o.getNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("envttl", (AssetClassCommodityEnvironmental3Choice) o.getEnvttl() != null ? 1 : 0, 0, 1), 
				checkCardinality("frtlzr", (AssetClassCommodityFertilizer4Choice) o.getFrtlzr() != null ? 1 : 0, 0, 1), 
				checkCardinality("frght", (AssetClassCommodityFreight4Choice) o.getFrght() != null ? 1 : 0, 0, 1), 
				checkCardinality("indstrlPdct", (AssetClassCommodityIndustrialProduct2Choice) o.getIndstrlPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("infltn", (AssetClassCommodityInflation1) o.getInfltn() != null ? 1 : 0, 0, 1), 
				checkCardinality("metl", (AssetClassCommodityMetal2Choice) o.getMetl() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiCmmdtyExtc", (AssetClassCommodityMultiCommodityExotic1) o.getMultiCmmdtyExtc() != null ? 1 : 0, 0, 1), 
				checkCardinality("offclEcnmcSttstcs", (AssetClassCommodityOfficialEconomicStatistics1) o.getOffclEcnmcSttstcs() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (AssetClassCommodityOther1) o.getOthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrC10", (AssetClassCommodityC10Other1) o.getOthrC10() != null ? 1 : 0, 0, 1), 
				checkCardinality("ppr", (AssetClassCommodityPaper4Choice) o.getPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("plprpln", (AssetClassCommodityPolypropylene4Choice) o.getPlprpln() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity6Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity6Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity6Choice__1", path, "");
			})
			.collect(toList());
	}

}
