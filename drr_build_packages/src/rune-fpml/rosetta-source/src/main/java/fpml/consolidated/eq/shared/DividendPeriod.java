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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.eq.shared.meta.DividendPeriodMeta;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base class of all time bounded dividend period types.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base class of all time bounded dividend period types.
 *
 */
@RosettaDataType(value="DividendPeriod", builder=DividendPeriod.DividendPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendPeriod", model="fpml", builder=DividendPeriod.DividendPeriodBuilderImpl.class, version="2.1.1")
public interface DividendPeriod extends RosettaModelObject {

	DividendPeriodMeta metaData = new DividendPeriodMeta();

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
	 * Provision Unadjusted inclusive dividend period start date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unadjusted inclusive dividend period start date.
	 *
	 */
	IdentifiedDate getUnadjustedStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Unadjusted inclusive dividend period end date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unadjusted inclusive dividend period end date.
	 *
	 */
	IdentifiedDate getUnadjustedEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date adjustments for all unadjusted dates in this dividend period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date adjustments for all unadjusted dates in this dividend period.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the underlyer which is paying dividends. This should be used in all cases, and must be used where there are multiple underlying assets, to avoid any ambiguity about which asset the dividend period relates to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the underlyer which is paying dividends. This should be used in all cases, and must be used where there are multiple underlying assets, to avoid any ambiguity about which asset the dividend period relates to.
	 *
	 */
	AssetReference getUnderlyerReference();

	/*********************** Build Methods  ***********************/
	DividendPeriod build();
	
	DividendPeriod.DividendPeriodBuilder toBuilder();
	
	static DividendPeriod.DividendPeriodBuilder builder() {
		return new DividendPeriod.DividendPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPeriod> getType() {
		return DividendPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodBuilder extends DividendPeriod, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedStartDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedStartDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedEndDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedEndDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference();
		@Override
		AssetReference.AssetReferenceBuilder getUnderlyerReference();
		DividendPeriod.DividendPeriodBuilder setId(String id);
		DividendPeriod.DividendPeriodBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		DividendPeriod.DividendPeriodBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		DividendPeriod.DividendPeriodBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		DividendPeriod.DividendPeriodBuilder setUnderlyerReference(AssetReference underlyerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
		}
		

		DividendPeriod.DividendPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriod  ***********************/
	class DividendPeriodImpl implements DividendPeriod {
		private final String id;
		private final IdentifiedDate unadjustedStartDate;
		private final IdentifiedDate unadjustedEndDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final AssetReference underlyerReference;
		
		protected DividendPeriodImpl(DividendPeriod.DividendPeriodBuilder builder) {
			this.id = builder.getId();
			this.unadjustedStartDate = ofNullable(builder.getUnadjustedStartDate()).map(f->f.build()).orElse(null);
			this.unadjustedEndDate = ofNullable(builder.getUnadjustedEndDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedStartDate")
		public IdentifiedDate getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedEndDate")
		public IdentifiedDate getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public AssetReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public DividendPeriod build() {
			return this;
		}
		
		@Override
		public DividendPeriod.DividendPeriodBuilder toBuilder() {
			DividendPeriod.DividendPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriod.DividendPeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUnadjustedStartDate()).ifPresent(builder::setUnadjustedStartDate);
			ofNullable(getUnadjustedEndDate()).ifPresent(builder::setUnadjustedEndDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriod {" +
				"id=" + this.id + ", " +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPeriod  ***********************/
	class DividendPeriodBuilderImpl implements DividendPeriod.DividendPeriodBuilder {
	
		protected String id;
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedStartDate;
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedEndDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected AssetReference.AssetReferenceBuilder underlyerReference;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedStartDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedStartDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedStartDate!=null) {
				result = unadjustedStartDate;
			}
			else {
				result = unadjustedStartDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedEndDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedEndDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedEndDate!=null) {
				result = unadjustedEndDate;
			}
			else {
				result = unadjustedEndDate = IdentifiedDate.builder();
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
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public AssetReference.AssetReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DividendPeriod.DividendPeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedStartDate")
		@Override
		public DividendPeriod.DividendPeriodBuilder setUnadjustedStartDate(IdentifiedDate _unadjustedStartDate) {
			this.unadjustedStartDate = _unadjustedStartDate == null ? null : _unadjustedStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedEndDate")
		@Override
		public DividendPeriod.DividendPeriodBuilder setUnadjustedEndDate(IdentifiedDate _unadjustedEndDate) {
			this.unadjustedEndDate = _unadjustedEndDate == null ? null : _unadjustedEndDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public DividendPeriod.DividendPeriodBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public DividendPeriod.DividendPeriodBuilder setUnderlyerReference(AssetReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@Override
		public DividendPeriod build() {
			return new DividendPeriod.DividendPeriodImpl(this);
		}
		
		@Override
		public DividendPeriod.DividendPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriod.DividendPeriodBuilder prune() {
			if (unadjustedStartDate!=null && !unadjustedStartDate.prune().hasData()) unadjustedStartDate = null;
			if (unadjustedEndDate!=null && !unadjustedEndDate.prune().hasData()) unadjustedEndDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUnadjustedStartDate()!=null && getUnadjustedStartDate().hasData()) return true;
			if (getUnadjustedEndDate()!=null && getUnadjustedEndDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriod.DividendPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPeriod.DividendPeriodBuilder o = (DividendPeriod.DividendPeriodBuilder) other;
			
			merger.mergeRosetta(getUnadjustedStartDate(), o.getUnadjustedStartDate(), this::setUnadjustedStartDate);
			merger.mergeRosetta(getUnadjustedEndDate(), o.getUnadjustedEndDate(), this::setUnadjustedEndDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodBuilder {" +
				"id=" + this.id + ", " +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}';
		}
	}
}
