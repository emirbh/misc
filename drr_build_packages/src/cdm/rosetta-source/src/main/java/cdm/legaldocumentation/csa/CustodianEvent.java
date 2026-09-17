package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CustodianEventMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Custodian Event.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(iii)" * name " Custodian Event"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(m)(ii)" * name "Collateral Manager Event"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(iii)" * name "Custodian Event"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CustodianEvent", builder=CustodianEvent.CustodianEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianEvent", model="cdm", builder=CustodianEvent.CustodianEventBuilderImpl.class, version="6.23.0")
public interface CustodianEvent extends RosettaModelObject {

	CustodianEventMeta metaData = new CustodianEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification as to whether the Custodian Event (English Law &amp; New York Law ISDA CSA) or the Collateral Manager Event (Japanese Law ISDA CSA) is applicable.
	 */
	Boolean getIsApplicable();
	/**
	 * The qualification of the Custodian Event (English Law &amp; New York Law ISDA CSA) or Collateral Manager Event (Japanese Law ISDA CSA) End Date.
	 */
	CustodianEventEndDate getEndDate();

	/*********************** Build Methods  ***********************/
	CustodianEvent build();
	
	CustodianEvent.CustodianEventBuilder toBuilder();
	
	static CustodianEvent.CustodianEventBuilder builder() {
		return new CustodianEvent.CustodianEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianEvent> getType() {
		return CustodianEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("endDate"), processor, CustodianEventEndDate.class, getEndDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianEventBuilder extends CustodianEvent, RosettaModelObjectBuilder {
		CustodianEventEndDate.CustodianEventEndDateBuilder getOrCreateEndDate();
		@Override
		CustodianEventEndDate.CustodianEventEndDateBuilder getEndDate();
		CustodianEvent.CustodianEventBuilder setIsApplicable(Boolean isApplicable);
		CustodianEvent.CustodianEventBuilder setEndDate(CustodianEventEndDate endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("endDate"), processor, CustodianEventEndDate.CustodianEventEndDateBuilder.class, getEndDate());
		}
		

		CustodianEvent.CustodianEventBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianEvent  ***********************/
	class CustodianEventImpl implements CustodianEvent {
		private final Boolean isApplicable;
		private final CustodianEventEndDate endDate;
		
		protected CustodianEventImpl(CustodianEvent.CustodianEventBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.endDate = ofNullable(builder.getEndDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public CustodianEventEndDate getEndDate() {
			return endDate;
		}
		
		@Override
		public CustodianEvent build() {
			return this;
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder toBuilder() {
			CustodianEvent.CustodianEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianEvent.CustodianEventBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEvent _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEvent {" +
				"isApplicable=" + this.isApplicable + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianEvent  ***********************/
	class CustodianEventBuilderImpl implements CustodianEvent.CustodianEventBuilder {
	
		protected Boolean isApplicable;
		protected CustodianEventEndDate.CustodianEventEndDateBuilder endDate;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public CustodianEventEndDate.CustodianEventEndDateBuilder getEndDate() {
			return endDate;
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder getOrCreateEndDate() {
			CustodianEventEndDate.CustodianEventEndDateBuilder result;
			if (endDate!=null) {
				result = endDate;
			}
			else {
				result = endDate = CustodianEventEndDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public CustodianEvent.CustodianEventBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public CustodianEvent.CustodianEventBuilder setEndDate(CustodianEventEndDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@Override
		public CustodianEvent build() {
			return new CustodianEvent.CustodianEventImpl(this);
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEvent.CustodianEventBuilder prune() {
			if (endDate!=null && !endDate.prune().hasData()) endDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getEndDate()!=null && getEndDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEvent.CustodianEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianEvent.CustodianEventBuilder o = (CustodianEvent.CustodianEventBuilder) other;
			
			merger.mergeRosetta(getEndDate(), o.getEndDate(), this::setEndDate);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEvent _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
