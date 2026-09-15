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
import fpml.consolidated.loan.meta.EventPaymentMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
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
 * Provision A structure that represents the prepayment structure associated within a facility.
 *
 */
@RosettaDataType(value="EventPayment", builder=EventPayment.EventPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventPayment", model="fpml", builder=EventPayment.EventPaymentBuilderImpl.class, version="2.1.1")
public interface EventPayment extends LoanSimplePayment {

	EventPaymentMeta metaData = new EventPaymentMeta();

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
	List<? extends EventPaymentSequence> getEventPaymentSequence();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A standard settlement instruction defining how a currency payment is to be made.
	 *
	 */
	SettlementInstruction getSettlementInstruction();

	/*********************** Build Methods  ***********************/
	EventPayment build();
	
	EventPayment.EventPaymentBuilder toBuilder();
	
	static EventPayment.EventPaymentBuilder builder() {
		return new EventPayment.EventPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventPayment> getType() {
		return EventPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("eventPaymentSequence"), processor, EventPaymentSequence.class, getEventPaymentSequence());
		processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.class, getSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventPaymentBuilder extends EventPayment, LoanSimplePayment.LoanSimplePaymentBuilder {
		EventPaymentSequence.EventPaymentSequenceBuilder getOrCreateEventPaymentSequence(int index);
		@Override
		List<? extends EventPaymentSequence.EventPaymentSequenceBuilder> getEventPaymentSequence();
		SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction();
		@Override
		SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction();
		@Override
		EventPayment.EventPaymentBuilder setId(String id);
		@Override
		EventPayment.EventPaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		EventPayment.EventPaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		EventPayment.EventPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		@Override
		EventPayment.EventPaymentBuilder setPaymentDate(AdjustableDate paymentDate);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence, int idx);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequence);
		EventPayment.EventPaymentBuilder setEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequence);
		EventPayment.EventPaymentBuilder setSettlementInstruction(SettlementInstruction settlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("eventPaymentSequence"), processor, EventPaymentSequence.EventPaymentSequenceBuilder.class, getEventPaymentSequence());
			processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getSettlementInstruction());
		}
		

		EventPayment.EventPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of EventPayment  ***********************/
	class EventPaymentImpl extends LoanSimplePayment.LoanSimplePaymentImpl implements EventPayment {
		private final List<? extends EventPaymentSequence> eventPaymentSequence;
		private final SettlementInstruction settlementInstruction;
		
		protected EventPaymentImpl(EventPayment.EventPaymentBuilder builder) {
			super(builder);
			this.eventPaymentSequence = ofNullable(builder.getEventPaymentSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementInstruction = ofNullable(builder.getSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventPaymentSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("eventPaymentSequence")
		public List<? extends EventPaymentSequence> getEventPaymentSequence() {
			return eventPaymentSequence;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInstruction")
		public SettlementInstruction getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public EventPayment build() {
			return this;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder toBuilder() {
			EventPayment.EventPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventPayment.EventPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventPaymentSequence()).ifPresent(builder::setEventPaymentSequence);
			ofNullable(getSettlementInstruction()).ifPresent(builder::setSettlementInstruction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventPaymentSequence, _that.getEventPaymentSequence())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventPaymentSequence != null ? eventPaymentSequence.hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPayment {" +
				"eventPaymentSequence=" + this.eventPaymentSequence + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EventPayment  ***********************/
	class EventPaymentBuilderImpl extends LoanSimplePayment.LoanSimplePaymentBuilderImpl implements EventPayment.EventPaymentBuilder {
	
		protected List<EventPaymentSequence.EventPaymentSequenceBuilder> eventPaymentSequence = new ArrayList<>();
		protected SettlementInstruction.SettlementInstructionBuilder settlementInstruction;
		
		@Override
		@RosettaAttribute("eventPaymentSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("eventPaymentSequence")
		public List<? extends EventPaymentSequence.EventPaymentSequenceBuilder> getEventPaymentSequence() {
			return eventPaymentSequence;
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder getOrCreateEventPaymentSequence(int index) {
			if (eventPaymentSequence==null) {
				this.eventPaymentSequence = new ArrayList<>();
			}
			return getIndex(eventPaymentSequence, index, () -> {
						EventPaymentSequence.EventPaymentSequenceBuilder newEventPaymentSequence = EventPaymentSequence.builder();
						return newEventPaymentSequence;
					});
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (settlementInstruction!=null) {
				result = settlementInstruction;
			}
			else {
				result = settlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EventPayment.EventPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public EventPayment.EventPaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		@Override
		public EventPayment.EventPaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public EventPayment.EventPaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentDate")
		@Override
		public EventPayment.EventPaymentBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventPaymentSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventPaymentSequence")
		@Override
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence _eventPaymentSequence) {
			if (_eventPaymentSequence != null) {
				this.eventPaymentSequence.add(_eventPaymentSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence _eventPaymentSequence, int idx) {
			getIndex(this.eventPaymentSequence, idx, () -> _eventPaymentSequence.toBuilder());
			return this;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequences) {
			if (eventPaymentSequences != null) {
				for (final EventPaymentSequence toAdd : eventPaymentSequences) {
					this.eventPaymentSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPaymentSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventPaymentSequence")
		@Override
		public EventPayment.EventPaymentBuilder setEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequences) {
			if (eventPaymentSequences == null) {
				this.eventPaymentSequence = new ArrayList<>();
			} else {
				this.eventPaymentSequence = eventPaymentSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInstruction")
		@Override
		public EventPayment.EventPaymentBuilder setSettlementInstruction(SettlementInstruction _settlementInstruction) {
			this.settlementInstruction = _settlementInstruction == null ? null : _settlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public EventPayment build() {
			return new EventPayment.EventPaymentImpl(this);
		}
		
		@Override
		public EventPayment.EventPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPayment.EventPaymentBuilder prune() {
			super.prune();
			eventPaymentSequence = eventPaymentSequence.stream().filter(b->b!=null).<EventPaymentSequence.EventPaymentSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementInstruction!=null && !settlementInstruction.prune().hasData()) settlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventPaymentSequence()!=null && getEventPaymentSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementInstruction()!=null && getSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPayment.EventPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EventPayment.EventPaymentBuilder o = (EventPayment.EventPaymentBuilder) other;
			
			merger.mergeRosetta(getEventPaymentSequence(), o.getEventPaymentSequence(), this::getOrCreateEventPaymentSequence);
			merger.mergeRosetta(getSettlementInstruction(), o.getSettlementInstruction(), this::setSettlementInstruction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventPaymentSequence, _that.getEventPaymentSequence())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventPaymentSequence != null ? eventPaymentSequence.hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentBuilder {" +
				"eventPaymentSequence=" + this.eventPaymentSequence + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}' + " " + super.toString();
		}
	}
}
