package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapProductTaxonomyList.MapProductTaxonomyListDefault.class)
public abstract class MapProductTaxonomyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetClassWithScheme mapAssetClassWithScheme;
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapTaxonomySourceEnum mapTaxonomySourceEnum;

	/**
	* @param fpmlPrimaryAssetClass 
	* @param fpmlSecondaryAssetClassList 
	* @param fpmlProductTypeList 
	* @return taxonomy 
	*/
	public List<? extends ProductTaxonomy> evaluate(AssetClass fpmlPrimaryAssetClass, List<? extends AssetClass> fpmlSecondaryAssetClassList, List<? extends ProductType> fpmlProductTypeList) {
		List<ProductTaxonomy.ProductTaxonomyBuilder> taxonomyBuilder = doEvaluate(fpmlPrimaryAssetClass, fpmlSecondaryAssetClassList, fpmlProductTypeList);
		
		final List<? extends ProductTaxonomy> taxonomy;
		if (taxonomyBuilder == null) {
			taxonomy = null;
		} else {
			taxonomy = taxonomyBuilder.stream().map(ProductTaxonomy::build).collect(Collectors.toList());
			objectValidator.validate(ProductTaxonomy.class, taxonomy);
		}
		
		return taxonomy;
	}

	protected abstract List<ProductTaxonomy.ProductTaxonomyBuilder> doEvaluate(AssetClass fpmlPrimaryAssetClass, List<? extends AssetClass> fpmlSecondaryAssetClassList, List<? extends ProductType> fpmlProductTypeList);

	public static class MapProductTaxonomyListDefault extends MapProductTaxonomyList {
		@Override
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> doEvaluate(AssetClass fpmlPrimaryAssetClass, List<? extends AssetClass> fpmlSecondaryAssetClassList, List<? extends ProductType> fpmlProductTypeList) {
			if (fpmlSecondaryAssetClassList == null) {
				fpmlSecondaryAssetClassList = Collections.emptyList();
			}
			if (fpmlProductTypeList == null) {
				fpmlProductTypeList = Collections.emptyList();
			}
			List<ProductTaxonomy.ProductTaxonomyBuilder> taxonomy = new ArrayList<>();
			return assignOutput(taxonomy, fpmlPrimaryAssetClass, fpmlSecondaryAssetClassList, fpmlProductTypeList);
		}
		
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> assignOutput(List<ProductTaxonomy.ProductTaxonomyBuilder> taxonomy, AssetClass fpmlPrimaryAssetClass, List<? extends AssetClass> fpmlSecondaryAssetClassList, List<? extends ProductType> fpmlProductTypeList) {
			final FieldWithMetaAssetClassEnum fieldWithMetaAssetClassEnum = mapAssetClassWithScheme.evaluate(MapperC.<AssetClass>of(fpmlSecondaryAssetClassList)
				.first().<String>map("getValue", assetClass -> assetClass.getValue()).get(), MapperC.<AssetClass>of(fpmlSecondaryAssetClassList)
				.first().<String>map("getAssetClassScheme", assetClass -> assetClass.getAssetClassScheme()).get());
			final ProductTaxonomy productTaxonomy = ProductTaxonomy.builder()
				.setPrimaryAssetClass(mapAssetClassWithScheme.evaluate(MapperS.of(fpmlPrimaryAssetClass).<String>map("getValue", assetClass -> assetClass.getValue()).get(), MapperS.of(fpmlPrimaryAssetClass).<String>map("getAssetClassScheme", assetClass -> assetClass.getAssetClassScheme()).get()))
				.setSecondaryAssetClass((fieldWithMetaAssetClassEnum == null ? Collections.<FieldWithMetaAssetClassEnum>emptyList() : Collections.singletonList(fieldWithMetaAssetClassEnum)))
				.build();
			if (productTaxonomy == null) {
				taxonomy.addAll(toBuilder(Collections.<ProductTaxonomy>emptyList()));
			} else {
				taxonomy.addAll(toBuilder(Collections.singletonList(productTaxonomy)));
			}
			
			taxonomy.addAll(toBuilder(MapperC.<ProductType>of(fpmlProductTypeList)
				.mapItem(item -> MapperS.of(ProductTaxonomy.builder()
					.setSource(mapTaxonomySourceEnum.evaluate(item.<String>map("getProductTypeScheme", productType -> productType.getProductTypeScheme()).get()))
					.setValue(TaxonomyValue.builder()
						.setName(mapStringWithScheme.evaluate(item.<String>map("getValue", productType -> productType.getValue()).get(), item.<String>map("getProductTypeScheme", productType -> productType.getProductTypeScheme()).get()))
						.build())
					.build())).getMulti()));
			
			return Optional.ofNullable(taxonomy)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
