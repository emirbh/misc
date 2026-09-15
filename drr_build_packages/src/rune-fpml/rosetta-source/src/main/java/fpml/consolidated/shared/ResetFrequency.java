package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.fpmlenum.WeeklyRollConventionEnum;
import fpml.consolidated.shared.meta.ResetFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaginhg is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaginhg is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap\swapStream\calculationPerioDates\effectiveDate and the swap\swapStream\calculationPerioDates\terminationDate.
 *
 */
@RosettaDataType(value="ResetFrequency", builder=ResetFrequency.ResetFrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetFrequency", model="fpml", builder=ResetFrequency.ResetFrequencyBuilderImpl.class, version="2.1.1")
public interface ResetFrequency extends Frequency {

	ResetFrequencyMeta metaData = new ResetFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
	 *
	 */
	WeeklyRollConventionEnum getWeeklyRollConvention();

	/*********************** Build Methods  ***********************/
	ResetFrequency build();
	
	ResetFrequency.ResetFrequencyBuilder toBuilder();
	
	static ResetFrequency.ResetFrequencyBuilder builder() {
		return new ResetFrequency.ResetFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetFrequency> getType() {
		return ResetFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("weeklyRollConvention"), WeeklyRollConventionEnum.class, getWeeklyRollConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetFrequencyBuilder extends ResetFrequency, Frequency.FrequencyBuilder {
		@Override
		ResetFrequency.ResetFrequencyBuilder setId(String id);
		@Override
		ResetFrequency.ResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		ResetFrequency.ResetFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		ResetFrequency.ResetFrequencyBuilder setWeeklyRollConvention(WeeklyRollConventionEnum weeklyRollConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("weeklyRollConvention"), WeeklyRollConventionEnum.class, getWeeklyRollConvention(), this);
		}
		

		ResetFrequency.ResetFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of ResetFrequency  ***********************/
	class ResetFrequencyImpl extends Frequency.FrequencyImpl implements ResetFrequency {
		private final WeeklyRollConventionEnum weeklyRollConvention;
		
		protected ResetFrequencyImpl(ResetFrequency.ResetFrequencyBuilder builder) {
			super(builder);
			this.weeklyRollConvention = builder.getWeeklyRollConvention();
		}
		
		@Override
		@RosettaAttribute("weeklyRollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weeklyRollConvention")
		public WeeklyRollConventionEnum getWeeklyRollConvention() {
			return weeklyRollConvention;
		}
		
		@Override
		public ResetFrequency build() {
			return this;
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder toBuilder() {
			ResetFrequency.ResetFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetFrequency.ResetFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getWeeklyRollConvention()).ifPresent(builder::setWeeklyRollConvention);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(weeklyRollConvention, _that.getWeeklyRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weeklyRollConvention != null ? weeklyRollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetFrequency {" +
				"weeklyRollConvention=" + this.weeklyRollConvention +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResetFrequency  ***********************/
	class ResetFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl implements ResetFrequency.ResetFrequencyBuilder {
	
		protected WeeklyRollConventionEnum weeklyRollConvention;
		
		@Override
		@RosettaAttribute("weeklyRollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weeklyRollConvention")
		public WeeklyRollConventionEnum getWeeklyRollConvention() {
			return weeklyRollConvention;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ResetFrequency.ResetFrequencyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public ResetFrequency.ResetFrequencyBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public ResetFrequency.ResetFrequencyBuilder setPeriod(PeriodExtendedEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("weeklyRollConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weeklyRollConvention")
		@Override
		public ResetFrequency.ResetFrequencyBuilder setWeeklyRollConvention(WeeklyRollConventionEnum _weeklyRollConvention) {
			this.weeklyRollConvention = _weeklyRollConvention == null ? null : _weeklyRollConvention;
			return this;
		}
		
		@Override
		public ResetFrequency build() {
			return new ResetFrequency.ResetFrequencyImpl(this);
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetFrequency.ResetFrequencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getWeeklyRollConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetFrequency.ResetFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ResetFrequency.ResetFrequencyBuilder o = (ResetFrequency.ResetFrequencyBuilder) other;
			
			
			merger.mergeBasic(getWeeklyRollConvention(), o.getWeeklyRollConvention(), this::setWeeklyRollConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(weeklyRollConvention, _that.getWeeklyRollConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weeklyRollConvention != null ? weeklyRollConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetFrequencyBuilder {" +
				"weeklyRollConvention=" + this.weeklyRollConvention +
			'}' + " " + super.toString();
		}
	}
}
