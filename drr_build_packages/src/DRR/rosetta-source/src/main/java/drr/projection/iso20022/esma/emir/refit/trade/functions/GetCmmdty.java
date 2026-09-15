package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.AgriculturalCommodityDairy2;
import iso20022.auth030.esma.AgriculturalCommodityForestry2;
import iso20022.auth030.esma.AgriculturalCommodityGrain3;
import iso20022.auth030.esma.AgriculturalCommodityLiveStock2;
import iso20022.auth030.esma.AgriculturalCommodityOilSeed2;
import iso20022.auth030.esma.AgriculturalCommodityOliveOil3;
import iso20022.auth030.esma.AgriculturalCommodityOther2;
import iso20022.auth030.esma.AgriculturalCommodityPotato2;
import iso20022.auth030.esma.AgriculturalCommoditySeafood2;
import iso20022.auth030.esma.AgriculturalCommoditySoft2;
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
import iso20022.auth030.esma.AssetClassDetailedSubProductType10Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType11Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType1Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType29Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType2Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType30Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType31Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType32Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType33Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType34Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType5Code;
import iso20022.auth030.esma.AssetClassDetailedSubProductType8Code;
import iso20022.auth030.esma.AssetClassProductType11Code;
import iso20022.auth030.esma.AssetClassProductType12Code;
import iso20022.auth030.esma.AssetClassProductType13Code;
import iso20022.auth030.esma.AssetClassProductType14Code;
import iso20022.auth030.esma.AssetClassProductType15Code;
import iso20022.auth030.esma.AssetClassProductType1Code;
import iso20022.auth030.esma.AssetClassProductType2Code;
import iso20022.auth030.esma.AssetClassProductType3Code;
import iso20022.auth030.esma.AssetClassProductType4Code;
import iso20022.auth030.esma.AssetClassProductType5Code;
import iso20022.auth030.esma.AssetClassProductType6Code;
import iso20022.auth030.esma.AssetClassProductType7Code;
import iso20022.auth030.esma.AssetClassProductType8Code;
import iso20022.auth030.esma.AssetClassProductType9Code;
import iso20022.auth030.esma.AssetClassSubProductType10Code;
import iso20022.auth030.esma.AssetClassSubProductType15Code;
import iso20022.auth030.esma.AssetClassSubProductType16Code;
import iso20022.auth030.esma.AssetClassSubProductType18Code;
import iso20022.auth030.esma.AssetClassSubProductType1Code;
import iso20022.auth030.esma.AssetClassSubProductType20Code;
import iso20022.auth030.esma.AssetClassSubProductType21Code;
import iso20022.auth030.esma.AssetClassSubProductType22Code;
import iso20022.auth030.esma.AssetClassSubProductType23Code;
import iso20022.auth030.esma.AssetClassSubProductType24Code;
import iso20022.auth030.esma.AssetClassSubProductType25Code;
import iso20022.auth030.esma.AssetClassSubProductType26Code;
import iso20022.auth030.esma.AssetClassSubProductType27Code;
import iso20022.auth030.esma.AssetClassSubProductType28Code;
import iso20022.auth030.esma.AssetClassSubProductType29Code;
import iso20022.auth030.esma.AssetClassSubProductType2Code;
import iso20022.auth030.esma.AssetClassSubProductType30Code;
import iso20022.auth030.esma.AssetClassSubProductType31Code;
import iso20022.auth030.esma.AssetClassSubProductType32Code;
import iso20022.auth030.esma.AssetClassSubProductType33Code;
import iso20022.auth030.esma.AssetClassSubProductType34Code;
import iso20022.auth030.esma.AssetClassSubProductType35Code;
import iso20022.auth030.esma.AssetClassSubProductType36Code;
import iso20022.auth030.esma.AssetClassSubProductType37Code;
import iso20022.auth030.esma.AssetClassSubProductType39Code;
import iso20022.auth030.esma.AssetClassSubProductType3Code;
import iso20022.auth030.esma.AssetClassSubProductType40Code;
import iso20022.auth030.esma.AssetClassSubProductType41Code;
import iso20022.auth030.esma.AssetClassSubProductType42Code;
import iso20022.auth030.esma.AssetClassSubProductType43Code;
import iso20022.auth030.esma.AssetClassSubProductType44Code;
import iso20022.auth030.esma.AssetClassSubProductType45Code;
import iso20022.auth030.esma.AssetClassSubProductType46Code;
import iso20022.auth030.esma.AssetClassSubProductType49Code;
import iso20022.auth030.esma.AssetClassSubProductType5Code;
import iso20022.auth030.esma.AssetClassSubProductType6Code;
import iso20022.auth030.esma.AssetClassSubProductType7Code;
import iso20022.auth030.esma.AssetClassSubProductType8Code;
import iso20022.auth030.esma.EnergyCommodityCoal2;
import iso20022.auth030.esma.EnergyCommodityDistillates2;
import iso20022.auth030.esma.EnergyCommodityElectricity2;
import iso20022.auth030.esma.EnergyCommodityInterEnergy2;
import iso20022.auth030.esma.EnergyCommodityLightEnd2;
import iso20022.auth030.esma.EnergyCommodityNaturalGas3;
import iso20022.auth030.esma.EnergyCommodityOil3;
import iso20022.auth030.esma.EnergyCommodityOther2;
import iso20022.auth030.esma.EnergyCommodityRenewableEnergy2;
import iso20022.auth030.esma.EnvironmentCommodityOther2;
import iso20022.auth030.esma.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.esma.EnvironmentalCommodityEmission3;
import iso20022.auth030.esma.EnvironmentalCommodityWeather2;
import iso20022.auth030.esma.FertilizerCommodityAmmonia2;
import iso20022.auth030.esma.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.esma.FertilizerCommodityOther2;
import iso20022.auth030.esma.FertilizerCommodityPotash2;
import iso20022.auth030.esma.FertilizerCommoditySulphur2;
import iso20022.auth030.esma.FertilizerCommodityUrea2;
import iso20022.auth030.esma.FertilizerCommodityUreaAndAmmoniumNitrate2;
import iso20022.auth030.esma.FreightCommodityContainerShip2;
import iso20022.auth030.esma.FreightCommodityDry3;
import iso20022.auth030.esma.FreightCommodityOther2;
import iso20022.auth030.esma.FreightCommodityWet3;
import iso20022.auth030.esma.IndustrialProductCommodityConstruction2;
import iso20022.auth030.esma.IndustrialProductCommodityManufacturing2;
import iso20022.auth030.esma.MetalCommodityNonPrecious2;
import iso20022.auth030.esma.MetalCommodityPrecious2;
import iso20022.auth030.esma.PaperCommodityContainerBoard2;
import iso20022.auth030.esma.PaperCommodityNewsprint2;
import iso20022.auth030.esma.PaperCommodityOther1;
import iso20022.auth030.esma.PaperCommodityPulp2;
import iso20022.auth030.esma.PolypropyleneCommodityOther2;
import iso20022.auth030.esma.PolypropyleneCommodityPlastic2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCmmdty.GetCmmdtyDefault.class)
public abstract class GetCmmdty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cmmdty 
	*/
	public AssetClassCommodity6Choice__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder cmmdtyBuilder = doEvaluate(drrReport);
		
		final AssetClassCommodity6Choice__1 cmmdty;
		if (cmmdtyBuilder == null) {
			cmmdty = null;
		} else {
			cmmdty = cmmdtyBuilder.build();
			objectValidator.validate(AssetClassCommodity6Choice__1.class, cmmdty);
		}
		
		return cmmdty;
	}

	protected abstract AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetCmmdtyDefault extends GetCmmdty {
		@Override
		protected AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder cmmdty = AssetClassCommodity6Choice__1.builder();
			return assignOutput(cmmdty, drrReport);
		}
		
		protected AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder assignOutput(AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder cmmdty, ESMAEMIRTransactionReport drrReport) {
			AgriculturalCommodityOilSeed2 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("GROS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = AgriculturalCommodityOilSeed2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySoft2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("SOFT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = AgriculturalCommoditySoft2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityPotato2 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("POTA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult2 = AgriculturalCommodityPotato2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType45Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOliveOil3 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OOLI"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult3 = AgriculturalCommodityOliveOil3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityDairy2 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("DIRY"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult4 = AgriculturalCommodityDairy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType20Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityForestry2 ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("FRST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult5 = AgriculturalCommodityForestry2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType21Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySeafood2 ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("SEAF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult6 = AgriculturalCommoditySeafood2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType23Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityLiveStock2 ifThenElseResult7 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("LSTK"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult7 = AgriculturalCommodityLiveStock2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType22Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityGrain3 ifThenElseResult8 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("GRIN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult8 = AgriculturalCommodityGrain3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOther2 ifThenElseResult9 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult9 = AgriculturalCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityElectricity2 ifThenElseResult10 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("ELEC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult10 = EnergyCommodityElectricity2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityNaturalGas3 ifThenElseResult11 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("NGAS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult11 = EnergyCommodityNaturalGas3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOil3 ifThenElseResult12 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OILP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult12 = EnergyCommodityOil3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityCoal2 ifThenElseResult13 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("COAL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult13 = EnergyCommodityCoal2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType24Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityInterEnergy2 ifThenElseResult14 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("INRG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult14 = EnergyCommodityInterEnergy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType26Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityRenewableEnergy2 ifThenElseResult15 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("RNNG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult15 = EnergyCommodityRenewableEnergy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType28Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityLightEnd2 ifThenElseResult16 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("LGHT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult16 = EnergyCommodityLightEnd2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType27Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityDistillates2 ifThenElseResult17 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("DIST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult17 = EnergyCommodityDistillates2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType25Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOther2 ifThenElseResult18 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult18 = EnergyCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityEmission3 ifThenElseResult19 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("EMIS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult19 = EnvironmentalCommodityEmission3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityWeather2 ifThenElseResult20 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("WTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult20 = EnvironmentalCommodityWeather2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityCarbonRelated2 ifThenElseResult21 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("CRBR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult21 = EnvironmentalCommodityCarbonRelated2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentCommodityOther2 ifThenElseResult22 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult22 = EnvironmentCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityAmmonia2 ifThenElseResult23 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("AMMO"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult23 = FertilizerCommodityAmmonia2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType39Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityDiammoniumPhosphate2 ifThenElseResult24 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("DAPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult24 = FertilizerCommodityDiammoniumPhosphate2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType40Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityPotash2 ifThenElseResult25 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("PTSH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult25 = FertilizerCommodityPotash2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType41Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommoditySulphur2 ifThenElseResult26 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("SLPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult26 = FertilizerCommoditySulphur2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType42Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUrea2 ifThenElseResult27 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("UREA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult27 = FertilizerCommodityUrea2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType43Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUreaAndAmmoniumNitrate2 ifThenElseResult28 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("UAAN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult28 = FertilizerCommodityUreaAndAmmoniumNitrate2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType44Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityOther2 ifThenElseResult29 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult29 = FertilizerCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityDry3 ifThenElseResult30 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("DRYF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult30 = FreightCommodityDry3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityWet3 ifThenElseResult31 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("WETF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult31 = FreightCommodityWet3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityContainerShip2 ifThenElseResult32 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("CSHP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult32 = FreightCommodityContainerShip2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType46Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityOther2 ifThenElseResult33 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult33 = FreightCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			IndustrialProductCommodityConstruction2 ifThenElseResult34 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("CSTR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult34 = IndustrialProductCommodityConstruction2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			IndustrialProductCommodityManufacturing2 ifThenElseResult35 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("MFTG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult35 = IndustrialProductCommodityManufacturing2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityInflation1 ifThenElseResult36 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("INFL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult36 = AssetClassCommodityInflation1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType12Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityNonPrecious2 ifThenElseResult37 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("NPRM"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult37 = MetalCommodityNonPrecious2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityPrecious2 ifThenElseResult38 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("PRME"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult38 = MetalCommodityPrecious2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType16Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityMultiCommodityExotic1 ifThenElseResult39 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("MCEX"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult39 = AssetClassCommodityMultiCommodityExotic1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType13Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOfficialEconomicStatistics1 ifThenElseResult40 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("OEST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult40 = AssetClassCommodityOfficialEconomicStatistics1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType14Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOther1 ifThenElseResult41 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult41 = AssetClassCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityC10Other1 ifThenElseResult42 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("OTHC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult42 = AssetClassCommodityC10Other1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityContainerBoard2 ifThenElseResult43 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("CBRD"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult43 = PaperCommodityContainerBoard2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType35Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityNewsprint2 ifThenElseResult44 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("NSPT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult44 = PaperCommodityNewsprint2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType36Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityPulp2 ifThenElseResult45 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("PULP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult45 = PaperCommodityPulp2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType37Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityOther1 ifThenElseResult46 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("RCVP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult46 = PaperCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityOther1 ifThenElseResult47 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult47 = PaperCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityPlastic2 ifThenElseResult48 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("PLST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult48 = PolypropyleneCommodityPlastic2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType18Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityOther2 ifThenElseResult49 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult49 = PolypropyleneCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			cmmdty = toBuilder(AssetClassCommodity6Choice__1.builder()
				.setAgrcltrl(AssetClassCommodityAgricultural6Choice.builder()
					.setGrnOilSeed(ifThenElseResult0)
					.setSoft(ifThenElseResult1)
					.setPtt(ifThenElseResult2)
					.setOlvOil(ifThenElseResult3)
					.setDairy(ifThenElseResult4)
					.setFrstry(ifThenElseResult5)
					.setSfd(ifThenElseResult6)
					.setLiveStock(ifThenElseResult7)
					.setGrn(ifThenElseResult8)
					.setOthr(ifThenElseResult9)
					.build())
				.setNrgy(AssetClassCommodityEnergy3Choice.builder()
					.setElctrcty(ifThenElseResult10)
					.setNtrlGas(ifThenElseResult11)
					.setOil(ifThenElseResult12)
					.setCoal(ifThenElseResult13)
					.setIntrNrgy(ifThenElseResult14)
					.setRnwblNrgy(ifThenElseResult15)
					.setLghtEnd(ifThenElseResult16)
					.setDstllts(ifThenElseResult17)
					.setOthr(ifThenElseResult18)
					.build())
				.setEnvttl(AssetClassCommodityEnvironmental3Choice.builder()
					.setEmssns(ifThenElseResult19)
					.setWthr(ifThenElseResult20)
					.setCrbnRltd(ifThenElseResult21)
					.setOthr(ifThenElseResult22)
					.build())
				.setFrtlzr(AssetClassCommodityFertilizer4Choice.builder()
					.setAmmn(ifThenElseResult23)
					.setDmmnmPhspht(ifThenElseResult24)
					.setPtsh(ifThenElseResult25)
					.setSlphr(ifThenElseResult26)
					.setUrea(ifThenElseResult27)
					.setUreaAndAmmnmNtrt(ifThenElseResult28)
					.setOthr(ifThenElseResult29)
					.build())
				.setFrght(AssetClassCommodityFreight4Choice.builder()
					.setDry(ifThenElseResult30)
					.setWet(ifThenElseResult31)
					.setCntnrShip(ifThenElseResult32)
					.setOthr(ifThenElseResult33)
					.build())
				.setIndstrlPdct(AssetClassCommodityIndustrialProduct2Choice.builder()
					.setCnstrctn(ifThenElseResult34)
					.setManfctg(ifThenElseResult35)
					.build())
				.setInfltn(ifThenElseResult36)
				.setMetl(AssetClassCommodityMetal2Choice.builder()
					.setNonPrcs(ifThenElseResult37)
					.setPrcs(ifThenElseResult38)
					.build())
				.setMultiCmmdtyExtc(ifThenElseResult39)
				.setOffclEcnmcSttstcs(ifThenElseResult40)
				.setOthr(ifThenElseResult41)
				.setOthrC10(ifThenElseResult42)
				.setPpr(AssetClassCommodityPaper4Choice.builder()
					.setCntnrBrd(ifThenElseResult43)
					.setNwsprnt(ifThenElseResult44)
					.setPulp(ifThenElseResult45)
					.setRcvrdPpr(ifThenElseResult46)
					.setOthr(ifThenElseResult47)
					.build())
				.setPlprpln(AssetClassCommodityPolypropylene4Choice.builder()
					.setPlstc(ifThenElseResult48)
					.setOthr(ifThenElseResult49)
					.build())
				.build());
			
			return Optional.ofNullable(cmmdty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
