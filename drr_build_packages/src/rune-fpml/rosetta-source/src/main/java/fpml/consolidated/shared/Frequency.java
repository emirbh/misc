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
import fpml.consolidated.shared.meta.FrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a time frequency, e.g. one day, three months. Used for specifying payment or calculation frequencies at which the value T (Term) is applicable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a time frequency, e.g. one day, three months. Used for specifying payment or calculation frequencies at which the value T (Term) is applicable.
 *
 */
@RosettaDataType(value="Frequency", builder=Frequency.FrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Frequency", model="fpml", builder=Frequency.FrequencyBuilderImpl.class, version="2.1.1")
public interface Frequency extends RosettaModelObject {

	FrequencyMeta metaData = new FrequencyMeta();

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
	 * Provision A time period multiplier, e.g. 1, 2 or 3 etc. If the period value is T (Term) then periodMultiplier must contain the value 1.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time period multiplier, e.g. 1, 2 or 3 etc. If the period value is T (Term) then periodMultiplier must contain the value 1.
	 *
	 */
	Integer getPeriodMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time period, e.g. a day, week, month, year or term of the stream.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time period, e.g. a day, week, month, year or term of the stream.
	 *
	 */
	PeriodExtendedEnum getPeriod();

	/*********************** Build Methods  ***********************/
	Frequency build();
	
	Frequency.FrequencyBuilder toBuilder();
	
	static Frequency.FrequencyBuilder builder() {
		return new Frequency.FrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Frequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Frequency> getType() {
		return Frequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FrequencyBuilder extends Frequency, RosettaModelObjectBuilder {
		Frequency.FrequencyBuilder setId(String id);
		Frequency.FrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum period);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		}
		

		Frequency.FrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of Frequency  ***********************/
	class FrequencyImpl implements Frequency {
		private final String id;
		private final Integer periodMultiplier;
		private final PeriodExtendedEnum period;
		
		protected FrequencyImpl(Frequency.FrequencyBuilder builder) {
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
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("period")
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@Override
		public Frequency build() {
			return this;
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			Frequency.FrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Frequency.FrequencyBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "Frequency {" +
				"id=" + this.id + ", " +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period +
			'}';
		}
	}

	/*********************** Builder Implementation of Frequency  ***********************/
	class FrequencyBuilderImpl implements Frequency.FrequencyBuilder {
	
		protected String id;
		protected Integer periodMultiplier;
		protected PeriodExtendedEnum period;
		
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
		@RuneAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("period")
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Frequency.FrequencyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public Frequency.FrequencyBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@Override
		public Frequency build() {
			return new Frequency.FrequencyImpl(this);
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Frequency.FrequencyBuilder prune() {
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
		public Frequency.FrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Frequency.FrequencyBuilder o = (Frequency.FrequencyBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "FrequencyBuilder {" +
				"id=" + this.id + ", " +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period +
			'}';
		}
	}
}
