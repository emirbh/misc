package drr.base.trade.underlier.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Basket;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.BondReference;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierProductIdentifier.UnderlierProductIdentifierDefault.class)
public abstract class UnderlierProductIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected IsFRA isFRA;
	@Inject protected IsProductETD isProductETD;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @param identifierType 
	* @return assetId 
	*/
	public List<? extends AssetIdentifier> evaluate(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
		List<AssetIdentifier.AssetIdentifierBuilder> assetIdBuilder = doEvaluate(product, identifierType);
		
		final List<? extends AssetIdentifier> assetId;
		if (assetIdBuilder == null) {
			assetId = null;
		} else {
			assetId = assetIdBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, assetId);
		}
		
		return assetId;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends Payout> productPayout(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends Payout> underlierPayout(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends ReferenceObligation> cdsProduct(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends ReferenceObligation> cdsUnderlying(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends CreditIndex> cdsIndexUnderlying(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends CreditIndex> cdsIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends FloatingRateIndex> floatingRateIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends InflationIndex> inflationRateIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> cdsProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> underlierProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperS<? extends AssetIdentifier> underlierProductName(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> etdProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends ProductIdentifier> otcProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> otcAssetID(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> indexProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperS<? extends AssetIdentifier> indexNoProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> basketProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	protected abstract MapperC<? extends AssetIdentifier> basketNoProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType);

	public static class UnderlierProductIdentifierDefault extends UnderlierProductIdentifier {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			List<AssetIdentifier.AssetIdentifierBuilder> assetId = new ArrayList<>();
			return assignOutput(assetId, product, identifierType);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> assetId, NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			assetId.addAll(toBuilder(MapperC.<AssetIdentifier>of(cdsProductID(product, identifierType), underlierProductID(product, identifierType), underlierProductName(product, identifierType), etdProductID(product, identifierType), indexProductId(product, identifierType), indexNoProductId(product, identifierType), basketProductId(product, identifierType), basketNoProductId(product, identifierType))
				.filterItemNullSafe(item -> notExists(MapperS.of(identifierType)).orNullSafe(areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(identifierType), CardinalityOperator.All)).get()).getMulti()));
			
			final MapperC<? extends ProductIdentifier> thenArg = otcProductID(product, identifierType)
				.filterItemNullSafe(item -> notExists(MapperS.of(identifierType)).orNullSafe(areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()).checkedMap("to-enum", e -> AssetIdTypeEnum.valueOf(e.name()), IllegalArgumentException.class), MapperS.of(identifierType), CardinalityOperator.All)).get());
			assetId.addAll(toBuilder(thenArg
				.mapItem(item -> MapperS.of(AssetIdentifier.builder()
					.setIdentifier(item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier()).get())
					.setIdentifierType(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()).checkedMap("to-enum", e -> AssetIdTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())).getMulti()));
			
			return Optional.ofNullable(assetId)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Payout> productPayout(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
		}
		
		@Override
		protected MapperC<? extends Payout> underlierPayout(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
		}
		
		@Override
		protected MapperC<? extends ReferenceObligation> cdsProduct(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return productPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation());
		}
		
		@Override
		protected MapperC<? extends ReferenceObligation> cdsUnderlying(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return underlierPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation());
		}
		
		@Override
		protected MapperC<? extends CreditIndex> cdsIndexUnderlying(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return underlierPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation());
		}
		
		@Override
		protected MapperC<? extends CreditIndex> cdsIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return productPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation());
		}
		
		@Override
		protected MapperC<? extends FloatingRateIndex> floatingRateIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return productPayout(product, identifierType).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex());
		}
		
		@Override
		protected MapperC<? extends InflationIndex> inflationRateIndex(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			return productPayout(product, identifierType).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex());
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> cdsProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			final MapperC<? extends ReferenceObligation> thenArg0;
			if (exists(cdsProduct(product, identifierType)).getOrDefault(false)) {
				thenArg0 = cdsProduct(product, identifierType);
			} else if (exists(cdsUnderlying(product, identifierType)).getOrDefault(false)) {
				thenArg0 = cdsUnderlying(product, identifierType);
			} else {
				thenArg0 = MapperC.<ReferenceObligation>ofNull();
			}
			final MapperListOfLists<AssetIdentifier> thenArg1 = thenArg0
				.mapItemToList(item -> {
					if (exists(item.<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity())).getOrDefault(false)) {
						return item.<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan())).getOrDefault(false)) {
						return item.<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
			return thenArg1
				.flattenList();
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> underlierProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			final MapperS<Underlier> thenArg;
			if (exists(MapperS.of(underlierForProduct.evaluate(product))).getOrDefault(false)) {
				thenArg = MapperS.of(underlierForProduct.evaluate(product));
			} else {
				thenArg = MapperS.<Underlier>ofNull();
			}
			return thenArg.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable())
				.mapSingleToList(item -> {
					if (exists(item.<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					if (exists(item.<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", referenceWithMetaObservable5 -> referenceWithMetaObservable5 == null ? null : referenceWithMetaObservable5.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
					}
					if (exists(item.<Observable>map("Type coercion", referenceWithMetaObservable6 -> referenceWithMetaObservable6 == null ? null : referenceWithMetaObservable6.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(product)))).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", referenceWithMetaObservable7 -> referenceWithMetaObservable7 == null ? null : referenceWithMetaObservable7.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
		}
		
		@Override
		protected MapperS<? extends AssetIdentifier> underlierProductName(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			final MapperS<Underlier> thenArg;
			if (exists(MapperS.of(underlierForProduct.evaluate(product))).getOrDefault(false)) {
				thenArg = MapperS.of(underlierForProduct.evaluate(product));
			} else {
				thenArg = MapperS.<Underlier>ofNull();
			}
			return thenArg.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable())
				.mapSingleToItem(item -> {
					if (exists(item.<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaString>map("chooseName", index -> indexDeepPathUtil.chooseName(index))).getOrDefault(false)) {
						return MapperS.of(AssetIdentifier.builder()
							.setIdentifier(item.<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaString>map("chooseName", index -> indexDeepPathUtil.chooseName(index)).get())
							.setIdentifierType(AssetIdTypeEnum.NAME)
							.build());
					}
					return MapperS.<AssetIdentifier>ofNull();
				});
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> etdProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			final Boolean _boolean = isProductETD.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				if (exists(MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())).getOrDefault(false)) {
					return MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
				}
				if (exists(MapperS.of(underlierForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
					return MapperS.of(underlierForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
				}
				return MapperC.<AssetIdentifier>ofNull();
			}
			return MapperC.<AssetIdentifier>ofNull();
		}
		
		@Override
		protected MapperC<? extends ProductIdentifier> otcProductID(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())).getOrDefault(false)) {
				return MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier());
			}
			return MapperC.<ProductIdentifier>ofNull();
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> otcAssetID(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(productPayout(product, identifierType).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier())).getOrDefault(false)) {
				return productPayout(product, identifierType).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
			}
			if (exists(productPayout(product, identifierType).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())).getOrDefault(false)) {
				return productPayout(product, identifierType).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
			}
			return MapperC.<AssetIdentifier>ofNull();
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> indexProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(cdsIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier())).getOrDefault(false)) {
				return cdsIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier());
			}
			if (exists(cdsIndexUnderlying(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier())).getOrDefault(false)) {
				return cdsIndexUnderlying(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier());
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isFRA.evaluate(product))).andNullSafe(exists(floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()))).getOrDefault(false)) {
				return floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier());
			}
			final Boolean boolean0 = qualify_BaseProduct_IRSwap.evaluate(economicTermsForProduct.evaluate(product));
			if ((boolean0 == null ? false : boolean0)) {
				return MapperC.<AssetIdentifier>of(floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()), floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()));
			}
			final Boolean boolean1 = qualify_BaseProduct_IRSwap.evaluate(economicTermsForProduct.evaluate(product));
			if ((boolean1 == null ? false : boolean1)) {
				return MapperC.<AssetIdentifier>of(floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()), inflationRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", inflationIndex -> inflationIndex.getIdentifier()));
			}
			return MapperC.<AssetIdentifier>ofNull();
		}
		
		@Override
		protected MapperS<? extends AssetIdentifier> indexNoProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(cdsIndex(product, identifierType).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName())).andNullSafe(notExists(cdsIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier()))).getOrDefault(false)) {
				return MapperS.of(AssetIdentifier.builder()
					.setIdentifier(cdsIndex(product, identifierType)
						.first().<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get())
					.setIdentifierType(AssetIdTypeEnum.NAME)
					.build());
			}
			if (exists(cdsIndexUnderlying(product, identifierType).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName())).andNullSafe(notExists(cdsIndexUnderlying(product, identifierType).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier()))).getOrDefault(false)) {
				return MapperS.of(AssetIdentifier.builder()
					.setIdentifier(cdsIndexUnderlying(product, identifierType)
						.first().<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get())
					.setIdentifierType(AssetIdTypeEnum.NAME)
					.build());
			}
			if (exists(floatingRateIndex(product, identifierType).<FieldWithMetaString>map("getName", _floatingRateIndex -> _floatingRateIndex.getName())).andNullSafe(notExists(floatingRateIndex(product, identifierType).<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()))).getOrDefault(false)) {
				return MapperS.of(AssetIdentifier.builder()
					.setIdentifier(floatingRateIndex(product, identifierType).<FieldWithMetaString>map("getName", _floatingRateIndex -> _floatingRateIndex.getName()).get())
					.setIdentifierType(AssetIdTypeEnum.NAME)
					.build());
			}
			return MapperS.<AssetIdentifier>ofNull();
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> basketProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Basket>map("getBasket", observable -> observable.getBasket())).getOrDefault(false)) {
				return MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier());
			}
			return MapperC.<AssetIdentifier>ofNull();
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> basketNoProductId(NonTransferableProduct product, AssetIdTypeEnum identifierType) {
			if (exists(productPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())).getOrDefault(false)) {
				return productPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())
					.mapItem(item -> MapperS.of(AssetIdentifier.builder()
						.setIdentifier(item.get())
						.setIdentifierType(AssetIdTypeEnum.OTHER)
						.build()));
			}
			if (exists(underlierPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())).getOrDefault(false)) {
				return underlierPayout(product, identifierType).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())
					.mapItem(item -> MapperS.of(AssetIdentifier.builder()
						.setIdentifier(item.get())
						.setIdentifierType(AssetIdTypeEnum.OTHER)
						.build()));
			}
			return MapperC.<AssetIdentifier>ofNull();
		}
	}
}
