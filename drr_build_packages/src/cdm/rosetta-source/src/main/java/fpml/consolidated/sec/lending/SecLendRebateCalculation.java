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
import fpml.consolidated.sec.lending.meta.SecLendRebateCalculationMeta;
import fpml.consolidated.shared.Frequency;
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
 * Provision Cash collateral rebate in a security lending transaction: a portion of investment interest on the cash collateral, rebated (returned) to the party posting the collateral (the security borrower). Under a cash-collateralised transation, the securities lending fee is implicit in the level of the rebate. In the case of a "special" loan on a hard-to-borrow security, a negative rebate may be negotiated i.e. the borrower pays a fee to the lender. The lender retains the investment earnings on the cash collateral, and earns an additional premium.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Cash collateral rebate in a security lending transaction: a portion of investment interest on the cash collateral, rebated (returned) to the party posting the collateral (the security borrower). Under a cash-collateralised transation, the securities lending fee is implicit in the level of the rebate. In the case of a "special" loan on a hard-to-borrow security, a negative rebate may be negotiated i.e. the borrower pays a fee to the lender. The lender retains the investment earnings on the cash collateral, and earns an additional premium.
 *
 */
@RosettaDataType(value="SecLendRebateCalculation", builder=SecLendRebateCalculation.SecLendRebateCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendRebateCalculation", model="fpml", builder=SecLendRebateCalculation.SecLendRebateCalculationBuilderImpl.class, version="2.1.1")
public interface SecLendRebateCalculation extends RosettaModelObject {

	SecLendRebateCalculationMeta metaData = new SecLendRebateCalculationMeta();

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

	/*********************** Build Methods  ***********************/
	SecLendRebateCalculation build();
	
	SecLendRebateCalculation.SecLendRebateCalculationBuilder toBuilder();
	
	static SecLendRebateCalculation.SecLendRebateCalculationBuilder builder() {
		return new SecLendRebateCalculation.SecLendRebateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendRebateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendRebateCalculation> getType() {
		return SecLendRebateCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.class, getResetFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendRebateCalculationBuilder extends SecLendRebateCalculation, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		@Override
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation();
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation();
		Frequency.FrequencyBuilder getOrCreateResetFrequency();
		@Override
		Frequency.FrequencyBuilder getResetFrequency();
		SecLendRebateCalculation.SecLendRebateCalculationBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		SecLendRebateCalculation.SecLendRebateCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		SecLendRebateCalculation.SecLendRebateCalculationBuilder setResetFrequency(Frequency resetFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.FrequencyBuilder.class, getResetFrequency());
		}
		

		SecLendRebateCalculation.SecLendRebateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendRebateCalculation  ***********************/
	class SecLendRebateCalculationImpl implements SecLendRebateCalculation {
		private final Schedule fixedRateSchedule;
		private final FloatingRateCalculation floatingRateCalculation;
		private final Frequency resetFrequency;
		
		protected SecLendRebateCalculationImpl(SecLendRebateCalculation.SecLendRebateCalculationBuilder builder) {
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.floatingRateCalculation = ofNullable(builder.getFloatingRateCalculation()).map(f->f.build()).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).map(f->f.build()).orElse(null);
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
		public SecLendRebateCalculation build() {
			return this;
		}
		
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder toBuilder() {
			SecLendRebateCalculation.SecLendRebateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendRebateCalculation.SecLendRebateCalculationBuilder builder) {
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFloatingRateCalculation()).ifPresent(builder::setFloatingRateCalculation);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendRebateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendRebateCalculation {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of SecLendRebateCalculation  ***********************/
	class SecLendRebateCalculationBuilderImpl implements SecLendRebateCalculation.SecLendRebateCalculationBuilder {
	
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRateCalculation;
		protected Frequency.FrequencyBuilder resetFrequency;
		
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
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateSchedule")
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder setFixedRateSchedule(Schedule _fixedRateSchedule) {
			this.fixedRateSchedule = _fixedRateSchedule == null ? null : _fixedRateSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateCalculation")
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation _floatingRateCalculation) {
			this.floatingRateCalculation = _floatingRateCalculation == null ? null : _floatingRateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetFrequency")
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder setResetFrequency(Frequency _resetFrequency) {
			this.resetFrequency = _resetFrequency == null ? null : _resetFrequency.toBuilder();
			return this;
		}
		
		@Override
		public SecLendRebateCalculation build() {
			return new SecLendRebateCalculation.SecLendRebateCalculationImpl(this);
		}
		
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder prune() {
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (floatingRateCalculation!=null && !floatingRateCalculation.prune().hasData()) floatingRateCalculation = null;
			if (resetFrequency!=null && !resetFrequency.prune().hasData()) resetFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFloatingRateCalculation()!=null && getFloatingRateCalculation().hasData()) return true;
			if (getResetFrequency()!=null && getResetFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecLendRebateCalculation.SecLendRebateCalculationBuilder o = (SecLendRebateCalculation.SecLendRebateCalculationBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFloatingRateCalculation(), o.getFloatingRateCalculation(), this::setFloatingRateCalculation);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::setResetFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendRebateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendRebateCalculationBuilder {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency +
			'}';
		}
	}
}
