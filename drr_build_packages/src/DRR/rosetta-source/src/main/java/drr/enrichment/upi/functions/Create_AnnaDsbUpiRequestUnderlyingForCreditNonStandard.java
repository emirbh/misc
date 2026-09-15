package drr.enrichment.upi.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Loan;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.util.string.functions.ReplaceAll;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard.Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandardDefault.class)
public abstract class Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Compute_IndexTermValue compute_IndexTermValue;
	@Inject protected DebtSeniority debtSeniority;
	@Inject protected GetCreditUnderlierISIN getCreditUnderlierISIN;
	@Inject protected GetCreditUnderlierLEI getCreditUnderlierLEI;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_Loan qualify_CreditDefaultSwap_Loan;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected ReplaceAll replaceAll;
	@Inject protected TranslateIndexNameToId translateIndexNameToId;

	/**
	* @param product 
	* @return underlying 
	*/
	public AnnaDsbUnderlying evaluate(NonTransferableProduct product) {
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlyingBuilder = doEvaluate(product);
		
		final AnnaDsbUnderlying underlying;
		if (underlyingBuilder == null) {
			underlying = null;
		} else {
			underlying = underlyingBuilder.build();
			objectValidator.validate(AnnaDsbUnderlying.class, underlying);
		}
		
		return underlying;
	}

	protected abstract AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product);

	protected abstract MapperS<? extends FieldWithMetaString> indexName(NonTransferableProduct product);

	public static class Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandardDefault extends Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard {
		@Override
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder doEvaluate(NonTransferableProduct product) {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying = AnnaDsbUnderlying.builder();
			return assignOutput(underlying, product);
		}
		
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder assignOutput(AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying, NonTransferableProduct product) {
			AnnaDsbSingleName ifThenElseResult2 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(product).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(product).get())))).getOrDefault(false)) {
				final AnnaDsbUnderlierIDSourceEnum ifThenElseResult0;
				if (exists(MapperS.of(getCreditUnderlierLEI.evaluate(economicTerms(product).get()))).getOrDefault(false)) {
					ifThenElseResult0 = AnnaDsbUnderlierIDSourceEnum.LEI;
				} else if (exists(MapperS.of(getCreditUnderlierISIN.evaluate(economicTerms(product).get()))).getOrDefault(false)) {
					ifThenElseResult0 = AnnaDsbUnderlierIDSourceEnum.ISIN;
				} else {
					ifThenElseResult0 = null;
				}
				final String ifThenElseResult1;
				if (exists(MapperS.of(getCreditUnderlierLEI.evaluate(economicTerms(product).get()))).getOrDefault(false)) {
					ifThenElseResult1 = getCreditUnderlierLEI.evaluate(economicTerms(product).get());
				} else if (exists(MapperS.of(getCreditUnderlierISIN.evaluate(economicTerms(product).get()))).getOrDefault(false)) {
					ifThenElseResult1 = getCreditUnderlierISIN.evaluate(economicTerms(product).get());
				} else {
					ifThenElseResult1 = null;
				}
				ifThenElseResult2 = AnnaDsbSingleName.builder()
					.setUnderlierIDSource(ifThenElseResult0)
					.setUnderlierID(ifThenElseResult1)
					.setDebtSeniority(debtSeniority.evaluate(product, AnnaDsbUseCaseEnum.NON_STANDARD))
					.build();
			}
			underlying
				.getOrCreateUnderlyingAssetType()
				.setSingleName(ifThenElseResult2);
			
			final Boolean boolean0 = qualify_CreditDefaultSwap_Index.evaluate(economicTerms(product).get());
			AnnaDsbCDSIndex ifThenElseResult4 = null;
			if ((boolean0 == null ? false : boolean0)) {
				final FieldWithMetaString fieldWithMetaString0 = indexName(product).get();
				final String ifThenElseResult3;
				if (exists(MapperS.of(translateIndexNameToId.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue())))).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString1 = indexName(product).get();
					ifThenElseResult3 = translateIndexNameToId.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()));
				} else {
					final FieldWithMetaString fieldWithMetaString2 = indexName(product).get();
					ifThenElseResult3 = replaceAll.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), ".\\d+.*", "");
				}
				ifThenElseResult4 = AnnaDsbCDSIndex.builder()
					.setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum.CRIDX)
					.setUnderlierID(ifThenElseResult3)
					.setUnderlyingInstrumentIndexTermValue(compute_IndexTermValue.evaluate(economicTerms(product).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), economicTerms(product).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get()))
					.setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR)
					.setUnderlyingCreditIndexSeries(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexSeries", creditIndex -> creditIndex.getIndexSeries()).get())
					.setUnderlyingCreditIndexVersion(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexAnnexVersion", creditIndex -> creditIndex.getIndexAnnexVersion()).get())
					.build();
			}
			underlying
				.getOrCreateUnderlyingAssetType()
				.setCDSIndex(ifThenElseResult4);
			
			final Boolean boolean1 = qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(product).get());
			AnnaDsbCDSIndex ifThenElseResult6 = null;
			if ((boolean1 == null ? false : boolean1)) {
				final FieldWithMetaString fieldWithMetaString3 = indexName(product).get();
				final String ifThenElseResult5;
				if (exists(MapperS.of(translateIndexNameToId.evaluate((fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue())))).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString4 = indexName(product).get();
					ifThenElseResult5 = translateIndexNameToId.evaluate((fieldWithMetaString4 == null ? null : fieldWithMetaString4.getValue()));
				} else {
					final FieldWithMetaString fieldWithMetaString5 = indexName(product).get();
					ifThenElseResult5 = replaceAll.evaluate((fieldWithMetaString5 == null ? null : fieldWithMetaString5.getValue()), ".\\d+.*", "");
				}
				ifThenElseResult6 = AnnaDsbCDSIndex.builder()
					.setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum.CRIDX)
					.setUnderlierID(ifThenElseResult5)
					.setUnderlyingInstrumentIndexTermValue(compute_IndexTermValue.evaluate(economicTerms(product).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), economicTerms(product).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get()))
					.setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR)
					.setUnderlyingCreditIndexSeries(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexSeries", creditIndex -> creditIndex.getIndexSeries()).get())
					.setUnderlyingCreditIndexVersion(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexAnnexVersion", creditIndex -> creditIndex.getIndexAnnexVersion()).get())
					.build();
			}
			underlying
				.getOrCreateUnderlyingAssetType()
				.setCDSIndexTranche(ifThenElseResult6);
			
			return Optional.ofNullable(underlying)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> indexName(NonTransferableProduct product) {
			return MapperS.of(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get());
		}
	}
}
