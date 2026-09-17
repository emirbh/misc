package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxFlexibleForwardExecutionPeriodMeta;
import fpml.consolidated.shared.BusinessCenters;
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
@RosettaDataType(value="FxFlexibleForwardExecutionPeriod", builder=FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFlexibleForwardExecutionPeriod", model="fpml", builder=FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl.class, version="2.1.1")
public interface FxFlexibleForwardExecutionPeriod extends RosettaModelObject {

	FxFlexibleForwardExecutionPeriodMeta metaData = new FxFlexibleForwardExecutionPeriodMeta();

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
	 * Provision Start date of the execution period/window.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Start date of the execution period/window.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Expiry (maturity) date of the execution period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expiry (maturity) date of the execution period.
	 *
	 */
	ZonedDateTime getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Business centers for determination of execution period business days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Business centers for determination of execution period business days.
	 *
	 */
	BusinessCenters getBusinessCenters();

	/*********************** Build Methods  ***********************/
	FxFlexibleForwardExecutionPeriod build();
	
	FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder();
	
	static FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder() {
		return new FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForwardExecutionPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFlexibleForwardExecutionPeriod> getType() {
		return FxFlexibleForwardExecutionPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardExecutionPeriodBuilder extends FxFlexibleForwardExecutionPeriod, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setId(String id);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setStartDate(ZonedDateTime startDate);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setExpiryDate(ZonedDateTime expiryDate);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForwardExecutionPeriod  ***********************/
	class FxFlexibleForwardExecutionPeriodImpl implements FxFlexibleForwardExecutionPeriod {
		private final String id;
		private final ZonedDateTime startDate;
		private final ZonedDateTime expiryDate;
		private final BusinessCenters businessCenters;
		
		protected FxFlexibleForwardExecutionPeriodImpl(FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder) {
			this.id = builder.getId();
			this.startDate = builder.getStartDate();
			this.expiryDate = builder.getExpiryDate();
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod build() {
			return this;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder() {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardExecutionPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardExecutionPeriod {" +
				"id=" + this.id + ", " +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFlexibleForwardExecutionPeriod  ***********************/
	class FxFlexibleForwardExecutionPeriodBuilderImpl implements FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder {
	
		protected String id;
		protected ZonedDateTime startDate;
		protected ZonedDateTime expiryDate;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod build() {
			return new FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodImpl(this);
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder prune() {
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getStartDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder o = (FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardExecutionPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardExecutionPeriodBuilder {" +
				"id=" + this.id + ", " +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}
}
