package drr.enrichment.upi.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.util.string.functions.ReplaceAll;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestUnderlyingForCredit.Create_AnnaDsbUpiRequestUnderlyingForCreditDefault.class)
public abstract class Create_AnnaDsbUpiRequestUnderlyingForCredit implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Compute_IndexTermValue compute_IndexTermValue;
	@Inject protected DebtSeniority debtSeniority;
	@Inject protected GetCreditUnderlierISIN getCreditUnderlierISIN;
	@Inject protected GetCreditUnderlierLEI getCreditUnderlierLEI;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected ReplaceAll replaceAll;
	@Inject protected TranslateIndexNameToId translateIndexNameToId;

	/**
	* @param product 
	* @param useCase 
	* @return underlying 
	*/
	public AnnaDsbUnderlying evaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlyingBuilder = doEvaluate(product, useCase);
		
		final AnnaDsbUnderlying underlying;
		if (underlyingBuilder == null) {
			underlying = null;
		} else {
			underlying = underlyingBuilder.build();
			objectValidator.validate(AnnaDsbUnderlying.class, underlying);
		}
		
		return underlying;
	}

	protected abstract AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder doEvaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperS<? extends FieldWithMetaString> indexName(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	public static class Create_AnnaDsbUpiRequestUnderlyingForCreditDefault extends Create_AnnaDsbUpiRequestUnderlyingForCredit {
		@Override
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder doEvaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying = AnnaDsbUnderlying.builder();
			return assignOutput(underlying, product, useCase);
		}
		
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder assignOutput(AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying, NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			final AnnaDsbUnderlierIDSourceEnum ifThenElseResult0;
			if (exists(MapperS.of(getCreditUnderlierLEI.evaluate(economicTerms(product, useCase).get()))).getOrDefault(false)) {
				ifThenElseResult0 = AnnaDsbUnderlierIDSourceEnum.LEI;
			} else if (exists(MapperS.of(getCreditUnderlierISIN.evaluate(economicTerms(product, useCase).get()))).getOrDefault(false)) {
				ifThenElseResult0 = AnnaDsbUnderlierIDSourceEnum.ISIN;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				ifThenElseResult0 = AnnaDsbUnderlierIDSourceEnum.CRIDX;
			} else {
				ifThenElseResult0 = null;
			}
			underlying
				.setUnderlierIDSource(ifThenElseResult0);
			
			final String ifThenElseResult1;
			if (exists(MapperS.of(getCreditUnderlierLEI.evaluate(economicTerms(product, useCase).get()))).getOrDefault(false)) {
				ifThenElseResult1 = getCreditUnderlierLEI.evaluate(economicTerms(product, useCase).get());
			} else if (exists(MapperS.of(getCreditUnderlierISIN.evaluate(economicTerms(product, useCase).get()))).getOrDefault(false)) {
				ifThenElseResult1 = getCreditUnderlierISIN.evaluate(economicTerms(product, useCase).get());
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = indexName(product, useCase).get();
				if (exists(MapperS.of(translateIndexNameToId.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue())))).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString1 = indexName(product, useCase).get();
					ifThenElseResult1 = translateIndexNameToId.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()));
				} else {
					final FieldWithMetaString fieldWithMetaString2 = indexName(product, useCase).get();
					ifThenElseResult1 = replaceAll.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), ".\\d+.*", "");
				}
			} else {
				ifThenElseResult1 = null;
			}
			underlying
				.setUnderlierID(ifThenElseResult1);
			
			Integer ifThenElseResult2 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				ifThenElseResult2 = compute_IndexTermValue.evaluate(economicTerms(product, useCase).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), economicTerms(product, useCase).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
			}
			underlying
				.setUnderlyingInstrumentIndexTermValue(ifThenElseResult2);
			
			AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ifThenElseResult3 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				ifThenElseResult3 = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR;
			}
			underlying
				.setUnderlyingInstrumentIndexTermUnit(ifThenElseResult3);
			
			Integer ifThenElseResult4 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				ifThenElseResult4 = economicTerms(product, useCase).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexSeries", creditIndex -> creditIndex.getIndexSeries()).get();
			}
			underlying
				.setUnderlyingCreditIndexSeries(ifThenElseResult4);
			
			Integer ifThenElseResult5 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product, useCase).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product, useCase).get())))).getOrDefault(false)) {
				ifThenElseResult5 = economicTerms(product, useCase).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexAnnexVersion", creditIndex -> creditIndex.getIndexAnnexVersion()).get();
			}
			underlying
				.setUnderlyingCreditIndexVersion(ifThenElseResult5);
			
			AnnaDsbDebtSeniorityEnum ifThenElseResult6 = null;
			if (areEqual(MapperS.of(useCase), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = debtSeniority.evaluate(product, useCase);
			}
			underlying
				.setDebtSeniority(ifThenElseResult6);
			
			return Optional.ofNullable(underlying)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> indexName(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			return MapperS.of(economicTerms(product, useCase).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get());
		}
	}
}
