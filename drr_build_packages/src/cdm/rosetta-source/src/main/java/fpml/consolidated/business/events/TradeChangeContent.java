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
import fpml.consolidated.business.events.meta.TradeChangeContentMeta;
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
 * Provision A structure describing a non-negotiated trade resulting from a market event.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a non-negotiated trade resulting from a market event.
 *
 */
@RosettaDataType(value="TradeChangeContent", builder=TradeChangeContent.TradeChangeContentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeChangeContent", model="fpml", builder=TradeChangeContent.TradeChangeContentBuilderImpl.class, version="2.1.1")
public interface TradeChangeContent extends RosettaModelObject {

	TradeChangeContentMeta metaData = new TradeChangeContentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The original qualified trade identifier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The original qualified trade identifier.
	 *
	 */
	PartyTradeIdentifier getOldTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The original trade details.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The original trade details.
	 *
	 */
	Trade getOldTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A full description of the amended trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full description of the amended trade.
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the change become effective
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the change become effective
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Substitution point for types of change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Substitution point for types of change
	 *
	 */
	ChangeEvent getChangeEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes a payment made in settlement of the change.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes a payment made in settlement of the change.
	 *
	 */
	List<? extends Payment> getPayment();

	/*********************** Build Methods  ***********************/
	TradeChangeContent build();
	
	TradeChangeContent.TradeChangeContentBuilder toBuilder();
	
	static TradeChangeContent.TradeChangeContentBuilder builder() {
		return new TradeChangeContent.TradeChangeContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeContent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeChangeContent> getType() {
		return TradeChangeContent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.class, getOldTradeIdentifier());
		processRosetta(path.newSubPath("oldTrade"), processor, Trade.class, getOldTrade());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("changeEvent"), processor, ChangeEvent.class, getChangeEvent());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeContentBuilder extends TradeChangeContent, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOldTradeIdentifier();
		Trade.TradeBuilder getOrCreateOldTrade();
		@Override
		Trade.TradeBuilder getOldTrade();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		ChangeEvent.ChangeEventBuilder getOrCreateChangeEvent();
		@Override
		ChangeEvent.ChangeEventBuilder getChangeEvent();
		Payment.PaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPayment();
		TradeChangeContent.TradeChangeContentBuilder setOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier);
		TradeChangeContent.TradeChangeContentBuilder setOldTrade(Trade oldTrade);
		TradeChangeContent.TradeChangeContentBuilder setTrade(Trade trade);
		TradeChangeContent.TradeChangeContentBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		TradeChangeContent.TradeChangeContentBuilder setChangeEvent(ChangeEvent changeEvent);
		TradeChangeContent.TradeChangeContentBuilder addPayment(Payment payment);
		TradeChangeContent.TradeChangeContentBuilder addPayment(Payment payment, int idx);
		TradeChangeContent.TradeChangeContentBuilder addPayment(List<? extends Payment> payment);
		TradeChangeContent.TradeChangeContentBuilder setPayment(List<? extends Payment> payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getOldTradeIdentifier());
			processRosetta(path.newSubPath("oldTrade"), processor, Trade.TradeBuilder.class, getOldTrade());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("changeEvent"), processor, ChangeEvent.ChangeEventBuilder.class, getChangeEvent());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeChangeContent.TradeChangeContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeContent  ***********************/
	class TradeChangeContentImpl implements TradeChangeContent {
		private final PartyTradeIdentifier oldTradeIdentifier;
		private final Trade oldTrade;
		private final Trade trade;
		private final ZonedDateTime effectiveDate;
		private final ChangeEvent changeEvent;
		private final List<? extends Payment> payment;
		
		protected TradeChangeContentImpl(TradeChangeContent.TradeChangeContentBuilder builder) {
			this.oldTradeIdentifier = ofNullable(builder.getOldTradeIdentifier()).map(f->f.build()).orElse(null);
			this.oldTrade = ofNullable(builder.getOldTrade()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.changeEvent = ofNullable(builder.getChangeEvent()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTradeIdentifier")
		public PartyTradeIdentifier getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTrade")
		public Trade getOldTrade() {
			return oldTrade;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("changeEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeEvent")
		public ChangeEvent getChangeEvent() {
			return changeEvent;
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
		public TradeChangeContent build() {
			return this;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder toBuilder() {
			TradeChangeContent.TradeChangeContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeContent.TradeChangeContentBuilder builder) {
			ofNullable(getOldTradeIdentifier()).ifPresent(builder::setOldTradeIdentifier);
			ofNullable(getOldTrade()).ifPresent(builder::setOldTrade);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getChangeEvent()).ifPresent(builder::setChangeEvent);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeChangeContent _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(changeEvent, _that.getChangeEvent())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (changeEvent != null ? changeEvent.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeContent {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"changeEvent=" + this.changeEvent + ", " +
				"payment=" + this.payment +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeChangeContent  ***********************/
	class TradeChangeContentBuilderImpl implements TradeChangeContent.TradeChangeContentBuilder {
	
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder oldTradeIdentifier;
		protected Trade.TradeBuilder oldTrade;
		protected Trade.TradeBuilder trade;
		protected ZonedDateTime effectiveDate;
		protected ChangeEvent.ChangeEventBuilder changeEvent;
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (oldTradeIdentifier!=null) {
				result = oldTradeIdentifier;
			}
			else {
				result = oldTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oldTrade")
		public Trade.TradeBuilder getOldTrade() {
			return oldTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOldTrade() {
			Trade.TradeBuilder result;
			if (oldTrade!=null) {
				result = oldTrade;
			}
			else {
				result = oldTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("changeEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeEvent")
		public ChangeEvent.ChangeEventBuilder getChangeEvent() {
			return changeEvent;
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder getOrCreateChangeEvent() {
			ChangeEvent.ChangeEventBuilder result;
			if (changeEvent!=null) {
				result = changeEvent;
			}
			else {
				result = changeEvent = ChangeEvent.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("oldTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oldTradeIdentifier")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder setOldTradeIdentifier(PartyTradeIdentifier _oldTradeIdentifier) {
			this.oldTradeIdentifier = _oldTradeIdentifier == null ? null : _oldTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oldTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oldTrade")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder setOldTrade(Trade _oldTrade) {
			this.oldTrade = _oldTrade == null ? null : _oldTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("changeEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeEvent")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder setChangeEvent(ChangeEvent _changeEvent) {
			this.changeEvent = _changeEvent == null ? null : _changeEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder addPayment(Payment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder addPayment(Payment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder addPayment(List<? extends Payment> payments) {
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
		public TradeChangeContent.TradeChangeContentBuilder setPayment(List<? extends Payment> payments) {
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
		public TradeChangeContent build() {
			return new TradeChangeContent.TradeChangeContentImpl(this);
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder prune() {
			if (oldTradeIdentifier!=null && !oldTradeIdentifier.prune().hasData()) oldTradeIdentifier = null;
			if (oldTrade!=null && !oldTrade.prune().hasData()) oldTrade = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (changeEvent!=null && !changeEvent.prune().hasData()) changeEvent = null;
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOldTradeIdentifier()!=null && getOldTradeIdentifier().hasData()) return true;
			if (getOldTrade()!=null && getOldTrade().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getChangeEvent()!=null && getChangeEvent().hasData()) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeChangeContent.TradeChangeContentBuilder o = (TradeChangeContent.TradeChangeContentBuilder) other;
			
			merger.mergeRosetta(getOldTradeIdentifier(), o.getOldTradeIdentifier(), this::setOldTradeIdentifier);
			merger.mergeRosetta(getOldTrade(), o.getOldTrade(), this::setOldTrade);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getChangeEvent(), o.getChangeEvent(), this::setChangeEvent);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeChangeContent _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(changeEvent, _that.getChangeEvent())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (changeEvent != null ? changeEvent.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeContentBuilder {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"changeEvent=" + this.changeEvent + ", " +
				"payment=" + this.payment +
			'}';
		}
	}
}
