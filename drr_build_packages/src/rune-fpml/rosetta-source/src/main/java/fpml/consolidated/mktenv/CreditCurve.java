package fpml.consolidated.mktenv;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.cd.DeliverableObligations;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.mktenv.meta.CreditCurveMeta;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.PricingStructure;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A generic credit curve definition.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A generic credit curve definition.
 *
 */
@RosettaDataType(value="CreditCurve", builder=CreditCurve.CreditCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditCurve", model="fpml", builder=CreditCurve.CreditCurveBuilderImpl.class, version="2.1.1")
public interface CreditCurve extends PricingStructure {

	CreditCurveMeta metaData = new CreditCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The entity for which this is defined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The entity for which this is defined.
	 *
	 */
	LegalEntity getReferenceEntity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An XML reference a credit entity defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An XML reference a credit entity defined elsewhere in the document.
	 *
	 */
	LegalEntityReference getCreditEntityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The material credit event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The material credit event.
	 *
	 */
	CreditEvents getCreditEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The level of seniority of the deliverable obligation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The level of seniority of the deliverable obligation.
	 *
	 */
	CreditSeniority getSeniority();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the deliverable obligation is secured or unsecured.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the deliverable obligation is secured or unsecured.
	 *
	 */
	Boolean getSecured();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency of denomination of the deliverable obligation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency of denomination of the deliverable obligation.
	 *
	 */
	Currency getObligationCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The underlying obligations of the reference entity on which you are buying or selling protection
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The underlying obligations of the reference entity on which you are buying or selling protection
	 *
	 */
	Obligations getObligations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision What sort of obligation may be delivered in the event of the credit event. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision What sort of obligation may be delivered in the event of the credit event. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category
	 *
	 */
	DeliverableObligations getDeliverableObligations();

	/*********************** Build Methods  ***********************/
	CreditCurve build();
	
	CreditCurve.CreditCurveBuilder toBuilder();
	
	static CreditCurve.CreditCurveBuilder builder() {
		return new CreditCurve.CreditCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditCurve> getType() {
		return CreditCurve.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.class, getCreditEntityReference());
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("secured"), Boolean.class, getSecured(), this);
		processRosetta(path.newSubPath("obligationCurrency"), processor, Currency.class, getObligationCurrency());
		processRosetta(path.newSubPath("obligations"), processor, Obligations.class, getObligations());
		processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.class, getDeliverableObligations());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditCurveBuilder extends CreditCurve, PricingStructure.PricingStructureBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		@Override
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference();
		@Override
		LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference();
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		@Override
		CreditEvents.CreditEventsBuilder getCreditEvents();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		Currency.CurrencyBuilder getOrCreateObligationCurrency();
		@Override
		Currency.CurrencyBuilder getObligationCurrency();
		Obligations.ObligationsBuilder getOrCreateObligations();
		@Override
		Obligations.ObligationsBuilder getObligations();
		DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations();
		@Override
		DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations();
		@Override
		CreditCurve.CreditCurveBuilder setId(String id);
		@Override
		CreditCurve.CreditCurveBuilder setName(String name);
		@Override
		CreditCurve.CreditCurveBuilder setCurrency(Currency currency);
		CreditCurve.CreditCurveBuilder setReferenceEntity(LegalEntity referenceEntity);
		CreditCurve.CreditCurveBuilder setCreditEntityReference(LegalEntityReference creditEntityReference);
		CreditCurve.CreditCurveBuilder setCreditEvents(CreditEvents creditEvents);
		CreditCurve.CreditCurveBuilder setSeniority(CreditSeniority seniority);
		CreditCurve.CreditCurveBuilder setSecured(Boolean secured);
		CreditCurve.CreditCurveBuilder setObligationCurrency(Currency obligationCurrency);
		CreditCurve.CreditCurveBuilder setObligations(Obligations obligations);
		CreditCurve.CreditCurveBuilder setDeliverableObligations(DeliverableObligations deliverableObligations);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getCreditEntityReference());
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("secured"), Boolean.class, getSecured(), this);
			processRosetta(path.newSubPath("obligationCurrency"), processor, Currency.CurrencyBuilder.class, getObligationCurrency());
			processRosetta(path.newSubPath("obligations"), processor, Obligations.ObligationsBuilder.class, getObligations());
			processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.DeliverableObligationsBuilder.class, getDeliverableObligations());
		}
		

		CreditCurve.CreditCurveBuilder prune();
	}

	/*********************** Immutable Implementation of CreditCurve  ***********************/
	class CreditCurveImpl extends PricingStructure.PricingStructureImpl implements CreditCurve {
		private final LegalEntity referenceEntity;
		private final LegalEntityReference creditEntityReference;
		private final CreditEvents creditEvents;
		private final CreditSeniority seniority;
		private final Boolean secured;
		private final Currency obligationCurrency;
		private final Obligations obligations;
		private final DeliverableObligations deliverableObligations;
		
		protected CreditCurveImpl(CreditCurve.CreditCurveBuilder builder) {
			super(builder);
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.creditEntityReference = ofNullable(builder.getCreditEntityReference()).map(f->f.build()).orElse(null);
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.secured = builder.getSecured();
			this.obligationCurrency = ofNullable(builder.getObligationCurrency()).map(f->f.build()).orElse(null);
			this.obligations = ofNullable(builder.getObligations()).map(f->f.build()).orElse(null);
			this.deliverableObligations = ofNullable(builder.getDeliverableObligations()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEntityReference")
		public LegalEntityReference getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("secured")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secured")
		public Boolean getSecured() {
			return secured;
		}
		
		@Override
		@RosettaAttribute("obligationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligationCurrency")
		public Currency getObligationCurrency() {
			return obligationCurrency;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligations")
		public Obligations getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableObligations")
		public DeliverableObligations getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public CreditCurve build() {
			return this;
		}
		
		@Override
		public CreditCurve.CreditCurveBuilder toBuilder() {
			CreditCurve.CreditCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditCurve.CreditCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getCreditEntityReference()).ifPresent(builder::setCreditEntityReference);
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getSecured()).ifPresent(builder::setSecured);
			ofNullable(getObligationCurrency()).ifPresent(builder::setObligationCurrency);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
			ofNullable(getDeliverableObligations()).ifPresent(builder::setDeliverableObligations);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurve _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(secured, _that.getSecured())) return false;
			if (!Objects.equals(obligationCurrency, _that.getObligationCurrency())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (secured != null ? secured.hashCode() : 0);
			_result = 31 * _result + (obligationCurrency != null ? obligationCurrency.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurve {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"seniority=" + this.seniority + ", " +
				"secured=" + this.secured + ", " +
				"obligationCurrency=" + this.obligationCurrency + ", " +
				"obligations=" + this.obligations + ", " +
				"deliverableObligations=" + this.deliverableObligations +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditCurve  ***********************/
	class CreditCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl implements CreditCurve.CreditCurveBuilder {
	
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected LegalEntityReference.LegalEntityReferenceBuilder creditEntityReference;
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected Boolean secured;
		protected Currency.CurrencyBuilder obligationCurrency;
		protected Obligations.ObligationsBuilder obligations;
		protected DeliverableObligations.DeliverableObligationsBuilder deliverableObligations;
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEntityReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (creditEntityReference!=null) {
				result = creditEntityReference;
			}
			else {
				result = creditEntityReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secured")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secured")
		public Boolean getSecured() {
			return secured;
		}
		
		@Override
		@RosettaAttribute("obligationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligationCurrency")
		public Currency.CurrencyBuilder getObligationCurrency() {
			return obligationCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateObligationCurrency() {
			Currency.CurrencyBuilder result;
			if (obligationCurrency!=null) {
				result = obligationCurrency;
			}
			else {
				result = obligationCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligations")
		public Obligations.ObligationsBuilder getObligations() {
			return obligations;
		}
		
		@Override
		public Obligations.ObligationsBuilder getOrCreateObligations() {
			Obligations.ObligationsBuilder result;
			if (obligations!=null) {
				result = obligations;
			}
			else {
				result = obligations = Obligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableObligations")
		public DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations() {
			DeliverableObligations.DeliverableObligationsBuilder result;
			if (deliverableObligations!=null) {
				result = deliverableObligations;
			}
			else {
				result = deliverableObligations = DeliverableObligations.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CreditCurve.CreditCurveBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public CreditCurve.CreditCurveBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public CreditCurve.CreditCurveBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public CreditCurve.CreditCurveBuilder setReferenceEntity(LegalEntity _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEntityReference")
		@Override
		public CreditCurve.CreditCurveBuilder setCreditEntityReference(LegalEntityReference _creditEntityReference) {
			this.creditEntityReference = _creditEntityReference == null ? null : _creditEntityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEvents")
		@Override
		public CreditCurve.CreditCurveBuilder setCreditEvents(CreditEvents _creditEvents) {
			this.creditEvents = _creditEvents == null ? null : _creditEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public CreditCurve.CreditCurveBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secured")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secured")
		@Override
		public CreditCurve.CreditCurveBuilder setSecured(Boolean _secured) {
			this.secured = _secured == null ? null : _secured;
			return this;
		}
		
		@RosettaAttribute("obligationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("obligationCurrency")
		@Override
		public CreditCurve.CreditCurveBuilder setObligationCurrency(Currency _obligationCurrency) {
			this.obligationCurrency = _obligationCurrency == null ? null : _obligationCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("obligations")
		@Override
		public CreditCurve.CreditCurveBuilder setObligations(Obligations _obligations) {
			this.obligations = _obligations == null ? null : _obligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliverableObligations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliverableObligations")
		@Override
		public CreditCurve.CreditCurveBuilder setDeliverableObligations(DeliverableObligations _deliverableObligations) {
			this.deliverableObligations = _deliverableObligations == null ? null : _deliverableObligations.toBuilder();
			return this;
		}
		
		@Override
		public CreditCurve build() {
			return new CreditCurve.CreditCurveImpl(this);
		}
		
		@Override
		public CreditCurve.CreditCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurve.CreditCurveBuilder prune() {
			super.prune();
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (creditEntityReference!=null && !creditEntityReference.prune().hasData()) creditEntityReference = null;
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			if (obligationCurrency!=null && !obligationCurrency.prune().hasData()) obligationCurrency = null;
			if (obligations!=null && !obligations.prune().hasData()) obligations = null;
			if (deliverableObligations!=null && !deliverableObligations.prune().hasData()) deliverableObligations = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getCreditEntityReference()!=null && getCreditEntityReference().hasData()) return true;
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getSecured()!=null) return true;
			if (getObligationCurrency()!=null && getObligationCurrency().hasData()) return true;
			if (getObligations()!=null && getObligations().hasData()) return true;
			if (getDeliverableObligations()!=null && getDeliverableObligations().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurve.CreditCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditCurve.CreditCurveBuilder o = (CreditCurve.CreditCurveBuilder) other;
			
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getCreditEntityReference(), o.getCreditEntityReference(), this::setCreditEntityReference);
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getObligationCurrency(), o.getObligationCurrency(), this::setObligationCurrency);
			merger.mergeRosetta(getObligations(), o.getObligations(), this::setObligations);
			merger.mergeRosetta(getDeliverableObligations(), o.getDeliverableObligations(), this::setDeliverableObligations);
			
			merger.mergeBasic(getSecured(), o.getSecured(), this::setSecured);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurve _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(secured, _that.getSecured())) return false;
			if (!Objects.equals(obligationCurrency, _that.getObligationCurrency())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (secured != null ? secured.hashCode() : 0);
			_result = 31 * _result + (obligationCurrency != null ? obligationCurrency.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveBuilder {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"seniority=" + this.seniority + ", " +
				"secured=" + this.secured + ", " +
				"obligationCurrency=" + this.obligationCurrency + ", " +
				"obligations=" + this.obligations + ", " +
				"deliverableObligations=" + this.deliverableObligations +
			'}' + " " + super.toString();
		}
	}
}
