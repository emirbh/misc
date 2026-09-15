package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAdjustedDateAndDateAdjustmentsMeta;
import fpml.consolidated.shared.BusinessDayAdjustments;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the expiry/observation schedule of the target.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the expiry/observation schedule of the target.
 *
 */
@RosettaDataType(value="FxAdjustedDateAndDateAdjustments", builder=FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAdjustedDateAndDateAdjustments", model="fpml", builder=FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl.class, version="2.1.1")
public interface FxAdjustedDateAndDateAdjustments extends RosettaModelObject {

	FxAdjustedDateAndDateAdjustmentsMeta metaData = new FxAdjustedDateAndDateAdjustmentsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date adjustments applied to the adjusted dates including the business day convention and the business centers. The date adjustments are as specified in the definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date adjustments applied to the adjusted dates including the business day convention and the business centers. The date adjustments are as specified in the definitions.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 *
	 */
	ZonedDateTime getAdjustedDate();

	/*********************** Build Methods  ***********************/
	FxAdjustedDateAndDateAdjustments build();
	
	FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder toBuilder();
	
	static FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder builder() {
		return new FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAdjustedDateAndDateAdjustments> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAdjustedDateAndDateAdjustments> getType() {
		return FxAdjustedDateAndDateAdjustments.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAdjustedDateAndDateAdjustmentsBuilder extends FxAdjustedDateAndDateAdjustments, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder setAdjustedDate(ZonedDateTime adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
		}
		

		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder prune();
	}

	/*********************** Immutable Implementation of FxAdjustedDateAndDateAdjustments  ***********************/
	class FxAdjustedDateAndDateAdjustmentsImpl implements FxAdjustedDateAndDateAdjustments {
		private final BusinessDayAdjustments dateAdjustments;
		private final ZonedDateTime adjustedDate;
		
		protected FxAdjustedDateAndDateAdjustmentsImpl(FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder builder) {
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = builder.getAdjustedDate();
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
		@Required
		@RuneAttribute("adjustedDate")
		public ZonedDateTime getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments build() {
			return this;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder toBuilder() {
			FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder builder) {
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAdjustedDateAndDateAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAdjustedDateAndDateAdjustments {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAdjustedDateAndDateAdjustments  ***********************/
	class FxAdjustedDateAndDateAdjustmentsBuilderImpl implements FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected ZonedDateTime adjustedDate;
		
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
		@Required
		@RuneAttribute("adjustedDate")
		public ZonedDateTime getAdjustedDate() {
			return adjustedDate;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustedDate")
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder setAdjustedDate(ZonedDateTime _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments build() {
			return new FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsImpl(this);
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder o = (FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAdjustedDateAndDateAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAdjustedDateAndDateAdjustmentsBuilder {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
