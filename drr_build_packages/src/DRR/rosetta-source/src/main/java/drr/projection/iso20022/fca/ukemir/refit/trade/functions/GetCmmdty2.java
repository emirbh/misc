package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.AgriculturalCommodityDairy2__1;
import iso20022.auth030.fca.AgriculturalCommodityForestry2__1;
import iso20022.auth030.fca.AgriculturalCommodityGrain3__1;
import iso20022.auth030.fca.AgriculturalCommodityLiveStock2__1;
import iso20022.auth030.fca.AgriculturalCommodityOilSeed2__1;
import iso20022.auth030.fca.AgriculturalCommodityOliveOil3__1;
import iso20022.auth030.fca.AgriculturalCommodityOther2__1;
import iso20022.auth030.fca.AgriculturalCommodityPotato2__1;
import iso20022.auth030.fca.AgriculturalCommoditySeafood2__1;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.AssetClassCommodity6Choice__2;
import iso20022.auth030.fca.AssetClassCommodityAgricultural6Choice__1;
import iso20022.auth030.fca.AssetClassCommodityC10Other1;
import iso20022.auth030.fca.AssetClassCommodityEnergy3Choice__1;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__2;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.AssetClassCommodityInflation1;
import iso20022.auth030.fca.AssetClassCommodityMetal2Choice__1;
import iso20022.auth030.fca.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.fca.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.fca.AssetClassCommodityOther1;
import iso20022.auth030.fca.AssetClassCommodityPaper4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityPolypropylene4Choice__1;
import iso20022.auth030.fca.AssetClassDetailedSubProductType10Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType11Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType1Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType29Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType2Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType30Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType31Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType32Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType33Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType34Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType5Code;
import iso20022.auth030.fca.AssetClassDetailedSubProductType8Code;
import iso20022.auth030.fca.AssetClassProductType11Code;
import iso20022.auth030.fca.AssetClassProductType12Code;
import iso20022.auth030.fca.AssetClassProductType13Code;
import iso20022.auth030.fca.AssetClassProductType14Code;
import iso20022.auth030.fca.AssetClassProductType15Code;
import iso20022.auth030.fca.AssetClassProductType1Code;
import iso20022.auth030.fca.AssetClassProductType2Code;
import iso20022.auth030.fca.AssetClassProductType3Code;
import iso20022.auth030.fca.AssetClassProductType4Code;
import iso20022.auth030.fca.AssetClassProductType5Code;
import iso20022.auth030.fca.AssetClassProductType6Code;
import iso20022.auth030.fca.AssetClassProductType7Code;
import iso20022.auth030.fca.AssetClassProductType8Code;
import iso20022.auth030.fca.AssetClassProductType9Code;
import iso20022.auth030.fca.AssetClassSubProductType10Code;
import iso20022.auth030.fca.AssetClassSubProductType15Code;
import iso20022.auth030.fca.AssetClassSubProductType16Code;
import iso20022.auth030.fca.AssetClassSubProductType18Code;
import iso20022.auth030.fca.AssetClassSubProductType1Code;
import iso20022.auth030.fca.AssetClassSubProductType20Code;
import iso20022.auth030.fca.AssetClassSubProductType21Code;
import iso20022.auth030.fca.AssetClassSubProductType22Code;
import iso20022.auth030.fca.AssetClassSubProductType23Code;
import iso20022.auth030.fca.AssetClassSubProductType24Code;
import iso20022.auth030.fca.AssetClassSubProductType25Code;
import iso20022.auth030.fca.AssetClassSubProductType26Code;
import iso20022.auth030.fca.AssetClassSubProductType27Code;
import iso20022.auth030.fca.AssetClassSubProductType28Code;
import iso20022.auth030.fca.AssetClassSubProductType29Code;
import iso20022.auth030.fca.AssetClassSubProductType2Code;
import iso20022.auth030.fca.AssetClassSubProductType30Code;
import iso20022.auth030.fca.AssetClassSubProductType31Code;
import iso20022.auth030.fca.AssetClassSubProductType32Code;
import iso20022.auth030.fca.AssetClassSubProductType33Code;
import iso20022.auth030.fca.AssetClassSubProductType34Code;
import iso20022.auth030.fca.AssetClassSubProductType35Code;
import iso20022.auth030.fca.AssetClassSubProductType36Code;
import iso20022.auth030.fca.AssetClassSubProductType37Code;
import iso20022.auth030.fca.AssetClassSubProductType39Code;
import iso20022.auth030.fca.AssetClassSubProductType3Code;
import iso20022.auth030.fca.AssetClassSubProductType40Code;
import iso20022.auth030.fca.AssetClassSubProductType41Code;
import iso20022.auth030.fca.AssetClassSubProductType42Code;
import iso20022.auth030.fca.AssetClassSubProductType43Code;
import iso20022.auth030.fca.AssetClassSubProductType44Code;
import iso20022.auth030.fca.AssetClassSubProductType45Code;
import iso20022.auth030.fca.AssetClassSubProductType46Code;
import iso20022.auth030.fca.AssetClassSubProductType49Code;
import iso20022.auth030.fca.AssetClassSubProductType5Code;
import iso20022.auth030.fca.AssetClassSubProductType6Code;
import iso20022.auth030.fca.AssetClassSubProductType7Code;
import iso20022.auth030.fca.AssetClassSubProductType8Code;
import iso20022.auth030.fca.EnergyCommodityCoal2__1;
import iso20022.auth030.fca.EnergyCommodityDistillates2__1;
import iso20022.auth030.fca.EnergyCommodityElectricity2__1;
import iso20022.auth030.fca.EnergyCommodityInterEnergy2__1;
import iso20022.auth030.fca.EnergyCommodityLightEnd2__1;
import iso20022.auth030.fca.EnergyCommodityNaturalGas3__1;
import iso20022.auth030.fca.EnergyCommodityOil3__1;
import iso20022.auth030.fca.EnergyCommodityOther2__1;
import iso20022.auth030.fca.EnergyCommodityRenewableEnergy2__1;
import iso20022.auth030.fca.EnvironmentCommodityOther2;
import iso20022.auth030.fca.EnvironmentalCommodityCarbonRelated2__1;
import iso20022.auth030.fca.EnvironmentalCommodityEmission3__1;
import iso20022.auth030.fca.EnvironmentalCommodityWeather2__1;
import iso20022.auth030.fca.FertilizerCommodityAmmonia2__1;
import iso20022.auth030.fca.FertilizerCommodityDiammoniumPhosphate2__1;
import iso20022.auth030.fca.FertilizerCommodityOther2__1;
import iso20022.auth030.fca.FertilizerCommodityPotash2__1;
import iso20022.auth030.fca.FertilizerCommoditySulphur2__1;
import iso20022.auth030.fca.FertilizerCommodityUrea2__1;
import iso20022.auth030.fca.FertilizerCommodityUreaAndAmmoniumNitrate2__1;
import iso20022.auth030.fca.FreightCommodityContainerShip2__1;
import iso20022.auth030.fca.FreightCommodityDry3__1;
import iso20022.auth030.fca.FreightCommodityOther2__1;
import iso20022.auth030.fca.FreightCommodityWet3__1;
import iso20022.auth030.fca.IndustrialProductCommodityConstruction2__1;
import iso20022.auth030.fca.IndustrialProductCommodityManufacturing2__1;
import iso20022.auth030.fca.MetalCommodityNonPrecious2__1;
import iso20022.auth030.fca.MetalCommodityPrecious2__1;
import iso20022.auth030.fca.PaperCommodityContainerBoard2__1;
import iso20022.auth030.fca.PaperCommodityNewsprint2__1;
import iso20022.auth030.fca.PaperCommodityOther1__1;
import iso20022.auth030.fca.PaperCommodityPulp2__1;
import iso20022.auth030.fca.PolypropyleneCommodityOther2__1;
import iso20022.auth030.fca.PolypropyleneCommodityPlastic2__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCmmdty2.GetCmmdty2Default.class)
public abstract class GetCmmdty2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cmmdty 
	*/
	public AssetClassCommodity6Choice__2 evaluate(FCAUKEMIRTransactionReport drrReport) {
		AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder cmmdtyBuilder = doEvaluate(drrReport);
		
		final AssetClassCommodity6Choice__2 cmmdty;
		if (cmmdtyBuilder == null) {
			cmmdty = null;
		} else {
			cmmdty = cmmdtyBuilder.build();
			objectValidator.validate(AssetClassCommodity6Choice__2.class, cmmdty);
		}
		
		return cmmdty;
	}

	protected abstract AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetCmmdty2Default extends GetCmmdty2 {
		@Override
		protected AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder cmmdty = AssetClassCommodity6Choice__2.builder();
			return assignOutput(cmmdty, drrReport);
		}
		
		protected AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder assignOutput(AssetClassCommodity6Choice__2.AssetClassCommodity6Choice__2Builder cmmdty, FCAUKEMIRTransactionReport drrReport) {
			AgriculturalCommodityOilSeed2__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("GROS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = AgriculturalCommodityOilSeed2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySoft2__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("SOFT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = AgriculturalCommoditySoft2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityPotato2__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("POTA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult2 = AgriculturalCommodityPotato2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType45Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOliveOil3__1 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OOLI"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult3 = AgriculturalCommodityOliveOil3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityDairy2__1 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("DIRY"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult4 = AgriculturalCommodityDairy2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType20Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityForestry2__1 ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("FRST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult5 = AgriculturalCommodityForestry2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType21Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommoditySeafood2__1 ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("SEAF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult6 = AgriculturalCommoditySeafood2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType23Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityLiveStock2__1 ifThenElseResult7 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("LSTK"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult7 = AgriculturalCommodityLiveStock2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType22Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityGrain3__1 ifThenElseResult8 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("GRIN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult8 = AgriculturalCommodityGrain3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AgriculturalCommodityOther2__1 ifThenElseResult9 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("AGRI"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult9 = AgriculturalCommodityOther2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType1Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityElectricity2__1 ifThenElseResult10 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("ELEC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult10 = EnergyCommodityElectricity2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityNaturalGas3__1 ifThenElseResult11 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("NGAS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult11 = EnergyCommodityNaturalGas3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOil3__1 ifThenElseResult12 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OILP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult12 = EnergyCommodityOil3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityCoal2__1 ifThenElseResult13 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("COAL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult13 = EnergyCommodityCoal2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType24Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityInterEnergy2__1 ifThenElseResult14 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("INRG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult14 = EnergyCommodityInterEnergy2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType26Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityRenewableEnergy2__1 ifThenElseResult15 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("RNNG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult15 = EnergyCommodityRenewableEnergy2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType28Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityLightEnd2__1 ifThenElseResult16 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("LGHT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult16 = EnergyCommodityLightEnd2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType27Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityDistillates2__1 ifThenElseResult17 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("DIST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult17 = EnergyCommodityDistillates2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType25Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnergyCommodityOther2__1 ifThenElseResult18 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("NRGY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult18 = EnergyCommodityOther2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType2Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityEmission3__1 ifThenElseResult19 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("EMIS"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult19 = EnvironmentalCommodityEmission3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityWeather2__1 ifThenElseResult20 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("WTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult20 = EnvironmentalCommodityWeather2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType30Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentalCommodityCarbonRelated2__1 ifThenElseResult21 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("CRBR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult21 = EnvironmentalCommodityCarbonRelated2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType29Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			EnvironmentCommodityOther2 ifThenElseResult22 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("ENVR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult22 = EnvironmentCommodityOther2.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType3Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityAmmonia2__1 ifThenElseResult23 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("AMMO"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult23 = FertilizerCommodityAmmonia2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType39Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityDiammoniumPhosphate2__1 ifThenElseResult24 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("DAPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult24 = FertilizerCommodityDiammoniumPhosphate2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType40Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityPotash2__1 ifThenElseResult25 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("PTSH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult25 = FertilizerCommodityPotash2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType41Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommoditySulphur2__1 ifThenElseResult26 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("SLPH"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult26 = FertilizerCommoditySulphur2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType42Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUrea2__1 ifThenElseResult27 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("UREA"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult27 = FertilizerCommodityUrea2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType43Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityUreaAndAmmoniumNitrate2__1 ifThenElseResult28 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("UAAN"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult28 = FertilizerCommodityUreaAndAmmoniumNitrate2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType44Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FertilizerCommodityOther2__1 ifThenElseResult29 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRTL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult29 = FertilizerCommodityOther2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType5Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityDry3__1 ifThenElseResult30 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("DRYF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult30 = FreightCommodityDry3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType31Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityWet3__1 ifThenElseResult31 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("WETF"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult31 = FreightCommodityWet3__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType32Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityContainerShip2__1 ifThenElseResult32 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("CSHP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult32 = FreightCommodityContainerShip2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType46Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			FreightCommodityOther2__1 ifThenElseResult33 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("FRGT"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult33 = FreightCommodityOther2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType4Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			IndustrialProductCommodityConstruction2__1 ifThenElseResult34 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("CSTR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult34 = IndustrialProductCommodityConstruction2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType33Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			IndustrialProductCommodityManufacturing2__1 ifThenElseResult35 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("INDP"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("MFTG"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult35 = IndustrialProductCommodityManufacturing2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType6Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType34Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityInflation1 ifThenElseResult36 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("INFL"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult36 = AssetClassCommodityInflation1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType12Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityNonPrecious2__1 ifThenElseResult37 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("NPRM"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult37 = MetalCommodityNonPrecious2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType10Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			MetalCommodityPrecious2__1 ifThenElseResult38 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("METL"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("PRME"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult38 = MetalCommodityPrecious2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType7Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType16Code::fromDisplayName, IllegalArgumentException.class).get())
					.setAddtlSubPdct(MapperS.of(drrReport).<String>map("getFurtherSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFurtherSubProduct()).checkedMap("to-enum", AssetClassDetailedSubProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityMultiCommodityExotic1 ifThenElseResult39 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("MCEX"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult39 = AssetClassCommodityMultiCommodityExotic1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType13Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOfficialEconomicStatistics1 ifThenElseResult40 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("OEST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult40 = AssetClassCommodityOfficialEconomicStatistics1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType14Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityOther1 ifThenElseResult41 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult41 = AssetClassCommodityOther1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType15Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			AssetClassCommodityC10Other1 ifThenElseResult42 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("OTHC"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult42 = AssetClassCommodityC10Other1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType11Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityContainerBoard2__1 ifThenElseResult43 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("CBRD"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult43 = PaperCommodityContainerBoard2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType35Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityNewsprint2__1 ifThenElseResult44 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("NSPT"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult44 = PaperCommodityNewsprint2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType36Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityPulp2__1 ifThenElseResult45 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("PULP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult45 = PaperCommodityPulp2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType37Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityOther1__1 ifThenElseResult46 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("RCVP"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult46 = PaperCommodityOther1__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PaperCommodityOther1__1 ifThenElseResult47 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("PAPR"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult47 = PaperCommodityOther1__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType8Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityPlastic2__1 ifThenElseResult48 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("PLST"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult48 = PolypropyleneCommodityPlastic2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType18Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			PolypropyleneCommodityOther2__1 ifThenElseResult49 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()), MapperS.of("POLY"), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()), MapperS.of("OTHR"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult49 = PolypropyleneCommodityOther2__1.builder()
					.setBasePdct(MapperS.of(drrReport).<String>map("getBaseProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBaseProduct()).checkedMap("to-enum", AssetClassProductType9Code::fromDisplayName, IllegalArgumentException.class).get())
					.setSubPdct(MapperS.of(drrReport).<String>map("getSubProduct", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubProduct()).checkedMap("to-enum", AssetClassSubProductType49Code::fromDisplayName, IllegalArgumentException.class).get())
					.build();
			}
			cmmdty = toBuilder(AssetClassCommodity6Choice__2.builder()
				.setAgrcltrl(AssetClassCommodityAgricultural6Choice__1.builder()
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
				.setNrgy(AssetClassCommodityEnergy3Choice__1.builder()
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
				.setEnvttl(AssetClassCommodityEnvironmental3Choice__2.builder()
					.setEmssns(ifThenElseResult19)
					.setWthr(ifThenElseResult20)
					.setCrbnRltd(ifThenElseResult21)
					.setOthr(ifThenElseResult22)
					.build())
				.setFrtlzr(AssetClassCommodityFertilizer4Choice__1.builder()
					.setAmmn(ifThenElseResult23)
					.setDmmnmPhspht(ifThenElseResult24)
					.setPtsh(ifThenElseResult25)
					.setSlphr(ifThenElseResult26)
					.setUrea(ifThenElseResult27)
					.setUreaAndAmmnmNtrt(ifThenElseResult28)
					.setOthr(ifThenElseResult29)
					.build())
				.setFrght(AssetClassCommodityFreight4Choice__1.builder()
					.setDry(ifThenElseResult30)
					.setWet(ifThenElseResult31)
					.setCntnrShip(ifThenElseResult32)
					.setOthr(ifThenElseResult33)
					.build())
				.setIndstrlPdct(AssetClassCommodityIndustrialProduct2Choice__1.builder()
					.setCnstrctn(ifThenElseResult34)
					.setManfctg(ifThenElseResult35)
					.build())
				.setInfltn(ifThenElseResult36)
				.setMetl(AssetClassCommodityMetal2Choice__1.builder()
					.setNonPrcs(ifThenElseResult37)
					.setPrcs(ifThenElseResult38)
					.build())
				.setMultiCmmdtyExtc(ifThenElseResult39)
				.setOffclEcnmcSttstcs(ifThenElseResult40)
				.setOthr(ifThenElseResult41)
				.setOthrC10(ifThenElseResult42)
				.setPpr(AssetClassCommodityPaper4Choice__1.builder()
					.setCntnrBrd(ifThenElseResult43)
					.setNwsprnt(ifThenElseResult44)
					.setPulp(ifThenElseResult45)
					.setRcvrdPpr(ifThenElseResult46)
					.setOthr(ifThenElseResult47)
					.build())
				.setPlprpln(AssetClassCommodityPolypropylene4Choice__1.builder()
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
