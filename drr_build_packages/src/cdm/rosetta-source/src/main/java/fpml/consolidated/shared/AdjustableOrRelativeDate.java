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
import fpml.consolidated.shared.meta.AdjustableOrRelativeDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 *
 */
@RosettaDataType(value="AdjustableOrRelativeDate", builder=AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableOrRelativeDate", model="fpml", builder=AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl.class, version="2.1.1")
public interface AdjustableOrRelativeDate extends RosettaModelObject {

	AdjustableOrRelativeDateMeta metaData = new AdjustableOrRelativeDateMeta();

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
	 * Provision A date that is subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date that is subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 */
	AdjustableDate getAdjustableDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A date specified as an offset to another date (the anchor date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date specified as an offset to another date (the anchor date).
	 *
	 */
	RelativeDateOffset getRelativeDate();

	/*********************** Build Methods  ***********************/
	AdjustableOrRelativeDate build();
	
	AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder();
	
	static AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder() {
		return new AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrRelativeDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableOrRelativeDate> getType() {
		return AdjustableOrRelativeDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrRelativeDateBuilder extends AdjustableOrRelativeDate, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setId(String id);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate adjustableDate);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
		}
		

		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrRelativeDate  ***********************/
	class AdjustableOrRelativeDateImpl implements AdjustableOrRelativeDate {
		private final String id;
		private final AdjustableDate adjustableDate;
		private final RelativeDateOffset relativeDate;
		
		protected AdjustableOrRelativeDateImpl(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			this.id = builder.getId();
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDate {" +
				"id=" + this.id + ", " +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrRelativeDate  ***********************/
	class AdjustableOrRelativeDateBuilderImpl implements AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder {
	
		protected String id;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		
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
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDate")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate _adjustableDate) {
			this.adjustableDate = _adjustableDate == null ? null : _adjustableDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDate")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(RelativeDateOffset _relativeDate) {
			this.relativeDate = _relativeDate == null ? null : _relativeDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return new AdjustableOrRelativeDate.AdjustableOrRelativeDateImpl(this);
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder o = (AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDateBuilder {" +
				"id=" + this.id + ", " +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
}
