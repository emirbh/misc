package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.AgriculturalCommodityDairy2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityForestry2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityGrain3;
import iso20022.auth030.hkma.tr.AgriculturalCommodityLiveStock2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOilSeed2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOliveOil3;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOther2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityPotato2;
import iso20022.auth030.hkma.tr.AgriculturalCommoditySeafood2;
import iso20022.auth030.hkma.tr.AgriculturalCommoditySoft2;
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
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType10Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType11Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType29Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType2Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType30Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType31Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType32Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType33Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType34Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType5Code;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType8Code;
import iso20022.auth030.hkma.tr.AssetClassProductType11Code;
import iso20022.auth030.hkma.tr.AssetClassProductType12Code;
import iso20022.auth030.hkma.tr.AssetClassProductType13Code;
import iso20022.auth030.hkma.tr.AssetClassProductType14Code;
import iso20022.auth030.hkma.tr.AssetClassProductType15Code;
import iso20022.auth030.hkma.tr.AssetClassProductType16Code;
import iso20022.auth030.hkma.tr.AssetClassProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassProductType2Code;
import iso20022.auth030.hkma.tr.AssetClassProductType3Code;
import iso20022.auth030.hkma.tr.AssetClassProductType4Code;
import iso20022.auth030.hkma.tr.AssetClassProductType5Code;
import iso20022.auth030.hkma.tr.AssetClassProductType6Code;
import iso20022.auth030.hkma.tr.AssetClassProductType7Code;
import iso20022.auth030.hkma.tr.AssetClassProductType8Code;
import iso20022.auth030.hkma.tr.AssetClassProductType9Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType10Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType15Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType16Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType18Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType20Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType21Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType22Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType23Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType24Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType25Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType26Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType27Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType28Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType29Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType2Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType30Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType31Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType32Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType33Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType34Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType35Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType36Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType37Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType39Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType3Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType40Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType41Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType42Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType43Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType44Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType45Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType46Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType49Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType50Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType5Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType6Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType7Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType8Code;
import iso20022.auth030.hkma.tr.EnergyCommodityCoal2;
import iso20022.auth030.hkma.tr.EnergyCommodityDistillates2;
import iso20022.auth030.hkma.tr.EnergyCommodityElectricity2;
import iso20022.auth030.hkma.tr.EnergyCommodityInterEnergy2;
import iso20022.auth030.hkma.tr.EnergyCommodityLightEnd2;
import iso20022.auth030.hkma.tr.EnergyCommodityNaturalGas3;
import iso20022.auth030.hkma.tr.EnergyCommodityOil3;
import iso20022.auth030.hkma.tr.EnergyCommodityOther2;
import iso20022.auth030.hkma.tr.EnergyCommodityRenewableEnergy2;
import iso20022.auth030.hkma.tr.EnvironmentCommodityOther2;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityEmission3;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityWeather2;
import iso20022.auth030.hkma.tr.FertilizerCommodityAmmonia2;
import iso20022.auth030.hkma.tr.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.hkma.tr.FertilizerCommodityOther2;
import iso20022.auth030.hkma.tr.FertilizerCommodityPotash2;
import iso20022.auth030.hkma.tr.FertilizerCommoditySulphur2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUrea2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUreaAndAmmoniumNitrate2;
import iso20022.auth030.hkma.tr.FreightCommodityContainerShip2;
import iso20022.auth030.hkma.tr.FreightCommodityDry3;
import iso20022.auth030.hkma.tr.FreightCommodityOther2;
import iso20022.auth030.hkma.tr.FreightCommodityWet3;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityConstruction2;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityManufacturing2;
import iso20022.auth030.hkma.tr.MetalCommodityNonPrecious2;
import iso20022.auth030.hkma.tr.MetalCommodityPrecious2;
import iso20022.auth030.hkma.tr.PaperCommodityContainerBoard2;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import iso20022.auth030.hkma.tr.PaperCommodityOther1;
import iso20022.auth030.hkma.tr.PaperCommodityPulp2;
import iso20022.auth030.hkma.tr.PaperCommodityRecoveredPaper3;
import iso20022.auth030.hkma.tr.PolypropyleneCommodityOther2;
import iso20022.auth030.hkma.tr.PolypropyleneCommodityPlastic2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AssetClassCommodity7Choice.Create_AssetClassCommodity7ChoiceDefault.class)
public abstract class Create_AssetClassCommodity7Choice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cmmdty 
	*/
	public AssetClassCommodity7Choice evaluate(HKMATransactionReport drrReport) {
		AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder cmmdtyBuilder = doEvaluate(drrReport);
		
		final AssetClassCommodity7Choice cmmdty;
		if (cmmdtyBuilder == null) {
			cmmdty = null;
		} else {
			cmmdty = cmmdtyBuilder.build();
			objectValidator.validate(AssetClassCommodity7Choice.class, cmmdty);
		}
		
		return cmmdty;
	}

	protected abstract AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_AssetClassCommodity7ChoiceDefault extends Create_AssetClassCommodity7Choice {
		@Override
		protected AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder doEvaluate(HKMATransactionReport drrReport) {
			AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder cmmdty = AssetClassCommodity7Choice.builder();
			return assignOutput(cmmdty, drrReport);
		}
		
		protected AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder assignOutput(AssetClassCommodity7Choice.AssetClassCommodity7ChoiceBuilder cmmdty, HKMATransactionReport drrReport) {
			AgriculturalCommodityOilSeed2 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("GROS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = AgriculturalCommodityOilSeed2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySoft2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("SOFT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = AgriculturalCommoditySoft2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityPotato2 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("POTA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult2 = AgriculturalCommodityPotato2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType45Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOliveOil3 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OOLI"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult3 = AgriculturalCommodityOliveOil3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityDairy2 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("DIRY"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult4 = AgriculturalCommodityDairy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType20Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityForestry2 ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("FRST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult5 = AgriculturalCommodityForestry2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType21Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySeafood2 ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("SEAF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult6 = AgriculturalCommoditySeafood2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType23Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityLiveStock2 ifThenElseResult7 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("LSTK"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult7 = AgriculturalCommodityLiveStock2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType22Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityGrain3 ifThenElseResult8 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("GRIN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult8 = AgriculturalCommodityGrain3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOther2 ifThenElseResult9 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult9 = AgriculturalCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityElectricity2 ifThenElseResult10 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("ELEC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult10 = EnergyCommodityElectricity2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityNaturalGas3 ifThenElseResult11 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("NGAS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult11 = EnergyCommodityNaturalGas3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOil3 ifThenElseResult12 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OILP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult12 = EnergyCommodityOil3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityCoal2 ifThenElseResult13 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("COAL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult13 = EnergyCommodityCoal2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType24Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityInterEnergy2 ifThenElseResult14 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("INRG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult14 = EnergyCommodityInterEnergy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType26Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityRenewableEnergy2 ifThenElseResult15 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("RNNG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult15 = EnergyCommodityRenewableEnergy2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType28Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityLightEnd2 ifThenElseResult16 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("LGHT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult16 = EnergyCommodityLightEnd2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType27Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityDistillates2 ifThenElseResult17 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("DIST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult17 = EnergyCommodityDistillates2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType25Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOther2 ifThenElseResult18 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult18 = EnergyCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityEmission3 ifThenElseResult19 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("EMIS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult19 = EnvironmentalCommodityEmission3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityWeather2 ifThenElseResult20 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("WTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult20 = EnvironmentalCommodityWeather2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityCarbonRelated2 ifThenElseResult21 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("CRBR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult21 = EnvironmentalCommodityCarbonRelated2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentCommodityOther2 ifThenElseResult22 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult22 = EnvironmentCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityAmmonia2 ifThenElseResult23 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("AMMO"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult23 = FertilizerCommodityAmmonia2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType39Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityDiammoniumPhosphate2 ifThenElseResult24 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("DAPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult24 = FertilizerCommodityDiammoniumPhosphate2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType40Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityPotash2 ifThenElseResult25 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("PTSH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult25 = FertilizerCommodityPotash2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType41Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommoditySulphur2 ifThenElseResult26 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("SLPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult26 = FertilizerCommoditySulphur2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType42Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUrea2 ifThenElseResult27 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("UREA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult27 = FertilizerCommodityUrea2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType43Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUreaAndAmmoniumNitrate2 ifThenElseResult28 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("UAAN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult28 = FertilizerCommodityUreaAndAmmoniumNitrate2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType44Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityOther2 ifThenElseResult29 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult29 = FertilizerCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityDry3 ifThenElseResult30 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("DRYF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult30 = FreightCommodityDry3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityWet3 ifThenElseResult31 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("WETF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult31 = FreightCommodityWet3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityContainerShip2 ifThenElseResult32 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("CSHP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult32 = FreightCommodityContainerShip2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType46Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityOther2 ifThenElseResult33 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult33 = FreightCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassProductType16Code ifThenElseResult34 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("INDX"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult34 = MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType16Code::fromDisplayName, IllegalArgumentException.class).get();
			}
			IndustrialProductCommodityConstruction2 ifThenElseResult35 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("CSTR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult35 = IndustrialProductCommodityConstruction2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			IndustrialProductCommodityManufacturing2 ifThenElseResult36 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("MFTG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult36 = IndustrialProductCommodityManufacturing2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityInflation1 ifThenElseResult37 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("INFL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult37 = AssetClassCommodityInflation1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType12Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityNonPrecious2 ifThenElseResult38 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("NPRM"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult38 = MetalCommodityNonPrecious2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityPrecious2 ifThenElseResult39 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("PRME"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult39 = MetalCommodityPrecious2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType16Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", hKMATransactionReport -> hKMATransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityMultiCommodityExotic1 ifThenElseResult40 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("MCEX"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult40 = AssetClassCommodityMultiCommodityExotic1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType13Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOfficialEconomicStatistics1 ifThenElseResult41 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("OEST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult41 = AssetClassCommodityOfficialEconomicStatistics1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType14Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOther1 ifThenElseResult42 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult42 = AssetClassCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityC10Other1 ifThenElseResult43 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("OTHC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult43 = AssetClassCommodityC10Other1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityContainerBoard2 ifThenElseResult44 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("CBRD"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult44 = PaperCommodityContainerBoard2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType35Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityNewsprint2 ifThenElseResult45 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("NSPT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult45 = PaperCommodityNewsprint2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType36Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityPulp2 ifThenElseResult46 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("PULP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult46 = PaperCommodityPulp2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType37Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityRecoveredPaper3 ifThenElseResult47 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("RCVP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult47 = PaperCommodityRecoveredPaper3.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType50Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityOther1 ifThenElseResult48 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult48 = PaperCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityPlastic2 ifThenElseResult49 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("PLST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult49 = PolypropyleneCommodityPlastic2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType18Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityOther2 ifThenElseResult50 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).map("to-string", CommonAssetClass::toDisplayString), MapperS.of("COMM"), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult50 = PolypropyleneCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", hKMATransactionReport -> hKMATransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", hKMATransactionReport -> hKMATransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			cmmdty = toBuilder(AssetClassCommodity7Choice.builder()
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
				.setIndx(AssetClassCommodityIndex1.builder()
					.setBasePdct(ifThenElseResult34)
					.build())
				.setIndstrlPdct(AssetClassCommodityIndustrialProduct2Choice.builder()
					.setCnstrctn(ifThenElseResult35)
					.setManfctg(ifThenElseResult36)
					.build())
				.setInfltn(ifThenElseResult37)
				.setMetl(AssetClassCommodityMetal2Choice.builder()
					.setNonPrcs(ifThenElseResult38)
					.setPrcs(ifThenElseResult39)
					.build())
				.setMultiCmmdtyExtc(ifThenElseResult40)
				.setOffclEcnmcSttstcs(ifThenElseResult41)
				.setOthr(ifThenElseResult42)
				.setOthrC10(ifThenElseResult43)
				.setPpr(AssetClassCommodityPaper5Choice.builder()
					.setCntnrBrd(ifThenElseResult44)
					.setNwsprnt(ifThenElseResult45)
					.setPulp(ifThenElseResult46)
					.setRcvrdPpr(ifThenElseResult47)
					.setOthr(ifThenElseResult48)
					.build())
				.setPlprpln(AssetClassCommodityPolypropylene4Choice.builder()
					.setPlstc(ifThenElseResult49)
					.setOthr(ifThenElseResult50)
					.build())
				.build());
			
			return Optional.ofNullable(cmmdty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
