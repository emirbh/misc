package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.AbstractLoanEventMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision An abstract base type defining common features of a syndicated loan business event.
 *
 */
@RosettaDataType(value="AbstractLoanEvent", builder=AbstractLoanEvent.AbstractLoanEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanEvent", model="fpml", builder=AbstractLoanEvent.AbstractLoanEventBuilderImpl.class, version="2.1.1")
public interface AbstractLoanEvent extends RosettaModelObject {

	AbstractLoanEventMeta metaData = new AbstractLoanEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends BusinessEventIdentifier> getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to relate child events to one another, with an overarching parent identifier. The parent identifier does not itself represent an event, but rather provides a mechanism to describe all related. The event described by this message should be included as a child event in this structure.
	 *
	 */
	ParentEventIdentifier getParentEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to relate a previous event (sequentially) to the event conveyed by the message. This identifier is NOT to be used for corrections to events.
	 *
	 */
	BusinessEventIdentifier getPreviousEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with a previous inaccurate event. Population of this identifier reflects the fact that the event being conveyed is a 'corrective measure' to the event referenced by this identifier.
	 *
	 */
	BusinessEventIdentifier getCorrectedEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the lender associated with a specific business event.
	 *
	 */
	PartyReference getLenderPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the overall net cash payable, as well as, the breakdown of individual cashflows.
	 *
	 */
	CashPayable getCashPayable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to add further details around the business event.
	 *
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractLoanEvent build();
	
	AbstractLoanEvent.AbstractLoanEventBuilder toBuilder();
	
	static AbstractLoanEvent.AbstractLoanEventBuilder builder() {
		return new AbstractLoanEvent.AbstractLoanEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanEvent> getType() {
		return AbstractLoanEvent.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanEventBuilder extends AbstractLoanEvent, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index);
		@Override
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		ParentEventIdentifier.ParentEventIdentifierBuilder getOrCreateParentEventIdentifier();
		@Override
		ParentEventIdentifier.ParentEventIdentifierBuilder getParentEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreatePreviousEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getPreviousEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateCorrectedEventIdentifier();
		@Override
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getCorrectedEventIdentifier();
		PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getLenderPartyReference();
		CashPayable.CashPayableBuilder getOrCreateCashPayable();
		@Override
		CashPayable.CashPayableBuilder getCashPayable();
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		AbstractLoanEvent.AbstractLoanEventBuilder setCashPayable(CashPayable cashPayable);
		AbstractLoanEvent.AbstractLoanEventBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		AbstractLoanEvent.AbstractLoanEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanEvent  ***********************/
	class AbstractLoanEventImpl implements AbstractLoanEvent {
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		private final ParentEventIdentifier parentEventIdentifier;
		private final BusinessEventIdentifier previousEventIdentifier;
		private final BusinessEventIdentifier correctedEventIdentifier;
		private final PartyReference lenderPartyReference;
		private final CashPayable cashPayable;
		private final String comment;
		
		protected AbstractLoanEventImpl(AbstractLoanEvent.AbstractLoanEventBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parentEventIdentifier = ofNullable(builder.getParentEventIdentifier()).map(f->f.build()).orElse(null);
			this.previousEventIdentifier = ofNullable(builder.getPreviousEventIdentifier()).map(f->f.build()).orElse(null);
			this.correctedEventIdentifier = ofNullable(builder.getCorrectedEventIdentifier()).map(f->f.build()).orElse(null);
			this.lenderPartyReference = ofNullable(builder.getLenderPartyReference()).map(f->f.build()).orElse(null);
			this.cashPayable = ofNullable(builder.getCashPayable()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentEventIdentifier")
		public ParentEventIdentifier getParentEventIdentifier() {
			return parentEventIdentifier;
		}
		
		@Override
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("previousEventIdentifier")
		public BusinessEventIdentifier getPreviousEventIdentifier() {
			return previousEventIdentifier;
		}
		
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correctedEventIdentifier")
		public BusinessEventIdentifier getCorrectedEventIdentifier() {
			return correctedEventIdentifier;
		}
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderPartyReference")
		public PartyReference getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPayable")
		public CashPayable getCashPayable() {
			return cashPayable;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractLoanEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder toBuilder() {
			AbstractLoanEvent.AbstractLoanEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanEvent.AbstractLoanEventBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getParentEventIdentifier()).ifPresent(builder::setParentEventIdentifier);
			ofNullable(getPreviousEventIdentifier()).ifPresent(builder::setPreviousEventIdentifier);
			ofNullable(getCorrectedEventIdentifier()).ifPresent(builder::setCorrectedEventIdentifier);
			ofNullable(getLenderPartyReference()).ifPresent(builder::setLenderPartyReference);
			ofNullable(getCashPayable()).ifPresent(builder::setCashPayable);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(parentEventIdentifier, _that.getParentEventIdentifier())) return false;
			if (!Objects.equals(previousEventIdentifier, _that.getPreviousEventIdentifier())) return false;
			if (!Objects.equals(correctedEventIdentifier, _that.getCorrectedEventIdentifier())) return false;
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(cashPayable, _that.getCashPayable())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentEventIdentifier != null ? parentEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (previousEventIdentifier != null ? previousEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedEventIdentifier != null ? correctedEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (cashPayable != null ? cashPayable.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanEvent {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"parentEventIdentifier=" + this.parentEventIdentifier + ", " +
				"previousEventIdentifier=" + this.previousEventIdentifier + ", " +
				"correctedEventIdentifier=" + this.correctedEventIdentifier + ", " +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"cashPayable=" + this.cashPayable + ", " +
				"comment=" + this.comment +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractLoanEvent  ***********************/
	class AbstractLoanEventBuilderImpl implements AbstractLoanEvent.AbstractLoanEventBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected ParentEventIdentifier.ParentEventIdentifierBuilder parentEventIdentifier;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder previousEventIdentifier;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder correctedEventIdentifier;
		protected PartyReference.PartyReferenceBuilder lenderPartyReference;
		protected CashPayable.CashPayableBuilder cashPayable;
		protected String comment;
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index) {
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			return getIndex(eventIdentifier, index, () -> {
						BusinessEventIdentifier.BusinessEventIdentifierBuilder newEventIdentifier = BusinessEventIdentifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentEventIdentifier")
		public ParentEventIdentifier.ParentEventIdentifierBuilder getParentEventIdentifier() {
			return parentEventIdentifier;
		}
		
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder getOrCreateParentEventIdentifier() {
			ParentEventIdentifier.ParentEventIdentifierBuilder result;
			if (parentEventIdentifier!=null) {
				result = parentEventIdentifier;
			}
			else {
				result = parentEventIdentifier = ParentEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("previousEventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getPreviousEventIdentifier() {
			return previousEventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreatePreviousEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (previousEventIdentifier!=null) {
				result = previousEventIdentifier;
			}
			else {
				result = previousEventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correctedEventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getCorrectedEventIdentifier() {
			return correctedEventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateCorrectedEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (correctedEventIdentifier!=null) {
				result = correctedEventIdentifier;
			}
			else {
				result = correctedEventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderPartyReference")
		public PartyReference.PartyReferenceBuilder getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (lenderPartyReference!=null) {
				result = lenderPartyReference;
			}
			else {
				result = lenderPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPayable")
		public CashPayable.CashPayableBuilder getCashPayable() {
			return cashPayable;
		}
		
		@Override
		public CashPayable.CashPayableBuilder getOrCreateCashPayable() {
			CashPayable.CashPayableBuilder result;
			if (cashPayable!=null) {
				result = cashPayable;
			}
			else {
				result = cashPayable = CashPayable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("comment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanEvent.AbstractLoanEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanEvent.AbstractLoanEventBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@Override
		public AbstractLoanEvent build() {
			return new AbstractLoanEvent.AbstractLoanEventImpl(this);
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder prune() {
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parentEventIdentifier!=null && !parentEventIdentifier.prune().hasData()) parentEventIdentifier = null;
			if (previousEventIdentifier!=null && !previousEventIdentifier.prune().hasData()) previousEventIdentifier = null;
			if (correctedEventIdentifier!=null && !correctedEventIdentifier.prune().hasData()) correctedEventIdentifier = null;
			if (lenderPartyReference!=null && !lenderPartyReference.prune().hasData()) lenderPartyReference = null;
			if (cashPayable!=null && !cashPayable.prune().hasData()) cashPayable = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParentEventIdentifier()!=null && getParentEventIdentifier().hasData()) return true;
			if (getPreviousEventIdentifier()!=null && getPreviousEventIdentifier().hasData()) return true;
			if (getCorrectedEventIdentifier()!=null && getCorrectedEventIdentifier().hasData()) return true;
			if (getLenderPartyReference()!=null && getLenderPartyReference().hasData()) return true;
			if (getCashPayable()!=null && getCashPayable().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractLoanEvent.AbstractLoanEventBuilder o = (AbstractLoanEvent.AbstractLoanEventBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			merger.mergeRosetta(getParentEventIdentifier(), o.getParentEventIdentifier(), this::setParentEventIdentifier);
			merger.mergeRosetta(getPreviousEventIdentifier(), o.getPreviousEventIdentifier(), this::setPreviousEventIdentifier);
			merger.mergeRosetta(getCorrectedEventIdentifier(), o.getCorrectedEventIdentifier(), this::setCorrectedEventIdentifier);
			merger.mergeRosetta(getLenderPartyReference(), o.getLenderPartyReference(), this::setLenderPartyReference);
			merger.mergeRosetta(getCashPayable(), o.getCashPayable(), this::setCashPayable);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(parentEventIdentifier, _that.getParentEventIdentifier())) return false;
			if (!Objects.equals(previousEventIdentifier, _that.getPreviousEventIdentifier())) return false;
			if (!Objects.equals(correctedEventIdentifier, _that.getCorrectedEventIdentifier())) return false;
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(cashPayable, _that.getCashPayable())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentEventIdentifier != null ? parentEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (previousEventIdentifier != null ? previousEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedEventIdentifier != null ? correctedEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (cashPayable != null ? cashPayable.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanEventBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"parentEventIdentifier=" + this.parentEventIdentifier + ", " +
				"previousEventIdentifier=" + this.previousEventIdentifier + ", " +
				"correctedEventIdentifier=" + this.correctedEventIdentifier + ", " +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"cashPayable=" + this.cashPayable + ", " +
				"comment=" + this.comment +
			'}';
		}
	}
}
