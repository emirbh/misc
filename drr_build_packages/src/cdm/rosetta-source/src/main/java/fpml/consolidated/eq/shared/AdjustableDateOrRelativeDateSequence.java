package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.AdjustableDateOrRelativeDateSequenceMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing a date defined as subject to adjustment or defined in reference to another date through one or several date offsets.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a date defined as subject to adjustment or defined in reference to another date through one or several date offsets.
 *
 */
@RosettaDataType(value="AdjustableDateOrRelativeDateSequence", builder=AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableDateOrRelativeDateSequence", model="fpml", builder=AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl.class, version="2.1.1")
public interface AdjustableDateOrRelativeDateSequence extends RosettaModelObject {

	AdjustableDateOrRelativeDateSequenceMeta metaData = new AdjustableDateOrRelativeDateSequenceMeta();

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
	 * Provision A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 */
	AdjustableDate getAdjustableDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A date specified in relation to some other date defined in the document (the anchor date), where there is the opportunity to specify a combination of offset rules. This component will typically be used for defining the valuation date in relation to the payment date, as both the currency and the exchange holiday calendars need to be considered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date specified in relation to some other date defined in the document (the anchor date), where there is the opportunity to specify a combination of offset rules. This component will typically be used for defining the valuation date in relation to the payment date, as both the currency and the exchange holiday calendars need to be considered.
	 *
	 */
	RelativeDateSequence getRelativeDateSequence();

	/*********************** Build Methods  ***********************/
	AdjustableDateOrRelativeDateSequence build();
	
	AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder();
	
	static AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder() {
		return new AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDateOrRelativeDateSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableDateOrRelativeDateSequence> getType() {
		return AdjustableDateOrRelativeDateSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.class, getRelativeDateSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDateOrRelativeDateSequenceBuilder extends AdjustableDateOrRelativeDateSequence, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence();
		@Override
		RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence();
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setId(String id);
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setAdjustableDate(AdjustableDate adjustableDate);
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.RelativeDateSequenceBuilder.class, getRelativeDateSequence());
		}
		

		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDateOrRelativeDateSequence  ***********************/
	class AdjustableDateOrRelativeDateSequenceImpl implements AdjustableDateOrRelativeDateSequence {
		private final String id;
		private final AdjustableDate adjustableDate;
		private final RelativeDateSequence relativeDateSequence;
		
		protected AdjustableDateOrRelativeDateSequenceImpl(AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder) {
			this.id = builder.getId();
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.relativeDateSequence = ofNullable(builder.getRelativeDateSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		@RosettaAttribute("relativeDateSequence")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDateSequence")
		public RelativeDateSequence getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence build() {
			return this;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder() {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getRelativeDateSequence()).ifPresent(builder::setRelativeDateSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateOrRelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateOrRelativeDateSequence {" +
				"id=" + this.id + ", " +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDateSequence=" + this.relativeDateSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDateOrRelativeDateSequence  ***********************/
	class AdjustableDateOrRelativeDateSequenceBuilderImpl implements AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder {
	
		protected String id;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected RelativeDateSequence.RelativeDateSequenceBuilder relativeDateSequence;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDate")
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDate")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setAdjustableDate(AdjustableDate _adjustableDate) {
			this.adjustableDate = _adjustableDate == null ? null : _adjustableDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDateSequence")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDateSequence")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setRelativeDateSequence(RelativeDateSequence _relativeDateSequence) {
			this.relativeDateSequence = _relativeDateSequence == null ? null : _relativeDateSequence.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence build() {
			return new AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceImpl(this);
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (relativeDateSequence!=null && !relativeDateSequence.prune().hasData()) relativeDateSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getRelativeDateSequence()!=null && getRelativeDateSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder o = (AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getRelativeDateSequence(), o.getRelativeDateSequence(), this::setRelativeDateSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateOrRelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateOrRelativeDateSequenceBuilder {" +
				"id=" + this.id + ", " +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDateSequence=" + this.relativeDateSequence +
			'}';
		}
	}
}
