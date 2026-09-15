package drr.regulation.common.functions;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractReferenceEntity.ExtractReferenceEntityDefault.class)
public abstract class ExtractReferenceEntity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return referenceEntity 
	*/
	public EntityIdentifier evaluate(ReportableEventBase reportableEvent) {
		EntityIdentifier.EntityIdentifierBuilder referenceEntityBuilder = doEvaluate(reportableEvent);
		
		final EntityIdentifier referenceEntity;
		if (referenceEntityBuilder == null) {
			referenceEntity = null;
		} else {
			referenceEntity = referenceEntityBuilder.build();
			objectValidator.validate(EntityIdentifier.class, referenceEntity);
		}
		
		return referenceEntity;
	}

	protected abstract EntityIdentifier.EntityIdentifierBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends LegalEntity> referenceEntityProduct(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends EntityIdentifier> referenceEntityByType(ReportableEventBase reportableEvent);

	public static class ExtractReferenceEntityDefault extends ExtractReferenceEntity {
		@Override
		protected EntityIdentifier.EntityIdentifierBuilder doEvaluate(ReportableEventBase reportableEvent) {
			EntityIdentifier.EntityIdentifierBuilder referenceEntity = EntityIdentifier.builder();
			return assignOutput(referenceEntity, reportableEvent);
		}
		
		protected EntityIdentifier.EntityIdentifierBuilder assignOutput(EntityIdentifier.EntityIdentifierBuilder referenceEntity, ReportableEventBase reportableEvent) {
			final MapperC<? extends EntityIdentifier> thenArg;
			if (exists(referenceEntityByType(reportableEvent)).getOrDefault(false)) {
				thenArg = referenceEntityByType(reportableEvent);
			} else {
				thenArg = referenceEntityProduct(reportableEvent).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier());
			}
			referenceEntity = toBuilder(thenArg
				.last().get());
			
			return Optional.ofNullable(referenceEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperC<? extends LegalEntity> referenceEntityProduct(ReportableEventBase reportableEvent) {
			final Boolean boolean0 = isCreditSwaption.evaluate(product(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity());
			}
			final Boolean boolean1 = isCredit.evaluate(product(reportableEvent).get());
			if ((boolean1 == null ? false : boolean1)) {
				return product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity());
			}
			return MapperC.<LegalEntity>ofNull();
		}
		
		@Override
		protected MapperC<? extends EntityIdentifier> referenceEntityByType(ReportableEventBase reportableEvent) {
			final MapperC<EntityIdentifier> thenArg = referenceEntityProduct(reportableEvent).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier());
			return thenArg
				.filterItemNullSafe(item -> areEqual(MapperC.<EntityIdentifierTypeEnum>of(MapperS.of(EntityIdentifierTypeEnum.LEI), MapperS.of(EntityIdentifierTypeEnum.COUNTRY_CODE)), item.<EntityIdentifierTypeEnum>map("getIdentifierType", entityIdentifier -> entityIdentifier.getIdentifierType()), CardinalityOperator.Any).get());
		}
	}
}
