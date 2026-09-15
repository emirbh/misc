package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.LcFxRevaluationMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An event representing a change in either the L/C to Facility or L/C to Accrual FX rates (or both) on an outstanding letter of credit.
 *
 */
@RosettaDataType(value="LcFxRevaluation", builder=LcFxRevaluation.LcFxRevaluationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcFxRevaluation", model="fpml", builder=LcFxRevaluation.LcFxRevaluationBuilderImpl.class, version="2.1.1")
public interface LcFxRevaluation extends AbstractLcEvent {

	LcFxRevaluationMeta metaData = new LcFxRevaluationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines exchange rate between the letter of credit accrual and letter of credit currencies.
	 *
	 */
	FxTerms getLcFxRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines exchange rate between the letter of credit and facility.
	 *
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LcFxRevaluation build();
	
	LcFxRevaluation.LcFxRevaluationBuilder toBuilder();
	
	static LcFxRevaluation.LcFxRevaluationBuilder builder() {
		return new LcFxRevaluation.LcFxRevaluationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcFxRevaluation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcFxRevaluation> getType() {
		return LcFxRevaluation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.class, getPreviousEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.class, getLcFxRate());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcFxRevaluationBuilder extends LcFxRevaluation, AbstractLcEvent.AbstractLcEventBuilder {
		FxTerms.FxTermsBuilder getOrCreateLcFxRate();
		@Override
		FxTerms.FxTermsBuilder getLcFxRate();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		@Override
		FxTerms.FxTermsBuilder getFacilityFxRate();
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setComment(String comment);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LcFxRevaluation.LcFxRevaluationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcFxRevaluation.LcFxRevaluationBuilder setLcFxRate(FxTerms lcFxRate);
		LcFxRevaluation.LcFxRevaluationBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.FxTermsBuilder.class, getLcFxRate());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LcFxRevaluation.LcFxRevaluationBuilder prune();
	}

	/*********************** Immutable Implementation of LcFxRevaluation  ***********************/
	class LcFxRevaluationImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcFxRevaluation {
		private final FxTerms lcFxRate;
		private final FxTerms facilityFxRate;
		
		protected LcFxRevaluationImpl(LcFxRevaluation.LcFxRevaluationBuilder builder) {
			super(builder);
			this.lcFxRate = ofNullable(builder.getLcFxRate()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFxRate")
		public FxTerms getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LcFxRevaluation build() {
			return this;
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder toBuilder() {
			LcFxRevaluation.LcFxRevaluationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcFxRevaluation.LcFxRevaluationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcFxRate()).ifPresent(builder::setLcFxRate);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcFxRevaluation _that = getType().cast(o);
		
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFxRevaluation {" +
				"lcFxRate=" + this.lcFxRate + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcFxRevaluation  ***********************/
	class LcFxRevaluationBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl implements LcFxRevaluation.LcFxRevaluationBuilder {
	
		protected FxTerms.FxTermsBuilder lcFxRate;
		protected FxTerms.FxTermsBuilder facilityFxRate;
		
		@Override
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFxRate")
		public FxTerms.FxTermsBuilder getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateLcFxRate() {
			FxTerms.FxTermsBuilder result;
			if (lcFxRate!=null) {
				result = lcFxRate;
			}
			else {
				result = lcFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFxRate")
		public FxTerms.FxTermsBuilder getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateFacilityFxRate() {
			FxTerms.FxTermsBuilder result;
			if (facilityFxRate!=null) {
				result = facilityFxRate;
			}
			else {
				result = facilityFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentEventIdentifier")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcFxRate")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setLcFxRate(FxTerms _lcFxRate) {
			this.lcFxRate = _lcFxRate == null ? null : _lcFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityFxRate")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder setFacilityFxRate(FxTerms _facilityFxRate) {
			this.facilityFxRate = _facilityFxRate == null ? null : _facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LcFxRevaluation build() {
			return new LcFxRevaluation.LcFxRevaluationImpl(this);
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder prune() {
			super.prune();
			if (lcFxRate!=null && !lcFxRate.prune().hasData()) lcFxRate = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcFxRate()!=null && getLcFxRate().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcFxRevaluation.LcFxRevaluationBuilder o = (LcFxRevaluation.LcFxRevaluationBuilder) other;
			
			merger.mergeRosetta(getLcFxRate(), o.getLcFxRate(), this::setLcFxRate);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcFxRevaluation _that = getType().cast(o);
		
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFxRevaluationBuilder {" +
				"lcFxRate=" + this.lcFxRate + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
