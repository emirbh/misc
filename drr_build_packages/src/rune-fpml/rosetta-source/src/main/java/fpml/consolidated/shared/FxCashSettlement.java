package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxCashSettlementMeta;
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
 * Provision A type that is used for describing cash settlement of an option / non deliverable forward. It includes the currency to settle into together with the fixings required to calculate the currency amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is used for describing cash settlement of an option / non deliverable forward. It includes the currency to settle into together with the fixings required to calculate the currency amount.
 *
 */
@RosettaDataType(value="FxCashSettlement", builder=FxCashSettlement.FxCashSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCashSettlement", model="fpml", builder=FxCashSettlement.FxCashSettlementBuilderImpl.class, version="2.1.1")
public interface FxCashSettlement extends RosettaModelObject {

	FxCashSettlementMeta metaData = new FxCashSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which cash settlement occurs for non-deliverable forwards and cash-settled options (non-deliverable or otherwise).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which cash settlement occurs for non-deliverable forwards and cash-settled options (non-deliverable or otherwise).
	 *
	 */
	Currency getSettlementCurrency();
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
	Currency getReferenceCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of money that the settlement will be derived from.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of money that the settlement will be derived from.
	 *
	 */
	PositiveMoney getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 *
	 */
	List<? extends FxFixing> getFixing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate. This element is optional, permitting it to be omitted where fixing details are unavailable at the point of message creation. It has multiple occurrence to support the case where fixing details must be specified for more than one currency pair e.g. on an option settled into a third currency (that is not one of the option currencies).
	 *
	 */
	List<? extends FxRateSourceFixing> getRateSourceFixing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which settlement is scheduled to occur
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which settlement is scheduled to occur
	 *
	 */
	AdjustableDate getSettlementDate();

	/*********************** Build Methods  ***********************/
	FxCashSettlement build();
	
	FxCashSettlement.FxCashSettlementBuilder toBuilder();
	
	static FxCashSettlement.FxCashSettlementBuilder builder() {
		return new FxCashSettlement.FxCashSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCashSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCashSettlement> getType() {
		return FxCashSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.class, getNotionalAmount());
		processRosetta(path.newSubPath("fixing"), processor, FxFixing.class, getFixing());
		processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.class, getRateSourceFixing());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableDate.class, getSettlementDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCashSettlementBuilder extends FxCashSettlement, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		@Override
		Currency.CurrencyBuilder getReferenceCurrency();
		PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getNotionalAmount();
		FxFixing.FxFixingBuilder getOrCreateFixing(int index);
		@Override
		List<? extends FxFixing.FxFixingBuilder> getFixing();
		FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int index);
		@Override
		List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing();
		AdjustableDate.AdjustableDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getSettlementDate();
		FxCashSettlement.FxCashSettlementBuilder setSettlementCurrency(Currency settlementCurrency);
		FxCashSettlement.FxCashSettlementBuilder setReferenceCurrency(Currency referenceCurrency);
		FxCashSettlement.FxCashSettlementBuilder setNotionalAmount(PositiveMoney notionalAmount);
		FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing);
		FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing fixing, int idx);
		FxCashSettlement.FxCashSettlementBuilder addFixing(List<? extends FxFixing> fixing);
		FxCashSettlement.FxCashSettlementBuilder setFixing(List<? extends FxFixing> fixing);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing, int idx);
		FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing);
		FxCashSettlement.FxCashSettlementBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing);
		FxCashSettlement.FxCashSettlementBuilder setSettlementDate(AdjustableDate settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("notionalAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("fixing"), processor, FxFixing.FxFixingBuilder.class, getFixing());
			processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.FxRateSourceFixingBuilder.class, getRateSourceFixing());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getSettlementDate());
		}
		

		FxCashSettlement.FxCashSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of FxCashSettlement  ***********************/
	class FxCashSettlementImpl implements FxCashSettlement {
		private final Currency settlementCurrency;
		private final Currency referenceCurrency;
		private final PositiveMoney notionalAmount;
		private final List<? extends FxFixing> fixing;
		private final List<? extends FxRateSourceFixing> rateSourceFixing;
		private final AdjustableDate settlementDate;
		
		protected FxCashSettlementImpl(FxCashSettlement.FxCashSettlementBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateSourceFixing = ofNullable(builder.getRateSourceFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public PositiveMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FxFixing> getFixing() {
			return fixing;
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public FxCashSettlement build() {
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder toBuilder() {
			FxCashSettlement.FxCashSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCashSettlement.FxCashSettlementBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
			ofNullable(getRateSourceFixing()).ifPresent(builder::setRateSourceFixing);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlement {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCashSettlement  ***********************/
	class FxCashSettlementBuilderImpl implements FxCashSettlement.FxCashSettlementBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected Currency.CurrencyBuilder referenceCurrency;
		protected PositiveMoney.PositiveMoneyBuilder notionalAmount;
		protected List<FxFixing.FxFixingBuilder> fixing = new ArrayList<>();
		protected List<FxRateSourceFixing.FxRateSourceFixingBuilder> rateSourceFixing = new ArrayList<>();
		protected AdjustableDate.AdjustableDateBuilder settlementDate;
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceCurrency")
		public Currency.CurrencyBuilder getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateReferenceCurrency() {
			Currency.CurrencyBuilder result;
			if (referenceCurrency!=null) {
				result = referenceCurrency;
			}
			else {
				result = referenceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public PositiveMoney.PositiveMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateNotionalAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FxFixing.FxFixingBuilder> getFixing() {
			return fixing;
		}
		
		@Override
		public FxFixing.FxFixingBuilder getOrCreateFixing(int index) {
			if (fixing==null) {
				this.fixing = new ArrayList<>();
			}
			return getIndex(fixing, index, () -> {
						FxFixing.FxFixingBuilder newFixing = FxFixing.builder();
						return newFixing;
					});
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int index) {
			if (rateSourceFixing==null) {
				this.rateSourceFixing = new ArrayList<>();
			}
			return getIndex(rateSourceFixing, index, () -> {
						FxRateSourceFixing.FxRateSourceFixingBuilder newRateSourceFixing = FxRateSourceFixing.builder();
						return newRateSourceFixing;
					});
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableDate.AdjustableDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateSettlementDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceCurrency")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setReferenceCurrency(Currency _referenceCurrency) {
			this.referenceCurrency = _referenceCurrency == null ? null : _referenceCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setNotionalAmount(PositiveMoney _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing _fixing) {
			if (_fixing != null) {
				this.fixing.add(_fixing.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addFixing(FxFixing _fixing, int idx) {
			getIndex(this.fixing, idx, () -> _fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addFixing(List<? extends FxFixing> fixings) {
			if (fixings != null) {
				for (final FxFixing toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setFixing(List<? extends FxFixing> fixings) {
			if (fixings == null) {
				this.fixing = new ArrayList<>();
			} else {
				this.fixing = fixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing _rateSourceFixing) {
			if (_rateSourceFixing != null) {
				this.rateSourceFixing.add(_rateSourceFixing.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(FxRateSourceFixing _rateSourceFixing, int idx) {
			getIndex(this.rateSourceFixing, idx, () -> _rateSourceFixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings != null) {
				for (final FxRateSourceFixing toAdd : rateSourceFixings) {
					this.rateSourceFixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings == null) {
				this.rateSourceFixing = new ArrayList<>();
			} else {
				this.rateSourceFixing = rateSourceFixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder setSettlementDate(AdjustableDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public FxCashSettlement build() {
			return new FxCashSettlement.FxCashSettlementImpl(this);
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixing.FxFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rateSourceFixing = rateSourceFixing.stream().filter(b->b!=null).<FxRateSourceFixing.FxRateSourceFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateSourceFixing()!=null && getRateSourceFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlement.FxCashSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCashSettlement.FxCashSettlementBuilder o = (FxCashSettlement.FxCashSettlementBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			merger.mergeRosetta(getRateSourceFixing(), o.getRateSourceFixing(), this::getOrCreateRateSourceFixing);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}
}
