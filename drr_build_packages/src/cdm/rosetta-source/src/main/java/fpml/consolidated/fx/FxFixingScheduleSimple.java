package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.meta.FxFixingScheduleSimpleMeta;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes the FX fixing schedule, a single continuous observation period which follows the applicable business day schedule for the quoted rate source.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the FX fixing schedule, a single continuous observation period which follows the applicable business day schedule for the quoted rate source.
 *
 */
@RosettaDataType(value="FxFixingScheduleSimple", builder=FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFixingScheduleSimple", model="fpml", builder=FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl.class, version="2.1.1")
public interface FxFixingScheduleSimple extends RosettaModelObject {

	FxFixingScheduleSimpleMeta metaData = new FxFixingScheduleSimpleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start of the period over which observations are made to determine whether a trigger has occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start of the period over which observations are made to determine whether a trigger has occurred.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The end of the period over which observations are made to determine whether a trigger event has occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The end of the period over which observations are made to determine whether a trigger event has occurred.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the schedule follows the business or calendar days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the schedule follows the business or calendar days.
	 *
	 */
	DayTypeEnum getDayType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 */
	BusinessCentersReference getBusinessCentersReference();
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
	BusinessCenters getBusinessCenters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An explicit list of dates in the schedule. For documentation purpose only.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An explicit list of dates in the schedule. For documentation purpose only.
	 *
	 */
	List<ZonedDateTime> getFixingDate();

	/*********************** Build Methods  ***********************/
	FxFixingScheduleSimple build();
	
	FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder();
	
	static FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder() {
		return new FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingScheduleSimple> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFixingScheduleSimple> getType() {
		return FxFixingScheduleSimple.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleSimpleBuilder extends FxFixingScheduleSimple, RosettaModelObjectBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setStartDate(ZonedDateTime startDate);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setEndDate(ZonedDateTime endDate);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setDayType(DayTypeEnum dayType);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCenters(BusinessCenters businessCenters);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(ZonedDateTime fixingDate);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(ZonedDateTime fixingDate, int idx);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(List<ZonedDateTime> fixingDate);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFixingDate(List<ZonedDateTime> fixingDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		}
		

		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingScheduleSimple  ***********************/
	class FxFixingScheduleSimpleImpl implements FxFixingScheduleSimple {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final DayTypeEnum dayType;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		private final List<ZonedDateTime> fixingDate;
		
		protected FxFixingScheduleSimpleImpl(FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.dayType = builder.getDayType();
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public FxFixingScheduleSimple build() {
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder() {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimple _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimple {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingScheduleSimple  ***********************/
	class FxFixingScheduleSimpleBuilderImpl implements FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected DayTypeEnum dayType;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected List<ZonedDateTime> fixingDate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(ZonedDateTime _fixingDate) {
			if (_fixingDate != null) {
				this.fixingDate.add(_fixingDate);
			}
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(ZonedDateTime _fixingDate, int idx) {
			getIndex(this.fixingDate, idx, () -> _fixingDate);
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates != null) {
				for (final ZonedDateTime toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates == null) {
				this.fixingDate = new ArrayList<>();
			} else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple build() {
			return new FxFixingScheduleSimple.FxFixingScheduleSimpleImpl(this);
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder prune() {
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getDayType()!=null) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder o = (FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<ZonedDateTime>) this::addFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimple _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimpleBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}
}
