package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualSettlementPeriodMeta;
import fpml.consolidated.fx.targets.FxSettlementPeriodBarrier;
import fpml.consolidated.fx.targets.SettlementPeriod;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
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
@RosettaDataType(value="FxAccrualSettlementPeriod", builder=FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualSettlementPeriod", model="fpml", builder=FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl.class, version="2.1.1")
public interface FxAccrualSettlementPeriod extends SettlementPeriod {

	FxAccrualSettlementPeriodMeta metaData = new FxAccrualSettlementPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payoff Region within the settlement period to link strike with the relevant payoff components.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payoff Region within the settlement period to link strike with the relevant payoff components.
	 *
	 */
	List<? extends FxAccrualSettlementPeriodPayoff> getPayoff();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Accrual factor for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Accrual factor for the settlement period.
	 *
	 */
	BigDecimal getAccrualFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trigger rate of the Global Knockout Barrier for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trigger rate of the Global Knockout Barrier for the settlement period.
	 *
	 */
	FxSettlementPeriodBarrier getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Actual fixing dates within the fixing period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Actual fixing dates within the fixing period.
	 *
	 */
	SettlementPeriodFixingDates getAccrualFixingDates();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriod build();
	
	FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder();
	
	static FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder() {
		return new FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualSettlementPeriod> getType() {
		return FxAccrualSettlementPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processRosetta(path.newSubPath("payoff"), processor, FxAccrualSettlementPeriodPayoff.class, getPayoff());
		processor.processBasic(path.newSubPath("accrualFactor"), BigDecimal.class, getAccrualFactor(), this);
		processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.class, getBarrier());
		processRosetta(path.newSubPath("accrualFixingDates"), processor, SettlementPeriodFixingDates.class, getAccrualFixingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodBuilder extends FxAccrualSettlementPeriod, SettlementPeriod.SettlementPeriodBuilder {
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder getOrCreatePayoff(int index);
		@Override
		List<? extends FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> getPayoff();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier();
		@Override
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getBarrier();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAccrualFixingDates();
		@Override
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAccrualFixingDates();
		@Override
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setSettlementDate(ZonedDateTime settlementDate);
		@Override
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff, int idx);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoff);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoff);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFactor(BigDecimal accrualFactor);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setBarrier(FxSettlementPeriodBarrier barrier);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFixingDates(SettlementPeriodFixingDates accrualFixingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processRosetta(path.newSubPath("payoff"), processor, FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder.class, getPayoff());
			processor.processBasic(path.newSubPath("accrualFactor"), BigDecimal.class, getAccrualFactor(), this);
			processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("accrualFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAccrualFixingDates());
		}
		

		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriod  ***********************/
	class FxAccrualSettlementPeriodImpl extends SettlementPeriod.SettlementPeriodImpl implements FxAccrualSettlementPeriod {
		private final List<? extends FxAccrualSettlementPeriodPayoff> payoff;
		private final BigDecimal accrualFactor;
		private final FxSettlementPeriodBarrier barrier;
		private final SettlementPeriodFixingDates accrualFixingDates;
		
		protected FxAccrualSettlementPeriodImpl(FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder) {
			super(builder);
			this.payoff = ofNullable(builder.getPayoff()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accrualFactor = builder.getAccrualFactor();
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.accrualFixingDates = ofNullable(builder.getAccrualFixingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("payoff")
		public List<? extends FxAccrualSettlementPeriodPayoff> getPayoff() {
			return payoff;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualFactor")
		public BigDecimal getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public FxSettlementPeriodBarrier getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("accrualFixingDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualFixingDates")
		public SettlementPeriodFixingDates getAccrualFixingDates() {
			return accrualFixingDates;
		}
		
		@Override
		public FxAccrualSettlementPeriod build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder() {
			FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayoff()).ifPresent(builder::setPayoff);
			ofNullable(getAccrualFactor()).ifPresent(builder::setAccrualFactor);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getAccrualFixingDates()).ifPresent(builder::setAccrualFixingDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualSettlementPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(accrualFixingDates, _that.getAccrualFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (accrualFixingDates != null ? accrualFixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriod {" +
				"payoff=" + this.payoff + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"barrier=" + this.barrier + ", " +
				"accrualFixingDates=" + this.accrualFixingDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriod  ***********************/
	class FxAccrualSettlementPeriodBuilderImpl extends SettlementPeriod.SettlementPeriodBuilderImpl implements FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder {
	
		protected List<FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> payoff = new ArrayList<>();
		protected BigDecimal accrualFactor;
		protected FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder barrier;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder accrualFixingDates;
		
		@Override
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("payoff")
		public List<? extends FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> getPayoff() {
			return payoff;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder getOrCreatePayoff(int index) {
			if (payoff==null) {
				this.payoff = new ArrayList<>();
			}
			return getIndex(payoff, index, () -> {
						FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder newPayoff = FxAccrualSettlementPeriodPayoff.builder();
						return newPayoff;
					});
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualFactor")
		public BigDecimal getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier() {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = FxSettlementPeriodBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualFixingDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAccrualFixingDates() {
			return accrualFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAccrualFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (accrualFixingDates!=null) {
				result = accrualFixingDates;
			}
			else {
				result = accrualFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("payoff")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff _payoff) {
			if (_payoff != null) {
				this.payoff.add(_payoff.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff _payoff, int idx) {
			getIndex(this.payoff, idx, () -> _payoff.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoffs) {
			if (payoffs != null) {
				for (final FxAccrualSettlementPeriodPayoff toAdd : payoffs) {
					this.payoff.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("payoff")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoffs) {
			if (payoffs == null) {
				this.payoff = new ArrayList<>();
			} else {
				this.payoff = payoffs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accrualFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrualFactor")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFactor(BigDecimal _accrualFactor) {
			this.accrualFactor = _accrualFactor == null ? null : _accrualFactor;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setBarrier(FxSettlementPeriodBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualFixingDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualFixingDates")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFixingDates(SettlementPeriodFixingDates _accrualFixingDates) {
			this.accrualFixingDates = _accrualFixingDates == null ? null : _accrualFixingDates.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod build() {
			return new FxAccrualSettlementPeriod.FxAccrualSettlementPeriodImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder prune() {
			super.prune();
			payoff = payoff.stream().filter(b->b!=null).<FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (accrualFixingDates!=null && !accrualFixingDates.prune().hasData()) accrualFixingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayoff()!=null && getPayoff().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccrualFactor()!=null) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getAccrualFixingDates()!=null && getAccrualFixingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder o = (FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder) other;
			
			merger.mergeRosetta(getPayoff(), o.getPayoff(), this::getOrCreatePayoff);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getAccrualFixingDates(), o.getAccrualFixingDates(), this::setAccrualFixingDates);
			
			merger.mergeBasic(getAccrualFactor(), o.getAccrualFactor(), this::setAccrualFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualSettlementPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(accrualFixingDates, _that.getAccrualFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (accrualFixingDates != null ? accrualFixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodBuilder {" +
				"payoff=" + this.payoff + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"barrier=" + this.barrier + ", " +
				"accrualFixingDates=" + this.accrualFixingDates +
			'}' + " " + super.toString();
		}
	}
}
