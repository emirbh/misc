package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.LagMeta;
import fpml.consolidated.shared.Period;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An observation period that is offset from a Calculation Period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An observation period that is offset from a Calculation Period.
 *
 */
@RosettaDataType(value="Lag", builder=Lag.LagBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Lag", model="fpml", builder=Lag.LagBuilderImpl.class, version="2.1.1")
public interface Lag extends RosettaModelObject {

	LagMeta metaData = new LagMeta();

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
	 * Provision The period during which observations will be made. If a firstObservationDateOffset is specified, the observation period will start the specified interval prior to each Calculation Period - i.e. if the firstObservationDateOffset is 4 months and the lagDuration is 3 months, observations will be taken in months 4,3 and 2 (but not 1) prior to each Calculation Period. If no firstObservationDate is specified, the observation period will end immediately preceding each Calculation Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The period during which observations will be made. If a firstObservationDateOffset is specified, the observation period will start the specified interval prior to each Calculation Period - i.e. if the firstObservationDateOffset is 4 months and the lagDuration is 3 months, observations will be taken in months 4,3 and 2 (but not 1) prior to each Calculation Period. If no firstObservationDate is specified, the observation period will end immediately preceding each Calculation Period.
	 *
	 */
	Period getLagDuration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The interval between the start of each lagDuration and the start of each respective calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The interval between the start of each lagDuration and the start of each respective calculation period.
	 *
	 */
	Period getFirstObservationDateOffset();

	/*********************** Build Methods  ***********************/
	Lag build();
	
	Lag.LagBuilder toBuilder();
	
	static Lag.LagBuilder builder() {
		return new Lag.LagBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Lag> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Lag> getType() {
		return Lag.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("lagDuration"), processor, Period.class, getLagDuration());
		processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Period.class, getFirstObservationDateOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LagBuilder extends Lag, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateLagDuration();
		@Override
		Period.PeriodBuilder getLagDuration();
		Period.PeriodBuilder getOrCreateFirstObservationDateOffset();
		@Override
		Period.PeriodBuilder getFirstObservationDateOffset();
		Lag.LagBuilder setId(String id);
		Lag.LagBuilder setLagDuration(Period lagDuration);
		Lag.LagBuilder setFirstObservationDateOffset(Period firstObservationDateOffset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("lagDuration"), processor, Period.PeriodBuilder.class, getLagDuration());
			processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Period.PeriodBuilder.class, getFirstObservationDateOffset());
		}
		

		Lag.LagBuilder prune();
	}

	/*********************** Immutable Implementation of Lag  ***********************/
	class LagImpl implements Lag {
		private final String id;
		private final Period lagDuration;
		private final Period firstObservationDateOffset;
		
		protected LagImpl(Lag.LagBuilder builder) {
			this.id = builder.getId();
			this.lagDuration = ofNullable(builder.getLagDuration()).map(f->f.build()).orElse(null);
			this.firstObservationDateOffset = ofNullable(builder.getFirstObservationDateOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("lagDuration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lagDuration")
		public Period getLagDuration() {
			return lagDuration;
		}
		
		@Override
		@RosettaAttribute("firstObservationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstObservationDateOffset")
		public Period getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		public Lag build() {
			return this;
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			Lag.LagBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lag.LagBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getLagDuration()).ifPresent(builder::setLagDuration);
			ofNullable(getFirstObservationDateOffset()).ifPresent(builder::setFirstObservationDateOffset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lag {" +
				"id=" + this.id + ", " +
				"lagDuration=" + this.lagDuration + ", " +
				"firstObservationDateOffset=" + this.firstObservationDateOffset +
			'}';
		}
	}

	/*********************** Builder Implementation of Lag  ***********************/
	class LagBuilderImpl implements Lag.LagBuilder {
	
		protected String id;
		protected Period.PeriodBuilder lagDuration;
		protected Period.PeriodBuilder firstObservationDateOffset;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("lagDuration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lagDuration")
		public Period.PeriodBuilder getLagDuration() {
			return lagDuration;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateLagDuration() {
			Period.PeriodBuilder result;
			if (lagDuration!=null) {
				result = lagDuration;
			}
			else {
				result = lagDuration = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstObservationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstObservationDateOffset")
		public Period.PeriodBuilder getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateFirstObservationDateOffset() {
			Period.PeriodBuilder result;
			if (firstObservationDateOffset!=null) {
				result = firstObservationDateOffset;
			}
			else {
				result = firstObservationDateOffset = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Lag.LagBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("lagDuration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lagDuration")
		@Override
		public Lag.LagBuilder setLagDuration(Period _lagDuration) {
			this.lagDuration = _lagDuration == null ? null : _lagDuration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstObservationDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstObservationDateOffset")
		@Override
		public Lag.LagBuilder setFirstObservationDateOffset(Period _firstObservationDateOffset) {
			this.firstObservationDateOffset = _firstObservationDateOffset == null ? null : _firstObservationDateOffset.toBuilder();
			return this;
		}
		
		@Override
		public Lag build() {
			return new Lag.LagImpl(this);
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder prune() {
			if (lagDuration!=null && !lagDuration.prune().hasData()) lagDuration = null;
			if (firstObservationDateOffset!=null && !firstObservationDateOffset.prune().hasData()) firstObservationDateOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getLagDuration()!=null && getLagDuration().hasData()) return true;
			if (getFirstObservationDateOffset()!=null && getFirstObservationDateOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lag.LagBuilder o = (Lag.LagBuilder) other;
			
			merger.mergeRosetta(getLagDuration(), o.getLagDuration(), this::setLagDuration);
			merger.mergeRosetta(getFirstObservationDateOffset(), o.getFirstObservationDateOffset(), this::setFirstObservationDateOffset);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LagBuilder {" +
				"id=" + this.id + ", " +
				"lagDuration=" + this.lagDuration + ", " +
				"firstObservationDateOffset=" + this.firstObservationDateOffset +
			'}';
		}
	}
}
