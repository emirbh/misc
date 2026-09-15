package fpml.consolidated.shared;

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
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.meta.PeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define recurring periods or time offsets.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define recurring periods or time offsets.
 *
 */
@RosettaDataType(value="Period", builder=Period.PeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Period", model="fpml", builder=Period.PeriodBuilderImpl.class, version="2.1.1")
public interface Period extends RosettaModelObject {

	PeriodMeta metaData = new PeriodMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
	 *
	 */
	Integer getPeriodMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
	 *
	 */
	PeriodEnum getPeriod();

	/*********************** Build Methods  ***********************/
	Period build();
	
	Period.PeriodBuilder toBuilder();
	
	static Period.PeriodBuilder builder() {
		return new Period.PeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Period> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Period> getType() {
		return Period.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodBuilder extends Period, RosettaModelObjectBuilder {
		Period.PeriodBuilder setId(String id);
		Period.PeriodBuilder setPeriodMultiplier(Integer periodMultiplier);
		Period.PeriodBuilder setPeriod(PeriodEnum period);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		}
		

		Period.PeriodBuilder prune();
	}

	/*********************** Immutable Implementation of Period  ***********************/
	class PeriodImpl implements Period {
		private final String id;
		private final Integer periodMultiplier;
		private final PeriodEnum period;
		
		protected PeriodImpl(Period.PeriodBuilder builder) {
			this.id = builder.getId();
			this.periodMultiplier = builder.getPeriodMultiplier();
			this.period = builder.getPeriod();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("period")
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		public Period build() {
			return this;
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			Period.PeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Period.PeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Period {" +
				"id=" + this.id + ", " +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period +
			'}';
		}
	}

	/*********************** Builder Implementation of Period  ***********************/
	class PeriodBuilderImpl implements Period.PeriodBuilder {
	
		protected String id;
		protected Integer periodMultiplier;
		protected PeriodEnum period;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("period")
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Period.PeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodMultiplier")
		@Override
		public Period.PeriodBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("period")
		@Override
		public Period.PeriodBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@Override
		public Period build() {
			return new Period.PeriodImpl(this);
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPeriodMultiplier()!=null) return true;
			if (getPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Period.PeriodBuilder o = (Period.PeriodBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodBuilder {" +
				"id=" + this.id + ", " +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period +
			'}';
		}
	}
}
