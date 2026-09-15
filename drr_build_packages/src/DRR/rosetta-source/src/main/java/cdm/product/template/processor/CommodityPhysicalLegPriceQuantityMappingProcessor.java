package cdm.product.template.processor;

import cdm.base.staticdata.asset.common.*;
import cdm.event.common.Trade;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.product.template.TradeLot;
import com.regnosys.rosetta.common.translation.*;
import com.regnosys.rosetta.common.util.PathUtils;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.path.RosettaPath;

import java.util.List;
import java.util.Optional;

import static com.regnosys.rosetta.common.translation.MappingProcessorUtils.getNonNullMappedValue;
import static com.regnosys.rosetta.common.translation.MappingProcessorUtils.getNonNullMapping;

@SuppressWarnings("unused")
public class CommodityPhysicalLegPriceQuantityMappingProcessor extends MappingProcessor {

    public CommodityPhysicalLegPriceQuantityMappingProcessor(RosettaPath modelPath, List<Path> synonymPaths, MappingContext context) {
        super(modelPath, synonymPaths, context);
    }

    @Override
    public void map(Path synonymPath, List<? extends RosettaModelObjectBuilder> builder, RosettaModelObjectBuilder parent) {
        Trade.TradeBuilder tradeBuilder = (Trade.TradeBuilder) parent;

        TradeLot.TradeLotBuilder tradeLotBuilder = tradeBuilder.getOrCreateTradeLot(0);
        RosettaPath tradeLotModelPath = getModelPath().getParent().newSubPath("tradeLot", 0);

        int priceQuantityIndex = builder.size();
        PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = tradeLotBuilder.getOrCreatePriceQuantity(priceQuantityIndex);
        RosettaPath priceQuantityModelPath = tradeLotModelPath.newSubPath("priceQuantity", priceQuantityIndex);

        getObservable(synonymPath, priceQuantityModelPath)
                .map(CommodityPhysicalLegPriceQuantityMappingProcessor::toReferencableObservableBuilder)
                .ifPresent(priceQuantityBuilder::setObservable);
    }

    private Optional<Observable> getObservable(Path commoditySwapSynonymPath, RosettaPath priceQuantityModelPath) {
        Observable.ObservableBuilder observableBuilder = Observable.builder();
        Asset.AssetBuilder assetBuilder = observableBuilder.getOrCreateAsset();

        RosettaPath assetModelPath = priceQuantityModelPath
                .newSubPath("observable")
                .newSubPath("value")
                .newSubPath("Asset");

        getCommodity(commoditySwapSynonymPath.addElement("coalPhysicalLeg"), assetModelPath).ifPresent(assetBuilder::setCommodity);
        getCommodity(commoditySwapSynonymPath.addElement("electricityPhysicalLeg"), assetModelPath).ifPresent(assetBuilder::setCommodity);
        getCommodity(commoditySwapSynonymPath.addElement("environmentalPhysicalLeg"), assetModelPath).ifPresent(assetBuilder::setCommodity);
        getCommodity(commoditySwapSynonymPath.addElement("gasPhysicalLeg"), assetModelPath).ifPresent(assetBuilder::setCommodity);
        getCommodity(commoditySwapSynonymPath.addElement("oilPhysicalLeg"), assetModelPath).ifPresent(assetBuilder::setCommodity);

        return observableBuilder.hasData() ? Optional.of(observableBuilder) : Optional.empty();
    }

    private Optional<Commodity> getCommodity(Path legSynonymPath, RosettaPath assetModelPath) {
        Commodity.CommodityBuilder commodityBuilder = Commodity.builder();

        RosettaPath commodityModelPath = assetModelPath.newSubPath("Commodity");

        int classificationIndex = 0;
        while (true) {
            RosettaPath taxonomyModelPath = commodityModelPath.newSubPath("taxonomy", classificationIndex);
            Path commodityClassificationSynonymPath = legSynonymPath.addElement("commodityClassification", classificationIndex++);

            Optional<Taxonomy> taxonomy = getTaxonomy(commodityClassificationSynonymPath, taxonomyModelPath);
            if (taxonomy.isEmpty()) {
                break;
            } else {
                commodityBuilder.addTaxonomy(taxonomy.get());
            }
        }
        return commodityBuilder.hasData() ? Optional.of(commodityBuilder) : Optional.empty();
    }

    private Optional<Taxonomy> getTaxonomy(Path commodityClassificationSynonymPath, RosettaPath taxonomyModelPath) {
        Taxonomy.TaxonomyBuilder taxonomyBuilder = Taxonomy.builder();
        TaxonomyValue.TaxonomyValueBuilder taxonomyValueBuilder = taxonomyBuilder.getOrCreateValue();

        RosettaPath taxonomyValueModelPath = taxonomyModelPath.newSubPath("value");

        int codeIndex = 0;
        while (true) {
            RosettaPath classificationModelPath = taxonomyValueModelPath.newSubPath("classification", codeIndex);
            Path codeSynonymPath = commodityClassificationSynonymPath.addElement("code", codeIndex++);

            Optional<TaxonomyClassification> classification = getTaxonomyClassification(codeSynonymPath, classificationModelPath);
            if (classification.isEmpty()) {
                break;
            } else {
                TaxonomyClassification taxonomyClassification = classification.get();
                taxonomyBuilder.getOrCreateValue().addClassification(taxonomyClassification);

                if (taxonomyBuilder.getSource() == null) {
                    Path classificationSchemeSynonymPath = codeSynonymPath.addElement("commodityClassificationScheme");
                    getNonNullMappedValue(classificationSchemeSynonymPath, getMappings())
                            .flatMap(this::getTaxonomySource)
                            .ifPresent(taxonomyBuilder::setSource);
                }
            }
        }
        return taxonomyBuilder.hasData() ? Optional.of(taxonomyBuilder) : Optional.empty();
    }

    private Optional<TaxonomyClassification> getTaxonomyClassification(Path codeSynonymPath, RosettaPath classificationModelPath) {
        TaxonomyClassification.TaxonomyClassificationBuilder taxonomyClassificationBuilder = TaxonomyClassification.builder();

        // classification code (with special logic to make the address/location reference work)
        getNonNullMapping(getMappings(), codeSynonymPath)
                .ifPresent(codeMapping -> {
                    String xmlValue = String.valueOf(codeMapping.getXmlValue());
                    taxonomyClassificationBuilder.setValue(xmlValue);
                    updateMapping(codeMapping, PathUtils.toPath(classificationModelPath.newSubPath("value")));
                });

        // classification ordinal
        Path classificationSchemeSynonymPath = codeSynonymPath.addElement("commodityClassificationScheme");
        MappingProcessorUtils.setValueAndUpdateMappings(classificationSchemeSynonymPath,
                scheme -> taxonomyClassificationBuilder.setOrdinal(getOrdinal(scheme)),
                getMappings(),
                classificationModelPath.newSubPath("ordinal"));

        return taxonomyClassificationBuilder.hasData() ? Optional.of(taxonomyClassificationBuilder) : Optional.empty();
    }

    private Integer getOrdinal(String scheme) {
        switch (scheme) {
            case "http://www.fpml.org/coding-scheme/esma-emir-refit-layer-1-commodity-classification":
            case "http://www.fpml.org/coding-scheme/isda-layer-1-commodity-classification":
                return 1;
            case "http://www.fpml.org/coding-scheme/esma-emir-refit-layer-2-commodity-classification":
            case "http://www.fpml.org/coding-scheme/isda-layer-2-commodity-classification":
                return 2;
            case "http://www.fpml.org/coding-scheme/esma-emir-refit-layer-3-commodity-classification":
            case "http://www.fpml.org/coding-scheme/isda-layer-3-commodity-classification":
                return 3;
            default:
                return null;
        }
    }

    private static FieldWithMetaObservable.FieldWithMetaObservableBuilder toReferencableObservableBuilder(Observable observable) {
        FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = FieldWithMetaObservable.builder().setValue(observable);
        observableBuilder.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
        return observableBuilder;
    }

    private void updateMapping(Mapping mapping, Path modelPath) {
        mapping.setRosettaPath(modelPath);
        // clear errors
        mapping.setError(null);
        mapping.setCondition(true);
        mapping.setDuplicate(false);
    }

    private Optional<TaxonomySourceEnum> getTaxonomySource(String value) {
        if ("http://www.fpml.org/coding-scheme/esma-emir-refit-layer-1-commodity-classification".equals(value)) {
            return Optional.of(TaxonomySourceEnum.EMIR);
        } else if ("http://www.fpml.org/coding-scheme/isda-layer-1-commodity-classification".equals(value)) {
            return Optional.of(TaxonomySourceEnum.ISDA);
        }
        return Optional.empty();
    }
}