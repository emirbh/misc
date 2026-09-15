package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.ProductForEvent;
import drr.enrichment.upi.UpiData;
import drr.regulation.common.ReportableEvent;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Enrich_ReportableEventWithUpiFromAnnaDsb.Enrich_ReportableEventWithUpiFromAnnaDsbDefault.class)
public abstract class Enrich_ReportableEventWithUpiFromAnnaDsb implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractUpi extractUpi;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param reportableEvent 
	* @param upiRecord 
	* @param underlyingUpiRecord 
	* @return reportableEventWithUpi 
	*/
	public ReportableEvent evaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
		ReportableEvent.ReportableEventBuilder reportableEventWithUpiBuilder = doEvaluate(reportableEvent, upiRecord, underlyingUpiRecord);
		
		final ReportableEvent reportableEventWithUpi;
		if (reportableEventWithUpiBuilder == null) {
			reportableEventWithUpi = null;
		} else {
			reportableEventWithUpi = reportableEventWithUpiBuilder.build();
			objectValidator.validate(ReportableEvent.class, reportableEventWithUpi);
		}
		
		return reportableEventWithUpi;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord);

	protected abstract MapperS<String> existingUpi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord);

	protected abstract MapperC<? extends ProductTaxonomy> existingCfi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord);

	protected abstract MapperS<? extends ProductIdentifier> existingUnderlyingUpi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord);

	public static class Enrich_ReportableEventWithUpiFromAnnaDsbDefault extends Enrich_ReportableEventWithUpiFromAnnaDsb {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
			ReportableEvent.ReportableEventBuilder reportableEventWithUpi = ReportableEvent.builder();
			return assignOutput(reportableEventWithUpi, reportableEvent, upiRecord, underlyingUpiRecord);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder reportableEventWithUpi, ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
			reportableEventWithUpi = toBuilder(reportableEvent, () -> ReportableEvent.builder());
			
			final List<UpiData> ifThenElseResult0;
			if (exists(MapperS.of(upiRecord)).getOrDefault(false)) {
				final UpiData upiData0 = UpiData.builder()
					.setUpiRecord(upiRecord)
					.setUpiOfUnderlying(false)
					.setUpiValidation(true)
					.build();
				ifThenElseResult0 = upiData0 == null ? Collections.<UpiData>emptyList() : Collections.singletonList(upiData0);
			} else {
				ifThenElseResult0 = Collections.<UpiData>emptyList();
			}
			reportableEventWithUpi
				.getOrCreateReportableInformation()
				.getOrCreateEnrichment()
				.addUpiData(ifThenElseResult0);
			
			final List<UpiData> ifThenElseResult1;
			if (exists(MapperS.of(underlyingUpiRecord)).getOrDefault(false)) {
				final UpiData upiData1 = UpiData.builder()
					.setUpiRecord(underlyingUpiRecord)
					.setUpiOfUnderlying(true)
					.setUpiValidation(true)
					.build();
				ifThenElseResult1 = upiData1 == null ? Collections.<UpiData>emptyList() : Collections.singletonList(upiData1);
			} else {
				ifThenElseResult1 = Collections.<UpiData>emptyList();
			}
			reportableEventWithUpi
				.getOrCreateReportableInformation()
				.getOrCreateEnrichment()
				.addUpiData(ifThenElseResult1);
			
			final List<ProductIdentifier> ifThenElseResult2;
			if (exists(MapperS.of(underlyingUpiRecord)).andNullSafe(notExists(existingUnderlyingUpi(reportableEvent, upiRecord, underlyingUpiRecord))).getOrDefault(false)) {
				final ProductIdentifier productIdentifier0 = ProductIdentifier.builder()
					.setIdentifierValue(MapperS.of(upiRecord).<AnnaDsbIdentifier>map("getIdentifier", annaDsbUpiRecord -> annaDsbUpiRecord.getIdentifier()).<String>map("getUPI", annaDsbIdentifier -> annaDsbIdentifier.getUPI()).get())
					.setSource(ProductIdTypeEnum.UPI)
					.build();
				ifThenElseResult2 = productIdentifier0 == null ? Collections.<ProductIdentifier>emptyList() : Collections.singletonList(productIdentifier0);
			} else {
				ifThenElseResult2 = Collections.<ProductIdentifier>emptyList();
			}
			reportableEventWithUpi
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateAfter(0)
				.getOrCreateTrade()
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateOptionPayout()
				.getOrCreateUnderlier()
				.getOrCreateProduct()
				.getOrCreateNonTransferableProduct()
				.addIdentifier(ifThenElseResult2);
			
			final List<ProductIdentifier> ifThenElseResult3;
			if (exists(MapperS.of(upiRecord)).andNullSafe(notExists(existingUpi(reportableEvent, upiRecord, underlyingUpiRecord))).getOrDefault(false)) {
				final ProductIdentifier productIdentifier1 = ProductIdentifier.builder()
					.setIdentifierValue(MapperS.of(upiRecord).<AnnaDsbIdentifier>map("getIdentifier", annaDsbUpiRecord -> annaDsbUpiRecord.getIdentifier()).<String>map("getUPI", annaDsbIdentifier -> annaDsbIdentifier.getUPI()).get())
					.setSource(ProductIdTypeEnum.UPI)
					.build();
				ifThenElseResult3 = productIdentifier1 == null ? Collections.<ProductIdentifier>emptyList() : Collections.singletonList(productIdentifier1);
			} else {
				ifThenElseResult3 = Collections.<ProductIdentifier>emptyList();
			}
			reportableEventWithUpi
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateAfter(0)
				.getOrCreateTrade()
				.getOrCreateProduct()
				.addIdentifier(ifThenElseResult3);
			
			final List<ProductTaxonomy> ifThenElseResult4;
			if (exists(MapperS.of(upiRecord)).andNullSafe(exists(MapperS.of(upiRecord).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<String>map("getClassificationType", annaDsbDerived -> annaDsbDerived.getClassificationType()))).andNullSafe(notExists(existingCfi(reportableEvent, upiRecord, underlyingUpiRecord))).getOrDefault(false)) {
				final ProductTaxonomy productTaxonomy = ProductTaxonomy.builder()
					.setValue(TaxonomyValue.builder()
						.setNameValue(MapperS.of(upiRecord).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<String>map("getClassificationType", annaDsbDerived -> annaDsbDerived.getClassificationType()).get())
						.build())
					.setSource(TaxonomySourceEnum.CFI)
					.build();
				ifThenElseResult4 = productTaxonomy == null ? Collections.<ProductTaxonomy>emptyList() : Collections.singletonList(productTaxonomy);
			} else {
				ifThenElseResult4 = Collections.<ProductTaxonomy>emptyList();
			}
			reportableEventWithUpi
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateAfter(0)
				.getOrCreateTrade()
				.getOrCreateProduct()
				.addTaxonomy(ifThenElseResult4);
			
			return Optional.ofNullable(reportableEventWithUpi)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> existingUpi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
			return MapperS.of(extractUpi.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperC<? extends ProductTaxonomy> existingCfi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
			return MapperS.of(productForEvent.evaluate(reportableEvent)).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.CFI), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperS<? extends ProductIdentifier> existingUnderlyingUpi(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord, AnnaDsbUpiRecord underlyingUpiRecord) {
			final MapperC<ProductIdentifier> thenArg = MapperS.of(MapperS.of(productForEvent.evaluate(reportableEvent)).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
	}
}
