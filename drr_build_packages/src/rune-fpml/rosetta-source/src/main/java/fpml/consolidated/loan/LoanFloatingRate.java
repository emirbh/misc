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
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.loan.meta.LoanFloatingRateMeta;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.StrikeSchedule;
import java.math.BigDecimal;
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
 * Provision An extension of the FloatingRate object for the purposes of the loan market.
 *
 */
@RosettaDataType(value="LoanFloatingRate", builder=LoanFloatingRate.LoanFloatingRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanFloatingRate", model="fpml", builder=LoanFloatingRate.LoanFloatingRateBuilderImpl.class, version="2.1.1")
public interface LoanFloatingRate extends FloatingRate {

	LoanFloatingRateMeta metaData = new LoanFloatingRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the accrual calculation is based on compounding balance.
	 *
	 */
	Boolean getIsCompoundingBalance();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	RateLimits getAllInRateLimits();

	/*********************** Build Methods  ***********************/
	LoanFloatingRate build();
	
	LoanFloatingRate.LoanFloatingRateBuilder toBuilder();
	
	static LoanFloatingRate.LoanFloatingRateBuilder builder() {
		return new LoanFloatingRate.LoanFloatingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanFloatingRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanFloatingRate> getType() {
		return LoanFloatingRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.class, getCalculationParameters());
		processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.class, getFallbackRate());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processor.processBasic(path.newSubPath("isCompoundingBalance"), Boolean.class, getIsCompoundingBalance(), this);
		processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
		processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.class, getAllInRateLimits());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanFloatingRateBuilder extends LoanFloatingRate, FloatingRate.FloatingRateBuilder {
		RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits();
		@Override
		RateLimits.RateLimitsBuilder getAllInRateLimits();
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setId(String id);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setIndexTenor(Period indexTenor);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setCalculationParameters(CalculationParameters calculationParameters);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setFallbackRate(FallbackRate fallbackRate);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int idx);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int idx);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		@Override
		LoanFloatingRate.LoanFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		LoanFloatingRate.LoanFloatingRateBuilder setIsCompoundingBalance(Boolean isCompoundingBalance);
		LoanFloatingRate.LoanFloatingRateBuilder setSpreadAdjustment(BigDecimal spreadAdjustment);
		LoanFloatingRate.LoanFloatingRateBuilder setAllInRateLimits(RateLimits allInRateLimits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.CalculationParametersBuilder.class, getCalculationParameters());
			processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.FallbackRateBuilder.class, getFallbackRate());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processor.processBasic(path.newSubPath("isCompoundingBalance"), Boolean.class, getIsCompoundingBalance(), this);
			processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
			processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getAllInRateLimits());
		}
		

		LoanFloatingRate.LoanFloatingRateBuilder prune();
	}

	/*********************** Immutable Implementation of LoanFloatingRate  ***********************/
	class LoanFloatingRateImpl extends FloatingRate.FloatingRateImpl implements LoanFloatingRate {
		private final Boolean isCompoundingBalance;
		private final BigDecimal spreadAdjustment;
		private final RateLimits allInRateLimits;
		
		protected LoanFloatingRateImpl(LoanFloatingRate.LoanFloatingRateBuilder builder) {
			super(builder);
			this.isCompoundingBalance = builder.getIsCompoundingBalance();
			this.spreadAdjustment = builder.getSpreadAdjustment();
			this.allInRateLimits = ofNullable(builder.getAllInRateLimits()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isCompoundingBalance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCompoundingBalance")
		public Boolean getIsCompoundingBalance() {
			return isCompoundingBalance;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRateLimits")
		public RateLimits getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		public LoanFloatingRate build() {
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder toBuilder() {
			LoanFloatingRate.LoanFloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanFloatingRate.LoanFloatingRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIsCompoundingBalance()).ifPresent(builder::setIsCompoundingBalance);
			ofNullable(getSpreadAdjustment()).ifPresent(builder::setSpreadAdjustment);
			ofNullable(getAllInRateLimits()).ifPresent(builder::setAllInRateLimits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(isCompoundingBalance, _that.getIsCompoundingBalance())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCompoundingBalance != null ? isCompoundingBalance.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRate {" +
				"isCompoundingBalance=" + this.isCompoundingBalance + ", " +
				"spreadAdjustment=" + this.spreadAdjustment + ", " +
				"allInRateLimits=" + this.allInRateLimits +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanFloatingRate  ***********************/
	class LoanFloatingRateBuilderImpl extends FloatingRate.FloatingRateBuilderImpl implements LoanFloatingRate.LoanFloatingRateBuilder {
	
		protected Boolean isCompoundingBalance;
		protected BigDecimal spreadAdjustment;
		protected RateLimits.RateLimitsBuilder allInRateLimits;
		
		@Override
		@RosettaAttribute("isCompoundingBalance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCompoundingBalance")
		public Boolean getIsCompoundingBalance() {
			return isCompoundingBalance;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRateLimits")
		public RateLimits.RateLimitsBuilder getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits() {
			RateLimits.RateLimitsBuilder result;
			if (allInRateLimits!=null) {
				result = allInRateLimits;
			}
			else {
				result = allInRateLimits = RateLimits.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationParameters")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setCalculationParameters(CalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackRate")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setFallbackRate(FallbackRate _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (final SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null) {
				this.spreadSchedule = new ArrayList<>();
			} else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rateTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateTreatment")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule) {
			if (_capRateSchedule != null) {
				this.capRateSchedule.add(_capRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule, int idx) {
			getIndex(this.capRateSchedule, idx, () -> _capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (final StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules == null) {
				this.capRateSchedule = new ArrayList<>();
			} else {
				this.capRateSchedule = capRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			if (_floorRateSchedule != null) {
				this.floorRateSchedule.add(_floorRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule, int idx) {
			getIndex(this.floorRateSchedule, idx, () -> _floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (final StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null) {
				this.floorRateSchedule = new ArrayList<>();
			} else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCompoundingBalance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCompoundingBalance")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setIsCompoundingBalance(Boolean _isCompoundingBalance) {
			this.isCompoundingBalance = _isCompoundingBalance == null ? null : _isCompoundingBalance;
			return this;
		}
		
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadAdjustment")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setSpreadAdjustment(BigDecimal _spreadAdjustment) {
			this.spreadAdjustment = _spreadAdjustment == null ? null : _spreadAdjustment;
			return this;
		}
		
		@RosettaAttribute("allInRateLimits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInRateLimits")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder setAllInRateLimits(RateLimits _allInRateLimits) {
			this.allInRateLimits = _allInRateLimits == null ? null : _allInRateLimits.toBuilder();
			return this;
		}
		
		@Override
		public LoanFloatingRate build() {
			return new LoanFloatingRate.LoanFloatingRateImpl(this);
		}
		
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder prune() {
			super.prune();
			if (allInRateLimits!=null && !allInRateLimits.prune().hasData()) allInRateLimits = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIsCompoundingBalance()!=null) return true;
			if (getSpreadAdjustment()!=null) return true;
			if (getAllInRateLimits()!=null && getAllInRateLimits().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRate.LoanFloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanFloatingRate.LoanFloatingRateBuilder o = (LoanFloatingRate.LoanFloatingRateBuilder) other;
			
			merger.mergeRosetta(getAllInRateLimits(), o.getAllInRateLimits(), this::setAllInRateLimits);
			
			merger.mergeBasic(getIsCompoundingBalance(), o.getIsCompoundingBalance(), this::setIsCompoundingBalance);
			merger.mergeBasic(getSpreadAdjustment(), o.getSpreadAdjustment(), this::setSpreadAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(isCompoundingBalance, _that.getIsCompoundingBalance())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCompoundingBalance != null ? isCompoundingBalance.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRateBuilder {" +
				"isCompoundingBalance=" + this.isCompoundingBalance + ", " +
				"spreadAdjustment=" + this.spreadAdjustment + ", " +
				"allInRateLimits=" + this.allInRateLimits +
			'}' + " " + super.toString();
		}
	}
}
