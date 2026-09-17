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
import fpml.consolidated.shared.meta.AdjustableOrRelativeDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
 *
 */
@RosettaDataType(value="AdjustableOrRelativeDates", builder=AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableOrRelativeDates", model="fpml", builder=AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilderImpl.class, version="2.1.1")
public interface AdjustableOrRelativeDates extends RosettaModelObject {

	AdjustableOrRelativeDatesMeta metaData = new AdjustableOrRelativeDatesMeta();

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

	/*********************** Build Methods  ***********************/
	AdjustableOrRelativeDates build();
	
	AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder toBuilder();
	
	static AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder builder() {
		return new AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrRelativeDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableOrRelativeDates> getType() {
		return AdjustableOrRelativeDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.class, getRelativeDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrRelativeDatesBuilder extends AdjustableOrRelativeDates, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates();
		@Override
		RelativeDates.RelativeDatesBuilder getRelativeDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setId(String id);
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setRelativeDates(RelativeDates relativeDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.RelativeDatesBuilder.class, getRelativeDates());
		}
		

		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrRelativeDates  ***********************/
	class AdjustableOrRelativeDatesImpl implements AdjustableOrRelativeDates {
		private final String id;
		private final AdjustableDates adjustableDates;
		private final RelativeDates relativeDates;
		
		protected AdjustableOrRelativeDatesImpl(AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder builder) {
			this.id = builder.getId();
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDates = ofNullable(builder.getRelativeDates()).map(f->f.build()).orElse(null);
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
		public AdjustableOrRelativeDates build() {
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder toBuilder() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDates()).ifPresent(builder::setRelativeDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDates {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrRelativeDates  ***********************/
	class AdjustableOrRelativeDatesBuilderImpl implements AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder {
	
		protected String id;
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDates.RelativeDatesBuilder relativeDates;
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDates")
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setAdjustableDates(AdjustableDates _adjustableDates) {
			this.adjustableDates = _adjustableDates == null ? null : _adjustableDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDates")
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder setRelativeDates(RelativeDates _relativeDates) {
			this.relativeDates = _relativeDates == null ? null : _relativeDates.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDates build() {
			return new AdjustableOrRelativeDates.AdjustableOrRelativeDatesImpl(this);
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDates!=null && !relativeDates.prune().hasData()) relativeDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDates()!=null && getRelativeDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder o = (AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDates(), o.getRelativeDates(), this::setRelativeDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDatesBuilder {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates +
			'}';
		}
	}
}
