package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.asset.CommodityClassificationLayer;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityClassificationToTaxonomy.MapCommodityClassificationToTaxonomyDefault.class)
public abstract class MapCommodityClassificationToTaxonomy implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationOrdinal mapCommodityClassificationOrdinal;

	/**
	* @param fpmlCommodityClassification 
	* @return taxonomy 
	*/
	public Taxonomy evaluate(CommodityClassification fpmlCommodityClassification) {
		Taxonomy.TaxonomyBuilder taxonomyBuilder = doEvaluate(fpmlCommodityClassification);
		
		final Taxonomy taxonomy;
		if (taxonomyBuilder == null) {
			taxonomy = null;
		} else {
			taxonomy = taxonomyBuilder.build();
			objectValidator.validate(Taxonomy.class, taxonomy);
		}
		
		return taxonomy;
	}

	protected abstract Taxonomy.TaxonomyBuilder doEvaluate(CommodityClassification fpmlCommodityClassification);

	protected abstract MapperS<String> scheme(CommodityClassification fpmlCommodityClassification);

	protected abstract MapperS<TaxonomySourceEnum> source(CommodityClassification fpmlCommodityClassification);

	public static class MapCommodityClassificationToTaxonomyDefault extends MapCommodityClassificationToTaxonomy {
		@Override
		protected Taxonomy.TaxonomyBuilder doEvaluate(CommodityClassification fpmlCommodityClassification) {
			Taxonomy.TaxonomyBuilder taxonomy = Taxonomy.builder();
			return assignOutput(taxonomy, fpmlCommodityClassification);
		}
		
		protected Taxonomy.TaxonomyBuilder assignOutput(Taxonomy.TaxonomyBuilder taxonomy, CommodityClassification fpmlCommodityClassification) {
			taxonomy = toBuilder(Taxonomy.builder()
				.setSource(source(fpmlCommodityClassification).get())
				.setValue(TaxonomyValue.builder()
					.setNameValue(null)
					.setClassification(MapperS.of(fpmlCommodityClassification).<CommodityClassificationLayer>mapC("getCode", commodityClassification -> commodityClassification.getCode())
						.mapItem(item -> MapperS.of(TaxonomyClassification.builder()
							.setValue(item.<String>map("getValue", commodityClassificationLayer -> commodityClassificationLayer.getValue()).get())
							.setOrdinal(mapCommodityClassificationOrdinal.evaluate(item.<String>map("getCommodityClassificationScheme", commodityClassificationLayer -> commodityClassificationLayer.getCommodityClassificationScheme()).get()))
							.build())).getMulti())
					.build())
				.build());
			
			return Optional.ofNullable(taxonomy)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> scheme(CommodityClassification fpmlCommodityClassification) {
			return MapperS.of(fpmlCommodityClassification).<CommodityClassificationLayer>mapC("getCode", commodityClassification -> commodityClassification.getCode())
				.first().<String>map("getCommodityClassificationScheme", commodityClassificationLayer -> commodityClassificationLayer.getCommodityClassificationScheme());
		}
		
		@Override
		protected MapperS<TaxonomySourceEnum> source(CommodityClassification fpmlCommodityClassification) {
			if (areEqual(scheme(fpmlCommodityClassification), MapperS.of("http://www.fpml.org/coding-scheme/isda-layer-1-commodity-classification"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(TaxonomySourceEnum.ISDA);
			}
			if (areEqual(scheme(fpmlCommodityClassification), MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-layer-1-commodity-classification"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(TaxonomySourceEnum.EMIR);
			}
			return MapperS.<TaxonomySourceEnum>ofNull();
		}
	}
}
