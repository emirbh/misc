package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.other.functions.MapAccountTypeEnum;
import cdm.ingest.fpml.confirmation.product.bondoption.functions.MapBondOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.brokerequityoption.functions.MapBrokerEquityOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.capfloor.functions.MapCapFloorAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.commodityforward.functions.MapCommodityForwardAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.commodityoption.functions.MapCommodityOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapCommoditySwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.commodityswaption.functions.MapCommoditySwaptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.correlationswap.functions.MapCorrelationSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions.MapCreditDefaultSwapOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions.MapDividendSwapOptionTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions.MapDividendSwapTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.equityforward.functions.MapEquityForwardAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.equityoption.functions.MapEquityOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions.MapEquityOptionTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions.MapEquitySwapTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fra.functions.MapFraAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fxoption.functions.MapFxOptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fxsingleleg.functions.MapFxSingleLegAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fxswap.functions.MapFxSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions.MapFxVarianceSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions.MapFxVolatilitySwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.genericproduct.functions.MapGenericProductAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapReturnSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.swaption.functions.MapSwaptionAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions.MapVarianceOptionTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceSwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilitySwapAccountPartyReference;
import cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions.MapVolatilitySwapTransactionSupplementAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.eqd.EquityForward;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.AccountId;
import fpml.consolidated.shared.AccountName;
import fpml.consolidated.shared.AccountType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwap;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAccount.MapAccountDefault.class)
public abstract class MapAccount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccountTypeEnum mapAccountTypeEnum;
	@Inject protected MapBondOptionAccountPartyReference mapBondOptionAccountPartyReference;
	@Inject protected MapBrokerEquityOptionAccountPartyReference mapBrokerEquityOptionAccountPartyReference;
	@Inject protected MapCapFloorAccountPartyReference mapCapFloorAccountPartyReference;
	@Inject protected MapCommodityForwardAccountPartyReference mapCommodityForwardAccountPartyReference;
	@Inject protected MapCommodityOptionAccountPartyReference mapCommodityOptionAccountPartyReference;
	@Inject protected MapCommoditySwapAccountPartyReference mapCommoditySwapAccountPartyReference;
	@Inject protected MapCommoditySwaptionAccountPartyReference mapCommoditySwaptionAccountPartyReference;
	@Inject protected MapCorrelationSwapAccountPartyReference mapCorrelationSwapAccountPartyReference;
	@Inject protected MapCreditDefaultSwapAccountPartyReference mapCreditDefaultSwapAccountPartyReference;
	@Inject protected MapCreditDefaultSwapOptionAccountPartyReference mapCreditDefaultSwapOptionAccountPartyReference;
	@Inject protected MapDividendSwapOptionTransactionSupplementAccountPartyReference mapDividendSwapOptionTransactionSupplementAccountPartyReference;
	@Inject protected MapDividendSwapTransactionSupplementAccountPartyReference mapDividendSwapTransactionSupplementAccountPartyReference;
	@Inject protected MapEquityForwardAccountPartyReference mapEquityForwardAccountPartyReference;
	@Inject protected MapEquityOptionAccountPartyReference mapEquityOptionAccountPartyReference;
	@Inject protected MapEquityOptionTransactionSupplementAccountPartyReference mapEquityOptionTransactionSupplementAccountPartyReference;
	@Inject protected MapEquitySwapTransactionSupplementAccountPartyReference mapEquitySwapTransactionSupplementAccountPartyReference;
	@Inject protected MapFraAccountPartyReference mapFraAccountPartyReference;
	@Inject protected MapFxOptionAccountPartyReference mapFxOptionAccountPartyReference;
	@Inject protected MapFxSingleLegAccountPartyReference mapFxSingleLegAccountPartyReference;
	@Inject protected MapFxSwapAccountPartyReference mapFxSwapAccountPartyReference;
	@Inject protected MapFxVarianceSwapAccountPartyReference mapFxVarianceSwapAccountPartyReference;
	@Inject protected MapFxVolatilitySwapAccountPartyReference mapFxVolatilitySwapAccountPartyReference;
	@Inject protected MapGenericProductAccountPartyReference mapGenericProductAccountPartyReference;
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapReturnSwapAccountPartyReference mapReturnSwapAccountPartyReference;
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapSwapAccountPartyReference mapSwapAccountPartyReference;
	@Inject protected MapSwaptionAccountPartyReference mapSwaptionAccountPartyReference;
	@Inject protected MapVarianceOptionTransactionSupplementAccountPartyReference mapVarianceOptionTransactionSupplementAccountPartyReference;
	@Inject protected MapVarianceSwapAccountPartyReference mapVarianceSwapAccountPartyReference;
	@Inject protected MapVarianceSwapTransactionSupplementAccountPartyReference mapVarianceSwapTransactionSupplementAccountPartyReference;
	@Inject protected MapVolatilitySwapAccountPartyReference mapVolatilitySwapAccountPartyReference;
	@Inject protected MapVolatilitySwapTransactionSupplementAccountPartyReference mapVolatilitySwapTransactionSupplementAccountPartyReference;

	/**
	* @param fpmlAccountList 
	* @param fpmlTrade 
	* @return account 
	*/
	public Account evaluate(fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade) {
		Account.AccountBuilder accountBuilder = doEvaluate(fpmlAccountList, fpmlTrade);
		
		final Account account;
		if (accountBuilder == null) {
			account = null;
		} else {
			account = accountBuilder.build();
			objectValidator.validate(Account.class, account);
		}
		
		return account;
	}

	protected abstract Account.AccountBuilder doEvaluate(fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade);

	protected abstract MapperS<? extends ReferenceWithMetaParty> partyReference(fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade);

	public static class MapAccountDefault extends MapAccount {
		@Override
		protected Account.AccountBuilder doEvaluate(fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade) {
			Account.AccountBuilder account = Account.builder();
			return assignOutput(account, fpmlAccountList, fpmlTrade);
		}
		
		protected Account.AccountBuilder assignOutput(Account.AccountBuilder account, fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade) {
			final Account.AccountBuilder withMetaArgument = Account.builder()
				.setPartyReference(partyReference(fpmlAccountList, fpmlTrade).get())
				.setAccountNumber(mapStringWithScheme.evaluate(MapperS.of(MapperS.of(fpmlAccountList).<AccountId>mapC("getAccountId", _account -> _account.getAccountId()).get()).<String>map("getValue", accountId -> accountId.getValue()).get(), MapperS.of(MapperS.of(fpmlAccountList).<AccountId>mapC("getAccountId", _account -> _account.getAccountId()).get()).<String>map("getAccountIdScheme", accountId -> accountId.getAccountIdScheme()).get()))
				.setAccountName(mapStringWithScheme.evaluate(MapperS.of(fpmlAccountList).<AccountName>map("getAccountName", _account -> _account.getAccountName()).<String>map("getValue", accountName -> accountName.getValue()).get(), MapperS.of(fpmlAccountList).<AccountName>map("getAccountName", _account -> _account.getAccountName()).<String>map("getAccountNameScheme", accountName -> accountName.getAccountNameScheme()).get()))
				.setAccountTypeValue(mapAccountTypeEnum.evaluate(MapperS.of(fpmlAccountList).<AccountType>map("getAccountType", _account -> _account.getAccountType()).<String>map("getValue", accountType -> accountType.getValue()).get()))
				.setAccountBeneficiary(mapPartyReference.evaluate(MapperS.of(fpmlAccountList).<PartyReference>map("getAccountBeneficiary", _account -> _account.getAccountBeneficiary()).<String>map("getHref", _partyReference -> _partyReference.getHref()).get()))
				.setServicingParty(mapPartyReference.evaluate(MapperS.of(fpmlAccountList).<PartyReference>map("getServicingParty", _account -> _account.getServicingParty()).<String>map("getHref", _partyReference -> _partyReference.getHref()).get()))
				.build() == null ? null : Account.builder()
				.setPartyReference(partyReference(fpmlAccountList, fpmlTrade).get())
				.setAccountNumber(mapStringWithScheme.evaluate(MapperS.of(MapperS.of(fpmlAccountList).<AccountId>mapC("getAccountId", _account -> _account.getAccountId()).get()).<String>map("getValue", accountId -> accountId.getValue()).get(), MapperS.of(MapperS.of(fpmlAccountList).<AccountId>mapC("getAccountId", _account -> _account.getAccountId()).get()).<String>map("getAccountIdScheme", accountId -> accountId.getAccountIdScheme()).get()))
				.setAccountName(mapStringWithScheme.evaluate(MapperS.of(fpmlAccountList).<AccountName>map("getAccountName", _account -> _account.getAccountName()).<String>map("getValue", accountName -> accountName.getValue()).get(), MapperS.of(fpmlAccountList).<AccountName>map("getAccountName", _account -> _account.getAccountName()).<String>map("getAccountNameScheme", accountName -> accountName.getAccountNameScheme()).get()))
				.setAccountTypeValue(mapAccountTypeEnum.evaluate(MapperS.of(fpmlAccountList).<AccountType>map("getAccountType", _account -> _account.getAccountType()).<String>map("getValue", accountType -> accountType.getValue()).get()))
				.setAccountBeneficiary(mapPartyReference.evaluate(MapperS.of(fpmlAccountList).<PartyReference>map("getAccountBeneficiary", _account -> _account.getAccountBeneficiary()).<String>map("getHref", _partyReference -> _partyReference.getHref()).get()))
				.setServicingParty(mapPartyReference.evaluate(MapperS.of(fpmlAccountList).<PartyReference>map("getServicingParty", _account -> _account.getServicingParty()).<String>map("getHref", _partyReference -> _partyReference.getHref()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAccountList).<String>map("getId", _account -> _account.getId()).get());
			account = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(account)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> partyReference(fpml.consolidated.shared.Account fpmlAccountList, Trade fpmlTrade) {
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				return MapperS.<ReferenceWithMetaParty>ofNull();
			}
			if (switchArgument instanceof BondOption) {
				final BondOption bondOption = (BondOption) switchArgument;
				return MapperS.of(mapBondOptionAccountPartyReference.evaluate(bondOption, fpmlAccountList));
			}
			if (switchArgument instanceof BrokerEquityOption) {
				final BrokerEquityOption brokerEquityOption = (BrokerEquityOption) switchArgument;
				return MapperS.of(mapBrokerEquityOptionAccountPartyReference.evaluate(brokerEquityOption, fpmlAccountList));
			}
			if (switchArgument instanceof CapFloor) {
				final CapFloor capFloor = (CapFloor) switchArgument;
				return MapperS.of(mapCapFloorAccountPartyReference.evaluate(capFloor, fpmlAccountList));
			}
			if (switchArgument instanceof CommodityForward) {
				final CommodityForward commodityForward = (CommodityForward) switchArgument;
				return MapperS.of(mapCommodityForwardAccountPartyReference.evaluate(commodityForward, fpmlAccountList));
			}
			if (switchArgument instanceof CommodityOption) {
				final CommodityOption commodityOption = (CommodityOption) switchArgument;
				return MapperS.of(mapCommodityOptionAccountPartyReference.evaluate(commodityOption, fpmlAccountList));
			}
			if (switchArgument instanceof CommoditySwap) {
				final CommoditySwap commoditySwap = (CommoditySwap) switchArgument;
				return MapperS.of(mapCommoditySwapAccountPartyReference.evaluate(commoditySwap, fpmlAccountList));
			}
			if (switchArgument instanceof CommoditySwaption) {
				final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument;
				return MapperS.of(mapCommoditySwaptionAccountPartyReference.evaluate(commoditySwaption, fpmlAccountList));
			}
			if (switchArgument instanceof CorrelationSwap) {
				final CorrelationSwap correlationSwap = (CorrelationSwap) switchArgument;
				return MapperS.of(mapCorrelationSwapAccountPartyReference.evaluate(correlationSwap, fpmlAccountList));
			}
			if (switchArgument instanceof CreditDefaultSwap) {
				final CreditDefaultSwap creditDefaultSwap = (CreditDefaultSwap) switchArgument;
				return MapperS.of(mapCreditDefaultSwapAccountPartyReference.evaluate(creditDefaultSwap, fpmlAccountList));
			}
			if (switchArgument instanceof CreditDefaultSwapOption) {
				final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument;
				return MapperS.of(mapCreditDefaultSwapOptionAccountPartyReference.evaluate(creditDefaultSwapOption, fpmlAccountList));
			}
			if (switchArgument instanceof DividendSwapOptionTransactionSupplement) {
				final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument;
				return MapperS.of(mapDividendSwapOptionTransactionSupplementAccountPartyReference.evaluate(dividendSwapOptionTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof DividendSwapTransactionSupplement) {
				final DividendSwapTransactionSupplement dividendSwapTransactionSupplement = (DividendSwapTransactionSupplement) switchArgument;
				return MapperS.of(mapDividendSwapTransactionSupplementAccountPartyReference.evaluate(dividendSwapTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof EquityForward) {
				final EquityForward equityForward = (EquityForward) switchArgument;
				return MapperS.of(mapEquityForwardAccountPartyReference.evaluate(equityForward, fpmlAccountList));
			}
			if (switchArgument instanceof EquityOption) {
				final EquityOption equityOption = (EquityOption) switchArgument;
				return MapperS.of(mapEquityOptionAccountPartyReference.evaluate(equityOption, fpmlAccountList));
			}
			if (switchArgument instanceof EquityOptionTransactionSupplement) {
				final EquityOptionTransactionSupplement equityOptionTransactionSupplement = (EquityOptionTransactionSupplement) switchArgument;
				return MapperS.of(mapEquityOptionTransactionSupplementAccountPartyReference.evaluate(equityOptionTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof EquitySwapTransactionSupplement) {
				final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument;
				return MapperS.of(mapEquitySwapTransactionSupplementAccountPartyReference.evaluate(equitySwapTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof Fra) {
				final Fra fra = (Fra) switchArgument;
				return MapperS.of(mapFraAccountPartyReference.evaluate(fra, fpmlAccountList));
			}
			if (switchArgument instanceof FxOption) {
				final FxOption fxOption = (FxOption) switchArgument;
				return MapperS.of(mapFxOptionAccountPartyReference.evaluate(fxOption, fpmlAccountList));
			}
			if (switchArgument instanceof FxSingleLeg) {
				final FxSingleLeg fxSingleLeg = (FxSingleLeg) switchArgument;
				return MapperS.of(mapFxSingleLegAccountPartyReference.evaluate(fxSingleLeg, fpmlAccountList));
			}
			if (switchArgument instanceof FxSwap) {
				final FxSwap fxSwap = (FxSwap) switchArgument;
				return MapperS.of(mapFxSwapAccountPartyReference.evaluate(fxSwap, fpmlAccountList));
			}
			if (switchArgument instanceof FxVarianceSwap) {
				final FxVarianceSwap fxVarianceSwap = (FxVarianceSwap) switchArgument;
				return MapperS.of(mapFxVarianceSwapAccountPartyReference.evaluate(fxVarianceSwap, fpmlAccountList));
			}
			if (switchArgument instanceof FxVolatilitySwap) {
				final FxVolatilitySwap fxVolatilitySwap = (FxVolatilitySwap) switchArgument;
				return MapperS.of(mapFxVolatilitySwapAccountPartyReference.evaluate(fxVolatilitySwap, fpmlAccountList));
			}
			if (switchArgument instanceof GenericProduct) {
				final GenericProduct genericProduct = (GenericProduct) switchArgument;
				return MapperS.of(mapGenericProductAccountPartyReference.evaluate(genericProduct, fpmlAccountList));
			}
			if (switchArgument instanceof ReturnSwap) {
				final ReturnSwap returnSwap = (ReturnSwap) switchArgument;
				return MapperS.of(mapReturnSwapAccountPartyReference.evaluate(returnSwap, fpmlAccountList));
			}
			if (switchArgument instanceof Swap) {
				final Swap swap = (Swap) switchArgument;
				return MapperS.of(mapSwapAccountPartyReference.evaluate(swap, fpmlAccountList));
			}
			if (switchArgument instanceof Swaption) {
				final Swaption swaption = (Swaption) switchArgument;
				return MapperS.of(mapSwaptionAccountPartyReference.evaluate(swaption, fpmlAccountList));
			}
			if (switchArgument instanceof VarianceOptionTransactionSupplement) {
				final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument;
				return MapperS.of(mapVarianceOptionTransactionSupplementAccountPartyReference.evaluate(varianceOptionTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof VarianceSwap) {
				final VarianceSwap varianceSwap = (VarianceSwap) switchArgument;
				return MapperS.of(mapVarianceSwapAccountPartyReference.evaluate(varianceSwap, fpmlAccountList));
			}
			if (switchArgument instanceof VarianceSwapTransactionSupplement) {
				final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement = (VarianceSwapTransactionSupplement) switchArgument;
				return MapperS.of(mapVarianceSwapTransactionSupplementAccountPartyReference.evaluate(varianceSwapTransactionSupplement, fpmlAccountList));
			}
			if (switchArgument instanceof VolatilitySwap) {
				final VolatilitySwap volatilitySwap = (VolatilitySwap) switchArgument;
				return MapperS.of(mapVolatilitySwapAccountPartyReference.evaluate(volatilitySwap, fpmlAccountList));
			}
			if (switchArgument instanceof VolatilitySwapTransactionSupplement) {
				final VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement = (VolatilitySwapTransactionSupplement) switchArgument;
				return MapperS.of(mapVolatilitySwapTransactionSupplementAccountPartyReference.evaluate(volatilitySwapTransactionSupplement, fpmlAccountList));
			}
			return MapperS.<ReferenceWithMetaParty>ofNull();
		}
	}
}
