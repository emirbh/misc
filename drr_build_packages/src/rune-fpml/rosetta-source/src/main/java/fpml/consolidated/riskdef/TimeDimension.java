package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.TimeDimensionMeta;
import fpml.consolidated.shared.Period;
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
 * Provision The time dimensions of a term-structure. The user must supply either a tenor or a date or both.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The time dimensions of a term-structure. The user must supply either a tenor or a date or both.
 *
 */
@RosettaDataType(value="TimeDimension", builder=TimeDimension.TimeDimensionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TimeDimension", model="fpml", builder=TimeDimension.TimeDimensionBuilderImpl.class, version="2.1.1")
public interface TimeDimension extends RosettaModelObject {

	TimeDimensionMeta metaData = new TimeDimensionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The absolute date corresponding to this term point, for example January 3, 2005.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The absolute date corresponding to this term point, for example January 3, 2005.
	 *
	 */
	ZonedDateTime getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount of time from the base date of the pricing input to the specified term point, e.g. 6M or 5Y.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of time from the base date of the pricing input to the specified term point, e.g. 6M or 5Y.
	 *
	 */
	Period getTenor();

	/*********************** Build Methods  ***********************/
	TimeDimension build();
	
	TimeDimension.TimeDimensionBuilder toBuilder();
	
	static TimeDimension.TimeDimensionBuilder builder() {
		return new TimeDimension.TimeDimensionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimeDimension> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TimeDimension> getType() {
		return TimeDimension.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimeDimensionBuilder extends TimeDimension, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenor();
		@Override
		Period.PeriodBuilder getTenor();
		TimeDimension.TimeDimensionBuilder setDate(ZonedDateTime date);
		TimeDimension.TimeDimensionBuilder setTenor(Period tenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
		}
		

		TimeDimension.TimeDimensionBuilder prune();
	}

	/*********************** Immutable Implementation of TimeDimension  ***********************/
	class TimeDimensionImpl implements TimeDimension {
		private final ZonedDateTime date;
		private final Period tenor;
		
		protected TimeDimensionImpl(TimeDimension.TimeDimensionBuilder builder) {
			this.date = builder.getDate();
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenor")
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		public TimeDimension build() {
			return this;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder toBuilder() {
			TimeDimension.TimeDimensionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimeDimension.TimeDimensionBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTenor()).ifPresent(builder::setTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimension _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimension {" +
				"date=" + this.date + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}

	/*********************** Builder Implementation of TimeDimension  ***********************/
	class TimeDimensionBuilderImpl implements TimeDimension.TimeDimensionBuilder {
	
		protected ZonedDateTime date;
		protected Period.PeriodBuilder tenor;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenor")
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public TimeDimension.TimeDimensionBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("tenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenor")
		@Override
		public TimeDimension.TimeDimensionBuilder setTenor(Period _tenor) {
			this.tenor = _tenor == null ? null : _tenor.toBuilder();
			return this;
		}
		
		@Override
		public TimeDimension build() {
			return new TimeDimension.TimeDimensionImpl(this);
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimension.TimeDimensionBuilder prune() {
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getTenor()!=null && getTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimension.TimeDimensionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimeDimension.TimeDimensionBuilder o = (TimeDimension.TimeDimensionBuilder) other;
			
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimension _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimensionBuilder {" +
				"date=" + this.date + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
}
