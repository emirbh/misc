package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.StubPeriodTypeEnum;
import fpml.consolidated.ird.meta.CalculationPeriodDatesMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.RelativeDateOffset;
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
 * Provision A type defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation perod schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStateDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation perod schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStateDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 *
 */
@RosettaDataType(value="CalculationPeriodDates", builder=CalculationPeriodDates.CalculationPeriodDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationPeriodDates", model="fpml", builder=CalculationPeriodDates.CalculationPeriodDatesBuilderImpl.class, version="2.1.1")
public interface CalculationPeriodDates extends RosettaModelObject {

	CalculationPeriodDatesMeta metaData = new CalculationPeriodDatesMeta();

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
	 * Provision The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 */
	AdjustableDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the effective date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the effective date.
	 *
	 */
	AdjustedRelativeDateOffset getRelativeEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 */
	AdjustableDate getTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The term/maturity of the swap, express as a tenor (typically in years).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The term/maturity of the swap, express as a tenor (typically in years).
	 *
	 */
	RelativeDateOffset getRelativeTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The business day convention to apply to each calculation period end date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business day convention to apply to each calculation period end date if it would otherwise fall on a day that is not a business day in the specified financial business centers.
	 *
	 */
	BusinessDayAdjustments getCalculationPeriodDatesAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start date of the calculation period if the date falls before the effective date. It must only be specified if it is not equal to the effective date. This date may be subject to adjustment in accordance with a business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the calculation period if the date falls before the effective date. It must only be specified if it is not equal to the effective date. This date may be subject to adjustment in accordance with a business day convention.
	 *
	 */
	AdjustableDate getFirstPeriodStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	ZonedDateTime getFirstRegularPeriodStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	ZonedDateTime getFirstCompoundingPeriodEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	ZonedDateTime getLastRegularPeriodEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
	 *
	 */
	StubPeriodTypeEnum getStubPeriodType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 *
	 */
	CalculationPeriodFrequency getCalculationPeriodFrequency();

	/*********************** Build Methods  ***********************/
	CalculationPeriodDates build();
	
	CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder();
	
	static CalculationPeriodDates.CalculationPeriodDatesBuilder builder() {
		return new CalculationPeriodDates.CalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationPeriodDates> getType() {
		return CalculationPeriodDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("relativeEffectiveDate"), processor, AdjustedRelativeDateOffset.class, getRelativeEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate.class, getTerminationDate());
		processRosetta(path.newSubPath("relativeTerminationDate"), processor, RelativeDateOffset.class, getRelativeTerminationDate());
		processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.class, getCalculationPeriodDatesAdjustments());
		processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableDate.class, getFirstPeriodStartDate());
		processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), ZonedDateTime.class, getFirstRegularPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), ZonedDateTime.class, getFirstCompoundingPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), ZonedDateTime.class, getLastRegularPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
		processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.class, getCalculationPeriodFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodDatesBuilder extends CalculationPeriodDates, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getEffectiveDate();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeEffectiveDate();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeEffectiveDate();
		AdjustableDate.AdjustableDateBuilder getOrCreateTerminationDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getTerminationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeTerminationDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeTerminationDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments();
		AdjustableDate.AdjustableDateBuilder getOrCreateFirstPeriodStartDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getFirstPeriodStartDate();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency();
		@Override
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency();
		CalculationPeriodDates.CalculationPeriodDatesBuilder setId(String id);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableDate effectiveDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeEffectiveDate(AdjustedRelativeDateOffset relativeEffectiveDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableDate terminationDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeTerminationDate(RelativeDateOffset relativeTerminationDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableDate firstPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(ZonedDateTime firstRegularPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(ZonedDateTime firstCompoundingPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(ZonedDateTime lastRegularPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum stubPeriodType);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("relativeEffectiveDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getRelativeEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("relativeTerminationDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeTerminationDate());
			processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getCalculationPeriodDatesAdjustments());
			processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getFirstPeriodStartDate());
			processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), ZonedDateTime.class, getFirstRegularPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), ZonedDateTime.class, getFirstCompoundingPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), ZonedDateTime.class, getLastRegularPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
			processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getCalculationPeriodFrequency());
		}
		

		CalculationPeriodDates.CalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodDates  ***********************/
	class CalculationPeriodDatesImpl implements CalculationPeriodDates {
		private final String id;
		private final AdjustableDate effectiveDate;
		private final AdjustedRelativeDateOffset relativeEffectiveDate;
		private final AdjustableDate terminationDate;
		private final RelativeDateOffset relativeTerminationDate;
		private final BusinessDayAdjustments calculationPeriodDatesAdjustments;
		private final AdjustableDate firstPeriodStartDate;
		private final ZonedDateTime firstRegularPeriodStartDate;
		private final ZonedDateTime firstCompoundingPeriodEndDate;
		private final ZonedDateTime lastRegularPeriodEndDate;
		private final StubPeriodTypeEnum stubPeriodType;
		private final CalculationPeriodFrequency calculationPeriodFrequency;
		
		protected CalculationPeriodDatesImpl(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			this.id = builder.getId();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.relativeEffectiveDate = ofNullable(builder.getRelativeEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.relativeTerminationDate = ofNullable(builder.getRelativeTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodDatesAdjustments = ofNullable(builder.getCalculationPeriodDatesAdjustments()).map(f->f.build()).orElse(null);
			this.firstPeriodStartDate = ofNullable(builder.getFirstPeriodStartDate()).map(f->f.build()).orElse(null);
			this.firstRegularPeriodStartDate = builder.getFirstRegularPeriodStartDate();
			this.firstCompoundingPeriodEndDate = builder.getFirstCompoundingPeriodEndDate();
			this.lastRegularPeriodEndDate = builder.getLastRegularPeriodEndDate();
			this.stubPeriodType = builder.getStubPeriodType();
			this.calculationPeriodFrequency = ofNullable(builder.getCalculationPeriodFrequency()).map(f->f.build()).orElse(null);
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
		public AdjustableDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("relativeEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeEffectiveDate")
		public AdjustedRelativeDateOffset getRelativeEffectiveDate() {
			return relativeEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("relativeTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeTerminationDate")
		public RelativeDateOffset getRelativeTerminationDate() {
			return relativeTerminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPeriodStartDate")
		public AdjustableDate getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstRegularPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstRegularPeriodStartDate")
		public ZonedDateTime getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstCompoundingPeriodEndDate")
		public ZonedDateTime getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPeriodEndDate")
		public ZonedDateTime getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("stubPeriodType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubPeriodType")
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getRelativeEffectiveDate()).ifPresent(builder::setRelativeEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getRelativeTerminationDate()).ifPresent(builder::setRelativeTerminationDate);
			ofNullable(getCalculationPeriodDatesAdjustments()).ifPresent(builder::setCalculationPeriodDatesAdjustments);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getFirstRegularPeriodStartDate()).ifPresent(builder::setFirstRegularPeriodStartDate);
			ofNullable(getFirstCompoundingPeriodEndDate()).ifPresent(builder::setFirstCompoundingPeriodEndDate);
			ofNullable(getLastRegularPeriodEndDate()).ifPresent(builder::setLastRegularPeriodEndDate);
			ofNullable(getStubPeriodType()).ifPresent(builder::setStubPeriodType);
			ofNullable(getCalculationPeriodFrequency()).ifPresent(builder::setCalculationPeriodFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(relativeEffectiveDate, _that.getRelativeEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(relativeTerminationDate, _that.getRelativeTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (relativeEffectiveDate != null ? relativeEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (relativeTerminationDate != null ? relativeTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDates {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"relativeEffectiveDate=" + this.relativeEffectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"relativeTerminationDate=" + this.relativeTerminationDate + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationPeriodDates  ***********************/
	class CalculationPeriodDatesBuilderImpl implements CalculationPeriodDates.CalculationPeriodDatesBuilder {
	
		protected String id;
		protected AdjustableDate.AdjustableDateBuilder effectiveDate;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder relativeEffectiveDate;
		protected AdjustableDate.AdjustableDateBuilder terminationDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeTerminationDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder calculationPeriodDatesAdjustments;
		protected AdjustableDate.AdjustableDateBuilder firstPeriodStartDate;
		protected ZonedDateTime firstRegularPeriodStartDate;
		protected ZonedDateTime firstCompoundingPeriodEndDate;
		protected ZonedDateTime lastRegularPeriodEndDate;
		protected StubPeriodTypeEnum stubPeriodType;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency;
		
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
		public AdjustableDate.AdjustableDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateEffectiveDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeEffectiveDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getRelativeEffectiveDate() {
			return relativeEffectiveDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateRelativeEffectiveDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (relativeEffectiveDate!=null) {
				result = relativeEffectiveDate;
			}
			else {
				result = relativeEffectiveDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableDate.AdjustableDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateTerminationDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeTerminationDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeTerminationDate() {
			return relativeTerminationDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeTerminationDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeTerminationDate!=null) {
				result = relativeTerminationDate;
			}
			else {
				result = relativeTerminationDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (calculationPeriodDatesAdjustments!=null) {
				result = calculationPeriodDatesAdjustments;
			}
			else {
				result = calculationPeriodDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPeriodStartDate")
		public AdjustableDate.AdjustableDateBuilder getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateFirstPeriodStartDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (firstPeriodStartDate!=null) {
				result = firstPeriodStartDate;
			}
			else {
				result = firstPeriodStartDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstRegularPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstRegularPeriodStartDate")
		public ZonedDateTime getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstCompoundingPeriodEndDate")
		public ZonedDateTime getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPeriodEndDate")
		public ZonedDateTime getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("stubPeriodType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubPeriodType")
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodFrequency")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (calculationPeriodFrequency!=null) {
				result = calculationPeriodFrequency;
			}
			else {
				result = calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeEffectiveDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeEffectiveDate(AdjustedRelativeDateOffset _relativeEffectiveDate) {
			this.relativeEffectiveDate = _relativeEffectiveDate == null ? null : _relativeEffectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeTerminationDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setRelativeTerminationDate(RelativeDateOffset _relativeTerminationDate) {
			this.relativeTerminationDate = _relativeTerminationDate == null ? null : _relativeTerminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodDatesAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodDatesAdjustments")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments _calculationPeriodDatesAdjustments) {
			this.calculationPeriodDatesAdjustments = _calculationPeriodDatesAdjustments == null ? null : _calculationPeriodDatesAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstPeriodStartDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableDate _firstPeriodStartDate) {
			this.firstPeriodStartDate = _firstPeriodStartDate == null ? null : _firstPeriodStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstRegularPeriodStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstRegularPeriodStartDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(ZonedDateTime _firstRegularPeriodStartDate) {
			this.firstRegularPeriodStartDate = _firstRegularPeriodStartDate == null ? null : _firstRegularPeriodStartDate;
			return this;
		}
		
		@RosettaAttribute("firstCompoundingPeriodEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstCompoundingPeriodEndDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(ZonedDateTime _firstCompoundingPeriodEndDate) {
			this.firstCompoundingPeriodEndDate = _firstCompoundingPeriodEndDate == null ? null : _firstCompoundingPeriodEndDate;
			return this;
		}
		
		@RosettaAttribute("lastRegularPeriodEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastRegularPeriodEndDate")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(ZonedDateTime _lastRegularPeriodEndDate) {
			this.lastRegularPeriodEndDate = _lastRegularPeriodEndDate == null ? null : _lastRegularPeriodEndDate;
			return this;
		}
		
		@RosettaAttribute("stubPeriodType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stubPeriodType")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum _stubPeriodType) {
			this.stubPeriodType = _stubPeriodType == null ? null : _stubPeriodType;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodFrequency")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency _calculationPeriodFrequency) {
			this.calculationPeriodFrequency = _calculationPeriodFrequency == null ? null : _calculationPeriodFrequency.toBuilder();
			return this;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return new CalculationPeriodDates.CalculationPeriodDatesImpl(this);
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (relativeEffectiveDate!=null && !relativeEffectiveDate.prune().hasData()) relativeEffectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (relativeTerminationDate!=null && !relativeTerminationDate.prune().hasData()) relativeTerminationDate = null;
			if (calculationPeriodDatesAdjustments!=null && !calculationPeriodDatesAdjustments.prune().hasData()) calculationPeriodDatesAdjustments = null;
			if (firstPeriodStartDate!=null && !firstPeriodStartDate.prune().hasData()) firstPeriodStartDate = null;
			if (calculationPeriodFrequency!=null && !calculationPeriodFrequency.prune().hasData()) calculationPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getRelativeEffectiveDate()!=null && getRelativeEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getRelativeTerminationDate()!=null && getRelativeTerminationDate().hasData()) return true;
			if (getCalculationPeriodDatesAdjustments()!=null && getCalculationPeriodDatesAdjustments().hasData()) return true;
			if (getFirstPeriodStartDate()!=null && getFirstPeriodStartDate().hasData()) return true;
			if (getFirstRegularPeriodStartDate()!=null) return true;
			if (getFirstCompoundingPeriodEndDate()!=null) return true;
			if (getLastRegularPeriodEndDate()!=null) return true;
			if (getStubPeriodType()!=null) return true;
			if (getCalculationPeriodFrequency()!=null && getCalculationPeriodFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder o = (CalculationPeriodDates.CalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getRelativeEffectiveDate(), o.getRelativeEffectiveDate(), this::setRelativeEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getRelativeTerminationDate(), o.getRelativeTerminationDate(), this::setRelativeTerminationDate);
			merger.mergeRosetta(getCalculationPeriodDatesAdjustments(), o.getCalculationPeriodDatesAdjustments(), this::setCalculationPeriodDatesAdjustments);
			merger.mergeRosetta(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::setFirstPeriodStartDate);
			merger.mergeRosetta(getCalculationPeriodFrequency(), o.getCalculationPeriodFrequency(), this::setCalculationPeriodFrequency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getFirstRegularPeriodStartDate(), o.getFirstRegularPeriodStartDate(), this::setFirstRegularPeriodStartDate);
			merger.mergeBasic(getFirstCompoundingPeriodEndDate(), o.getFirstCompoundingPeriodEndDate(), this::setFirstCompoundingPeriodEndDate);
			merger.mergeBasic(getLastRegularPeriodEndDate(), o.getLastRegularPeriodEndDate(), this::setLastRegularPeriodEndDate);
			merger.mergeBasic(getStubPeriodType(), o.getStubPeriodType(), this::setStubPeriodType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(relativeEffectiveDate, _that.getRelativeEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(relativeTerminationDate, _that.getRelativeTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (relativeEffectiveDate != null ? relativeEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (relativeTerminationDate != null ? relativeTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDatesBuilder {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"relativeEffectiveDate=" + this.relativeEffectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"relativeTerminationDate=" + this.relativeTerminationDate + ", " +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency +
			'}';
		}
	}
}
