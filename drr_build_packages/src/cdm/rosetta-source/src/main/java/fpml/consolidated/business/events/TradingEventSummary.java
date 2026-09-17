package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.TradingEventSummaryMeta;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.shared.NonNegativePayment;
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
 * Provision A type that records a short form event history of a trade.
 *
 */
@RosettaDataType(value="TradingEventSummary", builder=TradingEventSummary.TradingEventSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradingEventSummary", model="fpml", builder=TradingEventSummary.TradingEventSummaryBuilderImpl.class, version="2.1.1")
public interface TradingEventSummary extends RosettaModelObject {

	TradingEventSummaryMeta metaData = new TradingEventSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends BusinessEventIdentifier> getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	EventType getEventType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indication as to whether the transaction is an increase or decrease of notional of a derivative contract. Only applies when there is change in notional for a derivative contract
	 *
	 */
	NotionalChangeEnum getNotionalChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in notional amount for a prior report as a result of this event. The current notional will be reported in the trade itself. This corresponds to MiFIR Nominal or Monetary amount values; these can be distinguished by the esmaNotionalType indicator.
	 *
	 */
	List<? extends MoneyRef> getChangeInNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in nominal amount from a prior report as a result of this event. The current number of options will be reported in the trade itself. This corresponds to the MiFIR "units" value.
	 *
	 */
	List<? extends AmountRef> getChangeInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in quantity(s) from a prior report as a result of this event. The current quantity will be reported in the trade itself. This corresponds to the MiFIR "units" value.
	 *
	 */
	List<? extends UnitQuantityRef> getChangeInQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fee which compensates one of the parties for taking on a position that is off market.
	 *
	 */
	NonNegativePayment getPayment();

	/*********************** Build Methods  ***********************/
	TradingEventSummary build();
	
	TradingEventSummary.TradingEventSummaryBuilder toBuilder();
	
	static TradingEventSummary.TradingEventSummaryBuilder builder() {
		return new TradingEventSummary.TradingEventSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingEventSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradingEventSummary> getType() {
		return TradingEventSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("eventType"), processor, EventType.class, getEventType());
		processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
		processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.class, getChangeInNotional());
		processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.class, getChangeInNumberOfOptions());
		processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.class, getChangeInQuantity());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingEventSummaryBuilder extends TradingEventSummary, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index);
		@Override
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		EventType.EventTypeBuilder getOrCreateEventType();
		@Override
		EventType.EventTypeBuilder getEventType();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		@Override
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int index);
		@Override
		List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional();
		AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int index);
		@Override
		List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions();
		UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int index);
		@Override
		List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment();
		@Override
		NonNegativePayment.NonNegativePaymentBuilder getPayment();
		TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		TradingEventSummary.TradingEventSummaryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		TradingEventSummary.TradingEventSummaryBuilder setEventType(EventType eventType);
		TradingEventSummary.TradingEventSummaryBuilder setAgreementDate(ZonedDateTime agreementDate);
		TradingEventSummary.TradingEventSummaryBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		TradingEventSummary.TradingEventSummaryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		TradingEventSummary.TradingEventSummaryBuilder setNotionalChange(NotionalChangeEnum notionalChange);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(MoneyRef changeInNotional);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(MoneyRef changeInNotional, int idx);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotional);
		TradingEventSummary.TradingEventSummaryBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotional);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions, int idx);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		TradingEventSummary.TradingEventSummaryBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity, int idx);
		TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		TradingEventSummary.TradingEventSummaryBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		TradingEventSummary.TradingEventSummaryBuilder setPayment(NonNegativePayment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("eventType"), processor, EventType.EventTypeBuilder.class, getEventType());
			processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
			processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.MoneyRefBuilder.class, getChangeInNotional());
			processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.AmountRefBuilder.class, getChangeInNumberOfOptions());
			processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.UnitQuantityRefBuilder.class, getChangeInQuantity());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
		}
		

		TradingEventSummary.TradingEventSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of TradingEventSummary  ***********************/
	class TradingEventSummaryImpl implements TradingEventSummary {
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		private final EventType eventType;
		private final ZonedDateTime agreementDate;
		private final ExecutionDateTime executionDateTime;
		private final ZonedDateTime effectiveDate;
		private final NotionalChangeEnum notionalChange;
		private final List<? extends MoneyRef> changeInNotional;
		private final List<? extends AmountRef> changeInNumberOfOptions;
		private final List<? extends UnitQuantityRef> changeInQuantity;
		private final NonNegativePayment payment;
		
		protected TradingEventSummaryImpl(TradingEventSummary.TradingEventSummaryBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.eventType = ofNullable(builder.getEventType()).map(f->f.build()).orElse(null);
			this.agreementDate = builder.getAgreementDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.notionalChange = builder.getNotionalChange();
			this.changeInNotional = ofNullable(builder.getChangeInNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInNumberOfOptions = ofNullable(builder.getChangeInNumberOfOptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInQuantity = ofNullable(builder.getChangeInQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventType")
		public EventType getEventType() {
			return eventType;
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
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		public List<? extends MoneyRef> getChangeInNotional() {
			return changeInNotional;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment getPayment() {
			return payment;
		}
		
		@Override
		public TradingEventSummary build() {
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder toBuilder() {
			TradingEventSummary.TradingEventSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingEventSummary.TradingEventSummaryBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getEventType()).ifPresent(builder::setEventType);
			ofNullable(getAgreementDate()).ifPresent(builder::setAgreementDate);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getNotionalChange()).ifPresent(builder::setNotionalChange);
			ofNullable(getChangeInNotional()).ifPresent(builder::setChangeInNotional);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getChangeInQuantity()).ifPresent(builder::setChangeInQuantity);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventSummary {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"eventType=" + this.eventType + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingEventSummary  ***********************/
	class TradingEventSummaryBuilderImpl implements TradingEventSummary.TradingEventSummaryBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected EventType.EventTypeBuilder eventType;
		protected ZonedDateTime agreementDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected ZonedDateTime effectiveDate;
		protected NotionalChangeEnum notionalChange;
		protected List<MoneyRef.MoneyRefBuilder> changeInNotional = new ArrayList<>();
		protected List<AmountRef.AmountRefBuilder> changeInNumberOfOptions = new ArrayList<>();
		protected List<UnitQuantityRef.UnitQuantityRefBuilder> changeInQuantity = new ArrayList<>();
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventType")
		public EventType.EventTypeBuilder getEventType() {
			return eventType;
		}
		
		@Override
		public EventType.EventTypeBuilder getOrCreateEventType() {
			EventType.EventTypeBuilder result;
			if (eventType!=null) {
				result = eventType;
			}
			else {
				result = eventType = EventType.builder();
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
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		public List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional() {
			return changeInNotional;
		}
		
		@Override
		public MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int index) {
			if (changeInNotional==null) {
				this.changeInNotional = new ArrayList<>();
			}
			return getIndex(changeInNotional, index, () -> {
						MoneyRef.MoneyRefBuilder newChangeInNotional = MoneyRef.builder();
						return newChangeInNotional;
					});
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		public AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int index) {
			if (changeInNumberOfOptions==null) {
				this.changeInNumberOfOptions = new ArrayList<>();
			}
			return getIndex(changeInNumberOfOptions, index, () -> {
						AmountRef.AmountRefBuilder newChangeInNumberOfOptions = AmountRef.builder();
						return newChangeInNumberOfOptions;
					});
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int index) {
			if (changeInQuantity==null) {
				this.changeInQuantity = new ArrayList<>();
			}
			return getIndex(changeInQuantity, index, () -> {
						UnitQuantityRef.UnitQuantityRefBuilder newChangeInQuantity = UnitQuantityRef.builder();
						return newChangeInQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment.NonNegativePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public TradingEventSummary.TradingEventSummaryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventType")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setEventType(EventType _eventType) {
			this.eventType = _eventType == null ? null : _eventType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementDate")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setAgreementDate(ZonedDateTime _agreementDate) {
			this.agreementDate = _agreementDate == null ? null : _agreementDate;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalChange")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setNotionalChange(NotionalChangeEnum _notionalChange) {
			this.notionalChange = _notionalChange == null ? null : _notionalChange;
			return this;
		}
		
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNotional")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(MoneyRef _changeInNotional) {
			if (_changeInNotional != null) {
				this.changeInNotional.add(_changeInNotional.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(MoneyRef _changeInNotional, int idx) {
			getIndex(this.changeInNotional, idx, () -> _changeInNotional.toBuilder());
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals != null) {
				for (final MoneyRef toAdd : changeInNotionals) {
					this.changeInNotional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals == null) {
				this.changeInNotional = new ArrayList<>();
			} else {
				this.changeInNotional = changeInNotionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions) {
			if (_changeInNumberOfOptions != null) {
				this.changeInNumberOfOptions.add(_changeInNumberOfOptions.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions, int idx) {
			getIndex(this.changeInNumberOfOptions, idx, () -> _changeInNumberOfOptions.toBuilder());
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss != null) {
				for (final AmountRef toAdd : changeInNumberOfOptionss) {
					this.changeInNumberOfOptions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss == null) {
				this.changeInNumberOfOptions = new ArrayList<>();
			} else {
				this.changeInNumberOfOptions = changeInNumberOfOptionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInQuantity")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity) {
			if (_changeInQuantity != null) {
				this.changeInQuantity.add(_changeInQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity, int idx) {
			getIndex(this.changeInQuantity, idx, () -> _changeInQuantity.toBuilder());
			return this;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys != null) {
				for (final UnitQuantityRef toAdd : changeInQuantitys) {
					this.changeInQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys == null) {
				this.changeInQuantity = new ArrayList<>();
			} else {
				this.changeInQuantity = changeInQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder setPayment(NonNegativePayment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@Override
		public TradingEventSummary build() {
			return new TradingEventSummary.TradingEventSummaryImpl(this);
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder prune() {
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (eventType!=null && !eventType.prune().hasData()) eventType = null;
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			changeInNotional = changeInNotional.stream().filter(b->b!=null).<MoneyRef.MoneyRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInNumberOfOptions = changeInNumberOfOptions.stream().filter(b->b!=null).<AmountRef.AmountRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInQuantity = changeInQuantity.stream().filter(b->b!=null).<UnitQuantityRef.UnitQuantityRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEventType()!=null && getEventType().hasData()) return true;
			if (getAgreementDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getNotionalChange()!=null) return true;
			if (getChangeInNotional()!=null && getChangeInNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInNumberOfOptions()!=null && getChangeInNumberOfOptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInQuantity()!=null && getChangeInQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingEventSummary.TradingEventSummaryBuilder o = (TradingEventSummary.TradingEventSummaryBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			merger.mergeRosetta(getEventType(), o.getEventType(), this::setEventType);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getChangeInNotional(), o.getChangeInNotional(), this::getOrCreateChangeInNotional);
			merger.mergeRosetta(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::getOrCreateChangeInNumberOfOptions);
			merger.mergeRosetta(getChangeInQuantity(), o.getChangeInQuantity(), this::getOrCreateChangeInQuantity);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getNotionalChange(), o.getNotionalChange(), this::setNotionalChange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventSummaryBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"eventType=" + this.eventType + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment +
			'}';
		}
	}
}
