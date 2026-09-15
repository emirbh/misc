package drr.regulation.common.trade.underlier.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ProductOrUnderlierProduct;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnderlyingAssetName.GetUnderlyingAssetNameDefault.class)
public abstract class GetUnderlyingAssetName implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected ProductOrUnderlierProduct productOrUnderlierProduct;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param transactionReportInstruction 
	* @param regimeName 
	* @return name 
	*/
	public List<String> evaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
		List<String> name = doEvaluate(transactionReportInstruction, regimeName);
		
		return name;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName);

	public static class GetUnderlyingAssetNameDefault extends GetUnderlyingAssetName {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
			List<String> name = new ArrayList<>();
			return assignOutput(name, transactionReportInstruction, regimeName);
		}
		
		protected List<String> assignOutput(List<String> name, TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
			final MapperS<NonTransferableProduct> thenArg0;
			if (areEqual(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()).<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(regimeName), CardinalityOperator.Any).andNullSafe(greaterThan(MapperS.of(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()).resultCount()), MapperS.of(1), CardinalityOperator.All)).getOrDefault(false)) {
				thenArg0 = MapperS.of(productForEvent.evaluate(transactionReportInstruction));
			} else {
				thenArg0 = MapperS.<NonTransferableProduct>ofNull();
			}
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg2 = thenArg1
				.mapSingleToItem(item -> MapperS.of(productOrUnderlierProduct.evaluate(item.get())));
			name.addAll(thenArg2
				.mapSingleToList(item -> {
					if (exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
						return MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName());
					}
					if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
						return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName());
					}
					if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null))).getOrDefault(false)) {
						final MapperC<AssetIdentifier> _thenArg0 = MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null));
						final MapperC<AssetIdentifier> _thenArg1 = _thenArg0
							.filterItemNullSafe(_item -> areEqual(_item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.NAME), CardinalityOperator.All).get());
						return _thenArg1.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier());
					}
					return MapperC.<FieldWithMetaString>ofNull();
				}).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			
			return name;
		}
	}
}
