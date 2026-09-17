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
import fpml.consolidated.business.events.meta.TradeAmendmentContentMeta;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
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
 * Provision A structure describing a negotiated amendment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a negotiated amendment.
 *
 */
@RosettaDataType(value="TradeAmendmentContent", builder=TradeAmendmentContent.TradeAmendmentContentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeAmendmentContent", model="fpml", builder=TradeAmendmentContent.TradeAmendmentContentBuilderImpl.class, version="2.1.1")
public interface TradeAmendmentContent extends AbstractEvent {

	TradeAmendmentContentMeta metaData = new TradeAmendmentContentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A full description of the amended trade (i.e. the trade after the amendment).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full description of the amended trade (i.e. the trade after the amendment).
	 *
	 */
	Trade getTrade();
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
	 * Provision Indication as to whether the transaction is an increase or decrease of notional of a derivative contract. Only applies when there is change in notional for a derivative contract
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
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
	TradeAmendmentContent build();
	
	TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder();
	
	static TradeAmendmentContent.TradeAmendmentContentBuilder builder() {
		return new TradeAmendmentContent.TradeAmendmentContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeAmendmentContent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeAmendmentContent> getType() {
		return TradeAmendmentContent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
		processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.class, getChangeInNotional());
		processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.class, getChangeInNumberOfOptions());
		processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.class, getChangeInQuantity());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeAmendmentContentBuilder extends TradeAmendmentContent, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
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
		Payment.PaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPayment();
		@Override
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		TradeAmendmentContent.TradeAmendmentContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		TradeAmendmentContent.TradeAmendmentContentBuilder setTrade(Trade trade);
		TradeAmendmentContent.TradeAmendmentContentBuilder setAgreementDate(ZonedDateTime agreementDate);
		TradeAmendmentContent.TradeAmendmentContentBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		TradeAmendmentContent.TradeAmendmentContentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		TradeAmendmentContent.TradeAmendmentContentBuilder setNotionalChange(NotionalChangeEnum notionalChange);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(MoneyRef changeInNotional);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(MoneyRef changeInNotional, int idx);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotional);
		TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotional);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions, int idx);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity, int idx);
		TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(Payment payment);
		TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(Payment payment, int idx);
		TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(List<? extends Payment> payment);
		TradeAmendmentContent.TradeAmendmentContentBuilder setPayment(List<? extends Payment> payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
			processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.MoneyRefBuilder.class, getChangeInNotional());
			processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.AmountRefBuilder.class, getChangeInNumberOfOptions());
			processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.UnitQuantityRefBuilder.class, getChangeInQuantity());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeAmendmentContent.TradeAmendmentContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeAmendmentContent  ***********************/
	class TradeAmendmentContentImpl extends AbstractEvent.AbstractEventImpl implements TradeAmendmentContent {
		private final Trade trade;
		private final ZonedDateTime agreementDate;
		private final ExecutionDateTime executionDateTime;
		private final ZonedDateTime effectiveDate;
		private final NotionalChangeEnum notionalChange;
		private final List<? extends MoneyRef> changeInNotional;
		private final List<? extends AmountRef> changeInNumberOfOptions;
		private final List<? extends UnitQuantityRef> changeInQuantity;
		private final List<? extends Payment> payment;
		
		protected TradeAmendmentContentImpl(TradeAmendmentContent.TradeAmendmentContentBuilder builder) {
			super(builder);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.agreementDate = builder.getAgreementDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.notionalChange = builder.getNotionalChange();
			this.changeInNotional = ofNullable(builder.getChangeInNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInNumberOfOptions = ofNullable(builder.getChangeInNumberOfOptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInQuantity = ofNullable(builder.getChangeInQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
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
		@Multi
		@RuneAttribute("payment")
		public List<? extends Payment> getPayment() {
			return payment;
		}
		
		@Override
		public TradeAmendmentContent build() {
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder() {
			TradeAmendmentContent.TradeAmendmentContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeAmendmentContent.TradeAmendmentContentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
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
			if (!super.equals(o)) return false;
		
			TradeAmendmentContent _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
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
			return "TradeAmendmentContent {" +
				"trade=" + this.trade + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeAmendmentContent  ***********************/
	class TradeAmendmentContentBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements TradeAmendmentContent.TradeAmendmentContentBuilder {
	
		protected Trade.TradeBuilder trade;
		protected ZonedDateTime agreementDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected ZonedDateTime effectiveDate;
		protected NotionalChangeEnum notionalChange;
		protected List<MoneyRef.MoneyRefBuilder> changeInNotional = new ArrayList<>();
		protected List<AmountRef.AmountRefBuilder> changeInNumberOfOptions = new ArrayList<>();
		protected List<UnitQuantityRef.UnitQuantityRefBuilder> changeInQuantity = new ArrayList<>();
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trade")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementDate")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder setAgreementDate(ZonedDateTime _agreementDate) {
			this.agreementDate = _agreementDate == null ? null : _agreementDate;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalChange")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder setNotionalChange(NotionalChangeEnum _notionalChange) {
			this.notionalChange = _notionalChange == null ? null : _notionalChange;
			return this;
		}
		
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNotional")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(MoneyRef _changeInNotional) {
			if (_changeInNotional != null) {
				this.changeInNotional.add(_changeInNotional.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(MoneyRef _changeInNotional, int idx) {
			getIndex(this.changeInNotional, idx, () -> _changeInNotional.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions) {
			if (_changeInNumberOfOptions != null) {
				this.changeInNumberOfOptions.add(_changeInNumberOfOptions.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions, int idx) {
			getIndex(this.changeInNumberOfOptions, idx, () -> _changeInNumberOfOptions.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity) {
			if (_changeInQuantity != null) {
				this.changeInQuantity.add(_changeInQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity, int idx) {
			getIndex(this.changeInQuantity, idx, () -> _changeInQuantity.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
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
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(Payment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(Payment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addPayment(List<? extends Payment> payments) {
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder setPayment(List<? extends Payment> payments) {
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
		public TradeAmendmentContent build() {
			return new TradeAmendmentContent.TradeAmendmentContentImpl(this);
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder prune() {
			super.prune();
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			changeInNotional = changeInNotional.stream().filter(b->b!=null).<MoneyRef.MoneyRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInNumberOfOptions = changeInNumberOfOptions.stream().filter(b->b!=null).<AmountRef.AmountRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInQuantity = changeInQuantity.stream().filter(b->b!=null).<UnitQuantityRef.UnitQuantityRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getAgreementDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getNotionalChange()!=null) return true;
			if (getChangeInNotional()!=null && getChangeInNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInNumberOfOptions()!=null && getChangeInNumberOfOptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInQuantity()!=null && getChangeInQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeAmendmentContent.TradeAmendmentContentBuilder o = (TradeAmendmentContent.TradeAmendmentContentBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getChangeInNotional(), o.getChangeInNotional(), this::getOrCreateChangeInNotional);
			merger.mergeRosetta(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::getOrCreateChangeInNumberOfOptions);
			merger.mergeRosetta(getChangeInQuantity(), o.getChangeInQuantity(), this::getOrCreateChangeInQuantity);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getNotionalChange(), o.getNotionalChange(), this::setNotionalChange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeAmendmentContent _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
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
			return "TradeAmendmentContentBuilder {" +
				"trade=" + this.trade + ", " +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
