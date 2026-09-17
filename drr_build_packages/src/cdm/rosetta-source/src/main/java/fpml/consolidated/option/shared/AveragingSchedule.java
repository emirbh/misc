package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.AveragingScheduleMeta;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Method of generating a series of dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Method of generating a series of dates.
 *
 */
@RosettaDataType(value="AveragingSchedule", builder=AveragingSchedule.AveragingScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AveragingSchedule", model="fpml", builder=AveragingSchedule.AveragingScheduleBuilderImpl.class, version="2.1.1")
public interface AveragingSchedule extends RosettaModelObject {

	AveragingScheduleMeta metaData = new AveragingScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
	 *
	 */
	CalculationPeriodFrequency getAveragingPeriodFrequency();

	/*********************** Build Methods  ***********************/
	AveragingSchedule build();
	
	AveragingSchedule.AveragingScheduleBuilder toBuilder();
	
	static AveragingSchedule.AveragingScheduleBuilder builder() {
		return new AveragingSchedule.AveragingScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AveragingSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AveragingSchedule> getType() {
		return AveragingSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.class, getAveragingPeriodFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AveragingScheduleBuilder extends AveragingSchedule, RosettaModelObjectBuilder {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency();
		@Override
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency();
		AveragingSchedule.AveragingScheduleBuilder setStartDate(ZonedDateTime startDate);
		AveragingSchedule.AveragingScheduleBuilder setEndDate(ZonedDateTime endDate);
		AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency averagingPeriodFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getAveragingPeriodFrequency());
		}
		

		AveragingSchedule.AveragingScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of AveragingSchedule  ***********************/
	class AveragingScheduleImpl implements AveragingSchedule {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final CalculationPeriodFrequency averagingPeriodFrequency;
		
		protected AveragingScheduleImpl(AveragingSchedule.AveragingScheduleBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.averagingPeriodFrequency = ofNullable(builder.getAveragingPeriodFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("averagingPeriodFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingPeriodFrequency")
		public CalculationPeriodFrequency getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public AveragingSchedule build() {
			return this;
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			AveragingSchedule.AveragingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragingSchedule.AveragingScheduleBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getAveragingPeriodFrequency()).ifPresent(builder::setAveragingPeriodFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingSchedule {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of AveragingSchedule  ***********************/
	class AveragingScheduleBuilderImpl implements AveragingSchedule.AveragingScheduleBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder averagingPeriodFrequency;
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("averagingPeriodFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingPeriodFrequency")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (averagingPeriodFrequency!=null) {
				result = averagingPeriodFrequency;
			}
			else {
				result = averagingPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("averagingPeriodFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingPeriodFrequency")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency _averagingPeriodFrequency) {
			this.averagingPeriodFrequency = _averagingPeriodFrequency == null ? null : _averagingPeriodFrequency.toBuilder();
			return this;
		}
		
		@Override
		public AveragingSchedule build() {
			return new AveragingSchedule.AveragingScheduleImpl(this);
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder prune() {
			if (averagingPeriodFrequency!=null && !averagingPeriodFrequency.prune().hasData()) averagingPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getAveragingPeriodFrequency()!=null && getAveragingPeriodFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AveragingSchedule.AveragingScheduleBuilder o = (AveragingSchedule.AveragingScheduleBuilder) other;
			
			merger.mergeRosetta(getAveragingPeriodFrequency(), o.getAveragingPeriodFrequency(), this::setAveragingPeriodFrequency);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingScheduleBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency +
			'}';
		}
	}
}
