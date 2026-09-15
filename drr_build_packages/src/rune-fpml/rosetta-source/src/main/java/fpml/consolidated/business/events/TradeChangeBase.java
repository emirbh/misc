package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.business.events.meta.TradeChangeBaseMeta;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Payment;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing a trade change.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a trade change.
 *
 */
@RosettaDataType(value="TradeChangeBase", builder=TradeChangeBase.TradeChangeBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeChangeBase", model="fpml", builder=TradeChangeBase.TradeChangeBaseBuilderImpl.class, version="2.1.1")
public interface TradeChangeBase extends AbstractEvent {

	TradeChangeBaseMeta metaData = new TradeChangeBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Trade getOriginalTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Trade getResultingTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the change was agreed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the change was agreed.
	 *
	 */
	ZonedDateTime getAgreementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time at which the negotiated change to the terms of the original contract was agreed, such as via telephone or electronic trading system (i.e., agreement date/time).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date and time at which the negotiated change to the terms of the original contract was agreed, such as via telephone or electronic trading system (i.e., agreement date/time).
	 *
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the change become effective.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the change become effective.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes a payment made in settlement of the change. Normally there will be a single fee, but there could be additional payments such as principal exchanges resulting from the termination.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes a payment made in settlement of the change. Normally there will be a single fee, but there could be additional payments such as principal exchanges resulting from the termination.
	 *
	 */
	List<? extends Payment> getPayment();

	/*********************** Build Methods  ***********************/
	TradeChangeBase build();
	
	TradeChangeBase.TradeChangeBaseBuilder toBuilder();
	
	static TradeChangeBase.TradeChangeBaseBuilder builder() {
		return new TradeChangeBase.TradeChangeBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeChangeBase> getType() {
		return TradeChangeBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("resultingTrade"), processor, Trade.class, getResultingTrade());
		processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeBaseBuilder extends TradeChangeBase, AbstractEvent.AbstractEventBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		Trade.TradeBuilder getOrCreateOriginalTrade();
		@Override
		Trade.TradeBuilder getOriginalTrade();
		Trade.TradeBuilder getOrCreateResultingTrade();
		@Override
		Trade.TradeBuilder getResultingTrade();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		@Override
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		Payment.PaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPayment();
		@Override
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		TradeChangeBase.TradeChangeBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeChangeBase.TradeChangeBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeChangeBase.TradeChangeBaseBuilder setOriginalTrade(Trade originalTrade);
		TradeChangeBase.TradeChangeBaseBuilder setResultingTrade(Trade resultingTrade);
		TradeChangeBase.TradeChangeBaseBuilder setAgreementDate(ZonedDateTime agreementDate);
		TradeChangeBase.TradeChangeBaseBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		TradeChangeBase.TradeChangeBaseBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		TradeChangeBase.TradeChangeBaseBuilder addPayment(Payment payment);
		TradeChangeBase.TradeChangeBaseBuilder addPayment(Payment payment, int idx);
		TradeChangeBase.TradeChangeBaseBuilder addPayment(List<? extends Payment> payment);
		TradeChangeBase.TradeChangeBaseBuilder setPayment(List<? extends Payment> payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("resultingTrade"), processor, Trade.TradeBuilder.class, getResultingTrade());
			processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeChangeBase.TradeChangeBaseBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeBase  ***********************/
	class TradeChangeBaseImpl extends AbstractEvent.AbstractEventImpl implements TradeChangeBase {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Trade originalTrade;
		private final Trade resultingTrade;
		private final ZonedDateTime agreementDate;
		private final ExecutionDateTime executionDateTime;
		private final ZonedDateTime effectiveDate;
		private final List<? extends Payment> payment;
		
		protected TradeChangeBaseImpl(TradeChangeBase.TradeChangeBaseBuilder builder) {
			super(builder);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.resultingTrade = ofNullable(builder.getResultingTrade()).map(f->f.build()).orElse(null);
			this.agreementDate = builder.getAgreementDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resultingTrade")
		public Trade getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementDate")
		public ZonedDateTime getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends Payment> getPayment() {
			return payment;
		}
		
		@Override
		public TradeChangeBase build() {
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder toBuilder() {
			TradeChangeBase.TradeChangeBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeBase.TradeChangeBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getResultingTrade()).ifPresent(builder::setResultingTrade);
			ofNullable(getAgreementDate()).ifPresent(builder::setAgreementDate);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeBase {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeBase  ***********************/
	class TradeChangeBaseBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements TradeChangeBase.TradeChangeBaseBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder originalTrade;
		protected Trade.TradeBuilder resultingTrade;
		protected ZonedDateTime agreementDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected ZonedDateTime effectiveDate;
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resultingTrade")
		public Trade.TradeBuilder getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateResultingTrade() {
			Trade.TradeBuilder result;
			if (resultingTrade!=null) {
				result = resultingTrade;
			}
			else {
				result = resultingTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementDate")
		public ZonedDateTime getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime() {
			ExecutionDateTime.ExecutionDateTimeBuilder result;
			if (executionDateTime!=null) {
				result = executionDateTime;
			}
			else {
				result = executionDateTime = ExecutionDateTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends Payment.PaymentBuilder> getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment(int index) {
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			return getIndex(payment, index, () -> {
						Payment.PaymentBuilder newPayment = Payment.builder();
						return newPayment;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalTrade")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setOriginalTrade(Trade _originalTrade) {
			this.originalTrade = _originalTrade == null ? null : _originalTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resultingTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resultingTrade")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setResultingTrade(Trade _resultingTrade) {
			this.resultingTrade = _resultingTrade == null ? null : _resultingTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementDate")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setAgreementDate(ZonedDateTime _agreementDate) {
			this.agreementDate = _agreementDate == null ? null : _agreementDate;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addPayment(Payment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addPayment(Payment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addPayment(List<? extends Payment> payments) {
			if (payments != null) {
				for (final Payment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder setPayment(List<? extends Payment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeChangeBase build() {
			return new TradeChangeBase.TradeChangeBaseImpl(this);
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder prune() {
			super.prune();
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			if (resultingTrade!=null && !resultingTrade.prune().hasData()) resultingTrade = null;
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getResultingTrade()!=null && getResultingTrade().hasData()) return true;
			if (getAgreementDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeChangeBase.TradeChangeBaseBuilder o = (TradeChangeBase.TradeChangeBaseBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getResultingTrade(), o.getResultingTrade(), this::setResultingTrade);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeBaseBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
