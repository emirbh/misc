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
import fpml.consolidated.shared.meta.AdjustableRelativeOrPeriodicDates2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments, or as relative to some other series of (anchor) dates, or as a set of factors to specify periodic occurences.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments, or as relative to some other series of (anchor) dates, or as a set of factors to specify periodic occurences.
 *
 */
@RosettaDataType(value="AdjustableRelativeOrPeriodicDates2", builder=AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableRelativeOrPeriodicDates2", model="fpml", builder=AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl.class, version="2.1.1")
public interface AdjustableRelativeOrPeriodicDates2 extends RosettaModelObject {

	AdjustableRelativeOrPeriodicDates2Meta metaData = new AdjustableRelativeOrPeriodicDates2Meta();

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
	 * Provision A series of dates specified as some offset to another series of dates (the anchor dates).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A series of dates specified as some offset to another series of dates (the anchor dates).
	 *
	 */
	RelativeDates getRelativeDates();
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
	AdjustableRelativeOrPeriodicDates2 build();
	
	AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder();
	
	static AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder() {
		return new AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableRelativeOrPeriodicDates2> getType() {
		return AdjustableRelativeOrPeriodicDates2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.class, getRelativeDates());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableRelativeOrPeriodicDates2Builder extends AdjustableRelativeOrPeriodicDates2, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates();
		@Override
		RelativeDates.RelativeDatesBuilder getRelativeDates();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		@Override
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setId(String id);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setRelativeDates(RelativeDates relativeDates);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setPeriodicDates(PeriodicDates periodicDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.RelativeDatesBuilder.class, getRelativeDates());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
		}
		

		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder prune();
	}

	/*********************** Immutable Implementation of AdjustableRelativeOrPeriodicDates2  ***********************/
	class AdjustableRelativeOrPeriodicDates2Impl implements AdjustableRelativeOrPeriodicDates2 {
		private final String id;
		private final AdjustableDates adjustableDates;
		private final RelativeDates relativeDates;
		private final PeriodicDates periodicDates;
		
		protected AdjustableRelativeOrPeriodicDates2Impl(AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder) {
			this.id = builder.getId();
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDates = ofNullable(builder.getRelativeDates()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("relativeDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDates")
		public RelativeDates getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicDates")
		public PeriodicDates getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2 build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDates()).ifPresent(builder::setRelativeDates);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates2 {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableRelativeOrPeriodicDates2  ***********************/
	class AdjustableRelativeOrPeriodicDates2BuilderImpl implements AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder {
	
		protected String id;
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDates.RelativeDatesBuilder relativeDates;
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
		@RosettaAttribute("relativeDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDates")
		public RelativeDates.RelativeDatesBuilder getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates() {
			RelativeDates.RelativeDatesBuilder result;
			if (relativeDates!=null) {
				result = relativeDates;
			}
			else {
				result = relativeDates = RelativeDates.builder();
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
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDates")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setAdjustableDates(AdjustableDates _adjustableDates) {
			this.adjustableDates = _adjustableDates == null ? null : _adjustableDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDates")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setRelativeDates(RelativeDates _relativeDates) {
			this.relativeDates = _relativeDates == null ? null : _relativeDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("periodicDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicDates")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setPeriodicDates(PeriodicDates _periodicDates) {
			this.periodicDates = _periodicDates == null ? null : _periodicDates.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2 build() {
			return new AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Impl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDates!=null && !relativeDates.prune().hasData()) relativeDates = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDates()!=null && getRelativeDates().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder o = (AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDates(), o.getRelativeDates(), this::setRelativeDates);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates2Builder {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates +
			'}';
		}
	}
}
