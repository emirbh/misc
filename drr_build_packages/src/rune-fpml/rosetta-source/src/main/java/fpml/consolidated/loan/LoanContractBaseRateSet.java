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
import fpml.consolidated.loan.meta.LoanContractBaseRateSetMeta;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
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
 * Provision An event representing the initial setting of the rate on a single (new) loan contract.
 *
 */
@RosettaDataType(value="LoanContractBaseRateSet", builder=LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractBaseRateSet", model="fpml", builder=LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl.class, version="2.1.1")
public interface LoanContractBaseRateSet extends AbstractLoanContractEvent {

	LoanContractBaseRateSetMeta metaData = new LoanContractBaseRateSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the underlying interest rate is fixed. It is an actual (adjusted) date. Note: This should default to the effective date of the loan contract in the case of a PRIME base rate.
	 *
	 */
	ZonedDateTime getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The base rate.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An amount to be added to the calculated value before subsequent use, in order to more closely replicate the original term rate, by adjusting for the economic or credit spread between risk-free rates and risky term rates.
	 *
	 */
	BigDecimal getSpreadAdjustment();

	/*********************** Build Methods  ***********************/
	LoanContractBaseRateSet build();
	
	LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder();
	
	static LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder() {
		return new LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractBaseRateSet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractBaseRateSet> getType() {
		return LoanContractBaseRateSet.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractBaseRateSetBuilder extends LoanContractBaseRateSet, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setComment(String comment);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setFixingDate(ZonedDateTime fixingDate);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setRate(BigDecimal rate);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setSpreadAdjustment(BigDecimal spreadAdjustment);

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
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
		}
		

		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractBaseRateSet  ***********************/
	class LoanContractBaseRateSetImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractBaseRateSet {
		private final ZonedDateTime fixingDate;
		private final BigDecimal rate;
		private final BigDecimal spreadAdjustment;
		
		protected LoanContractBaseRateSetImpl(LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder) {
			super(builder);
			this.fixingDate = builder.getFixingDate();
			this.rate = builder.getRate();
			this.spreadAdjustment = builder.getSpreadAdjustment();
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		public LoanContractBaseRateSet build() {
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder() {
			LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSpreadAdjustment()).ifPresent(builder::setSpreadAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractBaseRateSet _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBaseRateSet {" +
				"fixingDate=" + this.fixingDate + ", " +
				"rate=" + this.rate + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractBaseRateSet  ***********************/
	class LoanContractBaseRateSetBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl implements LoanContractBaseRateSet.LoanContractBaseRateSetBuilder {
	
		protected ZonedDateTime fixingDate;
		protected BigDecimal rate;
		protected BigDecimal spreadAdjustment;
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingDate")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadAdjustment")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setSpreadAdjustment(BigDecimal _spreadAdjustment) {
			this.spreadAdjustment = _spreadAdjustment == null ? null : _spreadAdjustment;
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet build() {
			return new LoanContractBaseRateSet.LoanContractBaseRateSetImpl(this);
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getRate()!=null) return true;
			if (getSpreadAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContractBaseRateSet.LoanContractBaseRateSetBuilder o = (LoanContractBaseRateSet.LoanContractBaseRateSetBuilder) other;
			
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getSpreadAdjustment(), o.getSpreadAdjustment(), this::setSpreadAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractBaseRateSet _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBaseRateSetBuilder {" +
				"fixingDate=" + this.fixingDate + ", " +
				"rate=" + this.rate + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}' + " " + super.toString();
		}
	}
}
