package fpml.consolidated.sec.lending;

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
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.meta.SecLendFeeCalculationMeta;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.Schedule;
import java.util.Objects;

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
@RosettaDataType(value="SecLendFeeCalculation", builder=SecLendFeeCalculation.SecLendFeeCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendFeeCalculation", model="fpml", builder=SecLendFeeCalculation.SecLendFeeCalculationBuilderImpl.class, version="2.1.1")
public interface SecLendFeeCalculation extends RosettaModelObject {

	SecLendFeeCalculationMeta metaData = new SecLendFeeCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fixed repo or security lending rate. It is usually fixed rebate rate for the duration of the agreement but can be changed with mid-life events (rate changes).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fixed repo or security lending rate. It is usually fixed rebate rate for the duration of the agreement but can be changed with mid-life events (rate changes).
	 *
	 */
	Schedule getFixedRateSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floating rate index and tenor, with additional definitions relating to the calculation of floating rate amounts, including spread and multiplier. It is used for floating rate repo or security lending. For example, most floating rate repo or security lending on European markets are against EONIA
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floating rate index and tenor, with additional definitions relating to the calculation of floating rate amounts, including spread and multiplier. It is used for floating rate repo or security lending. For example, most floating rate repo or security lending on European markets are against EONIA
	 *
	 */
	FloatingRateCalculation getFloatingRateCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floating rate reset frequency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floating rate reset frequency.
	 *
	 */
	Frequency getResetFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure, that a trade generates enough income.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure, that a trade generates enough income.
	 *
	 */
	PositiveMoney getMinimumFee();

	/*********************** Build Methods  ***********************/
	SecLendFeeCalculation build();
	
	SecLendFeeCalculation.SecLendFeeCalculationBuilder toBuilder();
	
	static SecLendFeeCalculation.SecLendFeeCalculationBuilder builder() {
		return new SecLendFeeCalculation.SecLendFeeCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendFeeCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendFeeCalculation> getType() {
		return SecLendFeeCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.class, getResetFrequency());
		processRosetta(path.newSubPath("minimumFee"), processor, PositiveMoney.class, getMinimumFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendFeeCalculationBuilder extends SecLendFeeCalculation, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		@Override
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation();
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation();
		Frequency.FrequencyBuilder getOrCreateResetFrequency();
		@Override
		Frequency.FrequencyBuilder getResetFrequency();
		PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumFee();
		@Override
		PositiveMoney.PositiveMoneyBuilder getMinimumFee();
		SecLendFeeCalculation.SecLendFeeCalculationBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		SecLendFeeCalculation.SecLendFeeCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		SecLendFeeCalculation.SecLendFeeCalculationBuilder setResetFrequency(Frequency resetFrequency);
		SecLendFeeCalculation.SecLendFeeCalculationBuilder setMinimumFee(PositiveMoney minimumFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.FrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("minimumFee"), processor, PositiveMoney.PositiveMoneyBuilder.class, getMinimumFee());
		}
		

		SecLendFeeCalculation.SecLendFeeCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendFeeCalculation  ***********************/
	class SecLendFeeCalculationImpl implements SecLendFeeCalculation {
		private final Schedule fixedRateSchedule;
		private final FloatingRateCalculation floatingRateCalculation;
		private final Frequency resetFrequency;
		private final PositiveMoney minimumFee;
		
		protected SecLendFeeCalculationImpl(SecLendFeeCalculation.SecLendFeeCalculationBuilder builder) {
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.floatingRateCalculation = ofNullable(builder.getFloatingRateCalculation()).map(f->f.build()).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).map(f->f.build()).orElse(null);
			this.minimumFee = ofNullable(builder.getMinimumFee()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateCalculation")
		public FloatingRateCalculation getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetFrequency")
		public Frequency getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("minimumFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumFee")
		public PositiveMoney getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public SecLendFeeCalculation build() {
			return this;
		}
		
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder toBuilder() {
			SecLendFeeCalculation.SecLendFeeCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendFeeCalculation.SecLendFeeCalculationBuilder builder) {
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFloatingRateCalculation()).ifPresent(builder::setFloatingRateCalculation);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getMinimumFee()).ifPresent(builder::setMinimumFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendFeeCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendFeeCalculation {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"minimumFee=" + this.minimumFee +
			'}';
		}
	}

	/*********************** Builder Implementation of SecLendFeeCalculation  ***********************/
	class SecLendFeeCalculationBuilderImpl implements SecLendFeeCalculation.SecLendFeeCalculationBuilder {
	
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRateCalculation;
		protected Frequency.FrequencyBuilder resetFrequency;
		protected PositiveMoney.PositiveMoneyBuilder minimumFee;
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule.ScheduleBuilder getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (fixedRateSchedule!=null) {
				result = fixedRateSchedule;
			}
			else {
				result = fixedRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateCalculation")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRateCalculation!=null) {
				result = floatingRateCalculation;
			}
			else {
				result = floatingRateCalculation = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetFrequency")
		public Frequency.FrequencyBuilder getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateResetFrequency() {
			Frequency.FrequencyBuilder result;
			if (resetFrequency!=null) {
				result = resetFrequency;
			}
			else {
				result = resetFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumFee")
		public PositiveMoney.PositiveMoneyBuilder getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumFee() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (minimumFee!=null) {
				result = minimumFee;
			}
			else {
				result = minimumFee = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateSchedule")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder setFixedRateSchedule(Schedule _fixedRateSchedule) {
			this.fixedRateSchedule = _fixedRateSchedule == null ? null : _fixedRateSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateCalculation")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation _floatingRateCalculation) {
			this.floatingRateCalculation = _floatingRateCalculation == null ? null : _floatingRateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetFrequency")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder setResetFrequency(Frequency _resetFrequency) {
			this.resetFrequency = _resetFrequency == null ? null : _resetFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumFee")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder setMinimumFee(PositiveMoney _minimumFee) {
			this.minimumFee = _minimumFee == null ? null : _minimumFee.toBuilder();
			return this;
		}
		
		@Override
		public SecLendFeeCalculation build() {
			return new SecLendFeeCalculation.SecLendFeeCalculationImpl(this);
		}
		
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder prune() {
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (floatingRateCalculation!=null && !floatingRateCalculation.prune().hasData()) floatingRateCalculation = null;
			if (resetFrequency!=null && !resetFrequency.prune().hasData()) resetFrequency = null;
			if (minimumFee!=null && !minimumFee.prune().hasData()) minimumFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFloatingRateCalculation()!=null && getFloatingRateCalculation().hasData()) return true;
			if (getResetFrequency()!=null && getResetFrequency().hasData()) return true;
			if (getMinimumFee()!=null && getMinimumFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecLendFeeCalculation.SecLendFeeCalculationBuilder o = (SecLendFeeCalculation.SecLendFeeCalculationBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFloatingRateCalculation(), o.getFloatingRateCalculation(), this::setFloatingRateCalculation);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::setResetFrequency);
			merger.mergeRosetta(getMinimumFee(), o.getMinimumFee(), this::setMinimumFee);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendFeeCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendFeeCalculationBuilder {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"minimumFee=" + this.minimumFee +
			'}';
		}
	}
}
