package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.loan.meta.DueDateAdjustmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe a business adjustment to a due date (e.g. for completing a covenant obligation).
 *
 */
@RosettaDataType(value="DueDateAdjustment", builder=DueDateAdjustment.DueDateAdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DueDateAdjustment", model="fpml", builder=DueDateAdjustment.DueDateAdjustmentBuilderImpl.class, version="2.1.1")
public interface DueDateAdjustment extends RosettaModelObject {

	DueDateAdjustmentMeta metaData = new DueDateAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days adjustment.
	 *
	 */
	Integer getNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of day adjustment being applied (e.g. "business" vs. "calendar" days).
	 *
	 */
	DayTypeEnum getDayType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the type of adjustment (e.g. grace days, leading days, trailling days, etc.), based on a scheme.
	 *
	 */
	DateAdjustmentType getAdjustmentType();

	/*********************** Build Methods  ***********************/
	DueDateAdjustment build();
	
	DueDateAdjustment.DueDateAdjustmentBuilder toBuilder();
	
	static DueDateAdjustment.DueDateAdjustmentBuilder builder() {
		return new DueDateAdjustment.DueDateAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DueDateAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DueDateAdjustment> getType() {
		return DueDateAdjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("adjustmentType"), processor, DateAdjustmentType.class, getAdjustmentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DueDateAdjustmentBuilder extends DueDateAdjustment, RosettaModelObjectBuilder {
		DateAdjustmentType.DateAdjustmentTypeBuilder getOrCreateAdjustmentType();
		@Override
		DateAdjustmentType.DateAdjustmentTypeBuilder getAdjustmentType();
		DueDateAdjustment.DueDateAdjustmentBuilder setNumberOfDays(Integer numberOfDays);
		DueDateAdjustment.DueDateAdjustmentBuilder setDayType(DayTypeEnum dayType);
		DueDateAdjustment.DueDateAdjustmentBuilder setAdjustmentType(DateAdjustmentType adjustmentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("adjustmentType"), processor, DateAdjustmentType.DateAdjustmentTypeBuilder.class, getAdjustmentType());
		}
		

		DueDateAdjustment.DueDateAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of DueDateAdjustment  ***********************/
	class DueDateAdjustmentImpl implements DueDateAdjustment {
		private final Integer numberOfDays;
		private final DayTypeEnum dayType;
		private final DateAdjustmentType adjustmentType;
		
		protected DueDateAdjustmentImpl(DueDateAdjustment.DueDateAdjustmentBuilder builder) {
			this.numberOfDays = builder.getNumberOfDays();
			this.dayType = builder.getDayType();
			this.adjustmentType = ofNullable(builder.getAdjustmentType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustmentType")
		public DateAdjustmentType getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		public DueDateAdjustment build() {
			return this;
		}
		
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder toBuilder() {
			DueDateAdjustment.DueDateAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DueDateAdjustment.DueDateAdjustmentBuilder builder) {
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getAdjustmentType()).ifPresent(builder::setAdjustmentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DueDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DueDateAdjustment {" +
				"numberOfDays=" + this.numberOfDays + ", " +
				"dayType=" + this.dayType + ", " +
				"adjustmentType=" + this.adjustmentType +
			'}';
		}
	}

	/*********************** Builder Implementation of DueDateAdjustment  ***********************/
	class DueDateAdjustmentBuilderImpl implements DueDateAdjustment.DueDateAdjustmentBuilder {
	
		protected Integer numberOfDays;
		protected DayTypeEnum dayType;
		protected DateAdjustmentType.DateAdjustmentTypeBuilder adjustmentType;
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustmentType")
		public DateAdjustmentType.DateAdjustmentTypeBuilder getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder getOrCreateAdjustmentType() {
			DateAdjustmentType.DateAdjustmentTypeBuilder result;
			if (adjustmentType!=null) {
				result = adjustmentType;
			}
			else {
				result = adjustmentType = DateAdjustmentType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayType")
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustmentType")
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder setAdjustmentType(DateAdjustmentType _adjustmentType) {
			this.adjustmentType = _adjustmentType == null ? null : _adjustmentType.toBuilder();
			return this;
		}
		
		@Override
		public DueDateAdjustment build() {
			return new DueDateAdjustment.DueDateAdjustmentImpl(this);
		}
		
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder prune() {
			if (adjustmentType!=null && !adjustmentType.prune().hasData()) adjustmentType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfDays()!=null) return true;
			if (getDayType()!=null) return true;
			if (getAdjustmentType()!=null && getAdjustmentType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DueDateAdjustment.DueDateAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DueDateAdjustment.DueDateAdjustmentBuilder o = (DueDateAdjustment.DueDateAdjustmentBuilder) other;
			
			merger.mergeRosetta(getAdjustmentType(), o.getAdjustmentType(), this::setAdjustmentType);
			
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DueDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DueDateAdjustmentBuilder {" +
				"numberOfDays=" + this.numberOfDays + ", " +
				"dayType=" + this.dayType + ", " +
				"adjustmentType=" + this.adjustmentType +
			'}';
		}
	}
}
