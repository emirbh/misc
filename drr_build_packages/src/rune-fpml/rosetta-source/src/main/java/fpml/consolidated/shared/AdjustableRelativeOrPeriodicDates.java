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
import fpml.consolidated.shared.meta.AdjustableRelativeOrPeriodicDatesMeta;
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
@RosettaDataType(value="AdjustableRelativeOrPeriodicDates", builder=AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableRelativeOrPeriodicDates", model="fpml", builder=AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl.class, version="2.1.1")
public interface AdjustableRelativeOrPeriodicDates extends RosettaModelObject {

	AdjustableRelativeOrPeriodicDatesMeta metaData = new AdjustableRelativeOrPeriodicDatesMeta();

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
	 * Provision A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 */
	AdjustableDates getAdjustableDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A series of dates specified as some offset to other dates (the anchor dates) which can
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A series of dates specified as some offset to other dates (the anchor dates) which can
	 *
	 */
	RelativeDateSequence getRelativeDateSequence();
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
	PeriodicDates getPeriodicDates();

	/*********************** Build Methods  ***********************/
	AdjustableRelativeOrPeriodicDates build();
	
	AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder();
	
	static AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder() {
		return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableRelativeOrPeriodicDates> getType() {
		return AdjustableRelativeOrPeriodicDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.class, getRelativeDateSequence());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableRelativeOrPeriodicDatesBuilder extends AdjustableRelativeOrPeriodicDates, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence();
		@Override
		RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		@Override
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setId(String id);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.RelativeDateSequenceBuilder.class, getRelativeDateSequence());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
		}
		

		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesImpl implements AdjustableRelativeOrPeriodicDates {
		private final String id;
		private final AdjustableDates adjustableDates;
		private final RelativeDateSequence relativeDateSequence;
		private final PeriodicDates periodicDates;
		
		protected AdjustableRelativeOrPeriodicDatesImpl(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			this.id = builder.getId();
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDateSequence = ofNullable(builder.getRelativeDateSequence()).map(f->f.build()).orElse(null);
			this.periodicDates = ofNullable(builder.getPeriodicDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDateSequence")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDateSequence")
		public RelativeDateSequence getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicDates")
		public PeriodicDates getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDateSequence()).ifPresent(builder::setRelativeDateSequence);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"periodicDates=" + this.periodicDates +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesBuilderImpl implements AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder {
	
		protected String id;
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDateSequence.RelativeDateSequenceBuilder relativeDateSequence;
		protected PeriodicDates.PeriodicDatesBuilder periodicDates;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDateSequence")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDateSequence")
		public RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence() {
			RelativeDateSequence.RelativeDateSequenceBuilder result;
			if (relativeDateSequence!=null) {
				result = relativeDateSequence;
			}
			else {
				result = relativeDateSequence = RelativeDateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicDates")
		public PeriodicDates.PeriodicDatesBuilder getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates() {
			PeriodicDates.PeriodicDatesBuilder result;
			if (periodicDates!=null) {
				result = periodicDates;
			}
			else {
				result = periodicDates = PeriodicDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDates")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates _adjustableDates) {
			this.adjustableDates = _adjustableDates == null ? null : _adjustableDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDateSequence")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDateSequence")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDateSequence(RelativeDateSequence _relativeDateSequence) {
			this.relativeDateSequence = _relativeDateSequence == null ? null : _relativeDateSequence.toBuilder();
			return this;
		}
		
		@RosettaAttribute("periodicDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicDates")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates _periodicDates) {
			this.periodicDates = _periodicDates == null ? null : _periodicDates.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDateSequence!=null && !relativeDateSequence.prune().hasData()) relativeDateSequence = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDateSequence()!=null && getRelativeDateSequence().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder o = (AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDateSequence(), o.getRelativeDateSequence(), this::setRelativeDateSequence);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDatesBuilder {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"periodicDates=" + this.periodicDates +
			'}';
		}
	}
}
