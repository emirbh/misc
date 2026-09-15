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
import fpml.consolidated.fpmlenum.CalculationMethodEnum;
import fpml.consolidated.shared.meta.CalculationParametersMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a rate that is calculated based on a number of observations of an underlying rate that are averaged or compounded using a specified method. These are sometimes called modular calculated rates. These are described in the 2021 ISDA Definitions in Section 7.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a rate that is calculated based on a number of observations of an underlying rate that are averaged or compounded using a specified method. These are sometimes called modular calculated rates. These are described in the 2021 ISDA Definitions in Section 7.
 *
 */
@RosettaDataType(value="CalculationParameters", builder=CalculationParameters.CalculationParametersBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationParameters", model="fpml", builder=CalculationParameters.CalculationParametersBuilderImpl.class, version="2.1.1")
public interface CalculationParameters extends RosettaModelObject {

	CalculationParametersMeta metaData = new CalculationParametersMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the type of calculation, e.g. whether the calculation is a compounding or an averaging calculation. This element distinguishes between the applicable subsections of Section 7 (7.3, 7.4, and 7.7). If the calculationMethod is Componding or Averaging, this implies that a daily compounded calculation will be done, i.e. that the underlying rate will be observed eacy applicalbe business day during the observation period and then compounded or averaged. If it is CompoundedIndex, this means that the rate administrator is doing the compounding each day and publishing the resulting index value. In this case the calculation agent is responsible for observing the index and the start and at the end of the observation period, and then backing out the implied rate by following the formula in section 7.7. (This formula divides the index value at the end by the index value at the beginning, subtracts 1, and then scales the resulting value based on the year fraction to annualize the rate.) In other words, for CompoundedIndex the observation frequency is effectively 1T, where for Compounding and Averaging, it is 1D.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the type of calculation, e.g. whether the calculation is a compounding or an averaging calculation. This element distinguishes between the applicable subsections of Section 7 (7.3, 7.4, and 7.7). If the calculationMethod is Componding or Averaging, this implies that a daily compounded calculation will be done, i.e. that the underlying rate will be observed eacy applicalbe business day during the observation period and then compounded or averaged. If it is CompoundedIndex, this means that the rate administrator is doing the compounding each day and publishing the resulting index value. In this case the calculation agent is responsible for observing the index and the start and at the end of the observation period, and then backing out the implied rate by following the formula in section 7.7. (This formula divides the index value at the end by the index value at the beginning, subtracts 1, and then scales the resulting value based on the year fraction to annualize the rate.) In other words, for CompoundedIndex the observation frequency is effectively 1T, where for Compounding and Averaging, it is 1D.
	 *
	 */
	CalculationMethodEnum getCalculationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the applicable business days to be used for this calculation. If omitted, the business days should be defaulted from the FRO Matrix, as represented in the FRO metadata. Failing that, it should be defaulted from the default business center for the relevant currency. See the ISDA 2021 Definitions Section 7.2.1.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the applicable business days to be used for this calculation. If omitted, the business days should be defaulted from the FRO Matrix, as represented in the FRO metadata. Failing that, it should be defaulted from the default business center for the relevant currency. See the ISDA 2021 Definitions Section 7.2.1.
	 *
	 */
	BusinessCentersOrReference getApplicableBusinessDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies that lookback calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.2 and 7.4.2. This should not be used when the calculationMethod is CompoundedIndex.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies that lookback calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.2 and 7.4.2. This should not be used when the calculationMethod is CompoundedIndex.
	 *
	 */
	ObservationOffset getLookback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies that observation shift calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.3 and 7.4.3 and 7.7.3.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies that observation shift calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.3 and 7.4.3 and 7.7.3.
	 *
	 */
	ObservationShiftParameters getObservationShift();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies that lockout calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.4 and 7.4.4. This should not be used when the calculationMethod is CompoundedIndex.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies that lockout calculation is in effect, and supplies parameters needed to support that. See the ISDA 2021 Definitions Section 7.3.4 and 7.4.4. This should not be used when the calculationMethod is CompoundedIndex.
	 *
	 */
	ObservationOffset getLockout();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A maximum rate for an rate observation; optionally applied for daily averaged rates. These are described in the 2021 ISDA Definitions in Section 7.2.4
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A maximum rate for an rate observation; optionally applied for daily averaged rates. These are described in the 2021 ISDA Definitions in Section 7.2.4
	 *
	 */
	BigDecimal getObservationCapRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A minimum rate for an rate observation; optionally applied for daily averaged rates. These are described in the 2021 ISDA Definitions in Section 7.2.3
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A minimum rate for an rate observation; optionally applied for daily averaged rates. These are described in the 2021 ISDA Definitions in Section 7.2.3
	 *
	 */
	BigDecimal getObservationFloorRate();

	/*********************** Build Methods  ***********************/
	CalculationParameters build();
	
	CalculationParameters.CalculationParametersBuilder toBuilder();
	
	static CalculationParameters.CalculationParametersBuilder builder() {
		return new CalculationParameters.CalculationParametersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationParameters> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationParameters> getType() {
		return CalculationParameters.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationMethod"), CalculationMethodEnum.class, getCalculationMethod(), this);
		processRosetta(path.newSubPath("applicableBusinessDays"), processor, BusinessCentersOrReference.class, getApplicableBusinessDays());
		processRosetta(path.newSubPath("lookback"), processor, ObservationOffset.class, getLookback());
		processRosetta(path.newSubPath("observationShift"), processor, ObservationShiftParameters.class, getObservationShift());
		processRosetta(path.newSubPath("lockout"), processor, ObservationOffset.class, getLockout());
		processor.processBasic(path.newSubPath("observationCapRate"), BigDecimal.class, getObservationCapRate(), this);
		processor.processBasic(path.newSubPath("observationFloorRate"), BigDecimal.class, getObservationFloorRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationParametersBuilder extends CalculationParameters, RosettaModelObjectBuilder {
		BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getOrCreateApplicableBusinessDays();
		@Override
		BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getApplicableBusinessDays();
		ObservationOffset.ObservationOffsetBuilder getOrCreateLookback();
		@Override
		ObservationOffset.ObservationOffsetBuilder getLookback();
		ObservationShiftParameters.ObservationShiftParametersBuilder getOrCreateObservationShift();
		@Override
		ObservationShiftParameters.ObservationShiftParametersBuilder getObservationShift();
		ObservationOffset.ObservationOffsetBuilder getOrCreateLockout();
		@Override
		ObservationOffset.ObservationOffsetBuilder getLockout();
		CalculationParameters.CalculationParametersBuilder setCalculationMethod(CalculationMethodEnum calculationMethod);
		CalculationParameters.CalculationParametersBuilder setApplicableBusinessDays(BusinessCentersOrReference applicableBusinessDays);
		CalculationParameters.CalculationParametersBuilder setLookback(ObservationOffset lookback);
		CalculationParameters.CalculationParametersBuilder setObservationShift(ObservationShiftParameters observationShift);
		CalculationParameters.CalculationParametersBuilder setLockout(ObservationOffset lockout);
		CalculationParameters.CalculationParametersBuilder setObservationCapRate(BigDecimal observationCapRate);
		CalculationParameters.CalculationParametersBuilder setObservationFloorRate(BigDecimal observationFloorRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("calculationMethod"), CalculationMethodEnum.class, getCalculationMethod(), this);
			processRosetta(path.newSubPath("applicableBusinessDays"), processor, BusinessCentersOrReference.BusinessCentersOrReferenceBuilder.class, getApplicableBusinessDays());
			processRosetta(path.newSubPath("lookback"), processor, ObservationOffset.ObservationOffsetBuilder.class, getLookback());
			processRosetta(path.newSubPath("observationShift"), processor, ObservationShiftParameters.ObservationShiftParametersBuilder.class, getObservationShift());
			processRosetta(path.newSubPath("lockout"), processor, ObservationOffset.ObservationOffsetBuilder.class, getLockout());
			processor.processBasic(path.newSubPath("observationCapRate"), BigDecimal.class, getObservationCapRate(), this);
			processor.processBasic(path.newSubPath("observationFloorRate"), BigDecimal.class, getObservationFloorRate(), this);
		}
		

		CalculationParameters.CalculationParametersBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationParameters  ***********************/
	class CalculationParametersImpl implements CalculationParameters {
		private final CalculationMethodEnum calculationMethod;
		private final BusinessCentersOrReference applicableBusinessDays;
		private final ObservationOffset lookback;
		private final ObservationShiftParameters observationShift;
		private final ObservationOffset lockout;
		private final BigDecimal observationCapRate;
		private final BigDecimal observationFloorRate;
		
		protected CalculationParametersImpl(CalculationParameters.CalculationParametersBuilder builder) {
			this.calculationMethod = builder.getCalculationMethod();
			this.applicableBusinessDays = ofNullable(builder.getApplicableBusinessDays()).map(f->f.build()).orElse(null);
			this.lookback = ofNullable(builder.getLookback()).map(f->f.build()).orElse(null);
			this.observationShift = ofNullable(builder.getObservationShift()).map(f->f.build()).orElse(null);
			this.lockout = ofNullable(builder.getLockout()).map(f->f.build()).orElse(null);
			this.observationCapRate = builder.getObservationCapRate();
			this.observationFloorRate = builder.getObservationFloorRate();
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationMethod")
		public CalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableBusinessDays")
		public BusinessCentersOrReference getApplicableBusinessDays() {
			return applicableBusinessDays;
		}
		
		@Override
		@RosettaAttribute("lookback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lookback")
		public ObservationOffset getLookback() {
			return lookback;
		}
		
		@Override
		@RosettaAttribute("observationShift")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationShift")
		public ObservationShiftParameters getObservationShift() {
			return observationShift;
		}
		
		@Override
		@RosettaAttribute("lockout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lockout")
		public ObservationOffset getLockout() {
			return lockout;
		}
		
		@Override
		@RosettaAttribute("observationCapRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationCapRate")
		public BigDecimal getObservationCapRate() {
			return observationCapRate;
		}
		
		@Override
		@RosettaAttribute("observationFloorRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationFloorRate")
		public BigDecimal getObservationFloorRate() {
			return observationFloorRate;
		}
		
		@Override
		public CalculationParameters build() {
			return this;
		}
		
		@Override
		public CalculationParameters.CalculationParametersBuilder toBuilder() {
			CalculationParameters.CalculationParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationParameters.CalculationParametersBuilder builder) {
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getApplicableBusinessDays()).ifPresent(builder::setApplicableBusinessDays);
			ofNullable(getLookback()).ifPresent(builder::setLookback);
			ofNullable(getObservationShift()).ifPresent(builder::setObservationShift);
			ofNullable(getLockout()).ifPresent(builder::setLockout);
			ofNullable(getObservationCapRate()).ifPresent(builder::setObservationCapRate);
			ofNullable(getObservationFloorRate()).ifPresent(builder::setObservationFloorRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationParameters _that = getType().cast(o);
		
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(applicableBusinessDays, _that.getApplicableBusinessDays())) return false;
			if (!Objects.equals(lookback, _that.getLookback())) return false;
			if (!Objects.equals(observationShift, _that.getObservationShift())) return false;
			if (!Objects.equals(lockout, _that.getLockout())) return false;
			if (!Objects.equals(observationCapRate, _that.getObservationCapRate())) return false;
			if (!Objects.equals(observationFloorRate, _that.getObservationFloorRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableBusinessDays != null ? applicableBusinessDays.hashCode() : 0);
			_result = 31 * _result + (lookback != null ? lookback.hashCode() : 0);
			_result = 31 * _result + (observationShift != null ? observationShift.hashCode() : 0);
			_result = 31 * _result + (lockout != null ? lockout.hashCode() : 0);
			_result = 31 * _result + (observationCapRate != null ? observationCapRate.hashCode() : 0);
			_result = 31 * _result + (observationFloorRate != null ? observationFloorRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationParameters {" +
				"calculationMethod=" + this.calculationMethod + ", " +
				"applicableBusinessDays=" + this.applicableBusinessDays + ", " +
				"lookback=" + this.lookback + ", " +
				"observationShift=" + this.observationShift + ", " +
				"lockout=" + this.lockout + ", " +
				"observationCapRate=" + this.observationCapRate + ", " +
				"observationFloorRate=" + this.observationFloorRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationParameters  ***********************/
	class CalculationParametersBuilderImpl implements CalculationParameters.CalculationParametersBuilder {
	
		protected CalculationMethodEnum calculationMethod;
		protected BusinessCentersOrReference.BusinessCentersOrReferenceBuilder applicableBusinessDays;
		protected ObservationOffset.ObservationOffsetBuilder lookback;
		protected ObservationShiftParameters.ObservationShiftParametersBuilder observationShift;
		protected ObservationOffset.ObservationOffsetBuilder lockout;
		protected BigDecimal observationCapRate;
		protected BigDecimal observationFloorRate;
		
		@Override
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationMethod")
		public CalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableBusinessDays")
		public BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getApplicableBusinessDays() {
			return applicableBusinessDays;
		}
		
		@Override
		public BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getOrCreateApplicableBusinessDays() {
			BusinessCentersOrReference.BusinessCentersOrReferenceBuilder result;
			if (applicableBusinessDays!=null) {
				result = applicableBusinessDays;
			}
			else {
				result = applicableBusinessDays = BusinessCentersOrReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lookback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lookback")
		public ObservationOffset.ObservationOffsetBuilder getLookback() {
			return lookback;
		}
		
		@Override
		public ObservationOffset.ObservationOffsetBuilder getOrCreateLookback() {
			ObservationOffset.ObservationOffsetBuilder result;
			if (lookback!=null) {
				result = lookback;
			}
			else {
				result = lookback = ObservationOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationShift")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationShift")
		public ObservationShiftParameters.ObservationShiftParametersBuilder getObservationShift() {
			return observationShift;
		}
		
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder getOrCreateObservationShift() {
			ObservationShiftParameters.ObservationShiftParametersBuilder result;
			if (observationShift!=null) {
				result = observationShift;
			}
			else {
				result = observationShift = ObservationShiftParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lockout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lockout")
		public ObservationOffset.ObservationOffsetBuilder getLockout() {
			return lockout;
		}
		
		@Override
		public ObservationOffset.ObservationOffsetBuilder getOrCreateLockout() {
			ObservationOffset.ObservationOffsetBuilder result;
			if (lockout!=null) {
				result = lockout;
			}
			else {
				result = lockout = ObservationOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationCapRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationCapRate")
		public BigDecimal getObservationCapRate() {
			return observationCapRate;
		}
		
		@Override
		@RosettaAttribute("observationFloorRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationFloorRate")
		public BigDecimal getObservationFloorRate() {
			return observationFloorRate;
		}
		
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationMethod")
		@Override
		public CalculationParameters.CalculationParametersBuilder setCalculationMethod(CalculationMethodEnum _calculationMethod) {
			this.calculationMethod = _calculationMethod == null ? null : _calculationMethod;
			return this;
		}
		
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableBusinessDays")
		@Override
		public CalculationParameters.CalculationParametersBuilder setApplicableBusinessDays(BusinessCentersOrReference _applicableBusinessDays) {
			this.applicableBusinessDays = _applicableBusinessDays == null ? null : _applicableBusinessDays.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lookback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lookback")
		@Override
		public CalculationParameters.CalculationParametersBuilder setLookback(ObservationOffset _lookback) {
			this.lookback = _lookback == null ? null : _lookback.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationShift")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationShift")
		@Override
		public CalculationParameters.CalculationParametersBuilder setObservationShift(ObservationShiftParameters _observationShift) {
			this.observationShift = _observationShift == null ? null : _observationShift.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lockout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lockout")
		@Override
		public CalculationParameters.CalculationParametersBuilder setLockout(ObservationOffset _lockout) {
			this.lockout = _lockout == null ? null : _lockout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationCapRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationCapRate")
		@Override
		public CalculationParameters.CalculationParametersBuilder setObservationCapRate(BigDecimal _observationCapRate) {
			this.observationCapRate = _observationCapRate == null ? null : _observationCapRate;
			return this;
		}
		
		@RosettaAttribute("observationFloorRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationFloorRate")
		@Override
		public CalculationParameters.CalculationParametersBuilder setObservationFloorRate(BigDecimal _observationFloorRate) {
			this.observationFloorRate = _observationFloorRate == null ? null : _observationFloorRate;
			return this;
		}
		
		@Override
		public CalculationParameters build() {
			return new CalculationParameters.CalculationParametersImpl(this);
		}
		
		@Override
		public CalculationParameters.CalculationParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationParameters.CalculationParametersBuilder prune() {
			if (applicableBusinessDays!=null && !applicableBusinessDays.prune().hasData()) applicableBusinessDays = null;
			if (lookback!=null && !lookback.prune().hasData()) lookback = null;
			if (observationShift!=null && !observationShift.prune().hasData()) observationShift = null;
			if (lockout!=null && !lockout.prune().hasData()) lockout = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationMethod()!=null) return true;
			if (getApplicableBusinessDays()!=null && getApplicableBusinessDays().hasData()) return true;
			if (getLookback()!=null && getLookback().hasData()) return true;
			if (getObservationShift()!=null && getObservationShift().hasData()) return true;
			if (getLockout()!=null && getLockout().hasData()) return true;
			if (getObservationCapRate()!=null) return true;
			if (getObservationFloorRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationParameters.CalculationParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationParameters.CalculationParametersBuilder o = (CalculationParameters.CalculationParametersBuilder) other;
			
			merger.mergeRosetta(getApplicableBusinessDays(), o.getApplicableBusinessDays(), this::setApplicableBusinessDays);
			merger.mergeRosetta(getLookback(), o.getLookback(), this::setLookback);
			merger.mergeRosetta(getObservationShift(), o.getObservationShift(), this::setObservationShift);
			merger.mergeRosetta(getLockout(), o.getLockout(), this::setLockout);
			
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			merger.mergeBasic(getObservationCapRate(), o.getObservationCapRate(), this::setObservationCapRate);
			merger.mergeBasic(getObservationFloorRate(), o.getObservationFloorRate(), this::setObservationFloorRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationParameters _that = getType().cast(o);
		
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(applicableBusinessDays, _that.getApplicableBusinessDays())) return false;
			if (!Objects.equals(lookback, _that.getLookback())) return false;
			if (!Objects.equals(observationShift, _that.getObservationShift())) return false;
			if (!Objects.equals(lockout, _that.getLockout())) return false;
			if (!Objects.equals(observationCapRate, _that.getObservationCapRate())) return false;
			if (!Objects.equals(observationFloorRate, _that.getObservationFloorRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableBusinessDays != null ? applicableBusinessDays.hashCode() : 0);
			_result = 31 * _result + (lookback != null ? lookback.hashCode() : 0);
			_result = 31 * _result + (observationShift != null ? observationShift.hashCode() : 0);
			_result = 31 * _result + (lockout != null ? lockout.hashCode() : 0);
			_result = 31 * _result + (observationCapRate != null ? observationCapRate.hashCode() : 0);
			_result = 31 * _result + (observationFloorRate != null ? observationFloorRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationParametersBuilder {" +
				"calculationMethod=" + this.calculationMethod + ", " +
				"applicableBusinessDays=" + this.applicableBusinessDays + ", " +
				"lookback=" + this.lookback + ", " +
				"observationShift=" + this.observationShift + ", " +
				"lockout=" + this.lockout + ", " +
				"observationCapRate=" + this.observationCapRate + ", " +
				"observationFloorRate=" + this.observationFloorRate +
			'}';
		}
	}
}
