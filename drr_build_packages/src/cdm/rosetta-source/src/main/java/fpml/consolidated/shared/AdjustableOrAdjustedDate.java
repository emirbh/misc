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
import fpml.consolidated.shared.meta.AdjustableOrAdjustedDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 *
 */
@RosettaDataType(value="AdjustableOrAdjustedDate", builder=AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableOrAdjustedDate", model="fpml", builder=AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl.class, version="2.1.1")
public interface AdjustableOrAdjustedDate extends RosettaModelObject {

	AdjustableOrAdjustedDateMeta metaData = new AdjustableOrAdjustedDateMeta();

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
	 * Provision A date subject to adjustment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date subject to adjustment.
	 *
	 */
	IdentifiedDate getUnadjustedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 */
	IdentifiedDate getAdjustedDate();

	/*********************** Build Methods  ***********************/
	AdjustableOrAdjustedDate build();
	
	AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder();
	
	static AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder() {
		return new AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrAdjustedDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableOrAdjustedDate> getType() {
		return AdjustableOrAdjustedDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrAdjustedDateBuilder extends AdjustableOrAdjustedDate, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setId(String id);
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setUnadjustedDate(IdentifiedDate unadjustedDate);
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustedDate(IdentifiedDate adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
		}
		

		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrAdjustedDate  ***********************/
	class AdjustableOrAdjustedDateImpl implements AdjustableOrAdjustedDate {
		private final String id;
		private final IdentifiedDate unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final IdentifiedDate adjustedDate;
		
		protected AdjustableOrAdjustedDateImpl(AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder) {
			this.id = builder.getId();
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public IdentifiedDate getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public IdentifiedDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedDate {" +
				"id=" + this.id + ", " +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrAdjustedDate  ***********************/
	class AdjustableOrAdjustedDateBuilderImpl implements AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder {
	
		protected String id;
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedDate!=null) {
				result = unadjustedDate;
			}
			else {
				result = unadjustedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedDate")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setUnadjustedDate(IdentifiedDate _unadjustedDate) {
			this.unadjustedDate = _unadjustedDate == null ? null : _unadjustedDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedDate")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustedDate(IdentifiedDate _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedDate build() {
			return new AdjustableOrAdjustedDate.AdjustableOrAdjustedDateImpl(this);
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder prune() {
			if (unadjustedDate!=null && !unadjustedDate.prune().hasData()) unadjustedDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUnadjustedDate()!=null && getUnadjustedDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder o = (AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedDateBuilder {" +
				"id=" + this.id + ", " +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
