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
import fpml.consolidated.business.events.meta.TradeNotionalChangeMeta;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing a change to the size of a trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a change to the size of a trade.
 *
 */
@RosettaDataType(value="TradeNotionalChange", builder=TradeNotionalChange.TradeNotionalChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeNotionalChange", model="fpml", builder=TradeNotionalChange.TradeNotionalChangeBuilderImpl.class, version="2.1.1")
public interface TradeNotionalChange extends TradeChangeBase {

	TradeNotionalChangeMeta metaData = new TradeNotionalChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Notional Amount changes. The direction of the change (increase or decrease) is specified by the event type (Termination =&gt; reduction, Increase =&gt; greater.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Notional Amount changes. The direction of the change (increase or decrease) is specified by the event type (Termination =&gt; reduction, Increase =&gt; greater.)
	 *
	 */
	List<? extends NonNegativeMoney> getChangeInNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 */
	List<? extends NonNegativeMoney> getOutstandingNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Number of Options changes
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Number of Options changes
	 *
	 */
	BigDecimal getChangeInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 */
	BigDecimal getOutstandingNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Number of Units changes
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the Number of Units changes
	 *
	 */
	BigDecimal getChangeInNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	BigDecimal getOutstandingNumberOfUnits();
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
	List<? extends TradeLegSizeChange> getSizeChange();
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
	List<? extends TradeLegPriceChange> getPriceChange();

	/*********************** Build Methods  ***********************/
	TradeNotionalChange build();
	
	TradeNotionalChange.TradeNotionalChangeBuilder toBuilder();
	
	static TradeNotionalChange.TradeNotionalChangeBuilder builder() {
		return new TradeNotionalChange.TradeNotionalChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeNotionalChange> getType() {
		return TradeNotionalChange.class;
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
		processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.class, getChangeInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.class, getOutstandingNotionalAmount());
		processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		processRosetta(path.newSubPath("sizeChange"), processor, TradeLegSizeChange.class, getSizeChange());
		processRosetta(path.newSubPath("priceChange"), processor, TradeLegPriceChange.class, getPriceChange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeBuilder extends TradeNotionalChange, TradeChangeBase.TradeChangeBaseBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount(int index);
		@Override
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getChangeInNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount(int index);
		@Override
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getOutstandingNotionalAmount();
		TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateSizeChange(int index);
		@Override
		List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getSizeChange();
		TradeLegPriceChange.TradeLegPriceChangeBuilder getOrCreatePriceChange(int index);
		@Override
		List<? extends TradeLegPriceChange.TradeLegPriceChangeBuilder> getPriceChange();
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setOriginalTrade(Trade originalTrade);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setResultingTrade(Trade resultingTrade);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setAgreementDate(ZonedDateTime agreementDate);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addPayment(Payment payment);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addPayment(Payment payment, int idx);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder addPayment(List<? extends Payment> payment);
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder setPayment(List<? extends Payment> payment);
		TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount, int idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount, int idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmount);
		TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions);
		TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);
		TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits);
		TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange, int idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(List<? extends TradeLegSizeChange> sizeChange);
		TradeNotionalChange.TradeNotionalChangeBuilder setSizeChange(List<? extends TradeLegSizeChange> sizeChange);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange, int idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(List<? extends TradeLegPriceChange> priceChange);
		TradeNotionalChange.TradeNotionalChangeBuilder setPriceChange(List<? extends TradeLegPriceChange> priceChange);

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
			processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingNotionalAmount());
			processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
			processRosetta(path.newSubPath("sizeChange"), processor, TradeLegSizeChange.TradeLegSizeChangeBuilder.class, getSizeChange());
			processRosetta(path.newSubPath("priceChange"), processor, TradeLegPriceChange.TradeLegPriceChangeBuilder.class, getPriceChange());
		}
		

		TradeNotionalChange.TradeNotionalChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChange  ***********************/
	class TradeNotionalChangeImpl extends TradeChangeBase.TradeChangeBaseImpl implements TradeNotionalChange {
		private final List<? extends NonNegativeMoney> changeInNotionalAmount;
		private final List<? extends NonNegativeMoney> outstandingNotionalAmount;
		private final BigDecimal changeInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		private final BigDecimal changeInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		private final List<? extends TradeLegSizeChange> sizeChange;
		private final List<? extends TradeLegPriceChange> priceChange;
		
		protected TradeNotionalChangeImpl(TradeNotionalChange.TradeNotionalChangeBuilder builder) {
			super(builder);
			this.changeInNotionalAmount = ofNullable(builder.getChangeInNotionalAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInNumberOfOptions = builder.getChangeInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
			this.changeInNumberOfUnits = builder.getChangeInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
			this.sizeChange = ofNullable(builder.getSizeChange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.priceChange = ofNullable(builder.getPriceChange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotionalAmount")
		public List<? extends NonNegativeMoney> getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("outstandingNotionalAmount")
		public List<? extends NonNegativeMoney> getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("sizeChange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sizeChange")
		public List<? extends TradeLegSizeChange> getSizeChange() {
			return sizeChange;
		}
		
		@Override
		@RosettaAttribute("priceChange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceChange")
		public List<? extends TradeLegPriceChange> getPriceChange() {
			return priceChange;
		}
		
		@Override
		public TradeNotionalChange build() {
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder toBuilder() {
			TradeNotionalChange.TradeNotionalChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChange.TradeNotionalChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getChangeInNotionalAmount()).ifPresent(builder::setChangeInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
			ofNullable(getChangeInNumberOfUnits()).ifPresent(builder::setChangeInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
			ofNullable(getSizeChange()).ifPresent(builder::setSizeChange);
			ofNullable(getPriceChange()).ifPresent(builder::setPriceChange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNotionalChange _that = getType().cast(o);
		
			if (!ListEquals.listEquals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!ListEquals.listEquals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(sizeChange, _that.getSizeChange())) return false;
			if (!ListEquals.listEquals(priceChange, _that.getPriceChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (sizeChange != null ? sizeChange.hashCode() : 0);
			_result = 31 * _result + (priceChange != null ? priceChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChange {" +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"sizeChange=" + this.sizeChange + ", " +
				"priceChange=" + this.priceChange +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeNotionalChange  ***********************/
	class TradeNotionalChangeBuilderImpl extends TradeChangeBase.TradeChangeBaseBuilderImpl implements TradeNotionalChange.TradeNotionalChangeBuilder {
	
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> changeInNotionalAmount = new ArrayList<>();
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> outstandingNotionalAmount = new ArrayList<>();
		protected BigDecimal changeInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
		protected BigDecimal changeInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
		protected List<TradeLegSizeChange.TradeLegSizeChangeBuilder> sizeChange = new ArrayList<>();
		protected List<TradeLegPriceChange.TradeLegPriceChangeBuilder> priceChange = new ArrayList<>();
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotionalAmount")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount(int index) {
			if (changeInNotionalAmount==null) {
				this.changeInNotionalAmount = new ArrayList<>();
			}
			return getIndex(changeInNotionalAmount, index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newChangeInNotionalAmount = NonNegativeMoney.builder();
						return newChangeInNotionalAmount;
					});
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("outstandingNotionalAmount")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount(int index) {
			if (outstandingNotionalAmount==null) {
				this.outstandingNotionalAmount = new ArrayList<>();
			}
			return getIndex(outstandingNotionalAmount, index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newOutstandingNotionalAmount = NonNegativeMoney.builder();
						return newOutstandingNotionalAmount;
					});
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("sizeChange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sizeChange")
		public List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getSizeChange() {
			return sizeChange;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateSizeChange(int index) {
			if (sizeChange==null) {
				this.sizeChange = new ArrayList<>();
			}
			return getIndex(sizeChange, index, () -> {
						TradeLegSizeChange.TradeLegSizeChangeBuilder newSizeChange = TradeLegSizeChange.builder();
						return newSizeChange;
					});
		}
		
		@Override
		@RosettaAttribute("priceChange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceChange")
		public List<? extends TradeLegPriceChange.TradeLegPriceChangeBuilder> getPriceChange() {
			return priceChange;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder getOrCreatePriceChange(int index) {
			if (priceChange==null) {
				this.priceChange = new ArrayList<>();
			}
			return getIndex(priceChange, index, () -> {
						TradeLegPriceChange.TradeLegPriceChangeBuilder newPriceChange = TradeLegPriceChange.builder();
						return newPriceChange;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public TradeNotionalChange.TradeNotionalChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public TradeNotionalChange.TradeNotionalChangeBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public TradeNotionalChange.TradeNotionalChangeBuilder setOriginalTrade(Trade _originalTrade) {
			this.originalTrade = _originalTrade == null ? null : _originalTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resultingTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resultingTrade")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setResultingTrade(Trade _resultingTrade) {
			this.resultingTrade = _resultingTrade == null ? null : _resultingTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementDate")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setAgreementDate(ZonedDateTime _agreementDate) {
			this.agreementDate = _agreementDate == null ? null : _agreementDate;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPayment(Payment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPayment(Payment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPayment(List<? extends Payment> payments) {
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
		public TradeNotionalChange.TradeNotionalChangeBuilder setPayment(List<? extends Payment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNotionalAmount")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(NonNegativeMoney _changeInNotionalAmount) {
			if (_changeInNotionalAmount != null) {
				this.changeInNotionalAmount.add(_changeInNotionalAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(NonNegativeMoney _changeInNotionalAmount, int idx) {
			getIndex(this.changeInNotionalAmount, idx, () -> _changeInNotionalAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmounts) {
			if (changeInNotionalAmounts != null) {
				for (final NonNegativeMoney toAdd : changeInNotionalAmounts) {
					this.changeInNotionalAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInNotionalAmount")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmounts) {
			if (changeInNotionalAmounts == null) {
				this.changeInNotionalAmount = new ArrayList<>();
			} else {
				this.changeInNotionalAmount = changeInNotionalAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(NonNegativeMoney _outstandingNotionalAmount) {
			if (_outstandingNotionalAmount != null) {
				this.outstandingNotionalAmount.add(_outstandingNotionalAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(NonNegativeMoney _outstandingNotionalAmount, int idx) {
			getIndex(this.outstandingNotionalAmount, idx, () -> _outstandingNotionalAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmounts) {
			if (outstandingNotionalAmounts != null) {
				for (final NonNegativeMoney toAdd : outstandingNotionalAmounts) {
					this.outstandingNotionalAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmounts) {
			if (outstandingNotionalAmounts == null) {
				this.outstandingNotionalAmount = new ArrayList<>();
			} else {
				this.outstandingNotionalAmount = outstandingNotionalAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNumberOfOptions(BigDecimal _changeInNumberOfOptions) {
			this.changeInNumberOfOptions = _changeInNumberOfOptions == null ? null : _changeInNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNumberOfOptions(BigDecimal _outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = _outstandingNumberOfOptions == null ? null : _outstandingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNumberOfUnits")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setChangeInNumberOfUnits(BigDecimal _changeInNumberOfUnits) {
			this.changeInNumberOfUnits = _changeInNumberOfUnits == null ? null : _changeInNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setOutstandingNumberOfUnits(BigDecimal _outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = _outstandingNumberOfUnits == null ? null : _outstandingNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("sizeChange")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sizeChange")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange _sizeChange) {
			if (_sizeChange != null) {
				this.sizeChange.add(_sizeChange.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange _sizeChange, int idx) {
			getIndex(this.sizeChange, idx, () -> _sizeChange.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(List<? extends TradeLegSizeChange> sizeChanges) {
			if (sizeChanges != null) {
				for (final TradeLegSizeChange toAdd : sizeChanges) {
					this.sizeChange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sizeChange")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sizeChange")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setSizeChange(List<? extends TradeLegSizeChange> sizeChanges) {
			if (sizeChanges == null) {
				this.sizeChange = new ArrayList<>();
			} else {
				this.sizeChange = sizeChanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("priceChange")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceChange")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange _priceChange) {
			if (_priceChange != null) {
				this.priceChange.add(_priceChange.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange _priceChange, int idx) {
			getIndex(this.priceChange, idx, () -> _priceChange.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(List<? extends TradeLegPriceChange> priceChanges) {
			if (priceChanges != null) {
				for (final TradeLegPriceChange toAdd : priceChanges) {
					this.priceChange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("priceChange")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("priceChange")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder setPriceChange(List<? extends TradeLegPriceChange> priceChanges) {
			if (priceChanges == null) {
				this.priceChange = new ArrayList<>();
			} else {
				this.priceChange = priceChanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeNotionalChange build() {
			return new TradeNotionalChange.TradeNotionalChangeImpl(this);
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder prune() {
			super.prune();
			changeInNotionalAmount = changeInNotionalAmount.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			outstandingNotionalAmount = outstandingNotionalAmount.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			sizeChange = sizeChange.stream().filter(b->b!=null).<TradeLegSizeChange.TradeLegSizeChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			priceChange = priceChange.stream().filter(b->b!=null).<TradeLegPriceChange.TradeLegPriceChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getChangeInNotionalAmount()!=null && getChangeInNotionalAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			if (getChangeInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			if (getSizeChange()!=null && getSizeChange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPriceChange()!=null && getPriceChange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeNotionalChange.TradeNotionalChangeBuilder o = (TradeNotionalChange.TradeNotionalChangeBuilder) other;
			
			merger.mergeRosetta(getChangeInNotionalAmount(), o.getChangeInNotionalAmount(), this::getOrCreateChangeInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::getOrCreateOutstandingNotionalAmount);
			merger.mergeRosetta(getSizeChange(), o.getSizeChange(), this::getOrCreateSizeChange);
			merger.mergeRosetta(getPriceChange(), o.getPriceChange(), this::getOrCreatePriceChange);
			
			merger.mergeBasic(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::setChangeInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			merger.mergeBasic(getChangeInNumberOfUnits(), o.getChangeInNumberOfUnits(), this::setChangeInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNotionalChange _that = getType().cast(o);
		
			if (!ListEquals.listEquals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!ListEquals.listEquals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(sizeChange, _that.getSizeChange())) return false;
			if (!ListEquals.listEquals(priceChange, _that.getPriceChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (sizeChange != null ? sizeChange.hashCode() : 0);
			_result = 31 * _result + (priceChange != null ? priceChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeBuilder {" +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"sizeChange=" + this.sizeChange + ", " +
				"priceChange=" + this.priceChange +
			'}' + " " + super.toString();
		}
	}
}
