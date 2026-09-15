package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanLegalActionStatusMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe the overall loan legal action status.
 *
 */
@RosettaDataType(value="LoanLegalActionStatus", builder=LoanLegalActionStatus.LoanLegalActionStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatus", model="fpml", builder=LoanLegalActionStatus.LoanLegalActionStatusBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatus extends RosettaModelObject {

	LoanLegalActionStatusMeta metaData = new LoanLegalActionStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision The effective date of the loan legal action status details.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanLegalActionReference getLegalActionReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Loan legal action status as of the effective date, based on a scheme.
	 *
	 */
	LoanLegalActionStatusType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A free form field to provide additional description of the legal action status.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	LoanLegalActionStatus build();
	
	LoanLegalActionStatus.LoanLegalActionStatusBuilder toBuilder();
	
	static LoanLegalActionStatus.LoanLegalActionStatusBuilder builder() {
		return new LoanLegalActionStatus.LoanLegalActionStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatus> getType() {
		return LoanLegalActionStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("type"), processor, LoanLegalActionStatusType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatusBuilder extends LoanLegalActionStatus, RosettaModelObjectBuilder {
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference();
		@Override
		LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference();
		LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder getOrCreateType();
		@Override
		LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder _getType();
		LoanLegalActionStatus.LoanLegalActionStatusBuilder setId(String id);
		LoanLegalActionStatus.LoanLegalActionStatusBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		LoanLegalActionStatus.LoanLegalActionStatusBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		LoanLegalActionStatus.LoanLegalActionStatusBuilder setType(LoanLegalActionStatusType type);
		LoanLegalActionStatus.LoanLegalActionStatusBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("type"), processor, LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		LoanLegalActionStatus.LoanLegalActionStatusBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatus  ***********************/
	class LoanLegalActionStatusImpl implements LoanLegalActionStatus {
		private final String id;
		private final ZonedDateTime effectiveDate;
		private final LoanLegalActionReference legalActionReference;
		private final LoanLegalActionStatusType type;
		private final String description;
		
		protected LoanLegalActionStatusImpl(LoanLegalActionStatus.LoanLegalActionStatusBuilder builder) {
			this.id = builder.getId();
			this.effectiveDate = builder.getEffectiveDate();
			this.legalActionReference = ofNullable(builder.getLegalActionReference()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanLegalActionStatusType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public LoanLegalActionStatus build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder toBuilder() {
			LoanLegalActionStatus.LoanLegalActionStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatus.LoanLegalActionStatusBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getLegalActionReference()).ifPresent(builder::setLegalActionReference);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatus _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatus {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatus  ***********************/
	class LoanLegalActionStatusBuilderImpl implements LoanLegalActionStatus.LoanLegalActionStatusBuilder {
	
		protected String id;
		protected ZonedDateTime effectiveDate;
		protected LoanLegalActionReference.LoanLegalActionReferenceBuilder legalActionReference;
		protected LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder type;
		protected String description;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionReference")
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getLegalActionReference() {
			return legalActionReference;
		}
		
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder getOrCreateLegalActionReference() {
			LoanLegalActionReference.LoanLegalActionReferenceBuilder result;
			if (legalActionReference!=null) {
				result = legalActionReference;
			}
			else {
				result = legalActionReference = LoanLegalActionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder getOrCreateType() {
			LoanLegalActionStatusType.LoanLegalActionStatusTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanLegalActionStatusType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionReference")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder setType(LoanLegalActionStatusType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public LoanLegalActionStatus build() {
			return new LoanLegalActionStatus.LoanLegalActionStatusImpl(this);
		}
		
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder prune() {
			if (legalActionReference!=null && !legalActionReference.prune().hasData()) legalActionReference = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getLegalActionReference()!=null && getLegalActionReference().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatus.LoanLegalActionStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionStatus.LoanLegalActionStatusBuilder o = (LoanLegalActionStatus.LoanLegalActionStatusBuilder) other;
			
			merger.mergeRosetta(getLegalActionReference(), o.getLegalActionReference(), this::setLegalActionReference);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatus _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(legalActionReference, _that.getLegalActionReference())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (legalActionReference != null ? legalActionReference.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatusBuilder {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"legalActionReference=" + this.legalActionReference + ", " +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}';
		}
	}
}
