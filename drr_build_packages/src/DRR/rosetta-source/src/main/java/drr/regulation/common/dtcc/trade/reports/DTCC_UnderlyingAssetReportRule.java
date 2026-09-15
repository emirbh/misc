package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.LegalEntity;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.common.trade.underlier.functions.GetUnderlierIDForBasket;
import drr.regulation.common.trade.underlier.functions.GetUnderlierIDForIndex;
import drr.regulation.common.trade.underlier.functions.GetUnderlierLEIForCredit;
import drr.regulation.common.trade.underlier.functions.IsUnderlierForIndex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_UnderlyingAssetReportRule.DTCC_UnderlyingAssetReportRuleDefault.class)
public abstract class DTCC_UnderlyingAssetReportRule implements ReportFunction<TransactionReportInstruction, List<? extends UnderlyingAssetReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected DTCC_UnderlyingAssetIDTypeRule dTCC_UnderlyingAssetIDTypeRule;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetUnderlierIDForBasket getUnderlierIDForBasket;
	@Inject protected GetUnderlierIDForIndex getUnderlierIDForIndex;
	@Inject protected GetUnderlierLEIForCredit getUnderlierLEIForCredit;
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsUnderlierForIndex isUnderlierForIndex;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends UnderlyingAssetReport> evaluate(TransactionReportInstruction input) {
		List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends UnderlyingAssetReport> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(UnderlyingAssetReport::build).collect(Collectors.toList());
			objectValidator.validate(UnderlyingAssetReport.class, output);
		}
		
		return output;
	}

	protected abstract List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_UnderlyingAssetReportRuleDefault extends DTCC_UnderlyingAssetReportRule {
		@Override
		protected List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> assignOutput(List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).get());
			output = toBuilder(thenArg
				.mapSingleToList(reportableEvent -> {
					final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(thenArg.get()));
					final MapperS<NonTransferableProduct> thenArg1 = thenArg0
						.mapSingleToItem(item -> {
							final Boolean _boolean = isCreditSwaption.evaluate(item.get());
							if ((_boolean == null ? false : _boolean)) {
								return MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
							}
							return item;
						});
					return thenArg1
						.mapSingleToList(item -> {
							if (areEqual(MapperS.of(getUnderlyingIdentificationType.evaluate(reportableEvent.get())), MapperS.of(UnderlyingIdentificationTypeEnum.B), CardinalityOperator.All).getOrDefault(false)) {
								if (exists(MapperC.<String>of(getUnderlierIDForBasket.evaluate(item.get()))).getOrDefault(false)) {
									final MapperC<String> _thenArg0 = MapperC.<String>of(getUnderlierIDForBasket.evaluate(item.get()));
									return _thenArg0
										.mapItem(_item -> MapperS.of(UnderlyingAssetReport.builder()
											.setUnderlyingAssetID(_item.get())
											.setUnderlyingAssetIDType("Basket")
											.build()));
								}
								if (exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem()).<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<LegalEntity>map("getReferenceEntity", referencePair -> referencePair.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier())).getOrDefault(false)) {
									final MapperC<EntityIdentifier> _thenArg1 = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem()).<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<LegalEntity>map("getReferenceEntity", referencePair -> referencePair.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier());
									return _thenArg1
										.mapItem(_item -> {
											final FieldWithMetaString fieldWithMetaString = _item.<FieldWithMetaString>map("getIdentifier", entityIdentifier -> entityIdentifier.getIdentifier()).get();
											return MapperS.of(UnderlyingAssetReport.builder()
												.setUnderlyingAssetID((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))
												.setUnderlyingAssetIDType("LEI")
												.build());
										});
								}
								return MapperC.of(Collections.singletonList(UnderlyingAssetReport.builder()
									.setUnderlyingAssetIDType("Basket")
									.build()));
							}
							if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null))).getOrDefault(false)) {
								final MapperC<AssetIdentifier> thenArg2 = MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null));
								return thenArg2
									.mapItem(_item -> {
										if (areEqual(MapperS.of(dTCC_UnderlyingAssetIDTypeRule.evaluate(_item.get())), MapperS.of("SingleOther"), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isUnderlierForIndex.evaluate(reportableEvent.get())))).getOrDefault(false)) {
											final FieldWithMetaString fieldWithMetaString0 = _item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
											return MapperS.of(UnderlyingAssetReport.builder()
												.setUnderlyingAssetID((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()))
												.setUnderlyingAssetIDType("Index")
												.build());
										}
										final FieldWithMetaString fieldWithMetaString1 = _item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
										return MapperS.of(UnderlyingAssetReport.builder()
											.setUnderlyingAssetID((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()))
											.setUnderlyingAssetIDType(dTCC_UnderlyingAssetIDTypeRule.evaluate(_item.get()))
											.build());
									});
							}
							if (exists(MapperC.<String>of(getUnderlierIDForIndex.evaluate(item.get()))).getOrDefault(false)) {
								final MapperC<String> thenArg3 = MapperC.<String>of(getUnderlierIDForIndex.evaluate(item.get()));
								return thenArg3
									.mapItem(_item -> MapperS.of(UnderlyingAssetReport.builder()
										.setUnderlyingAssetID(_item.get())
										.setUnderlyingAssetIDType("Index")
										.build()));
							}
							if (exists(MapperC.<String>of(getUnderlierLEIForCredit.evaluate(item.get()))).getOrDefault(false)) {
								final MapperC<String> thenArg4 = MapperC.<String>of(getUnderlierLEIForCredit.evaluate(item.get()));
								return thenArg4
									.mapItem(_item -> MapperS.of(UnderlyingAssetReport.builder()
										.setUnderlyingAssetID(_item.get())
										.setUnderlyingAssetIDType("LEI")
										.build()));
							}
							return MapperC.<UnderlyingAssetReport>ofNull();
						});
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
