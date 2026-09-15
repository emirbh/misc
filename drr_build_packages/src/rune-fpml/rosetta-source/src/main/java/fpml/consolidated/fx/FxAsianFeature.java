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
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.meta.FxAsianFeatureMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Descibes the averaging period properties for an asian option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Descibes the averaging period properties for an asian option.
 *
 */
@RosettaDataType(value="FxAsianFeature", builder=FxAsianFeature.FxAsianFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAsianFeature", model="fpml", builder=FxAsianFeature.FxAsianFeatureBuilderImpl.class, version="2.1.1")
public interface FxAsianFeature extends RosettaModelObject {

	FxAsianFeatureMeta metaData = new FxAsianFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getPrimaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getSecondaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 *
	 */
	BusinessCenterTime getFixingTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Parametric schedule of rate observations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Parametric schedule of rate observations.
	 *
	 */
	FxAverageRateObservationSchedule getObservationSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One or more specific rate observation dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One or more specific rate observation dates.
	 *
	 */
	List<? extends FxAverageRateObservation> getRateObservation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which observed rate values are quoted, in terms of the option put/call currencies. In the absence of this element, rate observations are assumed to be quoted as per the option strikeQuoteBasis.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which observed rate values are quoted, in terms of the option put/call currencies. In the absence of this element, rate observations are assumed to be quoted as per the option strikeQuoteBasis.
	 *
	 */
	StrikeQuoteBasisEnum getRateObservationQuoteBasis();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The description of the mathematical computation for how the payout is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The description of the mathematical computation for how the payout is computed.
	 *
	 */
	String getPayoutFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 */
	Integer getPrecision();

	/*********************** Build Methods  ***********************/
	FxAsianFeature build();
	
	FxAsianFeature.FxAsianFeatureBuilder toBuilder();
	
	static FxAsianFeature.FxAsianFeatureBuilder builder() {
		return new FxAsianFeature.FxAsianFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAsianFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAsianFeature> getType() {
		return FxAsianFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("observationSchedule"), processor, FxAverageRateObservationSchedule.class, getObservationSchedule());
		processRosetta(path.newSubPath("rateObservation"), processor, FxAverageRateObservation.class, getRateObservation());
		processor.processBasic(path.newSubPath("rateObservationQuoteBasis"), StrikeQuoteBasisEnum.class, getRateObservationQuoteBasis(), this);
		processor.processBasic(path.newSubPath("payoutFormula"), String.class, getPayoutFormula(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAsianFeatureBuilder extends FxAsianFeature, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getOrCreateObservationSchedule();
		@Override
		FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getObservationSchedule();
		FxAverageRateObservation.FxAverageRateObservationBuilder getOrCreateRateObservation(int index);
		@Override
		List<? extends FxAverageRateObservation.FxAverageRateObservationBuilder> getRateObservation();
		FxAsianFeature.FxAsianFeatureBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		FxAsianFeature.FxAsianFeatureBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		FxAsianFeature.FxAsianFeatureBuilder setFixingTime(BusinessCenterTime fixingTime);
		FxAsianFeature.FxAsianFeatureBuilder setObservationSchedule(FxAverageRateObservationSchedule observationSchedule);
		FxAsianFeature.FxAsianFeatureBuilder addRateObservation(FxAverageRateObservation rateObservation);
		FxAsianFeature.FxAsianFeatureBuilder addRateObservation(FxAverageRateObservation rateObservation, int idx);
		FxAsianFeature.FxAsianFeatureBuilder addRateObservation(List<? extends FxAverageRateObservation> rateObservation);
		FxAsianFeature.FxAsianFeatureBuilder setRateObservation(List<? extends FxAverageRateObservation> rateObservation);
		FxAsianFeature.FxAsianFeatureBuilder setRateObservationQuoteBasis(StrikeQuoteBasisEnum rateObservationQuoteBasis);
		FxAsianFeature.FxAsianFeatureBuilder setPayoutFormula(String payoutFormula);
		FxAsianFeature.FxAsianFeatureBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("observationSchedule"), processor, FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder.class, getObservationSchedule());
			processRosetta(path.newSubPath("rateObservation"), processor, FxAverageRateObservation.FxAverageRateObservationBuilder.class, getRateObservation());
			processor.processBasic(path.newSubPath("rateObservationQuoteBasis"), StrikeQuoteBasisEnum.class, getRateObservationQuoteBasis(), this);
			processor.processBasic(path.newSubPath("payoutFormula"), String.class, getPayoutFormula(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		FxAsianFeature.FxAsianFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FxAsianFeature  ***********************/
	class FxAsianFeatureImpl implements FxAsianFeature {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final BusinessCenterTime fixingTime;
		private final FxAverageRateObservationSchedule observationSchedule;
		private final List<? extends FxAverageRateObservation> rateObservation;
		private final StrikeQuoteBasisEnum rateObservationQuoteBasis;
		private final String payoutFormula;
		private final Integer precision;
		
		protected FxAsianFeatureImpl(FxAsianFeature.FxAsianFeatureBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.observationSchedule = ofNullable(builder.getObservationSchedule()).map(f->f.build()).orElse(null);
			this.rateObservation = ofNullable(builder.getRateObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateObservationQuoteBasis = builder.getRateObservationQuoteBasis();
			this.payoutFormula = builder.getPayoutFormula();
			this.precision = builder.getPrecision();
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("observationSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationSchedule")
		public FxAverageRateObservationSchedule getObservationSchedule() {
			return observationSchedule;
		}
		
		@Override
		@RosettaAttribute("rateObservation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateObservation")
		public List<? extends FxAverageRateObservation> getRateObservation() {
			return rateObservation;
		}
		
		@Override
		@RosettaAttribute("rateObservationQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateObservationQuoteBasis")
		public StrikeQuoteBasisEnum getRateObservationQuoteBasis() {
			return rateObservationQuoteBasis;
		}
		
		@Override
		@RosettaAttribute("payoutFormula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoutFormula")
		public String getPayoutFormula() {
			return payoutFormula;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public FxAsianFeature build() {
			return this;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder toBuilder() {
			FxAsianFeature.FxAsianFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAsianFeature.FxAsianFeatureBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getObservationSchedule()).ifPresent(builder::setObservationSchedule);
			ofNullable(getRateObservation()).ifPresent(builder::setRateObservation);
			ofNullable(getRateObservationQuoteBasis()).ifPresent(builder::setRateObservationQuoteBasis);
			ofNullable(getPayoutFormula()).ifPresent(builder::setPayoutFormula);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeature _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(rateObservationQuoteBasis, _that.getRateObservationQuoteBasis())) return false;
			if (!Objects.equals(payoutFormula, _that.getPayoutFormula())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (rateObservationQuoteBasis != null ? rateObservationQuoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payoutFormula != null ? payoutFormula.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeature {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"observationSchedule=" + this.observationSchedule + ", " +
				"rateObservation=" + this.rateObservation + ", " +
				"rateObservationQuoteBasis=" + this.rateObservationQuoteBasis + ", " +
				"payoutFormula=" + this.payoutFormula + ", " +
				"precision=" + this.precision +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAsianFeature  ***********************/
	class FxAsianFeatureBuilderImpl implements FxAsianFeature.FxAsianFeatureBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder observationSchedule;
		protected List<FxAverageRateObservation.FxAverageRateObservationBuilder> rateObservation = new ArrayList<>();
		protected StrikeQuoteBasisEnum rateObservationQuoteBasis;
		protected String payoutFormula;
		protected Integer precision;
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationSchedule")
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getObservationSchedule() {
			return observationSchedule;
		}
		
		@Override
		public FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder getOrCreateObservationSchedule() {
			FxAverageRateObservationSchedule.FxAverageRateObservationScheduleBuilder result;
			if (observationSchedule!=null) {
				result = observationSchedule;
			}
			else {
				result = observationSchedule = FxAverageRateObservationSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateObservation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateObservation")
		public List<? extends FxAverageRateObservation.FxAverageRateObservationBuilder> getRateObservation() {
			return rateObservation;
		}
		
		@Override
		public FxAverageRateObservation.FxAverageRateObservationBuilder getOrCreateRateObservation(int index) {
			if (rateObservation==null) {
				this.rateObservation = new ArrayList<>();
			}
			return getIndex(rateObservation, index, () -> {
						FxAverageRateObservation.FxAverageRateObservationBuilder newRateObservation = FxAverageRateObservation.builder();
						return newRateObservation;
					});
		}
		
		@Override
		@RosettaAttribute("rateObservationQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateObservationQuoteBasis")
		public StrikeQuoteBasisEnum getRateObservationQuoteBasis() {
			return rateObservationQuoteBasis;
		}
		
		@Override
		@RosettaAttribute("payoutFormula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoutFormula")
		public String getPayoutFormula() {
			return payoutFormula;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryRateSource")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setPrimaryRateSource(InformationSource _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryRateSource")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setSecondaryRateSource(InformationSource _secondaryRateSource) {
			this.secondaryRateSource = _secondaryRateSource == null ? null : _secondaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationSchedule")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setObservationSchedule(FxAverageRateObservationSchedule _observationSchedule) {
			this.observationSchedule = _observationSchedule == null ? null : _observationSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateObservation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rateObservation")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder addRateObservation(FxAverageRateObservation _rateObservation) {
			if (_rateObservation != null) {
				this.rateObservation.add(_rateObservation.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder addRateObservation(FxAverageRateObservation _rateObservation, int idx) {
			getIndex(this.rateObservation, idx, () -> _rateObservation.toBuilder());
			return this;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder addRateObservation(List<? extends FxAverageRateObservation> rateObservations) {
			if (rateObservations != null) {
				for (final FxAverageRateObservation toAdd : rateObservations) {
					this.rateObservation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rateObservation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rateObservation")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setRateObservation(List<? extends FxAverageRateObservation> rateObservations) {
			if (rateObservations == null) {
				this.rateObservation = new ArrayList<>();
			} else {
				this.rateObservation = rateObservations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rateObservationQuoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateObservationQuoteBasis")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setRateObservationQuoteBasis(StrikeQuoteBasisEnum _rateObservationQuoteBasis) {
			this.rateObservationQuoteBasis = _rateObservationQuoteBasis == null ? null : _rateObservationQuoteBasis;
			return this;
		}
		
		@RosettaAttribute("payoutFormula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoutFormula")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setPayoutFormula(String _payoutFormula) {
			this.payoutFormula = _payoutFormula == null ? null : _payoutFormula;
			return this;
		}
		
		@RosettaAttribute("precision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("precision")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder setPrecision(Integer _precision) {
			this.precision = _precision == null ? null : _precision;
			return this;
		}
		
		@Override
		public FxAsianFeature build() {
			return new FxAsianFeature.FxAsianFeatureImpl(this);
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (observationSchedule!=null && !observationSchedule.prune().hasData()) observationSchedule = null;
			rateObservation = rateObservation.stream().filter(b->b!=null).<FxAverageRateObservation.FxAverageRateObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getObservationSchedule()!=null && getObservationSchedule().hasData()) return true;
			if (getRateObservation()!=null && getRateObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateObservationQuoteBasis()!=null) return true;
			if (getPayoutFormula()!=null) return true;
			if (getPrecision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAsianFeature.FxAsianFeatureBuilder o = (FxAsianFeature.FxAsianFeatureBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getObservationSchedule(), o.getObservationSchedule(), this::setObservationSchedule);
			merger.mergeRosetta(getRateObservation(), o.getRateObservation(), this::getOrCreateRateObservation);
			
			merger.mergeBasic(getRateObservationQuoteBasis(), o.getRateObservationQuoteBasis(), this::setRateObservationQuoteBasis);
			merger.mergeBasic(getPayoutFormula(), o.getPayoutFormula(), this::setPayoutFormula);
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeature _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(rateObservationQuoteBasis, _that.getRateObservationQuoteBasis())) return false;
			if (!Objects.equals(payoutFormula, _that.getPayoutFormula())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (rateObservationQuoteBasis != null ? rateObservationQuoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payoutFormula != null ? payoutFormula.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeatureBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"observationSchedule=" + this.observationSchedule + ", " +
				"rateObservation=" + this.rateObservation + ", " +
				"rateObservationQuoteBasis=" + this.rateObservationQuoteBasis + ", " +
				"payoutFormula=" + this.payoutFormula + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
}
